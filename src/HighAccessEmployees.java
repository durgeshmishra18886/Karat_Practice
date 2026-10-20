import java.util.*;

public class HighAccessEmployees {
    public static Map<String, List<Integer>> highAccessEmployee(String[][] accessLogs){

        Map<String, List<Integer>> userMap=new HashMap<>();

        for(String[] log: accessLogs) {
            String name = log[0];
            int time = Integer.parseInt(log[1]);

            userMap.computeIfAbsent(name, key -> new ArrayList<>()).add(time);
        }
        Map<String, List<Integer>> result = new HashMap<>();
        for(Map.Entry<String, List<Integer>> entry: userMap.entrySet()){
            String userName=entry.getKey();
            List<Integer> accessList= entry.getValue();
            Collections.sort(accessList);
            for (int i=0; i < accessList.size()-2;i++){
                if(accessList.get(i+2)-accessList.get(i) < 60){
                    result.put(userName,accessList);
                    break;
                }

            }
        }
        return result;

    }

    public static void main(String[] args) {
        String[][] accessLogs = {
                {"Alice", "5"},
                {"Alice", "40"},
                {"Alice", "55"},   // Alice: 3 swipes (5,40,55) within 60 min -> flagged
                {"Bob", "10"},
                {"Bob", "200"},    // Bob: only 2 swipes total -> not flagged
                {"Charlie", "0"},
                {"Charlie", "70"},
                {"Charlie", "200"} // Charlie: swipes too spread out -> not flagged
        };

        Map<String, List<Integer>> result = highAccessEmployee(accessLogs);

        System.out.println("Employees with 3+ badge swipes inside a 60-minute window:");
        for (Map.Entry<String, List<Integer>> entry : result.entrySet()) {
            System.out.println("  " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
