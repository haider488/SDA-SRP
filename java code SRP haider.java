// violating SRP

// A single class that handles both user creation and user validation
public class UserManager {

    // This method handles creating a user
    public void createUser(String name, String email) {
        // Simulate storing the user in the database
        System.out.println("User created: " + name + ", " + email);
    }

    // This method handles validating the user's email
    public boolean validateEmail(String email) {
        // Basic email validation logic
        return email.contains("@") && email.endsWith(".com");
    }

    // This method sends a welcome email after creating the user
    public void sendWelcomeEmail(String email) {
        // Simulate sending an email
        System.out.println("Welcome email sent to: " + email);
    }
}







// Not violating SRP
// Separate class for handling user creation
public class UserCreator {
    public void createUser(String name, String email) {
        // Simulate storing the user in the database
        System.out.println("User created: " + name + ", " + email);
    }
}
// Separate class for handling email validation
public class EmailValidator {
    public boolean validateEmail(String email) {
        // Basic email validation logic
        return email.contains("@") && email.endsWith(".com");
    }
}
// Separate class for sending welcome emails
public class WelcomeEmailSender {
    public void sendWelcomeEmail(String email) {
        // Simulate sending an email
        System.out.println("Welcome email sent to: " + email);
    }
}
// Main class to use the refactored code
public class UserManager {
    private UserCreator userCreator = new UserCreator();
    private EmailValidator emailValidator = new EmailValidator();
    private WelcomeEmailSender welcomeEmailSender = new WelcomeEmailSender();
    public void processUser(String name, String email) {
        // Validate email
        if (emailValidator.validateEmail(email)) {
            userCreator.createUser(name, email);
            welcomeEmailSender.sendWelcomeEmail(email);
        } else {
            System.out.println("Invalid email: " + email);
        }
    }
}

