package com.gm;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.beanio.BeanReader;
import org.beanio.StreamFactory;

public class ReadXMLFileData {

	public List<Employee> getXmlData() {
		// create a StreamFactory
		StreamFactory factory = StreamFactory.newInstance();
		// load the mapping file
		factory.load("mapping.xml");

		// use a StreamFactory to create a BeanReader
		BeanReader in = factory.createReader("employeeFile", new File("employee.xml"));
		Employee employee;
		List<Employee> xmlEmpList = new ArrayList();
		while ((employee = (Employee) in.read()) != null) {
			xmlEmpList.add(employee);
		}
		return xmlEmpList;
	}

}
