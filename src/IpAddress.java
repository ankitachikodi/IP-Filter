import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IpAddress {
    private List<Integer> start;
    private List<Integer> end;

    public IpAddress(String ip) {
        if (ip.indexOf('-') != -1) {
            String[] ipRange = ip.split("-");

            this.start = Arrays
                    .stream(ipRange[0].split("\\."))
                    .map(e -> Integer.parseInt(e))
                    .collect(Collectors.toList());

            this.end = Arrays
                    .stream(ipRange[1].split("\\."))
                    .map(e -> Integer.parseInt(e))
                    .collect(Collectors.toList());
        }
        else {
            this.start = this.end = Arrays
                    .stream(ip.split("\\."))
                    .map(e -> Integer.parseInt(e))
                    .collect(Collectors.toList());
        }
    }

    public boolean satisfiesIpRange(IpAddress inputIp) {
        for (int i=0; i<4; i++) {
            if (inputIp.start.get(i) < this.start.get(i) || inputIp.end.get(i) > this.end.get(i)) {
                return false;
            }
        }
        return true;
    }


}
