package flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.SystemColor;


public class flightGUI extends JFrame {

	private JPanel searchPage;
	private JTextField depCityChooser; //textfields for user inputs
	private JTextField arrCityChooser;
	private JTextField depDateChooser;
	private JTextField arrDateChooser;

	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public flightGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exits the gui when it is closed
		setBounds(100, 100, 1081, 721);
		searchPage = new JPanel();
		searchPage.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(searchPage);
		searchPage.setLayout(null);
		
		JButton searchFlight = new JButton("SEARCH FLIGHT");//creating button and setting name
		searchFlight.setForeground(SystemColor.textHighlight);//setting button colour
		searchFlight.setFont(new Font("The Bold Font", Font.PLAIN, 26));//setting button fonts and size
		searchFlight.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {

				flightArray.depCity = depCityChooser.getText();//fetches user input and saves to variable
				flightArray.arrCity = arrCityChooser.getText();
				flightArray.depDate = depDateChooser.getText();
				flightArray.arrDate = arrDateChooser.getText();
				System.out.println("depdate is"+flightArray.depDate);
				if (flightArray.userInputs()) {
					
					if ((flightArray.searchDepFlights() != null)&&(flightArray.searchArrFlights() !=null)){
						flightArray.filteredDepFlights = flightArray.searchDepFlights();//runs the method for filtering flights
						flightArray.filteredArrFlights = flightArray.searchArrFlights();
					
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									showFlights frame = new showFlights();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
						dispose();
					}
					else {
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									errorMessage frame = new errorMessage();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
					
					
				}
			}
		});
		
		searchFlight.setBounds(421, 569, 239, 88);
		searchPage.add(searchFlight);
		
		JButton btnShop = new JButton("SHOP");
		btnShop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					UIShop frame = new UIShop();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
			}
		});
		btnShop.setForeground(SystemColor.textHighlight);
		btnShop.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnShop.setBounds(200, 180, 215, 57);
		searchPage.add(btnShop);
		
		JButton btnRestaurant = new JButton("RESTAURANT");
		btnRestaurant.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Restaurant frame = new Restaurant();
					frame.setVisible(true);
				} 
				catch (Exception RRe) {
					RRe.printStackTrace();
				}
			}
		});
		btnRestaurant.setForeground(SystemColor.textHighlight);
		btnRestaurant.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnRestaurant.setBounds(450, 180, 215, 57);
		searchPage.add(btnRestaurant);
		
		JButton btnFinances = new JButton("FINANCES");
		btnFinances.setForeground(SystemColor.textHighlight);
		btnFinances.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnFinances.setBounds(700, 180, 215, 57);
		searchPage.add(btnFinances);
		
		JLabel headLine = new JLabel("BRUNEL CITY AIRPORT");
		headLine.setForeground(SystemColor.textHighlight);
		headLine.setFont(new Font("Elephant", Font.PLAIN, 60));
		headLine.setBounds(121, -41, 899, 218);
		searchPage.add(headLine);
		
		JButton btnOneWay = new JButton("ONE WAY");
		btnOneWay.setBackground(SystemColor.textHighlight);
		btnOneWay.setForeground(SystemColor.window);
		btnOneWay.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnOneWay.setBounds(289, 180, 215, 57);
		//searchPage.add(btnOneWay);
		
		JButton btnRoundTrip = new JButton("ROUND TRIP");
		btnRoundTrip.setBackground(SystemColor.textHighlight);
		btnRoundTrip.setForeground(Color.WHITE);
		btnRoundTrip.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnRoundTrip.setBounds(576, 180, 215, 57);
		//searchPage.add(btnRoundTrip);
		
		JLabel lblNewLabel = new JLabel("FROM:");
		lblNewLabel.setIcon(new ImageIcon("Seatingplan/src/flights/planeup.png"));
		lblNewLabel.setForeground(SystemColor.desktop);
		lblNewLabel.setBackground(SystemColor.desktop);
		lblNewLabel.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		lblNewLabel.setBounds(24, 293, 177, 88);
		searchPage.add(lblNewLabel);
		
		depCityChooser = new JTextField();
		depCityChooser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnFinances.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					finances frame = new finances();
					frame.setVisible(true);
					frame.setTitle("Finances");
				} catch (Exception re) {
					re.printStackTrace();
				}
				
			}
		});
		
		depCityChooser.setForeground(Color.WHITE);
		depCityChooser.setFont(new Font("The Bold Font", Font.PLAIN, 16));
		depCityChooser.setColumns(10);
		depCityChooser.setBackground(SystemColor.textHighlight);
		depCityChooser.setBounds(184, 310, 320, 57);
		searchPage.add(depCityChooser);
		
		JLabel lblTo = new JLabel("TO:");
		lblTo.setIcon(new ImageIcon("Seatingplan/src/flights/planedown.png"));
		lblTo.setForeground(SystemColor.desktop);
		lblTo.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		lblTo.setBackground(SystemColor.textHighlight);
		lblTo.setBounds(514, 293, 140, 88);
		searchPage.add(lblTo);
		
		arrCityChooser = new JTextField();
		arrCityChooser.setForeground(Color.WHITE);
		arrCityChooser.setFont(new Font("The Bold Font", Font.PLAIN, 16));
		arrCityChooser.setColumns(10);
		arrCityChooser.setBackground(SystemColor.textHighlight);
		arrCityChooser.setBounds(656, 310, 320, 57);
		searchPage.add(arrCityChooser);
		
		JLabel lblNewLabel_1 = new JLabel("DEPARTURE \r\nDATE: (DD/MM/YYYY)");
		lblNewLabel_1.setForeground(SystemColor.desktop);
		lblNewLabel_1.setFont(new Font("The Bold Font", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(184, 424, 340, 45);
		searchPage.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("RETURN\r DATE: (DD/MM/YYYY)");
		lblNewLabel_1_1.setForeground(SystemColor.desktop);
		lblNewLabel_1_1.setFont(new Font("The Bold Font", Font.PLAIN, 22));
		lblNewLabel_1_1.setBounds(576, 417, 320, 58);
		searchPage.add(lblNewLabel_1_1);
		
		depDateChooser = new JTextField();
		depDateChooser.setForeground(Color.WHITE);
		depDateChooser.setFont(new Font("The Bold Font", Font.PLAIN, 16));
		depDateChooser.setColumns(10);
		depDateChooser.setBackground(SystemColor.textHighlight);
		depDateChooser.setBounds(184, 461, 320, 57);
		searchPage.add(depDateChooser);
		
		arrDateChooser = new JTextField();
		arrDateChooser.setForeground(Color.WHITE);
		arrDateChooser.setFont(new Font("The Bold Font", Font.PLAIN, 16));
		arrDateChooser.setColumns(10);
		arrDateChooser.setBackground(SystemColor.textHighlight);
		arrDateChooser.setBounds(576, 461, 320, 57);
		searchPage.add(arrDateChooser);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("Seatingplan/src/flights/bkground.png"));
		lblNewLabel_2.setBounds(283, 0, 487, 684);
		searchPage.add(lblNewLabel_2);
		
		JButton btnClass = new JButton("CLASS");
		btnClass.setForeground(Color.WHITE);
		btnClass.setFont(new Font("The Bold Font", Font.PLAIN, 26));
		btnClass.setBackground(SystemColor.textHighlight);
		btnClass.setBounds(761, 581, 215, 57);
		//searchPage.add(btnClass);
		
		JButton btnTravellers = new JButton("DEPARTURE FLIGHTS MAP");
		btnTravellers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					BclFlightDep frame = new BclFlightDep();
					frame.setVisible(true);
				} catch (Exception e6) {
					e6.printStackTrace();
				}
			}
		});
		btnTravellers.setForeground(Color.WHITE);
		btnTravellers.setFont(new Font("The Bold Font", Font.PLAIN, 16));
		btnTravellers.setBackground(SystemColor.textHighlight);
		btnTravellers.setBounds(121, 581, 230, 70);
		searchPage.add(btnTravellers);
	}
}
