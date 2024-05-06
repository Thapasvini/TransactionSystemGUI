/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;


import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.*;
import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener
{
    JTextField withdrawAmount;
    
    JButton withdraw,back;
    
    String pinNumber;
    
    Withdrawal(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel label= new JLabel("Enter the amount you want to withdraw");
        label.setBounds(180,300,700,35);
        label.setFont(new Font("System",Font.BOLD,16));
        label.setForeground(Color.WHITE);
        image.add(label);
        
        withdrawAmount= new JTextField();
        withdrawAmount.setBounds(170,350,320,30);
        withdrawAmount.setFont(new Font("Raleway",Font.BOLD,22));
        //label.setForeground(Color.BLACK);
        image.add(withdrawAmount);
        
        withdraw = new JButton("Withdraw");
        withdraw.setBounds(350,485,160,30);
        withdraw.setFont(new Font("Raleway",Font.BOLD,14));
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        back = new JButton("Back");
        back.setBounds(350,515,160,30);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBackground(Color.WHITE);
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
                
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw)
        {
            String number=withdrawAmount.getText();
            
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter amount you want to withdraw");
            }
            else
            {
                try
                {
                    Conn c= new Conn();
                    ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinNumber+"'");
                
                    int balance=0;
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
                
                    if(balance<Integer.parseInt(number))
                    {
                        JOptionPane.showMessageDialog(null, "You dont have enough funds for the transaction");
                        return;
                    }
                    else
                    {
                        Date date= new Date();
                        String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+number+"')";
                        c.s.executeUpdate(query);
                        JOptionPane.showMessageDialog(null, "$"+number+" debited successfully");
                
                        setVisible(false);
                        new Transactions(pinNumber).setVisible(true);
                    
                    }   
                }
               /* try{
                    Conn c= new Conn();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"$"+number+" withdrew successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    
                   */ 
                
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
            
        }
    }
    public static void main(String args[])
    {
        new Withdrawal("");
    }
}
