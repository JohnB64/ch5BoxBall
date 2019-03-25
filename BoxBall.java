import java.awt.*;
import java.awt.geom.*;
/**
 * Creates a rectangle with balls inside that randomly bounce off the sides.
 *
 * @author John Burkert
 * @version March 24th 2019
 */
public class BoxBall
{
    // instance variables - replace the example below with your own
    private int width;
    private int height;
    private int xPos;
    private int yPos;
      
    private int ballDegradation = 2;
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;
    private final int groundPosition;      
    private Canvas canvas;
    private int ySpeed = 1;

    /**
     * Constructor for objects of class BoxBall
     * 
     * 
     */
    public BoxBall(int width, int height, int xPos, int yPos, int diameter, Color colorOfBall
    , Canvas canvas, int groundPos)
    {
        
        groundPosition = groundPos;
    }
    
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPos, yPos, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPos, yPos, diameter);
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPos()
    {
        return xPos;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPos()
    {
        return yPos;
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        // remove from canvas at the current position
        erase();
            
        // compute new position
        
        yPos += ySpeed;
        xPos +=2;

        // check if it has hit the ground
        if(yPos >= (groundPosition - diameter) && ySpeed > 0) {
            yPos = (int)(groundPosition - diameter);
            ySpeed = -ySpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    } 
}
