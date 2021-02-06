package giacom;

// Java program to implement
// a Simple Registration Form
// using Java Swing

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class RequestRecordsPage
        extends JFrame
        implements ActionListener {

    // Components of the Form
    private Container c;
    private JLabel title;
    private JLabel provider;
    private JTextField tProvider;
    private JLabel proEmailAddress;
    private JTextField tproEmailAddress;
    private JLabel proAddress;
    private JTextField tProAddress;
    private JLabel proAddress2;
    private JTextField tProAddress2;
    private JLabel agreements;
    private JTextArea terms;
    private JCheckBox agreeTerms;
    private JLabel startDate;
    private JComboBox date;
    private JComboBox month;
    private JComboBox year;
    private JLabel endDate;
    private JComboBox date2;
    private JComboBox month2;
    private JComboBox year2;
    private JLabel socialSecurity;
    private JTextField tSocialSecurity;

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
    public RequestRecordsPage()
    {
        setTitle("Request Records Form");
        setBounds(300, 90, 900, 800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        c = getContentPane();
        c.setLayout(null);

        title = new JLabel("Welcome! This is the tool to request medical records for your healthcare provider.");
        title.setFont(new Font("Arial", Font.PLAIN, 20));
        title.setSize(800, 100);
        title.setLocation(50, 20);
        c.add(title);

        provider = new JLabel("Health Provider Name");
        provider.setFont(new Font("Arial", Font.PLAIN, 15));
        provider.setSize(300, 20);
        provider.setLocation(80, 100);
        c.add(provider);

        tProvider = new JTextField();
        tProvider.setFont(new Font("Arial", Font.PLAIN, 15));
        tProvider.setSize(190, 20);
        tProvider.setLocation(235, 100);
        c.add(tProvider);

        proEmailAddress = new JLabel("Email Address");
        proEmailAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        proEmailAddress.setSize(300, 20);
        proEmailAddress.setLocation(440, 100);
        c.add(proEmailAddress);

        tproEmailAddress = new JTextField();
        tproEmailAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        tproEmailAddress.setSize(190, 20);
        tproEmailAddress.setLocation(570, 100);
        c.add(tproEmailAddress);

        proAddress = new JLabel("Provider Street Address");
        proAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        proAddress.setSize(300, 20);
        proAddress.setLocation(70, 140);
        c.add(proAddress);

        tProAddress = new JTextField();
        tProAddress.setFont(new Font("Arial", Font.PLAIN, 15));
        tProAddress.setSize(190, 20);
        tProAddress.setLocation(235, 140);
        c.add(tProAddress);

        proAddress2 = new JLabel("City, State Zip");
        proAddress2.setFont(new Font("Arial", Font.PLAIN, 15));
        proAddress2.setSize(300, 20);
        proAddress2.setLocation(440, 140);
        c.add(proAddress2);

        tProAddress2 = new JTextField();
        tProAddress2.setFont(new Font("Arial", Font.PLAIN, 15));
        tProAddress2.setSize(190, 20);
        tProAddress2.setLocation(570, 140);
        c.add(tProAddress2);

        agreements = new JLabel("Agree to Following Terms...");
        agreements.setFont(new Font("Arial", Font.PLAIN, 20));
        agreements.setSize(400, 30);
        agreements.setLocation(100, 200);
        c.add(agreements);

        terms = new JTextArea();
        terms.setFont(new Font("Arial", Font.PLAIN, 12));
        terms.setSize(680, 250);
        terms.setLocation(110, 230);
        terms.setLineWrap(true);
        terms.setEditable(false);
        terms.setText("+All medical records, meaning every page in my record, " +
                "including but not limited to: office notes, face sheets, history and physical, consultation notes, inpatient, " +
                "outpatient and emergency room treatment, all clinical charts, r ports, order sheets, progress notes, nurse's notes, " +
                "social worker records, clinic records, treatment plans, admission records, discharge summaries, requests for and reports of " +
                "consultations, documents, correspondence, test results, statements, questionnaires/histories, correspondence, photographs, videotapes, " +
                "telephone messages, and records received by other medical providers.\n\n+All physical, occupational and rehab requests, " +
                "consultations and progress notes.\n\n+All disability, Medicaid or Medicare records including claim forms and record of denial " +
                "of benefits.\n\n+All employment, personnel or wage records.\n\n+All autopsy, laboratory, histology, cytology, pathology, " +
                "immunohistochemistry records and specimens; radiology records and films including CT scan, MRI, MRA, EMG, bone scan, myleogram; " +
                "nerve conduction study, echocardiogram and cardiac catheterization results, videos/CDs/films/reels and reports.\n\n" +
                "+All pharmacy/prescription records including NDC numbers and drug information handouts/monographs.\n\n");
        c.add(terms);

        agreeTerms = new JCheckBox("Accept Terms And Conditions.");
        agreeTerms.setFont(new Font("Arial", Font.PLAIN, 15));
        agreeTerms.setSize(250, 20);
        agreeTerms.setLocation(100, 480);
        c.add(agreeTerms);


        startDate = new JLabel("Start of Records");
        startDate.setFont(new Font("Arial", Font.PLAIN, 18));
        startDate.setSize(150, 20);
        startDate.setLocation(100, 530);
        c.add(startDate);

        date = new JComboBox(dates);
        date.setFont(new Font("Arial", Font.PLAIN, 15));
        date.setSize(60, 20);
        date.setLocation(240, 530);
        c.add(date);

        month = new JComboBox(months);
        month.setFont(new Font("Arial", Font.PLAIN, 15));
        month.setSize(80, 20);
        month.setLocation(310, 530);
        c.add(month);

        year = new JComboBox(years);
        year.setFont(new Font("Arial", Font.PLAIN, 15));
        year.setSize(90, 20);
        year.setLocation(400, 530);
        c.add(year);

        endDate = new JLabel("End of Records");
        endDate.setFont(new Font("Arial", Font.PLAIN, 18));
        endDate.setSize(150, 20);
        endDate.setLocation(100, 565);
        c.add(endDate);

        date2 = new JComboBox(dates);
        date2.setFont(new Font("Arial", Font.PLAIN, 15));
        date2.setSize(60, 20);
        date2.setLocation(240, 565);
        c.add(date2);

        month2 = new JComboBox(months);
        month2.setFont(new Font("Arial", Font.PLAIN, 15));
        month2.setSize(80, 20);
        month2.setLocation(310, 565);
        c.add(month2);

        year2 = new JComboBox(years);
        year2.setFont(new Font("Arial", Font.PLAIN, 15));
        year2.setSize(90, 20);
        year2.setLocation(400, 565);
        c.add(year2);

        socialSecurity = new JLabel("Social Security");
        socialSecurity.setFont(new Font("Arial", Font.PLAIN, 18));
        socialSecurity.setSize(300, 20);
        socialSecurity.setLocation(100, 600);
        c.add(socialSecurity);

        tSocialSecurity = new JTextField();
        tSocialSecurity.setFont(new Font("Arial", Font.PLAIN, 15));
        tSocialSecurity.setSize(190, 20);
        tSocialSecurity.setLocation(235, 600);
        c.add(tSocialSecurity);

        sub = new JButton("Submit");
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.setSize(100, 20);
        sub.setLocation(150, 640);
        sub.addActionListener(this);
        c.add(sub);

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
        if (e.getSource() == sub) {
            if (tProvider.getText().isEmpty() || tproEmailAddress.getText().isEmpty() || tProAddress.getText().isEmpty()
                    || tProAddress2.getText().isEmpty() || tSocialSecurity.getText().isEmpty()) {
                res.setText("Please input responses for all fields");
            } else {
                if (agreeTerms.isSelected()) {
                    res.setText("Registration Successfully.. Form emailed to provider");
                    User demoUser = new User("demouser", "123", "Demo Man", "01/01/2000",
                            "872 this way", "athens,GA 30609", "Female");
                    String startingDate = month.getSelectedItem().toString() + " " + date.getSelectedItem().toString() + " " +
                            year.getSelectedItem().toString();
                    String endingDate = month2.getSelectedItem().toString() + " " + date2.getSelectedItem().toString() + " " +
                            year2.getSelectedItem().toString();
                    PDFCreate pdf = new PDFCreate(tProvider.getText(), tProAddress.getText(), tProAddress2.getText(),
                            demoUser, tSocialSecurity.getText(), startingDate, endingDate);
                } else {
                    res.setText("Please accept the"
                            + " terms & conditions.");
                }
            }
        }

        else if (e.getSource() == reset) {
            String def = "";
            tProvider.setText(def);
            tProAddress.setText(def);
            tProAddress2.setText(def);
            tproEmailAddress.setText(def);
            tSocialSecurity.setText(def);
            res.setText(def);
            agreeTerms.setSelected(false);
            date.setSelectedIndex(0);
            month.setSelectedIndex(0);
            year.setSelectedIndex(0);
        }


    }

}