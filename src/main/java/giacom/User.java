package giacom;

public class User {
    private String username;
    private String password;
    private String name;
    private String dob;
    private String streetAdd;
    private String citStatZip;
    private String gender;

    public User(){

    }

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

    public String getStreetAdd() {
        return streetAdd;
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

    public void setDob(String dob) {
        this.dob = dob;
    }

    public void setCitStatZip(String citStatZip) {
        this.citStatZip = citStatZip;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStreetAdd(String streetAdd) {
        this.streetAdd = streetAdd;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
