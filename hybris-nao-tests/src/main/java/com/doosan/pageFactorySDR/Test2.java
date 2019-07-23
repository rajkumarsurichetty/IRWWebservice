package com.doosan.pageFactorySDR;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test2 {

	public static void main (String [] args)
	{
		WebDriver driver=new FirefoxDriver();
		driver.get("https://jqueryui.com/animate/");
		driver.switchTo().frame(0);
		driver.findElement(By.id("button")).click();
		String rgb1 = driver.findElement(By.xpath(".//*[@id='effect']")).getCssValue("background-color");
		System.out.println(rgb1);
		String rgb[] = driver.findElement(By.xpath(".//*[@id='effect']")).getCssValue("background-color").replaceAll("(rgba)|(rgb)|(\\()|(\\s)|(\\))","").split(",");
		String hex = String.format("#%s%s%s", toBrowserHexValue(Integer.parseInt(rgb[0])), toBrowserHexValue(Integer.parseInt(rgb[1])), toBrowserHexValue(Integer.parseInt(rgb[2])));
		System.out.println(hex);
	}
	
	private static String toBrowserHexValue(int number) {
        StringBuilder builder = new StringBuilder(Integer.toHexString(number & 0xff));
        while (builder.length() < 2) {
            builder.append("0");
        }
        return builder.toString().toUpperCase();
    }
}
