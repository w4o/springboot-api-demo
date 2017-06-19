package lok.tar.app.domain;

import lok.tar.app.commons.BaseEntity;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by Frank on 2017/6/19.
 */
@Data
@Entity
@Table(name = "user_role")
public class UserRole extends BaseEntity {

    @Column(name = "user_id")
    private Integer userId;
    @Column(name = "role_id")
    private Integer roleId;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", insertable = false, updatable = false)
    private Role role;
}
