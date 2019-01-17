package am.aca.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "country")
public class Country {

    @Id
    @Column(name = "country_id")
    private int id;

    @Column(name = "name")
    private int name;

    @Override
    public String toString() {
        return "Country{" +
                "id=" + id +
                ", name=" + name +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getName() {
        return name;
    }

    public void setName(int name) {
        this.name = name;
    }

    public Country(int name) {
        this.name = name;
    }
}
