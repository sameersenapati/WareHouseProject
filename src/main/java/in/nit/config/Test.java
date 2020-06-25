package in.nit.config;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class Test {

	public static void main(String[] args) {
		String input="NIT";
		BCryptPasswordEncoder  encoder = new BCryptPasswordEncoder();
		String  enc= encoder.encode(input);
		System.out.println(enc);
	}

}//class
