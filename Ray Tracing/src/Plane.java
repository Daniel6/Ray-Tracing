
public class Plane implements Entity {
	Vector point;
	Vector normal;
	Color color;
	public Plane(Vector c, Vector n, Color color) {
		point = c;
		normal = n;
		this.color = color;
	}
	public Intersection findIntersect(Ray r) {
		double d = r.getDirection().dot(normal);
		if (d == 0) {
			return null;
		}
		double t = (point.dot(normal) - normal.dot(r.getOrigin())) / d;
		if(t < 0) {
			return null;
		}
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
