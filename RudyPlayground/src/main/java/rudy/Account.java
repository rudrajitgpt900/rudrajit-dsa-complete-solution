package rudy;

import java.util.Set;
import java.util.TreeSet;

public class Account {

    public String accountId;
    public int totalSpend;

    Account(String accountId , int totalSpend){
        this.accountId = accountId;
        this.totalSpend = totalSpend;
    }

    public void updateTotalSpend(Account account, int amount){
        account.totalSpend = account.totalSpend+amount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "accountId='" + accountId + '\'' +
                ", totalSpend=" + totalSpend +
                '}';
    }


    public static void main(String[] args) {
        Set<Account> accountSet = new TreeSet<>((ac1 ,ac2)-> {
            if(ac1.totalSpend ==ac2.totalSpend)
                return ac1.accountId.compareTo(ac2.accountId);
            return ac2.totalSpend-ac1.totalSpend;
        } );

        Account ac1 = new Account("ac1", 0);
        Account ac2 = new Account("ac2", 0);
        Account ac3 = new Account("ac3", 0);

        ac1.updateTotalSpend(ac1 , 100);
        ac1.updateTotalSpend(ac1 , 200);
        accountSet.add(ac1);
        ac1.updateTotalSpend(ac1 , 200);
        accountSet.add(ac1);

        ac2.updateTotalSpend(ac2 , 500);
        ac1.updateTotalSpend(ac1 , 100);
        ac3.updateTotalSpend(ac3 , 100);
        accountSet.add(ac2);
        accountSet.add(ac1);
        accountSet.add(ac3);
        System.out.println(accountSet);

      var list  =  accountSet.stream().map(account -> account.accountId.concat("(").concat(String.valueOf(account.totalSpend).concat(")"))).toList();

        System.out.println(list);
    }
}
