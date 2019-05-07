package lok.tar.app.web;

import io.swagger.annotations.ApiOperation;
import lok.tar.app.domain.CommonResult;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author frank
 * @date 2017/5/27.
 */
@RestController
@RequestMapping("/authdemo")
public class AuthDemoController {


    @ApiOperation(value = "这是一个需要授权才能访问的 Hello 资源")
    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public CommonResult<String> hello() {
        return new CommonResult<String>().success("Hello Auth Demo!");
    }

    @ApiOperation(value = "这是一个需要Admin 权限才能访问的资源")
    @RequestMapping(value = "/admin", method = RequestMethod.GET)
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResult<String> helloAdmin() {
        return new CommonResult<String>().success("Hello Admin!");
    }

    @ApiOperation(value = "这是一个需要User 权限才能访问的资源")
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @PreAuthorize("hasRole('USER')")
    public CommonResult<String> helloUser() {
        return new CommonResult<String>().success("Hello User!");
    }
}
