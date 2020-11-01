package validation;

public class valid {
	public static boolean checkformatEmail(String email) {
		if(email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
			return true;
		}
		return false;
	}

}
