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
    private int ySpeed = 4;
    private int xSpeed = 7;
    private int top = 0;
    private int bottom = 500;
    private int leftSide = 0;
    private int rightSide = 600;

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
    
    // add these later
    //int topOfBox, int bottomOfBox, int leftOfBox, int rightOfBox
    public BoxBall(int widthOfBox, int heightOfBox, int xPos, int yPos,
    int diameterOfBall, Color colorOfBall, Canvas canvasForBoxBall
    )
    {
       // if(xPosition >= widthOfBox)
       // xPosition = xPos;
       // else
       //     xPosition = xPos;
        
       // if(yPosition >= heightOfBox)
       // yPosition = yPos;
       // else
       //     yPosition = yPos;
        
        width = widthOfBox;
        height = heightOfBox;
        diameter = diameterOfBall;
        color = colorOfBall;
        canvas = canvasForBoxBall;
       // top = topOfBox;
       // bottom = bottomOfBox;
       // leftSide = leftOfBox;
       // rightSide = rightOfBox;
        
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
            
        
        
        yPosition = yPosition + ySpeed;
        xPosition = xPosition + xSpeed;

        if (xPosition + diameter > rightSide) {
            xPosition = rightSide - diameter;
            xSpeed = xSpeed * -1;
            
        }
       

        
        draw();
    } 
}
