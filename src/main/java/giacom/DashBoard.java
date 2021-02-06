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
    private JButton reset;
    private JLabel res;
    private boolean metReq;

    // constructor, to initialize the components
    // with default values.
    public DashBoard()
    {
        setTitle("DashBoard");
        setBounds(300, 90, 400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        c = getContentPane();
        c.setLayout(null);

        requestRecords = new JButton("Request Medical Records");
        requestRecords.setFont(new Font("Arial", Font.PLAIN, 30));
        requestRecords.setSize(300, 80);
        requestRecords.setLocation(50, 70);
        requestRecords.addActionListener(this);
        c.add(requestRecords);

        reset = new JButton("Cancel");
        reset.setFont(new Font("Arial", Font.PLAIN, 15));
        reset.setSize(100, 20);
        reset.setLocation(270, 640);
        reset.addActionListener(this);
        c.add(reset);

        res = new JLabel("");
        res.setFont(new Font("Arial", Font.PLAIN, 20));
        res.setSize(900, 25);
        res.setLocation(100, 680);
        c.add(res);

        setVisible(true);
    }

    // method actionPerformed()
    // to get the action performed
    // by the user and act accordingly
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource() == requestRecords) {
            res.setText("Registration Successfully.. Form emailed to provider");
        }




    }

}