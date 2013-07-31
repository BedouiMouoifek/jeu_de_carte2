package gui;

import java.awt.*;
import javax.swing.*;

public class MainGUI extends JFrame {
	
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new ImagePanel());
		frame.setTitle("display card");
		frame.setSize(300,300);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

class ImagePanel extends JPanel {
	private ImageIcon imageIcon = new ImageIcon("media/cards_for_test/funny-animated-gif-eat.gif");
	// private ImageIcon imageIcon = new ImageIcon("media/cards_for_test/QC.svg");
	private Image image =  imageIcon.getImage();

	/** Draw image on the panel */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		if (image != null)
			g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
	}
}