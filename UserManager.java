import java.util.HashMap;

public class UserManager {
    private static final HashMap<String, String> studentCredentials = new HashMap<>();
    private static final HashMap<String, String> professorCredentials = new HashMap<>();

    static {
        // Sample hardcoded credentials for students
        studentCredentials.put("student1", "password1");
        studentCredentials.put("student2", "password2");

        // Sample hardcoded credentials for professors
        professorCredentials.put("profA", "password");
        professorCredentials.put("profB", "password");
    }

    public static boolean isStudent(String username, String password) {
        return studentCredentials.containsKey(username) && studentCredentials.get(username).equals(password);
    }

    public static boolean isProfessor(String username, String password) {
        return professorCredentials.containsKey(username) && professorCredentials.get(username).equals(password);
    }
}
