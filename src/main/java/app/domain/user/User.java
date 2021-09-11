package app.domain.user;

import java.util.ArrayList;
import java.util.List;

import app.domain.user.types.Email;
import app.domain.user.types.Name;
import app.domain.user.types.Password;
import app.domain.user.types.errors.EmailTypeError;
import app.domain.user.types.errors.NameTypeError;
import app.domain.user.types.errors.PasswordTypeError;
import app.domain.user.types.errors.UserTypeError;
import app.utils.Either;

public class User {
	private Name name;
	private Email email;
	private Password password;

	public User(Name name, Email email, Password password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public static Either<List<UserTypeError>, User> create(String name, String email, String password) {
		Either<NameTypeError, Name> nameOrError = Name.create(name);
		Either<EmailTypeError, Email> emailOrError = Email.create(email);
		Either<PasswordTypeError, Password> passwordOrError = Password.create(password);
		
		boolean nameContainError = nameOrError.isLeft();
		boolean emailContainError = emailOrError.isLeft();
		boolean passwordContainError = passwordOrError.isLeft();		
		
		if (nameContainError || emailContainError || passwordContainError) {			
			List<UserTypeError> errors = new ArrayList<>();
			
			if (nameContainError) errors.add(nameOrError.left().get());	
			if (emailContainError) errors.add(emailOrError.left().get());
			if (passwordContainError) errors.add(passwordOrError.left().get());
			
			return Either.ofLeft(errors);
		}

		Name nameObject = nameOrError.right().get();
		Email emailObject = emailOrError.right().get();
		Password passwordObject = passwordOrError.right().get();

		return Either.ofRight(new User(nameObject, emailObject, passwordObject));
	}

	public String getName() {
		return name.get();
	}
	
	public void setName(String name) {
		this.name.set(name);
	}

	public String getEmail() {
		return email.get();
	}

	public void setEmail(String email) {
		this.email.set(email);
	}

	public String getPassword() {
		return password.get();
	}
	
	public void setPassword(String password) {
		this.password.set(password);
	}
}
