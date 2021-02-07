package giacom;

// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class DashBoard
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;

    private JButton requestRecords;
    private JLabel res;

    private User currentUser;
    // constructor, to initialize the components
    // with default values.
    public DashBoard(User currentUser)
    {
        this.currentUser = currentUser;
        setTitle("DashBoard");
        setBounds(300, 90, 600, 200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        requestRecords = new JButton("Request Medical Records");
        requestRecords.setFont(new Font("Arial", Font.PLAIN, 30));
        requestRecords.setSize(500, 80);
        requestRecords.setLocation(50, 70);
        requestRecords.addActionListener(this);
        c.add(requestRecords);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(900, 25);
        res.setLocation(100, 70);
        c.add(res);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == requestRecords) {
            RequestRecordsPage rr = new RequestRecordsPage(currentUser);
            setVisible(false);
        }
    }

}
