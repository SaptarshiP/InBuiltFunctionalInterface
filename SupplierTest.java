package com.psja.check;

import java.util.List;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class SupplierTest {

	public static void main( String args[] ) {
		List<EmployeeSuppl> empList = new ArrayList<>();
		empList.add( new EmployeeSuppl("psja1", 1000) );
		empList.add( new EmployeeSuppl("psja2", 2000) );
		empList.add( new EmployeeSuppl("psja3", 3000) );
		empList.add( new EmployeeSuppl("psja4", 4000) );
		empList.add( new EmployeeSuppl("psja5", 5000) );
		
		Predicate<EmployeeSuppl> pr1 = (c)->{
			Boolean t2 = c.getSal() > 5000;
			return t2;
		};
		
		Consumer<EmployeeSuppl> c1 = (c)->{
			System.out.println(c);
		};
		
		Supplier<EmployeeSuppl> suppl = ()->{
			return new EmployeeSuppl("psjaDummy", 9000);
		};
		
		System.out.println(empList.stream()
									.filter( pr1 ).findAny()
									.orElseGet(suppl).toString());
	}
	
}

class EmployeeSuppl{
	private String name;
	private Integer sal;
	
	public EmployeeSuppl( String name, Integer sal ){
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
		strBuilder.append("||").append(this.sal);
		return strBuilder.toString();
	}
}