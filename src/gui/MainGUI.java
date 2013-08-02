package gui;

import java.awt.*;
//import java.awt.event.*;
import javax.swing.*;

//import java.awt.image.BufferedImage;
//import javax.imageio.*;
import java.io.File;
import java.util.Random;
//import java.io.IOException;
//import java.io.FileNotFoundException;

public class MainGUI extends JFrame {
	
	private final int BOARD_WIDTH = 900;
	private final int BOARD_HEIGHT = 700; 
	
	public MainGUI() {
		setTitle("JEUX DE CARTES");
		setSize(BOARD_WIDTH, BOARD_HEIGHT);
		setLayout(new GridLayout(2, 4));
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
		
		File folder = new File("media/cards_gif");
		File[] listOfFiles = folder.listFiles();
		
//		for (int i=0; i < listOfFiles.length; i++) {
//			System.out.println("File : " + listOfFiles[i].getName());
//		}
		
		int range = listOfFiles.length;
		System.out.println(range);
		
		long seed = System.currentTimeMillis();
		Random rand = new Random(seed);
		System.out.println(seed);
		System.out.println(rand);
		
		String [] xString = new String[6];
		int [] x = new int[6];
		CardPanel [] cpx = new CardPanel[6];
		
		for (int i = 0; i < 6; i++) {
			x[i] = rand.nextInt(range);
			System.out.println(x[i]);
			xString[i] = "media/cards_gif/" + listOfFiles[x[i]].getName();
			System.out.println(xString[i]);
			cpx[i] = new CardPanel(xString[i]);
			frame.add(cpx[i]);
			
		}
		
		frame.add(cp10H);
		frame.add(cp10D);
		
		
//		frame.add(cp10C);
//		frame.add(cp10D);
//		frame.add(cp10H);

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
			Integer height = (int) ( (double) image.getHeight(this)/1.4 );
			Integer width = (int) ( (double) image.getWidth(this)/1.4);
			g.drawImage(image, 0, 0, width, height , this);
		}
	}
}



