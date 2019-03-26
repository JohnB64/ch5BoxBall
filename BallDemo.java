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
    int topWall = 10;
    int bottomWall = 10;
    int leftWall = 10;
    int rightWall = 10;
    int xPos = 10;
    int yPos = 10;
    int diameterOfBall = 25;
    //int red = random.nextInt(256);
    //int green = random.nextInt(256);
    //int blue = random.nextInt(256);
    
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
     * Draws a rectangle with a certain number of balls, 
     * a certain color of ball, a certain size of ball and a certain position
     * of the balls inside.
     * 
     */
    
    private void boxRectangle (int numBalls) {
        
       
        
       for(int i = 0; i < numBalls; i++) {
              
            int xPos = randomPos();
            int yPos = randomPos();
            int diameterOfBall = randomSize();
            
            myCanvas.drawRectangle(widthOfBox, heightOfBox, xPos, yPos);
            
           // Color randomColor = new Color(red, green, blue);
            
            BoxBall boxBall = new BoxBall(widthOfBox, heightOfBox, xPos, yPos, 
            diameterOfBall, /*randomColor*/ Color.CYAN ,myCanvas, topWall, bottomWall, rightWall, leftWall);
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
    /**
       * Randomly sizes the balls in the box from anywhere
       * from super tiny to the default size of the ball which is 25
         * 
           */
        private int randomSize() {
        
        int size = diameterOfBall;

        return random.nextInt(size);
        
    
    }
    
    
}
