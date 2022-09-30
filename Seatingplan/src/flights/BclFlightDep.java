package flights;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JTable.PrintMode;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.UIManager;
import javax.swing.JTextArea;

public class BclFlightDep extends JFrame {
	
	
	private JPanel contentPane;
	private JTable BCL;
	private JButton btnNewButton;
	private JTable YYZ;
	private JButton btnGru;
	private JButton btnDfw;
	private JButton btnLvs;
	private JButton btnMex;
	private JButton btnDub;
	private JButton btnMad;
	private JButton btnLis;
	private JButton btnCdg;
	private JButton btnAms;
	private JButton btnArn;
	private JButton btnSvo;
	private JButton btnFco;
	private JButton btnAth;
	private JButton btnRak;
	private JButton btnCai;
	private JButton btnLos;
	private JButton btnJnb;
	private JButton btnDxb;
	private JButton btnDel;
	private JButton btnBkk;
	private JButton btnHkg;
	private JButton btnHnd;
	private JButton btnSyd;
	private JTable DFW;
	private JTextField txtDepartures;
	private JTextField txtDelays;
	private JTextField txtBrunelCityAirport;
	private String a;
	private String flightNo;
	private String depAirport;
	private String depCity;
	private String arrAirport;
	private String arrCity;
	private String depTime;
	private String arrTime;
	private String airline;
	private int delay;
	private String newarrTime;
	private String flightDate;
	private String b;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[]args) throws ParseException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BclFlightDep frame = new BclFlightDep();
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
	 
	static ArrayList<Flight> allFlights = new ArrayList <Flight>();	
	private JTextArea delays;
	
		//importing the csv file and assigning columns
		
		{ 
			try
			{
				File myObj = new File("Flights.csv");
				Scanner myReader = new Scanner(myObj);
				
				while (myReader.hasNextLine())
				{
					String[] flightData = myReader.nextLine().split(",");
					Flight flight = new Flight();
					flight.setflightNo(flightData[10]);
					
					Flight depAirport = new Flight();
					flight.setdepAirport(flightData[6]);
					
					Flight depCity = new Flight();
					flight.setdepCity(flightData[7]);
					
					Flight arrAirport = new Flight();
					flight.setarrAirport(flightData[8]);
					
					Flight arrCity = new Flight();
					flight.setarrCity(flightData[9]);
					
					Flight depTime = new Flight();
					flight.setdepTime(flightData[1]);
					
					Flight arrTime = new Flight();
					flight.setarrTime(flightData[2]);
					
					Flight airline = new Flight();
					flight.setairline(flightData[11]);
					
					Flight delay = new Flight();
					flight.setdelay(flightData[5]);
					
					Flight flightDate = new Flight();
					flight.setflightDate(flightData[0]);
					
					// adding data to the arraylist
					
					
					allFlights.add(flight);
					allFlights.add(depAirport);
					allFlights.add(depCity);
					allFlights.add(arrAirport);
					allFlights.add(arrCity);
					allFlights.add(depTime);
					allFlights.add(arrTime);
					allFlights.add(airline);
					allFlights.add(delay);
					allFlights.add(flightDate);
					
					
				}
				myReader.close();
				
				//Object[] aobjArray = allFlights.toArray();
		         
			     // System.out.println( Arrays.toString(aobjArray) );
				
		
	    	//allFlights.toArray();
				
				//String[][] allFlights.toArray(<Flight> allFlights) {
					
			//	}
				
				
			
			}
		catch (FileNotFoundException e)
		{
			System.out.println("file not found");
			e.printStackTrace();
			
			
			
		
	    }
	        //filtering the flights to match the departure airport
		}
	public void filterflights(String airportcode, JTextArea airports)  {
		
   	 int k=0;
   	 //for (k=0; k < allFlights.size(); k++);
   	 
		    int row = 20, col = 8;
		    String[][] flightArray = new String[row][col];{
		     for(int i = 0 ; i < row; i++) {
		         for(int j = 0; j < col; j++) {
            
           	         flightArray[i][j] = allFlights.get(k).getdepTime();
		             flightArray[i][j] = allFlights.get(k).getarrTime();
		             flightArray[i][j] = allFlights.get(k).getdepAirport();
		             flightArray[i][j] = allFlights.get(k).getarrAirport();
		             flightArray[i][j] = allFlights.get(k).getflightNo();
		             flightArray[i][j] = allFlights.get(k).getairline();
		             flightArray[i][j] = allFlights.get(k).getdelay();
		            
		            b =  (allFlights.get(k).getdepTime() + "," + allFlights.get(k).getarrTime()+ "," + allFlights.get(k).getdepAirport() + "," + allFlights.get(k).getarrAirport() + "," + allFlights.get(k).getflightNo() + "," + allFlights.get(k).getairline()+ "," + allFlights.get(k).getdelay()+ "," + "\n");
		          
		            if (allFlights.get(k).getdepAirport().equals(airportcode))
		              	  a = (allFlights.get(k).getdepTime() + "," + allFlights.get(k).getarrTime()+ "," + allFlights.get(k).getdepAirport() + "," + allFlights.get(k).getarrAirport() + "," + allFlights.get(k).getflightNo() + "," + allFlights.get(k).getairline()+ "\n");
		                airports.append(a);
		                  
		                k++;
		                 if(k > allFlights.size()) {
		                     break;
		                 }
		        // }
		     }
		     //for(int i = 0 ; i < row; i++) {
		         for(int j = 0; j < col; j++) {

		           // System.out.println(flightArray[i][j] );
		         }
		     }
		    }
		    }
	//}
		    
	
	
	 //String value = bclflights.arrayFlight[index];
	
	//Object[] array = allFlights.toArray();{
	
		// Object[] arrayFlight = allFlights.toArray();
         
	     //   System.out.println( Arrays.toString(arrayFlight) );
		
	      /// 
	      //  for(Object o : arrayFlight) {
	       //     String s = (String) o;
	             
	         //   System.out.println(s);
	// }
	//}
	 
	//windowbuilder design
	
	public BclFlightDep() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1612, 1040);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		 
		 JTextArea airports = new JTextArea();
		
		 airports.setLineWrap(true);
		 airports.setFont(new Font("Courier New", Font.BOLD, 15));
		 airports.setWrapStyleWord(true);
		// airports = new JTextArea();
		 airports.setEditable(false);
		 airports.append(a);
		 airports.setBackground(Color.WHITE);
		 airports.setBounds(10, 266, 295, 470);
 		contentPane.add(airports, BorderLayout.CENTER);
 		
 		
 		JTextArea delays = new JTextArea();
		delays.setBounds(1291, 265, 295, 470);
		contentPane.add(delays);
		delays.setEditable(false);
		delays.setFont(new Font("Courier New", Font.BOLD, 15));
		if (delay > 30);
		delays.append(b);
 		
 		
			
		 btnSyd = new JButton("SYD");
		 btnSyd.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
			         filterflights("SYD", airports);
			         
			        
				 //		Deptab.setSelectedIndex(24);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		airports.setText(null);
			 	}
		 });
		 btnSyd.setForeground(Color.RED);
		 btnSyd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnSyd.setBorder(null);
		 btnSyd.setBackground(Color.LIGHT_GRAY);
		 btnSyd.setBounds(1145, 618, 22, 18);
		 contentPane.add(btnSyd);
		 
		 btnHnd = new JButton("HND");
		 btnHnd.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("HND", airports);
				 
				// int row = 26, col = 6;
				// for(int i = 0 ; i < row; i++) {
			     //    for(int j = 0; j < col; j++) {

			         //  airports.setText(a);
			     //    }
			//	 }
			     
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnHnd.setForeground(Color.RED);
		 btnHnd.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnHnd.setBorder(null);
		 btnHnd.setBackground(Color.LIGHT_GRAY);
		 btnHnd.setBounds(1145, 400, 22, 18);
		 contentPane.add(btnHnd);
		 
		 btnHkg = new JButton("HKG");
		 btnHkg.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("HKG", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnHkg.setForeground(Color.RED);
		 btnHkg.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnHkg.setBorder(null);
		 btnHkg.setBackground(Color.LIGHT_GRAY);
		 btnHkg.setBounds(1087, 451, 22, 18);
		 contentPane.add(btnHkg);
		 
		 btnBkk = new JButton("BKK");
		 btnBkk.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("BKK", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnBkk.setForeground(Color.RED);
		 btnBkk.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnBkk.setBorder(null);
		 btnBkk.setBackground(Color.LIGHT_GRAY);
		 btnBkk.setBounds(1050, 475, 22, 18);
		 contentPane.add(btnBkk);
		 
		 btnDel = new JButton("DEL");
		 btnDel.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("DEL", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnDel.setForeground(Color.RED);
		 btnDel.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnDel.setBorder(null);
		 btnDel.setBackground(Color.LIGHT_GRAY);
		 btnDel.setBounds(982, 454, 22, 18);
		 contentPane.add(btnDel);
		 
		 btnDxb = new JButton("DXB");
		 btnDxb.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("DXB", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnDxb.setForeground(Color.RED);
		 btnDxb.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnDxb.setBorder(null);
		 btnDxb.setBackground(Color.LIGHT_GRAY);
		 btnDxb.setBounds(894, 451, 22, 18);
		 contentPane.add(btnDxb);
		 
		 btnJnb = new JButton("JNB");
		 btnJnb.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("JNB", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnJnb.setForeground(Color.RED);
		 btnJnb.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnJnb.setBorder(null);
		 btnJnb.setBackground(Color.LIGHT_GRAY);
		 btnJnb.setBounds(830, 618, 22, 18);
		 contentPane.add(btnJnb);
		 
		 btnLos = new JButton("LOS");
		 btnLos.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("LOS", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnLos.setForeground(Color.RED);
		 btnLos.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnLos.setBorder(null);
		 btnLos.setBackground(Color.LIGHT_GRAY);
		 btnLos.setBounds(764, 500, 22, 18);
		 contentPane.add(btnLos);
		 
		 btnCai = new JButton("CAI");
		 btnCai.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("CAI", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnCai.setForeground(Color.RED);
		 btnCai.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnCai.setBorder(null);
		 btnCai.setBackground(Color.LIGHT_GRAY);
		 btnCai.setBounds(830, 439, 22, 18);
		 contentPane.add(btnCai);
		 
		 btnRak = new JButton("RAK");
		 btnRak.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 filterflights("RAK", airports);
		 	}
		 });
		 btnRak.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
			 		
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnRak.setForeground(Color.RED);
		 btnRak.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnRak.setBorder(null);
		 btnRak.setBackground(Color.LIGHT_GRAY);
		 btnRak.setBounds(721, 429, 22, 18);
		 contentPane.add(btnRak);
		 
		 btnAth = new JButton("ATH");
		 btnAth.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("ATH", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnAth.setForeground(Color.RED);
		 btnAth.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnAth.setBorder(null);
		 btnAth.setBackground(Color.LIGHT_GRAY);
		 btnAth.setBounds(808, 414, 22, 18);
		 contentPane.add(btnAth);
		 
		 btnFco = new JButton("FCO");
		 btnFco.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("FCO", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnFco.setForeground(Color.RED);
		 btnFco.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnFco.setBorder(null);
		 btnFco.setBackground(Color.LIGHT_GRAY);
		 btnFco.setBounds(788, 400, 22, 18);
		 contentPane.add(btnFco);
		 
		 btnSvo = new JButton("SVO");
		 btnSvo.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("SVO", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnSvo.setForeground(Color.RED);
		 btnSvo.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnSvo.setBorder(null);
		 btnSvo.setBackground(Color.LIGHT_GRAY);
		 btnSvo.setBounds(860, 344, 22, 18);
		 contentPane.add(btnSvo);
		 
		 btnArn = new JButton("ARN");
		 btnArn.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("ARN", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnArn.setForeground(Color.RED);
		 btnArn.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnArn.setBorder(null);
		 btnArn.setBackground(Color.LIGHT_GRAY);
		 btnArn.setBounds(788, 326, 22, 18);
		 contentPane.add(btnArn);
		 
		 btnAms = new JButton("AMS");
		 btnAms.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("AMS", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnAms.setForeground(Color.RED);
		 btnAms.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnAms.setBorder(null);
		 btnAms.setBackground(Color.LIGHT_GRAY);
		 btnAms.setBounds(764, 358, 22, 18);
		 contentPane.add(btnAms);
		 
		 btnCdg = new JButton("CDG");
		 btnCdg.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		 
		 	}
		 });
		 btnCdg.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("CDG", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnCdg.setForeground(Color.RED);
		 btnCdg.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnCdg.setBorder(null);
		 btnCdg.setBackground(Color.LIGHT_GRAY);
		 btnCdg.setBounds(743, 376, 22, 18);
		 contentPane.add(btnCdg);
		 
		 btnLis = new JButton("LIS");
		 btnLis.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnLis.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("LIS", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnLis.setForeground(Color.RED);
		 btnLis.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnLis.setBorder(null);
		 btnLis.setBackground(Color.LIGHT_GRAY);
		 btnLis.setBounds(711, 400, 22, 18);
		 contentPane.add(btnLis);
		 
		 btnMad = new JButton("MAD");
		 btnMad.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnMad.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("MAD", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnMad.setForeground(Color.RED);
		 btnMad.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnMad.setBorder(null);
		 btnMad.setBackground(Color.LIGHT_GRAY);
		 btnMad.setBounds(743, 400, 22, 18);
		 contentPane.add(btnMad);
		 
		 btnDub = new JButton("DUB");
		 btnDub.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnDub.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("DUB", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		
		 
		 btnDub.setForeground(Color.RED);
		 btnDub.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnDub.setBorder(null);
		 btnDub.setBackground(Color.LIGHT_GRAY);
		 btnDub.setBounds(721, 358, 22, 18);
		 contentPane.add(btnDub);
		 
		 btnMex = new JButton("MEX");
		 btnMex.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("MEX", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnMex.setForeground(Color.RED);
		 btnMex.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnMex.setBorder(null);
		 btnMex.setBackground(Color.LIGHT_GRAY);
		 btnMex.setBounds(428, 454, 22, 18);
		 contentPane.add(btnMex);
		 
		 btnLvs = new JButton("LVS");
		 btnLvs.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseEntered(MouseEvent e) {
		 		filterflights("LVS", airports);
		 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		
		 	}
		 });
		 btnLvs.setForeground(Color.RED);
		 btnLvs.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnLvs.setBorder(null);
		 btnLvs.setBackground(Color.LIGHT_GRAY);
		 btnLvs.setBounds(398, 403, 22, 18);
		 contentPane.add(btnLvs);
		 
		 btnDfw = new JButton("DFW");
		 btnDfw.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("DFW", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnDfw.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnDfw.setForeground(Color.RED);
		 btnDfw.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnDfw.setBorder(null);
		 btnDfw.setBackground(Color.LIGHT_GRAY);
		 btnDfw.setBounds(457, 417, 22, 18);
		 contentPane.add(btnDfw);
		 
		 btnGru = new JButton("GRU");
		 btnGru.addMouseListener(new MouseAdapter() {
			 @Override
			 	public void mouseEntered(MouseEvent e) {
				 filterflights("GRU", airports);
			 	}
			 	@Override
			 	public void mouseExited(MouseEvent e) {
			 		
			 	}
		 });
		 btnGru.setForeground(Color.RED);
		 btnGru.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnGru.setBorder(null);
		 btnGru.setBackground(Color.LIGHT_GRAY);
		 btnGru.setBounds(599, 593, 22, 18);
		 contentPane.add(btnGru);
		 

		
			
		 JButton btnYYZ = new JButton("YYZ");
		 btnYYZ.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnYYZ.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseEntered(MouseEvent e){
		 		filterflights("YYZ", airports);
		 	
		 	}
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 			
		 	}
		 });
		 btnYYZ.setForeground(Color.RED);
		 btnYYZ.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnYYZ.setBorder(null);
		 btnYYZ.setBackground(Color.LIGHT_GRAY);
		 btnYYZ.setBounds(510, 361, 22, 18);
		 contentPane.add(btnYYZ);
		 
		//table.setVisible(false);
		
		
		 btnNewButton = new JButton("BCL");
		 btnNewButton.setForeground(Color.RED);
		 btnNewButton.setBackground(Color.LIGHT_GRAY);
		 btnNewButton.setBorder(null);
		 btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 8));
		 btnNewButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 	}
		 });
		 btnNewButton.addMouseListener(new MouseAdapter() {
		 	@Override
		 public void mouseEntered(MouseEvent e) {
		 		filterflights("BCL", airports);
		 		
		 	}
		 	
		 
		 	@Override
		 	public void mouseExited(MouseEvent e) {
		 		
		 	}
		 });
		 btnNewButton.setBounds(743, 347, 22, 18);
		 contentPane.add(btnNewButton);
		
	
	
	
    
		
		//	Deptab.addTab("BCL", null, BCL, null);
		//	Deptab.setEnabledAt(50, true);
		
		 
			 DefaultTableModel dftModel = new DefaultTableModel();
				
			 
			    
				 BCL = new JTable();
				
				dftModel.addColumn("Flights");
				BCL.setModel(dftModel);
				
				dftModel.setRowCount(0);
			
			//String col[] = {"flightDate","depTime","arrTime","depCity", "arrCity", "Flno", "airline"};

			//DefaultTableModel tableModel = new DefaultTableModel(col, 0);
			                                            // The 0 argument is number rows.JTable table = new JTable(tableModel);
		
			//JTable YYZ = new JTable(tableModel);
			
			
			
			
			
			
		ImageIcon image = new ImageIcon(this.getClass().getResource("brunelmap.png"));
		contentPane.setLayout(null);
		//JFKtab.setVisible(false);
		JButton btnJFK = new JButton("JFK");
		btnJFK.setBackground(Color.LIGHT_GRAY);
		btnJFK.setForeground(Color.RED);
		btnJFK.setBorder(null);
		btnJFK.setFont(new Font("Tahoma", Font.PLAIN, 8));
		btnJFK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnJFK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				filterflights("JFK", airports);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				
			}
		});
		btnJFK.setBounds(526, 403, 22, 18);
		contentPane.add(btnJFK);
		JLabel lblNewLabel = new JLabel(image);
		lblNewLabel.setBounds(10, 5, 1581, 991);
		contentPane.add(lblNewLabel);
		
		txtDepartures = new JTextField();
		txtDepartures.setBorder(null);
		txtDepartures.setEditable(false);
		txtDepartures.setHorizontalAlignment(SwingConstants.CENTER);
		txtDepartures.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtDepartures.setText("DEPARTURES");
		txtDepartures.setBounds(5, 222, 279, 33);
		contentPane.add(txtDepartures);
		txtDepartures.setColumns(10);
		
		txtDelays = new JTextField();
		txtDelays.setBorder(null);
		txtDelays.setEditable(false);
		txtDelays.setText("DELAYS");
		txtDelays.setHorizontalAlignment(SwingConstants.CENTER);
		txtDelays.setFont(new Font("Segoe UI", Font.BOLD, 20));
		txtDelays.setColumns(10);
		txtDelays.setBounds(1281, 222, 305, 33);
		contentPane.add(txtDelays);
		
		txtBrunelCityAirport = new JTextField();
		txtBrunelCityAirport.setForeground(new Color(30, 144, 255));
		txtBrunelCityAirport.setBorder(null);
		txtBrunelCityAirport.setHorizontalAlignment(SwingConstants.CENTER);
		txtBrunelCityAirport.setFont(new Font("Segoe UI", Font.BOLD, 45));
		txtBrunelCityAirport.setText("Brunel City Airport");
		txtBrunelCityAirport.setEditable(false);
		txtBrunelCityAirport.setBounds(398, 41, 788, 115);
		contentPane.add(txtBrunelCityAirport);
		txtBrunelCityAirport.setColumns(10);
		
		

	}
	}			     			     
					    
			   
    
    

	
	
	

