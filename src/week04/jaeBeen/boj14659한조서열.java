import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		int max = 0;
		for(int i=0; i<n-1; i++) {
			int sum = 0;
			for(int j=i+1; j<n; j++) {
				if(arr[i] - arr[j] > 0) {
					sum++;
				} else {
					break;
				}
			}
			if(sum > max) {
				max = sum;
			}
		}
		System.out.println(max);
	}
}
