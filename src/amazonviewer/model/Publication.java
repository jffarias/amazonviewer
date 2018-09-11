/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;

/**
 *
 * @author i5
 */
import java.util.Date;
public class Publication {
    private String title;
    private Date edititionDate;
    private String editorial;
    private String[] authors;
    private boolean readed;
    
    public Publication(String title, Date edititionDate, String editorial) {
        super();
        this.title = title;
        this.edititionDate = edititionDate;
        this.editorial = editorial;
    }
    
    public String getTitle() {
		return title;
	}
    public void setTitle(String title) {
            this.title = title;
    }
    public Date getEdititionDate() {
            return edititionDate;
    }
    public void setEdititionDate(Date edititionDate) {
            this.edititionDate = edititionDate;
    }
    public String getEditorial() {
            return editorial;
    }
    public void setEditorial(String editorial) {
            this.editorial = editorial;
    }
    public String[] getAuthors() {
            return authors;
    }
    public void setAuthors(String[] authors) {
            this.authors = authors;
    }
    public String isReaded() {
        String leido = "";
        if(readed){
            leido = "SI";
        }else{
            leido = "No";
        }
        return leido;
    }


    public void setReaded(boolean readed) {
            this.readed = readed;
    }
}
