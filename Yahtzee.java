import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import java.util.Random;




public class Yahtzee{
    public static void main(String[] args) {
        Game game = new Game();
        game.show();
    }
}

class ScoreLogic{

    //TODO: IMPLEMENT SCORE CALCULATION
    /*Score Calculation */

    /*End Score Calculation*/    
}

class Game extends JFrame{
    //Variables
    private int[] diceValues = new int[5]; //for dice values
    private boolean[] diceRolling = new boolean[5]; //for toggle buttons
    private int rollCount = 0; //for roll count
    private Random rand = new Random(); //for random number generation



    //GUI COMPONENTS
    private JFrame frame;
    
    private JPanel panel;
    private JPanel dicePanel;
    private JPanel diceWrapper;
    private JPanel diceRollPanel;
    private JPanel scorePanel;
    private JPanel titleButtonPanel;
    private JPanel backButtonPanel;
    private JPanel[] dice;

    private JButton rollDice;
    private JButton rulesButton;
    private JButton startButton;
    private JButton backButton; 
    private JButton resetGameButton;



    private JToggleButton[] toggleButtons;

    private JLabel iconLabel;

    private JEditorPane rulesPanel;

    private JScrollPane scrollPanel;

    //Dice Faces
    private ImageIcon[] diceFaces;

    private Color green = new Color(34, 139, 34);
    private Color red = new Color(128, 0, 32);

    //GAME LOGIC OBJECT
    private ScoreLogic score = new ScoreLogic();

    /*
    * Initializes the GUI components so they are abled to be used in the program
    */
    private void init(){
        /*Frame*/
        frame = new JFrame("Yahtzee");
        frame.setSize(1000, 800);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        /*End Frame*/

        /*Main Panel*/
        panel = new JPanel(new BorderLayout());
        panel.setBackground(red);
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
        titleButtonPanel.setBackground(red);

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
            iconLabel.setBorder(new EmptyBorder(150, 0, 0, 0)); // top, left, bottom, right
        } catch (IOException e) {
           e.printStackTrace();
        }
        /*End Image Label*/

