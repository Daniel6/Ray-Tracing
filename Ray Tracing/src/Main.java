
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(10,5,5);
		Vector lookat = new Vector(0, 0, 0);
		Camera camera = new Camera(viewpoint, lookat, 1000);
		camera.setAntialias(true);
		camera.setZoom(4);
		Scene scene = new Scene();
		Color gray25 = new Color(0.25, 0.25, 0.25);
		Color gray75 = new Color(0.75, 0.75, 0.75);
		scene.add(new Sphere(new Vector(0, 0,0.4), 0.4, new Material(new Color(.8,.8,.8), new Color(.2,.2,.2), Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(.5, 0,0.2), 0.2, new Material(Color.BLACK, Color.RED, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0, .5,0.2), 0.2, new Material(Color.BLACK, Color.GREEN, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0,-.5,0.2), 0.2, new Material(Color.BLACK, Color.BLUE, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(-.5,0,0.2), 0.2, new Material(Color.BLACK, Color.YELLOW, Color.BLACK, 1)));
		scene.add(new Plane(new Vector(0,0,0), new Vector(0,0,1), new Material(gray25, gray25, Color.BLACK, 1)));
		scene.add(new Plane(new Vector(-2,0,0), new Vector(1,0,0), new Material(gray75, gray25, Color.BLACK, 1)));
		scene.add(new PointLight(new Vector(10, 10, 10), Color.WHITE));
		RGBImage image = camera.process(scene);
		image.displayImage();
	}
}
