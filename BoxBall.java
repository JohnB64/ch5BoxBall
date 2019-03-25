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
    private int xPosition;
    private int yPosition;
      
    private Ellipse2D.Double circle;
    private Color color;
    private int diameter;      
    private Canvas canvas;
    private int ySpeed;
    private int xSpeed;
    private int top;
    private int bottom;
    private int leftSide;
    private int rightSide;

    /**
     * Constructor for objects of class BoxBall
     * @param height height of box
     * @param width width of box
     * @param color color of ball
     * @param xPosition the x-position of the ball
     * @param yPosition the y-position of the ball
     * @param canvas the canvas
     * @param diameter the size of the ball
     */
    public BoxBall(int widthOfBox, int heightOfBox, int xPos, int yPos,
    int diameterOfBall, Color colorOfBall, Canvas canvasForBoxBall,
    int topOfBox, int bottomOfBox, int leftOfBox, int rightOfBox)
    {
        if(xPosition >= widthOfBox)
        xPosition = xPos;
        else
            xPosition = xPos;
        
        if(yPosition >= heightOfBox)
        yPosition = yPos;
        else
            yPosition = yPos;
        
        width = widthOfBox;
        height = heightOfBox;
        diameter = diameterOfBall;
        color = colorOfBall;
        canvas = canvasForBoxBall;
        top = topOfBox;
        bottom = bottomOfBox;
        leftSide = leftOfBox;
        rightSide = rightOfBox;
        
    }
    
    
    /**
     * Draw this ball at its current position onto the canvas.
     **/
    public void draw()
    {
        canvas.setForegroundColor(color);
        canvas.fillCircle(xPosition, yPosition, diameter);
    }

    /**
     * Erase this ball at its current position.
     **/
    public void erase()
    {
        canvas.eraseCircle(xPosition, yPosition, diameter);
    }
    
    /**
     * return the horizontal position of this ball
     */
    public int getXPosition()
    {
        return xPosition;
    }

    /**
     * return the vertical position of this ball
     */
    public int getYPosition()
    {
        return yPosition;
    }

    /**
     * Move this ball according to its position and speed and redraw.
     **/
    public void move()
    {
        
        erase();
            
        
        
        yPosition += ySpeed;
        xPosition += xSpeed;

        
        if(yPosition >= 0 && xPosition >= 0) {
            ySpeed = -ySpeed; 
            xSpeed = -xSpeed; 
        }

        
        draw();
    } 
}
