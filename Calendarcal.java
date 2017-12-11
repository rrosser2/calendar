import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;  
public class Calendarcal{
	String day[];   
int year=2017,month=0;          
public void setYear(int year)   
{   
    this.year=year;   
}   
  
public int getYear()   
{   
    return year;   
}   
  
public void setMonth(int month)   
{   
    this.month=month;   
}   
  
public int getMonth()   
{   
    return month;   
}   
  
public String[] getCalendar()   
{   
    String a[]=new String[42];   
    Calendar date=Calendar.getInstance();   
    date.set(year,month-1,1);   
    int week=date.get(Calendar.DAY_OF_WEEK)-1;   
    int day=0;   
     
    //exam month 
    if(month==1||month==3||month==5||month==7 
      ||month==8||month==10||month==12)   
    {   
        day=31;   
    }   
      
     
    if(month==4||month==6||month==9||month==11)   
    {   
        day=30;   
    }   
      
    //exam year  
    if(month==2)   
    {   
        if(((year%4==0)&&(year%100!=0))||(year%400==0))   
        {   
            day=29;   
        }   
          
        else   
        {   
            day=28;   
        }   
     }   
      
    for(int i=week,n=1;i<week+day;i++)   
    {   
            a[i]=String.valueOf(n) ;   
            n++;   
    }              
    return a;   
 }

public static int getyear() {
	Calendar c=Calendar.getInstance();
	c.setTime(new Date());
	int y= c.get(Calendar.YEAR);
	return y;
}
	public static int getmonth() {
		Calendar c=Calendar.getInstance();
		c.setTime(new Date());
		int m= c.get(Calendar.MONTH)+1;
		return m;
}   
	
}