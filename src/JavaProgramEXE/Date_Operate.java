package JavaProgramEXE;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.SimpleFormatter;

public class Date_Operate {

	public static void main(String[] args) {
	
		//first way
		Calendar cal = Calendar.getInstance();
		int Y = cal.get(Calendar.YEAR);
		int M =cal.get(Calendar.MONTH);
		int D = cal.get(Calendar.DATE);
		System.out.println(Integer.toString(Y)+Integer.toString(M)+Integer.toString(D));

		//second way
		Calendar cal2= Calendar.getInstance();
		SimpleDateFormat f = new SimpleDateFormat("yyyyMMdd");
		System.out.println(f.format(cal2.getTime()));
		
	}

}
