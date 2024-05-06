/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;// this imports actionListener class
import java.util.*;
import java.sql.*;

//to create the login page frame we need to use swing so we are extending JFrame
// we are using inheritance here, so we are importing JFRame from swing package
// look at the import statement #import javax.swing.*; or we can also use import javax.swing.JFrame;
// we will be using many function of JFrame to create this login page

// here actionListner is a interface we inport from event package so that outr inputs and button should store value and perform some action
public class Login extends JFrame implements ActionListener
{
    JButton login,signup,clear;// defining globally to use in other methods and constructors
    
    JTextField cardTextField;
    
    JPasswordField pinTextField;
    
    Login()
    {
        setTitle("AUTOMATED TELLER MACHINE");
        
        setLayout(null);// if not the image icon will be to the center by default
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        //to add image we need this object and we write the source, i.i., the address of that image, so it will pick the image from there
        Image i2= i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        // we are trying to scale the image to the desired size we want so creating another object that will get the image, and scale it, for this object we importing awt since Image class is in awt.
        
        //JLabel label= new JLabel(i1);we can import ImageIcon in JLabel bt not to Image object
        // so we will be converting Image to ImageIcon
        ImageIcon i3= new ImageIcon(i2);
        
        JLabel label= new JLabel(i3);
        // we need to place this image on frame, we cannot place an icon directly on frame, 
        label.setBounds(70,10,100,100);// first two dimensions are its location from start of frame next two are image dimentions
        add(label);
        // to add an component on frame we need add function
        // in layout the default is border in that properties its center hence the image will be at center hence we have nulled the setlayout function for label.setBounds(70,10,100,100);
        
        JLabel text= new JLabel("Welcome to ATM");
        text.setFont(new Font("Osward",Font.BOLD, 38));
        text.setBounds(200,40,400,40);
        add(text);
        
        JLabel cardno= new JLabel("Card No.");
        cardno.setFont(new Font("Raleway",Font.BOLD, 28));
        cardno.setBounds(120,150,150,30);
        add(cardno);
        
        cardTextField= new JTextField();
        cardTextField.setBounds(300,150,230,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(cardTextField);
        
        JLabel pin= new JLabel("Pin No.");
        pin.setFont(new Font("Raleway",Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        add(pin);
        
        pinTextField= new JPasswordField();
        pinTextField.setBounds(300,220,230,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD, 14));
        add(pinTextField);
        
        login= new JButton("Sign In");
        login.setBounds(300,300,100,30);
        login.setBackground(Color.RED);
        login.setForeground(Color.BLACK);
        login.addActionListener(this);
        //login.setOpaque(true); 
        add(login);
        
        clear= new JButton("Clear");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.RED);
        clear.setForeground(Color.BLACK);
        clear.addActionListener(this);
        add(clear);
        
        signup= new JButton("Sign Up");
        signup.setBounds(300,350,230,30);
        signup.setBackground(Color.RED);
        signup.setForeground(Color.BLACK);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        // getting the entire frame ands changing its color
        
        // main use of JLabel is we can write content on frame
        
        
        setSize(800,480);// to create frame with length 800 and breadth 480
        setVisible(true);// so with this function frame will be created and will be visible
        // post this if u click run frame will be created on top left coz for every frame its the origin
        // bt u can change frame location using below fun
        setLocation(350,200);
        
        
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()== clear)
        {
            cardTextField.setText("");
            pinTextField.setText("");
        }
        else if(ae.getSource()== signup)
        {
            setVisible(false);// for this frame to disappear
            new SignupOne("").setVisible(true);
        }
        else if(ae.getSource()== login)
        {
            Conn c= new Conn();
            String cardNumber=cardTextField.getText();
            String pinNumber=pinTextField.getText();
            
            String query="select * from login where cardNo='"+cardNumber+"' and pinNo='"+pinNumber+"'";
            
            try
            {
                ResultSet rs=c.s.executeQuery(query);// the rwsukt from select query will be store in resultset it is a type to store data.
                // for abv we have imported java.sql.*;
                if(rs.next())// if its not empty then
                {
                    setVisible(false);// for this frame to disappear
                    new Transactions(pinNumber).setVisible(true);
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Please enter correct CardNumber and PIN");
                    
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
        new Login();// we are creating an anynymous object such that once this class is run.
        // so basically once the class is called offcourse main method will be run first then constructor will be called "Login", we write all the code in constructor.
        // bt why?
    }
    
    
}
