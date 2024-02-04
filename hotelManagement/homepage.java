package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import javax.swing.plaf.FontUIResource;


public class homepage extends JFrame implements ActionListener {


    JButton btn1, btn2, btn3, back,abt;
    JPanel sidepan;
    String ne;
    homepage(String nr){
        super("BEDZ");
        ne = nr;
        setSize(800, 470);
        setLocationRelativeTo(null); 
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        Image tr = Toolkit.getDefaultToolkit().getImage("icons\\tringle.png");
        setIconImage(tr);

        ImageIcon bggrg = new ImageIcon("icons\\hbg.jpg");
        Image bggrgh = bggrg.getImage().getScaledInstance(620,478, Image.SCALE_DEFAULT);
        JLabel bgrgg3 = new JLabel(new ImageIcon(bggrgh));
        bgrgg3.setBounds(180,0,620,478);
        add(bgrgg3);
        


        

        
        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        sidepan.setBounds(0,0,180,478);
        sidepan.setBackground(new Color(210, 4, 45));
        sidepan.setLayout(null);
        add(sidepan);


        btn1 = new JButton("Boolking");

        btn1.setBounds(40, 20, 120, 35);
        btn1.setBackground(Color.white);
        btn1.setForeground(new Color(210, 4, 45));
        btn1.setFont(new FontUIResource("Times", Font.BOLD, 15));
        btn1.setBorderPainted(false);
        sidepan.add(btn1);
        btn1.addActionListener(this);

        
        btn2 = new JButton("Booked List");
        btn2.setBounds(40, 100, 120, 35);
        btn2.setBackground(Color.WHITE);
        btn2.setForeground(new Color(210, 4, 45));
        btn2.setFont(new FontUIResource("Times", Font.BOLD, 15));
        btn2.setBorderPainted(false);
        sidepan.add(btn2);
        btn2.addActionListener(this);

        btn3 = new JButton("Profile");
        btn3.setBounds(40, 180, 120, 35);
        btn3.setBackground(Color.WHITE);
        btn3.setForeground(new Color(210, 4, 45));
        btn3.setFont(new FontUIResource("Times", Font.BOLD, 15));
        btn3.setBorderPainted(false);
        sidepan.add(btn3);
        btn3.addActionListener(this);

        abt = new JButton("About Us");
        abt.setBounds(40, 360, 120, 35);
        abt.setBackground(Color.white);
        abt.setForeground(new Color(210, 4, 45));
        abt.setFont(new FontUIResource("Times", Font.BOLD, 15));
        abt.setBorderPainted(false);
        sidepan.add(abt);
        abt.addActionListener(this);

        JLabel wel = new JLabel("WELCOME TO BEDZ");
        wel.setBounds(50,30,600,200);
        wel.setFont(new FontUIResource(Font.SERIF, Font.BOLD, 50));
        wel.setForeground(Color.white);
        bgrgg3.add(wel);

        String g = "<html>BEDZ: Your go-to PC app for hassle-free room bookings. With BEDZ, easily reserve diverse rooms and manage profiles with a simple, intuitive interface. This system-exclusive application ensures seamless performance on your PC, delivering efficiency and convenience. Powered by a secure online database, BEDZ guarantees real-time updates for your bookings and profiles. Simplify your room reservations with BEDZ, designed exclusively for your PC experience. </html>";
        JLabel DEC = new JLabel(g);
        DEC.setBounds(60,170,500,200);
        DEC.setFont(new FontUIResource(Font.SERIF, Font.BOLD, 12));
        DEC.setForeground(Color.white);
        bgrgg3.add(DEC);




        
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btn1){
            dispose();
            new bedselectpage(ne);
        }
        else if(e.getSource()==btn2){
            dispose();
            new bookedpage(ne);            
        }
        
        else if(e.getSource()==btn3){
            dispose();
            new profilepage(ne);
        }else if(e.getSource()==abt){
            dispose();
            new aboutus(ne);
        }
    }
    
}
