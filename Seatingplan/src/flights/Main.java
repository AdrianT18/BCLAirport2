package flights;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.EventListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class Main extends JFrame {
	
	boolean hasErrors = false;
	
	public ArrayList<String> departureSeatsB747 = new ArrayList<String>();
	public ArrayList<String> departureSeatsA318 = new ArrayList<String>();
	public ArrayList<String> returnSeatsB747 = new ArrayList<String>();
	public ArrayList<String> returnSeatsA318 = new ArrayList<String>();
	
	
	
	//buttons for seat diagram
	ArrayList<JButton> A318buttons = new ArrayList<JButton>();
	
	
	
	
	
	
	//assuming I'm not inheriting these
	public int flightDuration;
	public static int ticketNum;
	
	public boolean isBoeing;
	public static boolean isReturning;
	public boolean canpass;
	
	
	//Layout objects
	JButton seatButton;
	JLabel successLabel;
	
	
	
	public String flightPlane;
	public String seatId;
	public String seatColour;
	public String displayLabel;

	private JPanel contentPane;
	private JTextField textField;

	 


	
	
public void selectTickets() {
		for(int i = 0; i < 10; i++) {
			
		}
	}




public void addAirbusSeats(ArrayList<String> as) {
	if(!isBoeing) {
		A318View sf = new A318View();
		sf.setVisible(true);
		sf.setSize(1600, 900);
		FlowLayout layout = new FlowLayout(10,10,10);
	
		contentPane.setLayout(layout);
	}else {
		System.out.println("await boeing 747 implementation");
		B747 tf = new B747();
		tf.setVisible(true);
		tf.setSize(1920, 1080);
		
	}
		
	
			
				}
	

public void showSeatingplan() {
	departureSeatsA318 = new ArrayList<String>();
	if(!isBoeing) {
		//add seats to departure seats for boeing 747
		
		for(String s: departureSeatsA318) { A318buttons.add(new JButton(s));  }
	
		
	}
	
}

public boolean checkInput(String s) {
	boolean checksout = false;
	ArrayList<Character> stuff = new ArrayList<Character>();
	//again convert to arraylist, easy simple for loop
	for(int i = 0; i < s.length(); i++) {stuff.add(s.charAt(i));}
	//iterate through arraylist
	for(int i = 0; i < stuff.size(); i++) {
		
		if(Character.isDigit(stuff.get(i))) {
			checksout = true;
			continue;
			
		}else {
			//System.out.println("String does not contain only digits");
			checksout = false;
			break;
		}
	}
	return checksout;
	//if(checksout) { System.out.println("String was all digits");}
}
	
	
	public boolean setPlane(int flightDuration) {
		if(flightDuration <= 120) {
			isBoeing = false;
			
		}else if(flightDuration > 120) {
			isBoeing = true;
			
		}
		
		return isBoeing;
	}
	
	
	public void displayFlight() {
		if(isReturning) {
			displayLabel = "Return flight " + flightPlane;
		}else {
			displayLabel = "Departure flight " + flightPlane;
		}
	}
	

	

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					Main main = new Main();
					//frame frame2 = new frame();
					main.setVisible(true);
					//frame2.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
					
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		String depDuration = flightArray.filteredDepFlights[3];
		//DecimalFormat formatter = new DecimalFormat(":");
		String[] passer = depDuration.split("\\:");
		int min1 = 60 * Integer.parseInt(passer[0]);
		int depTotal = min1 + Integer.parseInt(passer[1]);
		
		setPlane(depTotal);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 300);
		contentPane = new JPanel();
		contentPane.setSize(400, 300);
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		System.out.println();
		JFrame frame = new JFrame();
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select number of tickets");
		lblNewLabel.setBounds(86, 74, 232, 44);
		lblNewLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Book");
		btnNewButton.setBounds(140, 171, 107, 38);
		btnNewButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(140, 129, 98, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		 successLabel = new JLabel("Successfully booked " + ticketNum + " tickets", SwingConstants.CENTER);
		 seatButton = new JButton("Select seats");
		
		
		
		
		
		
		
		
		
		
		
		btnNewButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//allow the user to choose as many tickets as he/she wants - depending on the plane
				//gonna use 10 as the max, 1 as the minimum, throw option panes if the user makes dumb mistakes
				if(checkInput(textField.getText())) {
					ticketNum = Integer.parseInt(textField.getText());
					if(ticketNum <= 10 && ticketNum > 0) {
						//System.out.println("test");
						//get rid of all the old components
						textField.setVisible(false);
						lblNewLabel.setVisible(false);
						btnNewButton.setVisible(false);
						frame.setVisible(false);
						frame.dispose();
						
						
						//add the info label
						successLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
						successLabel.setBounds(86, 74, 232, 44);
						//use correct value of ticketNum
						successLabel.setText("Successfully booked " + ticketNum + " tickets");
						contentPane.add(successLabel);
						
						
						//add the seats button
						seatButton.setBounds(140, 129, 127, 38);
						seatButton.setFont(new Font("Segoe UI", Font.PLAIN, 18));
						contentPane.add(seatButton);
						
						
						
						
						
						
						
						
					}else {
						JOptionPane.showMessageDialog(contentPane, "You cannot have book more than 10 tickets, and you must have at least 1 ticket");
					}
				}else {
					JOptionPane.showMessageDialog(contentPane, "The number of tickets must be a whole number, it cannot contain alphabetical or decimal values");
				}
				//System.out.println("test");
				
			}
		});
		
		
		
		seatButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//hide all comps, make it bigger so we can fit the seating plan
				seatButton.setVisible(false);
				successLabel.setVisible(false);
				setBounds(100, 100, 0, 0);
				
				showSeatingplan();
				addAirbusSeats(departureSeatsA318);
				
			}
		});
		
		
		
		
	}
}
