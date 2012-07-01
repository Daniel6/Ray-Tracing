import java.util.ArrayList;
import java.util.List;

public class Scene {
	private List<Entity> objects;
	private List<Light> lights;

	public Scene() {
		objects = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
	}

	public Intersection getClosest(Ray r) {
		Intersection closest = null;
		for (Entity o : objects) {
			Intersection p = o.findIntersect(r);
			if (p == null) {
				continue;
			}
			if (p.getDistance() < .0001) {
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

	public Color reflection(Intersection i) {
		Vector origin = i.getIntersection();
		Vector direction = i.getRay().getDirection().reflect(i.getNormal());
		Ray r = new Ray(origin, direction);
		return getColor(getClosest(r));
	}

	public Color getColor(Intersection i) {
		if (i == null) {
			return new Color(0, 0, 0);
		}
		Color diffuse = i.getMaterial().getDiffuse();
		Color reflective = i.getMaterial().getReflective();
		Color lc = new Color(0, 0, 0);
		for (Light l : lights) {
			lc = lc.add(l.intensity(i));
		}
		diffuse = diffuse.mult(lc.clip());
		reflective = reflection(i).mult(reflective);
		return diffuse.add(reflective);
	}

	public void add(Entity i) {
		objects.add(i);

	}

	public void add(Light light) {
		lights.add(light);
		light.setScene(this);
	}
}
