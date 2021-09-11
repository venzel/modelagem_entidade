package app.domain.user.types;

import app.domain.user.types.errors.PasswordTypeError;
import app.utils.Either;

public class Password {
	private String password;
	
	public Password(String password) {
		this.password = password;
	}
	
	public static Either<PasswordTypeError, Password> create(String password) {
		if (!validate(password)) {
			return Either.ofLeft(new PasswordTypeError(password));
		}
		
		return Either.ofRight(new Password(password));
	}
	
	public String get() {
		return this.password;
	}
	
	public void set(String password) {
		this.password = password;
	}

	public static boolean validate(String password) {
        if (password.isBlank()) {
            return false;
        }

        if (password.length() <= 5 || password.length() > 8) {
            return false;
        }
        
		return true;
	}
}
