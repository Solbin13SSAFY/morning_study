package boj_20546_기적의매매법;

import java.util.Scanner;

import javax.swing.JScrollBar;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cash = sc.nextInt();
		sc.nextLine();
		int[] prices = new int[14];
		String[] str = sc.nextLine().split(" ");
		for(int i=0; i<14; i++) {
			prices[i] = Integer.parseInt(str[i]);
		}
		
		int jhCash = cash;
		int jhStock = 0;
		int smCash = cash;
		int smStock = 0;
		
		int redStraight = 0;
		int blueStraight = 0;
		
		for(int i=0; i<14; i++) {
			// 준현이는 일단 산다.
			int price = prices[i];
			if(jhCash >= price) {
				jhStock += jhCash/price;
				jhCash = jhCash%price;
			}
			// 가격이 연속으로 상승, 하강했는지 확인하기 위한 변수 
			if(i > 0) {
				if(price< prices[i-1]) {
					blueStraight++;
					redStraight = 0;
				}
				if(prices[i-1] < price) {
					redStraight++;
					blueStraight = 0;
				}
			}
			if(blueStraight >= 3 && smCash >= price) {
				smStock += smCash/price;
				smCash = smCash%price;
			}
			if(redStraight >= 3 && smStock >= 0) {
				// 성민이는 3일연속 상승하면 판다
				smCash += smStock*price;
				smStock = 0;
			}
		}
		int lastPrice = prices[13];
		
		jhCash += jhStock*lastPrice;
		smCash += smStock*lastPrice;
		
		System.out.println(jhCash == smCash? "SAMESAME":(jhCash>smCash ? "BNP": "TIMING"));
	}
}
