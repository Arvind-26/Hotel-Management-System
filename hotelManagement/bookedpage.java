package hotelManagement;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import java.io.File;
import java.io.FileWriter;
import java.util.Random;


public class bookedpage extends JFrame implements ActionListener{
    String ne;
    String data[][]= new String[20][4];
    JTable t;
    JScrollPane p;
    JButton bback, bdown;
    mysqlconnection con = new mysqlconnection();
    JTextField down;
    bookedpage(String nr){ 
        super("BEDZ");
        setSize(850, 470);
        ne = nr;
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        Image tr = Toolkit.getDefaultToolkit().getImage("package\\apk\\icons\\tringle.png");
        setIconImage(tr);

        JLabel head = new JLabel("Booked History");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setForeground(new Color(225,95,31));
        head.setBounds(10, 10, 250, 40);
        add(head);

        JPanel p1 = new JPanel(new FlowLayout());
        p1.setBounds(0,50,850,315);
        p1.setLayout(new FlowLayout());
        add(p1);

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
        sp.setPreferredSize(new Dimension(820, 310)); 
        p1.add(sp); 

        JLabel udown = new JLabel("Enter booking Id to downlaod: ");
        udown.setFont(new Font("Times", Font.BOLD, 13));
        udown.setBounds(400, 385, 250, 30);
        add(udown);
        down = new JTextField(2);
        down.setFont(new Font("Times", Font.PLAIN, 17));
        down.setBounds(595, 385, 100, 30);
        add(down);


        bdown = new JButton("Download");
        bdown.setFont(new Font("Times", Font.PLAIN, 15));
        bdown.setBackground(new Color(225,95,31));
        bdown.setForeground(Color.WHITE);
        bdown.setBorderPainted(false);
        bdown.setBounds(700, 380, 125, 35);
        add(bdown);
        bdown.addActionListener(this);

        bback = new JButton("Back");
        bback.setFont(new Font("Times", Font.PLAIN, 15));
        bback.setBackground(new Color(225,95,31));
        bback.setForeground(Color.WHITE);
        bback.setBorderPainted(false);
        bback.setBounds(25, 380, 125, 35);
        add(bback);
        bback.addActionListener(this);


        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bback)){
            dispose();
            new homepage(ne);}
        else if(e.getSource().equals(bdown)){
            Random filename = new Random();
            int rr = filename.nextInt(100000, 999999);
            String a = String.format("%d",rr);
            File file = new File("package/rcp/"+a+".txt");
            String downn = down.getText();
            String [] r = new String[5];
            try {
                FileWriter filewriter = new FileWriter(file);
                ResultSet sr = con.st.executeQuery("select * from "+ne+" where bookingid ='"+downn+"'");
                sr.next();
                String [] ee  = {"date","day","price","bookingid","recipt_no"};

                for(int i= 0;i<ee.length;i++){
                    r[i] = sr.getString(ee[i]);
                }

                filewriter.write("Recipt no. :  "+r[4]+"\n");
                filewriter.write("--------------------------------------------------"+"\n");
                filewriter.write("User :  "+ne+"\n");
                filewriter.write("Booking Id :   "+r[3]+"\n");
                filewriter.write("Date of Booking :  "+r[0]+"\n");
                filewriter.write("Booking days :  "+r[1]+"\n");
                filewriter.write("--------------------------------------------------"+"\n");
                filewriter.write("Price payable :  "+r[2]+"\n");
                filewriter.write("--------------------------------------------------");

                filewriter.close();
                Desktop desktop = Desktop.getDesktop();
                desktop.open(file);
   
            } catch (Exception e1) {
                System.out.println(e1);
            }

        }
    }
}
