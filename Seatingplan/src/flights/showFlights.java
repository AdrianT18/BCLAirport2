package flights;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import java.util.Arrays;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class showFlights extends JFrame {

	private JPanel contentPane; //initialising the panels and tables
	private JTable table;
	private JTable table2;

	public showFlights() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1081, 721);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);//sets the panel layout as border layout
		
		table = new JTable();//creating new table

		
		String[] split_table = Arrays.toString(flightArray.filteredDepFlights).split(", "); //splitting the filtered flights array
		table.setModel(new DefaultTableModel( //appending the filtered flights array to the table
			new Object[][] { 
				{split_table[0], split_table[1], split_table[2], split_table[3], split_table[4], split_table[5], split_table[6], split_table[7], split_table[8], split_table[9], split_table[10], split_table[11]},
			},
			new String[] { //setting column names for the table
				"Date Of Flight", "Departure Time", "Arrival Time", "Flight Duration", "Distance(miles)", "Delay(mins)", "Departure Airport", "Departure City", "Arrival Airport", "Arrrival City", "Flight Number", "Airline"
			}
		));
		
		
		JScrollPane test = new JScrollPane(table); //adding a scroll bar to the panel
		panel.add(test);
		
		
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		for(int i=0;i<12;i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(100); //setting the column width for the table
		}
		
		table2 = new JTable();
		
		String[] split_table2 = Arrays.toString(flightArray.filteredArrFlights).split(", ");
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{split_table2[0], split_table2[1], split_table2[2], split_table2[3], split_table2[4], split_table2[5], split_table2[6], split_table2[7], split_table2[8], split_table2[9], split_table2[10], split_table2[11]},
			},
			new String[] {
				"Date Of Flight", "Departure Time", "Arrival Time", "Flight Duration", "Distance(miles)", "Delay(mins)", "Departure Airport", "Departure City", "Arrival Airport", "Arrrival City", "Flight Number", "Airline"
			}
		));
		
		JScrollPane test2 = new JScrollPane(table2);
		panel.add(test2);
		
		table2.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		JLabel lblNewLabel = new JLabel("BRUNEL CITY AIRPORT");
		lblNewLabel.setForeground(SystemColor.textHighlight);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Elephant", Font.PLAIN, 60));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("Go Back"); //allowing the user to return to the previous frame
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							flightGUI frame = new flightGUI();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("The Bold Font", Font.PLAIN, 20));
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("Available Departure Flights");
		lblNewLabel_1.setForeground(SystemColor.textHighlight);
		lblNewLabel_1.setFont(new Font("The Bold Font", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Select Flights");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				flightArray.selectedDepFlight=((flightArray.selectedDepFlight)+(Arrays.toString(flightArray.filteredDepFlights)));
				flightArray.selectedArrFlight=((flightArray.selectedArrFlight)+(Arrays.toString(flightArray.filteredArrFlights)));
				//System.out.println(flightArray.selectedDepFlight);
				//System.out.println(flightArray.selectedArrFlight);
				System.out.println(Arrays.toString(flightArray.filteredDepFlights));
				dispose();
				try {
					
					Main main = new Main();
					//frame frame2 = new frame();
					main.setVisible(true);
					//frame2.setVisible(true);
				} catch (Exception e1) {
					e1.printStackTrace();
					
				}
			}
		});
		btnNewButton.setFont(new Font("The Bold Font", Font.PLAIN, 22));
		panel_1.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("Available Return Flights");
		lblNewLabel_3.setForeground(SystemColor.textHighlight);
		lblNewLabel_3.setFont(new Font("The Bold Font", Font.PLAIN, 22));
		panel_1.add(lblNewLabel_3);
		for(int i=0;i<12;i++) {
			table2.getColumnModel().getColumn(i).setPreferredWidth(100);
		}
		
	}
}

	