package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class recipt extends JFrame{
    Random no;
    JButton bback;

    recipt(String nr, String id){
        setSize(600, 500);
        setLocation(400, 100); 
        getContentPane().setBackground(Color.lightGray);
        setLayout(null);
        String ne = nr;
        String iddd = id;

        mysqlconnection pr = new mysqlconnection();
        ResultSet rs;
        String [] r = new String[5];
        try{
            rs = pr.st.executeQuery("select * from "+ne+" where bookingid = '"+iddd+"' ");
            rs.next();
            String [] e  = {"date","day","price","bookingid","recipt_no"};

            for(int i= 0;i<e.length;i++){
                r[i] = rs.getString(e[i]);
            }
        }catch(Exception t){
            System.out.println(t);
        }
        
        
        JLabel head = new JLabel("Recipt");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 200, 40);
        add(head);

        JLabel tit = new JLabel("Recipt number :"+"  "+r[4]);
        tit.setFont(new Font("Raleway", Font.BOLD, 15));
        tit.setBounds(220, 90, 200, 40);
        add(tit);
        JLabel ine = new JLabel("----------------------------------------------------------------------------");
        ine.setFont(new Font("Raleway", Font.BOLD, 15));
        ine.setBounds(100, 110, 500, 40);
        add(ine);

        JLabel usr = new JLabel("User        : "+"          "+ne);
        usr.setFont(new Font("Raleway", Font.BOLD, 15));
        usr.setBounds(220, 150, 1000, 40);
        add(usr);

        JLabel sir = new JLabel("Booking id        : "+"          "+iddd);
        sir.setFont(new Font("Raleway", Font.BOLD, 15));
        sir.setBounds(178, 190, 250, 40);
        add(sir);

        JLabel db = new JLabel("Date of booking        : "+"          "+r[0]);
        db.setFont(new Font("Raleway", Font.BOLD, 15));
        db.setBounds(142, 230,300, 40);
        add(db);

        JLabel bc = new JLabel("Booking Days        : "+"          "+r[1]);
        bc.setFont(new Font("Raleway", Font.BOLD, 15));
        bc.setBounds(157, 270,300, 40);
        add(bc);

        JLabel ine2 = new JLabel("----------------------------------------------------------------------------");
        ine2.setFont(new Font("Raleway", Font.BOLD, 15));
        ine2.setBounds(100, 300, 500, 40);
        add(ine2);

        JLabel pc = new JLabel("Price Payable        : "+"          ₹"+r[2]);
        pc.setFont(new Font("Raleway", Font.BOLD, 15));
        pc.setBounds(157, 320,300, 40);
        add(pc);

        JLabel ine3 = new JLabel("----------------------------------------------------------------------------");
        ine3.setFont(new Font("Raleway", Font.BOLD, 15));
        ine3.setBounds(100, 340, 500, 40);
        add(ine3);

        bback = new JButton("Conferm Booking");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(220, 390, 150, 30);
        add(bback);
        bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(bback)){
                    dispose();
                    new bookedpage(nr);
                }
            }
            
        });;



        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   

    
}
