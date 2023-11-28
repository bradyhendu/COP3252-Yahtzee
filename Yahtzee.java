import javax.swing.*;

public class Yahtzee extends JFrame{

    public Yahtzee() {
        // Create a new JFrame
        JFrame frame = new JFrame("Yahtzee");
        // Set the size of the frame
        frame.setSize(800, 600);
        //not resizeable
        frame.setResizable(false);
        // Set the frame to close when the user clicks the X button
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Create a new JPanel
        JPanel panel = new JPanel();
        // Add the panel to the frame
        frame.add(panel);
        // Make the frame visible
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        new Yahtzee();
    }
}
