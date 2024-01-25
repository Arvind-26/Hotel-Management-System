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

        JLabel firstname = new JLabel("First Name :  "+ w[0]);
        firstname.setFont(new Font("Raleway", Font.BOLD, 15));
        firstname.setBounds(20, 70, 230, 56);
        add(firstname);

        JLabel midname = new JLabel("Middle Name :  "+w[1]);
        midname.setFont(new Font("Raleway", Font.BOLD, 15));
        midname.setBounds(200, 70, 200, 56);
        add(midname);

        JLabel lastname = new JLabel("Last Name :  "+w[2]);
        lastname.setFont(new Font("Raleway", Font.BOLD, 15));
        lastname.setBounds(395, 70, 230, 56);
        add(lastname);

        JLabel uage = new JLabel("Age :  "+w[3]);
        uage.setFont(new Font("Raleway", Font.BOLD, 15));
        uage.setBounds(20, 120, 100, 56);
        add(uage);

        JLabel Gender = new JLabel("Gender :  "+w[4]);
        Gender.setFont(new Font("Raleway", Font.BOLD, 15));
        Gender.setBounds(200, 120, 200, 56);
        add(Gender);

        JLabel adss = new JLabel("Address :  "+w[5]);
        adss.setFont(new Font("Raleway", Font.BOLD, 15));
        adss.setBounds(20, 170, 500, 56);
        add(adss);

        JLabel count = new JLabel("Country :  "+w[6]);
        count.setFont(new Font("Raleway", Font.BOLD, 15));
        count.setBounds(370, 170, 200, 56);
        add(count);

        JLabel mail = new JLabel("Mail Address :  "+w[7]);
        mail.setFont(new Font("Raleway", Font.BOLD, 15));
        mail.setBounds(20, 220, 300, 56);
        add(mail);

        JLabel phn = new JLabel("Phone Number :  "+w[8]);
        phn.setFont(new Font("Raleway", Font.BOLD, 15));
        phn.setBounds(20, 280, 300, 56);
        add(phn);

        JLabel usr = new JLabel("Username :  "+w[9]);
        usr.setFont(new Font("Raleway", Font.BOLD, 15));
        usr.setBounds(20, 320, 300, 56);
        add(usr);

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
