package oop;

public class Child extends Parent{

	Child(){
		System.out.println("I am the child");
	}
	
	Child(String name){
		this();
		System.out.println("Hi, my name is "+name);
	}
}
