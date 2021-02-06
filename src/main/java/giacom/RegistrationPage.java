package giacom;

// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RegistrationPage
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel Fname;
    private JTextField tFname;
    private JLabel Lname;
    private JTextField tLname;
    private JLabel addressL1;
    private JTextField tAddressL1;
    private JLabel addressL2;
    private JTextField tAddressL2;
    private JLabel city;
    private JTextField tcity;
    private JLabel state;
    private JTextField tstate;
    private JLabel zipC;
    private JTextField tzipC;
    private JLabel gender;
    private JRadioButton male;
    private JRadioButton female;
    private ButtonGroup gengp;
    private JLabel dob;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel username;
    private JTextField tusername;
    private JLabel password;
    private JTextField tpassword;
    private JCheckBox term;
    private JButton sub;
    private JButton reset;
    private JLabel res;
    private boolean metReq;

    private String dates[]
            = { "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "10",
            "11", "12", "13", "14", "15",
            "16", "17", "18", "19", "20",
            "21", "22", "23", "24", "25",
            "26", "27", "28", "29", "30",
            "31" };
    private String months[]
            = { "Jan", "feb", "Mar", "Apr",
            "May", "Jun", "July", "Aug",
            "Sup", "Oct", "Nov", "Dec" };
    private String years[]
            = { "1995", "1996", "1997", "1998",
            "1999", "2000", "2001", "2002",
            "2003", "2004", "2005", "2006",
            "2007", "2008", "2009", "2010",
            "2011", "2012", "2013", "2014",
            "2015", "2016", "2017", "2018",
            "2019", "2020"};

    // constructor, to initialize the components
    // with default values.
    public RegistrationPage()
    {
        setTitle("Registration Form");
        setBounds(300, 90, 900, 1000);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Registration Form");
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        title.setSize(300, 30);
        title.setLocation(300, 30);
        c.add(title);

        Fname = new JLabel("First Name");
        Fname.setFont(new Font("Arial", Font.PLAIN, 20));
        Fname.setSize(100, 20);
        Fname.setLocation(100, 100);
        c.add(Fname);

        tFname = new JTextField();
        tFname.setFont(new Font("Arial", Font.PLAIN, 15));
        tFname.setSize(190, 20);
        tFname.setLocation(200, 100);
        c.add(tFname);

        Lname = new JLabel("Last Name");
        Lname.setFont(new Font("Arial", Font.PLAIN, 20));
        Lname.setSize(100, 20);
        Lname.setLocation(450, 100);
        c.add(Lname);

        tLname = new JTextField();
        tLname.setFont(new Font("Arial", Font.PLAIN, 15));
        tLname.setSize(190, 20);
        tLname.setLocation(550, 100);
        c.add(tLname);

        addressL1 = new JLabel("Address Line 1");
        addressL1.setFont(new Font("Arial", Font.PLAIN, 20));
        addressL1.setSize(200, 20);
        addressL1.setLocation(100, 140);
        c.add(addressL1);

        tAddressL1 = new JTextField();
        tAddressL1.setFont(new Font("Arial", Font.PLAIN, 15));
        tAddressL1.setSize(640, 20);
        tAddressL1.setLocation(100, 160);
        c.add(tAddressL1);

        addressL2 = new JLabel("Address Line 2");
        addressL2.setFont(new Font("Arial", Font.PLAIN, 20));
        addressL2.setSize(200, 20);
        addressL2.setLocation(100, 200);
        c.add(addressL2);

        tAddressL2 = new JTextField();
        tAddressL2.setFont(new Font("Arial", Font.PLAIN, 15));
        tAddressL2.setSize(640, 20);
        tAddressL2.setLocation(100, 220);
        c.add(tAddressL2);

        city = new JLabel("City");
        city.setFont(new Font("Arial", Font.PLAIN, 20));
        city.setSize(100, 20);
        city.setLocation(100, 260);
        c.add(city);

        tcity = new JTextField();
        tcity.setFont(new Font("Arial", Font.PLAIN, 15));
        tcity.setSize(100, 20);
        tcity.setLocation(100, 280);
        c.add(tcity);

        state = new JLabel("State/Province");
        state.setFont(new Font("Arial", Font.PLAIN, 20));
        state.setSize(200, 20);
        state.setLocation(100, 320);
        c.add(state);

        tstate = new JTextField();
        tstate.setFont(new Font("Arial", Font.PLAIN, 15));
        tstate.setSize(100, 20);
        tstate.setLocation(100, 340);
        c.add(tstate);

        zipC = new JLabel("Zip/Postal Code");
        zipC.setFont(new Font("Arial", Font.PLAIN, 20));
        zipC.setSize(200, 20);
        zipC.setLocation(100, 380);
        c.add(zipC);

        tzipC = new JTextField();
        tzipC.setFont(new Font("Arial", Font.PLAIN, 15));
        tzipC.setSize(100, 20);
        tzipC.setLocation(100, 400);
        c.add(tzipC);

        gender = new JLabel("Gender");
        gender.setFont(new Font("Arial", Font.PLAIN, 20));
        gender.setSize(100, 20);
        gender.setLocation(100, 440);
        c.add(gender);

        male = new JRadioButton("Male");
        male.setFont(new Font("Arial", Font.PLAIN, 15));
        male.setSelected(true);
        male.setSize(75, 20);
        male.setLocation(200, 440);
        c.add(male);

        female = new JRadioButton("Female");
        female.setFont(new Font("Arial", Font.PLAIN, 15));
        female.setSelected(false);
        female.setSize(80, 20);
        female.setLocation(275, 440);
        c.add(female);

        gengp = new ButtonGroup();
        gengp.add(male);
        gengp.add(female);

        dob = new JLabel("Date of Birth");
        dob.setFont(new Font("Arial", Font.PLAIN, 18));
        dob.setSize(100, 20);
        dob.setLocation(100, 480);
        c.add(dob);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(60, 20);
        date.setLocation(200, 480);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(80, 20);
        month.setLocation(270, 480);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(90, 20);
        year.setLocation(360, 480);
        c.add(year);

        //username is the email address
        username = new JLabel("Username (Enter your email address):");
        username.setFont(new Font("Arial", Font.PLAIN, 20));
        username.setSize(350, 20);
        username.setLocation(100, 520);
        c.add(username);

        tusername = new JTextField();
        tusername.setFont(new Font("Arial", Font.PLAIN, 15));
        tusername.setSize(290, 20);
        tusername.setLocation(450, 520);
        c.add(tusername);

        password = new JLabel("Password:");
        password.setFont(new Font("Arial", Font.PLAIN, 20));
        password.setSize(100, 20);
        password.setLocation(100, 560);
        c.add(password);

        tpassword = new JTextField();
        tpassword.setFont(new Font("Arial", Font.PLAIN, 15));
        tpassword.setSize(290, 20);
        tpassword.setLocation(200, 560);
        c.add(tpassword);

        term = new JCheckBox("Accept Terms And Conditions.");
        term.setFont(new Font("Arial", Font.PLAIN, 15));
        term.setSize(250, 20);
        term.setLocation(150, 600);
        c.add(term);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 625);
        sub.addActionListener(this);
        c.add(sub);

        reset = new JButton("Reset");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 625);
        reset.addActionListener(this);
        c.add(reset);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(500, 25);
        res.setLocation(100, 650);
        c.add(res);
        
        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == sub) {
            if (term.isSelected()) {
                res.setText("Registration Successfully..");
            }
            else {
                res.setText("Please accept the"
                        + " terms & conditions.");
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tFname.setText(def);
            tLname.setText(def);
            addressL1.setText(def);
            addressL2.setText(def);
            city.setText(def);
            state.setText(def);
            zipC.setText(def);
            username.setText(def);
            password.setText(def);
            res.setText(def);
            term.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }
    }
}



