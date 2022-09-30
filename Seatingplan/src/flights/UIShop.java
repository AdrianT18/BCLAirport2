package flights;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.JTextField;

import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSpinner;
import java.util.Date;

public class UIShop extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIShop frame = new UIShop();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public UIShop() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 968, 530);
		contentPane = new JPanel();
		//contentPane.setBackground(new Color(224, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(767, 23, 138, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(767, 67, 138, 34);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("               Brunel City Airport ");
		lblNewLabel.setFont(new Font("Rockwell Nova", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(243, 23, 323, 101);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("Seatingplan/src/flights/logo.1.jpg"));
		lblNewLabel_1.setBounds(82, 20, 105, 148);
		contentPane.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(767, 111, 138, 34);
		contentPane.add(textField_2);
		
		JLabel lblNewLabel_2 = new JLabel("  First Name:");
		lblNewLabel_2.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_2.setBounds(617, 23, 105, 34);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("  Surname:");
		lblNewLabel_2_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_2_1.setBounds(617, 67, 105, 34);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("  TicketNo:");
		lblNewLabel_2_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_2_1_1.setBounds(617, 111, 105, 34);
		contentPane.add(lblNewLabel_2_1_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("Seatingplan/src/flights/cart.1.jpg"));
		lblNewLabel_3.setBounds(909, 23, 35, 34);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel(" Gifts & Confectionary");
		lblNewLabel_4.setFont(new Font("Rockwell Nova", Font.BOLD, 15));
		lblNewLabel_4.setBounds(31, 197, 194, 34);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_4_1 = new JLabel("Boost-\u00A34.99");
		lblNewLabel_4_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1.setBounds(31, 259, 177, 34);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Snickers-\u00A33.99");
		lblNewLabel_4_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_1.setBounds(31, 315, 177, 34);
		contentPane.add(lblNewLabel_4_1_1);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Digestives-\u00A32.99");
		lblNewLabel_4_1_2.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_2.setBounds(31, 374, 177, 34);
		contentPane.add(lblNewLabel_4_1_2);
		
		JLabel lblNewLabel_4_1_3 = new JLabel("AirMax90-\u00A3169.99");
		lblNewLabel_4_1_3.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3.setBounds(339, 259, 177, 34);
		contentPane.add(lblNewLabel_4_1_3);
		
		JLabel lblNewLabel_4_1_3_1 = new JLabel("Walkers-\u00A31.99");
		lblNewLabel_4_1_3_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_1.setBounds(31, 428, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_1);
		
		JLabel lblNewLabel_4_1_3_2 = new JLabel("Clothing");
		lblNewLabel_4_1_3_2.setFont(new Font("Rockwell Nova", Font.BOLD, 15));
		lblNewLabel_4_1_3_2.setBounds(356, 197, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_2);
		
		JLabel lblNewLabel_4_1_3_3 = new JLabel("  Nike Tech Fleece-\u00A3109.99");
		lblNewLabel_4_1_3_3.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3.setBounds(302, 315, 214, 34);
		contentPane.add(lblNewLabel_4_1_3_3);
		
		JLabel lblNewLabel_4_1_3_3_1 = new JLabel("Brasilia Bag-\u00A359.99");
		lblNewLabel_4_1_3_3_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1.setBounds(339, 374, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1 = new JLabel(" Corduroy Jacket-\u00A323.99");
		lblNewLabel_4_1_3_3_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1_1.setBounds(322, 428, 194, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1_1 = new JLabel("Cosmetics");
		lblNewLabel_4_1_3_3_1_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 15));
		lblNewLabel_4_1_3_3_1_1_1.setBounds(638, 197, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1_1_1 = new JLabel("Makeup-\u00A312.99");
		lblNewLabel_4_1_3_3_1_1_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1_1_1_1.setBounds(638, 260, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1_1_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1_1_1_1 = new JLabel("Exclusive -\u00A320.00");
		lblNewLabel_4_1_3_3_1_1_1_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1_1_1_1_1.setBounds(638, 316, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1_1_1_1_1 = new JLabel(" Men Skincare-\u00A319.99");
		lblNewLabel_4_1_3_3_1_1_1_1_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1_1_1_1_1_1.setBounds(638, 375, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1_1_1_1_1);
		
		JLabel lblNewLabel_4_1_3_3_1_1_1_1_1_1_1 = new JLabel("Hair Dryer-\u00A319.99");
		lblNewLabel_4_1_3_3_1_1_1_1_1_1_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		lblNewLabel_4_1_3_3_1_1_1_1_1_1_1.setBounds(638, 429, 177, 34);
		contentPane.add(lblNewLabel_4_1_3_3_1_1_1_1_1_1_1);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(167, 268, 30, 20);
		contentPane.add(spinner);
		spinner.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner.setEnabled(false);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(167, 329, 30, 20);
		contentPane.add(spinner_1);
		spinner_1.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_1.setEnabled(false);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(167, 383, 30, 20);
		contentPane.add(spinner_2);
		spinner_2.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_2.setEnabled(false);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setBounds(167, 437, 30, 20);
		contentPane.add(spinner_3);
		spinner_3.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_3.setEnabled(false);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setBounds(519, 268, 30, 20);
		contentPane.add(spinner_4);
		spinner_4.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_4.setEnabled(false);
		
		JSpinner spinner_5 = new JSpinner();
		spinner_5.setBounds(519, 324, 30, 20);
		contentPane.add(spinner_5);
		spinner_5.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_5.setEnabled(false);
		
		JSpinner spinner_6 = new JSpinner();
		spinner_6.setBounds(519, 383, 30, 20);
		contentPane.add(spinner_6);
		spinner_6.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_6.setEnabled(false);
		
		JSpinner spinner_7 = new JSpinner();
		spinner_7.setBounds(519, 437, 30, 20);
		contentPane.add(spinner_7);
		spinner_7.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_7.setEnabled(false);
		
		JSpinner spinner_8 = new JSpinner();
		spinner_8.setBounds(836, 268, 30, 20);
		contentPane.add(spinner_8);
		spinner_8.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_8.setEnabled(false);
		
		JSpinner spinner_9 = new JSpinner();
		spinner_9.setBounds(836, 324, 30, 20);
		contentPane.add(spinner_9);
		spinner_9.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_9.setEnabled(false);
		
		JSpinner spinner_10 = new JSpinner();
		spinner_10.setBounds(836, 383, 30, 20);
		contentPane.add(spinner_10);
		spinner_10.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_10.setEnabled(false);
		
		JSpinner spinner_11 = new JSpinner();
		spinner_11.setBounds(836, 437, 30, 20);
		contentPane.add(spinner_11);
		spinner_11.setModel(new SpinnerNumberModel(0,0,null,1));
		spinner_11.setEnabled(false);
		
		String passenger_details = "Aaron Samuels 83746578 Regina George 27475839 Cady Heron 95738494";
		String[] passenger_details2 = passenger_details.split(" ");
		JButton btnNewButton_1 = new JButton("Enter ");
		btnNewButton_1.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean Error1 = true;
				for(int i = 0; i <= passenger_details2.length-1; ++i) {
					if(textField.getText().equals(passenger_details2[i]) ) {
						if (textField_1.getText().equals(passenger_details2[i+1])) {
							if (textField_2.getText().equals(passenger_details2[i+2])) {
								JOptionPane.showMessageDialog(null, "                   Details approved! ", "                              Success!", JOptionPane.PLAIN_MESSAGE);
								spinner.setEnabled(true); spinner_1.setEnabled(true); spinner_2.setEnabled(true); spinner_3.setEnabled(true); spinner_4.setEnabled(true); spinner_5.setEnabled(true);
								spinner_6.setEnabled(true); spinner_7.setEnabled(true); spinner_8.setEnabled(true); spinner_9.setEnabled(true); spinner_10.setEnabled(true); spinner_11.setEnabled(true);
								 Error1 = false;
							
								 
							}
						}
						
					}
				}

				if (Error1 == true) {
					JOptionPane.showMessageDialog(null, "Please enter valid details!", "Error", JOptionPane.ERROR_MESSAGE);
				}
			
				
			}	});
		JButton btnNewButton = new JButton("Checkout");
		btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double[] stlist= {Double.parseDouble(spinner.getValue()+""), Double.parseDouble(spinner_1.getValue()+""), Double.parseDouble(spinner_2.getValue()+""), Double.parseDouble(spinner_3.getValue()+""),  Double.parseDouble(spinner_4.getValue()+""), 
							 Double.parseDouble(spinner_5.getValue()+""),  Double.parseDouble(spinner_6.getValue()+""),  Double.parseDouble(spinner_7.getValue()+""),  Double.parseDouble(spinner_8.getValue()+""), ( Double.parseDouble(spinner_9.getValue()+"")),  Double.parseDouble(spinner_10.getValue()+""),
							 Double.parseDouble(spinner_11.getValue()+"")};
					JOptionPane.showMessageDialog(contentPane, "Thanks for your purchase!");
					double[] prlist= {4.99,3.99,2.99,1.99,69.99,109.99,39.99,33.99,12.99,49.99,19.99,24.99};
					double totalprice=0 , eachprice=0,totalprice1=0;
					int x =0;
					double price=0;
					String n = new Date() +"";
					int min = Integer.parseInt(n.substring(14,16));
					System.out.println(min);
					if (min%5==0) {
						x=1;
					}
					else {
						x=0;	
					}
					if (x ==1) {
						for (int i=0;i<12;++i) {
							if (stlist[i]>1) {
							int y = (int)stlist[i]/2;
							int offering=(int)stlist[i]-y;
							eachprice=offering * prlist[i];
							totalprice1=totalprice1+eachprice;
							
						}
							else {
								double y =stlist[i]*prlist[i];
								totalprice1=totalprice1+y;
							}
						
					}
					System.out.println(totalprice1);
					JOptionPane.showMessageDialog(null, "Thank you £"+totalprice1);}
					else {
					for (int i=0;i<12;++i) {
						eachprice=stlist[i]*prlist[i];
						totalprice=totalprice+eachprice;
						
						
					}
					System.out.println(totalprice);
					JOptionPane.showMessageDialog(null, "Thank you total is = £"+totalprice);
					}
				}
	
		});
		btnNewButton.setBackground(new Color(224, 255, 255));
		btnNewButton.setFont(new Font("Rockwell Nova", Font.BOLD, 14));
		btnNewButton.setBounds(766, 186, 138, 21);
		contentPane.add(btnNewButton);
		
			
		btnNewButton_1.setBounds(766, 155, 139, 21);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Special Offer");
		btnNewButton_2.setFont(new Font("Rockwell Nova", Font.BOLD, 16));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Get an item free for every item purchased if you buy something every 5 minutes!", "Special offer", JOptionPane.INFORMATION_MESSAGE);
				
			}
		});
		btnNewButton_2.setBounds(293, 134, 214, 34);
		contentPane.add(btnNewButton_2);
		
	}
}
