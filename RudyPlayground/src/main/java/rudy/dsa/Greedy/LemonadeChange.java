package rudy.dsa.Greedy;

public class LemonadeChange {

    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten =0;
        for(int i=0; i<bills.length; i++){
            int currentBill = bills[i];
            if(currentBill==5)
                five++;
            else if (currentBill ==10) {
                ten++;
                if(five>0)
                    five--;
                else
                    return false;
            }
            else{
                if(ten>0 && five>0){
                    ten--;
                    five--;
                } else if (five>=3) {
                    five-=3;
                }
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        LemonadeChange obj = new LemonadeChange();
        int []bills = {5,5,5,20};
        System.out.println(obj.lemonadeChange(bills));
    }
}
