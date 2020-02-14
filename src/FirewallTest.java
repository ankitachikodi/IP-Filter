import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class FirewallTest {
    Firewall firewall;

    @org.junit.jupiter.api.BeforeEach
    void setUp() throws IOException {
        firewall = new Firewall("input.csv");
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
    }

    @org.junit.jupiter.api.Test
    public void test1() {
        assertEquals(true, firewall.accept_packet("inbound", "udp", 53, "192.168.2.1"));
    }

    @org.junit.jupiter.api.Test
    public void test2() {
        assertEquals(true, firewall.accept_packet("outbound", "tcp", 10234, "192.168.10.11"));
    }

    @org.junit.jupiter.api.Test
    public void test3() {
        assertEquals(false, firewall.accept_packet("inbound", "tcp", 81, "192.168.1.2"));
    }

    @org.junit.jupiter.api.Test
    public void test4() {
        assertEquals(false, firewall.accept_packet("inbound", "udp", 24, "52.12.48.92"));
    }

}





