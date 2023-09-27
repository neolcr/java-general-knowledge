package com.neol.java.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestGenerics {
    public static void main(String[] args) {

        // Fourth line will make the compiler protests
        List lista = new ArrayList<>();
        lista.add("ejemplo");
        lista.add(0);
        //String s = lista.get(0);

        // Generic in <>
        List<String> lista2 = new ArrayList<>();
        lista2.add("ejemplo");
        //lista.add(0);
        String s = lista2.get(0);

        // Personal generic
        Generico<Double> genericoDouble = new Generico<>(1.1);
        genericoDouble.mostrar();
        Generico<Integer> genericoInt = new Generico<>(8);
        genericoInt.mostrar();
        Generico<String> genericoString = new Generico<>("hola que tal");
        genericoString.mostrar();

        // Personal bounded generic
        GenericoAcotado<Double> genericoAcDouble = new GenericoAcotado<>(1.1);
        genericoAcDouble.mostrar();
        GenericoAcotado<Integer> genericoAcInt = new GenericoAcotado<>(8);
        genericoAcInt.mostrar();
        // Will fail as String does not extend from Number
        //GenericoAcotado<String> genericoAcString = new GenericoAcotado<>(8);
        //genericoString.mostrar();


        //Generico en metodo en lugar de en clase
        GenericoEnMetodo genericoEnMetodo = new GenericoEnMetodo();
        genericoEnMetodo.mostrar();
        genericoEnMetodo.mostrar(1.0);
        genericoEnMetodo.mostrar("Generico en metodo");
        genericoEnMetodo.mostrar(true);
        System.out.println(genericoEnMetodo.retornar(true));

        genericoEnMetodo.mostrar(Arrays.asList(true, true, false, true, false));
        genericoEnMetodo.mostrar(Arrays.asList(1,6,4,32));

        // Generic using Wildcards
        GenericoConWildcard genericoConWildcard = new GenericoConWildcard();
        //genericoConWildcard.mostrar(Arrays.asList("a", "bc"));
        genericoConWildcard.mostrar(Arrays.asList(1, 3, 5.4));


    }
}

class Generico<TIPO> {
    private final TIPO tipoObjeto;

    public Generico(TIPO tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public void mostrar(){
        System.out.println("Esta es la clase del generico : " + tipoObjeto.getClass().getName());
    }
}

class GenericoAcotado<TIPO extends Number>{
    private final TIPO tipoObjeto;

    public GenericoAcotado(TIPO tipoObjeto) {
        this.tipoObjeto = tipoObjeto;
    }

    public void mostrar(){
        System.out.println("Esta es la clase del generico acotado: " + tipoObjeto.getClass().getName());
    }
}

class GenericoEnMetodo{
    public <TIPO> void mostrar(){
        System.out.println("Lo que sea");
    }

    // public <tipo> -> Equivalent to declare in the class name<tipo>{}
    public <TIPO> void mostrar(TIPO tipoObjeto){
        System.out.println("Esta es la clase del generico en metodo: " + tipoObjeto.getClass().getName());
    }

    public <TIPO> TIPO retornar(TIPO tipoObjeto){
        return tipoObjeto;
    }

    public <TIPO> void mostrar(List<TIPO> elements){
        elements.forEach(i -> System.out.println(i.getClass().getName()));
    }
}

class GenericoConWildcard{

    // Admite cualquier elemento mientras extienda de Number: int, double, etc
    public void mostrar(List<? extends Number> item){
        item.forEach(i -> System.out.println("Clase the generico: " + i.getClass().getName()));

    }
}
