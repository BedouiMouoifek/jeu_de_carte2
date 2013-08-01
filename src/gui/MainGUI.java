package gui;

import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.*;
import javax.imageio.*;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

public class MainGUI extends JFrame {
	
	public static void main(String[] args) {

		
		System.out.println(new File(".").getAbsolutePath());
		
		
		JFrame frame = new JFrame();
		
		
		String filename = "media/cards_gif/10C.gif";
		File imageFile = new File(filename);
		BufferedImage image = null;
		try {		
			image = ImageIO.read(imageFile);
		} 
		catch (IOException e) {
		}
		CardPanel cardPanel = new CardPanel(filename);

				
		
		frame.add(cardPanel);

		
		
		frame.setTitle("afficher carte");
		frame.setSize(600,600);
		frame.setLocationRelativeTo(null); // Center the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
}

class CardPanel extends JPanel {
	private ImageIcon imageIcon;
	private Image image;
	
	CardPanel(String filename) {
		imageIcon = new ImageIcon(filename);
		image = imageIcon.getImage();
	}
	
	/** Draw image on the panel */
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (image != null){
			Integer height = image.getHeight(this);
			Integer width = image.getWidth(this);
			g.drawImage(image, 0, 0, width, height , this);
		}
	}
}



