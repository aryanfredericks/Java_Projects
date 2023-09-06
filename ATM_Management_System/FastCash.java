package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener{
    JButton hundred,fiveHundred,thousand,twoThousand,fiveThousand,tenThousand,back;
    String pin;
    public FastCash(String pin){
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

        JLabel welcomeMsg = new JLabel("Enter cash you want to withdraw");
        welcomeMsg.setBounds(230,120,400,100);
        welcomeMsg.setForeground(Color.WHITE);
        welcomeMsg.setFont(new Font("Fira Code",Font.ITALIC,18));
        atmBcg.add(welcomeMsg);

        hundred = new JButton("100");
        hundred.setBounds(150,250,130,35);
        hundred.setFocusable(false);
        hundred.addActionListener(this);
        hundred.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(hundred);

        fiveHundred = new JButton("500");
        fiveHundred.setBounds(150,350,130,35);
        fiveHundred.setFocusable(false);
        fiveHundred.addActionListener(this);
        fiveHundred.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(fiveHundred);

        thousand = new JButton("1000");
        thousand.setBounds(150,450,130,35);
        thousand.setFocusable(false);
        thousand.addActionListener(this);
        thousand.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(thousand);

        twoThousand = new JButton("2000");
        twoThousand.setBounds(520,250,130,35);
        twoThousand.setFocusable(false);
        twoThousand.addActionListener(this);
        twoThousand.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(twoThousand);

        fiveThousand = new JButton("5000");
        fiveThousand.setBounds(520,350,130,35);
        fiveThousand.setFocusable(false);
        fiveThousand.addActionListener(this);
        fiveThousand.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(fiveThousand);

        tenThousand = new JButton("10000");
        tenThousand.setBounds(520,450,130,35);
        tenThousand.setFocusable(false);
        tenThousand.addActionListener(this);
        tenThousand.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(tenThousand);

        back = new JButton("BACK");
        back.setBounds(335,450,130,35);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(back);



        setVisible(true);
    }
    public static void main(String[] args) {
        new FastCash("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==back){
            dispose();
            new atm_homepage(pin);
        }
        else{
            connect c = new connect();
            String amount = ((JButton)e.getSource()).getText();
            try{
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
                if(e.getSource()!=back && balance<Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null,"Insufficient Balance");
                    return;
                }
                Date date= new Date();
                String query = "insert into bank_transaction_records values ('"+pin+"','"+date+"','Withdrawal','"+amount+"');";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Rs "+amount+" Withdrawn Succesfully");
                dispose();
                new atm_homepage(pin);
            }catch(Exception ag){
                System.out.println(ag);
            }
        }
    }
}
