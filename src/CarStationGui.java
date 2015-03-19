import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class CarStationGui extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	Dimension minSize = new Dimension(5, 10);
    Dimension prefSize = new Dimension(5, 10);
    Dimension maxSize = new Dimension(Short.MAX_VALUE, 10);
    
    JFrame Frame1= new JFrame("Box Layout");
	JPanel mainPanel =new JPanel();
	//Box center = Box.createVerticalBox();
	Box right = Box.createVerticalBox();
	
	BufferedImage stationImage;
	BufferedImage carImage;
	JLabel[] line1Labels;
	JLabel[] line2Labels;
	public final JTextField textField = new JTextField();
	
	
	public CarStationGui(int n) throws IOException {
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setColumns(1);
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		textField.resize(new Dimension(5,5));
		//mainPanel.add(textField);
		
		stationImage = ImageIO.read(new File("station.png"));
		carImage = ImageIO.read(new File("car.png"));
		
		line1Labels = new JLabel[n];
		line2Labels = new JLabel[n];
		for(int i=0;i<n;i++){
			line1Labels[i] = new JLabel(new ImageIcon(stationImage));
			line2Labels[i] = new JLabel(new ImageIcon(stationImage));
			
			mainPanel.add( line1Labels[i]);
			mainPanel.add(new Box.Filler(minSize, prefSize, maxSize));
			
			right.add( line2Labels[i]);
		    right.add(new Box.Filler(minSize, prefSize, maxSize));
		}
		
		Frame1.getContentPane().add(mainPanel, BorderLayout.CENTER);
		
		
		Frame1.getContentPane().add(right, BorderLayout.EAST);
		Frame1.setDefaultCloseOperation(EXIT_ON_CLOSE);
		Frame1.pack();
		Frame1.setSize(600,600);
		Frame1.setVisible(true);
	}

}
