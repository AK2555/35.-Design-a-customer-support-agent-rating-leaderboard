package org.example.manager;

import org.example.entities.Agent;
import org.example.entities.Pair;
import org.example.entities.Rating;
import org.example.observer.Observer;

import java.util.*;

public class BestAgentByMonthManager implements Observer {

    Map<String, Map<String, Pair>> monthAgentIdAvgRatingMap;

    public BestAgentByMonthManager(){
        this.monthAgentIdAvgRatingMap=new HashMap<>();
    }


    public List<String> getBestAgentsByMonth(String month){
        List<String> res=new ArrayList<>();
        Map<String,Pair> map=monthAgentIdAvgRatingMap.get(month);
        if(map==null){
            return res;
        }
        for(Map.Entry<String,Pair> me: map.entrySet()){
            String key=me.getKey();
            Pair val=me.getValue();
            String str=key+","+roundToOneDecimalPlace(val.getAvgRating());
            res.add(str);
        }
        Collections.sort(res,(String a,String b)->{
            String[] arr=a.split(",");
            String[] brr=b.split(",");
            if(!arr[1].equals(brr[1])){
                return Double.compare(Double.parseDouble(brr[1]) , Double.parseDouble(arr[1]));
            }else{
                return a.compareTo(b);
            }
        });
        return res;
    }

    @Override
    public void update(Agent agent, Rating rating) {
        String agentName=agent.getAgentName();
        String monthStr=rating.getRatingDate().substring(0,7);
        if(!monthAgentIdAvgRatingMap.containsKey(monthStr)){
            monthAgentIdAvgRatingMap.put(monthStr,new HashMap<>());
        }
        if(!monthAgentIdAvgRatingMap.get(monthStr).containsKey(agentName)){
            monthAgentIdAvgRatingMap.get(monthStr).put(agentName,new Pair(rating.getRating(),1));
            return;
        }
        Pair pair=monthAgentIdAvgRatingMap.get(monthStr).get(agentName);
        double val=nextAvgVal(pair,rating.getRating());
        pair.setAvgRating(val);
        pair.setRatingCnt(pair.getRatingCnt()+1);
    }
    private double nextAvgVal(Pair pair,double rating){
        double val=((pair.getAvgRating()*pair.getRatingCnt())+rating)/(pair.getRatingCnt()+1);
      //  val=roundToOneDecimalPlace(val);
        return val;
    }

    private double roundToOneDecimalPlace(double val){
        double res=Math.round(val*10.0)/10.0;
        return res;
    }
}
