
public class Cylinder extends Entity {
	Vector p1, p2;
	double R;
	private Material material;
	private Scene scene;
	public Cylinder(Vector p1, Vector p2, double r, Material material) {
		super();
		this.p1 = p1;
		this.p2 = p2;
		this.R = r;
		this.material = material;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	@Override
	public Intersection findIntersect(Ray r) {
		Vector o = r.getOrigin();
		Vector d = r.getDirection();
		Vector local_z = p2.sub(p1).norm();
		Vector local_x = d.cross(local_z).norm();
		Vector local_y = local_z.cross(local_x).norm();
		Vector w = o.sub(p1);
		Vector o_local = new Vector(w.dot(local_x), w.dot(local_y), w.dot(local_z));
		Vector d_local = new Vector(d.dot(local_x), d.dot(local_y), d.dot(local_z));
		double a = d_local.getY() * d_local.getY();
		double b = 2 * d_local.getY() * o_local.getY();
		double c = o_local.getY() * o_local.getY() + o_local.getX() * o_local.getX() - R * R;
		if (a == 0) {
			return null;
		}
		double e = b * b - 4 * a * c;
		if (e < 0) {
			return null;
		}
		e = Math.sqrt(e);
		double t1 = (-b - e) / (2 * a);
		double t2 = (-b + e) / (2 * a);
		if (t1 > getTol()) {
			Vector i = r.position(t1);
			double f = i.sub(p1).dot(local_z);
			if (f > 0 && f < p2.sub(p1).length()) {
				Vector q = p1.add(local_z.mult(f));
				Vector n = i.sub(q).norm();
				return new Intersection(t1, r, i, n, material);
			}
		}
		if (t2 > getTol()) {
			Vector i = r.position(t2);
			double f = i.sub(p1).dot(local_z);
			if (f > 0 && f < p2.sub(p1).length()) {
				Vector q = p1.add(local_z.mult(f));
				Vector n = q.sub(i).norm();
				return new Intersection(t2, r, i, n, material);
			}
		}
		return null;
	}
}
