
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
	public void addNoise(double scale, double mag) {
		double dx = Noise.noise(scale * intersection.getX(), scale * intersection.getY(), scale * intersection.getZ());
		double dy = Noise.noise(scale * intersection.getY(), scale * intersection.getZ(), scale * intersection.getX());
		double dz = Noise.noise(scale * intersection.getZ(), scale * intersection.getX(), scale * intersection.getY());
		Vector p = new Vector(dx, dy, dz);
		normal = normal.add(p.mult(mag)).norm();
	}

}
