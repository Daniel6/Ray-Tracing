public class ParallelPiped implements Entity {
	private Vector pmin, pmax;
	private Vector nx, ny, nz;
	private Material material;
	private Scene scene;
	public ParallelPiped(Vector pmin, Vector vx, Vector vy, Vector vz, Material material) {
		super();
		this.pmin = pmin;
		this.material = material;
		pmax = pmin.add(vx).add(vy).add(vz);
		nx = vy.cross(vz).norm();
		ny = vz.cross(vx).norm();
		nz = vx.cross(vy).norm();
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
		double txmin = Double.MIN_VALUE;
		double txmax = Double.MAX_VALUE;
		double dx = d.dot(nx);
		if (dx > 0) {
			txmin = pmin.sub(o).dot(nx) / dx;
			txmax = pmax.sub(o).dot(nx) / dx;
		}
		if (dx < 0) {
			txmin = pmax.sub(o).dot(nx) / dx;
			txmax = pmin.sub(o).dot(nx) / dx;
		}
		double tymin = Double.MIN_VALUE;
		double tymax = Double.MAX_VALUE;
		double dy = d.dot(ny);
		if (dy > 0) {
			tymin = pmin.sub(o).dot(ny) / dy;
			tymax = pmax.sub(o).dot(ny) / dy;
		}
		if (dy < 0) {
			tymin = pmax.sub(o).dot(ny) / dy;
			tymax = pmin.sub(o).dot(ny) / dy;
		}
		double tzmin = Double.MIN_VALUE;
		double tzmax = Double.MAX_VALUE;
		double dz = d.dot(nz);
		if (dz > 0) {
			tzmin = pmin.sub(o).dot(nz) / dz;
			tzmax = pmax.sub(o).dot(nz) / dz;
		}
		if (dz < 0) {
			tzmin = pmax.sub(o).dot(nz) / dz;
			tzmax = pmin.sub(o).dot(nz) / dz;
		}
		double tmin = Math.max(txmin, Math.max(tymin,  tzmin));
		double tmax = Math.min(txmax, Math.min(tymax,  tzmax));
		if (tmin > tmax)
			return null;
		if (tmax < 0)
			return null;
		double t = tmin > 0 ? tmin : tmax;
		Vector i = r.position(t);
		Vector n = null;
		double tol = 1.0e-8;
		Vector dmin = i.sub(pmin);
		Vector dmax = i.sub(pmax);
		double sx = Math.min(Math.abs(dmin.dot(nx)), Math.abs(dmax.dot(nx)));
		double sy = Math.min(Math.abs(dmin.dot(ny)), Math.abs(dmax.dot(ny)));
		double sz = Math.min(Math.abs(dmin.dot(nz)), Math.abs(dmax.dot(nz)));
		if (sx < tol) {
			n = dx > 0 ? nx.negate() : nx;
		}
		if (sy < tol) {
			n = dy > 0 ? ny.negate(): ny;
		}
		if (sz < tol) {
			n = dz > 0 ? nz.negate() : nz;
		}
		if (n == null)
			return null;
		return new Intersection(t, r, i, n, material);
	}
}
