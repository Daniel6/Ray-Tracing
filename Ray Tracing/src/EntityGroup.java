import java.util.ArrayList;
import java.util.List;


public class EntityGroup extends Entity {
	List<Entity> entities;
	EntityGroup() {
		entities = new ArrayList<Entity>();
	}
	public void add(Entity e) {
		entities.add(e);
	}
	@Override
	public Intersection findIntersect(Ray r) throws Exception {
		Intersection closest = null;
		for (Entity o : entities) {
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
}
