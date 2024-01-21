package hotelManagement;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;

public class bookingpage extends JFrame{
    JLabel head, db, sb, pricee;
    JDateChooser date;
    JComboBox selecttime;
    JButton bback, dane, book;

    bookingpage(String bed){
        super("Booking");
        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        head = new JLabel("Book Your Room");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 300, 40);
        add(head);

        if(bed.equals("single")){
            JLabel que = new JLabel("1 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(20, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 300/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(20, 80, 200, 56);
            add(price);
        }
        else if(bed.equals("double")){
            JLabel que = new JLabel("2 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(20, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 600/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(20, 80, 200, 56);
            add(price);
        }
        else if(bed.equals("triple")){
            JLabel que = new JLabel("3 Bedroom price :");
            que.setFont(new Font("Raleway", Font.BOLD, 20));
            que.setBounds(20, 70, 300, 20);
            add(que);
            JLabel price = new JLabel("₹ 1000/day");
            price.setFont(new Font("Raleway", Font.BOLD, 24));
            price.setBounds(20, 80, 200, 56);
            add(price);
        }

        db = new JLabel("Date of booking :");
        db.setFont(new Font("Raleway", Font.BOLD, 15));
        db.setBounds(20, 180, 200, 23);
        add(db);

        date = new JDateChooser();
        date.setBounds(170,180,250,25);
        add(date);

        sb = new JLabel("Select Number of Days :");
        sb.setFont(new Font("Raleway", Font.BOLD, 15));
        sb.setBounds(20, 220, 200, 23);
        add(sb);
        
        String []s = {"1day","2days","3days","4days","5days","6days","7days","8days","9days","10days"};
        selecttime = new JComboBox(s);
        selecttime.setBounds(210,220,150,25);
        add(selecttime);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(50, 400, 150, 30);
        add(bback);

        dane = new JButton("Done");
        dane.setFont(new Font("Raleway", Font.BOLD, 12));
        dane.setBounds(400, 280, 150, 30);
        add(dane);

        String var = "600";

        pricee = new JLabel("Total Amount:"+var);
        pricee.setFont(new Font("Raleway", Font.BOLD, 25));
        pricee.setBounds(50, 350, 300, 23);
        add(pricee);

        book = new JButton("Book");
        book.setFont(new Font("Raleway", Font.BOLD, 12));
        book.setBounds(400, 400, 150, 30);
        add(book);

        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {
        new bookingpage("double");
    }
}
