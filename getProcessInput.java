import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Integer.*;
import java.util.concurrent.*;


public class getProcessInput extends Thread
{
	public void setname(String name)
	{
		if(name.length()!=0)
			MainRunner.procName = name;
		else
			MainRunner.procName = "systemProcess";
		
		System.out.println(MainRunner.procName);
	}
	
	public void setLife(String life)
	{
		if(life.length()!=0)
			MainRunner.procLife = Integer.parseInt(life);
		else
			MainRunner.procLife = 120;
		//this.prosLife = life;
	}
	
	public void setPriority(String priorityNum)
	{
		if(priorityNum.length()!= 0)
		{
			MainRunner.procNumber = Integer.parseInt(priorityNum);
		}else
			MainRunner.procNumber = 3;
	}
	
	//private CountDownLatch latch1;
	public void run()
	{
		
		JFrame getProcessWindow = new JFrame("Add a Process");
		getProcessWindow.setSize(530, 400);
		getProcessWindow.setLayout(null);
		//getProcessWindow.getContentPane().setLayout(new FlowLayout());
	    
	    //JTextField processName = new JTextField("Enter the process name...", 25);
		JTextField processName = new JTextField(25);
		//processName.setBackground(Color.BLACK);
	    processName.setBounds(30, 15, 400, 50);
	    processName.setHorizontalAlignment(JTextField.RIGHT);
	    JTextField pName = new JTextField("Process Name (Default = systemProcess");
	    pName.setBorder(null);
	    pName.setBackground(null);
	    pName.setBounds(330, 70, 100, 25);

	    JTextField processLife = new JTextField();
	    //JTextArea processLife = new JTextArea("Enter the lifeTime...");
	    processLife.setBounds(230, 100, 200, 40);
	    processLife.setHorizontalAlignment(JTextField.RIGHT);
	    JTextField pLife = new JTextField("Process LifeTime(int) default=120");
	    pLife.setBorder(null);
	    pLife.setBackground(null);
	    pLife.setBounds(250, 145, 200, 25);
	    
	    JTextField priorityNumber = new JTextField();
	    priorityNumber.setBackground(Color.WHITE);
	    priorityNumber.setBounds(300, 180, 120, 50);
	    priorityNumber.setHorizontalAlignment(JTextField.RIGHT);
	    JTextField pInfo = new JTextField("Process Priority (0-5) (Default=3)");
	    pInfo.setBorder(null);
	    pInfo.setBackground(null);
	    pInfo.setBounds(250, 220, 180, 50);

	    
	    ImageIcon addIcon = new ImageIcon("D:\\Eclipse Program\\Eclipse WorkSpace\\SimulatingOS\\add.png", "an add icon");
	    JButton addProcessB = new JButton("    Add", addIcon);
	    addProcessB.setBounds(45, 270, 120, 50);
	    
	    getProcessWindow.setVisible(true);
	    //this.latch1 = MainRunner.latch;
	    
	    addProcessB.addActionListener(new ActionListener()
	    		{
	    			public void actionPerformed(ActionEvent arg1)
	    			{
	    				String name, life, priorityNum;
	    				name = processName.getText();
	    				setname(name);
	    				life = processLife.getText();
	    				setLife(life);
	    				priorityNum = priorityNumber.getText();
	    				setPriority(priorityNum);
	    				getProcessWindow.dispose();
	    				
	    				
	    				Process one = new Process(MainRunner.procName, MainRunner.procLife, MainRunner.procNumber);
	    				MainRunner.processQueue.add(one);
	    			}
	    		});
	    
	    
	    
	    getProcessWindow.add(processName);
	    getProcessWindow.add(processLife);
	    getProcessWindow.add(pLife);
	    getProcessWindow.add(pName);
	    getProcessWindow.add(addProcessB);
	    getProcessWindow.add(priorityNumber);
	    getProcessWindow.add(pInfo);
	    //getProcessWindow.pack();
	    getProcessWindow.setVisible(true);
		
//	}
	
	
	
	}
}
