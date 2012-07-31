import java.util.ArrayList;
import java.util.List;

public class Scene {
	private List<Entity> objects;
	private List<Light> lights;

	public Scene() {
		objects = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
	}

	public Intersection getClosest(Ray r) throws Exception {
		Intersection closest = null;
		for (Entity o : objects) {
			Intersection p = o.findIntersect(r);
			if (p == null) {
				continue;
			}
			if (closest == null) {
				closest = p;
				continue;
			}
			if (p.getDistance() < closest.getDistance()) {
				closest = p;
			}
		}
		return closest;
	}

	public Color reflection(Intersection i) throws Exception {
		Color reflect = i.getMaterial().getReflective();
		if (reflect.isBlack()) {
			return Color.BLACK;
		}
		Vector origin = i.getIntersection();
		Vector direction = i.getRay().getDirection().reflect(i.getNormal());
		Ray r = new Ray(origin, direction);
		return getColor(getClosest(r)).mult(reflect);
	}

	public Color getColor(Intersection i) throws Exception {
		if (i == null) {
			return Color.WHITE;
		}
		Color rtn = Color.BLACK;
		Material material = i.getMaterial();
		Roughness roughness = material.getRoughness();
		if (roughness != null) {
			i = roughness.perturb(i);
		}
		for (Light l : lights) {
			rtn = rtn.add(l.intensity(i));
		}
		rtn = rtn.add(reflection(i));
		return rtn;
	}

	public void add(Entity i) {
		i.setScene(this);
		objects.add(i);
	}

	public void add(Light light) {
		lights.add(light);
		light.setScene(this);
	}
}
