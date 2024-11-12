import javax.swing.*;
import java.awt.*;

public class ApplicationForm extends JFrame {
    private String professorName;

    public ApplicationForm(String professorName) {
        this.professorName = professorName;
        setTitle("Application Form - " + professorName);
        setSize(500, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 10, 10));

        JTextField nameField = new JTextField();
        JTextField emailField = new JTextField();
        JTextField contactField = new JTextField();
        JTextField skillsField = new JTextField();
        JTextArea motivationArea = new JTextArea();

        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Email:"));
        panel.add(emailField);
        panel.add(new JLabel("Contact Number:"));
        panel.add(contactField);
        panel.add(new JLabel("Skills:"));
        panel.add(skillsField);
        panel.add(new JLabel("Motivation:"));
        panel.add(new JScrollPane(motivationArea));

        JButton submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> {
            String name = nameField.getText();
            String email = emailField.getText();
            String contact = contactField.getText();
            String skills = skillsField.getText();
            String motivation = motivationArea.getText();

            ApplicationManager.saveApplication(professorName, name, email, contact, skills, motivation);
            JOptionPane.showMessageDialog(this, "Application submitted successfully!");
            dispose();
        });

        add(panel, BorderLayout.CENTER);
        add(submitButton, BorderLayout.SOUTH);
        setVisible(true);
    }
}
