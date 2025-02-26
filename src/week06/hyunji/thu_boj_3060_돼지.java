import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(sc.nextLine());
            String[] foods = sc.nextLine().split(" ");

            int amount = 0;
            for (String food : foods) {
                amount += Integer.parseInt(food);
            }

            int day = 1;
            while (N - amount >= 0) { 
                amount *= 4;
                day++;
            }

            System.out.println(day);
        }
    }
}
