import java.awt.*;
import java.awt.geom.*;
/**
 * Creates a rectangle with balls inside that randomly bounce off the sides.
 *
 * @author John Burkert
 * @version March 25th 2019
 */
public class BoxBall
{
    
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
    private int bottom = 0;
    private int left;
    private int right = 0;

    /**
     * Constructor for objects of class BoxBall
     * @param height height of box
     * @param width width of box
     * @param color color of ball
     * @param xPosition the x-position of the ball
     * @param yPosition the y-position of the ball
     * @param canvas the canvas
     * @param diameter the size of the ball
     * @param ySpeed the speed the ball moves vertically
     * @param xSpeed the speed the ball moves horizontally
     */
    
    
    public BoxBall(int widthOfBox, int heightOfBox, int xPos, int yPos,
    int diameterOfBall, Color colorOfBall, Canvas canvasForBoxBall, 
    int topWall, int bottomWall, int leftWall, int rightWall)
    {
          
        xPosition = xPos;
        yPosition = yPos;
        width = widthOfBox;
        height = heightOfBox;
        diameter = diameterOfBall;
        color = colorOfBall;
        canvas = canvasForBoxBall;
        xSpeed = (int) (Math.random() * 25) + 1;
        ySpeed = (int) (Math.random() * 25) + 1;
        top = topWall;
        bottom = bottomWall;
        left = leftWall;
        right = rightWall;
        
        
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
     * Move this ball according to its position and speed, redraw, and size.
     **/
    public void move()
    {
        
        erase();

        yPosition = yPosition + ySpeed;
        xPosition = xPosition + xSpeed;
        
        if (xPosition - diameter < right) {
            
         xSpeed = xSpeed * -1;
         xPosition = diameter + 10;
            
        }
        else if(xPosition + diameter >= width) {
            
            xSpeed = xSpeed * -1;
            xPosition = width - diameter;
            
        }
        
        if (yPosition - diameter <= bottom) {
            
         ySpeed = ySpeed * -1;
         yPosition = diameter + 10;
            
        }
        else if(yPosition + diameter >= width) {
            
            ySpeed = ySpeed * -1;
            yPosition = width - diameter;
            
        }
        
        draw();
    } 
}
