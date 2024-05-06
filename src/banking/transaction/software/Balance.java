/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener
{
    String pinNumber;
    
    JButton back;
    
    Balance(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        back =  new JButton("BACK");
        back.setBounds(350,485,160,30);
        back.setFont(new Font("Raleway",Font.BOLD,16));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
        // code to get transactions from db and calculate balance
        
        int balance=0;
        Conn c= new Conn();
        
        try
        {
            
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
        
            while(rs.next())
            {
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            }
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JLabel display= new JLabel("Your current account balance is $"+balance);
        display.setForeground(Color.WHITE);
        display.setFont(new Font("Raleway",Font.BOLD,16));
        display.setBounds(170,300,400,30);
        image.add(display);
        
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        setVisible(false);
        new Transactions(pinNumber).setVisible(true);
    }
    public static void main(String args[])
    {
        new Balance("").setVisible(true);
    }
}
