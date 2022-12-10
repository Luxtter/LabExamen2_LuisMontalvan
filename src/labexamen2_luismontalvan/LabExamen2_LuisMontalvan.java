/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labexamen2_luismontalvan;

import  java.util.Scanner;
/**
 *
 * @author luism
 */
public class LabExamen2_LuisMontalvan {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StardewValley();
    }
    public static void StardewValley(){
        Scanner pelicanTown  = new Scanner(System.in);
        System.out.println("Bienvenido a la granja: Schrute Farms");
        int dia = 1;
        int cosechar= 0;
        int dinero = 500;
        Granja Shrute = new Granja(dinero);//Asi se llama la variable por la granja
        Shrute.setMonets(dinero);
        boolean veggiesCrecen= false;
        do{
            System.out.println("<-------------------- Dia: "+dia+" -------------------->");
            hayCosechas(cosechar, veggiesCrecen);
            System.out.println("Que desea hacer hoy?\n1.- Plantar cosechas\n2.- Cosechar las cosechas\n3.- Conseguir animales\n4.- Vender cosas\n5.- Dormir\n6.- Estado/Estadisticas de la granja");
            int opc = pelicanTown.nextInt();
            Outer:
            do{    
                switch(opc){
                    case 1:
                        if(veggiesCrecen==false){
                            plantar();
                            veggiesCrecen= true;
                        }else if(veggiesCrecen==true){
                            System.out.println("Ya tienes vegetales creciendo, no puedes crecer mas...");
                            Indeciso();
                        }
                        break Outer;
                    case 2:
                        cosechar(cosechar);
                        break Outer;
                    case 3:
                        animales(dinero);
                        break Outer;
                    case 4:
                        analisis(dinero);
                        break Outer;
                    case 5:
                        dormir();
                        break Outer;
                    case 6:
                        Stats(dinero);
                        break;
                    default:
                        Indeciso();
                        break Outer;
                }
            }while(true);
            dia++;
            cosechar++;
            System.out.println("<----------------- FIn Del Dia----------------->");
        }while(dia<=15);
    }
    public static void hayCosechas(int diasCosechar, boolean confirmacion){
        int diasRes= (diasCosechar - 5)*-1;
        if(confirmacion == true){
            if(diasCosechar>=5){
                System.out.println("Ya hay vegetales a cosechar!");
            }else{
                System.out.println("Falta "+diasRes+" dia(s) para la cosecha!");
            }
        }else{
            System.out.println("No has plantado vegetales para cosechar");
        }
    }
    public static void plantar(){
        Scanner pelicanTown = new Scanner(System.in);
        System.out.println("Cuantos vegetales va a plantar?");
        int vegetales = pelicanTown.nextInt();
        System.out.println("Plantando cosechas...\nLas cosechas estaran listas en 5 dias");
    }   
    public static void cosechar(int aCosechar){
        if(aCosechar>=5){
            System.out.println("Has cosechado todos los vegetales");
        }else{
            System.out.println("No hay vegetales a cosechar");
        }
    }
    public static void animales(int dinero){
        Granja Shrute= new Granja(dinero);
        
        Scanner pelicanTown = new Scanner(System.in);
        Scanner penny = new Scanner(System.in);
        System.out.println("Cantidad de dinero actual: "+dinero+"\nQue animales desea?\n1.- Conejos-> 150 monets\n2.- Vacas-> 350 monets");
        int animal = pelicanTown.nextInt();
        
        if(animal==1){
            System.out.println("Cuantos conejos desea?");
            int cantidad= pelicanTown.nextInt();
            if(dinero>cantidad*150){    
                for (int i = 0; i < cantidad; i++) {
                    System.out.println("Ingrese el nombre de su conejo:");
                    String nombre= penny.nextLine();
                    Shrute.setNombre(nombre);
                    Shrute.conejos();
                    System.out.println(Shrute.getNombre()+" ha sido enviado a la granja!");
                    dinero-= cantidad*150;
                    Shrute.setMonets(dinero);
                    System.out.println("Tu nueva cantida de dinero es: "+dinero);
                }
            }else{
                System.out.println("Eres pobre y no pudiste comprar tu numero deseado de conejos\nEn vez de considerar comprar menos te vas decepcionado a casa...");
            }
        }else if(animal == 2){
            System.out.println("Cuantos vacas desea?");
            int cantidad= pelicanTown.nextInt();
            if(dinero>cantidad*150){    
                for (int i = 0; i < cantidad; i++) {
                    System.out.println("Ingrese el nombre de su vaca:");
                    String nombre= penny.nextLine();
                    Shrute.setNombre(nombre);
                    Shrute.vacas();
                    System.out.println(nombre+" ha sido enviado a la granja!");
                    dinero-= cantidad*350;
                    Shrute.setMonets(dinero);
                    System.out.println("Tu nueva cantida de dinero es: "+dinero);  
                }
            }else{
                System.out.println("Eres pobre y no pudiste comprar tu numero deseado de vacas\nEn vez de considerar comprar menos te vas decepcionado a casa...");
            }
        }
    }
    
    public static void dormir(){
        System.out.println("Decidiste dormir por hoy todo el dia\nZzz...");
    }
    public static void Stats(int dinero){
    Granja Shrute = new Granja(dinero);
    int veggies= Shrute.veggies.size();
    int vacas= Shrute.vacas.size();
    int conejos= Shrute.conejos.size();
    
    System.out.println("-----------ANALISIS DE GRANJA-------\nTienes "+veggies+" Vegetales\nTienes "+vacas+" vacas\nTienes "+conejos+" conejos\nTienes "+dinero+" Monets\n-------------------------------------");   
    }
    public static void analisis(int dinero){
        Scanner pelicanTown= new Scanner(System.in);
        Granja Shrute = new Granja(dinero);
        int veggies= Shrute.veggies.size();
        int vacas= Shrute.vacas.size();
        int conejos= Shrute.conejos.size();
        
        System.out.println("-----------ANALISIS DE GRANJA-------\nTienes "+veggies+" Vegetales\nTienes "+vacas+" vacas\nTienes "+conejos+" conejos\nTienes "+dinero+" Monets\n-------------------------------------");
        System.out.println("Selecciona\n1.- Vegetales\n2.- Conejos\n3.- Vacas");
        int opc= pelicanTown.nextInt();
        if(opc==1){
            if(veggies==0){
                System.out.println("Elegiste vender vegetales...\nPero no tienes ninguno...\nNo tener nada te baja los animos y mejor te vas a dormir...");
            }else{
                System.out.println("Se vendera por 100 cada una/Cuantos desea vender:");//no me acordaba por cuanto se vendia cada una perdon
                int vender= pelicanTown.nextInt();
                for (int i = 0; i < vender; i++) {
                    Shrute.conejos.remove(0);
                }
                System.out.print("La cantidad de vegetales vendidos en total: "+veggies);
                dinero+= 100*veggies;
                Shrute.setMonets(dinero);
                System.out.println("Tu nueva cantidad de dinero es: "+dinero);
            }
        }else if(opc==2){
            if(conejos==0){
                System.out.println("Elegiste vender conejos\nPero no tienes ninguno...\nNo tener nada te baja los animos y mejor te vas a dormir...");
            }else{
                System.out.println("La cantidad de conejos es: "+conejos+"\nY sus nombres son: ");
                for (int i = 0; i < conejos; i++) {
                    System.out.println((i+1)+".- "+Shrute.conejos.get(i));
                }
                System.out.println("Se vendera por 170 cada uno/Cuantos desea vender:");
                int vender= pelicanTown.nextInt();
                for (int i = 0; i < vender; i++) {
                    System.out.println("Bye bye "+Shrute.conejos.get(0));
                    Shrute.conejos.remove(0);
                }
                System.out.println("Se han vendido "+vender+" conejos");
            }
        }else if(opc==3){
            if(vacas==0){
                System.out.println("Elegiste vender vacas\nPero no tienes ninguna...\nNo tener nada te baja los animos y mejor te vas a dormir...");
            }else{
                System.out.println("La cantidad de vacas es: "+vacas+"\nY sus nombres son: ");
                for (int i = 0; i < conejos; i++) {
                    System.out.println((i+1)+".- "+Shrute.vacas.get(i));
                }
                System.out.println("Se vendera por 400 cada una/Cuantos desea vender:");//no me acordaba por cuanto se vendia cada una perdon
                int vender= pelicanTown.nextInt();
                for (int i = 0; i < vender; i++) {
                    System.out.println("Bye bye "+Shrute.vacas.get(0));
                    Shrute.conejos.remove(0);
                }
                System.out.println("Se han vendido "+vender+" vacas");
                dinero+=vender*400;
                
            }
        }else{
            Indeciso();
        }
    }
    public static void Indeciso(){
        System.out.println("Estabas tan indeciso que perdiste el dia pensando en que hacer...");
    }
    
}
