
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(2, 2, 2);
		Vector lookat = new Vector(0, 0, 0);
		Camera camera = new Camera(viewpoint, lookat, 1001);
		Scene scene = new Scene();
		scene.add(new Sphere(new Vector(0,0,0), 0.2, Color.WHITE));
		scene.add(new Sphere(new Vector(1,0,0), 0.1, Color.RED));
		scene.add(new Sphere(new Vector(0,1,0), 0.1, Color.GREEN));
		scene.add(new Sphere(new Vector(0,0,1), 0.1, Color.BLUE));
		scene.add(new Plane(new Vector(0,0,-1), new Vector(0,0,1), Color.WHITE));
		scene.add(new PointLight(new Vector(0, 0, 10), Color.WHITE));
//		scene.add(new PointLight(new Vector(-.2,-.2,0), Color.GRAY));
		RGBImage image = camera.process(scene);
		image.displayImage();
	}
}
