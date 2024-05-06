/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;// color and Fonf class ae in this package
import java.awt.event.*;
import java.util.*; // for rondom card and pin number

public class SignUpThree extends JFrame implements ActionListener
{
    String formno;
     
    JRadioButton savingsAcc,curentAcc,fixedAcc, recurrAcc;
    
    JCheckBox c1,c2,c3,c4,c5,c6,c7;
    
    JButton submit,cancel;
   
    SignUpThree(String formno)
    {
        this.formno=formno;
        
        setLayout(null);
        
        setTitle("New Account Application Form - Page 3");
                
        JLabel label= new JLabel("Page 3 : Applicant Account Details");
        label.setFont(new Font("Raleway",Font.BOLD,24));
        label.setBounds(200,40,450,40);
        add(label);
        
        JLabel accType= new JLabel("Account Type :");
        accType.setBounds(100,140,200,30);
        accType.setFont(new Font("Raleway",Font.BOLD,22));
        add(accType);
        
        savingsAcc= new JRadioButton("Saving Account");
        savingsAcc.setFont(new Font("Raleway",Font.BOLD,14));
        savingsAcc.setBounds(100,180,250,20);
        savingsAcc.setBackground(Color.WHITE);
        add(savingsAcc);
        
        curentAcc= new JRadioButton("Current Account");
        curentAcc.setFont(new Font("Raleway",Font.BOLD,14));
        curentAcc.setBounds(100,220,250,20);
        curentAcc.setBackground(Color.WHITE);
        add(curentAcc);
        
        fixedAcc= new JRadioButton("Fixed Deposit Account");
        fixedAcc.setFont(new Font("Raleway",Font.BOLD,14));
        fixedAcc.setBounds(350,180,250,20);
        fixedAcc.setBackground(Color.WHITE);
        add(fixedAcc);
        
        recurrAcc= new JRadioButton("Recurring Deposit Account");
        recurrAcc.setFont(new Font("Raleway",Font.BOLD,14));
        recurrAcc.setBounds(350,220,250,20);
        recurrAcc.setBackground(Color.WHITE);
        add(recurrAcc);
        
        ButtonGroup a= new ButtonGroup();
        a.add(savingsAcc);
        a.add(curentAcc);
        a.add(fixedAcc);
        a.add(recurrAcc);
     
        JLabel card= new JLabel("Card Number :");
        card.setBounds(100,270,200,30);
        card.setFont(new Font("Raleway",Font.BOLD,22));
        add(card);
        
        JLabel cardNo= new JLabel("XXXX-XXXX-XXXX-4184");
        cardNo.setBounds(330,270,300,30);
        cardNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(cardNo);
        
        JLabel cardMess= new JLabel("Your 16 digit card Number");
        cardMess.setBounds(100,300,300,30);
        cardMess.setFont(new Font("Raleway",Font.BOLD,12));
        add(cardMess);
        
        JLabel pin= new JLabel("PIN : ");
        pin.setBounds(100,350,300,30);
        pin.setFont(new Font("Raleway",Font.BOLD,22));
        add(pin);
        
        JLabel pinNo= new JLabel("XXXX");
        pinNo.setBounds(330,350,300,30);
        pinNo.setFont(new Font("Raleway",Font.BOLD,20));
        add(pinNo);
        
        JLabel pinMess= new JLabel("Your 4 Digit Password");
        pinMess.setBounds(100,380,300,30);
        pinMess.setFont(new Font("Raleway",Font.BOLD,12));
        add(pinMess);
        
        JLabel serviceReq= new JLabel("Services Required:");
        serviceReq.setBounds(100,430,300,30);
        serviceReq.setFont(new Font("Raleway",Font.BOLD,22));
        add(serviceReq);
        
        c1= new JCheckBox("ATM Card");
        c1.setFont(new Font("Raleway",Font.BOLD,16));
        c1.setBounds(100,480,200,30);
        c1.setBackground(Color.WHITE);
        add(c1);
        
        c2= new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway",Font.BOLD,16));
        c2.setBounds(300,480,200,30);
        c2.setBackground(Color.WHITE);
        add(c2);
        
        c3= new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway",Font.BOLD,16));
        c3.setBounds(100,530,200,30);
        c3.setBackground(Color.WHITE);
        add(c3);
        
        c4= new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway",Font.BOLD,16));
        c4.setBounds(300,530,200,30);
        c4.setBackground(Color.WHITE);
        add(c4);
        
        c5= new JCheckBox("Checque Book");
        c5.setFont(new Font("Raleway",Font.BOLD,16));
        c5.setBounds(100,580,200,30);
        c5.setBackground(Color.WHITE);
        add(c5);
        
        c6= new JCheckBox("E Statement");
        c6.setFont(new Font("Raleway",Font.BOLD,16));
        c6.setBounds(300,580,200,30);
        c6.setBackground(Color.WHITE);
        add(c6);
        
        c7= new JCheckBox("I here by declare that above information entired are correct to the best of my knowledge.");
        c7.setFont(new Font("Raleway",Font.BOLD,13));
        c7.setBounds(100,650,650,30);
        c7.setBackground(Color.WHITE);
        add(c7);
        
        submit= new JButton("Submit");
        submit.setBackground(Color.red);
        submit.setForeground(Color.BLACK);
        submit.setBounds(300,720,100,30);
        submit.setFont(new Font("Raleway",Font.BOLD,16));
        submit.addActionListener(this);
        add(submit);
        
        cancel= new JButton("Cancel");
        cancel.setBackground(Color.red);
        cancel.setForeground(Color.BLACK);
        cancel.setBounds(420,720,100,30);
        cancel.setFont(new Font("Raleway",Font.BOLD,16));
        cancel.addActionListener(this);
        add(cancel);
        
       
        setSize(850,820);
        setLocation(350,10);
        setVisible(true);
        
        getContentPane().setBackground(Color.WHITE);
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        
        if(ae.getSource()==submit)
        {
            String accountType=null;
            
            if(savingsAcc.isSelected())
            {
                accountType="Saving Account";
            }
            if(curentAcc.isSelected())
            {
                accountType="Current Account";
            }
            if(fixedAcc.isSelected())
            {
                accountType="Fixed Deposit Account";
            }
            if(recurrAcc.isSelected())
            {
                accountType="Recurring Deposit Account";
            }
            
            Random random= new Random();
            
            String scard=""+Math.abs((random.nextLong()%90000000L)+5040936000000000L);// we have added 50409360 for starting numbers to be same for all the cards
            
            String spin=""+Math.abs((random.nextLong()%9000L)+1000L);// we have added 50409360 for starting numbers to be same for all the cards
            
            String serviceFacility="";// here all the selected facilities are concatinated as string
            
            if(c1.isSelected())
            {
                serviceFacility=serviceFacility+" ATM Card,";
            }
             if(c2.isSelected())
            {
                serviceFacility=serviceFacility+" Internet Banking,";
            }
             if(c3.isSelected())
            {
                serviceFacility=serviceFacility+" Mobile Banking,";
            }
             if(c4.isSelected())
            {
                serviceFacility=serviceFacility+" Email & SMS Alerts,";
            }
            if(c5.isSelected())
            {
                serviceFacility=serviceFacility+" Cheque Book,";
            }
            if(c6.isSelected())
            {
                serviceFacility=serviceFacility+" E-Statement";
            }
            
            try
            {
                if(accountType=="")
                {
                    JOptionPane.showMessageDialog(null,"Please selected an account Type");  
                }
                else
                {
                    Conn c= new Conn();
                    String query1= "insert into signupthree values ('"+formno+"','"+accountType+"','"+scard+"','"+spin+"','"+serviceFacility+"')";
                    c.s.executeUpdate(query1);
                    
                    String query2="insert into login values ('"+formno+"','"+scard+"','"+spin+"')";
                    c.s.executeUpdate(query2);
                 
                    JOptionPane.showMessageDialog(null," Card Number: "+scard+ "\n Pin: "+spin);
                    
                    setVisible(false);
                    new Deposit(spin).setVisible(true);
                    
                }
            } 
            catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else if(ae.getSource()==cancel)
        {
            setVisible(false);
            new Login().setVisible(true);
        }
    }
    
    
    public static void main(String args[])
    {
        new SignUpThree("");
    }
}
