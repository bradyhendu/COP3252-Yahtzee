import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JPanel buttonPanel;
    private JPanel scorePanel;
    private JPanel titleButtonPanel;

    private JButton rollDice;
    private JButton rulesButton;
    private JButton startButton; 
    
    public GameGUI(){
        //initiate the frame
        frame = new JFrame("Yahtzee");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //initiate the panel
        panel = new JPanel(new BorderLayout());
        panel.setBackground(new Color(128, 0, 32));

        // Create buttons
        rulesButton = new JButton("Rules");
        startButton = new JButton("Start Game");


        // Create a new panel for the buttons
        titleButtonPanel = new JPanel();
        titleButtonPanel.setBackground(new Color(128,0, 32));

        // Add the buttons to the button panel
        titleButtonPanel.add(startButton);
        titleButtonPanel.add(rulesButton);

        // Add the panels to the main panel
        panel.add(titleButtonPanel, BorderLayout.CENTER);

        // Add the panel to the frame
        frame.add(panel);

        rulesButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               // Show the rules
               JOptionPane.showMessageDialog(panel, "Here are the rules...");
           }
        });
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            // Start the game
            startGame();
            }
        });

    }
    private void startGame(){
        // Remove the title panel
        panel.remove(titleButtonPanel);
        
        //Create new panel for buttons
        buttonPanel = new JPanel();
        //style buttonPanel
        buttonPanel.setBackground(new Color(34, 139, 34));
        //Create new panel for dice

        //roll dice button
        rollDice = new JButton("Roll Dice");

        // Add the buttons to the button panel
        buttonPanel.add(rollDice);

        // Add the panels to the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);


        // Add the panel to the frame
        frame.add(panel);
    }
    public void show(){
        // Show the frame
        frame.setVisible(true);
    }
}