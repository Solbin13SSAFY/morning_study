package week03.solbin;

import java.util.Scanner;
class Main
{
	final static Scanner sc = new Scanner(System.in);
	public static void main(String args[]) throws Exception
	{
		int sum=0;
		int diff = 100;
		for (int i = 0; i < 10; i++) {
			int input = sc.nextInt();
			sum += input;
            // 李⑥씠媛� �떎�떆 �긽�듅�븯湲� �떆�옉�븯�뒗 吏��젏�뿉�꽌 break
			if (Math.abs(100-sum)>diff) {
				sum -=input ;
				break;
			} else {
				diff = Math.abs(100-sum);
			}
		}
		System.out.println(sum);
	}
}