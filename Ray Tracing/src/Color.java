public class Color {
	private double R;
	private double G;
	private double B;
	public static final Color WHITE = new Color(1.0, 1.0, 1.0);
	public static final Color BLACK = new Color(0.0, 0.0, 0.0);
	public static final Color GRAY = new Color(0.5, 0.5, 0.5);
	public static final Color RED = new Color(1.0, 0.0, 0.0);
	public static final Color GREEN = new Color(0.0, 1.0, 0.0);
	public static final Color BLUE = new Color(0.0, 0.0, 1.0);
	public static final Color YELLOW = new Color(1.0, 1.0, 0.0);
	public static final Color CYAN = new Color(0.0, 1.0, 1.0);
	public static final Color MAGENTA = new Color(1.0, 0.0, 1.0);

	public Color(double iR, double iG, double iB) {
		R = iR < 0 ? 0 : iR > 1 ? 1 : iR;
		G = iG < 0 ? 0 : iG > 1 ? 1 : iG;
		B = iB < 0 ? 0 : iB > 1 ? 1 : iB;
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

	public Color add(Color c) {
		return new Color(R + c.R, G + c.G, B + c.B);
	}

	public Color sub(Color c) {
		return new Color(R - c.R, G - c.G, B - c.B);
	}
}
