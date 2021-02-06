package giacom;

public class User {
    private String username;
    private String password;
    private String name;
    private String dob;
    private String socialSecurity;

    public User(String username, String password, String name, String dob,
                String socialSecurity){
        this.username = username;
        this.password = password;
        this.name = name;
        this.dob = dob;
        this.socialSecurity = socialSecurity;
    }

    public String getUsername(){
        return username;
    }

    public String getDob() {
        return dob;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getSocialSecurity() {
        return socialSecurity;
    }
}
