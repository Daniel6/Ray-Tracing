
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(-50, 0, 0);
		Scene scene = new Scene();
		scene.add(new Sphere(new Vector(0,0,0), .1, Color.MAGENTA));
		scene.add(new Sphere(new Vector(0,0,.3), .1, Color.YELLOW));
		scene.add(new Sphere(new Vector(0,0,-.3), .1, Color.YELLOW));
		scene.add(new Plane(new Vector(0,0,0), new Vector(-1,0,0), Color.WHITE));
		scene.add(new PointLight(new Vector(-.2,.2,0), Color.GRAY));
		scene.add(new PointLight(new Vector(-.2,-.2,0), Color.GRAY));
		
		Color color = new Color(0,0,0);
		RGBImage i = new RGBImage(1000, 1000);
		for (int row = 0; row < 1000; row++) {
			for (int col = 0; col < 1000; col++) {
				Vector pixel = new Vector(-2, -.5 + row * .001, -.5 + col * .001);
				Ray ray = new Ray(viewpoint, pixel.sub(viewpoint));
				color = scene.getClosest(ray);
				int blue = (int) (color.getB() * 255);
				int green = (int) (color.getG() * 255);
				int red = (int) (color.getR() * 255);
				int rgb = blue | (green << 8) | (red << 16);
				i.setPixel(row, col, rgb);
			}
		}
		i.displayImage();
	}
}
