package no.bragalund.springserver;

public class Host {

    private String hostname;


    public Host() {
        this.hostname = System.getenv("HOSTNAME");
    }

    public String getHostname() {
        return System.getenv("HOSTNAME");
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
