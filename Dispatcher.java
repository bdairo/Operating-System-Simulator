import java.util.concurrent.TimeUnit;

public class Dispatcher extends Thread
{
	public void run()
	{
		
			while(true)
			{
				try
				{
			Process running = MainRunner.processQueue.peek();			
			
			MainRunner.processQueue.remove();
			MainRunner.runningQueue.add(running);
			try
			{
				for(int i = 0; i < 10; i++)
				{
					running = MainRunner.runningQueue.peek();
					if(!running.isEnded())
						running.run();
					else
						break;
						
					TimeUnit.MILLISECONDS.sleep(1000);
				}
				System.out.println(MainRunner.processQueue);
			} catch (Exception e)
			{
				continue;
				//System.out.println("Error in the dispatcherRun");
			}
			
			
			if(!running.isEnded())
				if(!running.isBlocked())
					MainRunner.processQueue.add(running);
			else if (running.isEnded())
				MainRunner.finishedQueue.add(running);
			//running = MainRunner.runningQueue.peek();
			
			
			MainRunner.runningQueue.remove();
				}
			catch(Exception e1)
			{
				//System.out.println("No elements to run");
			}
				
		}
			
			
		
	}
	
	public void IOReq()
	{
		//System.out.println("pressed");
		
		
		//Process newRun = MainRunner.processQueue.peek();
		//MainRunner.runningQueue.add(newRun);
	}
	
	
}
