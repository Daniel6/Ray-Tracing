public class Disc extends Plane {
	private double radius;
	public Disc(Vector c, Vector n, double r, Material m) {
		super(c, n, m);
		radius = r;
	}
	@Override
	public Intersection findIntersect(Ray r) {
		Intersection i = super.findIntersect(r);
		if (i == null) {
			return null;
		}
		double d = i.getIntersection().sub(getPoint()).length();
		return d > radius ? null : i;
	}
}
