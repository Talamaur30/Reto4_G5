/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Reto4_G5.Reto4_G5.Services;

import Reto4_G5.Reto4_G5.Model.Reservaciones;
import Reto4_G5.Reto4_G5.Repository.RepositorioReservaciones;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author JUANCHO
 */

@Service
/**
 * Clase principal Servicio de Reservaciones
 */
public class ServiciosReservaciones {
     @Autowired
     /**
      * Enlace de repositorio de reservaciones con metodo CRUD
      */
    private RepositorioReservaciones metodosCrud;
     
     /**
      * 
      * @return 
      */
    public List<Reservaciones> getAll(){
        return metodosCrud.getAll();
    }
    /**
     * 
     * @param reservationId
     * @return 
     */
    public Optional<Reservaciones> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservaciones save(Reservaciones reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }
    /**
     * 
     * @param reservation
     * @return 
     */
    public Reservaciones update(Reservaciones reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reservaciones> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }
    /**
     * 
     * @param reservationId
     * @return 
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
            }).orElse(false);
        return aBoolean;
    }
}
