package rudy.dsa.Graphs.ProblemOnBFSDFS;

import java.util.*;

public class AlienDictionary {
    public static String getAlienLanguage(String []dictionary, int k) {
        // Write your code here.
        StringBuilder ans = new StringBuilder();
        ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
        for(int i =0; i<k;i++){
            adj.add(new ArrayList<>());
        }
        int n = dictionary.length;
        int[]indeg = new int[k];
        for(int i=0; i<n-1;i++){
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int j =0; j<len;j++){
                if(s1.charAt(j) != s2.charAt(j)) {
                    adj.get(s1.charAt(j) - 'a').add(s2.charAt(j) - 'a');
                    indeg[s2.charAt(j) - 'a']++;
                    break;
                }
            }
        }


        Queue<Integer>q = new LinkedList<>();
        List<Integer> topo = new ArrayList<>();
        for(int i =0; i<k;i++){
            if(indeg[i]==0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            Integer front = q.poll();
            topo.add(front);
            for(Integer x : adj.get(front)){
                indeg[x]--;
                if(indeg[x] == 0)
                    q.add(x);
            }
        }
        if(topo.size() !=k){
            return "Cycle";
        }
        for(Integer x : topo){
            ans.append((char)(x+'a'));
        }
        return ans.toString();
    }


    public static void main(String[] args) {



        String[] dict = {"baa","abcd","abca","cab","cad"};

//        Scanner sc = new Scanner(System.in);
//        System.out.println("Enter dictionary: ");
//        int n = sc.nextInt();
//        String[]arr= new String[n];
//
//        for(int i=0;i<n;i++){
//            System.out.println("Enter your alien words: ");
//            String word = sc.nextLine();
//            arr[i]=word;
//        }
//        sc.close();

        System.out.println(AlienDictionary.getAlienLanguage(dict , 4));
    }
}
