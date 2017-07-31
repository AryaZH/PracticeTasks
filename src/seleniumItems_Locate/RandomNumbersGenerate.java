package seleniumItems_Locate;

import java.util.ArrayList;
import java.util.Random;


public class RandomNumbersGenerate {
	public static void main(String[] args){
		ArrayList<Integer> list = new RandomNumbersGenerate().DiffNum(100);
		System.out.print(list);
	}
	
	public ArrayList<Integer> DiffNum(int n){
		ArrayList<Integer> list = new ArrayList<Integer>();
		Random ran= new Random();
		boolean[] flag = new boolean[n];
		int num=0;
		for(int i=0;i<n;i++){
			do{
				num=ran.nextInt(n);
			}while(flag[num]);
			flag[num]=true;
			list.add(num);
		}
	 return  list;
	}
}
