
public class Vector {
	double k_X;
	double k_Y;
	double k_Z;
	public Vector(double X, double Y, double Z) {
		k_X = X;
		k_Y = Y;
		k_Z = Z;
	}
	public final double getX() {
		return k_X;
	}
	public final double getY() {
		return k_Y;
	}
	public final double getZ() {
		return k_Z;
	}
	public void setX(double k_X) {
		this.k_X = k_X;
	}
	public void setY(double k_Y) {
		this.k_Y = k_Y;
	}
	public void setZ(double k_Z) {
		this.k_Z = k_Z;
	}
	public Vector add(Vector v) {
		return new Vector(k_X + v.k_X, k_Y + v.k_Y, k_Z + v.k_Z);
	}
	public Vector sub(Vector v) {
		return new Vector(k_X - v.k_X, k_Y - v.k_Y, k_Z - v.k_Z);
	}
	public double length() {
		return Math.sqrt(Math.pow(k_X,2.0)+Math.pow(k_Y,2.0)+Math.pow(k_Z,2.0));
	}
	public String toString() {
		return "vector(" + k_X + "," + k_Y + "," + k_Z + ")";
	}
	public double dot(Vector v) {
		return (k_X * v.k_X) + (k_Y * v.k_Y) + (k_Z * v.k_Z);
	}
	public Vector cross(Vector v) {
		return new Vector((k_Y * v.k_Z) - (v.k_Y * k_Z), (k_Z * v.k_X) - (v.k_Z * k_X), (k_X * v.k_Y) - (v.k_X * k_Y));
	}
	public Vector mult(double d) {
		return new Vector(k_X * d, k_Y * d, k_Z * d);
	}
	public Vector div(double d) {
		return new Vector(k_X / d, k_Y / d, k_Z / d);
	}
	public Vector norm() {
		double l = this.length();
		return l == 0 ? this : this.div(l);
	}
}
