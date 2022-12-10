/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labexamen2_luismontalvan;
import java.util.ArrayList;
/**
 *
 * @author luism
 */
public class Granja {
    public int monets;
    public String nombre;
    ArrayList vacas = new ArrayList();
    ArrayList conejos = new ArrayList();
    ArrayList veggies = new ArrayList();

    public Granja(int monets) {
        this.monets = monets;
    }
    
    
    
    public void vacas(){
      vacas.add(nombre);
    }
    public void veggies(){
      vacas.add("Veggie");
    }
    public void conejos(){
      vacas.add(nombre);
    }

    public int getMonets() {
        return monets;
    }

    public void setMonets(int monets) {
        this.monets = monets;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

