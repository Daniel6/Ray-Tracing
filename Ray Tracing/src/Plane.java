
public class Plane extends Entity {
	Vector point;
	Vector normal;
	Material material;
	Scene scene;
	
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public Plane(Vector c, Vector n, Material material) {
		point = c;
		normal = n.norm();
		this.material = material;
	}
	public Intersection findIntersect(Ray r) {
		double d = r.getDirection().dot(normal);
		if (d == 0) {
			return null;
		}
		double t = (point.dot(normal) - normal.dot(r.getOrigin())) / d;
		if (t > getTol()) {
			Vector i = r.position(t);
			Vector n = d > 0 ? normal.negate() : normal;
			return new Intersection(t, r, i, n, material);
		}
		return null;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Vector getPoint() {
		return point;
	}
	public void setPoint(Vector point) {
		this.point = point;
	}
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
	
}
