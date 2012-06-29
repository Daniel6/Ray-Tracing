public class Camera {

	private Vector location;
	private Vector lookat;
	
	// Screen settings
	private int cols;
	private int rows;
	private Vector horizontal;
	private Vector vertical;
	private double distance;
	private double width;
	private double height;

	public Camera(Vector location, Vector lookat, int pixels) {
		this.location = location;
		this.lookat = lookat;
		cols = pixels;
		rows = pixels;
		width = 1.0;
		height = 1.0;
		distance = 1.0;
	}
	
	public RGBImage process(Scene scene) {
		RGBImage image = new RGBImage(cols, rows);
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				Ray ray = getRay(row, col);
				Color color = scene.getClosest(ray);
				image.setPixel(col, row, color);
			}
		}
		return image;
	}
	
	public Ray getRay(int row, int col) {
		Vector aim = lookat.sub(location).norm();
		horizontal = aim.cross(new Vector(0,0,1)).norm();
		if (horizontal.length() == 0)
			horizontal = new Vector(1,0,0);
		vertical = horizontal.cross(aim).norm();
		Vector center = location.add(aim.mult(distance));
		double dx = width / (cols - 1);
		double dy = height / (rows - 1);
		double x = -0.5 * width + col * dx;
		double y = +0.5 * height - row * dy;
		Vector pixel = center.add(horizontal.mult(x)).add(vertical.mult(y));
		Ray ray = new Ray(location, pixel.sub(location));
		return ray;
	}

}
