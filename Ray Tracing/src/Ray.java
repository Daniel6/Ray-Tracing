
public class Ray {
	Vector origin;
	Vector direction;
	public Ray(Vector o, Vector d) {
		origin = o;
		direction = d.norm();
	}
	public String toString() {
		return "origin:" + origin + ":direction:" + direction;
	}
	public Vector getOrigin() {
		return origin;
	}
	public void setOrigin(Vector origin) {
		this.origin = origin;
	}
	public Vector getDirection() {
		return direction;
	}
	public void setDirection(Vector direction) {
		this.direction = direction;
	}
	public Vector position(double t) {
		return origin.add(direction.mult(t));
	}
}
