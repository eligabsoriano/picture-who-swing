import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class App extends JFrame {
    
    private JLabel imageLabel;
    private int currentLevel = 1;
    private LaunchPage launchpage; // Declare launchpage here

    public App() {
        setTitle("Picture Who");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000, 650);
        setResizable(false);
        getContentPane().setBackground(new Color(131, 101, 172));

        JPanel topPanel = new JPanel(new BorderLayout());

        JLabel pictureWhoLabel = new JLabel("PICTURE WHO?");
        pictureWhoLabel.setHorizontalAlignment(JLabel.CENTER);
        pictureWhoLabel.setFont(new Font("Segoe UI", Font.BOLD, 33));
        pictureWhoLabel.setForeground(Color.WHITE);
        pictureWhoLabel.setOpaque(true);
        pictureWhoLabel.setBackground(Color.decode("#5E4580"));
        topPanel.add(pictureWhoLabel, BorderLayout.NORTH);

        ImageIcon icon = new ImageIcon("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        imageLabel = new JLabel(icon);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setOpaque(true);
        imageLabel.setBackground(Color.decode("#5E4580"));
        imageLabel.setVerticalAlignment(JLabel.BOTTOM);
        topPanel.add(imageLabel, BorderLayout.CENTER);

        // Add the top panel to the frame
        add(topPanel, BorderLayout.CENTER);

        // Create buttons panel
        JPanel buttonPanel = new JPanel(new BorderLayout());
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        buttonPanel.setBackground(Color.decode("#5E4580"));

        // Play button
        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        playButton.setForeground(Color.decode("#5E4580"));
        playButton.setBackground(Color.WHITE);
        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(App.this, "Starting the game...");
                openGameWindow();
                dispose();
            }
        });

        // Exit button
        JButton exitButton = new JButton("Exit");
        exitButton.setFont(new Font("Segoe UI Black", Font.PLAIN, 24));
        exitButton.setForeground(Color.decode("#5E4580"));
        exitButton.setBackground(Color.WHITE);
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int choice = JOptionPane.showConfirmDialog(App.this, "Are you sure you want to exit?", "Exit", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        // Add buttons to button panel
        buttonPanel.add(playButton, BorderLayout.WEST);
        buttonPanel.add(exitButton, BorderLayout.EAST);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void openGameWindow() {
        JFrame gameFrame = new JFrame("Game Window");
        gameFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        gameFrame.setSize(1000, 600);

        JPanel mainPanel = new JPanel(new BorderLayout());
        gameFrame.getContentPane().add(mainPanel);

        JPanel imagePanel = new JPanel(new GridLayout(2, 2));
        mainPanel.add(imagePanel, BorderLayout.CENTER);

        // Load images into ImageIcons
        ImageIcon image1 = new ImageIcon("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageIcon image2 = new ImageIcon("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageIcon image3 = new ImageIcon("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");
        ImageIcon image4 = new ImageIcon("Bone White Blue Groovy You Matter Desktop Wallpaper (1).png");

        // Create JLabels and set the icons
        JLabel imageLabel1 = new JLabel(image1);
        JLabel imageLabel2 = new JLabel(image2);
        JLabel imageLabel3 = new JLabel(image3);
        JLabel imageLabel4 = new JLabel(image4);

        // Add labels to the imagePanel
        imagePanel.add(imageLabel1);
        imagePanel.add(imageLabel2);
        imagePanel.add(imageLabel3);
        imagePanel.add(imageLabel4);

        JPanel answerPanel = new JPanel(new BorderLayout());
        mainPanel.add(answerPanel, BorderLayout.SOUTH);

        JTextField answerField = new JTextField();
        answerField.setPreferredSize(new Dimension(300, 50)); // Set preferred size
        answerPanel.add(answerField, BorderLayout.CENTER);

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String enteredAnswer = answerField.getText().trim().toLowerCase(); // Normalize the input
                String correctAnswer = "missing person"; // Replace this with the actual correct answer

                if (enteredAnswer.equals(correctAnswer)) {
                    JOptionPane.showMessageDialog(gameFrame, "MATALINO KANG BATA KA!");
                    openNextLevel();
                    gameFrame.dispose(); // Close current game window
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

    private void openNextLevel() {
        currentLevel++;
        JOptionPane.showMessageDialog(this, "Proceed to next level bro bro ");
        
        launchpage = new LaunchPage(); 
        launchpage.openLaunchPage();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                App game = new App();
                game.setVisible(true);
            }
        });
    }
}
