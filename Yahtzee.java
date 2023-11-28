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

class GameGUI extends JFrame{
    private JFrame frame;
    
    private JPanel panel;
    private JPanel dicePanel;
    private JPanel diceRollPanel;
    private JPanel scorePanel;
    private JPanel titleButtonPanel;

    private JButton rollDice;
    private JButton rulesButton;
    private JButton startButton;
    private JButton backButton; 

    private JLabel iconLabel;

    private JEditorPane rulesPane;

    private JScrollPane scrollPane;

    //initializes all GUI components
    private void init(){
        /*Start Button and Rule Button*/
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(128, 0, 32));
  

        //create buttons
        rulesButton = new JButton("Rules");
        startButton = new JButton("Start Game");
 
        /*End Start Button and Rule Button*/

        /*Title Button Panel */
        titleButtonPanel = new JPanel();
        titleButtonPanel.setBackground(new Color(128,0, 32));
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

        /*Button Panel*/
        //Create new panel for buttons
        diceRollPanel = new JPanel();
        //style buttonPanel
        diceRollPanel.setBackground(new Color(34, 139, 34));
        //Create new panel for dice

        //roll dice button
        rollDice = new JButton("Roll Dice");

        // Add the buttons to the button panel
        diceRollPanel.add(rollDice);
        /*End Button Panel*/

        
    }
    public GameGUI(){
        // Create the frame
        frame = new JFrame("Yahtzee");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize the GUI components
        init();

        //load the title screen
        titleScreen();
    }

    private void titleScreen(){
        // Add the buttons to the button panel
        titleButtonPanel.add(startButton);
        titleButtonPanel.add(rulesButton);

        // Add the image
        panel.add(iconLabel, BorderLayout.NORTH);

        // Add the panels to the main panel
        panel.add(titleButtonPanel, BorderLayout.CENTER);

        // Add the panel to the frame
        frame.add(panel);

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Remove the title panel
            panel.remove(titleButtonPanel);
            panel.remove(iconLabel);
            // Start the game
            startGame();
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
                // Show the rules
                showRules();
                //redraw the panel
                frame.revalidate();
                panel.repaint();
           }
        });

    }

    private void startGame(){

        // Add the panel to the main panel
        panel.add(diceRollPanel, BorderLayout.SOUTH);

        //Add the back button
        backButton();


        // Add the panel to the frame
        frame.add(panel);

        //redraw the panel
        frame.revalidate();
        panel.repaint();
        
    }

    private void showRules(){
        //Initiate the panel
        rulesPane = new JEditorPane();
        rulesPane.setEditable(false);

        //load the rules
        try {
            //TODO: HYPERLINKS' CAN'T BE CLICKED

            rulesPane.setPage("https://grail.sourceforge.net/demo/yahtzee/rules.html"); 
        } catch (IOException e) {
            rulesPane.setContentType("text/html");
            rulesPane.setText("<html>Could not load rules</html>");
        }

        //create a scroll pane and add the rules to it
        scrollPane = new JScrollPane(rulesPane);

        //go back to the main menu
        backButton();

        panel.add(scrollPane, BorderLayout.CENTER);

    }

    //Back to the title screen
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