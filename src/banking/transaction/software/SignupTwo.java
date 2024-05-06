/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package banking.transaction.software;

import java.awt.*;
import javax.swing.*;
import java.util.*;// to getr andomClass 
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;


// the class we are using JDate rclass will be inside JCalender
public class SignupTwo extends JFrame implements ActionListener
{
    String formno;
    
    JTextField ssnNoTextField;
    JButton next;
    JRadioButton veteranYes, veteranNo,existingNo,existingYes;
    
    JComboBox categoryBox,incomeBox,educationBox,occupationBox;
            
    SignupTwo(String formno)
    {
        this.formno=formno;
        setLayout(null);
        
        setTitle("New Account Application Form - Page 2");
        
        JLabel additionalDetails= new JLabel("Page 2: Additional Details");
        additionalDetails.setFont( new Font("Raleway", Font.BOLD, 22));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        // for drop down we use 
        /*
        String[] validReligion= {"Hindhu,"Muslim","Other"};
        JcomboBox religion= new JcomboBox(validReligion);
        */
        
        JLabel category= new JLabel("Category :");
        category.setFont( new Font("Raleway", Font.BOLD, 20));
        category.setBounds(100,140,200,30);
        add(category);
        
        String valcategory[]= {"American","Asian","Asian-American","Hispanic","Other"};
        categoryBox= new JComboBox(valcategory);
        categoryBox.setBounds(300, 140, 400, 30);
        categoryBox.setBackground(Color.WHITE);
        add(categoryBox);
        
        JLabel income= new JLabel("Income :");
        income.setFont( new Font("Raleway", Font.BOLD, 20));
        income.setBounds(100,190,200,30);
        add(income);
        
        String valIncome[]= {"Null","<50,000","<1,00,000",">1,00,000"};
        incomeBox= new JComboBox(valIncome);
        incomeBox.setBounds(300, 190, 400, 30);
        incomeBox.setBackground(Color.WHITE);
        add(incomeBox);
       
        JLabel education= new JLabel("Education ");
        education.setFont( new Font("Raleway", Font.BOLD, 20));
        education.setBounds(100,240,200,30);
        add(education);
        
        JLabel qualification= new JLabel("Qualification :");
        qualification.setFont( new Font("Raleway", Font.BOLD, 20));
        qualification.setBounds(100,260,200,30);
        add(qualification);
        
        String valEducation[]= {"Bachelors","Masters","Doctorate","Others"};
        educationBox= new JComboBox(valEducation);
        educationBox.setBounds(300, 260, 400, 30);
        educationBox.setBackground(Color.WHITE);
        add(educationBox);
        
        
        JLabel occupation= new JLabel("Occupation :");
        occupation.setFont( new Font("Raleway", Font.BOLD, 20));
        occupation.setBounds(100,310,200,30);
        add(occupation);
        
        String valOccupation[]= {"Salaried","Self-Employed","Retired","Student","Others"};
        occupationBox= new JComboBox(valOccupation);
        occupationBox.setBounds(300, 310, 400, 30);
        occupationBox.setBackground(Color.WHITE);
        add(occupationBox);
        
        
        JLabel ssnNo= new JLabel("SSN :");
        ssnNo.setFont( new Font("Raleway", Font.BOLD, 20));
        ssnNo.setBounds(100,360,200,30);
        add(ssnNo);
        
        ssnNoTextField = new JTextField();
        ssnNoTextField.setFont( new Font("Raleway", Font.BOLD, 14));
        ssnNoTextField.setBounds(300, 360, 400, 30);
        add(ssnNoTextField);
        
        JLabel veteran= new JLabel("Veteran :");
        veteran.setFont( new Font("Raleway", Font.BOLD, 20));
        veteran.setBounds(100,410,200,30);
        add(veteran);
        
        veteranYes=new JRadioButton("Yes");
        veteranYes.setBounds(300, 410,100,30);
        veteranYes.setBackground(Color.WHITE);
        add(veteranYes);
        
        veteranNo=new JRadioButton("No");
        veteranNo.setBounds(450, 410,100,30);
        veteranNo.setBackground(Color.WHITE);
        add(veteranNo);
        
        ButtonGroup veterangroup= new ButtonGroup();
        veterangroup.add(veteranYes);
        veterangroup.add(veteranNo);
        
        JLabel existingAccount= new JLabel("Existing Account :");
        existingAccount.setFont( new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100,460,200,30);
        add(existingAccount);
        
        existingYes=new JRadioButton("Yes");
        existingYes.setBounds(300, 460,100,30);
        existingYes.setBackground(Color.WHITE);
        add(existingYes);
        
        existingNo=new JRadioButton("No");
        existingNo.setBounds(450, 460,100,30);
        existingNo.setBackground(Color.WHITE);
        add(existingNo);
        
        ButtonGroup existingAccountgroup= new ButtonGroup();
        existingAccountgroup.add(existingYes);
        existingAccountgroup.add(existingNo);
        
        
        
        next= new JButton("Next");
        next.setBackground(Color.RED);
        next.setForeground(Color.BLACK);
        next.setFont(new Font("Raleway",Font.BOLD,14));
        next.setBounds(620, 660, 80, 30);
        next.addActionListener(this);
        add(next);
        
        
        getContentPane().setBackground(Color.WHITE);// for this import awt 
        setSize(850,800);
        
        setLocation(350,10);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        String category= (String)categoryBox.getSelectedItem();
        String income= (String)incomeBox.getSelectedItem();
      
        String education= (String)educationBox.getSelectedItem();
        String occupation= (String)occupationBox.getSelectedItem();
        
        String ssnNo=ssnNoTextField.getText();
        //
        String veteran=null;
        
        if(veteranYes.isSelected())
        {
            veteran="Yes";
        }
        else if(veteranNo.isSelected())
        {
            veteran="No";
        }
        
        
        
        String existingAccount=null;
        
        if(existingYes.isSelected())
        {
            existingAccount="Yes";
        }
        else if(existingNo.isSelected())
        {
            existingAccount="No";
        }
        
        
        
        
        try
        {
            Conn c= new Conn();
                        
                        //String query = "insert into signup values('"+formno+"','"+name+"','"+fname+"','"+dob+"','"+gender+"','"+mailId+"','"+marital+"','"+address+"','"+city+"','"+state+"','"+zipcode+"')";
            String query="insert into signuptwo values('"+formno+"', '"+category+"','"+income+"', '"+education+"',  '"+occupation+"', '"+ssnNo+"', '"+veteran+"', '"+existingAccount+"')";
            c.s.executeUpdate(query);
            
            //signupThree object
            setVisible(false);
            new SignUpThree(formno).setVisible(true);
                    
        }
        catch(Exception e)
        {
             System.out.println(e);
        }
        
        
    }
    
    public static void main(String args[])
    {
        new SignupTwo("");
    }
    
}
