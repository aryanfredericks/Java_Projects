package Java_Projects.ATM_Management_System;

import javax.swing.*;
import java.awt.*;

public class atm_homepage extends JFrame {
    public atm_homepage(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(300,0);
        setLayout(null);
        setResizable(false);
        setSize(900,1080);
        setTitle("APPLICATION FORM - PAGE 2");

        ImageIcon appForm  = new ImageIcon("C:\\GAMES\\Java Projects\\ATM_Management\\src\\icons\\ATM_image.jpg");
        Image appForm2= appForm.getImage().getScaledInstance(1000,1080,Image.SCALE_DEFAULT);
        ImageIcon finalImage=new ImageIcon(appForm2);
        JLabel atmBcg= new JLabel(finalImage);
        atmBcg.setBounds(0,0,900,1080);
        add(atmBcg);
        setVisible(true);
    }
    public static void main(String[] args) {
        new atm_homepage();
    }
}
