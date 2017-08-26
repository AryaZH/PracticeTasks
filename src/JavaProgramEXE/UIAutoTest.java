package JavaProgramEXE;

import java.io.IOException;

public class UIAutoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path="E:\\20170820\\uploadTest.exe";
		autoit(path);
	}
	
	/**
	 * 执行exe文件
	 * 
	 * @param cmd
	 */
	public static void autoit(String cmd) {
		try {
			
			Runtime.getRuntime().exec(cmd);
		} catch (IOException e) {
		}
	}
	
	

}
