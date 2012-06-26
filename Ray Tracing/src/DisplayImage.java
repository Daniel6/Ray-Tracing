import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

@SuppressWarnings("serial")
public class DisplayImage extends JPanel {
	BufferedImage image;
    Dimension size = new Dimension();

    public DisplayImage(BufferedImage image) {
        this.image = image;
        size.setSize(image.getWidth(), image.getHeight());
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new JScrollPane(this));
        f.setSize(image.getWidth(), image.getHeight());
        f.setLocation(0, 0);
        f.setVisible(true);
    }
    
    protected void paintComponent(Graphics g) {
        int x = (getWidth() - image.getWidth()) / 2;
        int y = (getHeight() - image.getHeight()) / 2;
        g.drawImage(image, x, y, this);
    }
}
