public abstract class Entity {
	public class Disc {

	}
	private Scene scene;
	public Scene getScene() {
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}
	public abstract Intersection findIntersect(Ray r) throws Exception;
	public double getTol() { return 1.0e-8; }
}
