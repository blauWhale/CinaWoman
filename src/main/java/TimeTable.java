import java.util.ArrayList;

public class TimeTable {

    private ArrayList<Movie> listOfMovies = new ArrayList<Movie>();
    private JsonReader jsonReader = new JsonReader();

    public ArrayList<Movie> createTimeTable(){
        listOfMovies.removeAll(listOfMovies);
        listOfMovies = jsonReader.readJsonFile();
        return listOfMovies;
    }

    public ArrayList<Movie> getListOfMovies() {
        return listOfMovies;
    }
}
