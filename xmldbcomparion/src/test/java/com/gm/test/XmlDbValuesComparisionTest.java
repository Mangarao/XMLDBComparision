package com.gm.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.gm.ConnectMSSqlServer;
import com.gm.Employee;
import com.gm.ReadXMLFileData;

public class XmlDbValuesComparisionTest {

	@Test
	public void testXmlDbValues() {
		ReadXMLFileData rxml=new ReadXMLFileData();
		List<Employee> xmlEmpList = rxml.getXmlData();
		ConnectMSSqlServer cMsServerDb =new ConnectMSSqlServer();
		List<Employee> dbEmpList = cMsServerDb.getDBData();
		System.out.println(xmlEmpList);
		int matchCount=0;
		for (Employee xmlEmp : xmlEmpList) {
			for (Employee dbEmp : dbEmpList) {
				
				if(xmlEmp.getId()==dbEmp.getId()){
					if(xmlEmp.getFirstName().equals(dbEmp.getFirstName()) && xmlEmp.getLastName().equals(dbEmp.getLastName())
						&& xmlEmp.getTitle().equals(dbEmp.getTitle()) && xmlEmp.getSalary()==dbEmp.getSalary()
						&& xmlEmp.getHireDate().equals(dbEmp.getHireDate())){
						matchCount++;
					}
				}
	
			}
			
		} //for loop ends here
		System.out.println("Matched records: "+matchCount);
		System.out.println("Unmatched records: "+(xmlEmpList.size()-matchCount));
		assertEquals(xmlEmpList.size(), matchCount);
		
		
	}

}
