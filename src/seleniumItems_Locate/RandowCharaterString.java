package seleniumItems_Locate;
import java.lang.Math;

public class RandowCharaterString {
	private static String string = "abcdefghijklmnopqrstuvwxyz";
	private static int getRandom(int count) {
		return (int) Math.round(Math.random()*count);
	}
	
	private static String getRandomString(int length){
		StringBuffer sb = new StringBuffer();
		int len = string.length();
		for (int i = 0; i < length; i++) {
			sb.append(string.charAt(getRandom(len-1)));
		}
		return sb.toString();
		}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
       System.out.print(getRandomString(5));
	}
	
	

}
