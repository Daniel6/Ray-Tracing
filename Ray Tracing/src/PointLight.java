
public class PointLight implements Light {
	Vector location;
	Color color;
	public PointLight(Vector l, Color c) {
		location = l;
		color = c;
	}
	public Color intensity(Intersection i) {
		Vector a = location.sub(i.getIntersection()).norm();
		Vector b = i.getNormal().norm();
		double d = a.dot(b);
		if (d < 0) {
			d = 0;
		}
		return color.mult(d);
	}
}
