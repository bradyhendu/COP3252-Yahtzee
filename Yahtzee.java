import javax.swing.*;
import java.awt.*;

public class Yahtzee extends JFrame{

    public Yahtzee() {
        // Create a new JFrame
        JFrame frame = new JFrame("Yahtzee");
        JPanel panel = new JPanel(new BorderLayout());
        // Set the size of the frame
        frame.setSize(800, 600);
        //not resizeable
        frame.setResizable(false);
        // Set the frame to close when the user clicks the X button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //Create new panel for buttons
        JPanel buttonPanel = new JPanel();
        //Create new panel for dice
        JPanel dicePanel = new JPanel();
        //Create new panel for scorecard
        JPanel scorecardPanel = new JPanel();

        //Create roll dice button
        JButton rollDice = new JButton("Roll Dice");

        // Add the buttons to the button panel
        buttonPanel.add(rollDice);

        // Add the panels to the main panel
        panel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.add(panel);
        // Make the frame visible
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Yahtzee();
    }
}
