package hotelManagement;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

public class bookingpage extends JFrame implements ActionListener {
    JLabel head, db, sb, pricee,part;
    JDateChooser date;
    JComboBox selecttime;
    JButton bback, dane, book;
    int tot, rs;
    String ne;
    Random id, no;
    JPanel sidepan;

    bookingpage(String bed, String nr) {
        super("BEDZ");
        ne = nr;
        setSize(800, 470);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Image tr = Toolkit.getDefaultToolkit().getImage("icons\\tringle.png");
        setIconImage(tr);

        sidepan = new JPanel();
        sidepan.setBounds(0, 0, 180, 478);
        sidepan.setBounds(0,0,180,478);
        sidepan.setBackground(new Color(210, 4, 45));;
        sidepan.setLayout(null);
        add(sidepan);

        head = new JLabel("Book Your Room");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(200, 10, 300, 40);
        head.setForeground(new Color(210, 4, 45));
        add(head);

        if (bed.equals("single")) {
            rs = 300;
            JLabel que = new JLabel("1 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(200, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 300/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(200, 80, 200, 56);
            add(price);
        } else if (bed.equals("double")) {
            rs = 600;
            JLabel que = new JLabel("2 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(200, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 600/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(200, 80, 200, 56);
            add(price);
        } else if (bed.equals("triple")) {
            JLabel que = new JLabel("3 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(200, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 1000/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(200, 80, 200, 56);
            add(price);
            rs = 1000;
        }

        db = new JLabel("Date of booking");
        db.setFont(new Font("Raleway", Font.BOLD, 15));
        db.setBounds(260, 150, 200, 23);
        add(db);

        date = new JDateChooser();
        date.setMinSelectableDate(new Date());
        date.setBounds(200, 180, 250, 30);
        add(date);

        sb = new JLabel("Select Number of Days");
        sb.setFont(new Font("Raleway", Font.BOLD, 15));
        sb.setBounds(540, 150, 200, 23);
        add(sb);

        String[] s = { "--No days selected--", "1 Day", "2 Days", "3 Days", "4 Days", "5 Days", "6 Days", "7 Days",
                "8 Days", "9 Days", "10 Days" };
        selecttime = new JComboBox<>(s);
        selecttime.setBounds(500, 180, 250, 30);
        add(selecttime);

        bback = new JButton("Back");
        bback.setFont(new Font("Times", Font.PLAIN, 15));
        bback.setBackground(Color.white);
        bback.setForeground(new Color(210, 4, 45));
        bback.setBorderPainted(false);
        bback.setBounds(25, 370, 125, 35);
        sidepan.add(bback); 
        bback.addActionListener(this);

        dane = new JButton("Done");
        dane.setFont(new Font("Times", Font.PLAIN, 15));
        dane.setBackground(new Color(210, 4, 45));
        dane.setForeground(Color.WHITE);
        dane.setBorderPainted(false);
        dane.setBounds(400, 250, 125, 35);
        add(dane);
        dane.addActionListener(this);

        part = new JLabel("---------------------------------------------------------------------------");
        part.setFont(new Font("Raleway", Font.BOLD, 25));
        part.setBounds(180, 280, 600, 23);
        add(part);

        pricee = new JLabel();
        pricee.setFont(new Font("Raleway", Font.BOLD, 30));
        pricee.setBounds(200, 340, 400, 23);
        add(pricee);
        pricee.setVisible(false);

        book = new JButton("Confirm Booking");
        book.setFont(new Font("Times", Font.PLAIN, 13));
        book.setBackground(new Color(210, 4, 45));
        book.setForeground(Color.WHITE);
        book.setBorderPainted(false);
        book.setBounds(610, 335, 140, 35); 
        add(book);
        book.addActionListener(this);
        book.setVisible(false);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {

            int mn = selecttime.getSelectedIndex();
            if (mn == 1) {
                tot = rs * mn;
            } else if (mn == 2) {
                tot = rs * mn;
            } else if (mn == 3) {
                tot = rs * mn;
            } else if (mn == 4) {
                tot = rs * mn;
            } else if (mn == 5) {
                tot = rs * mn;
            } else if (mn == 6) {
                tot = rs * mn;
            } else if (mn == 7) {
                tot = rs * mn;
            } else if (mn == 8) {
                tot = rs * mn;
            } else if (mn == 9) {
                tot = rs * mn;
            } else if (mn == 10) {
                tot = rs * mn;
            }

            String selectedDuration = (String) selecttime.getSelectedItem();
            String date1 = ((JTextField) date.getDateEditor().getUiComponent()).getText();

            if (e.getSource().equals(dane)) {
                if (mn == 0 || date1.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please Enter all the Filds Proerly, They all are Imortant.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                } else {
                    pricee.setText("Total Amount :" + " ₹" + tot);

                    pricee.setVisible(true);
                    book.setVisible(true);
                }
            } else if (e.getSource().equals(bback)) {
                dispose();
                new bedselectpage(ne);
            } else if (e.getSource().equals(book)) {

                mysqlconnection my = new mysqlconnection();
                id = new Random();
                int idd = id.nextInt(100, 9999);
                String iddd = "#" + idd ;

                no = new Random();
                int noo = no.nextInt(100, 999);
                String nooo = "#" + noo;

                try {
                    my.st.executeUpdate("create table " + ne
                            + " (date varchar(15), day varchar(10), price int, bookingid varchar(15), recipt_no varchar(10))");

                } catch (Exception g) {

                } finally {
                    my.st.executeUpdate("insert into " + ne + " values('" + date1 + "','" + selectedDuration + "',"
                            + tot + ",'" + iddd + "','"+nooo+"')");
                }

                JOptionPane.showMessageDialog(null,
                        "Room Booking for :" + " " + mn + "days" + "\nAmount Payable " + " ₹" + tot, "Booking",
                        JOptionPane.PLAIN_MESSAGE);
                dispose();
                new recipt(ne, iddd);
            }
        } catch (Exception d) {
            System.out.println(d);
        }

    }


}