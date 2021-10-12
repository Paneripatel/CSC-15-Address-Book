//Paneri Patel
//Csc 20
//Final Project

import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.io.IOException;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.swing.*;
import javax.swing.event.*;


public class Project extends JFrame implements ActionListener {
	
   static JPanel bottom, Sub1, Sub2, Phase1, Phase2, Phase3, Phase4, Phase5, Phase6, Phase7, Phase8;
   static JLabel label2b;
   static JTextField contactname, contactname2, contactname3, numContacts, lastName, address_lbl, searchStr, firstName, emailadd, phnumber;
   static JTable table, abTable;
   static Container contentPane;
   static CardLayout contentPaneLayout = new CardLayout();
   static ActionListener AL = new Project();
   static JScrollPane scrollPane = new JScrollPane();   
   static int contactCount, labNumber, studentCurrent, currentS;
   static String CN;     
   static JRadioButton rb1 = new JRadioButton("By First Name", true);     
   static JRadioButton rb2 = new JRadioButton("By Last Name");
   static JButton brb4 = new JButton(" Top Menu");
   static JButton brb5 = new JButton(" Top Menu");
   static JButton brb6 = new JButton(" Top Menu");
   static JButton brb7 = new JButton(" Top Menu");
   static JButton brbSearch = new JButton("Search");
   static JButton newAddress = new JButton (" Create a New Address Book");
   static JButton loadContacts = new JButton (" Load Contacts");
   static JButton addNew = new JButton (" Add New Contacts");
   static JButton searchContact = new JButton (" Search Contacts");
   static JButton sortContacts = new JButton (" Sort Contacts");
   static JButton viewDelete = new JButton (" View/Delete Contacts");
   static JButton Backup = new JButton (" Backup Contacts");
   static JButton Exit = new JButton (" Exit");
   static JButton create = new JButton("Create");
   static JButton cancel = new JButton("Cancel");
   static JButton cancel2 = new JButton("Cancel");
   static JButton cancel3 = new JButton("Cancel");
   static JButton load = new JButton("Load");
   static JButton load2 = new JButton("Load");
   static JButton sort = new JButton("Sort Contacts");
   static JButton saveAdd = new JButton("Save new Contact");
   static JButton deleteSelect = new JButton("Delete Selected");
   static address[] contactA = new address[100];
   static String[][] rowData = new String[100][100]; 
   static String[] colName = new String[] 
      {"First Name", "Last Name", "Email Address", "Address", "Phone Number"};   
   static String[] cbxYear = new String[] { "Freshman", "Sophomore", "Junior", "Senior", "Graduate" };
   static String[] cbxGender = new String[] { "Male", "Female" };
   static FileOutputStream fos;  
   static ObjectOutputStream oos;   
   static ObjectInputStream ois;
   
