package no.bragalund.springserver;

import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @RequestMapping(value = "/hostname", method = RequestMethod.GET)
    @ResponseBody
    public String getHostName() {
        Host host = new Host();
        return host.getHostname();
    }

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    public @ResponseBody String getHeartBeat() {
        return "<3";
    }

}
