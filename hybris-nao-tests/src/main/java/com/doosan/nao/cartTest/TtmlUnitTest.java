package com.doosan.nao.cartTest;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class TtmlUnitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//WebDriver wd=new HtmlUnitDriver();
		//wd.get("");
		
		//String str= "raj kumar";
		//System.out.println(str.contains("raj"));
		
		String timeStamp = new SimpleDateFormat("yyyyMMdd_HH:mm").format(Calendar.getInstance().getTime());
		String [] time=timeStamp.split("_");
		System.out.println(time[1].split(":"));
	}

}
