
public class Material {
	Color reflective;
	Color diffuse;
	Color refractive;
	double refractionIndex;
	Roughness roughness;
	public Material(Color a, Color b, Color c, double d) {
		diffuse = a;
		reflective = b;
		refractive = c;
		refractionIndex = d;
	}
	public Color getReflective() {
		return reflective;
	}
	public void setReflective(Color reflective) {
		this.reflective = reflective;
	}
	public Color getDiffuse() {
		return diffuse;
	}
	public void setDiffuse(Color diffuse) {
		this.diffuse = diffuse;
	}
	public Color getRefractive() {
		return refractive;
	}
	public void setRefractive(Color refractive) {
		this.refractive = refractive;
	}
	public double getRefractionIndex() {
		return refractionIndex;
	}
	public void setRefractionIndex(double refractionIndex) {
		this.refractionIndex = refractionIndex;
	}
	public Roughness getRoughness() {
		return roughness;
	}
	public void setRoughness(Roughness roughness) {
		this.roughness = roughness;
	}
	public static Material plastic(Color c) {
		return new Material(c.mult(0.9), Color.gray(0.1), Color.BLACK, 0);
	}
	public static Material metal(Color c) {
		return new Material(Color.gray(0.2), c.mult(0.8), Color.BLACK, 0);
	}
}
