package app.domain.user.types.errors;

public class EmailTypeError implements UserTypeError {	
	private String email;

	public EmailTypeError(String email) {
		this.email = email;
	}
	
	@Override
	public String getMessage() {
		return String.format("email %s ivalid!", email);
	}
}