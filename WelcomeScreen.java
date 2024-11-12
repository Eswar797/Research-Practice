import javax.swing.*;
import java.awt.*;

public class WelcomeScreen extends JFrame {
    public WelcomeScreen() {
        setTitle("Welcome to Research Application Portal");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        JLabel welcomeLabel = new JLabel("Welcome to the RP Application Portal", SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 26));
        
        JButton proceedButton = new JButton("Proceed");
        proceedButton.setFont(new Font("SansSerif", Font.PLAIN, 18));
        proceedButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });

        JPanel panel = new JPanel(new BorderLayout());
        panel.add(welcomeLabel, BorderLayout.CENTER);
        panel.add(proceedButton, BorderLayout.SOUTH);
        
        add(panel);
        setVisible(true);
    }
}
