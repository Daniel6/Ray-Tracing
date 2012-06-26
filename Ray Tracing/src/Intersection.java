
public class Intersection {
	Vector intersection;
	Vector normal;
	double distance;
	public Intersection(double t, Vector i, Vector n) {
		intersection = i;
		normal = n;
		distance = t;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Vector getIntersection() {
		return intersection;
	}
	public void setIntersection(Vector intersection) {
		this.intersection = intersection;
	}
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
}
