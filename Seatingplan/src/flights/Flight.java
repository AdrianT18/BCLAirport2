package flights;

import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.table.DefaultTableModel;

    public class Flight 
    {

	
	private String flightNo;
	private String depAirport;
	private String depCity;
	private String arrAirport;
	private String arrCity;
	private String depTime;
	private String arrTime;
	private String airline;
	private String delay;
	private String newarrTime;
	private String flightDate;
	
	
	
	
	
   // getters and setters for the variables
	
	public void setflightNo(String flightNo)
	{
		this.flightNo = flightNo;
		
		//System.out.println(flightNo);
	}
     
	public String getflightNo()
	{
		return flightNo;
	}
	
	
	public void setdepAirport(String depAirport)
	{
		this.depAirport = depAirport;
		//if (depAirport= "YYZ");{
			
		
		
		//System.out.println(depAirport);
	}
	
	public String getdepAirport()
	{
		
	
		return depAirport;
	
	}
	public void setdepCity(String depCity)
	{
		this.depCity = depCity;
		
		//System.out.println(depCity);
	}
     
	public String getdepCity()
	{
		return depCity;
	}
	
	
	public void setarrAirport(String arrAirport)
	{
		this.arrAirport = arrAirport;
		
		//System.out.println(arrAirport);
	}
     
	public String getarrAirport()
	{
		return arrAirport;
	}
	
	
	
	public void setarrCity(String arrCity)
	{
		this.arrCity = arrCity;
		
		//System.out.println(arrCity);
	}
     
	public String getarrCity()
	{
		return arrCity;
	}
	
	
	
	public void setdepTime(String depTime)
	{
		this.depTime = depTime;
		
		//System.out.println(depTime);
	}
     
	public String getdepTime()
	{
		return depTime;
	}
	
	
	
	public void setarrTime(String arrTime)
	{
		this.arrTime = arrTime;
		
		//System.out.println(arrTime);
	}
     
	public String getarrTime()
	{
		return arrTime;
	}
	
	
	
	public void setairline(String airline)
	{
		this.airline = airline;
		
		//System.out.println(airline);
	}
	
	public String getairline()
	{
		return airline;
	}
	
	
	
	public void setdelay(String delay)
	{
		this.delay = delay;
		
		//System.out.println(delay);
	}
	public String getdelay()
	{
		return delay;
	}
	
	
	
	public void setnewarrTime(String newarrTime)
	{
		newarrTime = arrTime + delay;
		
		this.newarrTime = newarrTime;
		
		//System.out.println(newarrTime);
	}
	public String getnewarrTime()
	{
		return newarrTime;
	}
	
	
	
	
	public void setflightDate(String flightDate)
	{
		this.flightDate = flightDate;
		
		//System.out.println(flightDate);
		
		//System.out.println(depTime + "," + arrTime + "," + depAirport + "," + arrAirport + "," + flightNo + "," + airline);
	}	
		public String flightDate()
	{
			return flightDate;
	}
	
		
		//if (depAirport.equals("BCL"))  {
			
		
		
		//
	
		


		
		
	
    }
    
    
 
	//@Override
	//public String toString() {
		
	//	return depTime;
		
	//}
	
   // }
	

