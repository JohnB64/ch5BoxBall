import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author John Burkert
 * @version March 25th 2019
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    private Random random;
    
    
    int widthOfBox = 400;
    int heightOfBox = 400;
    int widthOfCanvas = 400;
    int heightOfCanvas = 400;
    int topWall = 1;
    int bottomWall = 1;
    int leftWall = 1;
    int rightWall = 1;
    int xPos = 10;
    int yPos = 10;
    
    
    
    ArrayList<BoxBall> ball1 = new ArrayList<BoxBall>();
    
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", widthOfCanvas, heightOfCanvas);
        
        random = new Random();
    }
    
     /**
     * Simulate random balls bouncing in a box.
     */
    
        public void boxBounce(int numBalls)
    {
         
        
        
        
        myCanvas.setVisible(true);
        
        boxRectangle(numBalls);

        
        
        boolean finished = false;
        
        while(true) {
            
            myCanvas.wait(50);
            
            for(BoxBall boxBall : ball1) {
                
            boxBall.move();
            if(boxBall.getXPosition() >= heightOfBox * numBalls) {
                
                finished = true;
            }
            if(boxBall.getYPosition() >= widthOfBox * numBalls) {
                
                finished = true;
            }
        }
            
            
        }

    }


    /**
     * Draws a rectangle with a certain number of balls inside.
     * 
     */
    
    private void boxRectangle (int numBalls) {
        
       myCanvas.drawRectangle(widthOfBox, heightOfBox, xPos, yPos);
        
       for(int i = 0; i < numBalls; i++) {
              
            int xPos = randomPos();
            int yPos = randomPos();
            
            BoxBall boxBall = new BoxBall(widthOfBox, heightOfBox, xPos, yPos, 
            25, Color.RED,myCanvas, topWall, bottomWall, rightWall, leftWall);
               ball1.add(boxBall);
               boxBall.draw();
            }
    }
/**
 * Randomly positions the balls in the box via the x and y positions.
 * 
 */
  
    private int randomPos() {
        
        int position = heightOfBox;
        
        return random.nextInt(position);
        
    }
    
    
}
