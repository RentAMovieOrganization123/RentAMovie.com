package Model;

import java.util.Date;


public class User {
    
    private String name;
    private static int profilePicGlobalId = 0;
    private final int profilePicId;
    private String firstName;
    private Date birthDate;
    private int age;
    private String country;

    public User(String name, String firstName, Date birthDate, String country) {
        this.name = name;
        this.firstName = firstName;
        this.birthDate = birthDate;
        this.country = country;
        profilePicId = profilePicGlobalId;
        
        calculateAge();
        incrementProfilePicGlobalId();
    }
    
    

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }
    
    public void calculateAge(){
        Date now = new Date();
        long timeBetween = now.getTime() - birthDate.getTime();
        double yearsBetween = timeBetween / 3.156e+10;
        int age = (int) Math.floor(yearsBetween);
        this.setAge(age);
    }
    
     public int getProfilePicId() {
        return this.profilePicId;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

    private void incrementProfilePicGlobalId() {
        profilePicGlobalId = profilePicGlobalId + 1;
    }
}
