import java.util.*;

public class ParentChildAncestry {
    public static List findNodesByParentCount(int[][] parentChildPairs){
        Map<Integer,Integer> parentCount=new HashMap<>();
        Set<Integer> allPeople=new HashSet<>();
        for(int[] nodes: parentChildPairs){
            int parent=nodes[0];
            int child=nodes[1];

            allPeople.add(parent);
            allPeople.add(child);
            parentCount.put(child,parentCount.getOrDefault(child,0)+1);
        }

        List<Integer> zeroParents= new ArrayList<>();
        List<Integer> oneParents=new ArrayList<>();

        for(int person: allPeople){
            int count = parentCount.getOrDefault(person,0);
            if(count == 0){
                zeroParents.add(person);
            }else if (count ==1) {
                oneParents.add(person);
            }
        }

        Collections.sort(zeroParents);
        Collections.sort(oneParents);
        return Arrays.asList(zeroParents,oneParents);


    }

    public static void main(String[] args) {
        // 1 -> 3, 2 -> 3 (3 has two parents), 3 -> 5 (5 has exactly one parent: 3)
        int[][] parentChildPairs = {
                {1, 3},
                {2, 3},
                {3, 5}
        };

        List<List<Integer>> result = findNodesByParentCount(parentChildPairs);

        System.out.println("Individuals with 0 parents (roots): " + result.get(0));
        System.out.println("Individuals with exactly 1 parent: " + result.get(1));
    }

}
