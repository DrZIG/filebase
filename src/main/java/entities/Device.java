package entities;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

/**
 * name
 */
@Entity
@Table(name = "devices", uniqueConstraints = {@UniqueConstraint(columnNames = "id")})
public class Device {
    @Id
    @GeneratedValue
    @Column(nullable = false, updatable = false)
    private int id;

    @NotNull
    @Column(nullable = false)
    private String name;

    @NotNull
    @OneToMany(optional = false, cascade = CascadeType.ALL)
    private List<File> files;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
