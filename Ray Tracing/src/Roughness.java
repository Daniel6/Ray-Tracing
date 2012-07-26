
public class Roughness {
	double scale;
	double mag;
	public Roughness(double scale, double mag) {
		super();
		this.scale = scale;
		this.mag = mag;
	}
	public Intersection perturb(Intersection intersection) {
		Vector i = intersection.getIntersection();
		Vector n = intersection.getNormal();
		double dx = Noise.noise(scale * i.getX(), scale * i.getY(), scale * i.getZ());
		double dy = Noise.noise(scale * i.getY(), scale * i.getZ(), scale * i.getX());
		double dz = Noise.noise(scale * i.getZ(), scale * i.getX(), scale * i.getY());
		Vector p = new Vector(dx, dy, dz);
		n = n.add(p.mult(mag)).norm();
		Intersection rtn = new Intersection(intersection);
		rtn.setNormal(n);
		return rtn;
	}
	public double getScale() {
		return scale;
	}
	public void setScale(double scale) {
		this.scale = scale;
	}
	public double getMag() {
		return mag;
	}
	public void setMag(double mag) {
		this.mag = mag;
	}
}
