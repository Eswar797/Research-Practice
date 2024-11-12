public class Application {
    private String studentName;
    private String email;
    private String contactNumber;
    private String skills;
    private String experience;
    private String motivation;
    private String professorName;

    public Application(String studentName, String email, String contactNumber, String skills, String experience, String motivation, String professorName) {
        this.studentName = studentName;
        this.email = email;
        this.contactNumber = contactNumber;
        this.skills = skills;
        this.experience = experience;
        this.motivation = motivation;
        this.professorName = professorName;
    }

    // Getters and setters
    public String getProfessorName() {
        return professorName;
    }
}