import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class database {
	public static void main(String args[])
	{
//to do : 
	// arrange car buttons in view all cars (add sort by year and make drop down)
		//fix formatting and make prettier. (put space between buttons and jframe)
		//add more cars
		
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
		
	    try {
            // Set System L&F
        UIManager.setLookAndFeel(
            UIManager.getSystemLookAndFeelClassName());
	    } 
	    catch (UnsupportedLookAndFeelException e) {
	       // handle exception
	    }
	    catch (ClassNotFoundException e) {
	       // handle exception
	    }
	    catch (InstantiationException e) {
	       // handle exception
	    }
	    catch (IllegalAccessException e) {
	       // handle exception
	    }

    
    
		JFrame frame = new JFrame("Car Database");  //arg is what the program window says
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //click x to end program
		//frame.setLayout(new BoxLayout(frame, BoxLayout.PAGE_AXIS));
		frame.setSize(415, 290); //size of window
		frame.setLocationRelativeTo(null); 
		frame.addWindowListener(new WindowAdapter(){

		    public void windowClosing(WindowEvent e){
		        exitDatabase(myCars, frame);
		    }

		});
		
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(3,1,10,10));
		mainPanel.setSize(415, 290); //size of window
		mainPanel.setVisible(true); //set to true
		frame.add(mainPanel);
		
		JButton button = new JButton("View cars"); //make a button named "arg"
		button.setBounds(25, 25, 350, 50); // x,y coords, x size y size
		button.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		mainPanel.add(button); //add button to frame
		button.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			//printAllCars(myCars); //change
			//ArrayList<JButton> carButts = buttonify(myCars); //arraylist of jbuttons with car names
			//need to add action listeners to jbuttons
			addButtons(myCars);
			}
		});
		

		
		JButton button2 = new JButton("Add a new car");
		button2.setBounds(25, 100, 350, 50);
		button2.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		mainPanel.add(button2);
		
		
		button2.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			inputCar(myCars);
			}
		});
		
		
		JButton button3 = new JButton("Exit");
		button3.setBounds(25, 175, 350, 50);
		button3.setFont(new Font("TimesRoman", Font.PLAIN, 40));
		mainPanel.add(button3);
		
		
		button3.addActionListener(new ActionListener() 
		{
		public void actionPerformed(ActionEvent arg0) {
			exitDatabase(myCars, frame); 
			frame.dispose();
			System.exit(0);
			}
		});	
		frame.setVisible(true); //set to true
		//CLOSING THE PROGRAM***
		input.close();

		
	}
	
	public static void addButtons(ArrayList<Car> myCars)
	{
		
			final ArrayList<Car> final_cars = myCars;
			
		
			JFrame frame = new JFrame("All cars");  
			frame.setLocation(700, 400); //puts frame in middle
			frame.setSize(500, 200);
			frame.setVisible(true);
			
			JPanel panel = new JPanel();
			panel.setLayout(new GridLayout(3,3,10,10));
			
			Iterator<Car> buttIt = final_cars.iterator();
			Car tempCar;
			
			int year = Calendar.getInstance().get(Calendar.YEAR);
			
			while(buttIt.hasNext())
			{
				tempCar = buttIt.next();
				JButton tempButt = new JButton(tempCar.year + " " + tempCar.make + " " + tempCar.model);
				
				panel.add(tempButt);
				final Car[] tester_final = new Car[1];
				tester_final[0] = tempCar; //  https://stackoverflow.com/questions/4732544/why-are-only-final-variables-accessible-in-anonymous-class
				tempButt.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent arg0)
					{
						
						//view car on new jFrame

						JFrame carFrame = new JFrame(tester_final[0].getYear() + " " + tester_final[0].getMake() + " " + tester_final[0].getModel());
						carFrame.setSize(400, 300);
						carFrame.setVisible(true);
						carFrame.setLocation(200, 100);
						
						JPanel spec_panel = new JPanel();
						spec_panel.setLayout(new BoxLayout(spec_panel, BoxLayout.PAGE_AXIS));
						
						JLabel year_make_model = new JLabel(tester_final[0].getYear() + " " + tester_final[0].getMake() + " " + tester_final[0].getModel());
						JLabel age = new JLabel("Age: " + (year-tester_final[0].getYear()) + " year(s)");
						JLabel mpgLabel = new JLabel("MPG: " + tester_final[0].getMPG());
						JLabel hpLabel = new JLabel("Horsepower: " + tester_final[0].getHP());
						JLabel weightLabel = new JLabel("Curb weight: " + tester_final[0].getWeight());
						JLabel transLabel = new JLabel("Transmission: " + tester_final[0].getTrans());
						JLabel engineLabel = new JLabel("Engine: " + tester_final[0].getEngine());
						JLabel bodyLabel = new JLabel("Body style: " + tester_final[0].getBodyStyle());
						JLabel sizeLabel = new JLabel("Size/class: " + tester_final[0].getSize());
						
	
						year_make_model.setFont(new Font("", Font.PLAIN, 30));
						age.setFont(new Font("", Font.PLAIN, 20));
						bodyLabel.setFont(new Font("", Font.PLAIN, 20));
						sizeLabel.setFont(new Font("", Font.PLAIN, 20));
						mpgLabel.setFont(new Font("", Font.PLAIN, 20));
						hpLabel.setFont(new Font("", Font.PLAIN, 20));
						engineLabel.setFont(new Font("", Font.PLAIN, 20));
						transLabel.setFont(new Font("", Font.PLAIN, 20));
						weightLabel.setFont(new Font("", Font.PLAIN, 20));
						spec_panel.add(year_make_model);
						spec_panel.add(age);
						spec_panel.add(bodyLabel);
						spec_panel.add(sizeLabel);
						spec_panel.add(mpgLabel);
						spec_panel.add(hpLabel);
						spec_panel.add(engineLabel);
						spec_panel.add(transLabel);
						spec_panel.add(weightLabel);
						
						carFrame.add(spec_panel);
						

					}
				});
			}
			
			/*
			String[] sortOptions = {"No sort", "Sort by Year", "Sort by Make"};
			JComboBox sorting = new JComboBox(sortOptions);
			sorting.addActionListener(new ActionListener()
			{ public void actionPerformed(ActionEvent arg0)
				{
						
				}
			
			});
			panel.add(sorting);
			
			*/
			frame.add(panel, BorderLayout.NORTH);
				   
			
			//Display the window.
	   
		
		    

	}
	
	
	/*
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
	
*/
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
			JPanel panel = new JPanel();
			panel.setLayout(new SpringLayout());
			panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
			panel.setSize(500, 380);
			
			JLabel ymm = new JLabel("Year Make Model (e.g. 2018 Honda Civic): ");
			JTextField text = new JTextField(10);
			panel.add(ymm);
			panel.add(text);
			
			JLabel bodyStyle = new JLabel("Body Style (e.g. Sedan/Coupe): ");
			JTextField text7 = new JTextField(10);
			panel.add(bodyStyle);
			panel.add(text7);
			
			JLabel size = new JLabel("Size (e.g. Fullsize): ");
			JTextField text8 = new JTextField(10);
			panel.add(size);
			panel.add(text8);
			
			JLabel mpg = new JLabel("MPG (e.g. 30city/40hwy): ");
			JTextField text2 = new JTextField(10);
			panel.add(mpg);
			panel.add(text2);
			
			JLabel hp = new JLabel("HP (e.g. 400hp-555hp): ");
			JTextField text3 = new JTextField(10);
			panel.add(hp);
			panel.add(text3);
			
			JLabel engine = new JLabel("Engine (e.g. I4(1.8L-T)/V8(5.2L)): ");
			JTextField text6 = new JTextField(10);
			panel.add(engine);
			panel.add(text6);
			
			JLabel trans = new JLabel("Transmission (e.g. Automatic(3spd)/Manual(6spd)): ");
			JTextField text5 = new JTextField(10);
			panel.add(trans);
			panel.add(text5);
			
			JLabel weight = new JLabel("Weight (e.g. 2,500lbs-2,700lbs): ");
			JTextField text4 = new JTextField(10);
			panel.add(weight);
			panel.add(text4);

			JButton enterInput = new JButton("Enter");
		  
			
			enterInput.addActionListener(new ActionListener() {
				@Override public void actionPerformed(ActionEvent arg0) {
					String car = text.getText();
					String carSplit[] = car.split(" ");
					Car tempCar = new Car(Integer.parseInt(carSplit[0]), carSplit[1], carSplit[2], text2.getText(), text3.getText(), text4.getText(), text5.getText(), text6.getText(), text7.getText(), text8.getText());
					carList.add(tempCar);
					frame.dispose();
					
				}
			});
			panel.add(enterInput);
			frame.add(panel);
			frame.setSize(500, 380); //size of window
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
				writer.println(yearMakeModel + " " + temp.getMPG() + " " + temp.getHP() + " " + temp.getWeight() + " " + temp.getTrans() + " " + temp.getEngine() + " " + temp.getBodyStyle() + " " + temp.getSize());
			}
			writer.close();
			jframe.dispose();
		}
}
