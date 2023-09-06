package Java_Projects.ATM_Management_System;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class file1_Login extends JFrame implements ActionListener {
    JButton login,SignUp,exit,clear;
    JTextField cardNoTextField;
    JPasswordField pinNoTextField;
    public file1_Login(){
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,100);
        setResizable(false);
        setTitle("LOGIN PAGE");
        getContentPane().setBackground(new Color(255,255,255));
        setLayout(null);

        ImageIcon i  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\LOGINPAGE.jpg");
        Image i2= i.getImage().getScaledInstance(800,600,Image.SCALE_DEFAULT);
        ImageIcon backGroundPage=new ImageIcon(i2);
        JLabel backGroundLabel= new JLabel(backGroundPage);
        backGroundLabel.setBounds(0,0,800,600);
        add(backGroundLabel);


        ImageIcon icon= new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\bank_icon.jpg");
        JLabel label= new JLabel(icon);
        backGroundLabel.add(label);
        label.setBounds(0,0,100,100);

        JLabel welcomeText =  new JLabel("Welcome To ATM");
        welcomeText.setBounds(180,0,500,100);
        welcomeText.setFont(new Font("MV Boli",Font.BOLD,50));
        welcomeText.setForeground(Color.white);
        backGroundLabel.add(welcomeText);

        JLabel cardNo =  new JLabel("CARD NO : ");
        cardNo.setBounds(130,160,200,100);
        cardNo.setFont(new Font("MV Boli",Font.BOLD,20));
        cardNo.setForeground(Color.white);
        backGroundLabel.add(cardNo);

        JLabel pinNo =  new JLabel("PIN : ");
        pinNo.setBounds(130,280,200,100);
        pinNo.setFont(new Font("MV Boli",Font.BOLD,20));
        pinNo.setForeground(Color.white);
        backGroundLabel.add(pinNo);

        cardNoTextField =  new JTextField();
        cardNoTextField.setVisible(true);
        cardNoTextField.setBorder( new EtchedBorder());
        cardNoTextField.setBounds(270,190,400,40);
        cardNoTextField.setFont(new Font("MV Boli",Font.BOLD,20));
        backGroundLabel.add(cardNoTextField);

        pinNoTextField =  new JPasswordField();
        pinNoTextField.setVisible(true);
        pinNoTextField.setBounds(270,310,400,40);
        pinNoTextField.setFont(new Font("MV Boli",Font.BOLD,20));
        backGroundLabel.add(pinNoTextField);

        SignUp =  new JButton("Sign Up");
        SignUp.setFocusable(false);
        SignUp.setBounds(150,400,100,50);
        SignUp.setForeground(Color.WHITE);
        SignUp.addActionListener(this);
        SignUp.setBackground(Color.RED);
        SignUp.setFont(new Font("MV Boli",Font.BOLD,17));
        backGroundLabel.add(SignUp);
        
        login =  new JButton("Login");
        login.setFocusable(false);
        login.setBounds(430,400,100,50);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        login.setBackground(Color.RED);
        login.setFont(new Font("MV Boli",Font.BOLD,17));
        backGroundLabel.add(login);
        
        clear =  new JButton("Clear");
        clear.setFocusable(false);
        clear.setBounds(430,480,100,50);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        clear.setBackground(Color.RED);
        clear.setFont(new Font("MV Boli",Font.BOLD,17));
        backGroundLabel.add(clear);

        exit =  new JButton("Exit");
        exit.setFocusable(false);
        exit.setBounds(150,480,100,50);
        exit.setForeground(Color.WHITE);
        exit.setBackground(Color.RED);
        exit.addActionListener(this);
        exit.setFont(new Font("MV Boli",Font.BOLD,17));
        backGroundLabel.add(exit);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent a){
        if(a.getSource()==SignUp){
            dispose();
            new file2_SignUpOne();
        }
        else if(a.getSource()==login){
            file12_jdbcConnectivity con = new file12_jdbcConnectivity();
            String cardNumber = cardNoTextField.getText();
            String pinNumber = pinNoTextField.getText();
            String query = "select * from current_users where accountNumber = '"+cardNumber+"' and pinNumber ='"+pinNumber+"' ";
            try{
                ResultSet rs= con.s.executeQuery(query);
                if(rs.next()){
                    dispose();
                    new file5_atm_homepage(pinNumber);
                }else{
                    JOptionPane.showMessageDialog(this,"Incorrect pin or account number. \n Please sign up if you have not");
                }

            }catch(Exception e){
                System.out.println(e);
            }

        }
        else if(a.getSource()==exit){
            dispose();
        }
        else if(a.getSource()==clear){
            pinNoTextField.setText("");
            cardNoTextField.setText("");
        }
    }
    public static void main(String[] args) {
        new file1_Login();
    }
}
