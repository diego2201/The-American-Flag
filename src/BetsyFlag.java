import java.awt.*;
import java.awt.geom.GeneralPath;

/**
 * Creates the Betsy American class by implementing its own Star methods
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public class BetsyFlag extends BaseAmerican 
{

	/** Where the width of the flag will be stored */
	private double recWidth;
	
	/** Where the height of the flag will be stored */
	private double recHeight;
	
	/**
	 * The constructor of the Betsy American flag. 
	 * 
	 * @param width		the width to be set to the flag
     * @param height	the height to be set to the flag
	 * @param c1		the passed in color to be assigned to the rect variable
	 * @param c2		the passed in color to be assigned to the stripes variable
	 */
	public BetsyFlag(double width, double height, Color c1, Color c2) 
	{
		//Passes the width and the height to the parent constructor
		super(width, height, c1, c2);
		
		//Assigns the width and height of their respective variables 
		recWidth = width;
		recHeight = height;
	}

	@Override
	/**
	 * Implements the star method from is parent class. Creates the 13 stars seen in the Betsy Ross
	 * American flag in a circular pattern
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
		
		//Creates the star
		GeneralPath star = new GeneralPath();
		
	    star.moveTo((float) x[0], (float) y[0]);
	    
	    for(int i = 1; i < x.length; i++)
	    {
	    	star.lineTo((float) x[i], (float) y[i]);
	    }
	    
	    star.closePath();
	    
	    g2.translate(.017 * recWidth, .0232 * recHeight);
	    g2.setPaint(Color.WHITE);
		
	    //Help from Office Hours
	    //Calculates the radius and theta
		double halfWidth = recWidth / 2;
		double theta =  (2 * Math.PI) / 13;
		double radius = halfWidth * .19999;		

		//Where the x and y component will be stored using polar coordinates
		double xComponent;
		double yComponent;
		
		//Finds the center point of the circle in order to correctly print out in a circle pattern
		double centerX = .16 * recWidth;
		double centerY = .195 * recHeight;
		
		//Sets the center
		g2.translate(centerX, centerY);
		
		//Help from Office Hours
		//For loop to add a star 13 times 
		for(int i = 0; i < 13; i++)
		{		
			//Finds the x and y component in order to place the next star,
				//this is done using the equation x = rsin(theta) and y = rcos(theta)
			xComponent = radius * Math.sin(theta);
			yComponent = radius * Math.cos(theta);
			
			//Adds the star
			g2.translate(xComponent, yComponent);
						
			//Rotates the star 
			double rotate = 2.0 * Math.PI / 13;
			
			g2.rotate(rotate);
			
			//Colors the star and makes it visible
			g2.fill(star);
			g2.rotate(-rotate);
			
			//Sets the value back to the center in order to correctly translate the next star
			g2.translate(- xComponent, - yComponent);
			
			//Increments theta in order to keep moving along the circle
			theta += 2 * Math.PI/13;
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