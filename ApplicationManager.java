import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ApplicationManager {
    private static final String FILE_PATH = "applications.txt";

    // Save application to the file
    public static void saveApplication(String professorName, String name, String email, String contact, String skills, String motivation) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(professorName + "|" + name + "|" + email + "|" + contact + "|" + skills + "|" + motivation + "|Pending\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Retrieve applications for a specific professor
    // Helper method to normalize professor names
private static String normalizeProfessorName(String professorName) {
    return professorName.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); // Remove non-alphanumeric characters and convert to lowercase
}

// Retrieve applications for a specific professor
public static List<String[]> getApplicationsForProfessor(String professorName) {
    List<String[]> applications = new ArrayList<>();

    // Normalize the professor name to avoid any formatting issues
    String normalizedProfessorName = normalizeProfessorName(professorName);
    
    // Log professorName being searched for directly
    System.out.println("Normalized professor name for searching: '" + normalizedProfessorName + "'");

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split("\\|");

            // Ensure there are exactly 7 fields before processing
            if (data.length == 7) {
                String storedProfessorName = data[0].trim(); // Get professor name from file

                // Normalize stored professor name to avoid any formatting issues
                String normalizedStoredProfessorName = normalizeProfessorName(storedProfessorName);

                // Log the normalized names before comparison
                System.out.println("Normalized Stored Professor Name: '" + normalizedStoredProfessorName + "'");
                System.out.println("Line read from file: '" + line + "'");

                // Compare professor names after normalizing both
                if (normalizedStoredProfessorName.equals(normalizedProfessorName)) {
                    applications.add(data);
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    System.out.println("Total applications found for professor: " + applications.size());
    return applications;
}




    // Update application status (accept/reject)
    public static void updateApplicationStatus(String professorName, String studentName, String newStatus) {
        List<String> lines = new ArrayList<>();
        List<String> updatedLines = new ArrayList<>();
        
        // Read the lines from the file and update the status
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split("\\|");
                if (data.length == 7 && data[0].equals(professorName) && data[1].equals(studentName)) {
                    // Update the status of the application
                    line = String.join("|", data[0], data[1], data[2], data[3], data[4], data[5], newStatus);
                    updatedLines.add(line);  // Add the updated line to the list
                } else if (!line.contains(studentName)) {
                    updatedLines.add(line);  // Keep the lines that don't match
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    
        // Write the updated lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (String updatedLine : updatedLines) {
                writer.write(updatedLine + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    
}
