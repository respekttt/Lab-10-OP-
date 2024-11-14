import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Database {

    private List<Film> films;
    private List<Actor> actors;

    public Database() {
        films = new ArrayList<Film>();
        actors = new ArrayList<Actor>();
    }

    public List<Film> getFilms() {
        return films;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void addFilm(Film film) {
        if (!films.contains(film)) {
            films.add(film);
        }
    }

    public void addActor(Actor actor) {
        if (!actors.contains(actor)) {
            actors.add(actor);
        }
    }

    // Task 1:
    public List<Actor> getActorsWithNoFilms() {
        List<Actor> actorsWithNoFilms = new ArrayList<Actor>();
        // Typed iterator
        Iterator<Actor> iterator = actors.iterator();
        while (iterator.hasNext()) {
            Actor actor = iterator.next();
            if (actor.getFilms().isEmpty()) {
                actorsWithNoFilms.add(actor);
            }
        }
        return actorsWithNoFilms;
    }

    // Task 2:
    public List<Actor> getCoActors(Actor givenActor) {
        List<Actor> coActors = new ArrayList<Actor>();
        // Typed for-each loop
        for (Film film : givenActor.getFilms()) {
            for (Actor actor : film.getActors()) {
                if (!actor.equals(givenActor) && !coActors.contains(actor)) {
                    coActors.add(actor);
                }
            }
        }
        return coActors;
    }

    // Task 3:
    public Film getFilmWithMostActors() {
        // Untyped iterator
        Iterator iterator = films.iterator();
        Film maxFilm = null;
        int maxActors = 0;
        while (iterator.hasNext()) {
            Film film = (Film) iterator.next();
            int numActors = film.getActors().size();
            if (numActors > maxActors) {
                maxActors = numActors;
                maxFilm = film;
            }
        }
        return maxFilm;
    }
}