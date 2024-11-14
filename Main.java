import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Main {
    private List<Film> films;
    private List<Actor> actors;

    public Main() {
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

    // Main method
    public static void main(String[] args) {
        Main db = new Main();

        // actors
        Actor margotRobbie = new Actor("Margot Robbie");
        Actor ryanGosling = new Actor("Ryan Gosling");
        Actor americaFerrera = new Actor("America Ferrera");
        Actor tomHolland = new Actor("Tom Holland");
        Actor zendaya = new Actor("Zendaya");
        Actor jakeGyllenhaal = new Actor("Jake Gyllenhaal");
        Actor caryElwes = new Actor("Cary Elwes");
        Actor dannyGlover = new Actor("Danny Glover");
        Actor monicaPotter = new Actor("Monica Potter");
        Actor mikhailoPoplavsky = new Actor("Mikhailo Poplavsky"); // This actor will not be in any film

        // Add actors
        db.addActor(margotRobbie);
        db.addActor(ryanGosling);
        db.addActor(americaFerrera);
        db.addActor(tomHolland);
        db.addActor(zendaya);
        db.addActor(jakeGyllenhaal);
        db.addActor(caryElwes);
        db.addActor(dannyGlover);
        db.addActor(monicaPotter);
        db.addActor(mikhailoPoplavsky);

        // films
        Film barbie = new Film("Barbie (2023)");
        Film spiderManFFH = new Film("Spider-Man: Far From Home");
        Film saw = new Film("Saw");

        // Add films
        db.addFilm(barbie);
        db.addFilm(spiderManFFH);
        db.addFilm(saw);

        // Add actors to films
        barbie.addActor(margotRobbie);
        barbie.addActor(ryanGosling);
        barbie.addActor(americaFerrera);

        spiderManFFH.addActor(tomHolland);
        spiderManFFH.addActor(zendaya);
        spiderManFFH.addActor(jakeGyllenhaal);

        saw.addActor(caryElwes);
        saw.addActor(dannyGlover);
        saw.addActor(monicaPotter);

        // Task 1
        List<Actor> actorsWithNoFilms = db.getActorsWithNoFilms();
        if (!actorsWithNoFilms.isEmpty()) {
            System.out.println("Actors who have not acted in any film:");
            for (Actor actor : actorsWithNoFilms) {
                System.out.println("- " + actor.getName());
            }
        } else {
            System.out.println("All actors have acted in at least one film.");
        }

        // Task 2
        List<Actor> coActorsOfTom = db.getCoActors(tomHolland);
        System.out.println("Actors who have ever played with " + tomHolland.getName() + ": " + coActorsOfTom);

        // Task 3
        Film filmWithMostActors = db.getFilmWithMostActors();
        System.out.println("Film with the most actors: " + filmWithMostActors.getTitle());
    }
}
