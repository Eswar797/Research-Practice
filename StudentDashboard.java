import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDashboard extends JFrame {
    private String username;
    
    public StudentDashboard(String username) {
        this.username = username;
        
        setTitle("Student Dashboard");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Welcome, " + username, SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 24));
        
        JButton viewProfessorsButton = new JButton("View Professors and Apply");
        viewProfessorsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new ProfessorList();
            }
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            new LoginScreen();
            dispose();
        });
        
        JPanel panel = new JPanel(new GridLayout(3, 1, 10, 10));
        panel.add(welcomeLabel);
        panel.add(viewProfessorsButton);
        panel.add(logoutButton);
        
        add(panel, BorderLayout.CENTER);
        setVisible(true);
    }
}
