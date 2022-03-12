package com.mycompany.ejercicio1preparcial;

import java.util.*;
import rx.Observable;
import rx.functions.Func2;
import rx.observables.MathObservable;

/**
 *
 * @author Oscar Escobar
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        List<Numero> numeros = new ArrayList<>();
        numeros.add(new Numero(2));
        numeros.add(new Numero(5));
        numeros.add(new Numero(6));
        numeros.add(new Numero(8));
        numeros.add(new Numero(10));
        numeros.add(new Numero(35));
        numeros.add(new Numero(2));
        numeros.add(new Numero(10));

        Observable<Numero> numeroObservable = Observable.from(numeros);

        MathObservable
                .from(numeroObservable)
                .averageInteger(Numero::getNumero)
                .subscribe((promedio) -> {

                    System.out.println("PROMEDIO: " + promedio);
                    System.out.println("\n");

                });

        Observable observablenumero
                = Observable
                        .from(numeros.toArray())
                        .map((result) -> {
                            Numero numero = (Numero) result;
                            return numero.getNumero();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer a, Integer actual) {
                                if (actual == 10) {
                                    System.out.println(actual + "  Es igual que 10");
                                } else if (actual > 10) {
                                    System.out.println(actual + "  Es mayor 10");
                                } else {
                                    System.out.println(actual + " Es menor que 10");
                                }
                                return actual;

                            }

                        }
                        );
        observablenumero.subscribe((verificador) -> {
            System.out.println("\n");
        });
        Observable observablenumero2
                = Observable
                        .from(numeros.toArray())
                        .map((result) -> {
                            Numero numero = (Numero) result;
                            return numero.getNumero();
                        })
                        .reduce(
                                new Func2<Integer, Integer, Integer>() {
                            @Override
                            public Integer call(Integer acumulador, Integer actual) {

                                return acumulador + actual;

                            }
                        }
                        );
        observablenumero2.subscribe((sumatoria) -> {
            System.out.println(""
                    + "Sumatoria: " + sumatoria);
            System.out.println("\n");
        });
    }

}
