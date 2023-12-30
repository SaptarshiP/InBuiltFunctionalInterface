package com.psja.check;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;

public class PrediateConsumerTest {

	public static void main( String args[] ) {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("psja1", 1000));
		empList.add(new Employee("psja2", 2000));
		empList.add(new Employee("psja3", 3000));
		empList.add(new Employee("psja4", 4000));
		
		Predicate<Employee> empPredicate = (c)-> {
			Boolean t = c.getSal()>3000;
			return t;
		};
		
		Consumer<Employee> cons = (c)->{
			System.out.println(c);
		};
		empList.stream()
				.filter(t1->empPredicate.test(t1))
				.forEach(t1->cons.accept(t1));
	}
	
}

class Employee{
	private String name;
	private Integer sal;
	
	public Employee( String name, Integer sal ) {
		this.name = name;
		this.sal = sal;
	}
	
	public String getName() {
		return this.name;
	}
	public Integer getSal() {
		return this.sal;
	}
	
	@Override
	public String toString() {
		StringBuilder strBuilder = new StringBuilder(this.name);
		strBuilder.append("||").append( this.sal );
		return strBuilder.toString();
	}
}
