/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package amazonviewer.model;
import java.util.Date;

/**
 *<h1>IVisualizable</h1>
 * @author Iesous_Flor
 * Aplicamos Interfaces
 */
public interface IVisualizable {
    /*Defnimos los metodos de tiempo de vista*/
    /**
     * Este metodo captura el tiempo exacto de inicio de visualizacion.
     * 
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
     * @return Devuelve la fecha y hora capturada.
     */
    Date startToSee(Date dateI);
    
    /**
     * Este metodo captura el tiempo exacto de inicio y final de visualizacion.
     * 
     * @param dateI Es un objeto {@code Date} con el tiempo de inicio exacto.
     * @param dateF Es un objeto {@code Date} con el tiempo de final exacto.
     */
    void stopToSee(Date dateI, Date dateF);
}
