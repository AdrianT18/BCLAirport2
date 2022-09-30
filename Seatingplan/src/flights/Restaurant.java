package flights;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class Restaurant extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtLambChops;
	private JTextField textField_7;
	private JTextField txtMacAndCheese;
	private JTextField textField_2;
	private JTextField txtRestaurant;
	private JTextField txtFriedWings;
	private JTextField txtBurritos;
	private JTextField txtFishAndChips;
	private JTextField txtPizza;
	private JTextField txtSushi;
	private JTextField txtSteak;
	private JTextField txtChickenBurger;
	private JTextField txtSpaghetti;
	private JTextField txtShephardsPie;
	private JTextField txtLasagne;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_27;
	private JTextField textField_29;
	private JTextField textField_31;
	private JTextField textField_33;
	private JTextField textField_35;
	private JTextField txtClickToProceed;
	private JTextField txtTicketNo;
	private JLabel lblNewLabel_3;
	private JTextField textField_8;
	private JTextField textField_1;
	double[] foodTotal = new double[12];
	Food MacAndCheese = new Food("Mac and Cheese",100,10);
	Food FriedWings = new Food ("Fried Wings",100,5);
	Food Burritos = new Food ("Burritos",100,5);
	Food FishAndChips = new Food ("Fish And Chips",100,10);
	Food Pizza = new Food ("Pizza",100,8);
	Food Sushi = new Food ("Sushi",100,7);
	Food LambChops = new Food ("Lamb Chops",100,10);
	Food Steak = new Food ("Steak",100,15);
	Food ChickenBurger = new Food ("Chicken Burger",100,5);
	Food Spaghetti = new Food ("Spaghetti",100,7);
	Food ShephardsPie = new Food ("Shephard's Pie",100,10);
	Food Lasagne = new Food ("Lasagne",100,10);
	private int total=0;
	private int total1=0;
	private int total2=0;
	private int total3=0;
	private int total4=0;
	private int total5=0;
	private int total6=0;
	private int total7=0;
	private int total8=0;
	private int total9=0;
	private int total10=0;
	private int total11=0;
	ArrayList <Integer> quantity;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Restaurant frame = new Restaurant();
					frame.setVisible(true);
				} 
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public Restaurant() {
	

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 667, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BRUNEL CITY AIRPORT");
		lblNewLabel.setBounds(210, 6, 300, 26);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		contentPane.add(lblNewLabel);
// This is the details for the Title, this includes Name, where its placed, font type and size.
		
		
		txtLambChops = new JTextField();
		txtLambChops.setBounds(394, 68, 130, 35);
		txtLambChops.setBackground(SystemColor.textHighlight);
		txtLambChops.setForeground(SystemColor.text);
		txtLambChops.setText("Lamb Chops");
		txtLambChops.setColumns(10);
		contentPane.add(txtLambChops);
// Above is the details for lamb chop food type, here you can see the font type and size also you can see the different colours used, same for rest of food below.
		
		textField_7 = new JTextField();
		textField_7.setBounds(148, 68, 51, 35);
		textField_7.setBackground(SystemColor.textHighlight);
		textField_7.setForeground(SystemColor.text);
		textField_7.setText("£10");
		textField_7.setColumns(10);
		contentPane.add(textField_7);
		
		txtMacAndCheese = new JTextField();
		txtMacAndCheese.setBounds(6, 68, 130, 35);
		txtMacAndCheese.setBackground(SystemColor.textHighlight);
		txtMacAndCheese.setForeground(Color.WHITE);
		txtMacAndCheese.setFont(new Font("Verdana", Font.PLAIN, 13));
		txtMacAndCheese.setText("Mac and Cheese");
		txtMacAndCheese.setColumns(10);
		contentPane.add(txtMacAndCheese);
	
		
		textField_2 = new JTextField();
		textField_2.setBounds(536, 68, 51, 35);
		textField_2.setBackground(SystemColor.textHighlight);
		textField_2.setForeground(SystemColor.text);
		textField_2.setText("£10");
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		txtRestaurant = new JTextField();
		txtRestaurant.setBounds(265, 34, 130, 26);
		txtRestaurant.setForeground(SystemColor.text);
		txtRestaurant.setBackground(SystemColor.textHighlight);
		txtRestaurant.setText("RESTAURANT");
		txtRestaurant.setColumns(10);
		contentPane.add(txtRestaurant);
		
		txtFriedWings = new JTextField();
		txtFriedWings.setBounds(6, 136, 130, 35);
		txtFriedWings.setForeground(SystemColor.text);
		txtFriedWings.setBackground(SystemColor.textHighlight);
		txtFriedWings.setText("Fried Wings");
		txtFriedWings.setColumns(10);
		contentPane.add(txtFriedWings);
		
		txtBurritos = new JTextField();
		txtBurritos.setBounds(6, 198, 130, 35);
		txtBurritos.setForeground(SystemColor.text);
		txtBurritos.setBackground(SystemColor.textHighlight);
		txtBurritos.setText("Burritos");
		txtBurritos.setColumns(10);
		contentPane.add(txtBurritos);
		
		txtFishAndChips = new JTextField();
		txtFishAndChips.setBounds(6, 255, 130, 35);
		txtFishAndChips.setForeground(SystemColor.text);
		txtFishAndChips.setBackground(SystemColor.textHighlight);
		txtFishAndChips.setText("Fish and Chips");
		txtFishAndChips.setColumns(10);
		contentPane.add(txtFishAndChips);
		
		txtPizza = new JTextField();
		txtPizza.setBounds(6, 318, 130, 35);
		txtPizza.setForeground(SystemColor.text);
		txtPizza.setBackground(SystemColor.textHighlight);
		txtPizza.setText("Pizza");
		txtPizza.setColumns(10);
		contentPane.add(txtPizza);
		
		txtSushi = new JTextField();
		txtSushi.setBounds(6, 381, 130, 35);
		txtSushi.setBackground(SystemColor.textHighlight);
		txtSushi.setForeground(SystemColor.text);
		txtSushi.setText("Sushi");
		txtSushi.setColumns(10);
		contentPane.add(txtSushi);
		
		txtSteak = new JTextField();
		txtSteak.setBounds(394, 136, 130, 35);
		txtSteak.setBackground(SystemColor.textHighlight);
		txtSteak.setForeground(SystemColor.text);
		txtSteak.setText("Steak");
		txtSteak.setColumns(10);
		contentPane.add(txtSteak);
		
		txtChickenBurger = new JTextField();
		txtChickenBurger.setBounds(394, 198, 130, 35);
		txtChickenBurger.setBackground(SystemColor.textHighlight);
		txtChickenBurger.setForeground(SystemColor.text);
		txtChickenBurger.setText("Chicken Burger");
		txtChickenBurger.setColumns(10);
		contentPane.add(txtChickenBurger);
		
		txtSpaghetti = new JTextField();
		txtSpaghetti.setBounds(394, 255, 130, 35);
		txtSpaghetti.setBackground(SystemColor.textHighlight);
		txtSpaghetti.setForeground(SystemColor.text);
		txtSpaghetti.setText("Spaghetti");
		txtSpaghetti.setColumns(10);
		contentPane.add(txtSpaghetti);
		
		txtShephardsPie = new JTextField();
		txtShephardsPie.setBounds(394, 318, 130, 35);
		txtShephardsPie.setBackground(SystemColor.textHighlight);
		txtShephardsPie.setForeground(SystemColor.text);
		txtShephardsPie.setText("Shephard's Pie");
		txtShephardsPie.setColumns(10);
		contentPane.add(txtShephardsPie);
		
		txtLasagne = new JTextField();
		txtLasagne.setBounds(394, 381, 130, 35);
		txtLasagne.setBackground(SystemColor.textHighlight);
		txtLasagne.setForeground(SystemColor.text);
		txtLasagne.setText("Lasagne");
		txtLasagne.setColumns(10);
		contentPane.add(txtLasagne);
		
		textField_17 = new JTextField();
		textField_17.setBounds(148, 136, 51, 35);
		textField_17.setForeground(SystemColor.text);
		textField_17.setBackground(SystemColor.textHighlight);
		textField_17.setText("£5");
		textField_17.setColumns(10);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setBounds(148, 198, 51, 35);
		textField_18.setForeground(SystemColor.text);
		textField_18.setBackground(SystemColor.textHighlight);
		textField_18.setText("£5");
		textField_18.setColumns(10);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setBounds(148, 255, 51, 35);
		textField_19.setForeground(SystemColor.text);
		textField_19.setBackground(SystemColor.textHighlight);
		textField_19.setText("£10");
		textField_19.setColumns(10);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setBounds(148, 318, 51, 35);
		textField_20.setBackground(SystemColor.textHighlight);
		textField_20.setForeground(SystemColor.text);
		textField_20.setText("£8");
		textField_20.setColumns(10);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setBounds(148, 381, 51, 35);
		textField_21.setBackground(SystemColor.textHighlight);
		textField_21.setForeground(SystemColor.text);
		textField_21.setText("£7");
		textField_21.setColumns(10);
		contentPane.add(textField_21);
		
		textField_27 = new JTextField();
		textField_27.setBounds(536, 136, 51, 35);
		textField_27.setBackground(SystemColor.textHighlight);
		textField_27.setForeground(SystemColor.text);
		textField_27.setText("£15");
		textField_27.setColumns(10);
		contentPane.add(textField_27);
		
		textField_29 = new JTextField();
		textField_29.setBounds(536, 198, 51, 35);
		textField_29.setBackground(SystemColor.textHighlight);
		textField_29.setForeground(SystemColor.text);
		textField_29.setText("£5");
		textField_29.setColumns(10);
		contentPane.add(textField_29);
		
		textField_31 = new JTextField();
		textField_31.setBounds(536, 255, 51, 35);
		textField_31.setBackground(SystemColor.textHighlight);
		textField_31.setForeground(SystemColor.text);
		textField_31.setText("£7");
		textField_31.setColumns(10);
		contentPane.add(textField_31);
		
		textField_33 = new JTextField();
		textField_33.setBounds(536, 318, 51, 35);
		textField_33.setBackground(SystemColor.textHighlight);
		textField_33.setForeground(SystemColor.text);
		textField_33.setText("£10");
		textField_33.setColumns(10);
		contentPane.add(textField_33);
		
		textField_35 = new JTextField();
		textField_35.setBounds(536, 381, 51, 35);
		textField_35.setBackground(SystemColor.textHighlight);
		textField_35.setForeground(SystemColor.text);
		textField_35.setText("£10");
		textField_35.setColumns(10);
		contentPane.add(textField_35);
		
		txtClickToProceed = new JTextField();
		txtClickToProceed.setBounds(270, 137, 122, 35);
		txtClickToProceed.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		contentPane.add(txtClickToProceed);
		txtClickToProceed.setColumns(10);
// This txtClickToProceed represents the box where the user will input their first name.
		
		txtTicketNo = new JTextField();
		txtTicketNo.setBounds(270, 284, 122, 35);
		txtTicketNo.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		txtTicketNo.setColumns(10);
		contentPane.add(txtTicketNo);
// This txtTicketNo is the location where user will input their ticket number.
		
		JButton btnNewButton = new JButton("buy");
		btnNewButton.setBounds(270, 424, 117, 29);
		contentPane.add(btnNewButton);
// This btnNewButton is located on for the user to click once they have inserted their details and the food they want.
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(280, 109, 98, 16);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ticket No:");
		lblNewLabel_2.setBounds(280, 264, 98, 16);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_3 = new JLabel("Surname:");
		lblNewLabel_3.setBounds(280, 189, 61, 16);
		contentPane.add(lblNewLabel_3);
		
		textField_8 = new JTextField();
		textField_8.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField_8.setColumns(10);
		textField_8.setBounds(270, 217, 122, 35);
		contentPane.add(textField_8);
		
		

		
		SpinnerNumberModel case1 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case2 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case3 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case4 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case5 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case6 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case7 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case8 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case9 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case10 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case11 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
		
		SpinnerNumberModel case12 = new SpinnerNumberModel(0.0,0.0,100.0, 1.0);
//This was added here because this tells the drop down list to not exceed 100 and also not to go below 0.
		
		JSpinner spinner = new JSpinner(case1);
		spinner.setBounds(211, 72, 51, 26);
		contentPane.add(spinner);
		spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[0] = quantity;
				total = (int) quantity;
				System.out.println(total);
				updateTotal();
			}
		});
