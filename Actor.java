import java.util.List;
import java.util.ArrayList;

public class Actor {
    private String name;
    private List<Film> films;

    public Actor(String name) {
        this.name = name;
        this.films = new ArrayList<Film>();
    }

    public String getName() {
        return name;
    }

    public List<Film> getFilms() {
        return films;
    }

    public void addFilm(Film film) {
        if (!films.contains(film)) {
            films.add(film);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
