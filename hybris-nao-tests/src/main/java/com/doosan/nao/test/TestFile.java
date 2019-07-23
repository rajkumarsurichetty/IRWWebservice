package com.doosan.nao.test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFile {

	public static int i=0;
	
	@Test(dataProvider="data")
	
	public void testing(String testing1, String testing2)
	{
	
		
		System.out.println(testing1);
		System.out.println(testing2);
		i++;
		if (i==4)
		{
			Assert.assertEquals(i, 5);
		}
		
	}
	
	
	@DataProvider(name="data")
	public static Object[][] getData()
	{
		Object [][] data=new Object[6][2];
		
		data[0][0]="testing1";
		data[0][1]="testing2";
		
		data[1][0]="testing3";
		data[1][1]="testing4";
		
		data[2][0]="testing5";
		data[2][1]="testing6";
		
		data[3][0]="testing7";
		data[3][1]="testing8";
		
		
		data[4][0]="testing9";
		data[4][1]="testing10";
		
		
		data[5][0]="testing11";
		data[5][1]="testing12";
		
		
		return data;
		
	}
}
