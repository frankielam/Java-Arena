package today.lqf.microservice.example.forex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ForexController {

    @Autowired
    ExchangeValueRepository reposity;

    @Autowired
    Environment environment;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue exchange(@PathVariable String from, @PathVariable String to) {

        ExchangeValue value = reposity.findByFromAndTo(from, to);
        value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return value;
    }
}
