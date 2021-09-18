package moviedata;

public class MovieDBConsole {

    public static void main(String[] args) {
        MovieDB myMovieDB = new MovieDB();
        myMovieDB.createStartMovieDB();
        myMovieDB.showMovieDB();
        myMovieDB.createIndex();
        myMovieDB.showIndex();
    }

}
