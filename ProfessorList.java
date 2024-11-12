import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ProfessorList extends JFrame {
    public ProfessorList() {
        setTitle("Professors List");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        JPanel professorPanel = new JPanel();
        professorPanel.setLayout(new BoxLayout(professorPanel, BoxLayout.Y_AXIS));

        // Sample data, replace with actual data from Faculty.xlsx
        ArrayList<String[]> professors = new ArrayList<>();
        professors.add(new String[]{"Prof. A", "Machine Learning", "https://profA.edu"});
        professors.add(new String[]{"Prof. B", "Data Science", "https://profB.edu"});

        for (String[] professor : professors) {
            JPanel profRow = new JPanel(new BorderLayout(10, 10));
            JLabel nameLabel = new JLabel(professor[0]);
            JLabel interestLabel = new JLabel(professor[1]);
            JButton websiteButton = new JButton("Website");
            JButton applyButton = new JButton("Apply");

            websiteButton.addActionListener(e -> {
                try {
                    Desktop.getDesktop().browse(new java.net.URI(professor[2]));
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(this, "Unable to open website.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            });

            applyButton.addActionListener(e -> new ApplicationForm(professor[0]));

            profRow.add(nameLabel, BorderLayout.WEST);
            profRow.add(interestLabel, BorderLayout.CENTER);
            profRow.add(websiteButton, BorderLayout.EAST);
            profRow.add(applyButton, BorderLayout.SOUTH);

            professorPanel.add(profRow);
            professorPanel.add(Box.createVerticalStrut(10));
        }

        JScrollPane scrollPane = new JScrollPane(professorPanel);
        add(scrollPane, BorderLayout.CENTER);
        setVisible(true);
    }
}
