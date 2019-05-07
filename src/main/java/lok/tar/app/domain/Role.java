package lok.tar.app.domain;

import lok.tar.app.commons.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author frank
 * @date 2017/5/27.
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Entity
@Table(name = "role")
public class Role extends BaseEntity {

    @Column(name = "name")
    private String name;
}
