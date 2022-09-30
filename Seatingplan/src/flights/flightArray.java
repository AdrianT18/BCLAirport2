package flights;
import java.awt.EventQueue; //module for responding to events
import java.time.format.DateTimeFormatter; //module for formatting the date
import java.time.LocalDateTime;    //module for importing current date
import java.text.SimpleDateFormat; //module for formatting the date
import java.io.BufferedReader; //module for reading the csv file
import java.io.FileReader; //module for reading the csv file
import java.io.IOException; //module for handling exceptions
import java.text.ParseException; //module for parsing values
import java.util.List; //module for creating lists
import java.util.ArrayList; //module for creating arraylists
import java.util.Date; //module for using date variables
public class flightArray {
	static int rows = 0; //initialising variable and arrays as global
	static int cols = 0;
	static int len = 0;
	static Date arrDateAsDate = null;
	static Date todayDateAsDate = null;
	static Date depDateAsDate = null;
	public static String[][] flightData; //initialising 2d array
	static String[] filteredDepFlights;
	static String[] filteredArrFlights;
	public static String selectedDepFlight;
	public static String selectedArrFlight;
	
	public static void flightsArray()throws IOException {
		String line = "";
	    int len;
	    List<String[]> lines = new ArrayList<String[]>();
	    //parsing a CSV file into BufferedReader class constructor 
	    BufferedReader br = new BufferedReader(new FileReader("Flights.csv"));
	    while ((line = br.readLine()) != null) 
	    {
	    	lines.add(line.split(","));
	    	//use comma as separator  
	    }
	    len=lines.size();
	    flightData = new String[len][0];
	    lines.toArray(flightData);
	    rows = flightData.length;
	    cols = flightData[0].length;
	    br.close();
	}
	
	
	 static String depCity,depDate,arrCity,arrDate,value;

	public static boolean userInputs() {
		/*if ((depCity.length()==0||(arrCity.length())==0)||(depDate.length()==0)||(arrDate.length()==0)) {
			validation = false;
		}*/
    	boolean checker = checkIfExists(depCity);
    	boolean validation = true;
    	if (checker==true) {
			System.out.println("Value accepted"); 		
		}
		else {
			validation = false;
		}
    	
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy"); 
		LocalDateTime now = LocalDateTime.now(); 
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		try {
			depDateAsDate = sdf.parse(depDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			todayDateAsDate = sdf.parse(dtf.format(now));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			arrDateAsDate = sdf.parse(arrDate);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	    checker = checkIfExists(depDate);
    	if (checker==true) {
			
		}
		else {
			validation = false;
		}
    	
	    checker = checkIfExists(arrCity);
    	if (checker==true) {
			System.out.println("Value accepted"); 

			if ((depCity.equals(arrCity))==true) {
				errorMessage frame = new errorMessage();
				frame.setVisible(true);
				validation = false;	
			}
			else {
				validation = true;
			}
		}
		else {
			validation = false;
		}
			
	    checker = checkIfExists(arrDate);
    	if (checker==true) {
			if (((arrDateAsDate.before(depDateAsDate))==true)||(depDateAsDate.before(todayDateAsDate)==true)){
				errorMessage frame = new errorMessage();
				frame.setVisible(true);
				validation = false;			
			}
			else {
				validation = true;
			}
    	}
			
		else {
			validation = false;
			}
  
    	return validation;
    	}
	
	public static boolean checkIfExists(String value) { 
		for (int i=0;i<(rows);i++) {
			for(int j=0;j<(cols);j++){
				if ((flightData[i][j]).equals(value)) {
					System.out.println("value found");
					return true;
				}
				else {
				}
			}
		}
		System.out.println("Value not found");
		return false;
		
	}
	
	
	public static String[] searchDepFlights() {
		for (int i=0;i<(rows);i++) {
			if (((flightData[i][9].equals(arrCity)) && (flightData[i][7].equals(depCity))) && (((flightData[i][0].equals(depDate)) && (flightData[i][7].equals(depCity))))){
				return flightData[i];
			}
		}
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
		return null;
	}

	public static String[] searchArrFlights() {
		for (int i=0;i<(rows);i++) {
			if (((flightData[i][7].equals(arrCity)) && (flightData[i][9].equals(depCity))) && (((flightData[i][0].equals(arrDate)) && (flightData[i][7].equals(arrCity))))){
				return flightData[i];
			}
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					errorMessage frame = new errorMessage(); //outputs the error message
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		return null;
	}
		
	public static void main(String[] args) throws IOException{
	    flightsArray(); //runs the flights array method
	    
	    EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					flightGUI frame = new flightGUI(); //runs the first frame
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	    }
	
}
