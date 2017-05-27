package lok.tar.app.repository;

import lok.tar.app.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Created by Frank on 2017/5/27.
 */
public interface UserRepository extends CrudRepository <User, Integer> {

    /**
     * 根据用户名查找用户
     * @param userName
     * @return
     */
    @Query("select u from User  u where username=:username")
    User getUserByUsername(@Param(value="username") String userName);
}
