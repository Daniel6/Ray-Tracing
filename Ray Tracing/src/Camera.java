
public class Camera {

	private Vector location;
	private Vector lookat;
	private double zoom;
	private int cols;
	private int rows;
	private double width;
	private double height;

	public Camera(Vector location, Vector lookat, int pixels) {
		this.location = location;
		this.lookat = lookat;
		zoom = 1.0;
		cols = pixels;
		rows = pixels;
		width = 1.0;
		height = 1.0;
	}
	
	public RGBImage process(Scene scene) {
		RGBImage image = new RGBImage(cols, rows);
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				Ray ray = getRay(row, col);
				Color color = scene.getColor(scene.getClosest(ray));
				image.setPixel(col, row, color);
			}
		}
		return image;
	}
	
	private Ray getRay(int row, int col) {
		Vector aim = lookat.sub(location).norm();
		Vector horizontal = aim.cross(new Vector(0,0,1)).norm();
		if (horizontal.length() == 0)
			horizontal = new Vector(1,0,0);
		Vector vertical = horizontal.cross(aim).norm();
		Vector center = location.add(aim.mult(zoom));
		double dx = width / (cols - 1);
		double dy = height / (rows - 1);
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

}
