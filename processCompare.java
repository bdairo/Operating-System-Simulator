import java.util.Comparator;

public class processCompare implements Comparator<Process>
{

	@Override
	public int compare(Process p0, Process p1) {
		// TODO Auto-generated method stub
		if(p0.priority < p1.priority)
			return 1;
		else if(p0.priority > p1.priority)
			return -1;
		else
			return 1;
	}
	
}