   public static void main(String[] args) throws IOException {
	   
      
      JFrame frm = new JFrame("Address Book");
      contentPane = frm.getContentPane();
      contentPane.setLayout(contentPaneLayout);
      
      JLabel label = new JLabel("<html><font size = 5><b>Use The Buttons Below To Manage Contacts</b></html>", JLabel.CENTER);
      JLabel label1 = new JLabel("User Name: ", JLabel.CENTER);
      contactname = new JTextField(15);
      contactname.setEditable(false);
      JLabel label2 = new JLabel("Number of contacts: ", JLabel.CENTER);
      numContacts = new JTextField(10);
      numContacts.setEditable(false);
      Phase1 = new JPanel(new BorderLayout());
      Phase1.add(label, BorderLayout.NORTH);
      JPanel Sub1 = new JPanel(new FlowLayout());
      Sub1.add(label1);
      Sub1.add(contactname);
      Sub1.add(label2);
      Sub1.add(numContacts);
      Phase1.add(Sub1, BorderLayout.CENTER);
      bottom = new JPanel(new GridLayout(2, 4));
      bottom.add(newAddress);
      bottom.add(loadContacts);
      bottom.add(addNew);
      bottom.add(searchContact);
      bottom.add(sortContacts);
      bottom.add(viewDelete);
      bottom.add(Backup);
      bottom.add(Exit);
      
      Phase1.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(Phase1, "Card 1");
      
      
      newAddress.addActionListener(AL);
      loadContacts.addActionListener(AL);
      addNew.addActionListener(AL);
      searchContact.addActionListener(AL);
      sortContacts.addActionListener(AL);
      viewDelete.addActionListener(AL);
      Backup.addActionListener(AL);
      Exit.addActionListener(AL);
      
      
      
      label = new JLabel("<html><font size = 5><b>Create a New Address Book</b></html>", JLabel.CENTER);
      label1 = new JLabel("User Name: ", JLabel.CENTER); 
      contactname2 = new JTextField(15);
      Phase2 = new JPanel(new BorderLayout());
      Phase2.add(label, BorderLayout.NORTH);
      Sub1 = new JPanel(new FlowLayout());
      Sub1.add(label1);
      Sub1.add(contactname2);
      Phase2.add(Sub1, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      create.setBounds(2,2,50,25);
      cancel.setBounds(2,2,50,25);
      bottom.add(create);
      bottom.add(cancel);
      Phase2.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(Phase2, "Card 2");
      create.addActionListener(AL);
      cancel.addActionListener(AL);
      
            
      
      label = new JLabel("<html><font size = 5><b>Load Contacts From a File</b></html>", JLabel.CENTER);
      label1 = new JLabel("User Name: ", JLabel.CENTER);
      contactname3 = new JTextField(15);
      Phase3 = new JPanel(new BorderLayout());
      Phase3.add(label, BorderLayout.NORTH);
      Sub1 = new JPanel(new FlowLayout());
      Sub1.add(label1);
      Sub1.add(contactname3);
      Phase3.add(Sub1, BorderLayout.CENTER);
      bottom = new JPanel(new FlowLayout());
      load.setBounds(2,2,50,25);
      cancel2.setBounds(2,2,50,25);
      bottom.add(load);
      bottom.add(cancel2);
      Phase3.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(Phase3, "Card 3");
      cancel2.addActionListener(AL);
      load.addActionListener(AL);
     
      
      
      label = new JLabel("<html><font size = 5><b>Enter Contact Information</b></html>", JLabel.CENTER);
      label1 = new JLabel("First Name: ", JLabel.RIGHT);
      firstName = new JTextField(15);    
      label2 = new JLabel("Last Name: ", JLabel.RIGHT);
      lastName = new JTextField(15);      
      JLabel label3 = new JLabel("Email Address: ", JLabel.RIGHT);  
      emailadd = new JTextField(15); 
      JLabel label4 = new JLabel("Address: ", JLabel.RIGHT);
      address_lbl = new JTextField(15);
      JLabel label5 = new JLabel("Phone Number: ", JLabel.RIGHT);
      phnumber = new JTextField(15);
      Phase4 = new JPanel(new BorderLayout());
      Phase4.add(label, BorderLayout.NORTH);
      Sub1 = new JPanel();
      Sub1 = new JPanel(new GridLayout(5, 2));
      Sub1.add(label1);
      Sub1.add(firstName);
      firstName.setHorizontalAlignment(JTextField.LEFT);
      Sub1.add(label2);
      Sub1.add(lastName);
      lastName.setHorizontalAlignment(JTextField.LEFT);
      Sub1.add(label3);
      Sub1.add(emailadd);
      emailadd.setHorizontalAlignment(JTextField.LEFT);      
      Sub1.add(label4);
      Sub1.add(address_lbl);
      address_lbl.setHorizontalAlignment(JTextField.LEFT);
      Sub1.add(label5);
      Sub1.add(phnumber);
      phnumber.setHorizontalAlignment(JTextField.LEFT);      
      
     
      Phase4.add(Sub1, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      saveAdd.setBounds(2,2,50,25);
      brb4.setBounds(2,2,50,25);
      bottom.add(saveAdd);
      bottom.add(brb4);
      Phase4.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(Phase4, "Card 4");
      brb4.addActionListener(AL);
      saveAdd.addActionListener(AL);
      
      
     
      label = new JLabel("<html><font size = 5><b>Search Contacts by First Name or Last Name</b></html>", JLabel.CENTER);
      JLabel label2a = new JLabel("Search String: ", JLabel.CENTER);
      searchStr = new JTextField(10);
      Phase5 = new JPanel(new GridLayout(0,1));
      Phase5.add(label);
      Sub1 = new JPanel(new FlowLayout());
      table = new JTable(rowData, colName);
      table.setPreferredScrollableViewportSize(new Dimension(800, 80));
      table.setFillsViewportHeight(true);
      Phase5.add(scrollPane, BorderLayout.WEST);   
      
      Sub1.add(searchStr);
      Phase5.add(Sub1);
      bottom = new JPanel(new FlowLayout());
      
      brb5.setBounds(2,2,50,25);
      brbSearch.setBounds(1,1,50,25);
      bottom.add(label2a);
      
      bottom.add(searchStr);
      
      bottom.add(brbSearch);
      bottom.add(brb5);

      Phase5.add(bottom, BorderLayout.NORTH);    
      contentPane.add(Phase5, "Card 5");
      brbSearch.addActionListener(AL);
      searchStr.addActionListener(AL);
      brb5.addActionListener(AL);
      
      
    

      Phase6 = new JPanel(new GridLayout(0,1));
      label = new JLabel("<html><font size = 5>Sort Contacts By:</html>", JLabel.CENTER);
      
      
      ButtonGroup bg1 = new ButtonGroup();
      bg1.add(rb2);
      bg1.add(rb1);

      
      Box verticalBox = Box.createHorizontalBox();
      verticalBox.add(rb2);
      verticalBox.add(rb1);
      Phase6.add(verticalBox, BorderLayout.SOUTH);      

      bottom = new JPanel(new FlowLayout());
      sort.setBounds(1,2,50,25);
      brb6.setBounds(2,2,50,25);
      
      bottom.add(sort);
      bottom.add(brb6);
      Phase6.add(bottom, BorderLayout.PAGE_END);    
      contentPane.add(Phase6, "Card 6");
      sort.addActionListener(AL);
      brb6.addActionListener(AL);
    
      
      
      label = new JLabel("<html><font size = 4><b>Contact List</b></html>", JLabel.CENTER);      
      Phase7 = new JPanel(new BorderLayout());
      Phase7.add(label, BorderLayout.NORTH);
      Sub1 = new JPanel(new FlowLayout());
      table = new JTable(rowData, colName);
      table.setPreferredScrollableViewportSize(new Dimension(800, 80));
      table.setFillsViewportHeight(true);
      Phase7.add(scrollPane, BorderLayout.CENTER); 
      bottom = new JPanel(new FlowLayout());
      deleteSelect.setBounds(2,2,50,25);
      brb7.setBounds(2,2,50,25);
      bottom.add(deleteSelect);
      bottom.add(brb7);
      Phase7.add(bottom, BorderLayout.SOUTH);    
      contentPane.add(Phase7, "Card 7");
      brb7.addActionListener(AL);
      deleteSelect.addActionListener(AL);
     
      
      Backup.addActionListener(AL);
      
      frm.pack();
      frm.setSize(900,300);
      frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frm.setVisible(true);
      
   }
   
      public void actionPerformed(ActionEvent e) {
    	  
         Object source = e.getSource();
         
         if (source == create) {
        	 
            CN = contactname2.getText();
            contactCount = 0;
            contactname.setText(CN);
            numContacts.setText("" + contactCount);
            contentPaneLayout.show(contentPane, "Card 1");
            
         }
         
         if (source == cancel) contentPaneLayout.show(contentPane, "Card 1");
         if (source == cancel2) contentPaneLayout.show(contentPane, "Card 1");
         if (source == cancel3) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb4) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb5) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb6) contentPaneLayout.show(contentPane, "Card 1");
         if (source == brb7) contentPaneLayout.show(contentPane, "Card 1");
         if (source == newAddress) contentPaneLayout.show(contentPane, "Card 2");
         if (source == loadContacts) contentPaneLayout.show(contentPane, "Card 3");
         
