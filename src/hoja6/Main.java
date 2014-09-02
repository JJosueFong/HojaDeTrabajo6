/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja6;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author manuelgomez
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Set java = null,web=null,cel=null;
        String nombre;
        SetFactory factory=new SetFactory();
        int opcion1,opcion2;
        Scanner ingreso  = new Scanner(System.in);
        System.out.println("Elija su opcion de Set: ");
        System.out.println("1. HashSet");
        System.out.println("2. TreeSet");
        System.out.println("3. LinkedHashSet");                
        System.out.println("Número de opción: ");
        opcion1 = ingreso.nextInt();
        switch(opcion1){
            case 1:{
                java = factory.getClass("Hash");
                web = factory.getClass("Hash");
                cel = factory.getClass("Hash");
                break;
            }
            case 2:{
                java = factory.getClass("Tree");
                web = factory.getClass("Tree");
                cel = factory.getClass("Tree");
                break;
            }
            case 3:{
                java = factory.getClass("Linked");
                web = factory.getClass("Linked");
                cel = factory.getClass("Linked");
                break;
            }
        }
        opcion1 = 0;
        while(opcion1!=1){
            System.out.println("Ingrese su nombre: ");
            nombre = ingreso.next();
            System.out.println("Ingrese que desarrollador es: ");
            System.out.println("1. Java");
            System.out.println("2. Web");
            System.out.println("3. Celular");                
            System.out.println("Número de opción: ");
            opcion2 = ingreso.nextInt();
            switch(opcion2){
                case 1:{
                    java.add(nombre);
                    break;
                }
                case 2:{
                    web.add(nombre);
                    break;
                }
                case 3:{
                    cel.add(nombre);
                    break;
                }
            }
            System.out.println("Desea seguir ingresando nombres?");
            System.out.println("1. No");
            System.out.println("2. Si");
            System.out.println("Número de opción: ");
            opcion1 = ingreso.nextInt();
        }
        Iterator iterator = java.iterator();
        System.out.println("Interseccion de los 3 conjuntos:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(web.contains(elemento)&&cel.contains(elemento))
                System.out.print(" " +elemento);
        }
        
        iterator = java.iterator();
        System.out.println("Experiencia en java pero no web:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(!web.contains(elemento))
                System.out.print(" " +elemento);
        }
        
        iterator = web.iterator();
        System.out.println("Experiencia web y celulares pero no java:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(cel.contains(elemento)&&(!java.contains(elemento)))
                System.out.print(" " +elemento);
        }
    }
    
}
