
public interface Light {
	public Scene getScene();
	public void setScene(Scene s);
	public Color intensity(Intersection i) throws Exception;
}
