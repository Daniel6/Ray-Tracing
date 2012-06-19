import java.lang.Math.*;

public class Vector {
	double k_X;
	double k_Y;
	double k_Z;
	public Vector(double X, double Y, double Z) {
		k_X = X;
		k_Y = Y;
		k_Z = Z;
	}
	public double getX() {
		return k_X;
	}
	public double getY() {
		return k_Y;
	}
	public double getZ() {
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
	public double length(Vector v) {
		return sqrt(pow(v.k_X,2.0)+pow(v.k_Y,2.0)+pow(v.k_Z,2.0));
	}
}
