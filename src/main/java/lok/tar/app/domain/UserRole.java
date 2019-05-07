package lok.tar.app.domain;

import lok.tar.app.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

/**
 * @author frank
 * @date 2017/5/27.
 */
@Data
@EqualsAndHashCode(callSuper = false)
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
