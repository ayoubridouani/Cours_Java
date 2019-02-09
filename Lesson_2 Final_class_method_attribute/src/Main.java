//we can’t be created child classes
//Data members in the class must be declared as final

//final class -- we cannot extends from the class
final class Student{ 
    
	//final attribut -- we cannot change value the attribut
	private final String name; 
    private final int regNo; 
  
    public Student(String name, int regNo){ 
        this.name = name; 
        this.regNo = regNo; 
    } 
    
    public String getName(){ 
        return name; 
    }
    
    public int getRegNo(){ 
        return regNo; 
    }
    
    //final method -- we cannot override this method
    final String tostring() {
    	return "xxx";
    }
}

//error: class Studen1t extends Student{ }

public class Main{
	public static void main(String[] args) {
	    Student s = new Student("Ayoub",87);
	    System.out.println(s.getName());
	}
}
