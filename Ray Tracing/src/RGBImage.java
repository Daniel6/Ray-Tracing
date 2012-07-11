import java.awt.image.BufferedImage;

public class RGBImage {

	int width;
	int height;
	BufferedImage image;

	public RGBImage(int width, int height) {
		this.width = width;
		this.height = height;
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	void setPixel(int x, int y, Color c) {
		c = c.clip();
		int blue = (int) (c.getB() * 255);
		int green = (int) (c.getG() * 255);
		int red = (int) (c.getR() * 255);
		int rgb = blue | (green << 8) | (red << 16);
		image.setRGB(x, y, rgb);
	}

	Color getPixel(int x, int y) {
		int i = image.getRGB(x,  y);
		double r = ((i >> 16) & 0xff) / 255.0;
		double g = ((i >>  8) & 0xff) / 255.0;
		double b = ((i >>  0) & 0xff) / 255.0;
		return new Color(r, g, b);
	}

	void displayImage() {
		new DisplayImage(image);
	}
	
	RGBImage magnify(int n) {
		RGBImage m = new RGBImage(n * width, n * height);
		for (int row = 0; row < width; row++) {
			for (int col = 0; col < height; col++) {
				int c = image.getRGB(col, row);
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < n; j++) {
						m.image.setRGB(n * col + j,  n * row + i, c);
					}
				}
			}
		}
		return m;
	}
	
}
