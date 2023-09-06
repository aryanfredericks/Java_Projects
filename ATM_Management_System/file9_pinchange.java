package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class file9_pinchange extends JFrame implements ActionListener {
    JPasswordField currentPin,newPin;
    JButton submit,back;
    String pin;
    public file9_pinchange(String pin){
        this.pin = pin;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(370, 0);
        setLayout(null);
        setResizable(false);
        setSize(800, 800);

        ImageIcon bankImage = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\atmScreen.jpg");
        Image appForm2 = bankImage.getImage().getScaledInstance(1260, 1200, Image.SCALE_DEFAULT);
        ImageIcon finalImage = new ImageIcon(appForm2);
        JLabel atmBcg = new JLabel(finalImage);
        atmBcg.setBounds(0, 0, 800, 800);
        add(atmBcg);

        JLabel l1 = new JLabel("Enter Current PIN");
        l1.setBounds(150,150,300,100);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Comic Sans", Font.PLAIN,20));
        atmBcg.add(l1);
        currentPin = new JPasswordField();
        currentPin.setBounds(350,185,100,30);
        currentPin.setFont(new Font("Comic Sans", Font.PLAIN,20));
        atmBcg.add(currentPin);
        JLabel l2= new JLabel("Enter New PIN");
        l2.setBounds(150,200,300,100);
        l2.setForeground(Color.WHITE);
        l2.setFont(new Font("Comic Sans", Font.PLAIN,20));
        atmBcg.add(l2);
        newPin = new JPasswordField();
        newPin.setBounds(350,235,100,30);
        newPin.setFont(new Font("Comic Sans", Font.PLAIN,20));
        atmBcg.add(newPin);

        back = new JButton("BACK");
        back.setBounds(150, 450, 130, 35);
        back.setFocusable(false);
        back.addActionListener(this);
        back.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(back);

        submit = new JButton("SUBMIT");
        submit.setBounds(520, 450, 130, 35);
        submit.setFocusable(false);
        submit.addActionListener(this);
        submit.setFont(new Font("Fira Code", Font.BOLD, 15));
        atmBcg.add(submit);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==back){
            dispose();
            new file5_atm_homepage(pin);
        }
        if (e.getSource()==submit){

            try{
                String cPin= currentPin.getText();
                String nPin= newPin.getText();
                if(cPin.equals(nPin)){
                    JOptionPane.showMessageDialog(null,"Invalid\nNew Pin cannot be same as Current Pin");
                    return;
                }
                if(cPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter Current Pin");
                }
                if(nPin.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Enter New Pin");
                }
                file12_jdbcConnectivity c = new file12_jdbcConnectivity();
                String q1 = "update bank_transaction_records set pin='"+nPin+"' where pin='"+pin+"'";
                String q2 = "update signup3 set pin_number='"+nPin+"' where pin_number='"+pin+"'";
                String q3 = "update current_users set pinNumber='"+nPin+"' where pinNumber='"+pin+"'";
                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);
                c.s.executeUpdate(q3);
                JOptionPane.showMessageDialog(null,"Pin Changed Successfully");
                dispose();
                new file5_atm_homepage(nPin);
            }catch(Exception ac){
                System.out.println(ac);
            }
        }
        else{
            dispose();
            new file5_atm_homepage(pin);
        }
    }

    public static void main(String[] args) {
        new file9_pinchange("");
    }

}
