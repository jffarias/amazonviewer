/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;

import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author i5
 */
public class Movie extends Film implements IVisualizable{
    private int id;
    private int timeViewed;

    public Movie(String title, String genre, String creator, int duration, short year) {
            super(title, genre, creator, duration);
            setYear(year);
    }

    public void showData() {
        //System.out.println("Title:" + title);
        //System.out.println("Genre:" + genre);
        //System.out.println("Year:" + year);
    }

    public int getId() {
            return id;
    }


    public int getTimeViewed() {
            return timeViewed;
    }
    public void setTimeViewed(int timeViewed) {
            this.timeViewed = timeViewed;
    }

    @Override
    public String toString() {
            // TODO Auto-generated method stub
            return  "\n :: MOVIE ::" + 
                    "\n Title: " + getTitle() +
                    "\n Genero: " + getGenre() + 
                    "\n Year: " + getYear() + 
                    "\n Creator: " + getCreator() +
                    "\n Duration: " + getDuration();
    }

    /*Aplicamos interface definidos en IVisualizable*/
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if(dateF.getTime() > dateI.getTime()){
                setTimeViewed((int)(dateF.getTime() - dateI.getTime()));
        }else {
                setTimeViewed(0);
        }
    }
    
    public static ArrayList<Movie> makeMoviesList(){
        ArrayList<Movie> movies = new ArrayList();
        for(int i=1; i<=5; i++){
            movies.add(new Movie("Movie " + i, "Genero " + i, "Creador " + i, 120+i, (short)(2017+i)));
        }
        return movies;
    }

    @Override
    public void view() {
        setViewed(true);
        Date dateI = startToSee(new Date());
        for(int i=0; i<1000;i++){
            System.out.println("..............");
        }
        //Terminamos de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Viste :"+toString());
        System.out.println("Por: " + getTimeViewed() + " milisegundos");
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
