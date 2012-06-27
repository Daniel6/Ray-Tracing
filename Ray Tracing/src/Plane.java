
public class Plane implements Intersectable {
	Vector point;
	Vector normal;
	public Plane(Vector c, Vector n) {
		point = c;
		normal = n;
	}
	public Intersection findIntersect(Ray r) {
		double d = r.getDirection().dot(normal);
		if (d == 0) {
			return null;
		}
		double t = (point.dot(normal) - normal.dot(r.getOrigin())) / d;
		Vector i = r.getOrigin().add(r.getDirection().mult(t));
		return new Intersection(t, i, normal);
	}
	public Vector getPoint() {
		return point;
	}
	public void setPoint(Vector point) {
		this.point = point;
	}
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
}
