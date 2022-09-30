package flights;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class B747 extends A318View {

	public boolean boeingSeatsarebooked = false;
	boolean isReturning = false;
	static int oriticketNo;
	private JPanel contentPane;
	public boolean BseatsAreBooked = false;
	public JLabel bLabel;
	public JLabel status;
	public JFrame example;
	public int sideticketNum;
	int ticketNom;
	JButton bookButton;
	public static ArrayList<String> departureSeatsB747 = new ArrayList<String>();
	public static ArrayList<String> returnSeatsB747 = new ArrayList<String>();
	public ArrayList<JButton> boeingButtons;
	static int numberOfTickets;

	
	
	
	//override attempt #2
	public void updateSeats(ArrayList<String> s, JLabel label) {
	
		for(int i = 0; i < s.size(); i++) {
			//System.out.println(s.get(i));
			char[] exChar = new char[100];
			if(contains(s.get(i).toCharArray(), 'o')) {
				//System.out.println("found forbidden characters, ignored");
				BseatsAreBooked = true;
			}else {
				exChar = s.get(i).toCharArray();
				for(int j = 0; j < exChar.length; j++ ) {
					//System.out.println(exChar[j]);
					
					defText += exChar[j];
					
					
				}
					
					defText += ", ";
					summaryString += defText;
			}
			
			//seats.add(defText);
			//for(String se: seats) { System.out.println(se);        }
			//defText += s.get(i);
			
		}
		//System.out.println(defText);
		label.setVisible(false);
		defText += " ";
		label.setText("User has booked seats: " + defText + "     ");
		defText = "";
		label.setVisible(true);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//override attempt #1
	public void searchfor(String s, ArrayList<JButton> buttons, ArrayList<String> al, JFrame f, JLabel l, int ticketNo) {
		
		JButton buttonToChangeColourOf = null;
		for(int i = 0; i < buttons.size(); i++) {
			
			//System.out.println(buttons.get(i));
			if(buttons.get(i).getBackground() != Color.RED && buttons.get(i).getText() == s) {
				buttonToChangeColourOf = buttons.get(i);
				break;
			}else {
				//System.out.println("in the else");
				
			}
			
		}
		al.add(s);
		try {
			buttonToChangeColourOf.setBackground(Color.RED);
			formerlyBookedSeats.add(buttonToChangeColourOf.getX() + buttonToChangeColourOf.getY());
			fbs.add(buttonToChangeColourOf.getText());
			buttonToChangeColourOf.setText("Booked");
		}catch(NullPointerException npe) {
			BseatsAreBooked = true;
			JOptionPane.showMessageDialog(f, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			//JOptionPane.showMessageDialog(f, "That seat is already taken! Please choose another seat");
			//System.out.println("sideticketnum is " + ticketNo + " before being ostensibly incremented");
			if(isReturning) {
				oriticketNo++;
				l.setVisible(false);
				l.setText("Select " + ticketNom + " Seats");
				l.setVisible(true);
			}else {
				ticketNom++;
				//System.out.println("in the else");
				l.setVisible(false);
				l.setText("Select " + ticketNom + " Seats");
				l.setVisible(true);
			}
			
		}
		
	}
	
	
	
	
	
	public void Rsearchfor(String s, ArrayList<JButton> buttons, ArrayList<String> al, JFrame f, JLabel l, int ticketNo) {
		JButton buttonToChangeColourOf = null;
		for(int i = 0; i < buttons.size(); i++) {
			//System.out.println(buttons.get(i));
			if(buttons.get(i).getBackground() != Color.RED && buttons.get(i).getText() == s) {
				buttonToChangeColourOf = buttons.get(i);
				al.add(s);
				//System.out.println(al);
				break;
			}else {
				
			}
			
		}
		
		try {
			buttonToChangeColourOf.setBackground(Color.RED);
			formerlyBookedSeats.add(buttonToChangeColourOf.getX() + buttonToChangeColourOf.getY());
			fbs.add(buttonToChangeColourOf.getText());
			
			buttonToChangeColourOf.setText("Booked");
			//buttonToChangeColourOf.setFont(new Font("Comic Sans", Font.PLAIN, 18));
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(f, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			//System.out.println("sideticketnum is " + ticketNo + " before being ostensibly incremented");
		
			oriticketNo++;
			l.setVisible(false);
			l.setText("Select " + oriticketNo + " Seats");
			l.setVisible(true);
		}
		
	}
	

	
	ActionListener finishListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//updateSeats(returnSeatsB747, bLabel);
			if(!BseatsAreBooked && oriticketNo <= 0) {
				//System.out.println("condition not satisfied");
				JOptionPane.showMessageDialog(example, returnSeatsB747.size() + " seats booked for return flight on the Boeing 747");
			}else if(BseatsAreBooked && oriticketNo <= 0) {
				//System.out.println("value decremented");
				JOptionPane.showMessageDialog(example, departureSeatsB747.size() - 1 + " seats booked for return flight on the Boeing 747" );
				status.setVisible(false);
				 originalTicketNum--;
				 status.setText("Select " + --sideticketNum + " Seats");
				 status.setVisible(true);
			}else {
				JOptionPane.showMessageDialog(example, "Please book your remaining " + oriticketNo + " seats","You didn't book all your seats!", JOptionPane.ERROR_MESSAGE);
			}
			
			if(oriticketNo <= 0) {
				JOptionPane.showMessageDialog(example, "All seats booked successfully");
				System.out.println(departureSeatsB747);
				//JOptionPane.showMessageDialog(example, "Summary: " + summaryString);
				setBounds(100, 100, 1, 1);
				getContentPane().setVisible(false);
				try {
					Passangers frame = new Passangers();
					frame.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
			
		}
	};
	
	/**
	 * Launch the application.
	 */
	
	
	ActionListener aL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			//System.out.println("get action command is " + e.getActionCommand());
			//System.out.println("when the button is clicked, sideticketno is " + ticketNom);
			//System.out.println("test");
			if(ticketNom > 0 && checkSeatAvailbility(e.getActionCommand(), departureSeatsB747)) {
				//System.out.println("condition is being satisfied on line 72");
				status.setVisible(false);
				 ticketNom--;
				 status.setText("Select " + ticketNom + " Seats");
				 status.setVisible(true);
				 //System.out.println(e.getActionCommand());
				 searchfor(e.getActionCommand(), boeingButtons, departureSeatsB747, example, status, ticketNom);
				 updateSeats(departureSeatsB747, bLabel);
			}
			
			
		
		
		else if(!checkSeatAvailbility(e.getActionCommand() , departureSeatsB747)) {
			JOptionPane.showMessageDialog(example, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);

}
		else if(ticketNom <= 0) {
			JOptionPane.showMessageDialog(contentPane, "No tickets left", "You have no tickets left to book seats!", JOptionPane.ERROR_MESSAGE);
		}
	}

	};

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					B747 frame = new B747();
					//frame.add(button);
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public B747() {
		super(8);
		
		
		//System.out.println("ticketno is now " + ticketNom);
		
		oriticketNo = Main.ticketNum;
		
		contentPane = new JPanel();
		//System.out.println("test");
		contentPane.setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1601, 800);
		//getContentPane() = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton b1A = new JButton("1A");
		b1A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b1A.setBounds(45, 158, 104, 23);
		contentPane.add(b1A);
		
		JButton b2A = new JButton("2A");
		b2A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b2A.setBounds(45, 192, 104, 23);
		contentPane.add(b2A);
		
		JButton b3A = new JButton("3A");
		b3A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b3A.setBounds(45, 226, 104, 23);
		contentPane.add(b3A);
		
		JButton b4A = new JButton("4A");
		b4A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b4A.setBounds(45, 260, 104, 23);
		contentPane.add(b4A);
		
		JButton b5A = new JButton("5A");
		b5A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b5A.setBounds(45, 294, 104, 23);
		contentPane.add(b5A);
		
		JButton b1B = new JButton("1B");
		b1B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b1B.setBounds(230, 158, 104, 23);
		contentPane.add(b1B);
		
		JButton b2B = new JButton("2B");
		b2B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b2B.setBounds(230, 192, 104, 23);
		contentPane.add(b2B);
		
		JButton b3B = new JButton("3B");
		b3B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b3B.setBounds(230, 226, 104, 23);
		contentPane.add(b3B);
		
		JButton b4B = new JButton("4B");
		b4B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b4B.setBounds(230, 260, 104, 23);
		contentPane.add(b4B);
		
		JButton b5B = new JButton("5B");
		b5B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b5B.setBounds(230, 294, 104, 23);
		contentPane.add(b5B);
		
		JButton b11A = new JButton("11A");
		b11A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11A.setBounds(703, 158, 104, 23);
		contentPane.add(b11A);
		
		JButton b11B = new JButton("11B");
		b11B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11B.setBounds(817, 158, 104, 23);
		contentPane.add(b11B);
		
		JButton b11C = new JButton("11C");
		b11C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b11C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11C.setBounds(931, 158, 104, 23);
		contentPane.add(b11C);
		
		JButton b12A = new JButton("12A");
		b12A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12A.setBounds(703, 196, 104, 23);
		contentPane.add(b12A);
		
		JButton b12B = new JButton("12B");
		b12B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12B.setBounds(817, 196, 104, 23);
		contentPane.add(b12B);
		
		JButton b12C = new JButton("12C");
		b12C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12C.setBounds(931, 196, 104, 23);
		contentPane.add(b12C);
		
		JButton b13A = new JButton("13A");
		b13A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13A.setBounds(703, 230, 104, 23);
		contentPane.add(b13A);
		
		JButton b13B = new JButton("13B");
		b13B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13B.setBounds(817, 230, 104, 23);
		contentPane.add(b13B);
		
		JButton b13C = new JButton("13C");
		b13C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13C.setBounds(931, 230, 104, 23);
		contentPane.add(b13C);
		
		JButton b14A = new JButton("14A");
		b14A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14A.setBounds(703, 264, 104, 23);
		contentPane.add(b14A);
		
		JButton b14B = new JButton("14B");
		b14B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14B.setBounds(817, 264, 104, 23);
		contentPane.add(b14B);
		
		JButton b14C = new JButton("14C");
		b14C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14C.setBounds(931, 264, 104, 23);
		contentPane.add(b14C);
		
		JButton b16A = new JButton("16A");
		b16A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16A.setBounds(703, 339, 104, 23);
		contentPane.add(b16A);
		
		JButton b16B = new JButton("16B");
		b16B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16B.setBounds(817, 339, 104, 23);
		contentPane.add(b16B);
		
		JButton b16C = new JButton("16C");
		b16C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16C.setBounds(931, 339, 104, 23);
		contentPane.add(b16C);
		
		JButton b17A = new JButton("17A");
		b17A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17A.setBounds(703, 373, 104, 23);
		contentPane.add(b17A);
		
		JButton b17B = new JButton("17B");
		b17B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17B.setBounds(817, 373, 104, 23);
		contentPane.add(b17B);
		
		JButton b17C = new JButton("17C");
		b17C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17C.setBounds(931, 373, 104, 23);
		contentPane.add(b17C);
		
		JButton b18A = new JButton("18A");
		b18A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18A.setBounds(703, 407, 104, 23);
		contentPane.add(b18A);
		
		
		JButton b18B = new JButton("18B");
		b18B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18B.setBounds(817, 407, 104, 23);
		contentPane.add(b18B);
		
		JButton b18C = new JButton("18C");
		b18C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18C.setBounds(931, 407, 104, 23);
		contentPane.add(b18C);
		
		JButton b19A = new JButton("19A");
		b19A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19A.setBounds(703, 441, 104, 23);
		contentPane.add(b19A);
		
		JButton b19B = new JButton("19B");
		b19B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19B.setBounds(817, 441, 104, 23);
		contentPane.add(b19B);
		
		JButton b19C = new JButton("19C");
		b19C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19C.setBounds(931, 441, 104, 23);
		contentPane.add(b19C);
		
		JButton b11D = new JButton("11D");
		b11D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11D.setBounds(1070, 158, 104, 23);
		contentPane.add(b11D);
		
		JButton b11E = new JButton("11E");
		b11E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11E.setBounds(1184, 158, 104, 23);
		contentPane.add(b11E);
		
		JButton b11F = new JButton("11F");
		b11F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11F.setBounds(1298, 158, 104, 23);
		contentPane.add(b11F);
		
		JButton b12D = new JButton("12D");
		b12D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12D.setBounds(1070, 196, 104, 23);
		contentPane.add(b12D);
		
		JButton b12E = new JButton("12E");
		b12E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12E.setBounds(1184, 196, 104, 23);
		contentPane.add(b12E);
		
		JButton b12F = new JButton("12F");
		b12F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12F.setBounds(1298, 196, 104, 23);
		contentPane.add(b12F);
		
		JButton b13D = new JButton("13D");
		b13D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13D.setBounds(1070, 230, 104, 23);
		contentPane.add(b13D);
		
		JButton b13E = new JButton("13E");
		b13E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13E.setBounds(1184, 230, 104, 23);
		contentPane.add(b13E);
		
		JButton b13F = new JButton("13F");
		b13F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13F.setBounds(1298, 230, 104, 23);
		contentPane.add(b13F);
		
		JButton b14D = new JButton("14D");
		b14D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14D.setBounds(1070, 264, 104, 23);
		contentPane.add(b14D);
		
		JButton b14E = new JButton("14E");
		b14E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14E.setBounds(1184, 264, 104, 23);
		contentPane.add(b14E);
		
		JButton b14F = new JButton("14F");
		b14F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b14F.setBounds(1298, 264, 104, 23);
		contentPane.add(b14F);
		
		JButton b15D = new JButton("15D");
		b15D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15D.setBounds(1070, 298, 104, 23);
		contentPane.add(b15D);
		
		JButton b15E = new JButton("15E");
		b15E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15E.setBounds(1184, 298, 104, 23);
		contentPane.add(b15E);
		
		JButton b15F = new JButton("15F");
		b15F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15F.setBounds(1298, 298, 104, 23);
		contentPane.add(b15F);
		
		JButton b16D = new JButton("16D");
		b16D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16D.setBounds(1070, 339, 104, 23);
		contentPane.add(b16D);
		
		JButton b16E = new JButton("16E");
		b16E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16E.setBounds(1184, 339, 104, 23);
		contentPane.add(b16E);
		
		JButton b16F = new JButton("16F");
		b16F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b16F.setBounds(1298, 339, 104, 23);
		contentPane.add(b16F);
		
		JButton b17D = new JButton("17D");
		b17D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17D.setBounds(1070, 373, 104, 23);
		contentPane.add(b17D);
		
		JButton b17E = new JButton("17E");
		b17E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17E.setBounds(1184, 373, 104, 23);
		contentPane.add(b17E);
		
		JButton b17F = new JButton("17F");
		b17F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b17F.setBounds(1298, 373, 104, 23);
		contentPane.add(b17F);
		
		JButton b18D = new JButton("18D");
		b18D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18D.setBounds(1070, 407, 104, 23);
		contentPane.add(b18D);
		
		JButton b18E = new JButton("18E");
		b18E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18E.setBounds(1184, 407, 104, 23);
		contentPane.add(b18E);
		
		JButton b18F = new JButton("18F");
		b18F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b18F.setBounds(1298, 407, 104, 23);
		contentPane.add(b18F);
		
		JButton b15A = new JButton("15A");
		b15A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15A.setBounds(703, 294, 104, 23);
		contentPane.add(b15A);
		
		JButton b15B = new JButton("15B");
		b15B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15B.setBounds(817, 294, 104, 23);
		contentPane.add(b15B);
		
		JButton b15C = new JButton("15C");
		b15C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b15C.setBounds(931, 294, 104, 23);
		contentPane.add(b15C);
		
		JButton b19F = new JButton("19F");
		b19F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19F.setBounds(1298, 441, 104, 23);
		contentPane.add(b19F);
		
		JButton b19E= new JButton("19E");
		b19E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19E.setBounds(1184, 441, 104, 23);
		contentPane.add(b19E);
		
		JButton b19D = new JButton("19D");
		b19D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b19D.setBounds(1070, 441, 104, 23);
		contentPane.add(b19D);
		
		JButton b6A = new JButton("6A");
		b6A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6A.setBounds(45, 497, 104, 23);
		contentPane.add(b6A);
		
		JButton b7A = new JButton("7A");
		b7A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7A.setBounds(45, 531, 104, 23);
		contentPane.add(b7A);
		
		JButton b8A = new JButton("8A");
		b8A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8A.setBounds(45, 565, 104, 23);
		contentPane.add(b8A);
		
		JButton b9A = new JButton("9A");
		b9A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9A.setBounds(45, 599, 104, 23);
		contentPane.add(b9A);
		
		JButton b10A = new JButton("10A");
		b10A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10A.setBounds(45, 639, 104, 23);
		contentPane.add(b10A);
		
		JButton b6B = new JButton("6B");
		b6B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6B.setBounds(210, 497, 104, 23);
		contentPane.add(b6B);
		
		JButton b6C = new JButton("6C");
		b6C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6C.setBounds(324, 497, 104, 23);
		contentPane.add(b6C);
		
		JButton b7B = new JButton("7B");
		b7B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7B.setBounds(210, 531, 104, 23);
		contentPane.add(b7B);
		
		JButton b7C = new JButton("7C");
		b7C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7C.setBounds(324, 531, 104, 23);
		contentPane.add(b7C);
		
		JButton b8B = new JButton("8B");
		b8B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8B.setBounds(210, 569, 104, 23);
		contentPane.add(b8B);
		
		JButton b8C = new JButton("8C");
		b8C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8C.setBounds(324, 569, 104, 23);
		contentPane.add(b8C);
		
		JButton b9B = new JButton("9B");
		b9B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9B.setBounds(210, 603, 104, 23);
		contentPane.add(b9B);
		
		JButton b9C = new JButton("9C");
		b9C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9C.setBounds(324, 603, 104, 23);
		contentPane.add(b9C);
		
		JButton b10B = new JButton("10B");
		b10B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10B.setBounds(210, 643, 104, 23);
		contentPane.add(b10B);
		
		JButton b10C = new JButton("10C");
		b10C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10C.setBounds(324, 643, 104, 23);
		contentPane.add(b10C);
		
		JButton b6D = new JButton("6D");
		b6D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6D.setBounds(479, 497, 104, 23);
		contentPane.add(b6D);
		
		JButton b7D = new JButton("7D");
		b7D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7D.setBounds(479, 535, 104, 23);
		contentPane.add(b7D);
		
		JButton b8D = new JButton("8D");
		b8D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8D.setBounds(479, 573, 104, 23);
		contentPane.add(b8D);
		
		JButton b9D = new JButton("9D");
		b9D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9D.setBounds(479, 603, 104, 23);
		contentPane.add(b9D);
		
		JButton b10D = new JButton("10D");
		b10D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10D.setBounds(479, 643, 104, 23);
		contentPane.add(b10D);
		
		JLabel lblFirstClass = new JLabel("First Class");
		lblFirstClass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblFirstClass.setBounds(153, 93, 83, 23);
		contentPane.add(lblFirstClass);
		
		JLabel lblEconomy = new JLabel("Economy");
		lblEconomy.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEconomy.setBounds(1021, 101, 83, 23);
		contentPane.add(lblEconomy);
		
		sideticketNum = Main.ticketNum;
		ticketNom = Main.ticketNum;
		JLabel lblBusinessClass = new JLabel("Business class");
		lblBusinessClass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblBusinessClass.setBounds(230, 441, 121, 23);
		contentPane.add(lblBusinessClass);
		
		status = new JLabel("Select");
		status.setFont(new Font("Segoe UI", Font.BOLD, 18));
		status.setBounds(45, 59, 147, 23);
		contentPane.add(status);
		
		status.setText("Select " + sideticketNum + " seats");
		
		boeingButtons = new ArrayList<JButton>();
		Collections.addAll(boeingButtons, b1A, b1B, b2A, b2B, b3A, b3B, b4A, b4B, b5A, b5B, b6A, b6B, b6C, b6D,b7A, b7B, b7C, b7D, b8A, b8B, b8C, b8D, b9A, b9B, b9C, b9D, 
				b10A, b10B, b10C, b10D, b11A, b11B, b11C, b11D, 
				b11E, b11F, b12A, b12B, b12C, b12D, b12E, b12F, b13A, b13B, b13C, b13D, b13E, b13F, b14A, b14B, b14C, 
				b14D, b14E, b14F, b15A, b15B, b15C, b15D, b15E, b15F, b16A, b16B, b16C, b16D, b16E, b16F, b17A, b17B, b17C, b17D, b17E, b17F, b18A, b18B, b18C, b18D, 
				b18E, b18F, b19A, b19B, b19C, b19D, b19E, b19F);
		
		JLabel lblNewLabel = new JLabel("Departure Flight: Boeing 747");
		lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		lblNewLabel.setBounds(45, 11, 289, 37);
		contentPane.add(lblNewLabel);
		
		bLabel = new JLabel("User has booked");
		bLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bLabel.setBounds(45, 710, 726, 23);
		contentPane.add(bLabel);
		
		bookButton = new JButton("Book");
		bookButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bookButton.setBounds(1401, 689, 116, 44);
		contentPane.add(bookButton);
		
		JButton finishButton = new JButton("");
		finishButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		finishButton.setBounds(1401, 689, 116, 44);
		contentPane.add(finishButton);
		
		
		for(JButton button: boeingButtons) {
			button.addActionListener(aL);
		}
		
		ActionListener secondListener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(oriticketNo > 0 && checkSeatAvailbility(e.getActionCommand(), returnSeatsB747)) {
					//System.out.println("condition is being satisfied on line 72");
					status.setVisible(false);
					 //oriticketNo--;
					 oriticketNo--;
					 status.setText("Select " + oriticketNo + " Seats");
					 status.setVisible(true);
					 //System.out.println(e.getActionCommand());
					 Rsearchfor(e.getActionCommand(), boeingButtons, returnSeatsB747, example, status, oriticketNo);
					 updateSeats(returnSeatsB747, bLabel);
			
				}
				
				else if(!checkSeatAvailbility(e.getActionCommand() , returnSeatsB747)) {
					JOptionPane.showMessageDialog(example, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);

		}
				else if(oriticketNo <= 0) {
					JOptionPane.showMessageDialog(contentPane, "No tickets left", "You have no tickets left to book seats!", JOptionPane.ERROR_MESSAGE);
				}
				
				
				
				
				
			}
			
			
		};
		
		bookButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(ticketNom != 0) {
					
					JOptionPane.showMessageDialog(example, "You didn't book all your seats!");
				}else {
					//System.out.println(departureSeatsB747.size());
					//for(String s: departureSeatsB747) { System.out.println(s);  }
					
					if(!BseatsAreBooked) {
						JOptionPane.showMessageDialog(example, departureSeatsB747.size() + " seats booked for departure flight on the Boeing 747" );
						
					}else if(BseatsAreBooked) {
						JOptionPane.showMessageDialog(example, departureSeatsB747.size() - 1 + " seats booked for departure flight on the Boeing 747");
						status.setVisible(false);
						 ticketNom--;
						 status.setText("Select " + --ticketNom + " Seats");
						 status.setVisible(true);
					}
					
					JOptionPane.showMessageDialog(example, "Please book the seats for your return flight");
					
					lblNewLabel.setText("Return flight: Boeing 747");
					//System.out.println(oriticketNo);
					numberOfTickets = oriticketNo;
					status.setText("Select " + oriticketNo + " seats");
					bLabel.setText("User has booked seats: ");
					
					clearButtons(boeingButtons);
					for(JButton b: boeingButtons) {
						b.removeActionListener(aL);
						b.addActionListener(secondListener);
					}
					isReturning = true;
					bookButton.setVisible(false);
					finishButton.setText("Finish");
					finishButton.addActionListener(finishListener);
					
					
				}
				
			}
		});
		
		
		
		
	}
	

	
	
	
	
	
	
	
	
	
	
	public boolean checkSeatAvailbility(String seatID, ArrayList<String> al) {
		for(String s: al) {
			if(s == seatID) {
				return false;
				
			}
		}
		return true;
	}

}
