package main;

public class GUFsLog {
	String className;
	
	public <T> GUFsLog (Class<T> incomingClass) {
		className = incomingClass.getName();
		System.out.println("Class "+className+" initiated.");
	}
	
	public void print(String text) {
		System.out.println(className+" -> "+text);
	}
	
	public void error(String text) {
		System.out.println("ERROR -> "+className+" -> "+text);
	}

}
