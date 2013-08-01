package gui;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

//import java.awt.image.BufferedImage;
//import javax.imageio.*;
//import java.io.File;
//import java.io.IOException;
//import java.io.FileNotFoundException;

public class MainGUI extends JFrame {
	
	private final int BOARD_WIDTH = 1000;
	private final int BOARD_HEIGHT = 800; 
	
	public MainGUI() {
		setTitle("JEUX DE CARTES");
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLayout(new GridLayout(2, 3));
		setLocationRelativeTo(null); // Center the frame
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	

//	private static class ButtonHandler implements ActionListener {
//		public void actionPerformed(ActionEvent e) {
//			System.exit(0);
//		}
//	}
	
	
	public static void main(String[] args) {

//		String filename2 = "media/cards_gif/10D.gif";
//		File imageFile2 = new File(filename2);
//		BufferedImage image2 = null;
//		try {		
//			image2 = ImageIO.read(imageFile2);
//		} 
//		catch (IOException e) {
//		}

		
		MainGUI frame = new MainGUI();
		
	
		String filename10C = "media/cards_gif/10C.gif";
		CardPanel cp10C = new CardPanel(filename10C);
		
		String filename10D = "media/cards_gif/10D.gif";
		CardPanel cp10D = new CardPanel(filename10D);

		String filename10H = "media/cards_gif/10H.gif";
		CardPanel cp10H = new CardPanel(filename10H);

		
		frame.add(cp10C);
		frame.add(cp10D);
		frame.add(cp10H);

	
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



