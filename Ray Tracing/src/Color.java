
public class Color {
	private double R;
	private double G;
	private double B;
	public Color(double iR, double iG, double iB) {
		R = iR;
		G = iG;
		B = iB;
	}
	public double getR() {
		return R;
	}
	public double getG() {
		return G;
	}
	public double getB() {
		return B;
	}
	public String toString() {
		return "Color (" + R + "," + G + "," + B + ")";
	}
	public Color mult(double d) {
		return new Color(R * d, G * d, B * d);
	}
	public Color mult(Color c) {
		return new Color(R * c.R, G * c.G, B * c.B);
	}
}
