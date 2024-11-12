import javax.swing.*;
import java.awt.*;

public class LoginScreen extends JFrame {
    public LoginScreen() {
        setTitle("Login");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2, 10, 10));
        
        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField();
        
        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordText = new JPasswordField();
        
        JButton loginButton = new JButton("Login");
        loginButton.addActionListener(e -> {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());
            
            // Check if the user is a student
            if (UserManager.isStudent(user, password)) {
                new StudentDashboard(user);
                dispose();
            }
            // Check if the user is a professor
            else if (UserManager.isProfessor(user, password)) {
                new ProfessorDashboard(user);
                dispose();
            }
            // If credentials are invalid
            else {
                JOptionPane.showMessageDialog(this, "Invalid login credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        panel.add(userLabel);
        panel.add(userText);
        panel.add(passwordLabel);
        panel.add(passwordText);
        panel.add(new JLabel()); // Empty label for spacing
        panel.add(loginButton);

        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
