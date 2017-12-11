import javax.swing.JFrame;  
import javax.swing.UIManager;  
public class TestMain {
	 public static void main(String args[])   
     {   
          try {  
              UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel"); //windows style 
           }catch (Exception e) {  
             e.printStackTrace();  
           }  
           CalendarFrame frame=new CalendarFrame();   
           frame.setBounds(100,100,360,300);   
           frame.setTitle("Calendar");  
           frame.setLocationRelativeTo(null);//set at middle  
           frame.setVisible(true);   
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
     } 

}
