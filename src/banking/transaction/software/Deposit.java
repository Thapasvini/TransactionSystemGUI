/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;// for date class 


public class Deposit extends JFrame implements ActionListener
{
    JTextField despositAmount;
    
    JButton deposit,back;
    
    String pinNumber;
    
    Deposit(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel label= new JLabel("Enter the amount you want to deposit");
        label.setBounds(180,300,700,35);
        label.setFont(new Font("System",Font.BOLD,16));
        label.setForeground(Color.WHITE);
        image.add(label);
        
        despositAmount= new JTextField();
        despositAmount.setBounds(170,350,320,30);
        despositAmount.setFont(new Font("Raleway",Font.BOLD,22));
        //label.setForeground(Color.BLACK);
        image.add(despositAmount);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(350,485,160,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,14));
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);
        
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
        else if(ae.getSource()==deposit)
        {
            String number=despositAmount.getText();
            
            Date date= new Date();
            
            if(number.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter amount you want to deposit");
            }
            else
            {
                try{
                    Conn c= new Conn();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Deposit','"+number+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"$"+number+" deposited successfully");
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    
                }
                catch(Exception e)
                {
                    System.out.println(e);
                }
                
            }
            
        }
    }
    public static void main(String args[])
    {
        new Deposit("");
    }
}
