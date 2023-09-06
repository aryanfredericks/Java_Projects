package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class file4_SignUpThree extends JFrame implements ActionListener{
    String formNumber;
    JRadioButton type1,type2,type3,type4;
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    JButton next;
    public file4_SignUpThree(String fn){
        this.formNumber=fn;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,20);
        setLayout(null);
        setResizable(false);
        setSize(850,750);
        setTitle("APPLICATION FORM - PAGE 3");

        ImageIcon appForm  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\SIGNUP.jpg");
        Image appForm2= appForm.getImage().getScaledInstance(1200,759,Image.SCALE_DEFAULT);
        ImageIcon finalImage=new ImageIcon(appForm2);
        JLabel signUpBcg= new JLabel(finalImage);
        signUpBcg.setBounds(0,0,850,750);
        add(signUpBcg);

        ImageIcon i  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\appForm.png");
        Image i2= i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel formIcon= new JLabel(i3);
        formIcon.setBounds(10,10,100,100);
        signUpBcg.add(formIcon);

        JLabel heading = new JLabel("ACCOUNT SERVICES :  ");
        heading.setBounds(220,0,500,100);
        heading.setFont(new Font("Lucida Console",Font.BOLD,30));
        signUpBcg.add(heading);

        JLabel accType = new JLabel("ACCOUNT TYPE :");
        accType.setBounds(150,130,500,100);
        accType.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(accType);
        type1 = new JRadioButton();
        type1.setText("SAVINGS ACCOUNT");
        type1.setFocusable(false);
        type1.setBackground(Color.white);
        type1.setBounds(150,200,220,25);
        signUpBcg.add(type1);
        type2 = new JRadioButton();
        type2.setText("FIXED DEPOSIT ACCOUNT");
        type2.setFocusable(false);
        type2.setBackground(Color.white);
        type2.setBounds(450,200,190,25);
        signUpBcg.add(type2);
        type3 = new JRadioButton();
        type3.setText("CURRENT ACCOUNT");
        type3.setFocusable(false);
        type3.setBackground(Color.white);
        type3.setBounds(450,250,190,25);
        signUpBcg.add(type3);
        type4 = new JRadioButton();
        type4.setText("RECURRING DEPOSIT ACCOUNT");
        type4.setFocusable(false);
        type4.setBackground(Color.white);
        type4.setBounds(150,250,220,25);
        signUpBcg.add(type4);
        ButtonGroup gGroup2 = new ButtonGroup(); //use this so that the user cans elect only 1 option at a time
        gGroup2.add(type1);
        gGroup2.add(type2);
        gGroup2.add(type3);
        gGroup2.add(type4);

        JLabel cardNo = new JLabel("CARD : XXXX-XXXX-XXXX-2981");
        cardNo.setBounds(150,280,350,100);
        cardNo.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(cardNo);
        JLabel pinNo = new JLabel("PIN : XXXX ");
        pinNo.setBounds(150,330,350,100);
        pinNo.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(pinNo);

        JLabel services = new JLabel("SERVICES REQUIRED: ");
        services.setBounds(150,400,350,100);
        services.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(services);

        c1 = new JCheckBox("atm card");
        c1.setBounds(150,470,140,20);
        c1.setFocusable(false);
        c1.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c1);
        c2 = new JCheckBox("net banking");
        c2.setBounds(450,470,150,20);
        c2.setFocusable(false);
        c2.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c2);
        c3 = new JCheckBox("email alerts");
        c3.setBounds(150,520,140,20);
        c3.setFocusable(false);
        c3.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c3);
        c4 = new JCheckBox("mobile banking");
        c4.setBounds(450,520,150,20);
        c4.setFocusable(false);
        c4.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c4);
        c5 = new JCheckBox("statements");
        c5.setBounds(150,570,140,20);
        c5.setFocusable(false);
        c5.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c5);
        c6 = new JCheckBox("cheque book");
        c6.setBounds(450,570,150,20);
        c6.setFocusable(false);
        c6.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c6);
        c7 = new JCheckBox("I hereby declare that my information is correct.");
        c7.setBounds(150,650,450,20);
        c7.setFocusable(false);
        c7.setFont(new Font("Lucida Console",Font.PLAIN,15));
        signUpBcg.add(c7);

        next =  new JButton("SUBMIT");
        next.setFocusable(false);
        next.setBounds(650,630,100,50);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        next.setBackground(Color.BLACK);
        next.setFont(new Font("MV Lucida Console",Font.BOLD,17));
        signUpBcg.add(next);


        setVisible(true);
    }
    public static void main(String[] args) {
        new file4_SignUpThree("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            int flag=0;
            String accountType="null";
            if(type1.isSelected()){
                accountType="Savings Account";
            }else if(type2.isSelected()){
                accountType="Fixed Deposit Account";
            }else if(type3.isSelected()){
                accountType="Current Account";
            }else if(type4.isSelected()){
                accountType="Recurring Deposit Account";
            }
            Random ran=new Random();
            String cardNo = ""+Math.abs((ran.nextLong()% 90000000L+5040936000000000L));
            String pinNo = ""+ Math.abs((ran.nextLong()% 9000L+1000L));
            String services = "";
            if(c1.isSelected()){
                services+="Atm Card";
            }else if(c2.isSelected()){
                services+="Net Banking";
            }else if(c3.isSelected()){
                services+="Email Alerts";
            }else if(c4.isSelected()){
                services+="Mobile Banking";
            }else if(c5.isSelected()){
                services+="Statements";
            }else if(c6.isSelected()){
                services+="Cheque Book";
            }
            try{
                if(accountType.equals("null") || !c7.isSelected()){
                    flag=1;
                    JOptionPane.showMessageDialog(null,"Account type required");
                }
                else{
                    //connecting to database
                    file12_jdbcConnectivity conn = new file12_jdbcConnectivity();
                    String query1 = "insert into signup3 values ('"+formNumber+"','"+accountType+"','"+cardNo+"','"+pinNo+"','"+services+"')";
                    String query2 = "insert into current_users values ('"+formNumber+"','"+cardNo+"','"+pinNo+"')";
                    conn.s.executeUpdate(query1);
                    conn.s.executeUpdate(query2);

                    JOptionPane.showMessageDialog(null,"Card Number :"+cardNo+"\n"+"Pin Number : "+pinNo);
                }
                dispose();
                new file6_Deposit(pinNo);
            }
            catch(Exception vf){
                System.out.println(vf);
            }
            if (flag==0){
                dispose();
                new file1_Login();
            }
        }
    }
}
