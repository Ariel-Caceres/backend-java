package src;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        int numero = 10;
        int multiplicacion = numero * 2;
        ArrayList<String> Cosas = new ArrayList<>();
        Cosas.add("Palo");
        Cosas.add("Cama");
        // Cosas.remove(1);
        Collections.sort(Cosas);
        System.out.println(Cosas);

    }
}