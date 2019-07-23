package com.doosan.nao.fleetManagements.page;

import java.util.Date;
import java.util.Random;

public class RandomNumber {
	public static Date date=new Date();
	public static String month;
	public  String generateRnumber ()
	{
				
			Random randy=new Random();
			int temp = randy.nextInt(1000000);

			int runTimeDate=date.getDate();
			int runTimeMonth=date.getMonth()+1;
			
			switch (runTimeMonth) {
			case 1:
				month="Jan";
				break;
			case 2:
				month="Feb";
				break;
			case 3:
				month="Mar";
				break;
			case 4:
				month="Apr";
				break;
			case 5:
				month="May";
				break;
			case 6:
				month="Jun";
				break;
			case 7:
				month="Jul";
				break;
			case 8:
				month="Aug";
				break;
			case 9:
				month="Sep";
				break;
			case 10:
				month="Oct";
				break;
			case 11:
				month="Nov";
				break;
			case 12:
				month="Dec";
				break;
			}
							
			return temp+runTimeDate+month+"AutoRNo";

	}
}
