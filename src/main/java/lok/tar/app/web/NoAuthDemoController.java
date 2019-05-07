package lok.tar.app.web;

import io.swagger.annotations.ApiOperation;
import lok.tar.app.domain.CommonResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2017/5/27.
 */
@RestController
@RequestMapping("/noauth")
public class NoAuthDemoController {

    @ApiOperation("这是一个不需要授权就能访问的 Hello 资源")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public CommonResult<String> hello() {
        return new CommonResult<String>().success("Hello No Auth Demo");
    }

}
