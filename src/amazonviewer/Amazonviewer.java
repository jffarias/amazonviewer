package amazonviewer;
import amazonviewer.model.Book;
import java.util.Date;

import amazonviewer.model.Movie;
import amazonviewer.model.Serie;
import amazonviewer.model.Chapter;
import amazonviewer.model.Film;
import amazonviewer.model.Magazine;
import amazonviewer.util.AmazonUtil;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import makereport.Report;

/**
 *
 * <h1>AmazonViewer</h1>
 * AmazonViewer es un programa que permite visualizar Series, Movies con su 
 * respectivos Chapters.
 * <p>
 * Existen algunas reglas como todos los elementos pueden ser visualizados 
 * o leídos a excepción de las Magazines, estas sólo pueden ser vistas 
 * a modo de exposición sin ser leídas.
 * @author Iesous_Flor
 * @version 1.1
 * @since   2018 - 2019
 * 
 **/
public class Amazonviewer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        showMenu();
    }

    public static void showMenu() {
        int exit = 0;
        do {

                System.out.println("BIENVENIDOS AMAZON VIEWER");
                System.out.println("");
                System.out.println("Selecciona el número de la opción deseada");
                System.out.println("1. Movies");
                System.out.println("2. Series");
                System.out.println("3. Books");
                System.out.println("4. Magazines");
                System.out.println("5. Report");
                System.out.println("6. Report Today");
                System.out.println("0. Exit");

                //Leer la respuesta del usuario
                //int response = 1;
                int response = AmazonUtil.validateUserResponseMenu(0,6);
                switch (response) {
                        case 0:
                                //salir
                            exit=0;
                            break;
                        case 1:
                                showMovies();
                                break;
                        case 2:
                                showSeries();
                                break;
                        case 3:
                                showBooks();
                                break;
                        case 4:
                                showMagazines();
                                break;
                        case 5:
                                makeReport();
                                exit = 1;
                                break;
                        case 6:
                                //Date date = new Date();
                                makeReport(new Date());
                                exit = 1;
                                break;

                        default:
                                System.out.println();
                                System.out.println("....¡¡Selecciona una opción!!....");
                                System.out.println();
                                exit = 1;
                                break;
                }


        }while(exit != 0);
    }

    static ArrayList<Movie> movies = Movie.makeMoviesList();
    public static void showMovies() {
        int exit = 1;
        do {
                System.out.println();
                System.out.println(":: MOVIES ::");
                System.out.println();
                
                for(int i=0; i<movies.size(); i++){
                    System.out.println(i+1 + ". " + movies.get(i).getTitle() + " Visto: " + movies.get(i).isViewed());
                }
                System.out.println("0. Regresar al Menu");
                System.out.println();
                //Leer respuesta del usuaruio
                //Scanner sc = new Scanner(System.in);
                //int response =  Integer.valueOf(sc.nextLine());
                int response = AmazonUtil.validateUserResponseMenu(0, movies.size());
                if(response == 0){
                    exit = 0;
                    showMenu();
                    break;
                }
                if(response > 0){
                    Movie movieSelected = movies.get(response-1);
                    movieSelected.view();
                    /*movieSelected.setViewed(true);
                    Date dateI = movieSelected.startToSee(new Date());
                    for(int i=0; i<100000;i++){
                        System.out.println("..............");
                    }
                    //Terminamos de verla
                    movieSelected.stopToSee(dateI, new Date());
                    System.out.println();
                    System.out.println("Viste :"+movieSelected);
                    System.out.println("Por: " + movieSelected.getTimeViewed() + " milisegundos");*/
                }
        }while(exit !=0);

    }

    static ArrayList<Serie> series = Serie.makeSeriesList();
    public static void showSeries() {
        int exit = 0;
        do {
                System.out.println();
                System.out.println(":: SERIES ::");
                System.out.println();
                for(int i=0; i < series.size(); i++){
                    System.out.println(i+1 +". "+series.get(i).getTitle()+" Visto: "+series.get(i).isViewed());
                }
                System.out.println("0. Regresar al Menu");
                System.out.println();
                //Leer respuesta usuario
                int response = AmazonUtil.validateUserResponseMenu(0, series.size());
                if(response == 0){
                    exit = 0;
                    showMenu();
                    break;
                }
                //Mostramos los capitulos de la serie
                showChapters(series.get(response-1).getChapters(), response-1);
                
        }while(exit !=0);
    }

    
    public static void showChapters(ArrayList<Chapter> chaptersOfSerieSelected, int serieSelected) {
        int exit = 1;
        do {
                System.out.println();
                System.out.println(":: CHAPTERS ::");
                System.out.println();
                for(int i = 0; i < chaptersOfSerieSelected.size(); i++){
                    System.out.println(i+1+". "+chaptersOfSerieSelected.get(i).getTitle()+" Visto:"+chaptersOfSerieSelected.get(i).isViewed());
                
                }
                System.out.println("0. Regresar al Menu");
                System.out.println();
                //Leer respuesta del usuaruio
                //Scanner sc = new Scanner(System.in);
                //int response =  Integer.valueOf(sc.nextLine());
                int response = AmazonUtil.validateUserResponseMenu(0, chaptersOfSerieSelected.size());
                if(response == 0){
                    exit = 0;
                    showSeries();
                    break;
                }
                if(response > 0){
                    Chapter chapterSelected = chaptersOfSerieSelected.get(response-1);
                    chapterSelected.view();
                    /*series.get(serieSelected).setViewed(true);
                    Date dateI = chapterSelected.startToSee(new Date());
                    for(int i=0; i<100000;i++){
                        System.out.println("..............");
                    }
                    //Terminamos de verla
                    chapterSelected.stopToSee(dateI, new Date());
                    System.out.println();
                    System.out.println("Viste :"+chapterSelected);
                    System.out.println("Por: " + chapterSelected.getTimeViewed() + " milisegundos");*/
                }
        }while(exit !=0);
    }

    static ArrayList<Book> books = Book.makeBooksList();
    public static void showBooks() {
        int exit = 1;
        do {
                System.out.println();
                System.out.println(":: BOOKS ::");
                System.out.println();
                for(int i=0; i<books.size(); i++){
                    System.out.println(i+1 + ". " + books.get(i).getTitle() + " Visto: " + books.get(i).isReaded());
                }
                System.out.println("0. Regresar al Menu");
                System.out.println();
                //Leer respuesta del usuaruio
                //Scanner sc = new Scanner(System.in);
                //int response =  Integer.valueOf(sc.nextLine());
                int response = AmazonUtil.validateUserResponseMenu(0, books.size());
                if(response == 0){
                    exit = 0;
                    showMenu();
                    break;
                }
                if(response > 0){
                    Book bookSelected = books.get(response-1);
                    bookSelected.view();
                    /*Date dateI = bookSelected.startToSee(new Date());
                    for(int i=0; i<100000;i++){
                        System.out.println("..............");
                    }
                    //Terminamos de verla
                    bookSelected.stopToSee(dateI, new Date());
                    System.out.println();
                    System.out.println("Viste :"+bookSelected);
                    System.out.println("Por: " + bookSelected.getTimeReaded() + " milisegundos");*/
                }
        }while(exit !=0);
    }

    static ArrayList<Magazine> magazines = Magazine.makeMagazinesList();
    public static void showMagazines() {
        int exit = 1;
        do {
                System.out.println();
                System.out.println(":: MAGAZINES ::");
                System.out.println();
                for(int i=0; i<magazines.size(); i++){
                    System.out.println(i+1 + ". " + magazines.get(i).getTitle() + " Visto: " + magazines.get(i).isReaded());
                }
                System.out.println("0. Regresar al Menu");
                System.out.println();
                //Leer respuesta del usuaruio
                //Scanner sc = new Scanner(System.in);
                //int response =  Integer.valueOf(sc.nextLine());
                int response = AmazonUtil.validateUserResponseMenu(0, magazines.size());
                if(response == 0){
                    exit = 0;
                    showMenu();
                    break;
                }
                if(response > 0){
                    Magazine magazineSelected = magazines.get(response-1);
                    magazineSelected.setReaded(true);
                    Date dateI = magazineSelected.startToSee(new Date());
                    for(int i=0; i<100000;i++){
                        System.out.println("..............");
                    }
                    //Terminamos de verla
                    magazineSelected.stopToSee(dateI, new Date());
                    System.out.println();
                    System.out.println("Viste :"+magazineSelected);
                    System.out.println("Por: " + magazineSelected.getTimeReaded() + " milisegundos");
                }
        }while(exit !=0);
    }

    /*Las siguientes metodos es un ejemplo de Sobrecarga de métodos
    2 metodos con el mismo nombre pero una recibe un parametro*/
    public static void makeReport() {
        Report report = new Report();
        report.setNameFile("Reporte");
        report.setExtension("txt");
        report.setTitle("::: VISTAS :::");
        
        String contentReport = "";
        for(Movie movie : movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString()+"\r\n";
            }
        }
        report.setContent(contentReport);
        report.makeReport();
        
    }

    public static void makeReport(Date date) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = df.format(date);
        Report report = new Report();
        report.setNameFile("Reporte" + dateString);
        report.setExtension("txt");
        report.setTitle("::: VISTAS :::");
        
        String contentReport = "";
        for(Movie movie : movies){
            if(movie.getIsViewed()){
                contentReport += movie.toString()+"\r\n";
            }
        }
        report.setContent(contentReport);
        report.makeReport();
    }
}
