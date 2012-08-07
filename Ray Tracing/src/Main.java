
public class Main {
	public static void main(String args[]) throws InterruptedException {
		Vector viewpoint = new Vector(4,2,2);
		Vector lookat = new Vector(0, 0, .1);
		Camera camera = new Camera(viewpoint, lookat, 600, 800);
		camera.setAntialias(0);
		camera.setZoom(4);
		Scene scene = new Scene();
		Material globe = Material.metal(Color.WHITE);
		globe.setRoughness(new Roughness(10000, .005));
		scene.add(new Sphere(new Vector(.5, 0,0.1), 0.1, Material.plastic(Color.RED)));
		scene.add(new Sphere(new Vector(0, .5,0.1), 0.1, Material.plastic(Color.GREEN)));
		scene.add(new Sphere(new Vector(0,-.5,0.1), 0.1, Material.plastic(Color.BLUE)));
		scene.add(new Sphere(new Vector(-.5,0,0.1), 0.1, Material.plastic(Color.YELLOW)));
		scene.add(new ParallelPiped(new Vector(0.3, 0.3, 0), new Vector(0.3, 0, 0), new Vector(0, 0.5, 0), new Vector(0, 0, 0.1), Material.plastic(Color.MAGENTA.mult(.5))));
		scene.add(new SmoothCylinder(new Vector(.1, -.1, .1), new Vector(-.1, .1, .1), .1, Material.plastic(Color.GRAY)));
		Material floor = Material.plastic(Color.WHITE);
		floor.setRoughness(new Roughness(100, .01));
		scene.add(new Plane(new Vector(0,0,0), new Vector(0,0,1), floor));
//		scene.add(new PointLight(new Vector(5,-5, 2), Color.gray(0.8)));
		scene.add(new PointLight(new Vector(.5, .5, .3), Color.gray(1.0)));
		long t0 = System.currentTimeMillis();
		RGBImage image = camera.process(scene, 4);
		long t1 = System.currentTimeMillis();
		System.out.println("run time:" + (t1 - t0) / 1000.0 + "s");
		image = image.magnify(1);
		image.displayImage();
	}
}