         if (source == load) {
        	 
            address St;
            
            try {
            	
               CN = contactname3.getText();
               System.out.println("Contactname 3 is " + CN);
               contactCount = 0;
               
              
               ois = new ObjectInputStream(new FileInputStream(CN));
               
               while (true) {
            	   
                  St = (address)ois.readObject();
                  System.out.println("\n");
                  System.out.println("Contact's First Name: " + St.firstName);
                  System.out.println("Contact's Last Name: " + St.NameS); 
                  System.out.println("Contact's Email Address: " + St.emailaddS);
                  System.out.println("Contact's Address: " + St.address_lblC);
                  System.out.println("Contact's Phone Number: " + St.phnumberS);
                  contactA[contactCount] = St;
                  contactCount++;
                  
               }
               
            } 
            
            catch (EOFException ey) {
            } 
            
            catch (Exception ex) { 
            	
               ex.printStackTrace();
               
            }
            contactname.setText(CN);
            numContacts.setText("" + contactCount);
            contentPaneLayout.show(contentPane, "Card 1");
         }
         
         if (source == addNew) contentPaneLayout.show(contentPane, "Card 4");
         
         if (source == saveAdd) {
        	 
            address temp = new address();
            temp.firstName = firstName.getText();
            temp.NameS = lastName.getText();
            temp.emailaddS = emailadd.getText();
            temp.address_lblC = address_lbl.getText();
            temp.phnumberS = phnumber.getText();
            contactA[contactCount] = temp;
            contactCount++;
            firstName.setText("");
            lastName.setText("");
            emailadd.setText("");
            address_lbl.setText("");
            phnumber.setText("");
            numContacts.setText("" + contactCount);
            
         }
         
