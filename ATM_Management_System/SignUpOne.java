package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.Random;
import com.toedter.calendar.JDateChooser;


public class SignUpOne extends JFrame implements ActionListener {
    JTextField nameText,fnameText,emailText,addressText,cityText,stateText,pincodeText;
    JRadioButton genderMale,genderFemale,marriedOther,marriedSingle,marriedMarried,others;
    JDateChooser dobChooser;
    JButton clear2,next;
    int random;
    public SignUpOne(){
        Random r = new Random();
        random=  r.nextInt(10000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,20);
        setLayout(null);
        setResizable(false);
        setSize(850,750);
        setTitle("APPLICATION FORM - PAGE 1");

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

        JLabel heading = new JLabel("APPLICATION FORM NO: "+random);
        heading.setBounds(220,0,500,100);
        heading.setFont(new Font("Lucida Console",Font.BOLD,30));
        signUpBcg.add(heading);

        JLabel name = new JLabel("FULL NAME : ");
        name.setBounds(70,100,200,100);
        name.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(name);
        nameText= new JTextField();
        nameText.setBounds(300,135,450,30);
        nameText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(nameText);

        JLabel email = new JLabel("EMAIL : ");
        email.setBounds(70,150,200,100);
        email.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(email);
        emailText= new JTextField();
        emailText.setBounds(300,180,450,30);
        emailText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(emailText);

        JLabel gender = new JLabel("GENDER : ");
        gender.setBounds(70,200,200,100);
        gender.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(gender);
        genderMale = new JRadioButton();
        genderMale.setText("MALE");
        genderMale.setFocusable(false);
        genderMale.setBackground(Color.white);
        genderMale.setBounds(300,235,75,25);
        signUpBcg.add(genderMale);
        genderFemale = new JRadioButton();
        genderFemale.setText("FEMALE");
        genderFemale.setFocusable(false);
        genderFemale.setBackground(Color.white);
        genderFemale.setBounds(400,235,80,25);
        signUpBcg.add(genderFemale);
        others = new JRadioButton();
        others.setText("OTHER");
        others.setFocusable(false);
        others.setBackground(Color.white);
        others.setBounds(500,235,70,25);
        signUpBcg.add(others);

        ButtonGroup gGroup = new ButtonGroup(); //use this so that the user cans elect only 1 option at a time
        gGroup.add(genderMale);
        gGroup.add(genderFemale);
        gGroup.add(others);

        JLabel fname = new JLabel("FATHERS NAME : ");
        fname.setBounds(70,300,300,100);
        fname.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(fname);
        fnameText= new JTextField();
        fnameText.setBounds(300,338,450,25);
        fnameText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(fnameText);

        JLabel married= new JLabel("MARITAL STATUS :");
        married.setBounds(70,250,220,100);
        married.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(married);
        marriedMarried = new JRadioButton();
        marriedMarried.setText("MARRIED");
        marriedMarried.setFocusable(false);
        marriedMarried.setBackground(Color.white);
        marriedMarried.setBounds(300,285,80,25);
        signUpBcg.add(marriedMarried);
        marriedSingle = new JRadioButton();
        marriedSingle.setText("SINGLE");
        marriedSingle.setFocusable(false);
        marriedSingle.setBackground(Color.white);
        marriedSingle.setBounds(400,285,80,25);
        signUpBcg.add(marriedSingle);
        marriedOther = new JRadioButton();
        marriedOther.setText("OTHER");
        marriedOther.setFocusable(false);
        marriedOther.setBackground(Color.white);
        marriedOther.setBounds(500,285,80,25);
        signUpBcg.add(marriedOther);
        ButtonGroup gGroup2 = new ButtonGroup(); //use this so that the user cans elect only 1 option at a time
        gGroup2.add(marriedMarried);
        gGroup2.add(marriedSingle);
        gGroup2.add(marriedOther);

        JLabel dob= new JLabel("DATE OF BIRTH :");
        dob.setBounds(70,350,200,100);
        dob.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(dob);
        dobChooser = new JDateChooser();
        dobChooser.setFont(new Font("Lucida Console",Font.BOLD,17));
        dobChooser.setBounds(300,385,250,30);
        signUpBcg.add(dobChooser);

        JLabel address= new JLabel("ADDRESS :");
        address.setBounds(70,400,200,100);
        address.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(address);
        addressText= new JTextField();
        addressText.setBounds(300,435,450,30);
        addressText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(addressText);

        JLabel city= new JLabel("CITY :");
        city.setBounds(70,450,200,100);
        city.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(city);
        cityText= new JTextField();
        cityText.setBounds(300,485,450,30);
        cityText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(cityText);

        JLabel state= new JLabel("STATE :");
        state.setBounds(70,500,200,100);
        state.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(state);
        stateText= new JTextField();
        stateText.setBounds(300,535,450,30);
        stateText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(stateText);

        JLabel pincode= new JLabel("PINCODE :");
        pincode.setBounds(70,550,200,100);
        pincode.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(pincode);
        pincodeText= new JTextField();
        pincodeText.setBounds(300,585,450,30);
        pincodeText.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(pincodeText);

        clear2 =  new JButton("CLEAR");
        clear2.setFocusable(false);
        clear2.setBounds(300,630,100,50);
        clear2.setForeground(Color.WHITE);
        clear2.addActionListener(this);
        clear2.setBackground(Color.BLACK);
        clear2.setFont(new Font("MV Lucida Console",Font.BOLD,17));
        signUpBcg.add(clear2);

        next =  new JButton("NEXT");
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
        new SignUpOne();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==next){
            int flag=0;
            //We need to a=take all the data that the user has entered and store it in the database
            String formNo = ""+random; //converts long to string
            String name = nameText.getText();
            String fname = fnameText.getText();
            String email = emailText.getText().toUpperCase();
            String state = stateText.getText();
            String pincode = pincodeText.getText();
            String address= addressText.getText();
            String city = cityText.getText();
            String gender ="null";
            String married="null";
            String dob=((JTextField) dobChooser.getDateEditor().getUiComponent()).getText();
            if(genderMale.isSelected()){
                gender="Male";
            } else if (genderFemale.isSelected()) {
                gender="Female";
            }
            if(marriedMarried.isSelected()){
                married="Married";
            } else if (marriedSingle.isSelected()) {
                married="Single";
            }else if (marriedOther.isSelected()) {
                married="Other";
            }

            //validation step before proceeding
            try{
                if(name.contains("&")||name.contains("*")||name.contains("$")||name.contains("@")||name.contains("!")||name.contains("(")){
                    flag=1;
                    JOptionPane.showMessageDialog(this,"Invalid name\nInvalid Charachters","ERROR",JOptionPane.WARNING_MESSAGE);
                }
                else if(name.isEmpty()||email.isEmpty()){
                    flag=1;
                    JOptionPane.showMessageDialog(this,"Name or Email is empty","ERROR",JOptionPane.WARNING_MESSAGE);
                }
                else if (!email.contains("@")) {
                    flag=1;
                    JOptionPane.showMessageDialog(this,"Invalid Email\nMissing \"@\"","ERROR",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    connect c = new connect();
                    String query = "insert into signup values ('"+formNo+"','"+name+"','"+gender+"','"+married+"','"+fname+"','"+dob+"','"+address+"','"+city+"','"+state+"','"+pincode+"')";
                    c.s.executeUpdate(query);
                }
            }
            catch(Exception a){
                System.out.println(a);
            }
            if(flag==0){
                dispose();
                SignUpTwo s = new SignUpTwo();
            }
        }
        if(e.getSource()==clear2){
            nameText.setText("");
            fnameText.setText("");
            emailText.setText("");
            addressText.setText("");
            cityText.setText("");
            stateText.setText("");
            pincodeText.setText("");
            dobChooser.setDate(null);
        }
    }
}
