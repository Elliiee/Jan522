import java.security.KeyPair;
import java.util.ArrayList;
import java.util.HashMap;

public class Q399 {
    private Pair<String, Double> find(HashMap<String, Pair<String, Double>> gidWeight, String nodeId){
        //original group id is the node itself
        //original weight is 1
        gidWeight.putIfAbsent(nodeId, new Pair<String, Double>(nodeId, 1.0));

        Pair<String, Double> entry = gidWeight.get(nodeId);

        //find inconsistency, trigger chain update
        // which is changing all the connected node id to the root id
        if (!entry.getFirst().equals(nodeId)){
            Pair<String, Double> newEntry = find(gidWeight, entry.getFirst()); //go find the root id

            gidWeight.put(nodeId, new Pair<>(newEntry.getFirst(), entry.getSecond() * newEntry.getSecond()));
        }

        return gidWeight.get(nodeId); //return the pair value of the current node
    }

    private void union(HashMap<String, Pair<String, Double>> gidWeight, String divided, String divisor, Double value){
        Pair<String, Double> dividedEntry = find(gidWeight, divided);
        Pair<String, Double> divisorEntry = find(gidWeight, divisor);

        String dividedGid = dividedEntry.getFirst();
        String divisorGid = divisorEntry.getFirst();
        Double dividedWeight = dividedEntry.getSecond();
        Double divisorWeight = divisorEntry.getSecond();

        //merge the two groups together
        //by attaching the divided group to the one of divisor
        if (!dividedGid.equals(divisorGid)){
            gidWeight.put(dividedGid, new Pair<>(divisorGid, divisorWeight * value / dividedWeight));
        }
    }
}
