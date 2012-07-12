import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Camera {

	private Vector location;
	private Vector lookat;
	private double zoom;
	private int nCol;
	private int nRow;
	private double width;
	private double height;
	private int antialias;

	public Camera(Vector location, Vector lookat, int rows, int cols) {
		this.location = location;
		this.lookat = lookat;
		zoom = 1.0;
		this.nCol = cols;
		this.nRow = rows;
		width = 1.0 * cols / rows;
		height = 1.0;
	}

	public class PixelEval implements Callable<PixelEval> {
		private Scene scene;
		private RGBImage image;
		private int rs, re;
		private int cs, ce;
		private double dx, dy;
		public PixelEval(Scene scene, RGBImage image, int rs, int re, int cs, int ce, double dx, double dy) {
			super();
			this.scene = scene;
			this.image = image;
			this.rs = rs;
			this.re = re;
			this.cs = cs;
			this.ce = ce;
			this.dx = dx;
			this.dy = dy;
		}
		@Override
		public PixelEval call() throws Exception {
			for (int row = rs; row < re; row++) {
				for (int col = cs; col < ce; col++) {
					Ray ray = getRay(row, col, dx, dy);
					Color color = scene.getColor(scene.getClosest(ray));
					image.setPixel(col, row, color);
				}
			}
			return this;
		}
	}

	public RGBImage process(Scene scene, int nthread) throws InterruptedException {
		RGBImage image = new RGBImage(nCol, nRow);
		if (antialias == 0) {
			double dx = width / nCol;
			double dy = height / nRow;
			ArrayList<PixelEval> pixelEvals = new ArrayList<PixelEval>(nRow * nCol);
			for (int row = 0; row < nRow; row += 4) {
				pixelEvals.add(new PixelEval(scene, image, row, Math.min(nRow,  row + 4), 0, nCol, dx, dy));
			}
			ExecutorService pool = Executors.newFixedThreadPool(nthread);
			pool.invokeAll(pixelEvals);
			return image;
		}
		int n = antialias;
		int nr = n * nRow + 1;
		int nc = n * nCol + 1;
		double dx = width / (n * nCol);
		double dy = 1.0 / (n * nRow);
		double w = 1.0 / (n * n);
		RGBImage ximage = new RGBImage(nc, nr);
		ArrayList<PixelEval> pixelEvals = new ArrayList<PixelEval>(nRow * nCol);
		for (int row = 0; row < nr; row++) {
			pixelEvals.add(new PixelEval(scene, ximage, row, row + 1, 0, nc, dx, dy));
		}
		ExecutorService pool = Executors.newFixedThreadPool(nthread);
		pool.invokeAll(pixelEvals);
		for (int row = 0; row < nRow; row++) {
			for (int col = 0; col < nCol; col++) {
				int c0 = n * col;
				int r0 = n * row;
				Color color = new Color(0, 0, 0);
				for (int r = 0; r <= n; r++) {
					for (int c = 0; c <= n; c++) {
						Color x = ximage.getPixel(c0 + c, r0 + r);
						double wr = (r == 0 || r == n) ? 0.5 : 1.0;
						double wc = (c == 0 || c == n) ? 0.5 : 1.0;
						double wx = w * wr * wc;
						color = color.add(x.mult(wx));
					}
				}
				image.setPixel(col, row, color);
			}
		}
		return image;
	}

	private Ray getRay(double row, double col, double dx, double dy) {
		Vector aim = lookat.sub(location).norm();
		Vector horizontal = aim.cross(new Vector(0,0,1)).norm();
		if (horizontal.length() == 0)
			horizontal = new Vector(1,0,0);
		Vector vertical = horizontal.cross(aim).norm();
		Vector center = location.add(aim.mult(zoom));
		double x = -0.5 * width + col * dx;
		double y = +0.5 * height - row * dy;
		Vector pixel = center.add(horizontal.mult(x)).add(vertical.mult(y));
		Ray ray = new Ray(location, pixel.sub(location));
		return ray;
	}

	public Vector getLocation() {
		return location;
	}

	public void setLocation(Vector location) {
		this.location = location;
	}

	public Vector getLookat() {
		return lookat;
	}

	public void setLookat(Vector lookat) {
		this.lookat = lookat;
	}

	public double getZoom() {
		return zoom;
	}

	public void setZoom(double zoom) {
		this.zoom = zoom;
	}

	public int getnCol() {
		return nCol;
	}

	public void setnCol(int nCol) {
		this.nCol = nCol;
	}

	public int getnRow() {
		return nRow;
	}

	public void setnRow(int nRow) {
		this.nRow = nRow;
	}

	public int getAntialias() {
		return antialias;
	}

	public void setAntialias(int antialias) {
		this.antialias = antialias;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

}
