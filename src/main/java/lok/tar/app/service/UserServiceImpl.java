package lok.tar.app.service;

import lok.tar.app.domain.User;
import lok.tar.app.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

/**
 * @author frank
 * @date 2019-05-07 17:41
 */
@Service
public class UserServiceImpl implements UserService {

    private final BCryptPasswordEncoder encoder;

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        encoder = new BCryptPasswordEncoder();
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {

        User existing = userRepository.getUserByUsername(user.getUsername());
        Assert.isNull(existing, "user already exists: " + user.getUsername());

        String hash = encoder.encode(user.getPassword());
        user.setPassword(hash);

        userRepository.save(user);
    }


}
