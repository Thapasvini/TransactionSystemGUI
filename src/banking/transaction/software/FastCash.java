/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener
{
    JButton r1,r2,r3,r4,r5,r6,back;
    
    String pinNumber;
    
    FastCash(String pinNumber)
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
        
        JLabel text = new JLabel("Select Withdrawal Amount");
        text.setBounds(210,300,700,35);
        text.setBackground(Color.red);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,14));
        image.add(text);
        
        r1 = new JButton("$200");
        r1.setBounds(170,450,160,30);
        r1.setFont(new Font("Raleway",Font.BOLD,14));
        r1.setBackground(Color.BLUE);
        r1.setForeground(Color.BLACK);
        r1.addActionListener(this);
        image.add(r1);
        
        r2 = new JButton("$10");
        r2.setBounds(170,485,160,30);
        r2.setFont(new Font("Raleway",Font.BOLD,14));
        r2.setBackground(Color.WHITE);
        r2.setForeground(Color.BLACK);
        r2.addActionListener(this);
        image.add(r2);
        
        r3 = new JButton("$20");
        r3.setBounds(350,415,160,30);
        r3.setFont(new Font("Raleway",Font.BOLD,14));
        r3.setBackground(Color.WHITE);
        r3.setForeground(Color.BLACK);
        r3.addActionListener(this);
        image.add(r3);
        
        r4 = new JButton("$50");
        r4.setBounds(350,450,160,30);
        r4.setFont(new Font("Raleway",Font.BOLD,14));
        r4.setBackground(Color.WHITE);
        r4.setForeground(Color.BLACK);
        r4.addActionListener(this);
        image.add(r4);
        
        r5 = new JButton("$100");
        r5.setBounds(350,485,160,30);
        r5.setFont(new Font("Raleway",Font.BOLD,14));
        r5.setBackground(Color.WHITE);
        r5.setForeground(Color.BLACK);
        r5.addActionListener(this);
        image.add(r5);
        
        r6 = new JButton("$500");
        r6.setBounds(170,415,160,30);
        r6.setFont(new Font("Raleway",Font.BOLD,14));
        r6.setBackground(Color.WHITE);
        r6.setForeground(Color.BLACK);
        r6.addActionListener(this);
        image.add(r6);
        
        back = new JButton("BACK");
        back.setBounds(350,515,160,30);
        back.setFont(new Font("Raleway",Font.BOLD,14));
        back.setBackground(new Color(255, 255, 255));
        back.setForeground(Color.BLACK);
        back.addActionListener(this);
        image.add(back);
        
         
        setSize(900,900);
        setLocation(300,0);
        setUndecorated(true);// the top white panel which shows option to close, minimize
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==back)
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);            
        }
        else 
        {
            String amount=((JButton)ae.getSource()).getText().substring(1);
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
                
                if(ae.getSource()!="exit" && balance<Integer.parseInt(amount))
                {
                    JOptionPane.showMessageDialog(null, "You dont have enough funds for the transaction");
                    return;
                }
                else
                {
                    Date date= new Date();
                    String query="insert into bank values('"+pinNumber+"','"+date+"','Withdrawal','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, "$"+amount+" debited succesfully");
                
                    setVisible(false);
                    new Transactions(pinNumber).setVisible(true);
                    
                }   
            }
            catch(Exception e)
            {
                System.out.println(e);
            }     
        }
        
        
    }
    public static void main(String args[])
    {
        new FastCash("");
    }
}
