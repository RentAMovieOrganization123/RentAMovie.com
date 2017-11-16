package Model;

import java.util.Date;

public class User {

    private String name;
    private String userName;
    //private static int profilePicGlobalId = 0;
    //private final int profilePicId;
    private String password;
    private String firstName;
    private Date birthDate;
    private byte[] profilePicture;
    private int age;
    private String country;
    private String isAdmin;
    public User(String name, String firstName, String userName, String password, Date birthDate, String country, byte[] profilePicture,String isAdmin) {
        this.name = name;
        this.firstName = firstName;
        this.userName = userName;
        this.password = password;
        this.birthDate = birthDate;
        this.country = country;
        this.profilePicture = profilePicture;
        this.isAdmin = isAdmin;
        calculateAge();
        // incrementProfilePicGlobalId();
    }

    public String getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(String isAdmin) {
        this.isAdmin = isAdmin;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void calculateAge() {
        Date now = new Date();
        long timeBetween = now.getTime() - birthDate.getTime();
        double yearsBetween = timeBetween / 3.156e+10;
        int age = (int) Math.floor(yearsBetween);
        this.setAge(age);
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
    // private void incrementProfilePicGlobalId() {
    //     profilePicGlobalId = profilePicGlobalId + 1;
    // }
}
