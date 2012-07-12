public class Camera {

	private Vector location;
	private Vector lookat;
	private double zoom;
	private int cols;
	private int rows;
	private double width;
	private double height;
	private int antialias;

	public Camera(Vector location, Vector lookat, int rows, int cols) {
		this.location = location;
		this.lookat = lookat;
		zoom = 1.0;
		this.cols = cols;
		this.rows = rows;
		width = 1.0 * cols / rows;
		height = 1.0;
	}

	public RGBImage process(Scene scene) {
		RGBImage image = new RGBImage(cols, rows);
		if (antialias == 0) {
			for (int row = 0; row < rows; row++) {
				for (int col = 0; col < cols; col++) {
					Ray ray = getRay(row, col);
					Color color = scene.getColor(scene.getClosest(ray));
					image.setPixel(col, row, color);
				}
			}
			return image;
		}
		int n = antialias;
		int nr = n * rows + 1;
		int nc = n * cols + 1;
		double fr = 1.0 / n;
		double fc = 1.0 / n;
		double w = 1.0 / (n * n);
		RGBImage ximage = new RGBImage(nc, nr);
		for (int row = 0; row < nr; row++) {
			for (int col = 0; col < nc; col++) {
				Ray ray = getRay(fr * row - 0.5, fc * col - 0.5);
				Color color = scene.getColor(scene.getClosest(ray));
				ximage.setPixel(col, row, color);
			}
		}
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
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

	private Ray getRay(double row, double col) {
		Vector aim = lookat.sub(location).norm();
		Vector horizontal = aim.cross(new Vector(0,0,1)).norm();
		if (horizontal.length() == 0)
			horizontal = new Vector(1,0,0);
		Vector vertical = horizontal.cross(aim).norm();
		Vector center = location.add(aim.mult(zoom));
		double dx = width / cols;
		double dy = height / rows;
		double x = -0.5 * width + (col + 0.5) * dx;
		double y = +0.5 * height - (row + 0.5) * dy;
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

	public int getCols() {
		return cols;
	}

	public void setCols(int cols) {
		this.cols = cols;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}

	public int getAntialias() {
		return antialias;
	}

	public void setAntialias(int antialias) {
		this.antialias = antialias;
	}

}
