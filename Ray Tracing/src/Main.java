
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(10,5,5);
		Vector lookat = new Vector(0, 0, 0);
		Camera camera = new Camera(viewpoint, lookat, 1000);
		camera.setZoom(2.0);
		Scene scene = new Scene();
		Color gray25 = new Color(0.25, 0.25, 0.25);
		Color gray75 = new Color(0.75, 0.75, 0.75);
		scene.add(new Sphere(new Vector(0, 0,0.4), 0.4, new Material(Color.BLACK, Color.WHITE, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(1, 0,0.2), 0.2, new Material(Color.RED, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0, 1,0.2), 0.2, new Material(Color.GREEN, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0,-1,0.2), 0.2, new Material(Color.BLUE, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(-1,0,0.2), 0.2, new Material(Color.YELLOW, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Plane(new Vector(0,0,0), new Vector(0,0,1), new Material(gray25, gray25, Color.BLACK, 1)));
		scene.add(new Plane(new Vector(-2,0,0), new Vector(1,0,0), new Material(gray75, gray25, Color.BLACK, 1)));
		scene.add(new PointLight(new Vector(2, 2, 2), gray75));
		scene.add(new PointLight(new Vector(2, -2, 2), gray25));
		RGBImage image = camera.process(scene);
		image.displayImage();
	}
}
