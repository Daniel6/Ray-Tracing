
public class Test {
	public static void main(String[] args) {
		Ray r = new Ray(new Vector(0, -2, 0), new Vector(0, 1, 0));
		Cylinder c = new Cylinder(new Vector(0, 0, 0), new Vector(0, 0, 1), 1.0, Material.plastic(Color.WHITE));
		c.findIntersect(r);
	}
}
