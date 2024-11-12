import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ProfessorDashboard extends JFrame {
    private String professorName;

    public ProfessorDashboard(String professorName) {
        this.professorName = professorName;
        System.out.println("Professor name in dashboard: " + this.professorName);  // Debug statement
        setTitle("Professor Dashboard - " + professorName);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        // Retrieve applications for the professor
        List<String[]> applications = ApplicationManager.getApplicationsForProfessor(professorName);
if (applications.isEmpty()) {
    panel.add(new JLabel("No applications available for " + professorName));
} else {
    for (String[] application : applications) {
        System.out.println("Displaying application for: " + application[1]);  // Debug statement

        JPanel appPanel = new JPanel(new BorderLayout(10, 10));

        // Application details
        String studentName = application[1];
        String email = application[2];
        String contact = application[3];
        String skills = application[4];
        String motivation = application[5];
        String status = application[6];

        JLabel detailsLabel = new JLabel("<html><b>Student:</b> " + studentName +
                "<br><b>Email:</b> " + email +
                "<br><b>Contact:</b> " + contact +
                "<br><b>Skills:</b> " + skills +
                "<br><b>Motivation:</b> " + motivation +
                "<br><b>Status:</b> " + status + "</html>");

        JButton acceptButton = new JButton("Accept");
        JButton rejectButton = new JButton("Reject");

        acceptButton.setEnabled(status.equals("Pending"));
        rejectButton.setEnabled(status.equals("Pending"));

        acceptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationManager.updateApplicationStatus(professorName, studentName, "Accepted");
                JOptionPane.showMessageDialog(ProfessorDashboard.this, "Application Accepted.");
                refreshDashboard();
            }
        });

        rejectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ApplicationManager.updateApplicationStatus(professorName, studentName, "Rejected");
                JOptionPane.showMessageDialog(ProfessorDashboard.this, "Application Rejected.");
                refreshDashboard();
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(acceptButton);
        buttonPanel.add(rejectButton);

        appPanel.add(detailsLabel, BorderLayout.CENTER);
        appPanel.add(buttonPanel, BorderLayout.EAST);

        panel.add(appPanel);
        panel.add(Box.createVerticalStrut(10));
    }
}


        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> {
            dispose();
            new LoginScreen();  // Return to login screen
        });
        
        add(logoutButton, BorderLayout.SOUTH);
        setVisible(true);
    }

    // Modify refreshDashboard to reload applications from file
    // Modify refreshDashboard to reload applications from file
    private void refreshDashboard() {
        // Clear the current content from the professor's dashboard
        getContentPane().removeAll();
    
        // Reload the applications for the professor
        List<String[]> applications = ApplicationManager.getApplicationsForProfessor(professorName);
    
        // Repopulate the panel with the updated list of applications
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
    
        for (String[] application : applications) {
            String studentName = application[1];
            String email = application[2];
            String contact = application[3];
            String skills = application[4];
            String motivation = application[5];
            String status = application[6];
    
            // Display application details
            JLabel detailsLabel = new JLabel("<html><b>Student:</b> " + studentName +
                    "<br><b>Email:</b> " + email +
                    "<br><b>Contact:</b> " + contact +
                    "<br><b>Skills:</b> " + skills +
                    "<br><b>Motivation:</b> " + motivation +
                    "<br><b>Status:</b> " + status + "</html>");
    
            JButton acceptButton = new JButton("Accept");
            JButton rejectButton = new JButton("Reject");
    
            // Enable buttons only if the status is "Pending"
            acceptButton.setEnabled(status.equals("Pending"));
            rejectButton.setEnabled(status.equals("Pending"));
    
            // Add event listeners to handle accept/reject actions
            acceptButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ApplicationManager.updateApplicationStatus(professorName, studentName, "Accepted");
                    JOptionPane.showMessageDialog(ProfessorDashboard.this, "Application Accepted.");
                    refreshDashboard();  // Refresh dashboard to reflect the update
                }
            });
    
            rejectButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    ApplicationManager.updateApplicationStatus(professorName, studentName, "Rejected");
                    JOptionPane.showMessageDialog(ProfessorDashboard.this, "Application Rejected.");
                    refreshDashboard();  // Refresh dashboard to reflect the update
                }
            });
    
            // Add the application details and action buttons to the panel
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(acceptButton);
            buttonPanel.add(rejectButton);
    
            panel.add(detailsLabel);
            panel.add(buttonPanel);
            panel.add(Box.createVerticalStrut(10));
        }
    
        JScrollPane scrollPane = new JScrollPane(panel);
        add(scrollPane, BorderLayout.CENTER);
    
        // Refresh the dashboard to display updated information
        validate();
        repaint();
    }
    
}