         if (source == brbSearch) {
            
            String searchString = searchStr.getText();
            System.out.println(searchString);
            StringBuilder sb=new StringBuilder();  
            for(int i=0; i<contactCount;i++) {
            
        	      if(contactA[i].firstName.equalsIgnoreCase(searchString)|| contactA[i].NameS.equalsIgnoreCase(searchString)){
                  sb.append("Name: "+ contactA[i].firstName + " " + contactA[i].NameS + "\n");
                  sb.append("Email Address: " + contactA[i].emailaddS + "\n");
                  sb.append("Address: " + contactA[i].address_lblC + "\n");
                  sb.append("Phone Number: " + contactA[i].phnumberS);
               
                  JOptionPane.showMessageDialog(null, sb.toString() /*contactA[i].firstName*/ /*contactA[i].NameS, contactA[i].emailaddS, contactA[i].address_lblC, contactA[i].phnumberS*/);
               }
            }
            
         }
         
         
         if (source == searchContact)  contentPaneLayout.show(contentPane, "Card 5");
         if (source == sortContacts) contentPaneLayout.show(contentPane, "Card 6");
         
         if(source == sort) {
            if (rb1.isSelected()) {
               for(int i=0;i<contactCount;i++) {
                  for (int j = i+1; j<contactCount; j++) {
                     if(contactA[i].firstName.compareTo(contactA[j].firstName)>0) {
                         address temp = contactA[i];
                         contactA[i] = contactA[j];
                         contactA[j] = temp;
                     }
                  }
               }
            }
            if (rb2.isSelected()) {
               for(int i=0;i<contactCount;i++) {
                     for (int j = i+1; j<contactCount; j++) {
                        if(contactA[i].NameS.compareTo(contactA[j].NameS)>0) {
                            address temp = contactA[i];
                            contactA[i] = contactA[j];
                            contactA[j] = temp;
                        }
                     }
                  }

               }
         }
         
         if (source == viewDelete) {
        	 
            rowData = new String[contactCount][15];
            
            for (int i = 0; i < contactCount; i++) {
            	
               rowData[i][0] = contactA[i].firstName + "";
               rowData[i][1] = contactA[i].NameS + "";
               rowData[i][2] = contactA[i].emailaddS + "";
               rowData[i][3] = contactA[i].address_lblC + "";
               rowData[i][4] = contactA[i].phnumberS + "";
               
            }
            
            abTable = new JTable(rowData, colName);
            JScrollPane tmp = new JScrollPane(abTable);
            scrollPane.setViewport(tmp.getViewport());
            contentPaneLayout.show(contentPane, "Card 7");
            
         }
         if (source == deleteSelect) {
        	 
            int del = abTable.getSelectedRow();
            
            for (int k = del; k < contactCount - 1; ++k) 
               contactA[k] = contactA[k+1];
            contactCount--;
            rowData = new String[contactCount][15];
            
            for (int i = 0; i < contactCount; i++) {
            	
               rowData[i][0] = contactA[i].firstName + "";
               rowData[i][1] = contactA[i].NameS + "";
               rowData[i][2] = contactA[i].emailaddS + "";
               rowData[i][3] = contactA[i].address_lblC + "";
               rowData[i][4] = contactA[i].phnumberS + "";
               
            }
            numContacts.setText("" + contactCount);
            abTable = new JTable(rowData, colName);
            JScrollPane tmp = new JScrollPane(abTable);
            scrollPane.setViewport(tmp.getViewport());
            contentPaneLayout.show(contentPane, "Card 7");
         }
         if (source == Backup) { 
        	 
            
            System.out.println("contactname is " + CN);
            
            if (CN.equals("")) System.exit(0);
            else {
                
               try {
            	   
               
               contactCount = rowData.length;
               
               
               fos = new FileOutputStream(CN);
               oos = new ObjectOutputStream(fos);
               
               
               for (int i = 0; i < contactCount; i++)
                  oos.writeObject(contactA[i]);

               oos.close();
               } 
               catch (Exception ex) {
                  ex.printStackTrace();
               }
            }
         }
         if (source == Exit) 
        	 System.exit(0); 
      }
} 

class address implements Serializable { 

	String NameS, firstName, emailaddS, address_lblC, phnumberS;
	int Year, Gender, Part1, Part2, Part3, Part4, Part5, Part6, Part7, Part8, Part9, Part10; 
	
}

