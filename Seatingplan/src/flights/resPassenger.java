package flights;

import java.util.ArrayList;
public class resPassenger {

	public static ArrayList <String> list = new ArrayList<String>();
	public static ArrayList <String> list1 = new ArrayList<String>();
	public static ArrayList <String> list2 = new ArrayList<String>();
	
	
	public static String checkfirstname;
	public static String checksurname;
	public static String checkno;

	public static String checkuser(resPassenger check) {
		
		resPassenger x = new resPassenger();
		x.setFirstName("Aaron");
		x.setSurName("Samuels");
		x.setTicketNo("83746578");
		list.add("Aaron");
		list1.add("Samuels");
		list2.add("83746578");
		
		
		resPassenger y = new resPassenger();
		y.setFirstName("Regina");
		y.setSurName("George");
		y.setTicketNo("27475839");
		list.add("Regina");
		list1.add("George");
		list2.add("27475839");

		resPassenger z = new resPassenger();
		z.setFirstName("Cady");
		z.setSurName("Heron");
		z.setTicketNo("95738494");
		list.add("Cady");
		list1.add("Heron");
		list2.add("95738494");


	System.out.println(checkfirstname);
	System.out.println(checksurname);
	System.out.println(checkno);
	int checkin=0;

for (int i =0;i<list.size();i++) {



		if (checkfirstname.equals(list.get(i))&&checksurname.equals(list1.get(i))&&checkno.equals(list2.get(i))) {
			checkin=1;
			break;
		}else {
			checkin=2;
		}
	}
if (checkin==1)
	return "yes";
else {
	return "no";
}

	}


	public void setFirstName(String string) {
		// TODO Auto-generated method stub

	}

	public void setTicketNo(String string) {
		// TODO Auto-generated method stub

	}

	public void setSurName(String string) {
		// TODO Auto-generated method stub

	}


}
