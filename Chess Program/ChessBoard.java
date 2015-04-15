import java.awt.*;
import javax.swing.JPanel;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.Color;
/**
 * Chess Board is where the game is played on.
 * 
 * @NRafacz 
 * @4-14-15
 */
public class ChessBoard
{
    /** description of instance variable x (add comment for each instance variable) */
    private final int NUM_ROWS = 8;
    private final int NUM_COLS = 8;

    private int x;
    private int y;
    private int width;
    private int height;

    /**
     * Default constructor for objects of class ChessBoard
     */
    public ChessBoard(int x, int y, int width, int height)
    {
        // initialise instance variables
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public void draw(Graphics2D g2)
    {
        // put your code here
        int count = 0;
        for (int i =0; i < 64; i ++)
        {
            Rectangle2D.Double square = new Rectangle2D.Double(this.x + (count *25), this.y + (count * 25), this.width, this.height);
            g2.setColor(Color.blue);
            g2.draw(square);
            g2.fill(square);
            if(i %2 == 1)
            {
                g2.setColor(Color.gray);
            }
            count ++;
        }
    }
    }


