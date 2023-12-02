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


    /*Score Ones*/
    public int scoreOnes(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 1){
                score += 1;
            }
        }
        return score;
    }

    /*Score Twos*/
        public int scoreTwos(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 2){
                score += 2;
            }
        }
        return score;
    }

    /*Score Threes*/
        public int scoreThrees(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 3){
                score += 3;
            }
        }
        return score;
    }
    /*Score fours*/
        public int scoreFours(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 4){
                score += 4;
            }
        }
        return score;
    }
    /*Score fives*/
        public int scoreFives(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 5){
                score += 5;
            }
        }
        return score;
    }
    /*Score sixes*/
        public int scoreSixes(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            if(diceValues[i] == 6){
                score += 6;
            }
        }
        return score;
    }
    /*Score three of a kind*/
        public int scoreThreeOfAKind(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        for(int i = 0; i < 6; i++){
            if(diceCount[i] >= 3){
                for(int j = 0; j < 5; j++){
                    score += diceValues[j];
                }
            }
        }
        return score;
    }
    /*Score four of a kind*/
        public int scoreFourOfAKind(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        for(int i = 0; i < 6; i++){
            if(diceCount[i] >= 4){
                for(int j = 0; j < 5; j++){
                    score += diceValues[j];
                }
            }
        }
        return score;
    }
    /*Score full house*/
        public int scoreFullHouse(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        boolean threeOfAKind = false;
        boolean twoOfAKind = false;
        for(int i = 0; i < 6; i++){
            if(diceCount[i] == 3){
                threeOfAKind = true;
            }
            if(diceCount[i] == 2){
                twoOfAKind = true;
            }
        }
        if(threeOfAKind == true && twoOfAKind == true){
            score = 25;
        }
        return score;
    }
    /*Score small straight*/
        public int scoreSmallStraight(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(diceCount[i] >= 1){
                count++;
            }
        }
        if(count >= 4){
            score = 30;
        }
        return score;
    }
    /*Score large straight*/
        public int scoreLargeStraight(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        int count = 0;
        for(int i = 0; i < 6; i++){
            if(diceCount[i] >= 1){
                count++;
            }
        }
        if(count == 5){
            score = 40;
        }
        return score;
    }
    /*Score yahtzee*/
        public int scoreYahtzee(int[] diceValues){
        int score = 0;
        int[] diceCount = new int[6];
        for(int i = 0; i < 5; i++){
            diceCount[diceValues[i] - 1]++;
        }
        for(int i = 0; i < 6; i++){
            if(diceCount[i] == 5){
                score = 50;
            }
        }
        return score;
    }
    /*Score chance*/
        public int scoreChance(int[] diceValues){
        int score = 0;
        for(int i = 0; i < 5; i++){
            score += diceValues[i];
        }
        return score;
    }


    /*Total Score Calculation */
    public int totalScore(int[] scoreValues){
        int total = 0;
        for(int i = 0; i < 13; i++){
            total += scoreValues[i];
            //bonus
            if(i == 5 && total >= 63){
                total += 35;
            }
        }

        //TODO: YAHTZEE BONUS
        
        return total;
    }
        
}

class Game extends JFrame{
    //Variables
    private int[] diceValues = new int[5]; //for dice values
    private boolean[] diceRolling = new boolean[5]; //for toggle buttons
    private int rollCount = 0; //for roll count
    private Random rand = new Random(); //for random number generation
    private int[] scoreValues = new int[13]; //for score values
    private int turns = 0; //for turns

    private boolean[] scoreButtons = new boolean[13]; //for score buttons




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

    private JButton onesButton;
    private JButton twosButton;
    private JButton threesButton;
    private JButton foursButton;
    private JButton fivesButton;
    private JButton sixesButton;
    private JButton threeOfAKindButton;
    private JButton fourOfAKindButton;
    private JButton fullHouseButton;
    private JButton smallStraightButton;
    private JButton largeStraightButton;
    private JButton yahtzeeButton;
    private JButton chanceButton;

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
        startButton = new JButton("Play Game");

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
                    toggleScoreButtonsOn();
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

                if(rollCount == 3){
                    rollDice.setEnabled(false);
                    //Set Text of Roll Dice Button
                    rollDice.setText("No Rolls Left, Score Roll");
                }

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
                //reset the dice values
                for(int i = 0; i < 5; i++){
                    dice[i].removeAll();
                    dice[i].add(new JLabel(diceFaces[0]));
                    diceValues[i] = 1;
                }

                //reset the score values
                for(int i = 0; i < 13; i++){
                    scoreValues[i] = 0;
                }

