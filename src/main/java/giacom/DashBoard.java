package giacom;

// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

class DashBoard
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;

    private ImageIcon image;
    private JButton button;

    private JButton requestRecords;
    private JButton checkRecords;
    private JLabel res;

    private User currentUser;
    // constructor, to initialize the components
    // with default values.
    public DashBoard(User currentUser)
    {
        this.currentUser = currentUser;
        setTitle("DashBoard");
        setBounds(300, 90, 600, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        c = getContentPane();
        c.setLayout(null);

        image = new ImageIcon("./medlogo.png");
        button = new JButton(image);
        button.setFont(new Font("Arial", Font.PLAIN, 30));
        button.setSize(500, 350);
        button.setLocation(50, 30);
        c.add(button);

        requestRecords = new JButton("Request Medical Records");
        requestRecords.setFont(new Font("Arial", Font.PLAIN, 30));
        requestRecords.setSize(500, 80);
        requestRecords.setLocation(50, 400);
        requestRecords.addActionListener(this);
        c.add(requestRecords);

        checkRecords = new JButton("View Medical Records");
        checkRecords.setFont(new Font("Arial", Font.PLAIN, 30));
        checkRecords.setSize(500, 80);
        checkRecords.setLocation(50, 485);
        checkRecords.addActionListener(this);
        c.add(checkRecords);

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
