package lok.tar.app.web;

import lok.tar.app.domain.User;
import lok.tar.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by Frank on 2017/5/27.
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    //@RequestMapping(value = "/current", method = RequestMethod.GET)
    //public Principal getUser(Principal principal) {
    //    return principal;
    //}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public void createUser(@Valid @RequestBody User user) {
        userService.create(user);
    }

}
