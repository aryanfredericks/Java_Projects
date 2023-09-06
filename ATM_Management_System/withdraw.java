package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class withdraw extends JFrame implements ActionListener {
    JTextField withdrawAmount;
    JButton back, withdraw;
    String pin;
    public boolean isDigit(String a){
        if (a.contains("a")||a.contains("b")||a.contains("c")||a.contains("d")||a.contains("e")||a.contains("f")||a.contains("g")||a.contains("h")||a.contains("i")||a.contains("j")||a.contains("k")||a.contains("l")||a.contains("m")||a.contains("n")||a.contains("o")||a.contains("p")||a.contains("q")||a.contains("r")||a.contains("s")||a.contains("t")||a.contains("u")||a.contains("v")||a.contains("w")||a.contains("x")||a.contains("y")||a.contains("z")){
            return false;
        }else if(a.contains("A")||a.contains("B")||a.contains("C")||a.contains("D")||a.contains("E")||a.contains("F")||a.contains("G")||a.contains("H")||a.contains("I")||a.contains("J")||a.contains("K")||a.contains("L")||a.contains("M")||a.contains("N")||a.contains("O")||a.contains("P")||a.contains("Q")||a.contains("R")||a.contains("S")||a.contains("T")||a.contains("U")||a.contains("V")||a.contains("W")||a.contains("X")||a.contains("Y")||a.contains("Z")){
            return false;
        }else if(a.contains("!")||a.contains("@")||a.contains("#")||a.contains("$")||a.contains("%")||a.contains("^")||a.contains("&")||a.contains("*")||a.contains(")")||a.contains("(")||a.contains("_")||a.contains("-")||a.contains("+")||a.contains("=")||a.contains("[")||a.contains("]")||a.contains(";")||a.contains(":")||a.contains("'")||a.contains("\"")||a.contains(",")||a.contains(">")||a.contains("<")||a.contains(".")||a.contains("/")||a.contains("?")){
            return false;
        }
        else{
            return true;
        }
    }
    public withdraw(String pin){
        this.pin=pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(370,0);
        setLayout(null);
        setUndecorated(true);
        setResizable(false);
        setSize(800,800);
        setTitle("");

        ImageIcon bankImage  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\atmScreen.jpg");
        Image appForm2= bankImage.getImage().getScaledInstance(1260,1200,Image.SCALE_DEFAULT);
        ImageIcon finalImage=new ImageIcon(appForm2);
        JLabel atmBcg= new JLabel(finalImage);
        atmBcg.setBounds(0,0,800,800);
        add(atmBcg);

        JLabel welcomeMsg = new JLabel("Enter the amount you want to withdraw");
        welcomeMsg.setBounds(180,120,450,100);
        welcomeMsg.setForeground(Color.WHITE);
        welcomeMsg.setFont(new Font("Fira Code",Font.BOLD,20));
        atmBcg.add(welcomeMsg);

        withdrawAmount = new JTextField();
        withdrawAmount.setBounds(180,270,200,50);
        withdrawAmount.setForeground(Color.black);
        withdrawAmount.setFont(new Font("Fira Code",Font.ITALIC,25));
        atmBcg.add(withdrawAmount);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(480,450,130,35);
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);
        withdraw.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(withdraw);

        back= new JButton("BACK");
        back.setBounds(180,450,130,35);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setFont(new Font("Fira Code",Font.BOLD,15));
        atmBcg.add(back);

        setVisible(true);
    }

    public static void main(String[] args) {
        new withdraw("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int flag=0;
        if(e.getSource()==withdraw){
            try{
                String getWithDraw = withdrawAmount.getText();
                Date date= new Date();
                if (!isDigit(getWithDraw)||getWithDraw.equals("")){
                    JOptionPane.showMessageDialog(this,"AMOUNT CONTAINS SPECIAL CHARACHTERS","INVALID",JOptionPane.WARNING_MESSAGE);
                    flag=1;
                }
                else{
                    connect c = new connect();
                    String query = "insert into bank_transaction_records values ('"+pin+"','"+date+"','Withdrawal','"+withdrawAmount+"');";
                    c.s.executeQuery(query);
                    JOptionPane.showMessageDialog(null,"Rs "+getWithDraw+" Withdrawn Succesfully");
                }
            }catch(Exception p){
                System.out.println(p);
            }
            if(flag==0){
                dispose();
                new atm_homepage(pin);
            }
        }
        if (e.getSource()==back){
            dispose();
            new atm_homepage(pin);
        }
    }
}

