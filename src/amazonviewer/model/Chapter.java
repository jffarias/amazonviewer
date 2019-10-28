/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;

import java.util.ArrayList;

/**
 *
 * @author i5
 */
public class Chapter extends Movie {
    private int id;
	private int sessionNumber;
	private Serie serie;

	public Chapter(String title, String genre, String creator, int duration, short year, int sessionNumber, Serie serie) {
		super(title, genre, creator, duration, year);
		// TODO Auto-generated constructor stub
		this.setSessionNumber(sessionNumber);
		this.setSerie(serie);
	}
	
	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	public int getSessionNumber() {
		return sessionNumber;
	}

	public void setSessionNumber(int sessionNumber) {
		this.sessionNumber = sessionNumber;
	}
	
	
	public Serie getSerie() {
		return serie;
	}

	public void setSerie(Serie serie) {
		this.serie = serie;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return  "\n :: SERIE ::" + 
				"\n Title: " + getSerie().getTitle() +
				"\n :: CHAPTER ::" + 
				"\n Title: " + getTitle() +
				"\n Year: " + getYear() + 
				"\n Creator: " + getCreator() +
				"\n Duration: " + getDuration();
	}
    
    public static ArrayList<Chapter> makeChaptersList(Serie serie) {
        ArrayList<Chapter> chapters = new ArrayList();
        for (int i = 1; i <= 5; i++) {
                chapters.add(new Chapter("Capitulo "+i, "genero "+i, "creator" +i, 45, (short)(2017+i), i, serie));
        }
        return chapters;
    }
    
    //Video 7 - Curso Avanzado de Java SE
    //Implementando métodos abstractos en Java
    @Override
    public void view(){
        super.view();
        ArrayList<Chapter> chapters = getSerie().getChapters();
        int chapterViewedCounter = 0;
        for(Chapter chapter : chapters){
            if(chapter.getIsViewed()){
                chapterViewedCounter++;
            }
        }
        
        if(chapterViewedCounter == chapters.size()){
            getSerie().setViewed(true);
        }
    }
}
