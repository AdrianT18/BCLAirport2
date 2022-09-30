package flights;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import com.toedter.calendar.JDateChooser;

public class Passangers2 extends JFrame {

	public JComboBox<Object> departingSeat;
	public ArrayList<String> departing = new ArrayList<String>();
	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField txtFirstName;
	public JTextField txtSurname;
	public JTextField txtTelephoneNum;
	public JTextField txtEmail;
	public JLabel Airport;
	public JLabel PassangerDetails;
	public JLabel lblFirstName;
	public JLabel lblSurname;
	public JLabel lblDOB;
	public JDateChooser dateChooser;
	public JLabel lblTelephone;
	public JLabel lblEmail;
	public JLabel lblBags;
	public JLabel lblDepSeat;
	public JLabel lblReturnSeat;
	public String str;
	public boolean errorCount;
	
	
	B747 b747 = new B747();
	A318View a318View = new A318View();
	

	// Main method
	public Passangers2() {
		sizePanel();
		titlePanel();
		subHeading();
		firstNamePanel();
		surnamePanel();
		dobPanel();
		telephonePanel();
		emailPanel();
		BagPanel();
		departingSeat();
		returnSeat();
		submitPanel();
		backgroundPanel();
	}

	public void sizePanel() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 668, 512);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	}

	public void titlePanel() {
		Airport = new JLabel("Brunel City Airport");
		Airport.setBounds(9, 8, 370, 36);
		Airport.setFont(new Font("Elephant", Font.BOLD, 29));
		Airport.setForeground(new Color(0, 51, 204));
		contentPane.add(Airport);
	}

	public void subHeading() {
		PassangerDetails = new JLabel("Passenger Details");
		PassangerDetails.setBounds(10, 55, 194, 24);
		PassangerDetails.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 19));
		PassangerDetails.setForeground(Color.BLACK);
		contentPane.add(PassangerDetails);
	}

	public void firstNamePanel() {

		lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(9, 105, 150, 24);
		lblFirstName.setForeground(Color.BLACK);
		lblFirstName.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblFirstName);

		txtFirstName = new JTextField();
		txtFirstName.setBounds(245, 111, 150, 20);
		contentPane.add(txtFirstName);
		txtFirstName.setColumns(10);

	}

	public void surnamePanel() {
		lblSurname = new JLabel("Surname");
		lblSurname.setBounds(9, 140, 97, 24);
		lblSurname.setForeground(Color.BLACK);
		lblSurname.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblSurname);

		txtSurname = new JTextField();
		txtSurname.setBounds(245, 146, 150, 20);
		txtSurname.setColumns(10);
		contentPane.add(txtSurname);
	}

	public void dobPanel() {
		lblDOB = new JLabel("Date Of Birth");
		lblDOB.setBounds(9, 175, 142, 24);
		lblDOB.setForeground(Color.BLACK);
		lblDOB.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblDOB);

		dateChooser = new JDateChooser();
		dateChooser.setBounds(245, 177, 150, 20);
		contentPane.add(dateChooser);
	}

	public void telephonePanel() {
		lblTelephone = new JLabel("Telephone Number");
		lblTelephone.setBounds(9, 210, 255, 24);
		lblTelephone.setForeground(Color.BLACK);
		lblTelephone.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblTelephone);

		txtTelephoneNum = new JTextField();
		txtTelephoneNum.setBounds(245, 216, 150, 20);
		txtTelephoneNum.setColumns(10);
		contentPane.add(txtTelephoneNum);
	}

	public void emailPanel() {
		lblEmail = new JLabel("Email Address");
		lblEmail.setBounds(9, 245, 250, 24);
		lblEmail.setForeground(Color.BLACK);
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(245, 251, 150, 20);
		txtEmail.setColumns(10);
		contentPane.add(txtEmail);
	}

	public void BagPanel() {
		lblBags = new JLabel("Number Of Bags");
		lblBags.setBounds(9, 280, 250, 24);
		lblBags.setForeground(Color.BLACK);
		lblBags.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblBags);

		String[] bagsStrings = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
		JComboBox<Object> comboBags = new JComboBox<Object>(bagsStrings);
		comboBags.setBounds(245, 282, 47, 20);
		contentPane.add(comboBags);
		System.out.println(comboBags);
	}


	public void returnSeat() {
		ArrayList<String> returning = new ArrayList<String>();
		/*
		for(String s: b747.returnSeatsB747) {
			returning.add(s);
		}
		for(String s: a318View.returnSeatsA318) {
			returning.add(s);
		}
		*/
		returning.add("2B");
		JComboBox<Object> returningSeat = new JComboBox<Object>(returning.toArray());
		returningSeat.setBounds(245, 355, 47, 22);
		contentPane.add(returningSeat);

		lblReturnSeat = new JLabel("Returning Seat");
		lblReturnSeat.setBounds(9, 350, 164, 24);
		lblReturnSeat.setForeground(Color.BLACK);
		lblReturnSeat.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblReturnSeat);
	}

	public void backgroundPanel() {
		ImageIcon image = new ImageIcon(this.getClass().getResource("Small.png"));
		JLabel lblLogo = new JLabel(image);
		lblLogo.setBounds(0, 0, 652, 473);
		contentPane.add(lblLogo);
	}

	public void submitPanel() {
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(495, 426, 147, 36);
		btnSubmit.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Error 1
				nameCheck();
				// Error 2
				surnameCheck();
				// Error 3
				dobCheck();
				// Error 4
				numberCheck();
				// Error 5
				emailCheck();
				// Random number generator
				generator();
				// Stores First name, Surname and ticket number into an array.
				storeArray();
				// new frame based of ticket numbers
				formForTickets();
				if (errorCount==false) {
				try {
					flightGUI frame = new flightGUI();
					frame.setVisible(true);
				} catch (Exception e4) {
					e4.printStackTrace();
				}
				}
			}
			
		});
	}
	public void departingSeat() {

		lblDepSeat = new JLabel("Departing Seat");
		lblDepSeat.setBounds(9, 315, 163, 24);
		lblDepSeat.setForeground(Color.BLACK);
		lblDepSeat.setFont(new Font("Verdana", Font.BOLD, 19));
		contentPane.add(lblDepSeat);
		departing.add("2A");
		departingSeat = new JComboBox<Object>(departing.toArray());
		departingSeat.setBounds(245, 313, 47, 22);
		contentPane.add(departingSeat);
	}

	// Error 1
	public void nameCheck() {
		// Gets text from JTextfield and checks if first name is empty. If empty an
		// error message shows.
		if (txtFirstName.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure your First Name is entered.");
			errorCount = true;
		}
		// Gets text from JTextfield and checks if first name contains less then 3 characters.
		// If true an error message shows.
		else if (txtFirstName.getText().length() < 3) {
			JOptionPane.showMessageDialog(null, "Please make sure your First Name consists of 3 characters or more.");
			errorCount = true;
		} 
		else {
			// prevents from needing to double click submit button
			errorCount = false;
		}
	}

	// Error 2
	public void surnameCheck() {

		// Checks if surname is empty.
		if (txtSurname.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure your Surname is entered.");
			errorCount = true;
		}
		// Checks if surname contains less then 3 characters.
		else if (txtSurname.getText().length() < 3) {
			JOptionPane.showMessageDialog(null, "Please make sure your Surname consists of 3 characters or more.");
			errorCount = true;
		} else {
			// if no error it will return false allowing to submit the form.
			errorCount = false;
		}
	}

	// Error 3
	public void dobCheck() {

		// Gets date from dateChooser and check whoever its empty or not.
		if (((JTextField) dateChooser.getDateEditor().getUiComponent()).getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Please make sure you have entered your Date Of Birth.");
			errorCount = true;
		} else {
			// if no error it will return false allowing to submit the form.
			errorCount = false;
		}
	}

	// Error 4
	public void numberCheck() {
		// Error message if no telephone number is entered
		if (txtTelephoneNum.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure you have entered a telephone number.");
			errorCount = true;
		}
		// Phone number can't be longer then 12
		else if (txtTelephoneNum.getText().length() > 12) {
			JOptionPane.showMessageDialog(null, "Please make sure your phone number consists of 12 digits only.");
			errorCount = true;
		} else
			// Checks if number is int only.
			try {
				Integer.parseInt(txtTelephoneNum.getText());
			} catch (NumberFormatException ne) {
				JOptionPane.showMessageDialog(null, "Please make sure your telephone number contains digits only.");
				errorCount = true;
			}
	}

	// Validate email
	// Error 5
	public void emailCheck() {
		// Checks if the text field is empty
		if (txtEmail.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "Please make sure your Email address is entered.");
			errorCount = true;
		} else {
			// checks if the email address is missing the '@' symbol.
			// Has to be formatted in "String '@' String '.' String
			String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
			String email = txtEmail.getText();
			Pattern pattern = Pattern.compile(emailRegex);
			if (pattern.matcher(email).matches()) {
				// returns nothing
			} else {
				JOptionPane.showMessageDialog(null, "Please make sure your Email is in the correct email address format. username@domain ");
				errorCount = true;
			}
		}
	}

	// Random ticket generator.
	public void generator() {
		if (!errorCount) {
			// random number generated to make 8 digits.
			int min = 10000000;
			int max = 90000000;
			// generates min and max number inclusively.
			int random = (int) Math.floor(Math.random() * (max - min + 1) + min);
			str = String.valueOf(random);
			JOptionPane.showMessageDialog(null, "Thank you for your purchase. Your ticket number is: " + random);
		}
	}

	// making a new Jform for amount of passengers.
	public void formForTickets() {
		
		if (!errorCount) {
			
			if (B747.numberOfTickets > 1) {
				
				System.out.println("Number of tickets is "  + B747.numberOfTickets);
				B747.numberOfTickets--;
				new Passangers2().setVisible(true);
				
			}else {
				new Passangers2().setVisible(false);
			}
		}
	}
	
	// Stores first name, surname and a random ticket number
	public void storeArray() {
		if (!errorCount) {
			ArrayList<String> store = new ArrayList<String>();
			String firstName = txtFirstName.getText();
			String lastName = txtSurname.getText();
			String generator = str;
			store.add(firstName);
			store.add(lastName);
			store.add(generator);
		}
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Passangers2 frame = new Passangers2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
