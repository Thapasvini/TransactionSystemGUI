/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Transactions extends JFrame implements ActionListener
{
    JButton deposit,fastCash,pinChange,withdraw,statement,balance,exit;
    
    String pinNumber;
    
    Transactions(String pinNumber)
    {
        this.pinNumber=pinNumber;
        setLayout(null);
        
        // to insert image into the frame
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900,900,Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text = new JLabel("Please select your Transaction");
        text.setBounds(210,300,700,35);
        text.setBackground(Color.red);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        deposit = new JButton("Deposit");
        deposit.setBounds(170,415,160,30);
        deposit.setFont(new Font("Raleway",Font.BOLD,14));
        deposit.setBackground(Color.WHITE);
        deposit.setForeground(Color.BLACK);
        deposit.addActionListener(this);
        image.add(deposit);
        
        fastCash = new JButton("Fast Cash");
        fastCash.setBounds(170,450,160,30);
        fastCash.setFont(new Font("Raleway",Font.BOLD,14));
        fastCash.setBackground(Color.BLUE);
        fastCash.setForeground(Color.BLACK);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        pinChange = new JButton("Pin Change");
        pinChange.setBounds(170,485,160,30);
        pinChange.setFont(new Font("Raleway",Font.BOLD,14));
        pinChange.setBackground(Color.WHITE);
        pinChange.setForeground(Color.BLACK);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        withdraw = new JButton("Cash Withdrawl");
        withdraw.setBounds(350,415,160,30);
        withdraw.setFont(new Font("Raleway",Font.BOLD,14));
        withdraw.setBackground(Color.WHITE);
        withdraw.setForeground(Color.BLACK);
        withdraw.addActionListener(this);
        image.add(withdraw);
        
        statement = new JButton("Mini Statement");
        statement.setBounds(350,450,160,30);
        statement.setFont(new Font("Raleway",Font.BOLD,14));
        statement.setBackground(Color.WHITE);
        statement.setForeground(Color.BLACK);
        statement.addActionListener(this);
        image.add(statement);
        
        balance = new JButton("Balance Enquiry");
        balance.setBounds(350,485,160,30);
        balance.setFont(new Font("Raleway",Font.BOLD,14));
        balance.setBackground(Color.WHITE);
        balance.setForeground(Color.BLACK);
        balance.addActionListener(this);
        image.add(balance);
        
        exit = new JButton("Exit");
        exit.setBounds(350,515,160,30);
        exit.setFont(new Font("Raleway",Font.BOLD,14));
        exit.setBackground(new Color(255, 255, 255));
        exit.setForeground(Color.BLACK);
        exit.addActionListener(this);
        image.add(exit);
        
            
        
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);// the top white panel which shows option to close, minimize
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==exit)
        {
            System.exit(0);
        }
        else if(ae.getSource()==deposit)
        {
            setVisible(false);
            new Deposit(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==fastCash)
        {
            setVisible(false);
            new FastCash(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==pinChange)
        {
            setVisible(false);
            new PinChange(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==withdraw)
        {
            setVisible(false);
            new Withdrawal(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==statement)
        {
            new Statement(pinNumber).setVisible(true);
        }
        else if(ae.getSource()==balance)
        {
            setVisible(false);
            new Balance(pinNumber).setVisible(true);
        }
        
        
    }
    public static void main(String args[])
    {
        new Transactions("");
    }
}
