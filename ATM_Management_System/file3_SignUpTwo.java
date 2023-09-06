package Java_Projects.ATM_Management_System;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class file3_SignUpTwo extends JFrame implements ActionListener {
    JComboBox religionComBox,incomeComBox,eduComBox;
    JTextField panTextField,aadharTextField;
    JRadioButton scYes,scNo;
    JButton next,clear2;
    String fn;
    public file3_SignUpTwo(String formNo){
        this.fn=formNo;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,20);
        setLayout(null);
        setResizable(false);
        setSize(850,750);
        setTitle("APPLICATION FORM - PAGE 2");

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

        JLabel heading = new JLabel("ADDITIONAL DETAILS :  ");
        heading.setBounds(220,0,500,100);
        heading.setFont(new Font("Lucida Console",Font.BOLD,30));
        signUpBcg.add(heading);

        JLabel religion = new JLabel("RELIGION:  ");
        religion.setBounds(70,100,200,100);
        religion.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(religion);
        String [] rel={"","Hindu","Christian","Muslim","Sikh","Others"};
        religionComBox= new JComboBox(rel);
        signUpBcg.add(religionComBox);
        religionComBox.setBounds(300,135,450,30);
        religionComBox.setBackground(Color.WHITE);
        religionComBox.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(religionComBox);

        JLabel income = new JLabel("INCOME:  ");
        income.setBounds(70,150,200,100);
        income.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(income);
        String [] inc={"","no income","0 - 1,00,000","1,00,000 - 3,00,000","3,00,000 - 10,00,000","10,00,000+"};
        incomeComBox= new JComboBox(inc);
        signUpBcg.add(incomeComBox);
        incomeComBox.setBounds(300,180,450,30);
        incomeComBox.setBackground(Color.WHITE);
        incomeComBox.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(incomeComBox);

        JLabel edu = new JLabel("EDUCATION : ");
        edu.setBounds(70,200,200,100);
        edu.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(edu);
        String [] education={"","Student","UnderGrad","PostGrad","Employee"};
        eduComBox= new JComboBox(education);
        signUpBcg.add(eduComBox);
        eduComBox.setBounds(300,235,450,30);
        eduComBox.setBackground(Color.WHITE);
        eduComBox.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(eduComBox);

        JLabel pan = new JLabel("PAN CARD :  ");
        pan.setBounds(70,260,200,100);
        pan.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(pan);
        panTextField= new JTextField();
        panTextField.setBounds(300,298,450,25);
        panTextField.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(panTextField);
        setVisible(true);

        JLabel aadhar = new JLabel("AADHAR CARD :  ");
        aadhar.setBounds(70,320,200,100);
        aadhar.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(aadhar);
        aadharTextField= new JTextField();
        aadharTextField.setBounds(300,355,450,25);
        aadharTextField.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(aadharTextField);

        JLabel seniorC = new JLabel("SENIOR CITIZEN : ");
        seniorC.setBounds(70,370,250,100);
        seniorC.setFont(new Font("Lucida Console",Font.BOLD,20));
        signUpBcg.add(seniorC);
        scYes = new JRadioButton();
        scYes.setText("YES");
        scYes.setFocusable(false);
        scYes.setBackground(Color.white);
        scYes.setBounds(300,405,70,25);
        signUpBcg.add(scYes);
        scNo = new JRadioButton();
        scNo.setText("NO");
        scNo.setFocusable(false);
        scNo.setBackground(Color.white);
        scNo.setBounds(400,405,70,25);
        signUpBcg.add(scNo);
        ButtonGroup gGroup = new ButtonGroup(); //use this so that the user cans elect only 1 option at a time
        gGroup.add(scYes);
        gGroup.add(scNo);

        clear2 =  new JButton("CLEAR");
        clear2.setFocusable(false);
        clear2.setBounds(300,630,100,50);
        clear2.setForeground(Color.WHITE);
        clear2.addActionListener(this);
        clear2.setBackground(Color.BLACK);
        clear2.setFont(new Font("MV Lucida Console",Font.BOLD,17));
        signUpBcg.add(clear2);

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
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==next){
            int flag=0;
            String religion=(String) religionComBox.getSelectedItem();
            String income=(String) incomeComBox.getSelectedItem();
            String education=(String) eduComBox.getSelectedItem();
            String panNo =  panTextField.getText();
            String aadharNo = aadharTextField.getText();
            String seniorc="null";
            if (scYes.isSelected()){
                seniorc="Yes";
            }
            else if(scNo.isSelected()){
                seniorc="No";
            }

            //Validation Step to check if entered values are checked
            try{
                if(religionComBox.getSelectedItem()=="" ||eduComBox.getSelectedItem()==""||incomeComBox.getSelectedItem()=="" ||panTextField.getText().isEmpty() || aadharTextField.getText().isEmpty()){
                    flag=1;
                    JOptionPane.showMessageDialog(this,"Invalid Choice","Empty Input",JOptionPane.WARNING_MESSAGE);
                }
                else{
                    //connecting to database
                    file12_jdbcConnectivity conn = new file12_jdbcConnectivity();
                    String query = "insert into signup2 values ('"+fn+"','"+religion+"','"+income+"','"+education+"','"+panNo+"','"+aadharNo+"','"+seniorc+"')";
                    conn.s.executeUpdate(query);
                }
            }
            catch(Exception z){
                System.out.println(z);
            }
            if(flag==0){
                dispose();
                file4_SignUpThree s3 = new file4_SignUpThree(fn);
            }
        }
        if(e.getSource()==clear2){
            panTextField.setText("");
            aadharTextField.setText("");
            religionComBox.setSelectedIndex(0);
            incomeComBox.setSelectedIndex(0);
            eduComBox.setSelectedIndex(0);
        }
    }

    public static void main(String[] args) {
        new file3_SignUpTwo("");
    }
}
