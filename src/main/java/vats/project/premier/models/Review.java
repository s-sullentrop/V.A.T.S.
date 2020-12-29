package vats.project.premier.models;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Review extends AbstractEntity{

    @OneToMany
    @JoinColumn
    private final List<Game> games = new ArrayList<>();

    private String description;

    public Review() {};

    public Review(String description){
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
