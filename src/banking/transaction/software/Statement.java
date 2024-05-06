/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Statement extends JFrame implements ActionListener
{
    String pinNumber;
    
    Statement(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        setLayout(null);
        
        setTitle("Mini Statement");
        
        JLabel mini= new JLabel("Mini Statement");
        mini.setBounds(200,20,150,20);
        mini.setFont(new Font("Raleway",Font.BOLD,14));
        add(mini);
        
        JLabel bank= new JLabel("Bank of AMERICA");
        bank.setBounds(140,60,400,20);
        bank.setFont(new Font("Raleway",Font.BOLD,25));
        add(bank);
        
        JLabel card= new JLabel();// dynamicaly entering data
        card.setBounds(20,110,300,20);
        card.setFont(new Font("Raleway",Font.BOLD,14));
        add(card);
        
        JLabel transactions= new JLabel();
        transactions.setFont(new Font("Raleway",Font.BOLD,14));
        transactions.setBounds(20, 160, 400, 200);
        add(transactions);
        
        JLabel total= new JLabel();
        total.setFont(new Font("Raleway",Font.BOLD,14));
        total.setBounds(20, 400, 400, 20);
        add(total);
        
        
        
        try
        {
            Conn c= new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from login where pinNo='"+pinNumber+"'");
            
            while(rs.next())
            {
                card.setText("CardNumber : "+rs.getString("cardNo").substring(0,4)+"-XXXX-XXXX-"+rs.getString("cardNo").substring(12));
            } 
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        try
        {
            Conn c= new Conn();
            
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
            int balance=0;
            while(rs.next())
            {
                transactions.setText(transactions.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+
                        rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");   
            
                // got total balance 
                
                if(rs.getString("type").equals("Deposit"))
                {
                    balance+=Integer.parseInt(rs.getString("amount"));
                }
                else
                {
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
            
            } 
            
            total.setText("Your current account total balance is $"+balance);
            
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        
        JButton b= new JButton("Exit");
        b.setBounds(250,500,100,25);
        b.setFont(new Font("Raleway",Font.BOLD,16));
        b.setBackground(Color.WHITE);
        b.setForeground(Color.BLACK);
        b.addActionListener(this);
        add(b);
        
    
    
    
         setSize(500,600);
         setLocation(20,20);
         getContentPane().setBackground(Color.WHITE);
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
        new Statement("").setVisible(true);
    }
}
