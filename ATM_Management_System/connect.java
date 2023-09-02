package Java_Projects.ATM_Management_System;
import java.sql.*;
public class connect {
    /*
    Steps used in jdbc connectivity:
    1. Register The Driver
    2.Create Connection
    3.Create Statement
    4.Execute Query
    5.Close Connection
     */
    Connection c;
    Statement s;
    public connect(){
        //step2Requirement

        try{
            //step 1
//            Class.forName(com.mysql.cj.jdbc.Driver);
                //this gets redundant when we add the mysql library
            //step 2
            c = DriverManager.getConnection("jdbc:mysql:///bank_management","root","ArYAN/@21");

            //step 3
            s=c.createStatement();
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
