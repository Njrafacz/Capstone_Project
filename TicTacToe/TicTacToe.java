/**
 * TicTacToe is a GUI where you can play person vs person TicTacToe (for now!!)
 * 
 * @author NRafacz 
 * @version 5-1-15
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
public class TicTacToe implements ActionListener 
{
final String VERSION = "1.0";
//Setting up ALL the variables
JFrame window = new JFrame("Tic-Tac-Toe " + VERSION);

JMenuBar Main = new JMenuBar();
JMenuItem mnuNewGame = new JMenuItem("New Game"),
mnuInstruction = new JMenuItem("Instructions"),
mnuExit = new JMenuItem("Exit"),
mnuAbout = new JMenuItem("About");

JButton btn1v1 = new JButton("Player vs Player"),
btn1vCPU = new JButton("Player vs CPU"),
btnBack = new JButton("<--back");
JButton btnEmpty[] = new JButton[10];

JPanel pnlNewGame = new JPanel(),
pnlN = new JPanel(),
pnlS = new JPanel(),
pnlT = new JPanel(),
pnlB = new JPanel(),
pnlPlayingField = new JPanel();
JLabel lblTitle = new JLabel("Tic-Tac-Toe");
JTextArea txtMessage = new JTextArea();

final int winCombo[][] = new int[][] {
{1, 2, 3}, {1, 4, 7}, {1, 5, 9},
{4, 5, 6}, {2, 5, 8}, {3, 5, 7},
{7, 8, 9}, {3, 6, 9}
/*Horizontal Wins*/ /*Vertical Wins*/ /*Diagonal Wins*/
};
final int X = 412, Y = 268, color = 190;
boolean inGame = false;
boolean win = false;
boolean btnEmptyClicked = false;
String message;
int turn = 1;
int wonNumber1 = 1, wonNumber2 = 1, wonNumber3 = 1;
/**
     * Constructor of the TicTacToe class.
     * 
     * 
     * 
     */
public TicTacToe() 
{ //Setting game properties and layout and style...
//Setting window properties:
window.setSize(X, Y);
window.setLocation(450, 260);
window.setResizable(false);
window.setLayout(new BorderLayout());
window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//Setting Panel layouts and properties
pnlNewGame.setLayout(new GridLayout(2, 1, 2, 10));
pnlN.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlS.setLayout(new FlowLayout(FlowLayout.CENTER));

pnlN.setBackground(new Color(color-20, color-20, color-20));
pnlS.setBackground(new Color(color, color, color));

pnlT.setBackground(new Color(color, color, color));
pnlB.setBackground(new Color(color, color, color));

pnlT.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlB.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlNewGame.setBackground(Color.blue);

//Adding menu items to menu bar
Main.add(mnuNewGame);
Main.add(mnuInstruction);
Main.add(mnuAbout);
Main.add(mnuExit);

//Adding buttons to NewGame panel
pnlNewGame.add(btn1v1);
pnlNewGame.add(btn1vCPU);

//Adding Action Listener to all the Buttons and Menu Items
mnuNewGame.addActionListener(this);
mnuExit.addActionListener(this);
mnuInstruction.addActionListener(this);
mnuAbout.addActionListener(this);
btn1v1.addActionListener(this);
btn1vCPU.addActionListener(this);
btnBack.addActionListener(this);

//Setting up the playing field
pnlPlayingField.setLayout(new GridLayout(3, 3, 2, 2));
pnlPlayingField.setBackground(Color.black);
for(int i=1; i<=9; i++) {
btnEmpty[i] = new JButton();
btnEmpty[i].setBackground(new Color(220, 220, 220));
btnEmpty[i].addActionListener(this);
pnlPlayingField.add(btnEmpty[i]);
}
//Adding everything needed to pnlN and pnlS
pnlN.add(Main);
pnlS.add(lblTitle);

//Adding to window and Showing window
window.add(pnlN, BorderLayout.NORTH);
window.add(pnlS, BorderLayout.CENTER);
window.setVisible(true);
}

/**
     * actionPerformed methods checks and updates the game via mouse clicks. 
     * 
     * @param  click  Mouse Input used to proceed with the game.
     *  
     */
