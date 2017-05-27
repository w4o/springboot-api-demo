package lok.tar.app.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Frank on 2017/5/27.
 */
@RestController
@RequestMapping("/noauth")
public class NoAuthDemoController {

    @RequestMapping(value="/hello", method = RequestMethod.GET)
    String hello(){
        return "Hello No Auth Demo";
    }

}
