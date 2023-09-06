package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class statement extends JFrame{
    String pin ;
    public statement(String pin){
        this.pin=pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(50,50);
        setSize(400,700);
        setLayout(null);
        setTitle("STATEMENT");
        getContentPane().setBackground(Color.WHITE);

        JLabel bankStatement = new JLabel("HDFC BANK ");
        bankStatement.setBounds(130,80,150,100);
        bankStatement.setFont(new Font("Comic Sans", 1, 18));
        add(bankStatement);

        JLabel statement =  new JLabel("");
        statement.setBounds(30,150,300,100);
        statement.setFont(new Font("Comic Sans", 1, 15));
        add(statement);

        JLabel cardNo =  new JLabel("");
        cardNo.setBounds(30,120,300,100);
        cardNo.setFont(new Font("Comic Sans", 1, 15));
        add(cardNo);
        try{
            connect con = new connect();
            ResultSet rs = con.s.executeQuery("select * from current_users where pinNumber='"+pin+"'");
            while(rs.next()){
                cardNo.setText("Card Number : "+"XXXX-XXXX-XXXX-"+rs.getString("accountNumber").substring(12,16));

            }
        }catch(Exception g){
            System.out.println(g);
        }
        try{
            connect con = new connect();
            ResultSet rs = con.s.executeQuery("select * from bank_transaction_records where pin='"+pin+"'");
            while(rs.next()){
                statement.setText(statement.getText() + "<html>" +rs.getString("date") + "@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;" + rs.getString("type") +"@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;@nbsp;" +rs.getString("amount"));
            }
        }catch(Exception g){
            System.out.println(g);
        }


        setVisible(true);


    }
    public static void main(String[] args) {
        new statement("");
    }


}
