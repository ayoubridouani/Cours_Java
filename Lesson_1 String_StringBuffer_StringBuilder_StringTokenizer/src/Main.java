public class Main {
	public static void main(String[] args) {
		
		/*
		//to declare a string
		String string1 = "Ayoub"; //is interned (created on stack, and added to a pool of strings)
		
		char[] array_of_string= {'A','y','o','u','b'};
		String string2 = new String(array_of_string);
		
		String string3 = new String(); //is created on the heap and is not interned
		string3 = "Ayoub";
		
		String string4 = new String("Ayoub");
		
		System.out.println(string1 + " " + string2 + " " + string3 + " " + string4);
		
		//string1 != string3 ==> because string1 created on stack, and string3 created on heap 
		String s1 = string3; //s1 is an object
		String s2 = string3.intern(); //s2 is an pool of strings
		*/
		
		/*
		//String
		String string = new String("ayoub");
		System.out.println("length: " + string.length());
		System.out.println("Substring with begin: " + string.substring(2));
		System.out.println("Substring with begin and end: " + string.substring(2, 4));
		System.out.println("index of string in string: " + string.indexOf("you"));
		System.out.println("get character with index: " + string.charAt(0));
		System.out.println("check equality: " + string.equals("AyouB"));
		System.out.println("check equality without case sensive: " + string.equalsIgnoreCase("AyouB"));
		System.out.println("Compare with two string: " + string.compareTo("Ayoub"));
		System.out.println("Compare with string with case sensive: " + string.compareToIgnoreCase("Ayoub"));
		System.out.println("hashcode: " + string.hashCode());
		System.out.println("concatenation: " + string.concat("Ayoub"));
		System.out.println("check if the string contains the string: " + string.contains("Ayoub"));
		System.out.println("the string start with this character ?: " + string.startsWith("Ay"));
		System.out.println("the string end with this character ?: " + string.endsWith("ub"));
		System.out.println("trim: " + string.trim());
		System.out.println("check pattern (regular expression): " + string.matches("[A-Za-z]+"));
		//string to char Array: char[] Array = string.toCharArray();
		System.out.println("to lower case: " + string.toLowerCase());
		System.out.println("to upper case: " + string.toUpperCase());
		System.out.println("to string: " + string.toString());
		System.out.println("is empty: " + string.isEmpty());
		//join strings: String string = String.join("x","y","z");
		//get ascii for every character in string: byte b[] = string.getBytes();
		System.out.println("change an argument to string: " + String.valueOf(10));
		System.out.println("replace one character: " + string.replace('A', 'n'));
		System.out.println("replace string: " + string.replaceAll("ayoub", "ridouani"));
		*/
		
		/*
		//StringBuffer
		StringBuffer string = new StringBuffer("Ayoub");
		System.out.println("length: " + string.length());
		System.out.println("Substring with begin: " + string.substring(2));
		System.out.println("Substring with begin and end: " + string.substring(2, 4));
		System.out.println("index of string in string: " + string.indexOf("you"));
		System.out.println("get character with index: " + string.charAt(0));
		System.out.println("check equality: " + string.equals("AyouB"));
		System.out.println("capacity: " + string.capacity());
		System.out.println("Append string: " + string.append(" Ridouani"));
		System.out.println("hashcode: " + string.hashCode());
		System.out.println("delete from string: " + string.delete(5, 8));
		System.out.println("delete one character from  string: " + string.deleteCharAt(5));
		//replace one character: string.setCharAt(0, 'r');
		System.out.println("reverse string: " + string.reverse());
		//string to char Array: char[] Array = string.toCharArray();
		System.out.println("insert string: " + string.insert(9, "hi hello world"));
		System.out.println("insert string: " + string.insert(5, "we are good", 0, 11));
		//set length: string.setLength(10);
		System.out.println("to string: " + string.toString());
		*/
		
		/*
		//StringBuilder
		StringBuilder string = new StringBuilder("Ayoub");
		System.out.println("length: " + string.length());
		System.out.println("Substring with begin: " + string.substring(2));
		System.out.println("Substring with begin and end: " + string.substring(2, 4));
		System.out.println("index of string in string: " + string.indexOf("you"));
		System.out.println("get character with index: " + string.charAt(0));
		System.out.println("check equality: " + string.equals("AyouB"));
		System.out.println("capacity: " + string.capacity());
		System.out.println("Append string: " + string.append(" Ridouani"));
		System.out.println("hashcode: " + string.hashCode());
		System.out.println("delete from string: " + string.delete(5, 8));
		System.out.println("delete one character from  string: " + string.deleteCharAt(5));
		//replace one character: string.setCharAt(0, 'r');
		System.out.println("reverse string: " + string.reverse());
		//string to char Array: char[] Array = string.toCharArray();
		System.out.println("insert string: " + string.insert(9, "hi hello world"));
		System.out.println("insert string: " + string.insert(5, "we are good", 0, 11));
		//set length: string.setLength(10);
		System.out.println("to string: " + string.toString());
		*/
		
		/*
		//who fast ?? String, StringBuffer, StringBuilder
		String string1 = "Ayoub";
		long time = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			string1.concat(" Ridouani");
		}
		System.out.println("String: " + (System.currentTimeMillis()-time) + "ms");
		
		StringBuilder string2 = new StringBuilder("Ayoub");
		time = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			string2.append(" Ridouani");
		}
		System.out.println("StringBuilder: " + (System.currentTimeMillis()-time) + "ms");
		
		StringBuffer string3 = new StringBuffer("Ayoub");
		time = System.currentTimeMillis();
		for(int i=0;i<100000;i++) {
			string3.append(" Ridouani");
		}
		System.out.println("StringBuffer: " + (System.currentTimeMillis()-time) + "ms");
		*/
		
		//String is immutable (Strings are constants)
		//StringBuilder is mutable + not synchronized (multiple thread)
		//StringBuffer is mutable + synchronized (single threads)

		/*
		//tokenizer
		StringTokenizer string = new StringTokenizer("Ayoub Ridouani");
		System.out.println("tokens: " + (string.countTokens()+1));
		
		while(string.hasMoreTokens()) {
			//System.out.println(string.nextElement());
			//System.out.println(string.nextToken("u"));
		}
		*/
		
	}
}
