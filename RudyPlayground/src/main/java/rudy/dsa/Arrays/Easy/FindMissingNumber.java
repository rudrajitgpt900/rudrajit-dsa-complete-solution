package rudy.dsa.Arrays.Easy;

public class FindMissingNumber {

    public int missingNumber(int[] nums) {
        int n= nums.length;
        int S = (n*(n+1))/2;
        int s=0;
        for(int x : nums){
            s+=x;
        }

        return S-s;
    }


    public int missingNumberXOR(int[] nums){
        int n= nums.length;
        int xor1=0;
        for(int x : nums){
            xor1^=x;
        }

        int xor2=0;
        for(int i=0; i<= n; i++){xor2^=i;}

        return xor1^xor2;

    }
}