                //create a new score object
                score = new ScoreLogic();

                //reset the score buttons text 
                onesButton.setText("Score");
                twosButton.setText("Score");
                threesButton.setText("Score");
                foursButton.setText("Score");
                fivesButton.setText("Score");
                sixesButton.setText("Score");
                threeOfAKindButton.setText("Score");
                fourOfAKindButton.setText("Score");
                fullHouseButton.setText("Score");
                smallStraightButton.setText("Score");
                largeStraightButton.setText("Score");
                yahtzeeButton.setText("Score");
                chanceButton.setText("Score");

                //reset turns
                turns = 0;

                //reset score button boolean values
                for(int i = 0; i < 13; i++){
                    scoreButtons[i] = false;
                }

                handleEndTurn();
            }
        });
        /*End Reset Game Button*/

        // Add the buttons to the button panel
        diceRollPanel.add(rollDice);
        diceRollPanel.add(resetGameButton);
        /*End Dice Roll Panel*/

        /*Score Panel*/
        scorePanel = new JPanel(new GridLayout(0, 2));

        // Create the labels and buttons
        JLabel onesLabel = new JLabel("Ones");
        onesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        onesButton = new JButton("Score");

        JLabel twosLabel = new JLabel("Twos");
        twosLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        twosButton = new JButton("Score");

        JLabel threesLabel = new JLabel("Threes");
        threesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        threesButton = new JButton("Score");

        JLabel foursLabel = new JLabel("Fours");
        foursLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        foursButton = new JButton("Score");

        JLabel fivesLabel = new JLabel("Fives");
        fivesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fivesButton = new JButton("Score");

        JLabel sixesLabel = new JLabel("Sixes");
        sixesLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        sixesButton = new JButton("Score");

        JLabel threeOfAKindLabel = new JLabel("Three of a Kind");
        threeOfAKindLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        threeOfAKindButton = new JButton("Score");

        JLabel fourOfAKindLabel = new JLabel("Four of a Kind");
        fourOfAKindLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fourOfAKindButton = new JButton("Score");

        JLabel fullHouseLabel = new JLabel("Full House");
        fullHouseLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        fullHouseButton = new JButton("Score");

        JLabel smallStraightLabel = new JLabel("Small Straight");
        smallStraightLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        smallStraightButton = new JButton("Score");

        JLabel largeStraightLabel = new JLabel("Large Straight");
        largeStraightLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        largeStraightButton = new JButton("Score");

        JLabel yahtzeeLabel = new JLabel("Yahtzee");
        yahtzeeLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        yahtzeeButton = new JButton("Score");

        JLabel chanceLabel = new JLabel("Chance");
        chanceLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        chanceButton = new JButton("Score");

        // Add action listeners to buttons, calls the score method from game logic
        onesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[0] = score.scoreOnes(diceValues);

                //change the text of the button to the score
                onesButton.setText(Integer.toString(scoreValues[0]));

                //disable the buttons
                scoreButtons[0] = true;

                //increment turns
                turns++;

                handleEndTurn();
            }
        });

        twosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[1] = score.scoreTwos(diceValues);

                //change the text of the button to the score
                twosButton.setText(Integer.toString(scoreValues[1]));

                //disable the buttons
                scoreButtons[1] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        threesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[2] = score.scoreThrees(diceValues);

                //change the text of the button to the score
                threesButton.setText(Integer.toString(scoreValues[2]));

                //disable the buttons
                scoreButtons[2] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        foursButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[3] = score.scoreFours(diceValues);

                //change the text of the button to the score
                foursButton.setText(Integer.toString(scoreValues[3]));

                //disable the buttons
                scoreButtons[3] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        fivesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[4] = score.scoreFives(diceValues);

                //change the text of the button to the score
                fivesButton.setText(Integer.toString(scoreValues[4]));

                //disable the buttons
                scoreButtons[4] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        sixesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[5] = score.scoreSixes(diceValues);

                //change the text of the button to the score
                sixesButton.setText(Integer.toString(scoreValues[5]));

                //disable the buttons
                scoreButtons[5] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        threeOfAKindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[6] = score.scoreThreeOfAKind(diceValues);

                //change the text of the button to the score
                threeOfAKindButton.setText(Integer.toString(scoreValues[6]));

                //disable the buttons
                scoreButtons[6] = true;

                //increment turns
                turns++;

                handleEndTurn();

            
            }
        });

        fourOfAKindButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[7] = score.scoreFourOfAKind(diceValues);

                //change the text of the button to the score
                fourOfAKindButton.setText(Integer.toString(scoreValues[7]));

                //disable the buttons
                scoreButtons[7] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        fullHouseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[8] = score.scoreFullHouse(diceValues);

                //change the text of the button to the score
                fullHouseButton.setText(Integer.toString(scoreValues[8]));

                //disable the buttons
                scoreButtons[8] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        smallStraightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[9] = score.scoreSmallStraight(diceValues);

                //change the text of the button to the score
                smallStraightButton.setText(Integer.toString(scoreValues[9]));

                //disable the buttons
                scoreButtons[9] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        largeStraightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[10] = score.scoreLargeStraight(diceValues);

                //change the text of the button to the score
                largeStraightButton.setText(Integer.toString(scoreValues[10]));

                //disable the buttons
                scoreButtons[10] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
            }
        });

        yahtzeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    
                    //add the score to the scoreValues array
                    scoreValues[11] = score.scoreYahtzee(diceValues);
    
                    //change the text of the button to the score
                    yahtzeeButton.setText(Integer.toString(scoreValues[11]));
    
                    //disable the buttons
                    scoreButtons[11] = true;
    
                    //increment turns
                    turns++;
    
                    handleEndTurn();
            
            }
        });

        chanceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //add the score to the scoreValues array
                scoreValues[12] = score.scoreChance(diceValues);

                //change the text of the button to the score
                chanceButton.setText(Integer.toString(scoreValues[12]));

                //disable the buttons
                scoreButtons[12] = true;

                //increment turns
                turns++;

                handleEndTurn();
            
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

        //disable the buttons
        toggleScoreButtonsOff();
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
        diceWrapper.setBorder(new EmptyBorder(400, 50, 0, 50)); // top, left, bottom, right
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

    //Toggle Score Buttons to unclickable
    private void toggleScoreButtonsOff(){
        onesButton.setEnabled(false);
        twosButton.setEnabled(false);
        threesButton.setEnabled(false);
        foursButton.setEnabled(false);
        fivesButton.setEnabled(false);
        sixesButton.setEnabled(false);
        threeOfAKindButton.setEnabled(false);
        fourOfAKindButton.setEnabled(false);
        fullHouseButton.setEnabled(false);
        smallStraightButton.setEnabled(false);
        largeStraightButton.setEnabled(false);
        yahtzeeButton.setEnabled(false);
        chanceButton.setEnabled(false);
    }

    //Toggle Score Buttons to clickable
    private void toggleScoreButtonsOn(){
        if(scoreButtons[0] == false){
            onesButton.setEnabled(true);
        }
        if(scoreButtons[1] == false){
            twosButton.setEnabled(true);
        }
        if(scoreButtons[2] == false){
            threesButton.setEnabled(true);
        }
        if(scoreButtons[3] == false){
            foursButton.setEnabled(true);
        }
        if(scoreButtons[4] == false){
            fivesButton.setEnabled(true);
        }
        if(scoreButtons[5] == false){
            sixesButton.setEnabled(true);
        }
        if(scoreButtons[6] == false){
            threeOfAKindButton.setEnabled(true);
        }
        if(scoreButtons[7] == false){
            fourOfAKindButton.setEnabled(true);
        }
        if(scoreButtons[8] == false){
            fullHouseButton.setEnabled(true);
        }
        if(scoreButtons[9] == false){
            smallStraightButton.setEnabled(true);
        }
        if(scoreButtons[10] == false){
            largeStraightButton.setEnabled(true);
        }
        if(scoreButtons[11] == false){
            yahtzeeButton.setEnabled(true);
        }
        if(scoreButtons[12] == false){
            chanceButton.setEnabled(true);
        }
    }

    //Handle Buttons on Scoring or Reset
    private void handleEndTurn(){
        toggleScoreButtonsOff();

        //reset the roll count
        rollCount = 0;

        //toggle the toggle buttons off
        for(int i = 0; i < 5; i++){
            toggleButtons[i].setSelected(false);
            toggleButtons[i].setEnabled(false);
            diceRolling[i] = false;
        }

        //reset the roll dice button
        rollDice.setEnabled(true);
        rollDice.setText("Roll Dice");

        //check if the game is over
        if(turns == 13){
            //calculate the total score
            int total = score.totalScore(scoreValues);

            //display the total score
            JOptionPane.showMessageDialog(frame, "Game Over! Your Total Score is: " + total, "Game Over", JOptionPane.PLAIN_MESSAGE);
            
        }

        //redraw the panel
        frame.revalidate();
        panel.repaint();
    }

}