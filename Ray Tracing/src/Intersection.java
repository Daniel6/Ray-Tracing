
public class Intersection {
	private Vector intersection;
	private Vector normal;
	private double distance;
	private Material material;
	private Ray ray;
	public Intersection(double t, Ray r, Vector i, Vector n, Material m) {
		intersection = i;
		normal = n;
		distance = t;
		material = m;
		ray = r;
	}
	public Intersection(Intersection i) {
		intersection = i.intersection;
		normal = i.normal;
		distance = i.distance;
		material = i.material;
		ray = i.ray;
	}
	public Ray getRay() {
		return ray;
	}
	public void setRay(Ray ray) {
		this.ray = ray;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public Vector getIntersection() {
		return intersection;
	}
	public void setIntersection(Vector intersection) {
		this.intersection = intersection;
	}
	public Vector getNormal() {
		return normal;
	}
	public void setNormal(Vector normal) {
		this.normal = normal;
	}
}
