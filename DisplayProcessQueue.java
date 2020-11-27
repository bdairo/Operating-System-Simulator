import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import java.util.*;
import javax.swing.*;

public class DisplayProcessQueue extends Thread
{
	public void run()
	{
		try
		{
			JTextField labelText = new JTextField("Process Queue: ",20);
			labelText.setBackground(null);
			Font F = labelText.getFont();
			float size = F.getSize() + 4.0f;
			labelText.setFont(F.deriveFont(F.BOLD, size));
			labelText.setBounds(650, 25, 250, 25);
			labelText.setBorder(null);
			
			JTextArea processQDisplay = new JTextArea(20, 5);
			processQDisplay.setBackground(Color.white);
			processQDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
			Font f = processQDisplay.getFont();
			
			processQDisplay.setFont(f.deriveFont(size));
			processQDisplay.setBounds(650, 50, 300, 600);
			
			MainRunner.panel.add(processQDisplay);
			MainRunner.panel.add(labelText);
			while(true)
				{
				String processNames = "";
				
				
				
				try {
					Iterator i = MainRunner.processQueue.iterator();
					while(i.hasNext())
					{
						//System.out.println(i.next());
						processNames += i.next() + "\n";
					}
//					for(int i = 0; i < MainRunner.processQueue.size(); i++)
//					{
//						Process list = MainRunner.processQueue.poll();
//						processNames += list.display() + "\n";
//						//MainRunner.processQueue.remove();
//						MainRunner.processQueue.add(list);
//					}
				
				}
				catch(Exception e1)
				{
					System.out.println("Error is here");
				}
				
				processQDisplay.setText(processNames);
				//System.out.println(processNames);
				TimeUnit.SECONDS.sleep(1);
				}
		}
		catch(Exception e)
		{
			System.out.println("Error in PQdisplay");
		}
	}
}
