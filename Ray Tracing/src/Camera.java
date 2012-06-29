public class Camera {

	private Vector location;
	private Vector aim;
	
	// Screen settings
	private long cols;
	private long rows;
	private Vector horizontal;
	private Vector vertical;
	private double distance;
	private double width;
	private double height;

	public Camera(Vector location, Vector aim) {
		this.location = location;
		this.aim = aim.norm();
		cols = 1000;
		rows = 1000;
		width = 1.0;
		height = 1.0;
		distance = 1.0;
		setup();
	}
	
	private void setup() {
		horizontal = aim.cross(new Vector(0,0,1)).norm();
		if (horizontal.length() == 0)
			horizontal = new Vector(1,0,0);
		vertical = horizontal.cross(aim).norm();
	}
	
	public Ray getRay(int row, int col) {
		double dx = width / (cols - 1);
		double dy = height / (cols - 1);
		double x = dx * (col - 0.5 * cols);
		double y = dy * (col - 0.5 * rows);
		Vector center = location.add(aim.mult(distance));
		Vector pixel = center.add(horizontal.mult(x)).add(vertical.mult(y));
		Ray ray = new Ray(location, pixel.sub(location));
		return ray;
	}

	public Vector getLocation() {
		return location;
	}

	public void setLocation(Vector location) {
		this.location = location;
		setup();
	}

	public Vector getAim() {
		return aim;
	}

	public void setAim(Vector aim) {
		this.aim = aim;
		setup();
	}

	public long getXpixels() {
		return cols;
	}

	public void setXpixels(long xpixels) {
		this.cols = xpixels;
		setup();
	}

	public long getYpixels() {
		return rows;
	}

	public void setYpixels(long ypixels) {
		this.rows = ypixels;
		setup();
	}

	public Vector getHorizontal() {
		return horizontal;
	}

	public void setHorizontal(Vector horizontal) {
		this.horizontal = horizontal;
		setup();
	}

	public Vector getVertical() {
		return vertical;
	}

	public void setVertical(Vector vertical) {
		this.vertical = vertical;
		setup();
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
		setup();
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
		setup();
	}

	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
		setup();
	}

}
