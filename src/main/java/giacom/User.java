package giacom;

public class User {
    private String username;
    private String password;
    private String name;
    private String dob;
    private String streetAdd;
    private String citStatZip;
    private String gender;

    public User(String username, String password, String name, String dob, String streetAddress, String citStaZip, String gender){
        this.username = username;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.streetAdd = streetAddress;
        this.citStatZip = citStaZip;
        this.gender = gender;
    }

    public String getUsername(){
        return username;
    }
    public String getPassword() {
        return password;
    }
    public String getName() {
        return name;
    }
    public String getDob() {
        return dob;
    }
    public String getStreet() {
        return streetAdd;
    }
    public String getCitStatZip() {
        return citStatZip;
    }
    public String getGender() {
        return gender;
    }





}
