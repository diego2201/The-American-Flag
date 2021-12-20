import java.awt.*;
import javax.swing.*;

/**
 * This class defines the dimensions of the flags to be called. Then creates a 
 * frame panel and adds the flags into them in order to output the GUI correctly
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class Driver 
{
	/** Constant width for flags */
	private final static double FLAG_WIDTH = 350.0;

	/** Constant height for flags */
	private final static double FLAG_HEIGHT = 150.0;
	
	/** Padding for the GUI */
	private final static int PADDING = 5;
	
	/**
	 * In the main method the flag classes are called and then constructed
	 * then creates a new JFrame and a JPanel. Adds the flag GUIs to the pane
	 * and then adds that pane to the JPanel
	 * 
	 * @param args
	 */
	public static void main(String[] args) 
	{
		//Constructs the modern American flag with the set dimensions and the given colors 
		ModernAmerican modernNormal = new ModernAmerican(FLAG_WIDTH, FLAG_HEIGHT, Color.BLUE, Color.RED);
		ModernAmerican modernBW = new ModernAmerican(FLAG_WIDTH, FLAG_HEIGHT, Color.BLACK, Color.BLACK);
		
		//Constructs the betsy American flag with the set dimensions and the given colors
		BetsyFlag betsyNormal = new BetsyFlag(FLAG_WIDTH, FLAG_HEIGHT, Color.BLUE, Color.RED);
		BetsyFlag betsyBW = new BetsyFlag(FLAG_WIDTH, FLAG_HEIGHT, Color.BLACK, Color.BLACK);
		
		//Help from Office Hours
		//Creates the new frame that will output all the flags, sets the name to "American Flags"
			//Sets the dimensions, background colors, and the default close operation
		JFrame frame = new JFrame("American Flags");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBackground(Color.WHITE);
		frame.setSize(650, 450);
		
		//Sets the layout of the frame to the Border Layout
		frame.setLayout(new BorderLayout());
		
		//Creates a new JLabel with the correct output from the ReadMe
		JLabel text = new JLabel("Diego Cifuentes, CS 2334, Fall 2021", SwingConstants.CENTER);
		
		//Creates new JPanel, sets its layout to Grid and adds the spacing
		JPanel flagPanel = new JPanel();
		flagPanel.setLayout(new GridLayout(2, 2, PADDING, PADDING));
		
		//Adds the modern American flags
		flagPanel.add(modernNormal);
		flagPanel.add(modernBW);
		
		//Adds the betsy American flag
		flagPanel.add(betsyNormal);
		flagPanel.add(betsyBW);
		
		//Adds the panel to the main frame to the middle of the frame
		frame.add(flagPanel, BorderLayout.CENTER);
		
		//Then adds the text to the bottom of the main frame
		frame.add(text, BorderLayout.PAGE_END);
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
}
