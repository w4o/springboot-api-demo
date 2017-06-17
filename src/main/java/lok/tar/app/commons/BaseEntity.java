package lok.tar.app.commons;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by Frank on 2017/6/17.
 */
@MappedSuperclass
public abstract class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @Getter
    @Setter
    private Integer id;
}