// This was added as this is the actual drop down list and below there is more code used from this.		
		
		JSpinner spinner_1 = new JSpinner(case2);
		spinner_1.setBounds(211, 140, 51, 26);
		contentPane.add(spinner_1);
		spinner_1.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[1] = quantity;
				total1 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_2 = new JSpinner(case3);
		spinner_2.setBounds(211, 202, 51, 26);
		contentPane.add(spinner_2);
		spinner_2.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[2] = quantity;
				total2 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_3 = new JSpinner(case4);
		spinner_3.setBounds(211, 259, 51, 26);
		contentPane.add(spinner_3);
		spinner_3.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[3] = quantity;
				total3 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_4 = new JSpinner(case5);
		spinner_4.setBounds(211, 322, 51, 26);
		contentPane.add(spinner_4);
		spinner_4.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[4] = quantity;
				total4 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_5 = new JSpinner(case6);
		spinner_5.setBounds(211, 385, 51, 26);
		contentPane.add(spinner_5);
		spinner_5.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[5] = quantity;
				total5= (int) quantity;
				updateTotal();
			}
		});

		JSpinner spinner_6 = new JSpinner(case7);
		spinner_6.setBounds(599, 72, 51, 26);
		contentPane.add(spinner_6);
		spinner_6.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[6] = quantity;
				total6 = (int) quantity;
				updateTotal();
			}
		});

		JSpinner spinner_7 = new JSpinner(case8);
		spinner_7.setBounds(599, 140, 51, 26);
		contentPane.add(spinner_7);
		spinner_7.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[7] = quantity;
				total7 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_8 = new JSpinner(case9);
		spinner_8.setBounds(599, 202, 51, 26);
		contentPane.add(spinner_8);
		spinner_8.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[8] = quantity;
				total8 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_9 = new JSpinner(case10);
		spinner_9.setBounds(599, 259, 51, 26);
		contentPane.add(spinner_9);
		spinner_9.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[9] = quantity;
				total9 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_10 = new JSpinner(case11);
		spinner_10.setBounds(599, 322, 51, 26);
		contentPane.add(spinner_10);
		spinner_10.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[10] = quantity;
				total10 = (int) quantity;
				updateTotal();
			}
		});
		
		JSpinner spinner_11 = new JSpinner(case12);
		spinner_11.setBounds(599, 385, 51, 26);
		contentPane.add(spinner_11);
		spinner_11.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				double quantity = (double)((JSpinner) e.getSource()).getValue();
				foodTotal[11] = quantity;
				total11 = (int) quantity;
				updateTotal();
			}
		});
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Total Price:");
		lblNewLabel_2_1_1.setBounds(280, 366, 98, 16);
		contentPane.add(lblNewLabel_2_1_1);
		
		textField_1 = new JTextField();
		textField_1.setForeground(SystemColor.text);
		textField_1.setBackground(SystemColor.textHighlight);
		textField_1.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		textField_1.setColumns(10);
		textField_1.setBounds(270, 385, 122, 35);
		contentPane.add(textField_1);
		

		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println();
				resPassenger check = new resPassenger();
				check.setFirstName(txtClickToProceed.getText());
				check.setSurName(textField_8.getText());
				check.setTicketNo(txtTicketNo.getText());
