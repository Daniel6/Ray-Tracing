
public interface Entity {
	public Scene getScene();
	public void setScene(Scene s);
	public Intersection findIntersect(Ray r);
}
