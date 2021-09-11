package app.domain.user.types;

import app.domain.user.types.errors.NameTypeError;
import app.utils.Either;

public class Name {
	private String name;
	
	public Name(String name) {
		this.name = name;
	}
	
	public static Either<NameTypeError, Name> create(String name) {
		if (!validate(name)) {
			return Either.ofLeft(new NameTypeError(name));
		}
		
		return Either.ofRight(new Name(name));
	}
	
	public String get() {
		return this.name;
	}

	public void set(String name) {
		this.name = name;
	}
	
	public static boolean validate(String name) {
        if (name.isBlank()) {
            return false;
        }

        if (name.length() > 30) {
            return false;
        }
        
        String[] parts = name.split(" ");
        
        if (parts.length < 2 || parts.length > 6) {
        	return false;
        }
        
		return true;
	}
}
