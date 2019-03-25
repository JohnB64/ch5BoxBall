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
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;

    /**
     * Constructor for objects of class BoxBall
     * @param height height of box
     * @param width width of box
     * @param color color of ball
     * @param xPos the x-position of the ball
     * @param yPos the y-position of the ball
     * @param canvas the canvas
     * @param diameter the size of the ball
     */
    public BoxBall(int width, int height, int xPos, int yPos, int diameter, Color colorOfBall
    , Canvas canvas)
    {
        if(xPos >= width)
        xPos = xPos;
        else
            xPos = xPos;
        
        if(yPos >= height)
        yPos = yPos;
        else
            yPos = yPos;
        
        width = width;
        height = height;
        diameter = diameter;
        color = colorOfBall;
        canvas = canvas;
        
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
        xPos += xSpeed;

        // check if it has hit the ground
        if(yPos >= 0 && xPos >= 0) {
            ySpeed = -ySpeed + ballDegradation; 
            xSpeed = -xSpeed + ballDegradation; 
        }

        // draw again at new position
        draw();
    } 
}
