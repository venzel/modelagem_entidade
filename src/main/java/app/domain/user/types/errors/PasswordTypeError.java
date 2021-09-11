package app.domain.user.types.errors;

public class PasswordTypeError implements UserTypeError {	
	private String password;

	public PasswordTypeError(String password) {
		this.password = password;
	}
	
	@Override
	public String getMessage() {
		return String.format("password %s ivalid!", password);
	}
}