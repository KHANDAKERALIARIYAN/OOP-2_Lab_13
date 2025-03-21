import java.util.Objects;

/**
 * Base class for all users in the system.
 * Contains common attributes like userID, email, and password.
 */
public class User {
    private String userID; // Unique identifier for the user
    private String email;  // Email address of the user
    private String password; // Password for authentication

    /**
     * Constructor to initialize a User object.
     *
     * @param userID   Unique identifier for the user.
     * @param email    Email address of the user.
     * @param password Password for authentication.
     */
    public User(String userID, String email, String password) {
        this.userID = userID;
        this.email = email;
        this.password = password;
    }

    // Getters and Setters
    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Authenticates the user by comparing the provided credentials.
     *
     * @param inputEmail    Email provided by the user.
     * @param inputPassword Password provided by the user.
     * @return true if credentials match, false otherwise.
     */
    public boolean authenticate(String inputEmail, String inputPassword) {
        return Objects.equals(this.email, inputEmail) && Objects.equals(this.password, inputPassword);
    }

    @Override
    public String toString() {
        return String.format("UserID: %s, Email: %s", userID, email);
    }
}