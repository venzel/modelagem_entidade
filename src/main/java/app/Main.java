package app;

import java.util.List;

import app.domain.user.User;
import app.domain.user.types.errors.UserTypeError;
import app.utils.Either;

public class Main {
	public static void main(String[] args) {
		
		Either<List<UserTypeError>, User> user = User.create("TiagoRizzo", "@gmail.com", "ti123");
		
		if (user.isRight()) {
			System.out.println(user.right().get().getName());
			System.out.println(user.right().get().getEmail());
			System.out.println(user.right().get().getPassword());
		} else {
			user.left().get().forEach(e -> System.out.println(e.getMessage()));
		}
	}
}
