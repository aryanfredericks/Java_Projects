package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class file5_atm_homepage extends JFrame implements ActionListener {
    JButton deposit, withdraw, fastcash, statement, exit, pinchange, balanceCheck;
    String pin;

    public file5_atm_homepage(String pin) {
        this.pin = pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(370, 0);
        setLayout(null);
        setResizable(false);
        setUndecorated(true);
        setSize(800, 800);
        setTitle("APPLICATION FORM - PAGE 2");

        ImageIcon bankImage = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\atmScreen.jpg");
        Image appForm2 = bankImage.getImage().getScaledInstance(1260, 1200, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(appForm2);
        JLabel atmBcg = new JLabel(finalImage);
        atmBcg.setBounds(0, 0, 800, 800);
        add(atmBcg);

        JLabel welcomeMsg = new JLabel("WELCOME TO ATM");
        welcomeMsg.setBounds(280, 120, 250, 100);
        welcomeMsg.setForeground(Color.WHITE);
        welcomeMsg.setFont(new Font("Fira Code", Font.ITALIC, 25));
        atmBcg.add(welcomeMsg);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(150, 250, 130, 35);
        deposit.setFocusable(false);
        deposit.addActionListener(this);
        deposit.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(deposit);

        withdraw = new JButton("WITHDRAW");
        withdraw.setBounds(150, 350, 130, 35);
        withdraw.setFocusable(false);
        withdraw.addActionListener(this);
        withdraw.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(withdraw);

        statement = new JButton("STATEMENT");
        statement.setBounds(150, 450, 130, 35);
        statement.setFocusable(false);
        statement.addActionListener(this);
        statement.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(statement);

        fastcash = new JButton("FAST CASH");
        fastcash.setBounds(520, 250, 130, 35);
        fastcash.setFocusable(false);
        fastcash.addActionListener(this);
        fastcash.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(fastcash);

        exit = new JButton("EXIT");
        exit.setBounds(335, 450, 130, 35);
        exit.setFocusable(false);
        exit.addActionListener(this);
        exit.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(exit);

        pinchange = new JButton("CHANGE PIN");
        pinchange.setBounds(520, 450, 130, 35);
        pinchange.setFocusable(false);
        pinchange.addActionListener(this);
        pinchange.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(pinchange);

        balanceCheck = new JButton("BALANCE");
        balanceCheck.setBounds(520, 350, 130, 35);
        balanceCheck.setFocusable(false);
        balanceCheck.addActionListener(this);
        balanceCheck.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(balanceCheck);


        setVisible(true);
    }

    public static void main(String[] args) {
        new file5_atm_homepage("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            dispose();
        } else if (e.getSource() == deposit) {
            dispose();
            new file6_Deposit(pin);
        } else if (e.getSource() == withdraw) {
            dispose();
            new file7_withdraw(pin);
        } else if (e.getSource() == fastcash) {
            dispose();
            new file8_fastcash(pin);
        } else if (e.getSource()==pinchange) {
            dispose();
            new file9_pinchange(pin);
        }else if (e.getSource()==balanceCheck) {
            dispose();
            new file10_balance(pin);
        }else if (e.getSource()==statement) {
            dispose();
            new file11_statement(pin);
        }
    }
}