
public class Sphere extends Entity {
	Vector center;
	double radius;
	Material material;
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
		f = Math.sqrt(f);
		double t1 = (-b - f) / (2 * a);
		if (t1 > getTol()) {
			Vector i = r.position(t1);
			Vector n = i.sub(center).norm();	
			return new Intersection(t1, r, i, n, material);
		}
		double t2 = (-b + f) / (2 * a);
		if (t2 > getTol()) {
			Vector i = r.position(t2);
			Vector n = center.sub(i).norm();	
			return new Intersection(t2, r, i, n, material);
		}
		return null;
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
