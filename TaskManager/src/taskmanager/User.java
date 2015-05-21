/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package taskmanager;

/**
 *
 * @author scott
 */
public class User {
    private String name;
    private String password;
    
    public User(String name, String pwd)
    {
        this.name = name;
        this.password = pwd;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }


    public Boolean isGood(User to_match) {
        return this.name.equals(to_match.name) && this.password.equals(to_match.password);
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
