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




public class aboutus extends JFrame implements ActionListener{
    JButton bback,babt,btc,bpp;
    JPanel sidepan;
    JLabel labo,ltc,mb;
    String a,b,c,d,f,g,ne;
    public aboutus(String nr){
        super("BEDZ");
        ne = nr;
        setSize(800, 470);
        setLocationRelativeTo(null); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
    
        Image tr = Toolkit.getDefaultToolkit().getImage("icons\\tringle.png");
        setIconImage(tr);

        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        sidepan.setBounds(0,0,180,478);
        sidepan.setBackground(new Color(210, 4, 45));;
        sidepan.setLayout(null);
        add(sidepan);

        babt = new JButton("About Us");
        babt.setBounds(25,25,135,30);
        babt.setForeground(Color.white);
        babt.setContentAreaFilled(false);
        babt.setBorderPainted(false);
        babt.setOpaque(false);
        sidepan.add(babt);
        babt.addActionListener(this);

        String v = "<html>Terms & Conditions</html>";
        btc = new JButton(v);
        btc.setBounds(25,70,135,30);
        btc.setForeground(Color.white);
        btc.setContentAreaFilled(false);
        btc.setBorderPainted(false);
        sidepan.add(btc);
        btc.addActionListener(this);

        bpp = new JButton("Privacy Policy");
        bpp.setBounds(25,120,135,30);
        bpp.setForeground(Color.white);
        bpp.setContentAreaFilled(false);
        bpp.setBorderPainted(false);
        sidepan.add(bpp);
        bpp.addActionListener(this);

        d = "About Us";
        f = "Terms & Condition";
        g = "Privacy Policy";        
       

        a = "<html>BEDZ companion for stress-free room bookings. As your personal room matchmaker, I'll help you find the ideal accommodation tailored to your preferences. With BEDZ, enjoy a secure and straightforward booking experience. Whether it's a quick getaway or a longer stay, I've got your booking needs covered. Let's make every reservation a breeze! #BEDZ #BookWithEase</html>";
        b = "<html>1. Confirmed booking & verify details<br>2. Check hotel cancellation & refund policies<br>3. Secure payment, no stored info, extra charges may apply<br>4. Data confidentiality, no third-party sharing without consent<br>5. Follow hotel rules, BEDZ not responsible for non-compliance<br>6. Respect community guidelines, inappropriate behavior may lead to suspension<br>7. Modifications subject to availability & charges may apply<br>8. BEDZ not liable, recommend travel insurance<br>9. Service suspension for policy violations<br>10. Contact for assistance & report issues <br>By using BEDZ, you agree to these Terms & Conditions. Safe travels!  #BEDZ #TermsAndConditions" + //
                        "</html>";
        c = "<html>1. Information Collected: We collect personal information such as name, contact details, and payment information for booking purposes.<br>2. Security Measures: BEDZ employs industry-standard security measures to protect your data; we do not store sensitive payment information on our servers.<br>3. Sharing Your Information: Your personal information is shared with hotels for booking confirmation purposes only; BEDZ does not sell, trade, or rent your information to third parties.<br>5. Cookies and Tracking: BEDZ uses cookies to enhance user experience and gather analytics; you can manage cookie preferences in your app settings.<br>6. Third-Party Links: BEDZ may contain links to third-party websites; we are not responsible for their privacy practices.<br>7. User Controls: You can update, correct, or delete your personal information in the app settings; opt-out of promotional communications by adjusting your preferences.<br>#BEDZ #PrivacyPolicy</html>";


        ltc = new JLabel(d);
        ltc.setBounds(200,10,250,40);
        ltc.setFont(new Font("Times", Font.PLAIN, 20));
        ltc.setVerticalAlignment(JLabel.TOP);
        add(ltc);

        labo = new JLabel(a);
        labo.setBounds(200,40,550,300);
        labo.setFont(new Font("Times", Font.PLAIN, 15));
        labo.setVerticalAlignment(JLabel.TOP);
        add(labo);

        String h = "<html>Developed By : ARVIND & RUDRA<br>Contact : 8446055290 / 9890812560<br>Email : langoterudra@gmail.com</html>";
        mb = new JLabel(h);
        mb.setFont(new Font("Times", Font.PLAIN, 15));
        mb.setBounds(200,350,400,70);
        add(mb);

        bback = new JButton("Back");
        bback.setFont(new Font("Times", Font.PLAIN, 15));
        bback.setBackground(Color.white);
        bback.setForeground(new Color(210, 4, 45));
        bback.setBorderPainted(false);
        bback.setBounds(25, 370, 125, 35);
        sidepan.add(bback); 
        bback.addActionListener(this);
        setResizable(false);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource().equals(bback)){
            dispose();
            new homepage(ne);
        }
        else if(e.getSource().equals(babt)){
            ltc.setText(d);
            labo.setText(a);
        }
        else if(e.getSource().equals(btc)){
            ltc.setText(f);
            labo.setText(b);
        }
        else if(e.getSource().equals(bpp)){
            ltc.setText(g);
            labo.setText(c);
        }
        
    }

}
