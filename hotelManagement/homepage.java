package hotelManagement;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;


public class homepage extends JFrame implements ActionListener {


    JButton btn1, btn2, btn3, back;
    String ne;
    homepage(String nr){
        super("Home Page");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100); 
        setLayout(null);

        ImageIcon img1 = new ImageIcon("icons\\pc.png");
        Image scaledImage1 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon11 = new ImageIcon(scaledImage1);

        btn1 = new JButton("Boolking", scaledIcon11);
        btn1.setHorizontalTextPosition(JButton.CENTER);
        btn1.setVerticalTextPosition(JButton.BOTTOM);
        btn1.setBounds(30, 130, 150, 175);
        add(btn1);
        btn1.addActionListener(this);

        ImageIcon img2 = new ImageIcon("icons\\list.png");
        Image scaledImage2 = img2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon22 = new ImageIcon(scaledImage2);

        btn2 = new JButton("Booked List", scaledIcon22);
        btn2.setHorizontalTextPosition(JButton.CENTER);
        btn2.setVerticalTextPosition(JButton.BOTTOM);
        btn2.setBounds(215, 130, 150, 175);
        add(btn2);
        btn2.addActionListener(this);

        ImageIcon img3 = new ImageIcon("icons\\person.png");
        Image scaledImage3 = img3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon33 = new ImageIcon(scaledImage3);

        btn3 = new JButton("Profile", scaledIcon33);
        btn3.setHorizontalTextPosition(JButton.CENTER);
        btn3.setVerticalTextPosition(JButton.BOTTOM);
        btn3.setBounds(400, 130, 150, 175);
        add(btn3);
        btn3.addActionListener(this);

        
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
        }}
}
