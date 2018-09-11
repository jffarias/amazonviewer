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
public class Magazine extends Publication implements IVisualizable {
    private int id;
    private boolean readed;
    private int timeReaded;

    public int getTimeReaded() {
        return timeReaded;
    }

    public void setTimeReaded(int timeReaded) {
        this.timeReaded = timeReaded;
    }
    
    public int getId() {
        return id;
    }
    
    public Magazine(String title, Date editionDate, String editorial){
        super(title, editionDate, editorial);
    }
    
    @Override
    public String toString(){
        return  "\n :: MAGAZINE ::" + 
                "\n Title: " + getTitle() +
                "\n Editorial: " + getEditorial() + 
                "\n Edition Date: " + getEdititionDate();
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
    
    //Mostramos lista de revista
    public static ArrayList<Magazine> makeMagazinesList(){
        ArrayList<Magazine> magazines = new ArrayList();
        for(int i=1; i<=5; i++){
            magazines.add(new Magazine("Titulo "+i,new Date(),"PC Magazine"));
        }
        return magazines;
    }
}
