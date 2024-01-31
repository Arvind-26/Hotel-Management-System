package hotelManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

class loginPage extends JFrame implements ActionListener {
  JLabel ltitle, luser, lpass, lor;
  JTextField tuser;
  JPasswordField ppass;
  JButton blogin, bsignin;

  public loginPage() {
    setSize(450, 400);
    setLocation(440, 170);
    getContentPane().setBackground(Color.lightGray);
    setLayout(null);
    setDefaultCloseOperation(EXIT_ON_CLOSE);

    ltitle = new JLabel("Login");
    ltitle.setFont(new Font("Ralway", Font.BOLD, 30));
    ltitle.setBounds(10, 0, 80, 40);
    add(ltitle);

    luser = new JLabel("Username:");
    luser.setFont(new Font("Ralway", Font.BOLD, 15));
    luser.setBounds(67, 100, 120, 20);
    add(luser);

    tuser = new JTextField();
    tuser.setBounds(180, 100, 120, 20);
    add(tuser);

    lpass = new JLabel("Password:");
    lpass.setFont(new Font("Ralway", Font.BOLD, 15));
    lpass.setBounds(67, 150, 120, 20);
    add(lpass);

    ppass = new JPasswordField();
    ppass.setBounds(180, 150, 120, 20);
    add(ppass);

    blogin = new JButton("Login");
    blogin.setBounds(180, 190, 100, 30);
    add(blogin);
    blogin.addActionListener(this);

    lor = new JLabel("-------OR-------");
    lor.setFont(new Font("Ralway", Font.ITALIC, 15));
    lor.setBounds(180, 235, 120, 20);
    add(lor);

    bsignin = new JButton("Sign in");
    bsignin.setBounds(180, 280, 100, 30);
    add(bsignin);
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
        System.out.println(password1);
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