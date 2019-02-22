package com.ds.model;

/**
 * This is the model for User.
 */
public class User {

    private String name;

    private String email;

    private String passwordHash;

    private String confPasswordHash;

    /**
     * Default constructor
     */
    public User() {
        super();
        this.name = "";
        this.email = "";
        this.passwordHash = "";
        this.confPasswordHash = "";
    }

    /**
     * Create User object by passing name, email, password and passwordConfirmation
     *
     * @param name
     * @param email
     * @param passwordHash
     * @param confPasswordHash
     */
    public User(String name, String email, String passwordHash, String confPasswordHash) {
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.confPasswordHash = confPasswordHash;
    }

    /**
     * Getter method for Name
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     * Method to set Name
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Method to get the email Address
     *
     * @return
     */
    public String getEmail() {
        return email;
    }

    /**
     * Method to set email address
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Method to get the Password
     *
     * @return
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Method to set password
     *
     * @param password
     */
    public void setPasswordHash(String password) {
        this.passwordHash = password;
    }

    /**
     * Method to set Password Confirmation
     *
     * @return
     */
    public String getConfPasswordHash() {
        return confPasswordHash;
    }

    /**
     * Method to set Password Confirmation string
     *
     * @param confPassword
     */
    public void setConfPasswordHash(String confPassword) {
        this.confPasswordHash = confPassword;
    }

}
