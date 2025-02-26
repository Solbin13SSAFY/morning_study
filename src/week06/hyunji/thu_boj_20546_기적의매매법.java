 import java.util.Scanner;

public class thu_boj_20546_기적의매매법 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int money = sc.nextInt(); 

        int[] stockPrice = new int[14]; 
        for(int i=0; i<14; i++) {
            stockPrice[i] = sc.nextInt();
        }

        //준현 - 가능한 범위내에서 최대한 많이 산다
        int jhMoney = money; //현금
        int jhStock = 0; //보유 주식 수

        for(int i=0; i<14; i++) {
            int cur = jhMoney/stockPrice[i];
            jhStock += cur;
            jhMoney -= cur*stockPrice[i];
        }

        int BNP = jhMoney+jhStock*stockPrice[13];

        //성민 - 3일연속 오르면 다음날 떨어짐 => 전량 매도, 3일연속 내리면 다음날 오름 => 전량 매수
        int smMoney = money;
        int smStock = 0;
        
        for(int i=0; i<stockPrice.length-3; i++) {
            if((stockPrice[i]<stockPrice[i+1]) && (stockPrice[i+1]<stockPrice[i+2])) { //3일연속 주가가 오르면 => 다음날 가격으로 전량매도
                if(smStock == 0) continue; //팔 주식이 없음 continue
                smMoney += stockPrice[i+3]*smStock;
                smStock = 0;
            }
            else if((stockPrice[i]>stockPrice[i+1]) && (stockPrice[i+1]>stockPrice[i+2])) { //3일연속 주가가 내리면 => 다음날 가격으로 전량매수
                if((smMoney/stockPrice[i+3])>0) {
                    int buyStock = smMoney/stockPrice[i+3]; 
                    smStock += buyStock;
                    smMoney -= stockPrice[i+3]*buyStock;
                }
            }
        }

        int TIMING = smMoney+smStock*stockPrice[13];

        if(BNP>TIMING) System.out.println("BNP");
        else if(TIMING>BNP) System.out.println("TIMING");
        else System.out.println("SAMESAME");
    }
}