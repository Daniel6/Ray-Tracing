
public class SmoothCylinder extends EntityGroup {
	SmoothCylinder(Vector p1, Vector p2, double r, Material m) {
		super();
		add(new Cylinder(p1, p2, r, m));
		add(new Sphere(p1, r, m));
		add(new Sphere(p2, r, m));
	}
}
