import java.awt.*;
import javax.swing.*;

/**
 * The main parent class. Extends JPanel. Sets the dimensions of the flags with 
 * the passed in width and height from the main class, implements helpers and setters.
 * 
 * @author Diego Cifuentes
 * @version 1
 */
public abstract class Flag extends JPanel
{
	/** private variable where the height of the flag will be stored */
    private double height;
    
    /** Private variable where the width of the flag will be stored */
    private double width;
   
    /**
     * The main flag constructor, sets the height and width of the 
     * flag with the passed in values 
     * 
     * @param width		the width to be set to the flag
     * @param height	the height to be set to the flag
     */
    public Flag(double width, double height) 
    {
        this.height = height;
        this.width = width;
    }
    
    @Override
    /**
     * Returns the dimensions of the rectangle 
     * 
     * @return the dimensions of the width and height
     */
    public Dimension getPreferredSize() 
    {
        return new Dimension((int) width, (int) height);
    }
}