package giacom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class LoginPage extends JFrame implements ActionListener {

    // Components of the Form
    private Container con;
    private JLabel title;
    private JLabel username;
    private JTextField tusername;
    private JLabel password;
    private JTextField tpassword;
    private JButton login;
    private JLabel reg;
    private JButton register;
    private JLabel res;

    private User currentUser = new User();

    public LoginPage() {
        setTitle("Login");
        setBounds(300, 90, 700, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        con = getContentPane();
        con.setLayout(null);

        title = new JLabel("Login");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        con.add(title);

        //username is the email address
        username = new JLabel("Username (Enter your email address):");
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setSize(350, 20);
        username.setLocation(50, 100);
        con.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.PLAIN, 15));
        tusername.setSize(290, 20);
        tusername.setLocation(400, 100);
        con.add(tusername);

        password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(50, 140);
        con.add(password);

        tpassword = new JTextField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(290, 20);
        tpassword.setLocation(150, 140);
        con.add(tpassword);

        login = new JButton("Login");
        login.setFont(new Font("Arial", Font.PLAIN, 15));
        login.setSize(100, 20);
        login.setLocation(300, 170);
        login.addActionListener(this);
        con.add(login);

        reg = new JLabel("Need an account?");
        reg.setFont(new Font("Arial", Font.PLAIN, 15));
        reg.setSize(150, 20);
        reg.setLocation(170, 200);
        con.add(reg);

        register = new JButton("Sign up");
        register.setFont(new Font("Arial", Font.PLAIN, 15));
        register.setSize(100, 20);
        register.setLocation(300, 200);
        register.addActionListener(this);
        con.add(register);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(50, 225);
        con.add(res);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == login) {
            if(tusername.getText().isEmpty() || tpassword.getText().isEmpty()) {
                res.setText("Please answer all fields properly");
            } else {
                //need to check for valid login info
                try{
                    if(checkForUser()) {
                        res.setText("Login successful");
                        setVisible(false);
                        DashBoard db = new DashBoard(currentUser);
                    }else {
                        res.setText("Incorrect username or password");
                    }
                } catch (IOException r) {
                    r.printStackTrace();
                }
            }
        } else if (e.getSource() == register) {
            RegistrationPage f = new RegistrationPage();
            setVisible(false);
        }

    }

    public boolean checkForUser() throws FileNotFoundException {

        Scanner file = new Scanner(new File("./UserData.txt"));
        String userInfo;
        while(file.hasNextLine()){
            userInfo = file.nextLine();
            if(userInfo.substring(0, userInfo.indexOf(":")).equals(tusername.getText().toString())){
                currentUser.setUsername(userInfo.substring(0, userInfo.indexOf(":")));
                userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
                if(userInfo.substring(0, userInfo.indexOf(":")).equals(tpassword.getText().toString())){
                    currentUser.setPassword(userInfo.substring(0, userInfo.indexOf(":")));
                    userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
                    readInfo(userInfo);
                    return true;
                }
            }
        }
        return false;
    }

    public void readInfo(String userInfo){
        currentUser.setName(userInfo.substring(0, userInfo.indexOf(":")));
        userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
        currentUser.setDob(userInfo.substring(0, userInfo.indexOf(":")));
        userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
        currentUser.setStreetAdd(userInfo.substring(0, userInfo.indexOf(":")));
        userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
        currentUser.setCitStatZip(userInfo.substring(0, userInfo.indexOf(":")));
        userInfo = userInfo.substring(userInfo.indexOf(":") + 1);
        currentUser.setGender(userInfo.substring(0, userInfo.indexOf(";")));
    }
}
