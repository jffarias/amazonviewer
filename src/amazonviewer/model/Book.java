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
public class Book extends Publication implements IVisualizable{
    private int id;
    private String isbn;
    private boolean readed;
    private int timeReaded;
    
    public Book(String title, Date edititionDate, String editorial, String[] authors) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
        setAuthors(authors);
    }
    
    public int getId() {
		return id;
	}
    public String getIsbn() {
            return isbn;
    }


    public void setIsbn(String isbn) {
            this.isbn = isbn;
    }

    public int getTimeReaded() {
            return timeReaded;
    }


    public void setTimeReaded(int timeReaded) {
            this.timeReaded = timeReaded;
    }

    /*Al sobreescribir este metodo aplicamos polimorfismo*/
    @Override
    public String toString() {
            // TODO Auto-generated method stub
            String detailBook = "\n :: BOOK ::" + 
                                "\n Title: " + getTitle() +
                                "\n Editorial: " + getEditorial() + 
                                "\n Edition Date: " + getEdititionDate() +
                                "\n Authors: ";
            for (int i = 0; i < getAuthors().length; i++) {
                    detailBook += "\t" + getAuthors()[i];
            }
            return  detailBook;
    }

    /*iNTERFACES*/
    @Override
    public Date startToSee(Date dateI) {
        return dateI;
    }

    @Override
    public void stopToSee(Date dateI, Date dateF) {
        if (dateF.getTime() > dateI.getTime()) {
                setTimeReaded((int)(dateF.getTime() - dateI.getTime()));
        }else {
                setTimeReaded(0);
        }
    }
    
    public static ArrayList<Book> makeBooksList(){
        ArrayList<Book> books = new ArrayList();
        String[] authorsBook = {"Autor 1", "Autor 2"};
        for(int i=1; i <= 5; i++){
            books.add(new Book("Book "+i, new Date(), "Porrua", authorsBook));
        }
        return books;
    }
}
