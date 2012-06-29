
public class PointLight implements Light {
	Vector location;
	Color color;
	Scene scene;
	public PointLight(Vector l, Color c) {
		location = l;
		color = c;
		scene = null;
	}
	public Vector getLocation() {
		return location;
	}
	public void setLocation(Vector location) {
		this.location = location;
	}
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public Color intensity(Intersection i) {
		Vector a = location.sub(i.getIntersection()).norm();
		Vector b = i.getNormal().norm();
		double d = a.dot(b);
		if (d < 0) {
			d = 0;
		}
		Ray r = new Ray(i.getIntersection(), location.sub(i.getIntersection()));
		Intersection j = scene.getClosest(r);
		if (j != null) {
			if (/*j.getDistance() < location.sub(i.getIntersection()).length()*/  j.getDistance() > 0.0000001) {
				return Color.BLACK;
			}
		}
		return color.mult(d);
	}
}
