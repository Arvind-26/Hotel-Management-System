package hotelManagement;

import javax.swing.*;
import javax.swing.plaf.FontUIResource;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class loginPage extends JFrame implements ActionListener  {
  JLabel ltitle, luser, lpass, lor, ltitle2;
  JTextField tuser;
  JPasswordField ppass;
  JButton blogin, bsignin;
  JPanel plogin,psign;

  public loginPage() {
    setSize(850, 478);
    setLocationRelativeTo(null);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    getContentPane().setBackground(Color.WHITE);

    psign = new JPanel();
    psign.setBounds(425, 0, 425, 478);
    psign.setBackground(new Color(225,95,31));
    psign.setLayout(null);
    add(psign);

    plogin = new JPanel();
    plogin.setBounds(0, 0, 425, 478);    
    plogin.setBackground(Color.WHITE);
    plogin.setLayout(null);
    add(plogin);

    ltitle = new JLabel("LOGIN");
    ltitle.setFont(new Font("Times", Font.BOLD, 38));
    ltitle.setForeground(new Color(225,95,31));
    ltitle.setBounds(150, 40, 140, 40);
    plogin.add(ltitle);

    luser = new JLabel("Username");
    luser.setFont(new Font("Ralway", Font.BOLD, 13));
    luser.setBounds(40, 150, 120, 20);
    plogin.add(luser);

    tuser = new JTextField();
    tuser.setBounds(40, 175, 350, 30);
    tuser.setFont(new Font("Ralway", Font.PLAIN, 17));
    plogin.add(tuser);

    lpass = new JLabel("Password");
    lpass.setFont(new Font("Ralway", Font.BOLD, 13));
    lpass.setBounds(40, 240, 120, 20);
    plogin.add(lpass);

    ppass = new JPasswordField();
    ppass.setBounds(40, 265, 350, 30);
    ppass.setFont(new Font("Ralway", Font.PLAIN, 17));
    plogin.add(ppass);

    blogin = new JButton("Login");
    blogin.setBounds(156, 343, 110, 35);
    blogin.setBackground(new Color(225,95,31));
    blogin.setForeground(Color.WHITE);
    blogin.setFont(new FontUIResource("Times", Font.PLAIN, 15));
    blogin.setBorderPainted(false);
    plogin.add(blogin);
    blogin.addActionListener(this);

    ltitle2 = new JLabel("CREATE ACCOUNT");
    ltitle2.setFont(new Font("Times", Font.BOLD, 38));
    ltitle2.setForeground(Color.WHITE);
    ltitle2.setBounds(20, 40, 380, 40);
    psign.add(ltitle2);

    bsignin = new JButton("Sign in");
    bsignin.setBounds(156, 343, 110, 35);
    bsignin.setBackground(Color.white);
    bsignin.setForeground(new Color(225,95,31));
    bsignin.setFont(new FontUIResource("Times", Font.PLAIN, 15));
    bsignin.setBorderPainted(false);
    psign.add(bsignin);
    bsignin.addActionListener(this);
    setResizable(false);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    try {
      if (e.getSource() == blogin) {
        String username = tuser.getText();
        char[] password = ppass.getPassword();
        String password1 = new String(password);
        mysqlconnection con = new mysqlconnection();
        ResultSet rs = con.st
            .executeQuery("select * from users where username='" + username + "' and password='" + password1 + "'");
        rs.next();
        try {
          if (rs.getString("username").equals(username) && rs.getString("password").equals(password1)) {
            new homepage(username);
            dispose();
          }
        } catch (Exception o) {
          JOptionPane.showMessageDialog(null, "Invalid Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
        }
      } else if (e.getSource() == bsignin) {
        new signinpage();
        dispose();
      }
    } catch (Exception E) {
      System.out.println(E);
    }
  }

  public static void main(String args[]) {
    new loginPage();
  }
}