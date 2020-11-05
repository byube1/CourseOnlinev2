package tool;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Tool {
	
	public static String AutoCreateID(String characters) {
		 Date dNow = new Date( );
		  @SuppressWarnings("deprecation")
		  int Random= dNow.getDate()+dNow.getMonth()+dNow.getYear()+dNow.getSeconds()+dNow.getMinutes()+dNow.getHours();		 
	 return characters+Random;
	}
	
	public static  String getTimeNow() {
		  Date dNow = new Date( );
	      SimpleDateFormat ft =  new SimpleDateFormat (" dd/MM/yyyy");
	      return ft.format(dNow);
	}
	
}
