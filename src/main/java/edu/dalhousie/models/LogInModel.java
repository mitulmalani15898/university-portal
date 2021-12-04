package edu.dalhousie.models;

public class LogInModel {
    private String userName;
    private String userPassword;
    private String hashedPassword;
    private final String[] userCredentials = new String[2];
    private String storedUserName;
    private String storedUserPassword;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String[] getUserCredentials() {
        return userCredentials;
    }

    public void setUserCredentials(String user_name, String user_hashed_password) {
        userCredentials[0] = user_name;
        userCredentials[1] = user_hashed_password;
    }

    public String getStoredUserName() {
        return storedUserName;
    }

    public void setStoredUserName(String storedUserName) {
        this.storedUserName = storedUserName;
    }

    public String getStoredUserPassword() {
        return storedUserPassword;
    }

    public void setStoredUserPassword(String storedUserPassword) {
        this.storedUserPassword = storedUserPassword;
    }
}
