//it's better to use "Commons Validator" for simple and fast regular expression
//https://commons.apache.org/proper/commons-validator/

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {

		String regex = "h";
		String input = "hello world hello world hello world";
		
		
		//first method
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(input);
		Boolean result = matcher.matches();
		
		
		/*
		//second method
		boolean result = Pattern.matches(regex, input);
		*/
		
		System.out.println(result);

		//to get how many group containt the regex
		System.out.println(matcher.groupCount() + " groups used in this regex");
		
		//to specify the bounds of match
		matcher.region(2, 26);
		
		//to get all founded matcher
		while(matcher.find())
			System.out.println("the input ==> '" + matcher.group() + "' founded between " + matcher.start() + " and " + matcher.end());
	}

}