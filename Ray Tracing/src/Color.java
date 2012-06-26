
public class Color {
	double R;
	double G;
	double B;
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
}
