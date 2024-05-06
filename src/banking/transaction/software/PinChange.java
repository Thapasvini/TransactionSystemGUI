/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PinChange extends JFrame implements ActionListener
{
    String pinNumber;
    
    JPasswordField pin,repin;
    
    JButton change,back;
   
    PinChange(String pinNumber)
    {
        this.pinNumber=pinNumber;
        
        setLayout(null);
        
        ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image= new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
       
        JLabel text= new JLabel("CHANGE YOUR PIN");
        text.setBounds(250,290,700,35);
        text.setFont(new Font("System",Font.BOLD,16));
        text.setForeground(Color.WHITE);
        image.add(text);
        
        JLabel pintext= new JLabel("Enter your New Pin");
        pintext.setBounds(165,320,180,25);
        pintext.setFont(new Font("System",Font.BOLD,16));
        pintext.setForeground(Color.WHITE);
        image.add(pintext);
        
        pin = new JPasswordField();
        pin.setBounds(330,320,180,25);
        pin.setFont(new Font("Raleway",Font.BOLD,25));
        pin.setForeground(Color.BLACK);
        image.add(pin);
        
        JLabel repintext= new JLabel("Renter your New Pin");
        repintext.setBounds(165,369,180,25);
        repintext.setFont(new Font("System",Font.BOLD,16));
        repintext.setForeground(Color.WHITE);
        image.add(repintext);
        
        repin = new JPasswordField();
        repin.setBounds(330,369,180,25);
        repin.setFont(new Font("Raleway",Font.BOLD,25));
        repin.setForeground(Color.BLACK);
        image.add(repin);
        
        change= new JButton("CHANGE");
        change.setBounds(350,485,160,30);
        change.setFont(new Font("Raleway",Font.BOLD,16));
        change.setBackground(Color.WHITE);
        change.setForeground(Color.BLACK);
        change.addActionListener(this);
        image.add(change);
        
        back= new JButton("Back");
        back.setBounds(350,515,160,30);
        back.setFont(new Font("Raleway",Font.BOLD,16));
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
        if(ae.getSource()==change)
        {
            
        
            try
            {
            String npin=pin.getText();
            String nrepin=repin.getText();
            
            if(!npin.equals(nrepin))
            {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }
            if(npin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please enter PIN");
                return;
            }
            if(nrepin.equals(""))
            {
                JOptionPane.showMessageDialog(null, "Please Re-Enter PIN");
                return;
            }
            Conn c= new Conn();
               
            String query1="update login set pinNo='"+nrepin+"' where pinNo='"+pinNumber+"'";
            c.s.executeUpdate(query1);
            
            String query2="update bank set pin='"+nrepin+"' where pin='"+pinNumber+"'";
            c.s.executeUpdate(query2);
            
            String query3="update signupthree set pinNo='"+nrepin+"' where pinNo='"+pinNumber+"'";
            c.s.executeUpdate(query3);
            
            JOptionPane.showMessageDialog(null, "Pin changed successfully");
            
            setVisible(false);
            new Transactions(nrepin).setVisible(true);
        
            }
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
        {
            setVisible(false);
            new Transactions(pinNumber).setVisible(true);
        }
    }
    public static void main(String args[])
    {
        new PinChange("").setVisible(true);
    }
}
