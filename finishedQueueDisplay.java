import java.awt.Color;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
import javax.swing.*;

public class finishedQueueDisplay extends Thread
{
	public void run()
	{
		try
		{
			JTextField labelText = new JTextField("Finished Queue: ",20);
			labelText.setBackground(null);
			Font F = labelText.getFont();
			float size = F.getSize() + 4.0f;
			labelText.setFont(F.deriveFont(F.BOLD, size));
			labelText.setBounds(1200, 325, 250, 25);
			labelText.setBorder(null);
			
			JTextArea processQDisplay = new JTextArea(20, 5);
			processQDisplay.setBackground(Color.white);
			processQDisplay.setBorder(BorderFactory.createLineBorder(Color.black));
			Font f = processQDisplay.getFont();
			
			processQDisplay.setFont(f.deriveFont(size));
			processQDisplay.setBounds(1200, 350, 300, 200);
			
			MainRunner.panel.add(processQDisplay);
			MainRunner.panel.add(labelText);
			while(true)
				{
				String processNames = "";
				
				
				
				try {
					for(int i = 0; i < MainRunner.finishedQueue.size(); i++)
					{
						Process list = MainRunner.finishedQueue.peek();
						processNames += list.display() + "\n";
						MainRunner.finishedQueue.remove();
						MainRunner.finishedQueue.add(list);
					}
				
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
			System.out.println("Error in FQDisplay");
		}
	}
}
