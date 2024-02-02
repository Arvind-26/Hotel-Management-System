package hotelManagement;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class updatepage extends JFrame implements ActionListener {
    JTextField age, add, country, mailfild, phone;
    JRadioButton male, female, other;
    String ne;
    JButton bback, savechange, del;
    JPanel sidepan;

    updatepage(String nr) {
        super("BEDZ");
        ne = nr;
        setSize(800, 478);
        setLocationRelativeTo(null);
        setLayout(null);

        mysqlconnection ch = new mysqlconnection();
        ne = nr;
        ResultSet rs;
        String[] w = new String[10];
        try {
            rs = ch.st.executeQuery("select * from users where username= '" + ne + "'");
            rs.next();

            String[] q = { "firstname", "lastname", "age", "gender", "address", "country", "mail",
                    "phonenum", "username" };

            for (int i = 0; i < q.length; i++) {
                w[i] = rs.getString(q[i]);
            }
        } catch (Exception a) {
            System.out.println(a);
        }

        Image tr = Toolkit.getDefaultToolkit().getImage("package\\apk\\icons\\tringle.png");
        setIconImage(tr);

        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        ImageIcon bgg = new ImageIcon("package\\apk\\icons\\bgg.png");
        Image bgg2 = bgg.getImage().getScaledInstance(200,478, Image.SCALE_DEFAULT);
        JLabel bgg3 = new JLabel(new ImageIcon(bgg2));
        bgg3.setBounds(0,0,200,478);
        sidepan.add(bgg3);
        sidepan.setLayout(null);
        add(sidepan);

       

        JLabel head = new JLabel("UPDATE INFORMATION");
        head.setFont(new Font("Times", Font.BOLD, 30));
        head.setBounds(200, 10, 400, 40);
        head.setForeground(new Color(225,95,31));
        add(head);
        

        JLabel i2 = new JLabel(w[0]+" "+w[1]);
        i2.setFont(new Font("Times", Font.BOLD, 25));
        i2.setBounds(200, 70, 250, 30);
        add(i2);
         

        JLabel i4 = new JLabel(ne);
        i4.setFont(new Font("Times", Font.PLAIN, 19));
        i4.setBounds(200, 95, 100, 30);
        add(i4);
        
       
        
        JLabel uage = new JLabel("Age");
        uage.setFont(new Font("Times", Font.BOLD, 13));
        uage.setBounds(200, 150, 250, 30);
        add(uage);
        age = new JTextField(2);
        age.setFont(new Font("Times", Font.PLAIN, 17));
        age.setBounds(255, 150, 100, 30);
        add(age);
        age.setText(w[2]);
          

        

        JLabel adss = new JLabel("City");
        adss.setFont(new Font("Times", Font.BOLD, 13));
        adss.setBounds(200, 200, 150, 30);
        add(adss);
        add = new JTextField();
        add.setFont(new Font("Times", Font.PLAIN, 17));
        add.setBounds(255, 200, 350, 30);
        add(add);
        add.setText(w[4]);

       

        JLabel count = new JLabel("Country");
        count.setFont(new Font("Times", Font.BOLD, 13));
        count.setBounds(200, 250, 150, 30);
        add(count);
        country = new JTextField();
        country.setFont(new Font("Times", Font.PLAIN, 17));
        country.setBounds(255, 250, 350, 30);
        add(country);
        country.setText(w[5]);

       

        JLabel mail = new JLabel("Email");
        mail.setFont(new Font("Times", Font.BOLD, 13));
        mail.setBounds(200, 300, 150, 30);
        add(mail);
        mailfild = new JTextField();
        mailfild.setFont(new Font("Times", Font.PLAIN, 17));
        mailfild.setBounds(255, 300, 350, 30);
        add(mailfild);
        mailfild.setText(w[6]);
         

        JLabel phn = new JLabel("Phone");
        phn.setFont(new Font("Times", Font.BOLD, 13));
        phn.setBounds(200, 350, 100, 30);
        add(phn);
        phone = new JTextField();
        phone.setFont(new Font("Times", Font.PLAIN, 17));
        phone.setBounds(255, 350, 350, 30);
        add(phone);
        phone.setText(w[7]);
        

        

       bback = new JButton("Back");
        bback.setFont(new Font("Times", Font.PLAIN, 15));
        bback.setBackground(Color.WHITE);
        bback.setForeground(new Color(225,95,31));
        bback.setBorderPainted(false);
        bback.setBounds(25, 370, 125, 35);
        bgg3.add(bback); 
        bback.addActionListener(this);
        

        savechange = new JButton("Save Change");
        savechange.setFont(new Font("Times", Font.PLAIN, 15));
        savechange.setBackground(new Color(225,95,31));
        savechange.setForeground(Color.WHITE);
        savechange.setBorderPainted(false);
        savechange.setBounds(620, 390, 125, 35);
        add(savechange); 
        savechange.addActionListener(this);
        

        del = new JButton("Delete Acount");
        del.setFont(new Font("Times", Font.PLAIN, 15));
        del.setBackground(new Color(225,95,31));
        del.setForeground(Color.WHITE);
        del.setBorderPainted(false);
        del.setBounds(200, 390, 125, 35);
        add(del); 
        del.addActionListener(this);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    

    @Override
    public void actionPerformed(ActionEvent g) {
        if (g.getSource().equals(bback)) {
            new profilepage(ne);
            dispose();
        } else if (g.getSource().equals(savechange)) {
            int aagg = Integer.parseInt(age.getText());
            String ad = add.getText();
            String ct = country.getText();
            String m = mailfild.getText();
            long p = Long.parseLong(phone.getText());
            mysqlconnection ch = new mysqlconnection();

            try {
                ch.st.executeUpdate("update users set age =" + aagg + " , address ='" + ad + "', country ='" + ct
                        + "', mail ='" + m + "',phonenum =" + p + " where username ='" + ne + "'");
            } catch (SQLException e) {
                System.out.println(e);
            }
            new profilepage(ne);
            dispose();

        } else if (g.getSource().equals(del)) {
            mysqlconnection ch = new mysqlconnection();
            try {
                ch.st.executeUpdate("delete from users where username = '" + ne + "'");
                try {
                    ch.st.executeUpdate("drop table " + ne + "");
                } catch (Exception d) {

                }
                dispose();
                new loginPage();
            } catch (Exception f) {
                System.out.println(f);
            }
        }
    }

    public static void main(String[] args) {
        new updatepage("Rudra19");
    }

}
