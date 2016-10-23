import java.awt.Toolkit;
import java.util.*;

public class Timer 
{
	private int time;
	
	public Timer(int time)
	{
		this.time = time;
	}
	
	public void start()
	{
		while(time >= 1000)
		{
			System.out.println(time/1000 + " seconds remain!");
			try 
			{
				Thread.sleep(1000);
				time = time - 1000;
			} 
			catch (InterruptedException e) 
			{
				System.out.println("Timer interrupted! Stopping timer.");
				break;
			}
		}
		System.out.println(time/1000 + " seconds remain!");
		alarm();
	}
	
	public void alarm()
	{
		for(int i = 0; i < 3; i++)
		{
			Toolkit.getDefaultToolkit().beep();
			try 
			{
				Thread.sleep(200);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("I was interrupted!");;
			}
			Toolkit.getDefaultToolkit().beep();
			try 
			{
				Thread.sleep(1000);
			} 
			catch (InterruptedException e) 
			{
				System.out.println("I was interrupted!");;
			}
		}
	}
	
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter time to wait in seconds: ");
		int time;
		while(true)
		{
			try
			{
				time = scan.nextInt()*1000;
				break;
			}
			catch(Exception e)
			{
				System.out.println("Invalid input. Please enter time in whole numerical seconds.");
				scan.next();
			}
		}
		scan.close();
		Timer t = new Timer(time);
		t.start();
	}
}
