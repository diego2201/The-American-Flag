import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Constructors an American flag without the stars, the parent class to 
 * the modern American flag and the Betsy Ross flag. 
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public abstract class BaseAmerican extends Flag 
{
	/** Where the color of the rectangle will be stored */
	private Color rect;
	
	/** Where the color of the stripes will be stored */
	private Color stripes;
	
	/** Where the width of the flag will be stored */
	private double baseWidth;
	
	/** Where the height of the flag will be stored */
	private double baseHeight;
	
	private double rw;
	private double xc;
	
	/**
	 * The constructor of the Base American flag. 
	 * 
	 * @param width		the width to be set to the flag
     * @param height	the height to be set to the flag
	 * @param c1		the passed in color to be assigned to the rect variable
	 * @param c2		the passed in color to be assigned to the stripes variable
	 */
	public BaseAmerican(double width, double height, Color c1, Color c2)
	{
		//Passes the width and the height to the parent constructor
		super(width, height);
		
		//Assigns the colors to their respective variables 
		rect = c1;
		stripes = c2;
	
		//Assigns the width and height of their respective variables 
		baseWidth = width;
		baseHeight = height;
	}

	/**
	 * Creates the rectangle for the American flag in the top left corner
	 * and then sets its color to the passed in value from the constructor
	 * 
	 * @param g		Graphics 
	 */
	public void paintComponentRect(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		//Sets the paint color to the passed in color from the constructor 
	    g2.setPaint(rect);
	    
	    //Creates a new 2D rectangle and then colors it in
	    g2.fill(new Rectangle2D.Double(0, 0, .4 * baseWidth, .53846 * baseHeight));
	}
	
	/**
	 * Creates the stripes of the American flag and then paints them 
	 * 
	 * @param g		Graphics
	 */
	public void paintComponentStripes(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;
		
		rw = .6 * baseWidth;
		xc = .4 * baseWidth;
		
		//For loop to create the 13 stripes
		for(int i = 0; i < 13; i++)
	    {
	    	if(i == 7)
	    	{
	    		xc = 0;
	    		rw = baseWidth;
	    	}
	    	
	    	if(i % 2 == 0)
	    	{
	    		//Paints some of the stripes to the passed in value
	    		g2.setPaint(stripes);
	    	}
	    	
	    	else
	    	{
	    		//Pains some of the stripes to white
	    		g2.setPaint(Color.WHITE);
	    	}
	    	
	    	//Creates a new 2D rectangle and then either colors them in with the stripe color 
	    		//or white
	    	g2.fill(new Rectangle2D.Double(xc, i * .0769 * baseHeight, rw, .0769 * baseHeight));
	    }
	}
	
	/**
	 * Pains the stripes and rectangle to the GUI
	 * 
	 * @param g		Graphics
	 */
	public void paintComponent(Graphics g)
	{
		paintComponentStripes(g);
		paintComponentRect(g);
	}

	/**
	 * Makes an abstract method to create the pattern for the stars that 
	 * each of its child classes must implement
	 * 
	 * @param g		Graphics
	 */
	public abstract void paintComponentStars(Graphics g);
}
