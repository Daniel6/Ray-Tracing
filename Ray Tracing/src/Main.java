
public class Main {
	public static void main(String args[]) {
		Vector viewpoint = new Vector(10,5,5);
		Vector lookat = new Vector(0, 0, 0);
		Camera camera = new Camera(viewpoint, lookat, 300, 400);
		camera.setAntialias(2);
		camera.setZoom(4);
		Scene scene = new Scene();
		scene.add(new Sphere(new Vector(0, 0,0.2), 0.2, Material.plastic(Color.WHITE)));
		scene.add(new Sphere(new Vector(.5, 0,0.2), 0.2, Material.plastic(Color.RED)));
		scene.add(new Sphere(new Vector(0, .5,0.2), 0.2, Material.plastic(Color.GREEN)));
		scene.add(new Sphere(new Vector(0,-.5,0.2), 0.2, Material.plastic(Color.BLUE)));
		scene.add(new Sphere(new Vector(-.5,0,0.2), 0.2, Material.plastic(Color.YELLOW)));
		scene.add(new Plane(new Vector(0,0,0), new Vector(0,0,1), Material.plastic(Color.gray(1.0))));
		scene.add(new PointLight(new Vector(5,-5, 2), Color.gray(0.8)));
		scene.add(new PointLight(new Vector(5, 5, 2), Color.gray(0.8)));
		RGBImage image = camera.process(scene);
		image.displayImage();
	}
}
