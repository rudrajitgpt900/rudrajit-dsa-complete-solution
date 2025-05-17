package rudy.dsa.StringsAdvanced;

public class CountAndSay {

    public String countAndSay(int n) {
        if(n==1)
            return "1";

        String prev = countAndSay(n-1);
        StringBuilder sb = new StringBuilder();
        int frequency =1;
        int i = 1;
        while (i<prev.length()){
            if(prev.charAt(i) == prev.charAt(i-1)){
                frequency++;
            }
            else{
                sb = sb.append(frequency).append(prev.charAt(i-1));
            }
            i++;
        }
        sb = sb.append(frequency).append(prev.charAt(i-1));
        return sb.toString();

    }
}
