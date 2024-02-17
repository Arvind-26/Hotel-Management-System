package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class profilepage extends JFrame implements ActionListener{
    JButton bback , bupdate;
    String awe,rust;
    
    JPanel sidepan;
    profilepage(String awr){
        super("Profile");
        awe = awr;
        mysqlconnection con = new mysqlconnection();
        ResultSet rs;
        String [] w = new String[10];
        try {
            rs = con.st.executeQuery("select * from users where username='"+awe+"'");
            rs.next();
            String [] q = {"firstname","lastname","age","gender","address","country","mail","phonenum","username"};
            
            for(int j = 0;j<q.length;j++){

                w[j] = rs.getString(q[j]);
            
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    


        setSize(800, 470);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image tr = Toolkit.getDefaultToolkit().getImage("Hotel-Management-System\\icons\\tringle.png");
        setIconImage(tr);

        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        sidepan.setBounds(0,0,180,478);
        sidepan.setBackground(new Color(210, 4, 45));;
        sidepan.setLayout(null);
        add(sidepan);


        
        ImageIcon pro = new ImageIcon("Hotel-Management-System\\icons\\Male.png");
        Image pro2 = pro.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);

        ImageIcon pro1 = new ImageIcon("Hotel-Management-System\\icons\\female.png");
        Image pro21 = pro1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        
        if(w[3].equals("Male")){
            JLabel pro3 = new JLabel(new ImageIcon(pro2));
            pro3.setBounds(40,30,100,100);
            sidepan.add(pro3);
        }else if(w[3].equals("Female")){
            JLabel pro3 = new JLabel(new ImageIcon(pro21));
            pro3.setBounds(40,30,100,100);
            sidepan.add(pro3);
        }

        
        
         
        JLabel head1 = new JLabel("Profile");
        head1.setFont(new Font("", Font.BOLD, 32));
        head1.setBounds(40, 150, 300, 40);
        head1.setForeground(Color.WHITE);
        sidepan.add(head1);

        JLabel head = new JLabel("INFORMATION");
        head.setFont(new Font("Times", Font.BOLD, 30));
        head.setBounds(200, 10, 300, 40);
        head.setForeground(new Color(210, 4, 45));
        add(head);

        JLabel i1 = new JLabel("Name");
        i1.setFont(new Font("Times", Font.BOLD, 20));
        i1.setBounds(200, 80, 120, 20);
        add(i1);

       

        JLabel i2 = new JLabel(w[0]+" "+w[1]);
        i2.setFont(new Font("Times", Font.PLAIN, 17));
        i2.setBounds(200, 100, 250, 30);
        add(i2);
         


        JLabel i3 = new JLabel("Username");
        i3.setFont(new Font("Raleway", Font.BOLD, 20));
        i3.setBounds(200, 133, 100, 56);
        add(i3);

        JLabel i4 = new JLabel(awe);
        i4.setFont(new Font("Times", Font.PLAIN, 17));
        i4.setBounds(200, 173, 100, 30);
        add(i4);
        

        JLabel i5 = new JLabel("Age");
        i5.setFont(new Font("Times", Font.BOLD, 20));
        i5.setBounds(200, 225, 250, 30);
        add(i5);

        JLabel i6 = new JLabel(w[2]);
        i6.setFont(new Font("Times", Font.PLAIN, 17));
        i6.setBounds(200, 250, 100, 30);
        add(i6);

        
        JLabel i7 = new JLabel("Gender");
        i7.setFont(new Font("Times", Font.BOLD, 20));
        i7.setBounds(200, 300, 150, 30);
        add(i7);

        JLabel i8 = new JLabel(w[3]);
        i8.setFont(new Font("Times", Font.PLAIN, 17));
        i8.setBounds(200, 320, 350, 30);
        add(i8);

        
        JLabel i9 = new JLabel("City");
        i9.setFont(new Font("Times", Font.BOLD, 20));
        i9.setBounds(450, 75, 150, 30);
        add(i9);

        JLabel i10 = new JLabel(w[4]);
        i10.setFont(new Font("Times", Font.PLAIN, 17));
        i10.setBounds(450, 100, 350, 30);
        add(i10);

        
        JLabel i11 = new JLabel("Country");
        i11.setFont(new Font("Times", Font.BOLD, 20));
        i11.setBounds(450, 145, 150, 30);
        add(i11);

         JLabel i12 = new JLabel(w[5]);
        i12.setFont(new Font("Times", Font.PLAIN, 17));
        i12.setBounds(450, 170, 155, 30);
        add(i12);

        
        JLabel i13 = new JLabel("Email");
        i13.setFont(new Font("Times", Font.BOLD, 20));
        i13.setBounds(450, 225, 150, 30);
        add(i13);

        JLabel i14 = new JLabel(w[6]);
        i14.setFont(new Font("Times", Font.PLAIN, 17));
        i14.setBounds(450, 250, 220, 30);
        add(i14);

      

        JLabel i15 = new JLabel("Phone");
        i15.setFont(new Font("Times", Font.BOLD, 20));
        i15.setBounds(450, 300, 100, 30);
        add(i15);

        JLabel i16 = new JLabel(w[7]);
        i16.setFont(new Font("Times", Font.PLAIN, 17));
        i16.setBounds(450, 320, 270, 30);
        add(i16);
         

        bback = new JButton("Back");
        bback.setFont(new Font("Times", Font.PLAIN, 15));
        bback.setBackground(Color.white);
        bback.setForeground(new Color(210, 4, 45));
        bback.setBorderPainted(false);
        bback.setBounds(25, 370, 125, 35);
        sidepan.add(bback); 
        bback.addActionListener(this);

        
        bupdate = new JButton("Update");
        bupdate.setFont(new Font("Times", Font.PLAIN, 15));
        bupdate.setBackground(new Color(210, 4, 45));
        bupdate.setForeground(Color.WHITE);
        bupdate.setBorderPainted(false);
        bupdate.setBounds(600, 370, 125, 35);
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
    
   
    
}
