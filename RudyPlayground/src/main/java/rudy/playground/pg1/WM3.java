package rudy.playground.pg1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

class SimCache{
    private Map<String, List<SimData>>userInfo = new HashMap<>();

    public synchronized void addItem(String user, SimData sim){
        cleanUpCache(user);
        if(userInfo.containsKey(user)){
            List<SimData>userSims = userInfo.get(user);
            if(userSims.contains(sim)){
                if(!isSimValid(userSims.get(userSims.indexOf(sim)),sim))
                    System.out.println("User "+ user+" already has a sim of type "+ sim.type);
                return;
            }
            else{
                userSims.add(sim);
                userInfo.put(user,userSims);
                System.out.println("User "+ user+"  has taken a sim of type "+ sim.type);
                return;
            }
        }
        var l = new CopyOnWriteArrayList<SimData>();
        userInfo.put(user,l);
        var list =  userInfo.get(user);
        list.add(sim);
        userInfo.put(user,list);
        System.out.println("User "+ user+"  has taken a sim of type "+ sim.type);
    }




    public synchronized  void  cleanUpCache(String userId){
        if(!userInfo.containsKey(userId))
            return;
        var list = userInfo.get(userId);
        list.forEach(sim -> {
            if(isSimExpired(sim)){
                System.out.println("Removing expired sim "+sim.type+" from cache for user "+ userId);
                list.remove(sim);
            }
        });
    }

    public synchronized boolean isSimExpired(SimData simData){
        long l = System.currentTimeMillis() / 1000 - simData.issuedDate;
        return l >=5;
    }

    public synchronized boolean isSimValid(SimData existingSim , SimData newSim){
        var x = existingSim.issuedDate;
        var y = newSim.issuedDate;
        return (y-x)>=5;
    }

    public synchronized void printActiveSim(){
        userInfo.forEach( (user ,sim)-> System.out.println(user +":"+ sim));
    }

}

class SimData{
    public SimType type;
    public long issuedDate;

    SimData(SimType type, long issuedDate){
        this.issuedDate= issuedDate;
        this.type = type;
    }
}
public class WM3 {

    public static void main(String[] args) throws InterruptedException {
        SimCache simCache = new SimCache();
        SimData sim1 = new SimData(SimType.S1, System.currentTimeMillis() / 1000);
        SimData sim2 = new SimData(SimType.S2, System.currentTimeMillis() / 1000);
        simCache.addItem("user1", sim1);

        simCache.addItem("user1", sim2);
        Thread.sleep(5000);
        simCache.addItem("user1", sim1);
        simCache.addItem("user1", sim2);
        simCache.printActiveSim();

    }
}
