package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

class signinpage extends JFrame {

    JTextField fname, lname, age, add, country, mailfild, phone;
    JPanel sidepan;
    JPasswordField password;
    JRadioButton male, female, other;
    JButton signin;
    Random r;
    String ggg, nr;

    signinpage() {

        super("BEDZ");
        setSize(850, 470);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.WHITE);

        Image tr = Toolkit.getDefaultToolkit().getImage("package\\apk\\icons\\tringle.png");
        setIconImage(tr);

        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        ImageIcon bgg = new ImageIcon("package\\apk\\icons\\bgg.png");
        Image bgg2 = bgg.getImage().getScaledInstance(180,478, Image.SCALE_DEFAULT);
        JLabel bgg3 = new JLabel(new ImageIcon(bgg2));
        bgg3.setBounds(0,0,180,478);
        sidepan.add(bgg3);
        sidepan.setLayout(null);
        add(sidepan);


        JLabel head = new JLabel("SIGN IN");
        head.setFont(new Font("Times", Font.BOLD, 38));
        head.setBounds(200, 10, 200, 40);
        head.setForeground(new Color(225,95,31));
        add(head);
       

        JLabel firstname = new JLabel("First Name");
        firstname.setFont(new Font("Times", Font.BOLD, 13));
        firstname.setBounds(200, 80, 120, 20);
        add(firstname);
        fname = new JTextField(20);
        fname.setFont(new Font("Times", Font.PLAIN, 17));
        fname.setBounds(200, 100, 250, 30);
        add(fname);
        

        JLabel lastname = new JLabel("Last Name");
        lastname.setFont(new Font("Times", Font.BOLD, 13));
        lastname.setBounds(510, 80, 120, 20);
        add(lastname);
        lname = new JTextField(20);
        lname.setFont(new Font("Times", Font.PLAIN, 17));
        lname.setBounds(510, 100, 250, 30);
        add(lname);

         

        JLabel uage = new JLabel("Age");
        uage.setFont(new Font("Times", Font.BOLD, 13));
        uage.setBounds(200, 150, 250, 30);
        add(uage);
        age = new JTextField(2);
        age.setFont(new Font("Times", Font.PLAIN, 17));
        age.setBounds(200, 175, 100, 30);
        add(age);
        

        JLabel Gender = new JLabel("Gender");
        Gender.setFont(new Font("Times", Font.BOLD, 13));
        Gender.setBounds(350, 150, 250, 30);
        add(Gender);
        male = new JRadioButton("Male");
        male.setFont(new Font("Times", Font.BOLD, 13));
        male.setBackground(Color.white);
        male.setBounds(350, 175, 100, 30);
        add(male);
        female = new JRadioButton("Female");
        female.setFont(new Font("Times", Font.BOLD, 13));
        female.setBackground(Color.white);
        female.setBounds(510, 175, 100, 30);
        add(female);
        other = new JRadioButton("Other");
        other.setFont(new Font("TImes", Font.BOLD, 13));
        other.setBackground(Color.white);
        other.setBounds(660, 175, 100, 30);
        add(other);
        ButtonGroup radio = new ButtonGroup();
        radio.add(male);
        radio.add(female);
        radio.add(other);
        

        JLabel adss = new JLabel("City");
        adss.setFont(new Font("Times", Font.BOLD, 13));
        adss.setBounds(200, 225, 150, 30);
        add(adss);
        add = new JTextField();
        add.setFont(new Font("Times", Font.PLAIN, 17));
        add.setBounds(200, 250, 350, 30);
        add(add);
        

        JLabel count = new JLabel("Country");
        count.setFont(new Font("Times", Font.BOLD, 13));
        count.setBounds(600, 225, 150, 30);
        add(count);
        country = new JTextField();
        country.setFont(new Font("Times", Font.PLAIN, 17));
        country.setBounds(600, 250, 155, 30);
        add(country);
        

        JLabel mail = new JLabel("Mail Address");
        mail.setFont(new Font("Times", Font.BOLD, 13));
        mail.setBounds(200, 305, 150, 30);
        add(mail);
        mailfild = new JTextField();
        mailfild.setFont(new Font("Times", Font.PLAIN, 17));
        mailfild.setBounds(200, 330, 220, 30);
        add(mailfild);
       

        JLabel phn = new JLabel("Phone Number");
        phn.setFont(new Font("Times", Font.BOLD, 13));
        phn.setBounds(500, 305, 100, 30);
        add(phn);
        phone = new JTextField();
        phone.setFont(new Font("Times", Font.PLAIN, 17));
        phone.setBounds(500, 330, 270, 30);
        add(phone);
         

        JLabel pass = new JLabel("Create Password :");
        pass.setFont(new Font("Times", Font.BOLD, 13));
        pass.setBounds(200, 373, 150, 56);
        add(pass);
        password = new JPasswordField(10);
        password.setFont(new Font("Times", Font.PLAIN, 17));
        password.setBounds(320, 385, 200, 30);
        add(password); 
        

        r = new Random();
        int rr = r.nextInt(90) + 10;

        signin = new JButton("Create Account");
        signin.setFont(new Font("Times", Font.PLAIN, 15));
        signin.setBackground(new Color(225,95,31));
        signin.setForeground(Color.WHITE);
        signin.setBorderPainted(false);
        signin.setBounds(650, 383, 150, 35);
        add(signin); 
        
        signin.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    String n1 = fname.getText();
                    String n2 = lname.getText();
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
                    if (pass2.length() > 10) {
                        JOptionPane.showMessageDialog(null, "Plaese enter password under 10 digits.",
                                "Warning",
                                JOptionPane.WARNING_MESSAGE);
                    } else {
                        nr = n1 + rr;

                        mysqlconnection data = new mysqlconnection();
                        data.st.executeUpdate(
                                "insert into users values('" + nr + "','" + pass2 + "','" + n1 +"','" + n2 + "'," + a1 + ",'" + ggg + "','" + add1 + "','" + c1 + "','" + m1+ "'," + ph1+ ")");

                        JOptionPane.showMessageDialog(null, "Username : " + nr + "\n Password : " + pass2,
                                "Sign in Successfully", JOptionPane.PLAIN_MESSAGE);
                        dispose();
                        new homepage(nr);
                        new profilepage(nr);
                        
                    }
                } catch (Exception c) {
                    JOptionPane.showMessageDialog(null, "Please Enter all the Filds Proerly, They all are Imortant.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                            System.out.println(c);

                }

            }

        }); 

        setLayout(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}