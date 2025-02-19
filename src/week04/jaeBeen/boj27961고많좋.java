import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		// 목표값이 0이 아니면 첫번째는 무조건 소환
		// 그다음부터는 목표치에 근사해 질 때 까지 2배
		// 2배 하기전 < 목표 < 2배하고난 후 의 상태가 되면 2배 대신 현재 가진 고양이중 일정 부분만 복제
		// 목표값을 2로 나누어 떨어지지 않을 때 까지 나눈 횟수를 우선 구해보자
		
		Scanner sc = new Scanner(System.in);
		long n = Long.parseLong(sc.next());
		
		int count = 0;
		long cat = 0;
		while(true) {
			if(count==0 && n != 0) {
				count++;
				cat++;
			}
			if(cat*2 < n) {
				cat *= 2;
				count++;
			}
			if(cat*2 >= n) {
				break;
			}
			
		}
		System.out.println(cat < n ? count+1: count);
	}
}
