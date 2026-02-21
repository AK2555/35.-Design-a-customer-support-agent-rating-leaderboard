package org.example.manager;

import org.example.entities.Agent;
import org.example.entities.Pair;
import org.example.entities.Rating;
import org.example.observer.Observer;

import java.util.*;

public class AverageRatingManager implements Observer {

    Map<String, Pair> agentIdAvgRatingMap;

    public AverageRatingManager(){
        this.agentIdAvgRatingMap=new HashMap<>();
    }

    public List<String> getAverageRatings() {
        List<String> res= new ArrayList<String>();
        for(Map.Entry<String,Pair> me: agentIdAvgRatingMap.entrySet()){
            String key=me.getKey();
            Pair val=me.getValue();
            String str=key+","+roundToOneDecimalPlace(val.getAvgRating());
            res.add(str);
        }

        Collections.sort(res,(String a, String b)->{
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
        if(!agentIdAvgRatingMap.containsKey(agent.getAgentName())){
           // double val=roundToOneDecimalPlace(rating.getRating()*1.0);
            agentIdAvgRatingMap.put(agent.getAgentName(),new Pair(rating.getRating(),1));
            return;
        }
        Pair pair=agentIdAvgRatingMap.get(agent.getAgentName());
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
