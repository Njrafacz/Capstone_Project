import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
/**
 * Write a description of class BoardViewer here.
 * 
 * @NRafacz 
 * @4-14-15 
 */
public class BoardViewer
{
    /** description of instance variable x (add comment for each instance variable) */
    
    private JButton randomColors;
    private JLabel titleLabel;
    private JPanel panel, tools;
    private JFrame frame;
    /**
     * Default constructor for objects of class BoardViewer
     */
    public static void main(String[] args)
    {
        // initialise instance variables
        JFrame frame = new JFrame();
        frame.setSize(1000, 1000);
        frame.setTitle("Chess Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        BoardPanel board = new BoardPanel();
        JPanel panel = new JPanel();
        panel.add(board);
        frame.add(panel);
        frame.setVisible(true);
    }

   

}
