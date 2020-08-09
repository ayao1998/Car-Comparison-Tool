import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class database {
	public static void main(String args[])
	{

		
		//**SETUP
		ArrayList<Car> myCars = new ArrayList<Car>(); 
		Scanner input = new Scanner(System.in);
		Scanner filein;
		java.io.File file = new java.io.File("cars.txt");
		try
		{
			filein = new Scanner(file);
		}
		catch (FileNotFoundException e)
		{
			System.out.println("Can't open input file");
			System.out.println();
			input.close();
			return;
		}
		String temp;
		String tempSplit[];
		while (filein.hasNext())
		{
			temp = filein.nextLine();
			tempSplit = temp.split(" ");
			
			myCars.add(new Car(Integer.parseInt(tempSplit[0]), tempSplit[1], tempSplit[2], tempSplit[3], tempSplit[4], tempSplit[5], tempSplit[6], tempSplit[7], tempSplit[8], tempSplit[9]));

		}
		
		filein.close();
		System.out.println("Car database loaded.");//delete later
		
		
		//**JFRAME STUFF
		
		
		
		JFrame frame = new JFrame("Car Database");  //arg is what the program window says
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //click x to end program
		frame.setSize(415, 290); //size of window
		frame.setLocationRelativeTo(null); 
		frame.setVisible(true); //set to true
		JButton button = new JButton("View cars"); //make a button named "arg"
		button.setBounds(25, 25, 350, 50); // x,y coords, x size y size
		frame.add(button); //add button to frame
		button.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			//printAllCars(myCars); //change
			ArrayList<JButton> carButts = buttonify(myCars); //arraylist of jbuttons with car names
			//need to add action listeners to jbuttons
			addButtons(carButts, myCars);
			}
		});
		

		
		JButton button2 = new JButton("Add a new car");
		button2.setBounds(25, 100, 350, 50);
		frame.add(button2);
		
		
		button2.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			inputCar(myCars);
			}
		});
		
		
		JButton button3 = new JButton("Exit");
		button3.setBounds(25, 175, 350, 50);
		frame.add(button3);
		
		
		button3.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			//exitDatabase(myCars, frame); //close the window temporarily disabled because it was messing up my text file.
			frame.dispose();
			}
		});
		
		//CLOSING THE PROGRAM***
		input.close();

		
	}
	
	public static void addButtons(ArrayList<JButton> buttonz, ArrayList<Car> myCars)
	{

			JFrame frame = new JFrame("All cars"); 
			frame.setLocation(700, 0); //puts frame in middle
			frame.setSize(1000, 200);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			
			Iterator<JButton> buttIt = buttonz.iterator();
			JButton tempButt;
			
			while(buttIt.hasNext())
			{
				tempButt = buttIt.next();
				panel.add(tempButt);
				tempButt.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						//view car on new jFrame
						JFrame carFrame = new JFrame();
						carFrame.setSize(300, 750);
						carFrame.setVisible(true);
						
						JPanel spec_panel = new JPanel();
						
						JLabel car_deets = new JLabel("testing123\n");
						JLabel car2 = new JLabel("test again\n");
						/*
						car_deets.setAlignmentX(0);
						car_deets.setAlignmentY(0);
						car2.setAlignmentX(100);
						car2.setAlignmentY(100);
						*/
						
						spec_panel.add(car_deets);
						spec_panel.add(car2);
						carFrame.add(spec_panel);
						

					}
				});
			}
			
			
			frame.add(panel, BorderLayout.NORTH);
				   
			
			//Display the window.
	   
		
		    

	}
	
	
	
		public static ArrayList<JButton> buttonify(ArrayList<Car> myCars)
		{
			ArrayList<JButton> cars = new ArrayList<JButton>();
			
			Iterator<Car> carIt = myCars.iterator();
			JButton tempButt;
			Car tempCar;
			while(carIt.hasNext())
			{
				tempCar = carIt.next();
				tempButt = new JButton(tempCar.year + " " + tempCar.make + " " + tempCar.model);
				cars.add(tempButt);
			}
			
			return cars;
		}
	

		public static void printAllCars(ArrayList<Car> myCars)
		{
			JFrame frame = new JFrame("All cars"); 

			Iterator<Car> carIt = myCars.iterator();
			Car tempCar;
			String masterString = "<html>";
			while(carIt.hasNext())
			{
				tempCar = carIt.next();
				masterString += (tempCar.year + " " + tempCar.make + " " + tempCar.model);
				masterString += "<br>";
			}
			masterString += "</html>";
			  
		JLabel textLabel = new JLabel(masterString ,SwingConstants.CENTER);
		textLabel.setFont (textLabel.getFont().deriveFont (30.0f)); //font size
	      textLabel.setPreferredSize(new Dimension(700, 500)); //size of window
	      
			JScrollPane pane = new JScrollPane(textLabel); //scroll bar
			frame.getContentPane().add(pane); // add the scroll bar
			
	   
	      
			
			//Display the window.
	      frame.setLocation(700, 250); //puts frame in middle
	      frame.pack(); //works with get content pane and window size
	      frame.setVisible(true);
		
		    
		  
		}
		
		public static void inputCar(ArrayList<Car> carList)
		{
			JFrame frame = new JFrame("Enter new car");
			JTextField text = new JTextField(25);
			JButton enterInput = new JButton("Enter");
			frame.getContentPane().add(text, BorderLayout.WEST);
			
			enterInput.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent arg0) {
					String car = text.getText();
					String carSplit[] = car.split(" ");
					Car tempCar = new Car(Integer.parseInt(carSplit[0]), carSplit[1], carSplit[2], carSplit[3], carSplit[4], carSplit[5], carSplit[6], carSplit[7], carSplit[8], carSplit[9]);
					carList.add(tempCar);
					frame.dispose();
					
				}
			});
			frame.add(enterInput);
			frame.setSize(500, 100); //size of window
		      frame.setLocation(700, 250); //puts frame in middle
	
		      frame.setVisible(true);
		}
		
		
		public static void exitDatabase(ArrayList<Car> a, JFrame jframe)
		{
			Iterator<Car> iterator = a.iterator();
			FileOutputStream outfile = null;
			try
			{
				outfile = new FileOutputStream("cars.txt");
			}
			catch (FileNotFoundException e)
			{
				System.err.println(e);
				return;
			}
			PrintWriter writer = new PrintWriter(outfile, true);
			Car temp;
			String yearMakeModel;
			
			while (iterator.hasNext())
			{
				temp = iterator.next();
				yearMakeModel = Integer.toString(temp.getYear()) + " " + temp.getMake() + " " + temp.getModel();
				writer.println(yearMakeModel);
			}
			writer.close();
			jframe.dispose();
		}
}


//does not terminate if you view cars then try to add then click exit.