        /*Dice Faces*/
        diceFaces = new ImageIcon[6];
        for(int i = 0; i < 6; i++){
            //Read the image file as follows: dice-i.png where i is the current index
            try {
                File imageFile = new File("dice-" + (i + 1) + ".png");
                BufferedImage originalImage = ImageIO.read(imageFile);

                Image image = originalImage.getScaledInstance(75, 75, Image.SCALE_DEFAULT);

                // Create an ImageIcon
                diceFaces[i] = new ImageIcon(image);

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*End Dice Faces*/

        /*Dice Roll Panel*/
        diceRollPanel = new JPanel();
        //style buttonPanel
        diceRollPanel.setBackground(green);
        diceRollPanel.setBorder(new EmptyBorder(10, 0, 10, 0)); // top, left, bottom, right
        /*End Dice Roll Panel*/
        

        /*Roll Dice Button*/
        rollDice = new JButton("Roll Dice");
        rollDice.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //When the dice is rolled for the first time, enable the toggle buttons
                if(rollCount == 0){
                    for(int i = 0; i < 5; i++){
                        toggleButtons[i].setEnabled(true);
                    }
                }

                //Change the dice values
                for(int i = 0; i < 5; i++){
                    if(diceRolling[i] == false){
                        //remove previus dice face
                        dice[i].removeAll();
                        diceValues[i] = rand.nextInt(6) + 1;
                        dice[i].add(new JLabel(diceFaces[diceValues[i] - 1]));
                    }
                }

                rollCount++;

                /*if(rollCount == 3){
                    rollDice.setEnabled(false);
                }*/

                //redraw the panel
                frame.revalidate();
                panel.repaint();
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
        scorePanel = new JPanel(new GridLayout(0, 2));
        //set size of score panel
        scorePanel.setPreferredSize(new Dimension(175, 175));

        // Create the labels and buttons
        JLabel onesLabel = new JLabel("Ones");
        JButton onesButton = new JButton("Score");

        JLabel twosLabel = new JLabel("Twos");
        JButton twosButton = new JButton("Score");

        JLabel threesLabel = new JLabel("Threes");
        JButton threesButton = new JButton("Score");

        JLabel foursLabel = new JLabel("Fours");
        JButton foursButton = new JButton("Score");

        JLabel fivesLabel = new JLabel("Fives");
        JButton fivesButton = new JButton("Score");

        JLabel sixesLabel = new JLabel("Sixes");
        JButton sixesButton = new JButton("Score");

        JLabel threeOfAKindLabel = new JLabel("Three of a Kind");
        JButton threeOfAKindButton = new JButton("Score");

        JLabel fourOfAKindLabel = new JLabel("Four of a Kind");
        JButton fourOfAKindButton = new JButton("Score");

        JLabel fullHouseLabel = new JLabel("Full House");
        JButton fullHouseButton = new JButton("Score");

        JLabel smallStraightLabel = new JLabel("Small Straight");
        JButton smallStraightButton = new JButton("Score");

        JLabel largeStraightLabel = new JLabel("Large Straight");
        JButton largeStraightButton = new JButton("Score");

        JLabel yahtzeeLabel = new JLabel("Yahtzee");
        JButton yahtzeeButton = new JButton("Score");

        JLabel chanceLabel = new JLabel("Chance");
        JButton chanceButton = new JButton("Score");

        // Add action listeners to buttons, calls the score method from game logic
        onesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        twosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        threesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        foursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        fivesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        sixesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        threeOfAKindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        fourOfAKindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        fullHouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        smallStraightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        largeStraightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        yahtzeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        chanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            
            }
        });

        // Add the labels and buttons to the score panel
        scorePanel.add(onesLabel);
        scorePanel.add(onesButton);

        scorePanel.add(twosLabel);
        scorePanel.add(twosButton);

        scorePanel.add(threesLabel);
        scorePanel.add(threesButton);

        scorePanel.add(foursLabel);
        scorePanel.add(foursButton);

        scorePanel.add(fivesLabel);
        scorePanel.add(fivesButton);

        scorePanel.add(sixesLabel);
        scorePanel.add(sixesButton);

        scorePanel.add(threeOfAKindLabel);
        scorePanel.add(threeOfAKindButton);

        scorePanel.add(fourOfAKindLabel);
        scorePanel.add(fourOfAKindButton);

        scorePanel.add(fullHouseLabel);
        scorePanel.add(fullHouseButton);

        scorePanel.add(smallStraightLabel);
        scorePanel.add(smallStraightButton);

        scorePanel.add(largeStraightLabel);
        scorePanel.add(largeStraightButton);

        scorePanel.add(yahtzeeLabel);
        scorePanel.add(yahtzeeButton);

        scorePanel.add(chanceLabel);
        scorePanel.add(chanceButton);
        /*End Score Panel*/

        /*Dice*/
        dice = new JPanel[5];
        /*End Dice*/
        
        /*Toggle Buttons*/
        toggleButtons = new JToggleButton[5];
        /*End Toggle Buttons*/

        /*Dice Panel*/
        dicePanel = new JPanel(new GridLayout(2, 5, 15, 15));
        dicePanel.setBackground(red);
        dicePanel.setSize(new Dimension(200, 200));

        
         for (int i = 0; i < 5; i++) {
            dice[i] = new JPanel();
            dice[i].setBackground(red);
            dice[i].add(new JLabel(diceFaces[i]));
            dicePanel.add(dice[i]);
        }

        for (int i = 0; i < 5; i++) {
            final int index = i;
            toggleButtons[index] = new JToggleButton("Stop Rolling");
            toggleButtons[index].setForeground(Color.BLACK); // Set text color
            toggleButtons[index].setPreferredSize(new Dimension(125, 25)); // Set background color

            if(rollCount == 0){
                toggleButtons[index].setEnabled(false);
            }

            // Add action listener to button
            toggleButtons[index].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //when the button is clicked, toggle the boolean value
                    diceRolling[index] = !diceRolling[index];
                }
            });


            dicePanel.add(toggleButtons[index]);
        }
        /*End Dice Panel*/

        /*Dice Wrapper*/
        //The purpose of this wrapper is to give the dice panel a border with better sizing
        diceWrapper = new JPanel();
        diceWrapper.setBackground(red);
        diceWrapper.setBorder(new EmptyBorder(400, 50, 10, 50)); // top, left, bottom, right
        //change size to fit the dice panel
        diceWrapper.setPreferredSize(new Dimension(500, 500));
        diceWrapper.add(dicePanel);
        /*End Dice Wrapper*/


        /*Back Button*/
        backButton = new JButton("Back to Main Menu");
        //add action listener to button
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //remove all components from the panel
                panel.removeAll();

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
        backButtonPanel.setBackground(green);

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
    public Game(){
        init(); // Initialize the GUI components
        mainMenu();//load the title screen

        // Add the panel to the frame
        frame.add(panel);
    }

    /*
     * Loads the different screens of the game to the Frane
     */

    //Starts the game
    private void gameScreen(){
        //Panel Components
        panel.add(diceRollPanel, BorderLayout.SOUTH); // Add the dice roll panel to the main panel

        panel.add(backButtonPanel, BorderLayout.NORTH); //add the back button to the panel

        panel.add(diceWrapper, BorderLayout.CENTER); // Add the dice panel to the main panel

        panel.add(scorePanel, BorderLayout.EAST); // Add the score panel to the main panel

        // Add the panel to the frame
        frame.add(panel); 

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
        // Show the frame at center
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}