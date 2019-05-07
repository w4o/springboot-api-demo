package lok.tar.app.service;

import lok.tar.app.domain.User;

/**
 * @author frank
 * @date 2017/5/27.
 */
public interface UserService {

    /**
     * 创建用户
     *
     * @param user 用户
     */
    void create(User user);

}
