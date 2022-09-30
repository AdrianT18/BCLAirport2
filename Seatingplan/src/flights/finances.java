package flights;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.TreeUI;
import javax.swing.JTable;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

//import sun.jvm.hotspot.debugger.win32.coff.TestDebugInfo;

import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.io.File;
import java.net.http.HttpResponse.BodyHandler;
import java.security.InvalidKeyException;
import java.util.Optional;
import java.util.Random;
import java.awt.Color;

public class finances extends JFrame {
	
	
	Random random = new Random(); //instance of random class
	
	//Three variables for totalCostOfBagsSelected for each passenger
	double totalCostOfBagsSelected;
	double totalCostOfBagsSelectedTwo;
	double totalCostOfBagsSelectedThree;
	
	
	double totalCostOfTickets; //One variable for totalCostOfTickets as all passengers are taking the same flight
	
	double costOfCompensation; //One variable for costOfCompensation as all passengers are taking the same flight
	
	//Three different variables for totalCostOfFood where the cost is randomly generated from 0 to 200 for each passenger
	double totalCostOfFood = 45.0;
	double totalCostOfFoodTwo = 40.0;
	double totalCostOfFoodThree = random.nextInt(200);
	
	//Three different variables for totalCostOfProducts where the cost is randomly generated from 0 to 200 for each passenger
	double totalCostOfProducts = 104.97;
	double totalCostOfProductsTwo = 89.94;
	double totalCostOfProductsThree = random.nextInt(200);
	
	//Three variables for totalCostOverall for each passenger as costs will vary
	double totalCostOverall;
	double totalCostOverallTwo;
	double totalCostOverallThree;

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finances frame = new finances();
					frame.setVisible(true);
					frame.setTitle("Finances");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public finances() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 64, 1010, 110);
		contentPane.add(scrollPane);
		
	
		table = new JTable();
		table.setFont(new Font("Verdana", Font.PLAIN, 10));
		table.setBackground(UIManager.getColor("Button.background"));
		table.setEnabled(false);
		//table.setSize(800, 600);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Aaron", "Samuels", "19/03/1995", "83746578", totalCostOfBagsSelected, totalCostOfTickets, totalCostOfFood, totalCostOfProducts, costOfCompensation, totalCostOverall},
				{"Regina", "George", "12/08/1968", "27475839", totalCostOfBagsSelectedTwo, totalCostOfTickets, totalCostOfFoodTwo, totalCostOfProductsTwo, costOfCompensation, totalCostOverallTwo},
			},
			new String[] {
				"First Name", "Surname", "Date Of Birth", "Ticket Number", "Bag Costs", "Ticket Costs", "Food Costs", "Product Costs", "Compensation", "Total"
			}
		));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0;i<table.getColumnCount();i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(100); //setting the column width for the table
		}
		
		table.getColumnModel().getColumn(3).setMaxWidth(500);
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("Finances");
		lblNewLabel.setForeground(new Color(0, 0, 139));
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 50));
		lblNewLabel.setBounds(10, 10, 236, 51);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Seatingplan/src/flights/bkground2.png"));
		
		lblNewLabel_1.setBounds(283, 0, 487, 684);
		contentPane.add(lblNewLabel_1);
		
		//JOptionPane.showMessageDialog(null, "No Information Available");
	}
	
	
	{
		//totalCostOfBagsSelected Passenger 1
		int numOfBags = 2; //The numOfBags is randomly generated from 0 to 20
		
		//This if statement will print the total cost of bags if there is 1 or less bags
		if (numOfBags <= 1) {
			totalCostOfBagsSelected = 0;
		}
		
		//This else if statement will print the total cost of bags if there is more than 1 bag
		else if (numOfBags > 1) {
			totalCostOfBagsSelected = (25 * (numOfBags-1));
		}
		
		
		
		//totalCostOfBagsSelected Passenger 2
		int numOfBagsTwo = 2;
				
		if (numOfBagsTwo <= 1) {
			totalCostOfBagsSelectedTwo = 0;
		}
		
		else if (numOfBagsTwo > 1) {
			totalCostOfBagsSelectedTwo = (25 * (numOfBagsTwo-1));
		}
		
		
		
		//totalCostOfBagsSelected Passenger 1
		int numOfBagsThree = getRandom(20);
		
		if (numOfBagsThree <= 1) {
			totalCostOfBagsSelectedThree = 0;
		}
		
		//This else if statement will print the total cost of bags if there is more than 1 bag
		else if (numOfBagsThree > 1) {
			totalCostOfBagsSelectedThree = (25 * (numOfBagsThree-1));
		}
		

		double distanceTravelled = 7458.56 + 8521.09;
		
		//The sum of the values 7021.04 and 11687.85 are assigned to the variable distanceTravelled as provided by the assessment brief
		String flightClass = getFlightClass(); //This calls the randomly chosen flightClass
		
		//This sequence of statements calculate the totalCostOfTickets dependant on the flightClass
		if (flightClass == "Economy") {
			totalCostOfTickets = (0.5 * distanceTravelled);
		}
		
		else if (flightClass == "Business") {
			totalCostOfTickets = (1 * distanceTravelled);
		}
		else if (flightClass == "First-Class") {
			totalCostOfTickets = (1.5 * distanceTravelled);
		}
		
		
		
		
		int flightDelay = 0; //The sum of the values 179 and 10 are assigned to the variable flightDelay as provided by the assessment brief

		//This sequence of statements calculate the costOfCompensation dependant on the flightDelay
		if (flightDelay > 60 && flightDelay <= 120) {
			costOfCompensation = 100;
		}
		
		else if (flightDelay > 120 && flightDelay <= 180) {
			costOfCompensation = 200;
		}
		
		else if (flightDelay > 180) {
			costOfCompensation = 300;
		}
		
		//The totalCostOverall is calculated below for each passenger
		totalCostOverall = (totalCostOfBagsSelected + totalCostOfTickets + totalCostOfFood + totalCostOfProducts) - (costOfCompensation);
		totalCostOverallTwo = (totalCostOfBagsSelectedTwo + totalCostOfTickets + totalCostOfFoodTwo + totalCostOfProductsTwo) - (costOfCompensation);
		totalCostOverallThree = (totalCostOfBagsSelectedThree + totalCostOfTickets + totalCostOfFoodThree + totalCostOfProductsThree) - (costOfCompensation);
	}
	
	//This set of code randomly selects the type of class the passengers are flying using a switch
	public String getFlightClass() {
		Random random = new Random(); //instance of random class
		int r = random.nextInt(3);
		switch (r) {
		case 0:
			return "First-Class";
		case 1: 
			return "Economy";
		case 2:
			return "Business";
		}
		return "";
	}
	
	public int getRandom(int bound) {
		Random randomTwo = new Random();
		return randomTwo.nextInt(bound);
	}
}