import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		PointLight light = new PointLight(new Vector(-.2,0,0), new Color(1,1,1));
		Vector viewpoint = new Vector(-50, 0, 0);
		ArrayList<Intersectable> objects = new ArrayList<Intersectable>();
		objects.add(new Sphere(new Vector(0,0,0), .1, new Color(1,0,0)));
		objects.add(new Sphere(new Vector(0,0,.3), .1, new Color(1,1,0)));
		objects.add(new Sphere(new Vector(0,0,-.3), .1, new Color(0,1,1)));
		objects.add(new Plane(new Vector(0,0,0), new Vector(-1,0,0), new Color(1,1,1)));
		RGBImage i = new RGBImage(1000, 1000);
		for (int row = 0; row < 1000; row++) {
			for (int col = 0; col < 1000; col++) {
				Vector pixel = new Vector(-2, -.5 + row * .001, -.5 + col * .001);
				Ray ray = new Ray(viewpoint, pixel.sub(viewpoint));
				Intersection closest = null;
				Color c = new Color(0,0,0);
				for (Intersectable o : objects) {
					Intersection p = o.findIntersect(ray);
					if (p == null) {
						continue;
					}
					if (closest == null) {
						closest = p;
					}
					if (p.getDistance() < closest.getDistance()) {
						closest = p;
					}
				}
				if (closest != null) {
					c = closest.getColor();
					Color lc = light.intensity(closest);
					c = c.mult(lc);
				}
				int blue = (int) (c.getB() * 255);
				int green = (int) (c.getG() * 255);
				int red = (int) (c.getR() * 255);
				int rgb = blue | (green << 8) | (red << 16);
				i.setPixel(row, col, rgb);
				
			}
		}
		i.displayImage();
	}
}
