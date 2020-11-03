package tool;

import java.util.Date;

public class Tool {
	
	public static String AutoCreateID(String characters) {
		 Date dNow = new Date( );
		  @SuppressWarnings("deprecation")
		  int Random= dNow.getDate()+dNow.getMonth()+dNow.getYear()+dNow.getSeconds()+dNow.getMinutes()+dNow.getHours();		 
	 return characters+Random;
	}
	
}
