package app.domain.user.types.errors;

public class NameTypeError implements UserTypeError {
	private String name;

	public NameTypeError(String name) {
		this.name = name;
	}
	
	@Override
	public String getMessage() {
		return String.format("name %s ivalid!", name);
	}
}