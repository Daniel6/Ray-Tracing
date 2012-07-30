
public class Material {
	Color reflective;
	Color diffuse;
	Color refractive;
	double refractionIndex;
	Roughness roughness;
	double specularExponent;
	public Material(Color a, Color b) {
		diffuse = a;
		reflective = b;
		refractionIndex = 1.0;
		specularExponent = 0.0;
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
	public double getSpecularExponent() {
		return specularExponent;
	}
	public void setSpecularExponent(double specularExponent) {
		this.specularExponent = specularExponent;
	}
	public static Material plastic(Color c) {
		Material m = new Material(c.mult(0.9), Color.gray(0.1));
		m.setSpecularExponent(100.0);
		return m;
	}
	public static Material metal(Color c) {
		Material m = new Material(Color.gray(0.2), c.mult(0.8));
		m.setSpecularExponent(1000.0);
		return m;
	}
}
