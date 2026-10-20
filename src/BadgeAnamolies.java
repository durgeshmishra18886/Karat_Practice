import java.util.*;

public class BadgeAnamolies {

    public static List<List<String>> findBadgeAnomalies(String[][] badgeRecords) {
        Set insideBuilding = new HashSet<>();
        Set invalidEntry = new HashSet<>();
        Set invalidExit = new HashSet<>();

        for (String[] str : badgeRecords) {
            String name = str[0];
            String action = str[1];

            if ("enter".equals(action)) {
                if (insideBuilding.contains(name)) {
                    invalidEntry.add(name);
                } else {
                    insideBuilding.add(name);
                }
            }
            if ("exit".equals(action)) {
                if (insideBuilding.contains(name)) {
                    insideBuilding.remove(name);
                } else {
                    invalidExit.add(name);
                }
            }
        }

        invalidEntry.addAll(insideBuilding);
        return Arrays.asList(new ArrayList<>(invalidEntry), new ArrayList<>(invalidExit));
    }

        public static void main(String args[]){

            String[][] badgeRecords = {
                    {"Alice", "enter"},
                    {"Bob", "enter"},
                    {"Alice", "exit"},
                    {"Alice", "enter"},   // Alice never exited the second time -> forgot to badge out
                    {"Charlie", "exit"},  // Charlie badged out without ever entering -> invalid exit
                    {"Bob", "enter"}      // Bob re-entered without exiting -> invalid enter
            };

            List<List<String>> invalids=findBadgeAnomalies(badgeRecords);

            System.out.println("Invalid Entry"+ invalids.get(0));
            System.out.println("Invalid Exit"+ invalids.get(1));





        }

}
