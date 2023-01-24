package game.console;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class InputController {

	public static String readString() {
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader inputReader = new BufferedReader(input);
		try {
			return inputReader.readLine();
		} catch (IOException e) {
			System.err.println("Error while reading user input");
			return "";
		}
	}
}
