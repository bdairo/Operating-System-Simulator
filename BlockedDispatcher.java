import java.util.concurrent.TimeUnit;

public class BlockedDispatcher extends Thread
{
	public void run()
	{
		while(true)
		{
			try
			{
				Process blocked = MainRunner.blockedQueue.peek();
				while(true)
				{
					if(blocked.isBlocked())
						blocked.IORun();
					else
						break;
					
					TimeUnit.MILLISECONDS.sleep(1000);
				}
				MainRunner.processQueue.add(blocked);
				MainRunner.blockedQueue.remove();
			}
			catch(Exception e)
			{
				//int a = 5;
				//System.out.println("Empty Blocked Queue");
			}
		}
	}
	
}
