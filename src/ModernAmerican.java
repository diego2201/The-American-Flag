import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Creates the modern American class by implementing its own Star methods
 * 
 * @author Diego Cifuentes 
 *
 */
public class ModernAmerican extends BaseAmerican
{

	/** Where the width of the flag will be stored */
	private double recWidth;
	
	/** Where the height of the flag will be stored */
	private double recHeight;
	
	/**
	 * The constructor of the Modern American flag. 
	 * 
	 * @param width		the width to be set to the flag
     * @param height	the height to be set to the flag
	 * @param c1		the passed in color to be assigned to the rect variable
	 * @param c2		the passed in color to be assigned to the stripes variable
	 */
	public ModernAmerican(double width, double height, Color c1, Color c2) 
	{
		//Passes the width and the height to the parent constructor
		super(width, height, c1, c2);
		
		//Assigns the width and height of their respective variables 
		recWidth = width;
		recHeight = height;
	}

	@Override
	/**
	 * Implements the star method from is parent class. Creates the 50 stars seen in the modern
	 * American flag
	 * 
	 * @param g		Graphics 
	 */
	public void paintComponentStars(Graphics g) 
	{
		
		Graphics2D g2 = (Graphics2D) g;
		
		double x[] = {
			      .0002105 * recWidth, .0126 * recWidth, .0163 * recWidth, .02 * recWidth, .0324 * recWidth,
			      .0217 * recWidth, .02574 * recWidth, .0163 * recWidth, .0069 * recWidth, .0109 * recWidth
		};
		double y[] = {
			      .02 * recHeight, .02 * recHeight, 0, .02 * recHeight, .02 * recHeight, 
			      .03 * recHeight, .05 * recHeight, .04 * recHeight, .05 * recHeight, .03 * recHeight
		};
		
		GeneralPath star = new GeneralPath();
		
	    star.moveTo((float) x[0], (float) y[0]);
	    
	    for(int i = 1; i < x.length; i++)
	    {
	    	star.lineTo((float) x[i], (float) y[i]);
	    }
	    
	    star.closePath();
	    
	    g2.translate(.017 * recWidth, .0232 * recHeight);
	    g2.setPaint(Color.WHITE);
	    g2.fill(star);
		
	    for(int i = 0; i < 5; i++)
	    {
	    	g2.translate(.066316 * recWidth, 0);
	        g2.fill(star);
	    }
	    
	    for(int i = 0; i < 4; i++)
	    {
	    	g2.translate(-.03316 * recWidth, .054 * recHeight);
	        g2.fill(star);
	        
	        for(int j = 0; j < 4; j++)
	        {
	        	g2.translate(-.066316 * recWidth, 0);
	            g2.fill(star);
	        }
	        
	        g2.translate(-.03316 * recWidth, .054 * recHeight);
	        g2.fill(star);
	        
	        for(int k = 0; k < 5; k++)
	        {
	        	g2.translate(.066316 * recWidth, 0);
	            g2.fill(star);
	        }
	    }
	}
	
	/**
	 * First calls the parent painComponent method to pain the stripes and rectangle
	 * and then pains the stars to the GUI
	 * 
	 * @param g		Graphics 
	 */
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		paintComponentStars(g);
	}
}
