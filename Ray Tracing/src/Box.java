public class Box extends Entity {
	private Vector vmin;
	private Vector vmax;
	private Material material;
	private final Vector negX = new Vector(-1, 0, 0);
	private final Vector posX = new Vector(+1, 0, 0);
	private final Vector negY = new Vector( 0,-1, 0);
	private final Vector posY = new Vector( 0,+1, 0);
	private final Vector negZ = new Vector( 0, 0,-1);
	private final Vector posZ = new Vector( 0, 0,+1);
	public Box(Vector vmin, Vector vmax, Material material) {
		super();
		this.vmin = vmin;
		this.vmax = vmax;
		this.material = material;
	}
	public Material getMaterial() {
		return material;
	}
	public void setMaterial(Material material) {
		this.material = material;
	}
	double minPos(double x, double y) {
		return x < y ? x > 0 ? x : y : y > 0 ? y : x;
	}
	@Override
	public Intersection findIntersect(Ray r) {
		Vector o = r.getOrigin();
		Vector d = r.getDirection();
		double txmin = Double.MIN_VALUE;
		double txmax = Double.MAX_VALUE;
		if (d.getX() > 0) {
			txmin = (vmin.getX() - o.getX()) / d.getX();
			txmax = (vmax.getX() - o.getX()) / d.getX();
		}
		if (d.getX() < 0) {
			txmin = (vmax.getX() - o.getX()) / d.getX();
			txmax = (vmin.getX() - o.getX()) / d.getX();
		}
		double tymin = Double.MIN_VALUE;
		double tymax = Double.MAX_VALUE;
		if (d.getY() > 0) {
			tymin = (vmin.getY() - o.getY()) / d.getY();
			tymax = (vmax.getY() - o.getY()) / d.getY();
		}
		if (d.getY() < 0) {
			tymin = (vmax.getY() - o.getY()) / d.getY();
			tymax = (vmin.getY() - o.getY()) / d.getY();
		}
		double tzmin = Double.MIN_VALUE;
		double tzmax = Double.MAX_VALUE;
		if (d.getZ() > 0) {
			tzmin = (vmin.getZ() - o.getZ()) / d.getZ();
			tzmax = (vmax.getZ() - o.getZ()) / d.getZ();
		}
		if (d.getZ() < 0) {
			tzmin = (vmax.getZ() - o.getZ()) / d.getZ();
			tzmax = (vmin.getZ() - o.getZ()) / d.getZ();
		}
		double tmin = Math.max(txmin, Math.max(tymin,  tzmin));
		double tmax = Math.min(txmax, Math.min(tymax,  tzmax));
		if (tmin > tmax)
			return null;
		if (tmax <= getTol())
			return null;
		double t = tmin > getTol() ? tmin : tmax;
		Vector i = r.position(t);
		Vector n = null;
		Vector dmin = i.sub(vmin);
		Vector dmax = i.sub(vmax);
		double dx = Math.min(Math.abs(dmin.getX()), Math.abs(dmax.getX()));
		double dy = Math.min(Math.abs(dmin.getY()), Math.abs(dmax.getY()));
		double dz = Math.min(Math.abs(dmin.getZ()), Math.abs(dmax.getZ()));
		if (dx > getTol()) {
			n = d.getX() > 0 ? negX : posX;
		}
		if (dy > getTol()) {
			n = d.getY() > 0 ? negY : posY;
		}
		if (dz > getTol()) {
			n = d.getZ() > 0 ? negZ : posZ;
		}
		if (n == null)
			return null;
		return new Intersection(t, r, i, n, material);
	}
}
