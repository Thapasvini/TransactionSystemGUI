/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;
import java.sql.*;// imporing sql libraries


public class Conn 
{
    Connection c;
    Statement s;
    public Conn()// we are creating an object from other class so creatig a  constructor
    {
        // as mySql is an external entity we need exceptional handling are these are changes of run time error bt not completime errors
        try
        {
            // we need register driver
            //Class.forName(com.mysql.cj.jdbc.Driver);
            // as we already imported mysql connection library we dont need to write above command
            
            // creating connection
            //c= DriverManager.getConnection("jdbc:mysql://localhost3306/bankmanagementsystem","root","Thappu@1999");
            c= DriverManager.getConnection("jdbc:mysql:///bankmanagementsystem","root","Thappu@1999");// by default mysql runs on localhost so we dont have to mention again
            
            s=c.createStatement();       
        }
        catch(Exception e)
                {
                   System.out.println(e);
                }
    }
}
// we created connection and then need to create a database to create connecttion with connclass

