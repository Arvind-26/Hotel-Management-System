package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class profilepage extends JFrame implements ActionListener{
    JButton bback , bupdate;
    String awe;
    profilepage(String awr){
        super("Profile");
        awe = awr;
        mysqlconnection con = new mysqlconnection();
        ResultSet rs;
        String [] w = new String[10];
        try {
            rs = con.st.executeQuery("select * from users where username='"+awe+"'");
            rs.next();
            String [] q = {"firstname","middlename","lastname","age","gender","address","country","mail","phonenum","username"};
            
            for(int j = 0;j<q.length;j++){
                w[j] = rs.getString(q[j]);

                
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        
    


        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        JLabel head = new JLabel("Profile");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 100, 40);
        add(head);

        JLabel firstname = new JLabel("First Name :");
        firstname.setFont(new Font("Raleway", Font.BOLD, 12));
        firstname.setBounds(20, 70, 100, 56);
        add(firstname);

        JLabel firstname1 = new JLabel(w[0]);
        firstname1.setFont(new Font("Raleway", Font.BOLD, 12));
        firstname1.setBounds(90, 70, 100, 56);
        add(firstname1);

        JLabel midname = new JLabel("Middle Name : ");
        midname.setFont(new Font("Raleway", Font.BOLD, 12));
        midname.setBounds(200, 70, 100, 56);
        add(midname);
        JLabel midname1 = new JLabel(w[1]);
        midname1.setFont(new Font("Raleway", Font.BOLD, 12));
        midname1.setBounds(283, 70, 100, 56);
        add(midname1);

        JLabel lastname = new JLabel("Last Name : ");
        lastname.setFont(new Font("Raleway", Font.BOLD, 12));
        lastname.setBounds(395, 70, 100, 56);
        add(lastname);
        JLabel lastname1 = new JLabel(w[2]);
        lastname1.setFont(new Font("Raleway", Font.BOLD, 12));
        lastname1.setBounds(465, 70, 100, 56);
        add(lastname1);

        JLabel uage = new JLabel("Age : ");
        uage.setFont(new Font("Raleway", Font.BOLD, 12));
        uage.setBounds(20, 120, 100, 56);
        add(uage);
        JLabel uage1 = new JLabel(w[3]);
        uage1.setFont(new Font("Raleway", Font.BOLD, 12));
        uage1.setBounds(90, 120, 100, 56);
        add(uage1);

        JLabel Gender = new JLabel("Gender : ");
        Gender.setFont(new Font("Raleway", Font.BOLD, 12));
        Gender.setBounds(200, 120, 100, 56);
        add(Gender);
        JLabel Gender1 = new JLabel(w[4]);
        Gender1.setFont(new Font("Raleway", Font.BOLD, 12));
        Gender1.setBounds(260, 120, 100, 56);
        add(Gender1);

        JLabel adss = new JLabel("Address : ");
        adss.setFont(new Font("Raleway", Font.BOLD, 12));
        adss.setBounds(20, 170, 100, 56);
        add(adss);
        JLabel adss1 = new JLabel(w[5]);
        adss1.setFont(new Font("Raleway", Font.BOLD, 12));
        adss1.setBounds(90, 170, 300, 56);
        add(adss1);

        JLabel count = new JLabel("Country : ");
        count.setFont(new Font("Raleway", Font.BOLD, 12));
        count.setBounds(370, 170, 100, 56);
        add(count);
        JLabel count1 = new JLabel(w[6]);
        count1.setFont(new Font("Raleway", Font.BOLD, 12));
        count1.setBounds(440, 170, 100, 56);
        add(count1);

        JLabel mail = new JLabel("Mail Address : ");
        mail.setFont(new Font("Raleway", Font.BOLD, 12));
        mail.setBounds(20, 220, 100, 56);
        add(mail);
        JLabel mail1 = new JLabel(w[7]);
        mail1.setFont(new Font("Raleway", Font.BOLD, 12));
        mail1.setBounds(120, 220, 300, 56);
        add(mail1);

        JLabel phn = new JLabel("Phone Number : ");
        phn.setFont(new Font("Raleway", Font.BOLD, 12));
        phn.setBounds(20, 280, 100, 56);
        add(phn);
        JLabel phn1 = new JLabel(w[8]);
        phn1.setFont(new Font("Raleway", Font.BOLD, 12));
        phn1.setBounds(120, 280, 100, 56);
        add(phn1);

        JLabel usr = new JLabel("Username : ");
        usr.setFont(new Font("Raleway", Font.BOLD, 12));
        usr.setBounds(20, 320, 100, 56);
        add(usr);
        JLabel usr1 = new JLabel(w[9]);
        usr1.setFont(new Font("Raleway", Font.BOLD, 12));
        usr1.setBounds(120, 320, 100, 56);
        add(usr1);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(50, 400, 150, 30);
        add(bback);
        bback.addActionListener(this);

        bupdate = new JButton("Update");
        bupdate.setFont(new Font("Raleway", Font.BOLD, 12));
        bupdate.setBounds(350, 400, 150, 30);
        add(bupdate);
        bupdate.addActionListener(this);


        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==bback){
            dispose();
            new homepage(awe);
        }
        else if(e.getSource()==bupdate){
            dispose();
            new updatepage(awe);

        }
    }
    public static void main(String[] args) {
        new profilepage("arvind35");
    }
    
    
}
