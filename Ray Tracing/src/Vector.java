
public class Vector {
	double x;
	double y;
	double z;
	public Vector(double X, double Y, double Z) {
		x = X;
		y = Y;
		z = Z;
	}
	public final double getX() {
		return x;
	}
	public final double getY() {
		return y;
	}
	public final double getZ() {
		return z;
	}
	public void setX(double X) {
		this.x = X;
	}
	public void setY(double Y) {
		this.y = Y;
	}
	public void setZ(double Z) {
		this.z = Z;
	}
	public Vector add(Vector v) {
		return new Vector(x + v.x, y + v.y, z + v.z);
	}
	public Vector sub(Vector v) {
		return new Vector(x - v.x, y - v.y, z - v.z);
	}
	public double length() {
		return Math.sqrt(Math.pow(x,2.0)+Math.pow(y,2.0)+Math.pow(z,2.0));
	}
	public String toString() {
		return "vector(" + x + "," + y + "," + z + ")";
	}
	public double dot(Vector v) {
		return (x * v.x) + (y * v.y) + (z * v.z);
	}
	public Vector cross(Vector v) {
		return new Vector((y * v.z) - (v.y * z), (z * v.x) - (v.z * x), (x * v.y) - (v.x * y));
	}
	public Vector mult(double d) {
		return new Vector(x * d, y * d, z * d);
	}
	public Vector div(double d) {
		return new Vector(x / d, y / d, z / d);
	}
	public Vector norm() {
		double l = this.length();
		return l == 0 ? this : this.div(l);
	}
}
