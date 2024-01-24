package hotelManagement;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class bookingpage extends JFrame implements ActionListener{
    JLabel head, db, sb, pricee;
    JDateChooser date;
    JComboBox selecttime;
    JButton bback, dane, book;
    int tot, rs;
    String ne;
    bookingpage(String bed,String nr){
        super("Booking");
        ne = nr;
        setSize(600, 500);
        setLocation(400, 100);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        head = new JLabel("Book Your Room");
        head.setFont(new Font("Raleway", Font.BOLD, 30));
        head.setBounds(10, 10, 300, 40);
        add(head);

        if(bed.equals("single")){
            rs = 300;
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
            rs = 600;
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
            rs = 1000;
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
        
        String []s = {"--No days selected--","1 Day","2 Days","3 Days","4 Days","5 Days","6 Days","7 Days","8 Days","9 Days","10 Days"};
        selecttime = new JComboBox<>(s);
        selecttime.setBounds(210,220,160,25);
        add(selecttime);

        bback = new JButton("Back");
        bback.setFont(new Font("Raleway", Font.BOLD, 12));
        bback.setBounds(50, 400, 150, 30);
        add(bback);
        bback.addActionListener(this);

        dane = new JButton("Done");
        dane.setFont(new Font("Raleway", Font.BOLD, 12));
        dane.setBounds(400, 280, 150, 30);
        add(dane);
        dane.addActionListener(this);

        pricee = new JLabel();
        pricee.setFont(new Font("Raleway", Font.BOLD, 25));
        pricee.setBounds(50, 340, 300, 23);
        add(pricee);  
        pricee.setVisible(false);

        book = new JButton("Book");
        book.setFont(new Font("Raleway", Font.BOLD, 12));
        book.setBounds(400, 400, 150, 30);
        add(book);
        book.addActionListener(this);
        book.setVisible(false);

        

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
        
        
            int mn = selecttime.getSelectedIndex();
            if(mn == 1){
                tot = rs*mn;
            }else if(mn == 2){
                tot = rs*mn;
            }else if(mn == 3){
                tot = rs*mn;
            }else if(mn == 4){
                tot = rs*mn;
            }else if(mn == 5){
                tot = rs*mn;
            }else if(mn == 6){
                tot = rs*mn;
            }else if(mn == 7){
                tot = rs*mn;
            }else if(mn == 8){
                tot = rs*mn;
            }else if(mn == 9){
                tot = rs*mn;
            }else if(mn == 10){
                tot = rs*mn;
            }

            String selectedDuration = (String)selecttime.getSelectedItem();
            String date1 = ((JTextField)date.getDateEditor().getUiComponent()).getText();
            
            if(e.getSource().equals(dane)){
                if(mn==0 || date1.equals("")){
                        JOptionPane.showMessageDialog(null, "Please Enter all the Filds Proerly, They all are Imortant.",
                         "Warning",
                         JOptionPane.WARNING_MESSAGE);
                    }
                else {                    
                    pricee.setText("Total Amount :"+" "+tot);
                
                    pricee.setVisible(true);
                    book.setVisible(true);
                }      
            }
            else if(e.getSource().equals(bback)){
                dispose();
                new bedselectpage(ne);
            }
            else if(e.getSource().equals(book)){
                JOptionPane.showMessageDialog(null, "Room Booking for :"+" " + mn +"days"+ "\nAmount Payable " +" "+ tot, "Booking",JOptionPane.PLAIN_MESSAGE);
                dispose();
            }
        }catch(Exception d){
            System.out.println(d);
        }

    }

    public static void main(String[] args) {
        new bookingpage("single","ne");
    }
    
}