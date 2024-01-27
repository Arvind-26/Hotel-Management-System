package hotelManagement;

import javax.swing.*;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class bedselectpage extends JFrame implements ActionListener{
    JLabel head;
    JButton bsingle, bdouble, btriple, bback;
    BufferedImage single;
    String ne;
    public bedselectpage(String nr){
        super("Bed Rooms");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        head = new JLabel("Beds");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 100, 40);
        add(head);

        ImageIcon img1 = new ImageIcon("Hotel-Management-System//hotelManagement//icon//singlebed.jpg");
        Image scaledImage1 = img1.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);

        bsingle = new JButton("Single Bedroom", scaledIcon1);
        bsingle.setHorizontalTextPosition(JButton.CENTER);
        bsingle.setVerticalTextPosition(JButton.BOTTOM);
        bsingle.setFont(new Font("Raleway", Font.BOLD, 12));
        bsingle.setBounds(20, 70, 170, 200);
        add(bsingle);
        bsingle.addActionListener(this);

        ImageIcon img2 = new ImageIcon("Hotel-Management-System//hotelManagement//icon//doublebed.jpg");
        Image scaledImage2 = img2.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        bdouble = new JButton("Double Bedroom", scaledIcon2);
        bdouble.setHorizontalTextPosition(JButton.CENTER);
        bdouble.setVerticalTextPosition(JButton.BOTTOM);
        bdouble.setFont(new Font("Raleway", Font.BOLD, 12));
        bdouble.setBounds(210, 70, 170, 200);
        add(bdouble);
        bdouble.addActionListener(this);

        ImageIcon img3 = new ImageIcon("Hotel-Management-System//hotelManagement//icon//triplebed.jpg");
        Image scaledImage3 = img3.getImage().getScaledInstance(170, 170, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        btriple = new JButton("Triple Bedroom", scaledIcon3);
        btriple.setHorizontalTextPosition(JButton.CENTER);
        btriple.setVerticalTextPosition(JButton.BOTTOM);
        btriple.setFont(new Font("Raleway", Font.BOLD, 12));
        btriple.setBounds(400, 70, 170, 200);
        add(btriple);
        btriple.addActionListener(this);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(50, 400, 150, 30);
        add(bback);
        bback.addActionListener(this);
        setResizable(false);;
        setVisible(true);
    }
        @Override
        public void actionPerformed(ActionEvent e) {
            if(e.getSource()==bsingle){
                dispose();
                new bookingpage("single",ne);
            }
            else if(e.getSource()==bdouble){
                dispose();
                new bookingpage("double",ne);
            }
            else if(e.getSource()==btriple){
                dispose();
                new bookingpage("triple",ne);
            }
            else if(e.getSource()==bback){
                dispose();
                new homepage(ne);
            }            
    }
    
}
