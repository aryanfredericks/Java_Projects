package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.*;

public class CheckBalance extends JFrame implements ActionListener {
    String pin;
    JButton back;
    public CheckBalance(String pin){
        this.pin=pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(370,0);
        setLayout(null);
        setResizable(false);
        setSize(800,800);

        ImageIcon bankImage  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\atmScreen.jpg");
        Image appForm2= bankImage.getImage().getScaledInstance(1260,1200,Image.SCALE_DEFAULT);
        ImageIcon finalImage=new ImageIcon(appForm2);
        JLabel atmBcg= new JLabel(finalImage);
        atmBcg.setBounds(0,0,800,800);
        add(atmBcg);

        JLabel l1 =  new JLabel("i  will see my balance here");
        l1.setBounds(160,120,400,100);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Fira Code",Font.BOLD,20));
        atmBcg.add(l1);

        back = new JButton("BACK");
        back.setBounds(150, 450, 130, 35);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(back);

        try{
            connect c = new connect();
            ResultSet rs = c.s.executeQuery("select * from bank_transaction_records where pin = '"+pin+"'");
            int balance = 0;
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            l1.setText("Your Balance is Rs "+balance);
        }
        catch(Exception af){
            System.out.println(af);
        }
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            dispose();
            new atm_homepage(pin);
        }
    }

    public static void main(String[] args) {
        new CheckBalance("");
    }
}
