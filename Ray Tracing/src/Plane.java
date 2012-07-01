
public class Plane implements Entity {
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
		normal = n;
		this.material = material;
	}
	public Intersection findIntersect(Ray r) {
		double d = r.getDirection().dot(normal);
		if (d == 0) {
			return null;
		}
		double t = (point.dot(normal) - normal.dot(r.getOrigin())) / d;
		if(t < 0) {
			return null;
		}
		Vector i = r.getOrigin().add(r.getDirection().mult(t));
		return new Intersection(t, r, i, normal, material);
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
