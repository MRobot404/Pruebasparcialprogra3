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

    public static int precio, total, anterior = 0, actual, valor;

    public static void main(String[] args) {
        ArrayList<Consola> consolas = new ArrayList<>();
        consolas.add(new Consola("ps4", 350));
        consolas.add(new Consola("gamecube", 300));
        consolas.add(new Consola("external disk", 200));
        consolas.add(new Consola("Laptop", 800));
        consolas.add(new Consola("vr", 230));
        consolas.add(new Consola("Internet", 10));
        consolas.add(new Consola("Internet", 11));

        Observable observableconsola
                = Observable
                        .from(consolas.toArray())
                        .map((result) -> {
                            Consola consola = (Consola) result;
                            return consola.getEdad();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumulador, Integer actual) {
                             
                                return acumulador + actual;

                            }
                        }
                        );
        observableconsola.subscribe((sumatoria) -> {
            System.out.println(""
                    + "Sumatoria: " + sumatoria);
            System.out.println("\n");
        });
        Observable observableconsola2
                = Observable
                        .from(consolas.toArray())
                        .map((result) -> {
                            Consola consola = (Consola) result;
                            return consola.getEdad();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer a, Integer actual) {
                              if(actual<=a){
                                  
                              }else{
                                  a=actual;
                              }
                                return a;
                               

                            }

                        }
                        );
        observableconsola2.subscribe((verificador) -> {
            System.out.println(""
                    + "El numero mayor es : " + verificador);

        });

    }

}
