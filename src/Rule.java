public class Rule {
    private String direction;
    private String protocol;
    private Port port;
    private IpAddress ip;

    public Rule(String direction, String protocol, String port, String ip) {
        this.direction = direction;
        this.protocol = protocol;
        this.port = new Port(port);
        this.ip = new IpAddress(ip);
    }


    public boolean satisfiesRule(Rule inputRule) {
        return (
                inputRule.direction.equals(this.direction) &&
                        inputRule.protocol.equals(this.protocol) &&
                        inputRule.port.satisfiesPortRange(this.port) &&
                        inputRule.ip.satisfiesIpRange(this.ip)
        );
    }
}
