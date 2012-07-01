
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(10,10,10);
		Vector lookat = new Vector(0, 0, 0);
		Camera camera = new Camera(viewpoint, lookat, 1000);
		camera.setZoom(4.0);
		Scene scene = new Scene();
		scene.add(new Sphere(new Vector(0,0,0), 0.2, new Material(Color.WHITE, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(1,0,0), 0.2, new Material(Color.RED, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0,1,0), 0.2, new Material(Color.GREEN, Color.BLACK, Color.BLACK, 1)));
		scene.add(new Sphere(new Vector(0,0,1), 0.2, new Material(Color.BLUE, Color.BLACK, Color.BLACK,1 )));
		scene.add(new Plane(new Vector(0,0,-0.2), new Vector(0,0,1), new Material(Color.WHITE, Color.BLACK, Color.BLACK, 1)));
		scene.add(new PointLight(new Vector(0.5, 0, 0.5), Color.WHITE));
		RGBImage image = camera.process(scene);
		image.displayImage();
	}
}
