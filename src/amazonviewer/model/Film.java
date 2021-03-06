/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;
/**
 *<h1>Film</h1>
 * Film es una clase padre abstracta
 * <p>
 * Es la clase base de la familia Films, como es abstracta no se puede 
 * instanciar y por ende contiene el método abstracto 
 * {@code view()}
 * @author Iesous_Flor
 */
public abstract class Film {
    /*Mediante los modificadores de acceso podemos
    ocultar los atributos de la clase y al realizar
    esto estamos trabajando con encapsulamiento*/
    private String title;
    private String genre;
    private String creator;
    private int duration;
    private short year;
    private boolean viewed; 
    
    public Film(String title, String genre, String creator, int duration){
        super();
        this.title = title;
        this.genre = genre;
        this.creator = creator;
        this.duration = duration;
    }
    
    public String getTitle() {
		return title;
	}
    public void setTitle(String title) {
            this.title = title;
    }
    public String getGenre() {
            return genre;
    }
    public void setGenre(String genre) {
            this.genre = genre;
    }
    public String getCreator() {
            return creator;
    }
    public void setCreator(String creator) {
            this.creator = creator;
    }
    public int getDuration() {
            return duration;
    }
    public void setDuration(int duration) {
            this.duration = duration;
    }
    public short getYear() {
            return year;
    }
    public void setYear(short year) {
            this.year = year;
    }
    public String isViewed() {
        String visto = "";
        if(viewed){
            visto = "Si";
        }else{
            visto = "No";
        }
        return visto;
    }
    
    public boolean getIsViewed(){
        return viewed;
    }
    public void setViewed(boolean viewed) {
            this.viewed = viewed;
    }
    //Video 5 - Clases avanzadas - Curso Avanzado de Java SE - 2019
    /**
     * {@code view()} es un metodo abstracto obligatorio de implementar
     */
    public abstract void view();
}
