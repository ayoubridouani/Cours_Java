import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		/*
		//one file
		FileInputStream in = new FileInputStream("src/file.txt");
		FileOutputStream out = new FileOutputStream("src/result.txt");
		out.write(seq.readAllBytes());
		*/
		
		/*
		//two file
		FileInputStream in1 = new FileInputStream("src/file1.txt");
		FileInputStream in2 = new FileInputStream("src/file2.txt");
		
		SequenceInputStream seq = new SequenceInputStream(in1,in2);
		
		FileOutputStream out = new FileOutputStream("src/result.txt");
		out.write(seq.readAllBytes());
		*/
		
		/*
		//many files
		FileInputStream in1 = new FileInputStream("src/file1.txt");
		FileInputStream in2 = new FileInputStream("src/file2.txt");
		FileInputStream in3 = new FileInputStream("src/file3.txt");
		
		Vector vec= new Vector();
		vec.add(in1);
		vec.add(in2);
		vec.add(in3);
		
		Enumeration<FileInputStream> Enum = vec.elements();
		
		SequenceInputStream seq = new SequenceInputStream(Enum);
		FileOutputStream out = new FileOutputStream("src/file3.txt");
		
		out.write(seq.readAllBytes());
		*/
		/*
		//write ascii on file
		File file = new File("file.txt");
		FileWriter writer = new FileWriter(file);
		writer.write("hello");//accept only String and int
		writer.append(" world");//accept StringBuilder and StringBuffer and String and int
		writer.flush();//write the data and empty the tampon
		writer.close();//call flush() and close the object
		*/
		
		/*
		//read ascii from file
		File file = new File("file.txt");
		FileReader reader = new FileReader(file);
		int c;
		
		reader.skip(5);//ignorer 5 character
		//reader.mark(0);//not supported
		//reader.reset();//not supported
		if(reader.ready())
			while((c = reader.read(pp)) != -1)
				System.out.println((char)c);
		reader.close();
		*/
		/*
		//the class PrintWriter has a rich set of convinience methods than FileWriter
		File file = new File("file.txt");
		PrintWriter printer = new PrintWriter(file);
		printer.print(10);
		printer.println(20);
		printer.printf("%s", "30");
		printer.write((char) 65);
		printer.write("50");
		printer.append((char) 66);
		printer.append("70");
		printer.flush();
		printer.close();
		*/
		
		/*
		File file = new File("file.txt");
		BufferedReader buffer = new BufferedReader(new FileReader(file));
		if(buffer.markSupported() == true && buffer.ready() == true) {
			System.out.println(buffer.readLine());//print line 1
			buffer.mark(8);//mark placed tampon in line 2
			buffer.reset();//tampon go to line 2 position 4
			System.out.println((char)buffer.read());//print one character from (line)
			buffer.reset();//tampon go to line 2 position 4
			System.out.println((char)buffer.read());//print one character from (line)
			buffer.reset();
			System.out.println(buffer.readLine());
			buffer.mark(2);
			buffer.reset();
			buffer.skip(5);
			char[] buff = new char[1024];
			while(buffer.read(buff) != -1);//stock value returned of read in buff 
			System.out.println(buff);
		}
		buffer.close();
		*/
		/*
		File file = new File("file.txt");
		BufferedWriter buffer= new BufferedWriter(new FileWriter(file));
		buffer.write(65);
		buffer.newLine();
		buffer.write("text");
		buffer.append((char)65);
		buffer.append("text");
		buffer.flush();
		buffer.close();
		*/
		/*
		FileOutputStream out = new FileOutputStream("file.txt");
		DataOutputStream dataout = new DataOutputStream(out);
		dataout.writeInt(65);
		dataout.writeUTF("trtrtrtr");
		dataout.flush();
		dataout.close();
		
		
		FileInputStream in = new FileInputStream("file.txt");
		DataInputStream datain = new DataInputStream(in);
		System.out.println(datain.readInt());
		System.out.println(datain.readUTF());
		datain.close();
		*/
		/*
		FileInputStream in = new FileInputStream("file.txt");
		ObjectOutputStream data = new ObjectOutputStream(new FileOutputStream("file.txt"));
		data.writeInt(15);
		data.close();
		ObjectInputStream object = new ObjectInputStream(in);
		System.out.println(object.readInt());
		object.close();
		*/
	}
}
