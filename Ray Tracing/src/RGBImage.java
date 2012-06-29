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
			int blue = (int) (c.getB() * 255);
			int green = (int) (c.getG() * 255);
			int red = (int) (c.getR() * 255);
			int rgb = blue | (green << 8) | (red << 16);
	        image.setRGB(x, y, rgb);
	    }

	    void displayImage() {
	        new DisplayImage(image);
	    }
}
