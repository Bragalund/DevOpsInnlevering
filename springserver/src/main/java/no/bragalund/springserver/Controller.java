package no.bragalund.springserver;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping(value = "/hostname", method = RequestMethod.GET)
    @ResponseBody
    public String getHostName() {
        return System.getenv("HOSTNAME");
    }

    @RequestMapping(value = "/heartbeat", method = RequestMethod.GET)
    @ResponseBody
    public String getHeartBeat() {
        return "<3";
    }

}
