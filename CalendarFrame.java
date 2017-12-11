import java.awt.*;   
import java.util.*;
import java.awt.event.*;
import java.text.*;

import javax.swing.*;
import javax.swing.Timer; 
public class CalendarFrame extends JFrame implements ActionListener{   
	Calendarcal calendar; 
    JLabel labelDay[]=new JLabel[42];   
    JTextField  text=new JTextField(10);
    JTextField text2=new JTextField(50);
    JButton titleName[]=new JButton[8];   
    JButton button = new JButton();  
    String name[]={"Sun.","Mon.","Tue.","Wed", "Thu.","Fri.","Sat."};   
    JButton nextMonth,previousMonth,time,event;   
    int y= Calendarcal.getyear();
    int m= Calendarcal.getmonth();
    int year=y,month=m; //initial calendar time 
      
    JLabel showMessage=new JLabel("",JLabel.CENTER);   
    JLabel lbl1 = new JLabel("Switch Year£º");  // switch the year
    JLabel lbl2=new JLabel("       ");  
    JLabel lbl3=new JLabel  (" New Event: ");// Add new Events
    JLabel lbl4=new JLabel("       ");

    public CalendarFrame(){   
        JPanel pCenter=new JPanel();   
          
      //Set pCenter layout as 7x7 GridLayout   
        pCenter.setLayout(new GridLayout(7,7));    
          
      //add titleName[i] to pCenter
        for(int i=0;i<7;i++)   
        {   
            titleName[i]=new JButton(name[i]);   
            pCenter.add(titleName[i]);   
        }   

      //add labelDay[i] to pCenter  
        for(int i=0;i<42;i++){   
            labelDay[i]=new JLabel("",JLabel.CENTER);   
            pCenter.add(labelDay[i]);  
        }   
          
        text.addActionListener(this);
        text2.addActionListener(this);
        calendar=new Calendarcal();   
        calendar.setYear(year);   
        calendar.setMonth(month);   
        String day[]=calendar.getCalendar();   

        for(int i=0;i<42;i++){   
            labelDay[i].setText(day[i]);   
        }   

        nextMonth=new JButton    ("  Next Month  ");   
        previousMonth=new JButton("Previous Month");
        time=new JButton("Today");
        button=new JButton("Enter");
        event=new JButton("Add Event");
        
          
        //listener 
        nextMonth.addActionListener(this);   
        previousMonth.addActionListener(this);   
        button.addActionListener(this);  
          
        JPanel pNorth=new JPanel(),  
        pSouth=new JPanel();   
        pNorth.add(showMessage);    
        pNorth.add(lbl2);    
        pNorth.add(previousMonth);   
        pNorth.add(nextMonth);
        pNorth.add(time);
        pSouth.add(lbl1);          
        pSouth.add(text);  
        pSouth.add(button); 
        pSouth.add(lbl4);
        pSouth.add(lbl3);
        pSouth.add(text2);
        pSouth.add(event);
        showMessage.setText("Calendar of  "+"Year "+calendar.getYear()+"."+ calendar.getMonth() );  
        ScrollPane scrollPane=new ScrollPane();   
        scrollPane.add(pCenter);   
        add(scrollPane,BorderLayout.CENTER);//add scrollPane in the middle
        add(pNorth,BorderLayout.NORTH);// add pNorth on top 
        add(pSouth,BorderLayout.SOUTH);// add pSouth at bottom
        time.addActionListener(this);  
        time.addActionListener(new ActionListener() {
     	   
     	   @Override
     	   public void actionPerformed(ActionEvent e) {
     		  Label dateLable = new Label("date");
     		    Label timeLable = new Label("time");
     		 
     		    JFrame.setDefaultLookAndFeelDecorated(true);
     		    JFrame f = new JFrame("Today");
     		    f.setSize(750,350);	    
     		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     		    f.setLayout(new GridLayout(3, 1));
     		 
     		    f.add(dateLable);
     		    f.add(timeLable);
     		    f.getContentPane().setBackground(Color.white);
     		    f.setVisible(true);
     		    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     	   }
     	  });
     }   
     
     public void actionPerformed(ActionEvent A){ 
    
         if(A.getSource()==nextMonth){   
             month=month+1;   
             if(month>12)
            	 
             month=1;
             year=year+1;
             calendar.setMonth(month);  
             
             String day[]=calendar.getCalendar();   

             for(int i=0;i<42;i++){  
                 labelDay[i].setText(day[i]);   
             }   
          }   
         else if(A.getSource()==previousMonth){   
             month=month-1;                
             if(month<1)   
             month=12;
             year=year-1;
             calendar.setMonth(month);
             
             String day[]=calendar.getCalendar();   

             for(int i=0;i<42;i++)   
             {   
                 labelDay[i].setText(day[i]);   
             }   
          }   
         else if(A.getSource()==button){  
             month=month+1;                
             if(month>12)                  
                   month=1;
             
             calendar.setYear(Integer.parseInt(text.getText()));               
             String day[]=calendar.getCalendar();                  
             for(int i=0;i<42;i++){  
                 labelDay[i].setText(day[i]);  
             }  
         }
         else if(A.getSource()==time){
        	 
        	 month=Calendarcal.getmonth();
        	 year=Calendarcal.getyear();
        	 calendar.setMonth(month);
        	 calendar.setYear(year);               
             String day[]=calendar.getCalendar();                  
             for(int i=0;i<42;i++){  
                 labelDay[i].setText(day[i]);  
         }
         }
         else if(A.getSource()==event){
        	 String s=text2.getText();
        	 Calendar.addEvent(s);
         }
       showMessage.setText("Calendar of  "+"Year "+calendar.getYear()+"."+ calendar.getMonth() );   
    }
     
}
