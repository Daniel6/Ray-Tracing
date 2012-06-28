
public class Plane implements Intersectable {
	Vector point;
	Vector normal;
	Color color;
	public Plane(Vector c, Vector n, Color color) {
		point = c;
		normal = n;
		this.color = color;
	}
	public Intersection findIntersect(Ray r) {
		if (r.getDirection().dot(normal) == 0) {
			return null;
		}
		double t = (point.dot(normal) - normal.dot(r.getOrigin())) / r.getDirection().dot(normal);
		Vector i = r.getOrigin().add(r.getDirection().mult(t));
		return new Intersection(t, i, normal, color);
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
