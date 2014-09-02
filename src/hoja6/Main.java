/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package hoja6;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
        //Se define que tipo de Set se utilizara
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
        //ciclo para ingresar todos los nombres y agregarlos a los Sets
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
        //mostrar la interseccion de los 3 conjuntos
        Iterator iterator = java.iterator();
        System.out.println("Interseccion de los 3 conjuntos:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(web.contains(elemento)&&cel.contains(elemento))
                System.out.print(elemento+ ", ");
        }
        //mostrar la experiencia en java pero no web
        System.out.println(" ");
        iterator = java.iterator();
        System.out.println("Experiencia en java pero no web:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(!web.contains(elemento))
                System.out.print(elemento+ ", ");
        }
        //mostrar Experiencia web y celulares pero no java
        System.out.println(" ");
        iterator = web.iterator();
        System.out.println("Experiencia web y celulares pero no java:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(cel.contains(elemento)&&(!java.contains(elemento)))
                System.out.print(elemento+ ", ");
        }
        //mostrar Experiencia web o celulares pero no java
        System.out.println(" ");
        iterator = web.iterator();
        Iterator iterator2 = cel.iterator();
        System.out.println("Experiencia web o celulares pero no java:");
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if((!java.contains(elemento)))
                System.out.print(elemento+ ", ");
            String elemento2 = (String) iterator2.next();
            if((!java.contains(elemento2))&&(elemento!=elemento2))
                System.out.print(elemento2+ ", ");
        }
        //mostar si los desarrolladores de java son un subconjunto de los web
        System.out.println(" ");
        iterator = java.iterator();
        boolean bandera = true;
        while(iterator.hasNext()){
            String elemento = (String) iterator.next();
            if(!web.contains(elemento))
                bandera = false;
        }
        if(bandera) System.out.println("Los desarrolladores de Java SI son un subconjunto de los desarrolladores web. ");
        else System.out.println("Los desarrolladores de Java NO son un subconjunto de los desarrolladores web. ");
        //mostrar el subconjunto mas grande y los nombres ordenados
        if((java.size()>web.size())&&(java.size()>cel.size())){
            System.out.println("Java es el conjunto de desarrolladores mas grande. ");
            System.out.println(java);
            Set orden = new TreeSet(java);
            System.out.println("Nombres ordenados: ");
            System.out.println(orden);
        }
        else 
            if ((java.size()<web.size())&&(web.size()>cel.size())){
               System.out.println("Web es el conjunto de desarrolladores mas grande. "); 
               System.out.println(web);
               Set orden = new TreeSet(web);
               System.out.println("Nombres ordenados: ");
               System.out.println(orden);
            }
        else
                if ((java.size()<cel.size())&&(web.size()<cel.size())){
                    System.out.println("Celulares es el conjunto de desarrolladores mas grande. "); 
                    System.out.println(cel); 
                    Set orden = new TreeSet(cel);
                    System.out.println("Nombres ordenados: ");
                    System.out.println(orden);
                }
        else
                    System.out.println("Todo los conjuntos de desarrolladores son del mismo tamaño. ");
    }
    
}
