package giacom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage extends JFrame implements ActionListener {

    // Components of the Form
    private Container con;
    private JLabel title;
    private JLabel username;
    private JTextField tusername;
    private JLabel password;
    private JTextField tpassword;
    private JButton login;
    private JLabel res;

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

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(50, 195);
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
                res.setText("Login successful");
            }
        }
    }
}
