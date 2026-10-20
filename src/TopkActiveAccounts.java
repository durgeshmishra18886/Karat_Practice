import java.util.*;

public class TopkActiveAccounts {

    public List<Map.Entry<String,Integer>> topK (Map<String,Integer> counts, int k){
        PriorityQueue<Map.Entry<String,Integer>> minHeap=new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<String,Integer> entry:counts.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }

        }

        List<Map.Entry<String,Integer>> result=new ArrayList<>(minHeap);

        result.sort((a,b)-> b.getValue()-a.getValue());

        return result;
    }
    public static void main(String[] args) {

    }
}
