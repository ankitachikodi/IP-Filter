import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Firewall {

    List<Rule> filterRules;

    public Firewall(String filepath) throws IOException {
        filterRules = new ArrayList<>();
        File file = new File(filepath);
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] attributes = line.split(",");
            filterRules.add(new Rule(
                    attributes[0],
                    attributes[1],
                    attributes[2],
                    attributes[3]
            ));
        }
    }

    public boolean accept_packet(String direction, String protocol, int port, String ip_address) {
        Rule rule = new Rule(direction, protocol, String.valueOf(port), ip_address);

        for(Rule filterRule: filterRules){
            if(rule.satisfiesRule(filterRule))
                return true;
        }
        return false;
    }
}