// This piece of code checks the data from the passenger class
				resPassenger.checkfirstname=txtClickToProceed.getText();
				resPassenger.checksurname=textField_8.getText();
				resPassenger.checkno=txtTicketNo.getText();
// The above tells us where the data will be checked in
				
				if(resPassenger.checkuser(check)=="yes" && getTotal()<101) {
					System.out.println (getTotal());
				JOptionPane.showMessageDialog(null, "Order Successful");
// The above if statement is used and when things are correct the message from the bottom will be shown
				
				MacAndCheese.setStock(MacAndCheese.getStock()-(int)foodTotal[0]);
				
				FriedWings.setStock(FriedWings.getStock()-(int)foodTotal[1]);
				
				Burritos.setStock(Burritos.getStock()-(int)foodTotal[2]);
				
				FishAndChips.setStock(FishAndChips.getStock()-(int)foodTotal[3]);
				
				Pizza.setStock(Pizza.getStock()-(int)foodTotal[4]);
				
				Sushi.setStock(Sushi.getStock()-(int)foodTotal[5]);
				
				LambChops.setStock(LambChops.getStock()-(int)foodTotal[6]);
				
				Steak.setStock(Steak.getStock()-(int)foodTotal[7]);
				
				ChickenBurger.setStock(ChickenBurger.getStock()-(int)foodTotal[8]);
				
				Spaghetti.setStock(Spaghetti.getStock()-(int)foodTotal[9]);
				
				ShephardsPie.setStock(ShephardsPie.getStock()-(int)foodTotal[10]);
				
				Lasagne.setStock(Lasagne.getStock()-(int)foodTotal[11]);
				}
				System.out.println(getTotal());
				if(resPassenger.checkuser(check)=="no" || getTotal()>100) {
					JOptionPane.showMessageDialog(null, "Order Failed, Check First Name, Check Surname,Check Ticket No, Check Quantity");
							
// The above if statement is used if the order fails, this may be because the name is wrong or ticket number is wrong, it could also be if they exceed 100 food items.
				}
				
			}
		});
		
	}
	public int getTotal() {
		return total+total1+total2+total3+total4+total5+total6+total7+total8+total9+total10+total11;
	}
// The above return is needed so that when all the food items are combined they do not exceed 100.
	public void updateTotal() {
		double total = 0;
		total += foodTotal[0]*MacAndCheese.getPrice();
		total += foodTotal[1]*FriedWings.getPrice();
		total += foodTotal[2]*Burritos.getPrice();
		total += foodTotal[3]*FishAndChips.getPrice();
		total += foodTotal[4]*Pizza.getPrice();
		total += foodTotal[5]*Sushi.getPrice();
		total += foodTotal[6]*LambChops.getPrice();
		total += foodTotal[7]*Steak.getPrice();
		total += foodTotal[8]*ChickenBurger.getPrice();
		total += foodTotal[9]*Spaghetti.getPrice();
		total += foodTotal[10]*ShephardsPie.getPrice();
		total += foodTotal[11]*Lasagne.getPrice();
		textField_1.setText(String.valueOf(total));
	}
}
