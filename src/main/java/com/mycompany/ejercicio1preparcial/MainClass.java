/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.ejercicio1preparcial;

import java.util.*;
import javax.swing.JOptionPane;
import rx.Observable;
import rx.functions.Func2;

/**
 *
 * @author Oscar Escobar
 */
public class MainClass {

    public static int precio, total, anterior = 0, actual,valor;

    public static void main(String[] args) {
        ArrayList<Consola> consolas = new ArrayList<>();
        consolas.add(new Consola("ps4", 300));
        consolas.add(new Consola("gamecube", 300));
        consolas.add(new Consola("external disk", 200));
        consolas.add(new Consola("Laptop", 800));
        consolas.add(new Consola("vr", 230));
        consolas.add(new Consola("Internet", 10));
        consolas.add(new Consola("Internet", 11));


        for (int i = 0; i < consolas.size(); i++) {
            precio = consolas.get(i).getEdad();
            total = total + precio;
        }
        System.out.println("El total del programa " + total);
        System.out.println("\n");
        
        valor=consolas.get(0).getEdad();
        //Mostrar vector
        for (int i = 0; i < consolas.size(); i++) {
            System.out.println(consolas.get(i).getNombre()+" "+consolas.get(i).getEdad());
        }
        
        for (int j = 0; j < consolas.size(); j++) {

            if (consolas.get(j).getEdad() <=valor ) {

            } else {
            valor=consolas.get(j).getEdad();
                
            }
        }
        System.out.println("EL numero mayor de la lista es: " + valor);
    }

}
