package no.bragalund.springserver;

public class Host {

    private String hostname;


    public Host() {
        this.hostname = System.getenv("HOSTNAME");
    }

    public String getHostname() {
        return "Docker-container_id is: "+System.getenv("HOSTNAME");
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
