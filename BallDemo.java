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
    private int top;
    private int bottom;
    private int leftSide;
    private int rightSide;
    
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

       // myCanvas.drawLine(leftSide, top, rightSide, bottom);
        
        BoxBall ball1 = new BoxBall(50, 50, 16, 12, 14, Color.BLACK,
        myCanvas, 10, 10, 10, 10);
        
        ball1.draw();
        
        boxBounce(numBalls);

        boolean finished =  false;
        
        //int ball1;
        
        while(!finished) {
            myCanvas.wait(50);   
            ball1.move();
            
           // for(BoxBall boxball : ball) 
            
            
            
            
        if(ball1.getXPosition() >= 550 || ball1.getXPosition() >= 550) {
                finished = true;
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
       // BoxBall boxball = new Boxball(xPos, yPos, width, height, myCanvas);
       // ball.add(boxBall);
      //  boxBall.draw();
    }
    }
    
    private int randomPos() {
        
        int position = (int) (height);
        
        return random.nextInt(position);
        
    }
}
