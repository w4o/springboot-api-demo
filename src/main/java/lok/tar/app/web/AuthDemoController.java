package lok.tar.app.web;

import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Frank on 2017/5/27.
 */
@RestController
@RequestMapping("/authdemo")
public class AuthDemoController {


    @ApiOperation(value = "这是一个需要授权才能访问的 Hello 资源")
    @PreAuthorize("#oauth2.hasScope('server')")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    String hello() {
        return "Hello Auth Demo!";
    }
}
