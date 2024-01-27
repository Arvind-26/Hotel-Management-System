package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class signinpage extends JFrame {

    JTextField fname, mname, lname, age, add, country, mailfild, phone;
    JPasswordField password;
    JRadioButton male, female, other;
    JButton signin;
    Random r;
    String ggg, nr;

    signinpage() {

        super("Sign in");
        setSize(600, 500);
        setLocation(400, 100);

        JLabel head = new JLabel("Sign In");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 100, 40);
        add(head);

        JLabel firstname = new JLabel("First Name : ");
        firstname.setFont(new Font("Raleway", Font.BOLD, 12));
        firstname.setBounds(20, 70, 100, 56);
        add(firstname);
        fname = new JTextField(20);
        fname.setFont(new Font("Raleway", Font.BOLD, 12));
        fname.setBounds(90, 90, 100, 18);
        add(fname);

        JLabel midname = new JLabel("Middle Name : ");
        midname.setFont(new Font("Raleway", Font.BOLD, 12));
        midname.setBounds(200, 70, 100, 56);
        add(midname);
        mname = new JTextField(20);
        mname.setFont(new Font("Raleway", Font.BOLD, 12));
        mname.setBounds(283, 90, 100, 18);
        add(mname);

        JLabel lastname = new JLabel("Last Name : ");
        lastname.setFont(new Font("Raleway", Font.BOLD, 12));
        lastname.setBounds(395, 70, 100, 56);
        add(lastname);
        lname = new JTextField();
        lname.setFont(new Font("Raleway", Font.BOLD, 12));
        lname.setBounds(465, 90, 100, 18);
        add(lname);

        JLabel uage = new JLabel("Age : ");
        uage.setFont(new Font("Raleway", Font.BOLD, 12));
        uage.setBounds(20, 120, 100, 56);
        add(uage);
        age = new JTextField(2);
        age.setFont(new Font("Raleway", Font.BOLD, 12));
        age.setBounds(90, 140, 100, 18);
        add(age);

        JLabel Gender = new JLabel("Gender : ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 12));
        Gender.setBounds(200, 120, 100, 56);
        add(Gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Raleway", Font.BOLD, 12));
        male.setBounds(260, 140, 70, 18);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Raleway", Font.BOLD, 12));
        female.setBounds(360, 140, 70, 18);
        add(female);
        other = new JRadioButton("Other");
        other.setFont(new Font("Raleway", Font.BOLD, 12));
        other.setBounds(460, 140, 70, 18);
        add(other);
        ButtonGroup radio = new ButtonGroup();
        radio.add(male);
        radio.add(female);
        radio.add(other);

        JLabel adss = new JLabel("Address : ");
        adss.setFont(new Font("Raleway", Font.BOLD, 12));
        adss.setBounds(20, 170, 100, 56);
        add(adss);
        add = new JTextField();
        add.setFont(new Font("Raleway", Font.BOLD, 12));
        add.setBounds(90, 190, 250, 18);
        add(add);

        JLabel count = new JLabel("Country : ");
        count.setFont(new Font("Raleway", Font.BOLD, 12));
        count.setBounds(370, 170, 100, 56);
        add(count);
        country = new JTextField();
        country.setFont(new Font("Raleway", Font.BOLD, 12));
        country.setBounds(440, 190, 125, 18);
        add(country);

        JLabel mail = new JLabel("Mail Address : ");
        mail.setFont(new Font("Raleway", Font.BOLD, 12));
        mail.setBounds(20, 220, 100, 56);
        add(mail);
        mailfild = new JTextField();
        mailfild.setFont(new Font("Raleway", Font.BOLD, 12));
        mailfild.setBounds(120, 240, 300, 18);
        add(mailfild);

        JLabel phn = new JLabel("Phone Number : ");
        phn.setFont(new Font("Raleway", Font.BOLD, 12));
        phn.setBounds(20, 280, 100, 56);
        add(phn);
        phone = new JTextField();
        phone.setFont(new Font("Raleway", Font.BOLD, 12));
        phone.setBounds(120, 300, 300, 18);
        add(phone);

        JLabel pass = new JLabel("Password : ");
        pass.setFont(new Font("Raleway", Font.BOLD, 12));
        pass.setBounds(20, 340, 100, 56);
        add(pass);
        password = new JPasswordField(10);
        password.setFont(new Font("Raleway", Font.BOLD, 12));
        password.setBounds(120, 360, 300, 18);
        add(password);

        r = new Random();
        int rr = r.nextInt(90) + 10;

        signin = new JButton("Create Account");
        signin.setFont(new Font("Raleway", Font.BOLD, 12));
        signin.setBounds(210, 400, 150, 30);
        add(signin);
        signin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String n1 = fname.getText();
                    String n2 = mname.getText();
                    String n3 = lname.getText();
                    int a1 = Integer.parseInt(age.getText());

                    if (male.isSelected()) {
                        ggg = "Male";

                    } else if (female.isSelected()) {
                        ggg = "Female";

                    } else if (other.isSelected()) {
                        ggg = "Other";

                    }

                    String add1 = add.getText();
                    String c1 = country.getText();
                    String m1 = mailfild.getText();
                    long ph1 = Long.parseLong(phone.getText());
                    char[] pass1 = password.getPassword();
                    String pass2 = new String(pass1);
                    nr = n1 + rr;

                    mysqlconnection data = new mysqlconnection();
                    data.st.executeUpdate("insert into users values('" + nr + "','" + pass2 + "','" + n1 + "','" + n2
                            + "','" + n3 + "'," + a1 + ",'" + ggg + "','" + add1 + "','" + c1 + "','" + m1 + "'," + ph1
                            + ")");

                    JOptionPane.showMessageDialog(null, "Username : " + nr + "\n Password : " + pass2, "Sign in Successfully",JOptionPane.PLAIN_MESSAGE);
                    dispose();
                    new homepage(nr);       

                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "Please Enter all the Filds Proerly, They all are Imortant.",
                     "Warning",
                     JOptionPane.WARNING_MESSAGE);

                    
                }

            }

        });

        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}