
public class Material {
	Color reflective;
	Color diffuse;
	Color refractive;
	double refractionIndex;
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
}
