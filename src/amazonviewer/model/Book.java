/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;

import amazonviewer.util.AmazonUtil;
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
    private ArrayList<Page> pages;
    
    
    public Book(String title, Date edititionDate, String editorial, String[] authors, ArrayList<Page> pages) {
        super(title, edititionDate, editorial);
        // TODO Auto-generated constructor stub
        setAuthors(authors);
        this.pages = pages;
    }

    public ArrayList<Page> getPages() {
        return pages;
    }

    public void setPages(ArrayList<Page> pages) {
        this.pages = pages;
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
        String[] authors = new String[3];
            for (int i = 0; i < 3; i++) {
                    authors[i] = "author "+i;
            }
        /**
         * Video 16
         */
        ArrayList<Page> pages = new ArrayList();
        int pagina = 0;
        for(int i = 0; i < 3; i++){
            pagina = i + 1;
            pages.add(new Book.Page(pagina, "El contenido de la página "+pagina));
        }
        for (int i = 1; i <= 5; i++) {
                books.add(new Book("Book " + i, new Date(), "editorial " + i, authors, pages));
        }
        return books;
    }
    
     //Video 7 - Curso Avanzado de Java SE
    //Implementando métodos abstractos en Java
    public void view(){
        setReaded(true);
        Date dateI = startToSee(new Date());
        int i = 0;
        do {
            System.out.println("...........");
            System.out.println("Page:  "+getPages().get(i).getNumber());
            System.out.println("Content: "+getPages().get(i).getContent());
            System.out.println("...........");
            
            if( i != 0){
                System.out.println("1. Regresar página. ");
            }
            System.out.println("2. Siguiente página. ");
            System.out.println("0 . Cerrar libro. ");
            System.out.println();
            
            int response = AmazonUtil.validateUserResponseMenu(0, 2);
            if(response == 2){
                i++;
            }else if(response == 1){
                i--;
            }else if(response == 0){
                break;
            }
        }while(i < getPages().size());
        /**
         * Se borra en video 16
         */
        /*for(int i=0; i<100000;i++){
            System.out.println("..............");
        }*/
        //Terminamos de verla
        stopToSee(dateI, new Date());
        System.out.println();
        System.out.println("Leiste :"+toString());
        System.out.println("Por: " + getTimeReaded() + " milisegundos");
    }
    
    public static class Page {
        private int id;
        private int number;
        private String content;

        public Page(int number, String content) {
            super();
            this.number = number;
            this.content = content;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
        
    }
}
