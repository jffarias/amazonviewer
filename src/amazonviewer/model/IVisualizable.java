/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;
import java.util.Date;

/**
 *
 * @author i5
 * Aplicamos Interfaces
 */
public interface IVisualizable {
    /*Defnimos los metodos de tiempo de vista*/
    Date startToSee(Date dateI);
    void stopToSee(Date dateI, Date dateF);
}
