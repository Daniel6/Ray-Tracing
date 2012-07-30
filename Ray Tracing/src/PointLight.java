
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
	
	@Override
	public Scene getScene() {
		return scene;
	}
	@Override
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	@Override
	public Color intensity(Intersection i) throws Exception {
		Color diffuse = i.getMaterial().getDiffuse();
		double specular = i.getMaterial().getSpecularExponent();
		if (diffuse.isBlack() && specular <= 0) {
			return Color.BLACK;
		}
		Vector a = location.sub(i.getIntersection());
		Vector n = i.getNormal().norm();
		double d = a.norm().dot(n);
		if (d < 0) {
			return Color.BLACK;
		}
		Ray r = new Ray(i.getIntersection(), a);
		Intersection j = scene.getClosest(r);
		if (j != null && j.getDistance() < a.length()) {
			return Color.BLACK;
		}
		Color rtn = color.mult(diffuse).mult(d);
		Vector b = i.getRay().getDirection().reflect(n).norm();
		double c = a.norm().dot(b);
		rtn = rtn.add(Color.WHITE.mult(Math.pow(c, specular)));
		return rtn;
	}
}
