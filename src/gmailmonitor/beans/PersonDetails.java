/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gmailmonitor.beans;

import java.util.ArrayList;

/**
 *
 * @author priyanka
 */
public class PersonDetails {
   private String name;
   private String location;
   private ArrayList<String> number;

    public PersonDetails(String name, String location, ArrayList<String> number) {
        this.name = name;
        this.location = location;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public ArrayList<String> getNumber() {
        return number;
    }

    public void setNumber(ArrayList<String> number) {
        this.number = number;
    }
   
   
    
}
