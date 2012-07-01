
public class Sphere implements Entity {
	Vector center;
	double radius;
	Material material;
	Scene scene;

	public Scene getScene() {
		return scene;
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Sphere(Vector c, double r, Material m) {
		center = c;
		radius = r;
		material = m;
	}

	public Intersection findIntersect(Ray r) {
		double a = r.getDirection().dot(r.getDirection());
		double b = 2 * r.getDirection().dot(r.getOrigin().sub(center));
		double c = r.getOrigin().sub(center).dot(r.getOrigin().sub(center))
				- (radius * radius);
		double f = Math.pow(b, 2) - 4 * a * c;
		if (f < 0) {
			return null;
		}
		double t = -1;
		double t1 = (-b + Math.sqrt(f)) / (2 * a);
		double t2 = (-b - Math.sqrt(f)) / (2 * a);
		if (t1 > 0 && t2 > 0 && t1 < t2) {
			t = t1;
		}
		if (t1 > 0 && t2 > 0 && t2 < t1) {
			t = t2;
		}
		if (t1 > 0 && t2 > 0 && t1 == t2) {
			t = t1;
		}
		if (t1 > 0 && t2 < 0) {
			t = t1;
		}
		if (t1 < 0 && t2 > 0) {
			t = t2;
		}
		if (t < 0) {
			return null;
		}
		Vector i = r.getOrigin().add(r.getDirection().mult(t));
		Vector n = i.sub(center);
		return new Intersection(t, i, n, material.getDiffuse());
	}

	public Vector getCenter() {
		return center;
	}

	public void setCenter(Vector center) {
		this.center = center;
	}

	public double getRadius() {
		return radius;
	}

	public void setRadius(double radius) {
		this.radius = radius;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

}
