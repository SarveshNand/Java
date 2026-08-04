package LoveBabbarTasks.OOPS.Intro;

public class Movie {
//    Attributes
    public String movieName;
    public String hero;
    public double rating;

    public Movie(String movieName, String hero, double rating){
        this.movieName = movieName;
        this.hero = hero;
        this.rating = rating;
    }

    public void display(){
        System.out.println("Movie Name: " + movieName);
        System.out.println("Movie Hero: " + hero);
        System.out.println("Movie Rating: " + rating);
    }
}
