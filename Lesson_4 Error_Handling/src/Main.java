public class Main {
	
	//try-catch-finally
	static void fun1(){ 
		System.out.println("Inside fun()");
        try {
			int x = 5/0;
			System.out.println(x);
		}catch (ArithmeticException e) {
			e.printStackTrace();
		} 
    }
	
	//throw with try/catch
	static void fun2(){ 
        System.out.println("Inside fun()"); 
        try {
			throw new IllegalAccessException("demo");
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} 
    }
	
	//throw with throws
	//propagation so for every method was called fun2(), it must be throws same type of exception or have a try-catch
	static void fun3() throws IllegalAccessException{ 
        System.out.println("Inside fun()"); 
        //throw new IllegalAccessException("demo");//if the throw cannot found catch, so the program was halted
    }

    public static void main(String args[]) throws IllegalAccessException{ 
        child.fun3();
        System.out.println("finish."); 
        
    } 
}

//propagation with override function
class child extends Main{
	//propagation with override function: the throws must be contains an exception less or equal exception handling
	 static void fun3() throws IllegalAccessException{
		System.out.println("child Inside fun()");
		throw new IllegalAccessException("demo1");
	}
}

//try-catch-finally: no propagation
//throws-throw: propagation