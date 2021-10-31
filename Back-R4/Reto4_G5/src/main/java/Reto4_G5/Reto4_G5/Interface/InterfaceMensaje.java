/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Reto4_G5.Reto4_G5.Interface;

import Reto4_G5.Reto4_G5.Model.Mensaje;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author JUANCHO
 */
public interface InterfaceMensaje extends CrudRepository<Mensaje,Integer> {
    
}
