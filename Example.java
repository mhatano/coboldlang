import java.lang.System;
import java.lang.Character;
import java.lang.String;
import java.lang.StringBuilder;
import java.util.function.Supplier;

public class Example {
	private String lastName = null;

	public static void main(String[] args) {
		Example main = new Example();
		main.helloWorld("world",false);
		return;
	}

	public void helloWorld(String name,boolean savelast) {
		Supplier<String> supplierCopyOfName = () -> {
			if ( name == null && lastName == null ) {
				return "World";
			} else if ( name == null ) {
				return lastName;
			} else if ( Character.isLowerCase(name.charAt(0)) ) {
				StringBuilder stringBuilder = new StringBuilder();
				stringBuilder.append(Character.toUpperCase(name.charAt(0)));
				stringBuilder.append(name.substring(1));
				return stringBuilder.toString();
			}
			return new String(name);
		};
		String copyOfName = supplierCopyOfName.get();
		System.out.printf("Hello, %s!\n",copyOfName);
		if ( savelast ) {
			lastName = copyOfName;
		}
	}
}