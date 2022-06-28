import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws MenuException {
        Scanner scanner = new Scanner(System.in);
        TimeTable timeTable = new TimeTable();
        menuPrinter(scanner, timeTable);

    }

    private static void menuPrinter(Scanner scanner, TimeTable timeTable) throws MenuException {
        System.out.println("Welcome to CinaWoman" );
        System.out.println("Please enter your name: " );
        String input = scanner.nextLine();
        Client client = new Client(input);
        System.out.println("Welcome to CinaWoman " + client.getName());

        ArrayList<Movie> movieList = timeTable.createTimeTable();
        System.out.println("Choose one of the movies listed: " );
        for (int movieNumber = 0; movieNumber < movieList.size(); movieNumber++) {
            System.out.println("[" + (movieNumber) + "] " + movieList.get(movieNumber).getMovieTitle());
        }
        Movie chosenMovie;
        try {
            String chosenNumber = scanner.nextLine();
            chosenMovie = movieList.get(Integer.parseInt(chosenNumber));
            System.out.println("You chose " + chosenMovie.getMovieTitle());
        } catch (IndexOutOfBoundsException e) {
            throw new MenuException("Choose one of the movies listed: " );


        } catch (NumberFormatException e) {
            throw new MenuException("Please type a number");
        }
        System.out.println("Would you like to ...");
        int choice = -1;
        do {
            System.out.println(" [1] Reserve a seat");
            System.out.println(" [2] Show more information");
            System.out.println(" [0] Close programm");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1 -> {
                        if(chosenMovie.getFreeSeats()<=0){
                            throw new MenuException("Unfortunately there are [0] seats available");
                        }
                        if(chosenMovie.getFreeSeats()>0){
                            chosenMovie.setFreeSeats(chosenMovie.getFreeSeats()-1);
                            System.out.println("You successfully reserved a seat for "+ chosenMovie.getMovieTitle());
                            System.out.println(chosenMovie.getMovieTitle() + " has [" + chosenMovie.getFreeSeats() + "] seat(s) still available"  );
                        }
                    }
                    case 2 -> System.out.println(chosenMovie.getMovieTitle() + " is playing in Cinema [" + chosenMovie.getCinemaNr() + "] at " + chosenMovie.getPlayTime() );
                    case 0 -> System.out.println("Program closed");
                    default -> throw new MenuException("Choose one of the options in the menu (0-2)");
                }
            } catch (MenuException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 0);
        scanner.close();
    }

}