public void actionPerformed(ActionEvent click) {
Object source = click.getSource();
for(int i=1; i<=9; i++) {
if(source == btnEmpty[i] && turn < 10) {
btnEmptyClicked = true;
if(!(turn % 2 == 0))
btnEmpty[i].setText("X");
else
btnEmpty[i].setText("O");
btnEmpty[i].setEnabled(false);
pnlPlayingField.requestFocus();
turn++;
}
}
if(btnEmptyClicked) {
checkWin();
btnEmptyClicked = false;
}
if(source == mnuNewGame) {
clearPanelS();
pnlS.setLayout(new GridLayout(2, 1, 2, 5));
pnlT.add(pnlNewGame);
pnlB.add(btnBack);
pnlS.add(pnlT);
pnlS.add(pnlB);

}
else if(source == btn1v1) {
if(inGame) {
int option = JOptionPane.showConfirmDialog(null, "If you start a new game," +
"your current game will be lost..." + "\n" +
"Are you sure you want to continue?",
"Quit Game?" ,JOptionPane.YES_NO_OPTION);
if(option == JOptionPane.YES_OPTION) {
inGame = false;
}
}
if(!inGame) {
btnEmpty[wonNumber1].setBackground(new Color(220, 220, 220));
btnEmpty[wonNumber2].setBackground(new Color(220, 220, 220));
btnEmpty[wonNumber3].setBackground(new Color(220, 220, 220));
turn = 1;
for(int i=1; i<10; i++) {
btnEmpty[i].setText("");
btnEmpty[i].setEnabled(true);
}
win = false;
showGame();

}
}
else if(source == btn1vCPU) {
JOptionPane.showMessageDialog(null, "Coming Soon!!");
}
else if(source == mnuExit) {
int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
"Exit Game" ,JOptionPane.YES_NO_OPTION);
if(option == JOptionPane.YES_OPTION)
System.exit(0);
}
else if(source == mnuInstruction || source == mnuAbout) {
clearPanelS();
String message = "";
txtMessage.setBackground(new Color(color, color, color));
if(source == mnuInstruction) {
message = "Instructions:\n\n" +
"Your goal is to be the first player to get 3 X's or O's in a\n" +
"row. (horizontally, diagonally, or vertically)";
} else {
message = "About:\n\n" +
"Title: Tic-Tac-Toe\n" +
"Author: NickRafacz\n";

}
txtMessage.setEditable(false);
txtMessage.setText(message);
pnlS.setLayout(new GridLayout(2, 1, 2, 5));
pnlT.add(txtMessage);
pnlB.add(btnBack);
pnlS.add(pnlT);
pnlS.add(pnlB);
}
else if(source == btnBack) {
if(inGame)
showGame();
else {
clearPanelS();
pnlS.setLayout(new FlowLayout(FlowLayout.CENTER));
pnlN.setVisible(true);
pnlS.add(lblTitle);
}
}
pnlS.setVisible(false);
pnlS.setVisible(true);
}


/**
     *Displays the game.
     * 
     * 
     *  
     */
public void showGame() {

clearPanelS();
inGame = true;
pnlS.setLayout(new BorderLayout());
pnlS.add(pnlPlayingField, BorderLayout.CENTER);
pnlPlayingField.requestFocus();
}
/**
     * Checks if there are 3 symbols in a row vertically, diagonally, or horizontally.
     * Then shows a message and disables buttons.
     * 
     * 
     */
public void checkWin() {

for(int i=0; i<7; i++) {
if(
!btnEmpty[winCombo[i][0]].getText().equals("") &&
btnEmpty[winCombo[i][0]].getText().equals(btnEmpty[winCombo[i][1]].getText()) &&
// if {1 == 2 && 2 == 3}
btnEmpty[winCombo[i][1]].getText().equals(btnEmpty[winCombo[i][2]].getText())

) {
win = true;
wonNumber1 = winCombo[i][0];
wonNumber2 = winCombo[i][1];
wonNumber3 = winCombo[i][2];
btnEmpty[wonNumber1].setBackground(Color.white);
btnEmpty[wonNumber2].setBackground(Color.white);
btnEmpty[wonNumber3].setBackground(Color.white);
break;
}
}
if(win || (!win && turn>9)) {
if(win) {
if(turn % 2 == 0)
message = "X has won!";
else
message = "O has won!";
win = false;
} else if(!win && turn>9) {
message = "Both players have tied!\nBetter luck next time.";
}
JOptionPane.showMessageDialog(null, message);
for(int i=1; i<=9; i++) {
btnEmpty[i].setEnabled(false);
}
}
}
/**
     * Removes all the possible panels.
     * 
     * 
     */
public void clearPanelS() {

pnlS.remove(lblTitle);
pnlS.remove(pnlT);
pnlS.remove(pnlB);
pnlS.remove(pnlPlayingField);
pnlT.remove(pnlNewGame);
pnlT.remove(txtMessage);
pnlB.remove(btnBack);
}

public static void main(String[] args) {
new TicTacToe();// Calling the class construtor.
}
}