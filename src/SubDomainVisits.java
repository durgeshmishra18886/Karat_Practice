import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubDomainVisits {

    public static List<String> subDomainVisit(String[] cpdomain) {
        Map<String, Integer> counts = new HashMap<>();

        for (String str : cpdomain) {
            String[] parts = str.split(",");
            int count = Integer.parseInt(parts[0]);
            String domain = parts[1];

            String[] subdomains = domain.split("\\.");
            String sb = "";
            for (int i = subdomains.length - 1; i >= 0; i--) {
                if (sb.isEmpty()) {
                    sb = subdomains[i];
                }else{
                    sb = subdomains[i] + "." + sb;
                }
                counts.put(sb, counts.getOrDefault(sb, 0) + count);
            }
        }

        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            result.add(entry.getValue() + "," + entry.getKey());
        }
        return result;
    }

    public static void main(String args[]){

        String[] cpdomains = {"900,google.com", "50,yahoo.com", "1,mail.yahoo.com", "5,gaming.google.com"};

        List<String> domainCount=subDomainVisit(cpdomains);

        System.out.println(domainCount);
    }
}
