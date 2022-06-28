import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;


public class JsonReader {
    private ArrayList<Movie> teamArrayList = new ArrayList<Movie>();

    public ArrayList<Movie> readJsonFile() {
        JSONParser jsonParser = new JSONParser();
        try (FileReader reader = new FileReader("movies.json")) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            parseMovieObject((JSONObject) obj);
            return teamArrayList;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return teamArrayList;
    }


    public void parseMovieObject(JSONObject object) {

        JSONArray moviesJsonArr = (JSONArray) object.get("movies");
        for (Object o : moviesJsonArr) {
            JSONObject moviesJsonObj = (JSONObject) o;
            Movie movie = new Movie((String) moviesJsonObj.get("title"), Integer.parseInt((String) moviesJsonObj.get("lengthInMinutes")) , Integer.parseInt((String) moviesJsonObj.get("cinemaNr")), LocalDateTime.parse((String) moviesJsonObj.get("playTime")), Integer.parseInt((String) moviesJsonObj.get("freeSeats")));
            teamArrayList.add(movie);
        }
    }

}

