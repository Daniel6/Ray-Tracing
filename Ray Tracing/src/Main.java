import java.util.ArrayList;

public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(-50, 0, 0);
		ArrayList<Intersectable> objects = new ArrayList<Intersectable>();
		objects.add(new Sphere(new Vector(0,0,0), .1, new Color(1,1,1)));
		objects.add(new Sphere(new Vector(0, 0, .1), .1, new Color(0,0,0)));
		//objects.add(new Plane(new Vector(0,0,0), new Vector(0,1,0)));
		RGBImage i = new RGBImage(100, 100);
		for (int row = 0; row < 100; row++) {
			for (int col = 0; col < 100; col++) {
				Vector pixel = new Vector(-2, -.5 + row * .01, -.5 + col * .01);
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
					c = new Color(1,1,1);
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
