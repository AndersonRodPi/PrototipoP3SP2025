/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador.seguridad;

/**
 *
 * @author visitante
 */
public class Cine {
    
    int idCines;
    String Nombre;
    String Dirección;

    public Cine(int idCines, String Nombre, String Dirección) {
        this.idCines = idCines;
        this.Nombre = Nombre;
        this.Dirección = Dirección;
    }

    @Override
    public String toString() {
        return "Cine{" + "idCines=" + idCines + ", Nombre=" + Nombre + ", Dirección=" + Dirección + '}';
    }
    
    public int getIdCines() {
        return idCines;
    }

    public void setIdCines(int idCines) {
        this.idCines = idCines;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDirección() {
        return Dirección;
    }

    public void setDirección(String Dirección) {
        this.Dirección = Dirección;
    }

    public Cine() {
    }
   
}
