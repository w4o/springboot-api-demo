package lok.tar.app.commons;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author frank
 * @date 2017/5/27.
 */
@MappedSuperclass
@Data
public abstract class BaseEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
}
