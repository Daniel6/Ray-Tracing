
public abstract class Entity {
	public abstract Scene getScene();
	public abstract void setScene(Scene s);
	public abstract Intersection findIntersect(Ray r) throws Exception;
	public double getTol() { return 1.0e-8; }
}
