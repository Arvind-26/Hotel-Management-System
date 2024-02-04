package hotelManagement;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;


public class bedselectpage extends JFrame implements ActionListener{
    JLabel head ,ls,ld,lt,lsdes,lddes,ltdes;
    JButton bsingle, bdouble, btriple, bback;
    JPanel ps,pd,pt;
    BufferedImage single;
    String ne;
    public bedselectpage(String nr){
        super("BEDZ");
        ne = nr;
        setSize(850, 478);
        setLocationRelativeTo(null);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(225,95,31));

        Image tr = Toolkit.getDefaultToolkit().getImage("package\\apk\\icons\\tringle.png");
        setIconImage(tr);

        ps = new JPanel();
        ps.setBounds(30,40,230,350);
        ps.setBackground(Color.WHITE);
        ps.setLayout(null);
        add(ps);  

        head = new JLabel("Beds");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 0, 100, 40);
        head.setForeground(Color.white);
        add(head);

        ImageIcon img1 = new ImageIcon("package\\apk\\icons\\singlebed.jpg");
        Image scaledImage1 = img1.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon1 = new ImageIcon(scaledImage1);

        ls = new JLabel(scaledIcon1);
        ls.setBounds(0,0,230,230);
        ps.add(ls);
        
        String l1 = "<html>A single hotel room is designed for One guest, featuring a single bed and essential amenities like a TV, desk, and en-suite bathroom. It provides a comfortable and efficient space for solo travelers.</html>";

        lsdes = new JLabel(l1);
        lsdes.setFont(new Font("Raleway", Font.PLAIN, 9));
        lsdes.setBounds(10,230,210,60);
        ps.add(lsdes);

        bsingle = new JButton("Book");
        bsingle.setFont(new Font("Raleway", Font.BOLD, 12));
        bsingle.setBounds(60, 310, 100, 30);
        bsingle.setBackground(new Color(225,95,31));
        bsingle.setForeground(Color.WHITE);
        bsingle.setBorderPainted(false);
        ps.add(bsingle);
        bsingle.addActionListener(this);

        pd = new JPanel();
        pd.setBounds(300,40,230,350);
        pd.setBackground(Color.WHITE);
        pd.setLayout(null);
        add(pd);

        ImageIcon img2 = new ImageIcon("package\\apk\\icons\\doublebed.jpg");
        Image scaledImage2 = img2.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);

        ld = new JLabel(scaledIcon2);
        ld.setBounds(0,0,230,230);
        pd.add(ld);

        String l2 = "<html>A double bed hotel room is designed to accommodate Two guests, a double bed and essential amenities TV and en-suite bathroom. It provides a comfortable and convenient space for couples who prefer more sleeping space.</html>";

        lddes = new JLabel(l2);
        lddes.setFont(new Font("Raleway", Font.PLAIN, 9));
        lddes.setBounds(10,230,210,60);
        pd.add(lddes);

        bdouble = new JButton("Book");
        bdouble.setFont(new Font("Raleway", Font.BOLD, 12));
        bdouble.setBounds(60, 310, 100, 30);
        bdouble.setBackground(new Color(225,95,31));
        bdouble.setForeground(Color.WHITE);
        bdouble.setBorderPainted(false);
        pd.add(bdouble);
        bdouble.addActionListener(this);

        pt = new JPanel();
        pt.setBounds(570,40,230,350);
        pt.setBackground(Color.WHITE);
        pt.setLayout(null);
        add(pt);

        ImageIcon img3 = new ImageIcon("package\\apk\\icons\\triplebed.jpg");
        Image scaledImage3 = img3.getImage().getScaledInstance(230, 230, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon3 = new ImageIcon(scaledImage3);

        lt = new JLabel(scaledIcon3);
        lt.setBounds(0,0,230,230);
        pt.add(lt);

        String l3 = "<html>A triple bed hotel room is tailored for Three guests, typically offering three separate beds or a combination of larger and smaller beds. Equipped with essential amenities like a TV, desk, and en-suite bathroom.</html>";

        ltdes = new JLabel(l3);
        ltdes.setFont(new Font("Raleway", Font.PLAIN, 9));
        ltdes.setBounds(10,230,210,60);
        pt.add(ltdes);

        btriple = new JButton("Book");
        btriple.setFont(new Font("Raleway", Font.BOLD, 12));
        btriple.setBounds(60, 310, 100, 30);
        btriple.setBackground(new Color(225,95,31));
        btriple.setForeground(Color.WHITE);
        btriple.setBorderPainted(false);
        pt.add(btriple);
        btriple.addActionListener(this);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(30, 400, 150, 30);
        bback.setBackground(Color.WHITE);
        bback.setForeground(new Color(225,95,31));
        bback.setBorderPainted(false);
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
