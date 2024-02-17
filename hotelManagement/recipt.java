package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class recipt extends JFrame{
    Random no;
    JButton bback;
    JPanel poutline;

    recipt(String nr, String id){
        super("BEDZ");
        setSize(800, 470);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(new Color(210, 4, 45));
        setLayout(null);
        String ne = nr;
        String iddd = id;
        
        Image tr = Toolkit.getDefaultToolkit().getImage("Hotel-Management-System\\icons\\tringle.png");
        setIconImage(tr);

        poutline = new JPanel();
        poutline.setBounds(200,50,400,300);
        poutline.setBackground(Color.white);
        poutline.setLayout(null);
        add(poutline);

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
        head.setForeground(Color.white);
        head.setBounds(10, 10, 200, 40);
        add(head);

        JLabel tit = new JLabel("Recipt number :"+"  "+r[4]);
        tit.setFont(new Font("Raleway", Font.BOLD, 15));
        tit.setBounds(125, 0, 200, 40);
        poutline.add(tit);
        JLabel ine = new JLabel("----------------------------------------------------------------------------");
        ine.setFont(new Font("Raleway", Font.BOLD, 15));
        ine.setBounds(10, 15, 500, 40);
        poutline.add(ine);

        JLabel usr = new JLabel("User        : "+"          "+ne);
        usr.setFont(new Font("Raleway", Font.BOLD, 15));
        usr.setBounds(125, 50, 1000, 40);
        poutline.add(usr);

        JLabel sir = new JLabel("Booking id        : "+"          "+iddd);
        sir.setFont(new Font("Raleway", Font.BOLD, 15));
        sir.setBounds(83, 80, 250, 40);
        poutline.add(sir);

        JLabel db = new JLabel("Date of booking        : "+"          "+r[0]);
        db.setFont(new Font("Raleway", Font.BOLD, 15));
        db.setBounds(47, 110,300, 40);
        poutline.add(db);

        JLabel bc = new JLabel("Booking Days        : "+"          "+r[1]);
        bc.setFont(new Font("Raleway", Font.BOLD, 15));
        bc.setBounds(62, 140,300, 40);
        poutline.add(bc);

        JLabel ine2 = new JLabel("----------------------------------------------------------------------------");
        ine2.setFont(new Font("Raleway", Font.BOLD, 15));
        ine2.setBounds(10, 170, 500, 40);
        poutline.add(ine2);

        JLabel pc = new JLabel("Price Payable        : "+"          ₹"+r[2]);
        pc.setFont(new Font("Raleway", Font.BOLD, 15));
        pc.setBounds(62, 200,300, 40);
        poutline.add(pc);

        JLabel ine3 = new JLabel("----------------------------------------------------------------------------");
        ine3.setFont(new Font("Raleway", Font.BOLD, 15));
        ine3.setBounds(10, 220, 500, 40);
        poutline.add(ine3);

        bback = new JButton("Done");
        bback.setFont(new Font("Times", Font.PLAIN, 13));
        bback.setBackground(new Color(210, 4, 45));
        bback.setForeground(Color.WHITE);
        bback.setBorderPainted(false);
        bback.setBounds(125, 255, 140, 35); 
        poutline.add(bback);
        bback.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(bback)){
                    dispose();
                    new bookedpage(ne);
                }
            }
            
        });;



        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

   
    
}
