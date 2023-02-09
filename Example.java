import java.lang.System;
import java.lang.Character;
import java.lang.String;
import java.lang.StringBuilder;

public class Example {
	private String lastName = null;

	public static void main(String[] args) {
		Example main = new Example();
		main.helloWorld("world",false);
		return;
	}

	public void helloWorld(String name,boolean savelast) {
		String copyOfName;
		if ( name == null && lastName == null ) {
			copyOfName = "World";
		} else if ( name == null ) {
			copyOfName = lastName;
		} else if ( Character.isLowerCase(name.charAt(0)) ) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append(Character.toUpperCase(name.charAt(0)));
			stringBuilder.append(name.substring(1));
			copyOfName = stringBuilder.toString();
		} else {
			copyOfName = new String(name);
		}
		System.out.printf("Hello, %s!\n",copyOfName);
		if ( savelast ) {
			lastName = copyOfName;
		}
	}
}