//import Process.status;

public class Process
{
	private String name;
	//private status status;
	private int lifeTime;
	private int blockedTime;
	public int priority;
	
	
	public Process()
	{
		this.name = "systemProcess";
		//this.status = status.START;
		this.lifeTime = 120;
		this.blockedTime = 0;
		this.priority = 3;
	}
	
	public Process( Process p)
	{
		name = p.name;
		lifeTime = p.lifeTime;
		priority = 3;
	}
	
	public Process(String name, int life)
	{
		this.name = name;
		//this.status = status.START;
		this.lifeTime = life;
		this.blockedTime = 0;
		this.priority = 3;
	}
	
	public Process(String name, int life, int priority)
	{
		this.name = name;
		//this.status = status.START;
		this.lifeTime = life;
		this.blockedTime = 0;
		if(priority > 5 || priority < 0)
			this.priority = 3;
		else
			this.priority = priority;
	}
	
//	public int compareTo(Process p)
//	{
//		return -(this.priority - p.priority);
//	}\

	public String toString()
	{
		return this.name;
	}
	
	public boolean isEnded()
	{
		return this.lifeTime == 0;
	}
	
	public boolean isBlocked()
	{
		return this.blockedTime != 0;
	}
	
	public void run()
	{
		if (this.isEnded() != true )
			if (this.isBlocked() != true)
			{
				this.lifeTime -= 1;
			}
		
	}
	
	
	public int checkLife()
	{
		return this.lifeTime;
	}
	
	public int checkBlockedTime()
	{
		return this.blockedTime;
	}
	
	public void setBlockTime(int blocktime)
	{
		this.blockedTime = blocktime;
		//this.status = status.BLOCKED;
	}
	
	public void IORun()
	{
		if(this.isEnded() != true)
			if(this.isBlocked())
			{
				this.blockedTime -= 1;
			}
		
	}
	
	public String display()
	{
		return this.name;
	}
	
	
	
}
