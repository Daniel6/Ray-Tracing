
public class CappedCylinder extends EntityGroup {
	CappedCylinder(Vector p1, Vector p2, double r, Material m) {
		super();
		add(new Cylinder(p1, p2, r, m));
		add(new Disc(p1, p1.sub(p2).norm(), r, m));
		add(new Disc(p2, p2.sub(p1).norm(), r, m));
	}
}
