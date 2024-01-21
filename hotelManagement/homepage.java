package hotelManagement;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.w3c.dom.events.Event;

public class homepage extends JFrame {


    JButton btn1, btn2, btn3, back;
    homepage(){
        super("Home Page");
        setSize(600, 500);
        setLocation(400, 100); 
        setLayout(null);

        ImageIcon img1 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\pracjava\\icon\\pc.png");
        Image scaledImage1 = img1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon11 = new ImageIcon(scaledImage1);

        btn1 = new JButton("Boolking", scaledIcon11);
        btn1.setHorizontalTextPosition(JButton.CENTER);
        btn1.setVerticalTextPosition(JButton.BOTTOM);
        btn1.setBounds(30, 130, 150, 175);
        add(btn1);

        ImageIcon img2 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\pracjava\\icon\\list.png");
        Image scaledImage2 = img2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon22 = new ImageIcon(scaledImage2);

        btn2 = new JButton("Booked List", scaledIcon22);
        btn2.setHorizontalTextPosition(JButton.CENTER);
        btn2.setVerticalTextPosition(JButton.BOTTOM);
        btn2.setBounds(215, 130, 150, 175);
        add(btn2);

        ImageIcon img3 = new ImageIcon("C:\\Users\\lenovo\\Desktop\\pracjava\\icon\\person.png");
        Image scaledImage3 = img3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon33 = new ImageIcon(scaledImage3);

        btn3 = new JButton("Profile", scaledIcon33);
        btn3.setHorizontalTextPosition(JButton.CENTER);
        btn3.setVerticalTextPosition(JButton.BOTTOM);
        btn3.setBounds(400, 130, 150, 175);
        add(btn3);
        
        back = new JButton("Back");
        back.setFont(new Font("Raleway", Font.BOLD, 12));
        back.setBounds(210, 400, 150, 30);
        add(back);
        back.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();

            }
        });
        

        
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new homepage();
    }
}
