import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.*;

public class MainRunner {

	public static String procName;
	public static int procLife;
	public static int procNumber;
	public static PriorityQueue<Process> processQueue = new PriorityQueue<>(new processCompare());
	public static Queue<Process> runningQueue = new LinkedList<>();
	public static Queue<Process> blockedQueue = new LinkedList<>();
	public static Queue<Process> finishedQueue = new LinkedList<>();
	public static JPanel panel = new JPanel();
	
	public static void main(String[] args) 
	{
	
		//This is the main frame of the window
		JFrame mainWindow = new JFrame("OS Simulation");
		mainWindow.setSize(1600, 750);
	    mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    //All the buttons and display will be put into this panel
	    Process test = new Process("random with priority 1", 100, 1);
	    Process test1 = new Process("random with priority 2", 100, 2);
	    Process test2 = new Process("random with priority 3", 100, 3);
	    Process test3 = new Process("random with priority 4", 100, 4);
	    Process test4 = new Process("random with priority 5", 100, 5);
	    processQueue.add(test);
	    processQueue.add(test1);
	    processQueue.add(test2);
	    processQueue.add(test3);
	    processQueue.add(test4);
	    //runningQueue.add(test);
	    
	    panel.setLayout(null);
	    
	    
	    //Creating the add process button that will add a new process
	    ImageIcon addIcon = new ImageIcon("D:\\Eclipse Program\\Eclipse WorkSpace\\SimulatingOS\\add.png", "an add icon");	    
	    JButton addProcess = new JButton("      Add a Process", addIcon);
	    addProcess.setBounds(120, 500, 250, 100);
	    
	    
	    //Creating an action event for the addProcess button
	    addProcess.addActionListener(new ActionListener()
	    		{
	    	
	    			
					@Override
					public void actionPerformed(ActionEvent arg0) 
					{
						
						getProcessInput one = new getProcessInput();
						one.start();
						
						System.out.println(procName);
						System.out.println(procLife);

					
					}
	    			
	    			
	    		}
	    );
	    Dispatcher dispatcher = new Dispatcher();
		dispatcher.start();
		
		BlockedDispatcher bDispatcher = new BlockedDispatcher();
		bDispatcher.start();
		
	    JButton IOReq = new JButton("I/O Request");
	    Font font = IOReq.getFont();
	    float fontSize = font.getSize() + 4.0f;
	    IOReq.setFont(font.deriveFont(fontSize));
	    IOReq.setBounds(120, 300, 250, 100);
	    
	    IOReq.addActionListener(new ActionListener()
	    		{
	    			
	    			public void actionPerformed(ActionEvent arg1)
	    			{
	    				//dispatcher.IOReq();
	    				Process newrunn = runningQueue.peek();
	    				newrunn.setBlockTime(7);
	    				blockedQueue.add(newrunn);
	    				//Process nnnn= blockedQueue.peek();
	    				runningQueue.remove();
	    				//System.out.println("herere");
	    				//System.out.println(nnnn.display());
	    			}
	    		}
	    		);
	    
//	    System.out.println(procName);
//		System.out.println(procLife);
		
		DisplayProcessQueue one = new DisplayProcessQueue();
		one.start();
		
		runningQueueDisplay two = new runningQueueDisplay();
		two.start();
		
		blockedQueueDisplay three = new blockedQueueDisplay();
		three.start();
		
		finishedQueueDisplay four = new finishedQueueDisplay();
		four.start();
		
//		Dispatcher dispatcher = new Dispatcher();
//		dispatcher.start();
	    
	    panel.add(addProcess);
	    panel.add(IOReq);
	    mainWindow.add(panel);
	   
	    mainWindow.setVisible(true);

	}
}
