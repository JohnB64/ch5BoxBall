import java.awt.Color;
import java.util.Random;
import java.util.ArrayList;
/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    private Random random;
    
    
    int width = 100;
    int height = 100;
    int xPos = 25;
    int yPos = 25;
    
    ArrayList<BoxBall> ball = new ArrayList<BoxBall>();
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
        
        random = new Random();
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        
        
        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();
        
        

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
     /**
     * Simulate random balls bouncing in box.
     */
    
    public void bounceInBox(int numBalls)
    {
         

        myCanvas.setVisible(true);

        boxBounce(numBalls);

        boolean finished =  false;
        
        
        while(!finished) {
            myCanvas.wait(50);   
            
            for(BoxBall boxball : ball) {
            
          //  boxBall.move();
            
            
           // if(boxBall.getXPosition() >= height) {
           //     finished = true;
           // }
        
        }
    }
}

    /**
     * Draws a rectangle with a certain number of balls inside.
     * 
     */
    private void boxBounce(int numBalls) {
        
        myCanvas.drawRectangle(width, height, xPos, yPos);
        for(int i = 0; i < numBalls; i++) {
       // BoxBall boxball = new Boxball(xPos, yPos, Color.RED, width, height, myCanvas);
      //  ball.add(boxBall);
      //  boxBall.draw();
    }
    }
    
    private int randomPos() {
        
        int position = (int) (height);
        
        return random.nextInt(position);
        
    }
}
