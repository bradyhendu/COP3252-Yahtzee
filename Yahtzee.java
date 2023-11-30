import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.border.EmptyBorder;



public class Yahtzee{
    public static void main(String[] args) {
        GameGUI gameGUI = new GameGUI();
        gameGUI.show();
    }
}

class GameLogic{

    //TODO: IMPLEMENT SCORE CALCULATION
    /*Score Calculation */

    /*End Score Calculation*/    
}

class GameGUI extends JFrame{
    private JFrame frame;
    
    private JPanel panel;
    private JPanel dicePanel;
    private JPanel diceRollPanel;
    private JPanel scorePanel;
    private JPanel titleButtonPanel;
    private JPanel backButtonPanel;

    private JButton rollDice;
    private JButton rulesButton;
    private JButton startButton;
    private JButton backButton; 
    private JButton resetGameButton;

    private JLabel iconLabel;

    private JEditorPane rulesPanel;

    private JScrollPane scrollPanel;

    //GAME LOGIC OBJECT
    private GameLogic game = new GameLogic();

    /*
    * Initializes the GUI components so they are abled to be used in the program
    */
    private void init(){
        /*Frame*/
        frame = new JFrame("Yahtzee");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*End Frame*/

        /*Main Panel*/
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(128, 0, 32));
        /*End Main Panel*/
  

        /* Start Button and Rule Button*/
        rulesButton = new JButton("Rules");
        startButton = new JButton("Start Game");

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Remove the title panel
            panel.remove(titleButtonPanel);
            panel.remove(iconLabel);
            // Start the game
            gameScreen();
            //redraw the panel
            frame.revalidate();
            panel.repaint();

            }
        });

        rulesButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
                // Remove the title panel
                panel.remove(titleButtonPanel);
                panel.remove(iconLabel);

                // Add the scroll pane for rules page
                panel.add(scrollPanel, BorderLayout.CENTER);
                // Add the back button for rules page
                panel.add(backButtonPanel, BorderLayout.NORTH);

                //redraw the panel
                frame.revalidate();
                panel.repaint();
           }
        });
        /*End Start Button and Rule Button*/

        /*Title Button Panel */
        titleButtonPanel = new JPanel();
        titleButtonPanel.setBackground(new Color(128,0, 32));

        // Add the buttons to the button panel
        titleButtonPanel.add(startButton);
        titleButtonPanel.add(rulesButton);
        /*End Title Button Panel */

        /*Image Label*/
        try {
           // Read the image file
           File imageFile = new File("Yahtzee-logo.png");
           BufferedImage originalImage = ImageIO.read(imageFile);

           Image image = originalImage.getScaledInstance(600, 400, Image.SCALE_DEFAULT);

           // Create an ImageIcon
           ImageIcon icon = new ImageIcon(image);

            // Create a label with the image 
            iconLabel = new JLabel(icon);
            // Add padding to the top of the image
            iconLabel.setBorder(new EmptyBorder(50, 0, 0, 0)); // top, left, bottom, right
        } catch (IOException e) {
           e.printStackTrace();
        }
        /*End Image Label*/

        /*Dice Roll Panel*/
        diceRollPanel = new JPanel();
        //style buttonPanel
        diceRollPanel.setBackground(new Color(34, 139, 34));
        diceRollPanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // top, left, bottom, right
        

        /*Roll Dice Button*/
        rollDice = new JButton("Roll Dice");
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: IMPLEMENT ROLL DICE BUTTON
            }
        });
        /*End Roll Dice Button*/

        /*Reset Game Button*/
        resetGameButton = new JButton("Restart Game");
        resetGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO: IMPLEMENT RESET GAME BUTTON
            }
        });
        /*End Reset Game Button*/

        // Add the buttons to the button panel
        diceRollPanel.add(rollDice);
        diceRollPanel.add(resetGameButton);
        /*End Dice Roll Panel*/

        /*Score Panel*/
        scorePanel = new JPanel();
        //TODO: IMPLEMENT SCORE PANEL
        /*End Score Panel*/

        /*Dice Panel*/
        dicePanel = new JPanel();
        //TODO: IMPLEMENT DICE PANEL 
        /*End Dice Panel*/


        /*Back Button*/
        backButton = new JButton("Back to Main Menu");
        //add action listener to button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove the scroll pane
                panel.remove(scrollPanel);
                panel.remove(backButtonPanel);
                //remove the dice roll panel
                panel.remove(diceRollPanel);

                // Go back to the main menu
                mainMenu();
                //redraw the panel
                frame.revalidate();
                panel.repaint();
            }
        });
        /*End Back Button*/

        /*Back Button Panel*/

        backButtonPanel = new JPanel();

        //style buttonPanel
        backButtonPanel.setBackground(new Color(34, 139, 34));

        // Add the buttons to the button panel
        backButtonPanel.add(backButton);
        /*End Back Button Panel*/

        /*Rules Panel*/
        rulesPanel = new JEditorPane();
        rulesPanel.setEditable(false);

        //load the rules
        try {
            //TODO: HYPERLINKS' CAN'T BE CLICKED

            rulesPanel.setPage("https://grail.sourceforge.net/demo/yahtzee/rules.html"); 
        } catch (IOException e) {
            rulesPanel.setContentType("text/html");
            rulesPanel.setText("<html>Could not load rules</html>");
        }
        /*End Rules Panel*/

        /*Scroll Pane */
        scrollPanel = new JScrollPane(rulesPanel);
        /*End Scroll Pane*/


    }
    public GameGUI(){
        init(); // Initialize the GUI components
        titleScreen();//load the title screen
    }

    /*
     * Loads the different screens of the game to the Frane
     */
    //Loads the title screen
    private void titleScreen(){
        panel.add(iconLabel, BorderLayout.NORTH); // Add the image

        panel.add(titleButtonPanel, BorderLayout.CENTER); // Add the panels to the main panel

        frame.add(panel); // Add the panel to the frame
    }

    //Starts the game
    private void gameScreen(){
        panel.add(diceRollPanel, BorderLayout.SOUTH); // Add the dice roll panel to the main panel

        panel.add(backButtonPanel, BorderLayout.NORTH); //add the back button to the panel

        frame.add(panel); // Add the panel to the frame

        //TODO: ADD COMPLETED DICE PANEL AND SCORE PANEL TO THE MAIN PANEL

        //redraw the panel
        frame.revalidate();
        panel.repaint();
    }

    //Loads the main menu
    private void mainMenu(){
        panel.add(titleButtonPanel, BorderLayout.CENTER);
        panel.add(iconLabel, BorderLayout.NORTH);

        //redraw the panel
        frame.revalidate();
        panel.repaint();
    }

    public void show(){
        // Show the frame
        frame.setVisible(true);
    }
}