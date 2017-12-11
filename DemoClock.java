import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;
public class DemoClock{
	public static  void main(String[]args) {//Test Main method
		 
	    Label dateLable = new Label("date");
	    Label timeLable = new Label("time");
	 
	    JFrame.setDefaultLookAndFeelDecorated(true);
	    JFrame f = new JFrame("Clock");
	    f.setSize(750,350);	    
	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    f.setLayout(new GridLayout(3, 1));
	 
	    f.add(dateLable);
	    f.add(timeLable);
	    f.getContentPane().setBackground(Color.white);
	    f.setVisible(true);
	  }
	}
	 
	class Label extends JLabel implements ActionListener {
	  String type;
	  SimpleDateFormat sdf;
	 
	  public Label(String type) {
	    this.type = type;
	    setForeground(Color.black);
	 
	    switch (type) {
	      case "date" : sdf = new SimpleDateFormat("  MMMM dd yyyy EEEE");
	                    setFont(new Font("sans-serif", Font.PLAIN, 20));
	                    setHorizontalAlignment(SwingConstants.LEFT);
	                    break;
	      case "time" : sdf = new SimpleDateFormat("hh:mm:ss a");
	                    setFont(new Font("sans-serif", Font.PLAIN, 50));
	                    setHorizontalAlignment(SwingConstants.CENTER);
	                    break;

	    
	    }
	 
	    Timer t = new Timer(1000, this);//refresh
	    t.start();
	  }
	 
	  public void actionPerformed(ActionEvent ae) {
	    Date d = new Date();
	    setText(sdf.format(d));
	  }

}

	
	



