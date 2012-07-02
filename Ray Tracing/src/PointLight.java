
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
			return Color.BLACK;
		}
		Ray r = new Ray(i.getIntersection(), a);
		Intersection j = scene.getClosest(r);
		if (j != null && j.getDistance() < location.sub(i.getIntersection()).length()) {
			return Color.BLACK;
		}
		return color.mult(d);
	}
	
}
