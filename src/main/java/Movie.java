import java.time.LocalDateTime;

public class Movie {

    private String title;
    private Integer lengthInMinutes;
    private Integer cinemaNr;
    private LocalDateTime playTime;
    private Integer freeSeats;

    public Movie(String title, Integer lengthInMinutes, Integer cinemaNr, LocalDateTime playTime, Integer freeSeats) {
        this.title = title;
        this.lengthInMinutes = lengthInMinutes;
        this.cinemaNr = cinemaNr;
        this.playTime = playTime;
        this.freeSeats = freeSeats;
    }

    public String getMovieTitle() {
        return title;
    }

    public Integer getFreeSeats() {
        return freeSeats;
    }
}
