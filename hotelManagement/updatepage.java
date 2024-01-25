package hotelManagement;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class updatepage extends JFrame implements ActionListener{
    JTextField  age, add, country, mailfild, phone;
    JRadioButton male, female, other;
    String ne;
    JButton bback, savechange, del;
    updatepage(String nr){
        super("Update");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);

        mysqlconnection ch = new mysqlconnection();
        ne = nr;
        ResultSet rs;
        String [] h = new String[10];
        try{
            rs = ch.st.executeQuery("select * from users where username= '"+ne+"'");
            rs.next();

            String [] q = {"firstname","middlename","lastname","age","gender","address","country","mail","phonenum","username"};

            for(int i = 0; i<q.length ;i++){
                h[i] = rs.getString(q[i]);
            }
        }catch(Exception a){
            System.out.println(a);
        }



        JLabel head = new JLabel("Make Changes");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 250, 40);
        add(head);

        JLabel firstname = new JLabel("First Name :"+" "+h[0]);
        firstname.setFont(new Font("Raleway", Font.BOLD, 15));
        firstname.setBounds(20, 70, 200, 56);
        add(firstname);


        JLabel midname = new JLabel("Middle Name :"+" "+h[1]);
        midname.setFont(new Font("Raleway", Font.BOLD, 15));
        midname.setBounds(200, 70, 200, 56);
        add(midname);

        JLabel lastname = new JLabel("Last Name :"+" "+h[2]);
        lastname.setFont(new Font("Raleway", Font.BOLD, 15));
        lastname.setBounds(395, 70, 200, 56);
        add(lastname);

        JLabel uage = new JLabel("Age : ");
        uage.setFont(new Font("Raleway", Font.BOLD, 15));
        uage.setBounds(20, 120, 100, 56);
        add(uage);
        age = new JTextField(2);
        age.setFont(new Font("Raleway", Font.BOLD, 15));
        age.setBounds(90, 140, 100, 20);
        add(age);
        age.setText(h[3]);

        JLabel Gender = new JLabel("Gender : "+ " "+h[4]);
        Gender.setFont(new Font("Raleway", Font.BOLD, 15));
        Gender.setBounds(300, 120, 150, 56);
        add(Gender);

        JLabel adss = new JLabel("Address : ");
        adss.setFont(new Font("Raleway", Font.BOLD, 15));
        adss.setBounds(20, 170, 200, 56);
        add(adss);
        add = new JTextField();
        add.setFont(new Font("Raleway", Font.BOLD, 15));
        add.setBounds(100, 190, 250, 20);
        add(add);
        add.setText(h[5]);

        JLabel count = new JLabel("Country : ");
        count.setFont(new Font("Raleway", Font.BOLD, 15));
        count.setBounds(370, 170, 100, 56);
        add(count);
        country = new JTextField();
        country.setFont(new Font("Raleway", Font.BOLD, 15));
        country.setBounds(440, 190, 125, 18);
        add(country);
        country.setText(h[6]);

        JLabel mail = new JLabel("Mail Address : ");
        mail.setFont(new Font("Raleway", Font.BOLD, 15));
        mail.setBounds(20, 220, 150, 56);
        add(mail);
        mailfild = new JTextField();
        mailfild.setFont(new Font("Raleway", Font.BOLD, 15));
        mailfild.setBounds(150, 240, 300, 20);
        add(mailfild);
        mailfild.setText(h[7]);

        JLabel phn = new JLabel("Phone Number : ");
        phn.setFont(new Font("Raleway", Font.BOLD, 15));
        phn.setBounds(20, 280, 150, 56);
        add(phn);
        phone = new JTextField();
        phone.setFont(new Font("Raleway", Font.BOLD, 15));
        phone.setBounds(150, 300, 300, 20);
        add(phone);
        phone.setText(h[8]);

        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(20, 380, 150, 30);
        add(bback);
        bback.addActionListener(this);

        savechange = new JButton("Save Change");
        savechange.setFont(new Font("Raleway", Font.BOLD, 12));
        savechange.setBounds(410, 380, 150, 30);
        add(savechange);
        savechange.addActionListener(this);

        del = new JButton("Delete Account");
        del.setFont(new Font("Raleway", Font.BOLD, 12));
        del.setBounds(220, 380, 150, 30);
        add(del);
        del.addActionListener(this);

    }

    @Override
        public void actionPerformed(ActionEvent g){
            if(g.getSource().equals(bback)){
                new profilepage(ne);
                dispose();
            }
            else if (g.getSource().equals(savechange)){
                int aagg = Integer.parseInt(age.getText());
                String ad = add.getText();
                String ct = country.getText();
                String m = mailfild.getText();
                long p = Long.parseLong(phone.getText());
                mysqlconnection ch = new mysqlconnection();

                try {
                    ch.st.executeUpdate("update users set age ="+aagg+" , address ='"+ad+"', country ='"+ct+"', mail ='"+m+"',phonenum ="+p+" where username ='"+ne+"'");
                } catch (SQLException e) {
                    System.out.println(e);
                }
                new profilepage(ne);
                dispose();
                
            }else if(g.getSource().equals(del)){
                mysqlconnection ch = new mysqlconnection();
                try{
                    ch.st.executeUpdate("delete from users where username = '"+ne+"'");
                    try{
                        ch.st.executeUpdate("drop table "+ne+"");
                    }catch(Exception d){
                    
                    }
                    dispose();
                    new loginPage();
                }catch(Exception f){
                    System.out.println(f);
                }
            }
        }

    public static void main(String[] args) {
        new updatepage("Arvind62");
    }
    
}
