package app.domain.user.types;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import app.domain.user.types.errors.EmailTypeError;
import app.utils.Either;

public class Email {
	private String email;
	
	public Email(String email) {
		this.email = email;
	}
	
	public static Either<EmailTypeError, Email> create(String email) {
		if (!validate(email)) {
			return Either.ofLeft(new EmailTypeError(email));
		}
		
		return Either.ofRight(new Email(email));
	}
	
	public String get() {
		return this.email;
	}
	
	public void set(String email) {
		this.email = email;
	}

	public static boolean validate(String email) {
        if (email.isBlank()) {
            return false;
        }

        if (email.length() > 256) {
            return false;
        }
        
        String[] parts = email.split("@");
        
        if (parts.length < 2) {
        	return false;
        }
        
        if (parts[0].length() > 64) {
        	return false;
        }
        
        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        
        Matcher matcher = pattern.matcher(email);
        
        if (!matcher.matches()) {
            return false;
        }
        
        return true;
	}
}
