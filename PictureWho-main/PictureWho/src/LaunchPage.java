import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LaunchPage implements ActionListener {

    public LaunchPage() {
        openGameWindow();
    }

    private void openGameWindow() {
        JFrame gameFrame = new JFrame("Game Window");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        gameFrame.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Placeholder image labels
        for (int i = 0; i < 4; i++) {
            JLabel imageLabel = new JLabel(new ImageIcon("delicious-burguer-isolated-white-background.png"));
            imagePanel.add(imageLabel);
        }

        JPanel answerPanel = new JPanel(new BorderLayout());
        mainPanel.add(answerPanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(300, 50)); 
        answerPanel.add(answerField, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAnswer = answerField.getText().trim().toLowerCase(); 
                String correctAnswer = "borger"; 

                if (enteredAnswer.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(gameFrame, "MATALINO KANG BATA KA!");
                    // openNextLevel(); // You may need to implement this method
                    gameFrame.dispose(); 
                } else {
                    JOptionPane.showMessageDialog(gameFrame, "BOBO MALI");
                }

                answerField.setText(""); 
            }
        });

        answerPanel.add(submitButton, BorderLayout.EAST);

        gameFrame.pack();
        gameFrame.setLocationRelativeTo(null);
        gameFrame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        openGameWindow();
    }

    public void openLaunchPage() {
        // Implement this method if needed
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new LaunchPage();
            }
        });
    }
}
