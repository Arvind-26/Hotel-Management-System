package hotelManagement;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class updatepage extends JFrame{
    JTextField fname, mname, lname, age, add, country, mailfild, phone;
    JRadioButton male, female, other;
    String ne;
    updatepage(String nr){
        super("Update");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);

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
    }
    public static void main(String[] args) {
        
    }
    
}
