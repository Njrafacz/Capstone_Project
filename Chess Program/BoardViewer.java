import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

/**
 * Write a description of class BoardViewer here.
 * 
 * @NRafacz 
 * @4-14-15 
 */
public class BoardViewer
{
    /** description of instance variable x (add comment for each instance variable) */
    private final int WIDTH = 1000;
    private final int HEIGHT = 1000;
    
    private JButton randomColors;
    private JLabel titleLabel;
    private JPanel panel, tools;
    private ChessBoard board;
    private JFrame frame;
    /**
     * Default constructor for objects of class BoardViewer
     */
    public BoardViewer()
    {
        // initialise instance variables
        titleLabel = new JLabel("Chess Board");
        tools.add(titleLabel);
        panel = new JPanel();
        panel.add(tools);
        ChessBoard board = new ChessBoard(100,100, 50,50);
        panel.add(board);
        
        frame = new JFrame();
        frame.setTitle("Chess Program");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        frame.add(panel);
        frame.setVisible(true);
    }

   

}
