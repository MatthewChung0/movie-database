package moviedata;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class MovieDB {

    private List<Movie> movieDB;
    private static final int INITIAL_CAPACITY = 20;
    private static final int STARTER_MOVIEDB_SIZE = 15;

    private Set<IndexEntry> titleIndex;

    public MovieDB() { 
    	movieDB = new ArrayList<Movie>();
    	titleIndex = new TreeSet<IndexEntry>();
        
    }

    public void createStartMovieDB() {
    	Random randNumGenerator = new Random();
    	int capacityCounter = 0;
    	Set<Integer> values = new HashSet<Integer>();
    	while(values.size() != STARTER_MOVIEDB_SIZE) {
    		int randNumber = randNumGenerator.nextInt(STARTER_MOVIEDB_SIZE) + 1;
    		
    		if(capacityCounter == INITIAL_CAPACITY) {
    			break;
    		}
    		
    		else if(values.contains(randNumber) == false) {
    			String title = "Title" + randNumber; 
    			String director = "Director" + randNumber;
    			int year = 2021;
    			values.add(randNumber);
    			Movie newMovie = new Movie(title, director, year); 
				movieDB.add(newMovie);
				capacityCounter = capacityCounter + 1;
    			System.out.println(newMovie);
    		}
    		else if(values.contains(randNumber) == true) {
    			capacityCounter = capacityCounter + 1;
    		}
    	}
    	   	
    }

    public void showMovieDB() {
    	System.out.printf("%10s %15s %10s", "TITLE" , "DIRECTOR" , "YEAR");
    	System.out.println();
    	System.out.println("--------------------------------------------------------");
    	
    	for(Movie currentMovie : movieDB) {
    		System.out.format("%10s %15s %10d", currentMovie.getTitle(), currentMovie.getDirector(), currentMovie.getYear());
    		System.out.println();
    	}
    }

    public void createIndex() {
    	int location = 0; 
    	for(Movie currentMovie : movieDB) {
    		location = location + 1;
    		IndexEntry newEntry = new IndexEntry(currentMovie.getTitle(), location); 
    		titleIndex.add(newEntry);
    	}
    }
    
    public void showIndex() {
    	System.out.printf("%10s %10s", "TITLE", "LOCATION");
    	System.out.println();
    	System.out.println("--------------------------");
    	for(IndexEntry currentMovie : titleIndex) {
    		System.out.format("%10s %10d", currentMovie.getTitle(), currentMovie.getLocation());
    		System.out.println();
    	}

    }    

}
