import java.util.List;
import java.util.ArrayList;

public class Film {
    private String title;
    private List<Actor> actors;

    public Film(String title) {
        this.title = title;
        this.actors = new ArrayList<Actor>();
    }

    public String getTitle() {
        return title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addActor(Actor actor) {
        if (!actors.contains(actor)) {
            actors.add(actor);
            actor.addFilm(this); // Add this film to the actor's list of films
        }
    }

    @Override
    public String toString() {
        return title;
    }
}
