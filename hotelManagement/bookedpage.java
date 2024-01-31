package hotelManagement;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class bookedpage extends JFrame implements ActionListener{
    String ne;
    String data[][]= new String[11][4];
    JTable t;
    JScrollPane p;
    JButton bback;
    bookedpage(String nr){
        super("Bookings");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100);
        getContentPane().setBackground(Color.lightGray);
        setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel head = new JLabel("Booked History");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 250, 40);
        add(head);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.setSize(100, 100);
        add(p1);

        mysqlconnection con = new mysqlconnection();
        int j=0;
        String rew[] = {"bookingid","date", "day", "price"};
        try {
            ResultSet rs = con.st.executeQuery("select * from "+ne+"");
            while(rs.next()){
                for(int i = 0;i<=3;i++){
                    data[j][i] = rs.getString(rew[i]);
                }
                j++;
            }
        } catch (Exception e) {
            System.out.println(e);
        }       

        String column[] = {"bookingid","Date", "Days","Price"};
        JTable jt=new JTable(data,column);  
        jt.setEnabled(false);     
        jt.setRowHeight(20);     
        JScrollPane sp=new JScrollPane(jt);   
        sp.setPreferredSize(new Dimension(570, 300)); 
        p1.add(sp); 

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(20, 380, 150, 30);
        add(bback);
        bback.addActionListener(this);


        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        dispose();
        new homepage(ne);
    }
    
}
