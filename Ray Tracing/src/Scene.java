import java.util.ArrayList;
import java.util.List;

public class Scene {
	private List<Entity> objects;
	private List<Light> lights;

	public Scene() {
		objects = new ArrayList<Entity>();
		lights = new ArrayList<Light>();
	}

	public Color getClosest(Ray r) {
		Intersection closest = null;
		Color c = new Color(0, 0, 0);
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
		if (closest != null) {
			c = closest.getColor();
			Color lc = new Color(0,0,0);
			for (Light l : lights) {
				lc = lc.add(l.intensity(closest));
			}
			c = c.mult(lc);
		}
		return c;
	}
	public void add(Entity i) {
		objects.add(i);
	}
	public void add(Light light) {
		lights.add(light);
	}
}
