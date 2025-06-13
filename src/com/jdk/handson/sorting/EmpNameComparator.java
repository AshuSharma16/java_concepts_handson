package com.jdk.handson.sorting;

import com.jdk.handson.dto.Employee;

import java.util.Comparator;

public class EmpNameComparator implements Comparator<Employee> {

	@Override
	public int compare(Employee o1,Employee o2) {
		
		return o1.getEmpName().compareTo(o2.getEmpName());
	}

}
