package rudy.dsa.Greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class MeetingInfo {
   public int start;
   public int end;
   public int pos;

    MeetingInfo(int start, int end , int pos){
        this.end= end;
        this.start= start;
        this.pos= pos;

    }
}
public class NMeetingsinaRoom {

    public static int countMaxMeeting(int[]start, int []end, int n){
        int count =1;
        List<MeetingInfo>list = new ArrayList<>();
        for(int i =0; i< n; i++){
            int st = start[i];
            int en = end[i];
            list.add(new MeetingInfo(st,en,i));
        }
        list.sort(Comparator.comparingInt(a -> a.end));
        int freeTime = list.get(0).end;

        for(int i =1; i<n; i++){

            MeetingInfo currentMeeting = list.get(i);
            if(currentMeeting.start > freeTime){
                count++;
                freeTime = currentMeeting.end;
            }
        }
        return count;
    }
}
