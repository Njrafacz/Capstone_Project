import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import java.awt.*;
import javax.swing.JPanel;

/**
 * Write a description of class BoardComponent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BoardPanel extends JPanel
{
    /** description of instance variable x (add comment for each instance variable) */
   private final int PANEL_WIDTH = 1500;
   private final int PANEL_HEIGHT = 1500;
   public BoardPanel()
   {
       setBackground(Color.black);
       setPreferredSize (new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
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
    public void paintBoard(Graphics g)
    {
        super.paintBoard(g);
        ChessBoard board = new ChessBoard(100,100,50,50);
        board.draw(g);
    }
}
