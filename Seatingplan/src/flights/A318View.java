package flights;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;


import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.cert.CollectionCertStoreParameters;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class A318View extends JFrame {
	
	public boolean done = false;
	public boolean seatsAreBooked = false;
	
	public boolean isNotReturning = true;
	int bookstage = 0;
	
	
	
	public String summaryString = "";
	public ArrayList<JButton> leftoverButtons = new ArrayList<JButton>();
	public ArrayList<Font> leftovers = new ArrayList<Font>();
	public ArrayList<Integer> formerlyBookedSeats = new ArrayList<Integer>();
	public ArrayList<String> fbs = new ArrayList<String>();
 	public int originalTicketNum;
	public boolean isReturn = false;
	public ArrayList<String> departureSeatsA318 = new ArrayList<String>();
	public ArrayList<String> returnSeatsA318 = new ArrayList<String>();
	public boolean secondmethod = false;
	JButton bButton;
	private JFrame frame;
	private ArrayList<JButton> buttons;
	public ArrayList<String> seats;
	int sideticketNum;
	JLabel lblNewLabel = new JLabel();
	boolean labelchanging = false;
	JLabel bookLabel = new JLabel();
	public String defText = "";
	public boolean addComma;
	boolean isReturningAgain = false;
	JButton rBook;
	
	
	ActionListener returnListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			rBook.setText("Finish");
			

			
			//assertEquals(5, originalTicketNum);
			
			
			
			if(originalTicketNum > 0 && checkSeatAvailbility(e.getActionCommand(), returnSeatsA318)) {
				//frame.setVisible(true);
				isNotReturning = true;
				lblNewLabel.setVisible(false);
				 originalTicketNum--;
				 lblNewLabel.setText("Select " + originalTicketNum + " Seats");
				 lblNewLabel.setVisible(true);
				 
				 Rsearchfor(e.getActionCommand(), buttons, returnSeatsA318, frame, lblNewLabel, originalTicketNum);
				 updateSeats(returnSeatsA318, bookLabel);
				 
				 
			}
			else if(!checkSeatAvailbility(e.getActionCommand(), returnSeatsA318) && e.getActionCommand() != "Finish") {
				
				JOptionPane.showMessageDialog(frame, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			
				
			}else if(e.getActionCommand() == "Finish" && originalTicketNum > 0) {
				JOptionPane.showMessageDialog(frame, "Please book your remaining " + originalTicketNum + " seats","You didn't book all your seats!", JOptionPane.ERROR_MESSAGE);
			}
					
		
			 
		else if(originalTicketNum  <= 0) {
					JOptionPane.showMessageDialog(frame, returnSeatsA318.size() + " seats booked for return flight on the Airbus A318");
					JOptionPane.showMessageDialog(frame, "All seats booked successfully");
					
					
					getContentPane().setVisible(false);
					setBounds(100, 100, 1, 1);
				}
			
			
			
			
			
			
		}
	};
	
	
	public void clearButtons(ArrayList<JButton> aljb) {
		int match = 0;
		
		for(int i = 0; i < aljb.size(); i++) {
			for(int j = 0; j < formerlyBookedSeats.size(); j++) {
				for(int k = 0; k < fbs.size(); k++) {
					if((aljb.get(i).getX() + aljb.get(i).getY()) == formerlyBookedSeats.get(j)) {
						match++;
						
						aljb.get(i).setBackground(null);
						aljb.get(i).setText(fbs.get(j));
						
						
					}else {
						
					}
				}
			}
		}
		
		
		
	
		
		
		
		
		
	
		
			
	}
	
	
	
	
	
	
	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					A318View window = new A318View();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	ActionListener buttonAL = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
			       	
			
		if(sideticketNum > 0 && checkSeatAvailbility(e.getActionCommand(), departureSeatsA318)) {
			
			isNotReturning = true;
			lblNewLabel.setVisible(false);
			 sideticketNum--;
			 lblNewLabel.setText("Select " + sideticketNum + " Seats");
			 lblNewLabel.setVisible(true);
			 
			 searchfor(e.getActionCommand(), buttons, departureSeatsA318, frame, lblNewLabel, sideticketNum);
			 updateSeats(departureSeatsA318, bookLabel);
			 
			 
		}
		
		
		else if(!checkSeatAvailbility(e.getActionCommand(), returnSeatsA318)) {
			
			JOptionPane.showMessageDialog(frame, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			
				
			}
					
		
			 
		else if(sideticketNum <= 0) {
			JOptionPane.showMessageDialog(frame, "No tickets left", "You have no tickets left to book seats!", JOptionPane.ERROR_MESSAGE);

				}
			 
		}
		
		
		
			 
		
		 
		
		
		
	
		
	};

	
	public A318View(int donothing) {
		
	}
	/**
	 * Create the application.
	 */
	
	public void searchfor(String s, ArrayList<JButton> buttons, ArrayList<String> al, JFrame f, JLabel l, int ticketNo) {
		JButton buttonToChangeColourOf = null;
		for(int i = 0; i < buttons.size(); i++) {
			
			if(buttons.get(i).getBackground() != Color.RED && buttons.get(i).getText() == s) {
				buttonToChangeColourOf = buttons.get(i);
				al.add(s);
				
				break;
			}else {
				
			}
			
		}
		
		try {
			buttonToChangeColourOf.setBackground(Color.RED);
			formerlyBookedSeats.add(buttonToChangeColourOf.getX() + buttonToChangeColourOf.getY());
			fbs.add(buttonToChangeColourOf.getText());
			
			buttonToChangeColourOf.setText("Booked");
			
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(f, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			
			sideticketNum++;
			
			l.setVisible(false);
			l.setText("Select " + sideticketNum + " Seats");
			l.setVisible(true);
		}
		
	}
	
	
	
	public void Rsearchfor(String s, ArrayList<JButton> buttons, ArrayList<String> al, JFrame f, JLabel l, int ticketNo) {
		JButton buttonToChangeColourOf = null;
		for(int i = 0; i < buttons.size(); i++) {
			
			if(buttons.get(i).getBackground() != Color.RED && buttons.get(i).getText() == s) {
				buttonToChangeColourOf = buttons.get(i);
				al.add(s);
				
				break;
			}else {
				
			}
			
		}
		
		try {
			buttonToChangeColourOf.setBackground(Color.RED);
			formerlyBookedSeats.add(buttonToChangeColourOf.getX() + buttonToChangeColourOf.getY());
			fbs.add(buttonToChangeColourOf.getText());
			
			buttonToChangeColourOf.setText("Booked");
			
		}catch(NullPointerException npe) {
			JOptionPane.showMessageDialog(f, "That seat is already taken! Please choose another seat", "Seat already chosen", JOptionPane.ERROR_MESSAGE);
			
		
			originalTicketNum++;
			l.setVisible(false);
			l.setText("Select " + originalTicketNum + " Seats");
			l.setVisible(true);
		}
		
	}
	
	public boolean checkSeatAvailbility(String seatID, ArrayList<String> sss) {
		for(String s: sss) {
			if(s == seatID) {
				return false;
				
			}
		}
		return true;
	}
	
	public boolean contains(char[] coll, char letter) {
		for(int i = 0; i < coll.length; i++) {
			if(coll[i] == letter) {
				return true;
			}
		}
		return false;
	}
	
	public void removeDuplicates(ArrayList<String> s) {
		
		
		
	}
	
	
	
	public void updateSeats(ArrayList<String> s, JLabel label) {
		for(int i = 0; i < s.size(); i++) {
			
			char[] exChar = new char[100];
			if(contains(s.get(i).toCharArray(), 'o')) {
				//System.out.println("found forbidden characters, ignored");
				seatsAreBooked = true;
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
	
	
	
	protected A318View() {
		//System.out.println("in the other constructor ");
		getContentPane().setLayout(null);
		
		
		
		
		
		JButton b1A = new JButton("1A");
		b1A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b1A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		b1A.setBounds(101, 158, 104, 23);
		getContentPane().add(b1A);
		
		JButton b2A = new JButton("2A");
		b2A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b2A.setBounds(101, 192, 104, 23);
		getContentPane().add(b2A);
		
		JButton b3A = new JButton("3A");
		b3A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b3A.setBounds(101, 226, 104, 23);
		getContentPane().add(b3A);
		
		JButton b4A = new JButton("4A");
		b4A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b4A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b4A.setBounds(101, 260, 104, 23);
		getContentPane().add(b4A);
		
		JButton b5A = new JButton("5A");
		b5A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b5A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b5A.setBounds(101, 294, 104, 23);
		getContentPane().add(b5A);
		
		JButton b1B = new JButton("1B");
		b1B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b1B.setBounds(303, 158, 104, 23);
		getContentPane().add(b1B);
		
		JButton b2B = new JButton("2B");
		b2B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b2B.setBounds(303, 192, 104, 23);
		getContentPane().add(b2B);
		
		JButton b3B = new JButton("3B");
		b3B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b3B.setBounds(303, 226, 104, 23);
		getContentPane().add(b3B);
		
		JButton b4B = new JButton("4B");
		b4B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b4B.setBounds(303, 260, 104, 23);
		getContentPane().add(b4B);
		
		JButton b5B = new JButton("5B");
		b5B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b5B.setBounds(303, 294, 104, 23);
		getContentPane().add(b5B);
		
		JLabel businessLabel = new JLabel("Business class");
		businessLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		businessLabel.setBounds(196, 96, 133, 37);
		getContentPane().add(businessLabel);
		
		JButton b6A = new JButton("6A");
		b6A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6A.setBounds(659, 158, 104, 23);
		getContentPane().add(b6A);
		
		JButton b6B = new JButton("6B");
		b6B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6B.setBounds(779, 158, 104, 23);
		getContentPane().add(b6B);
		
		JButton b6C = new JButton("6C");
		b6C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6C.setBounds(893, 158, 104, 23);
		getContentPane().add(b6C);
		
		JButton b6D = new JButton("6D");
		b6D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6D.setBounds(1021, 158, 104, 23);
		getContentPane().add(b6D);
		
		JButton b6E = new JButton("6E");
		b6E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6E.setBounds(1143, 158, 104, 23);
		getContentPane().add(b6E);
		
		JButton b6F = new JButton("6F");
		b6F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b6F.setBounds(1267, 158, 104, 23);
		getContentPane().add(b6F);
		
		JButton b7A = new JButton("7A");
		b7A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7A.setBounds(659, 196, 104, 23);
		getContentPane().add(b7A);
		
		JButton b7B = new JButton("7B");
		b7B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7B.setBounds(779, 196, 104, 23);
		getContentPane().add(b7B);
		
		JButton b7C= new JButton("7C");
		b7C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7C.setBounds(893, 196, 104, 23);
		getContentPane().add(b7C);
		
		JButton b7D = new JButton("7D");
		b7D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7D.setBounds(1021, 196, 104, 23);
		getContentPane().add(b7D);
		
		JButton b7E = new JButton("7E");
		b7E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7E.setBounds(1143, 196, 104, 23);
		getContentPane().add(b7E);
		
		JButton b7F = new JButton("7F");
		b7F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b7F.setBounds(1267, 196, 104, 23);
		getContentPane().add(b7F);
		
		JButton b8A = new JButton("8A");
		b8A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b8A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8A.setBounds(659, 230, 104, 23);
		getContentPane().add(b8A);
		
		JButton b8B = new JButton("8B");
		b8B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8B.setBounds(779, 230, 104, 23);
		getContentPane().add(b8B);
		
		JButton b8C = new JButton("8C");
		b8C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8C.setBounds(893, 230, 104, 23);
		getContentPane().add(b8C);
		
		JButton b8D = new JButton("8D");
		b8D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8D.setBounds(1021, 230, 104, 23);
		getContentPane().add(b8D);
		
		JButton b8E = new JButton("8E");
		b8E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8E.setBounds(1143, 230, 104, 23);
		getContentPane().add(b8E);
		
		JButton b8F = new JButton("8F");
		b8F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b8F.setBounds(1267, 230, 104, 23);
		getContentPane().add(b8F);
		
		JButton b9A = new JButton("9A");
		b9A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b9A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9A.setBounds(659, 260, 104, 23);
		getContentPane().add(b9A);
		
		JButton b9B = new JButton("9B");
		b9B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9B.setBounds(779, 264, 104, 23);
		getContentPane().add(b9B);
		
		JButton b9C = new JButton("9C");
		b9C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9C.setBounds(893, 264, 104, 23);
		getContentPane().add(b9C);
		
		JButton b9D = new JButton("9D");
		b9D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b9D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9D.setBounds(1021, 264, 104, 23);
		getContentPane().add(b9D);
		
		JButton b9E = new JButton("9E");
		b9E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9E.setBounds(1143, 264, 104, 23);
		getContentPane().add(b9E);
		
		JButton b9F = new JButton("9F");
		b9F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b9F.setBounds(1267, 264, 104, 23);
		getContentPane().add(b9F);
		
		JButton b10A = new JButton("10A");
		b10A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b10A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10A.setBounds(659, 294, 104, 23);
		getContentPane().add(b10A);
		
		JButton b10B = new JButton("10B");
		b10B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10B.setBounds(779, 298, 104, 23);
		getContentPane().add(b10B);
		
		JButton b10C =  new JButton("10C");
		b10C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10C.setBounds(893, 298, 104, 23);
		getContentPane().add(b10C);
		
		JButton b10D = new JButton("10D");
		b10D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10D.setBounds(1021, 298, 104, 23);
		getContentPane().add(b10D);
		
		JButton b10E = new JButton("10E");
		b10E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10E.setBounds(1143, 298, 104, 23);
		getContentPane().add(b10E);
		
		JButton b10F = new JButton("10F");
		b10F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b10F.setBounds(1267, 294, 104, 23);
		getContentPane().add(b10F);
		
		JButton b11A = new JButton("11A");
		b11A.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b11A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11A.setBounds(659, 332, 104, 23);
		getContentPane().add(b11A);
		
		JButton b11B = new JButton("11B");
		b11B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11B.setBounds(779, 332, 104, 23);
		getContentPane().add(b11B);
		
		JButton b11C = new JButton("11C");
		b11C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11C.setBounds(893, 332, 104, 23);
		getContentPane().add(b11C);
		
		JButton b11D = new JButton("11D");
		b11D.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b11D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11D.setBounds(1021, 332, 104, 23);
		getContentPane().add(b11D);
		
		JButton b11E = new JButton("11E");
		b11E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11E.setBounds(1143, 332, 104, 23);
		getContentPane().add(b11E);
		
		JButton b11F = new JButton("11F");
		b11F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b11F.setBounds(1267, 332, 104, 23);
		getContentPane().add(b11F);
		
		JButton b12A = new JButton("12A");
		b12A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12A.setBounds(659, 366, 104, 23);
		getContentPane().add(b12A);
		
		JButton b12B = new JButton("12B");
		b12B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12B.setBounds(779, 366, 104, 23);
		getContentPane().add(b12B);
		
		JButton b12C = new JButton("12C");
		b12C.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b12C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12C.setBounds(893, 366, 104, 23);
		getContentPane().add(b12C);
		
		JButton b12D = new JButton("12D");
		b12D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12D.setBounds(1021, 366, 104, 23);
		getContentPane().add(b12D);
		
		JButton b12E = new JButton("12E");
		b12E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12E.setBounds(1143, 366, 104, 23);
		getContentPane().add(b12E);
		
		JButton b12F = new JButton("12F");
		b12F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b12F.setBounds(1267, 366, 104, 23);
		getContentPane().add(b12F);
		
		JButton b13A = new JButton("13A");
		b13A.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13A.setBounds(659, 400, 104, 23);
		getContentPane().add(b13A);
		
		JButton b13B = new JButton("13B");
		b13B.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13B.setBounds(779, 400, 104, 23);
		getContentPane().add(b13B);
		
		JButton b13C = new JButton("13C");
		b13C.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13C.setBounds(893, 400, 104, 23);
		getContentPane().add(b13C);
		
		JButton b13D = new JButton("13D");
		b13D.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13D.setBounds(1021, 400, 104, 23);
		getContentPane().add(b13D);
		
		JButton b13E = new JButton("13E");
		b13E.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13E.setBounds(1143, 400, 104, 23);
		getContentPane().add(b13E);
		
		JButton b13F = new JButton("13F");
		b13F.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		b13F.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		b13F.setBounds(1267, 400, 104, 23);
		getContentPane().add(b13F);
		
		JLabel lblEconomyClass = new JLabel("Economy class");
		lblEconomyClass.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		lblEconomyClass.setBounds(953, 96, 133, 37);
		
		
		getContentPane().add(lblEconomyClass);
		
		
		sideticketNum = Main.ticketNum;
		originalTicketNum = Main.ticketNum;
		
		
			lblNewLabel = new JLabel("Select " + sideticketNum + " Seats");
			lblNewLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
			lblNewLabel.setBounds(41, 49, 148, 23);
			getContentPane().add(lblNewLabel);
		
		
		initialize();
		buttons = new ArrayList<JButton>();
	
		Collections.addAll(buttons, b1A, b1B, b2A, b2B, b3A, b3B, b4A, b4B, b5A, b5B, b6A, b6B, b6C, b6D, b6E, b6F ,b7A, b7B, b7C, b7D, b7E, b7F, b8A, b8B, b8C, b8D, b8E, b8F, b9A, b9B, b9C, b9D, b9E, b9F, b10A, b10B, b10C, b10D, b10E, b10F, b11A, b11B, b11C, b11D, b11E, b11F, b12A, b12B, b12C, b12D, b12E, b12F, b13A, b13B, b13C, b13D, b13E, b13F);
		
		JLabel departureLabel = new JLabel("Departure Flight: Airbus A318");
		departureLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
		departureLabel.setBounds(41, 11, 288, 27);
		getContentPane().add(departureLabel);
		
		bookLabel = new JLabel("");
		bookLabel.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bookLabel.setBounds(41, 660, 722, 23);
		getContentPane().add(bookLabel);
		
		bButton = new JButton("Book");
		bButton.setFont(new Font("Segoe UI", Font.BOLD, 18));
		bButton.setBounds(1373, 620, 112, 47);
		getContentPane().add(bButton);
		
		rBook = new JButton("");
		rBook.setFont(new Font("Segoe UI", Font.BOLD, 18));
		rBook.setBounds(1373, 620, 112, 47);
		getContentPane().add(rBook);
		
		
		
		
		for(JButton b: buttons) {
			b.addActionListener(buttonAL);
		}
		
		
		if(b1A.isSelected()) {
			//System.out.println("hello");
		}
		
		
		
	
		bButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
					if(sideticketNum != 0) {
						JOptionPane.showMessageDialog(frame, "You didn't book all your seats!");
					}else {
						done = true;
						departureLabel.setText("Return Flight: Airbus A318");
						
						Main.isReturning = true;
						isReturn = Main.isReturning;
						
						bButton.setBounds(1355, 674, 200, 77);
						bButton.setText("Book return flight");
						//bButton.addActionListener(buttonAL);
						rBook.setText("Finish");
						bButton.setVisible(false);
						rBook.setVisible(true);
						
						//clear labels
						
						lblNewLabel.setText("Select " + originalTicketNum + " tickets");
						bookLabel.setText("User has booked seats: ");
						if(!seatsAreBooked) {
							
							JOptionPane.showMessageDialog(frame, departureSeatsA318.size() + " seats booked for departure flight on the Airbus A318" );
							JOptionPane.showMessageDialog(frame, "Please book the seats for your return flight");
						}else if(seatsAreBooked) {
							
							JOptionPane.showMessageDialog(frame, departureSeatsA318.size() - 1 + " seats booked for departure flight on the Airbus A318" );
							lblNewLabel.setVisible(false);
							 sideticketNum--;
							 lblNewLabel.setText("Select " + --sideticketNum + " Seats");
							 lblNewLabel.setVisible(true);
						}
						
						
						clearButtons(buttons);
						
						for(JButton b: buttons) {
							b.removeActionListener(buttonAL);
							b.addActionListener(returnListener);
						}
						
					
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						rBook.addActionListener(returnListener);
						//btnNewButton.setVisible(true);
						//btnNewButton.addActionListener(buttonAL);
					}
					
									
					//bButton.setVisible(false);
					//btnNewButton.setVisible(true);
					
					

					
				}
			
				
			
		});
	}
	

	
	
	
	
	
	
	
	
	
	
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
