package Labo;

import java.util.Arrays;

public class Algos {
    public static void main(String []args) {
        Fraction []tab = {
          new Fraction(1,2),
                new Fraction(3,6),
                new Fraction(2,7),
                new Fraction(7,8),
                new Fraction(8,9),
                new Fraction(3,5),
                new Fraction(9,3),
                new Fraction(3,2),
                new Fraction(0,1),
                new Fraction(2,4),
                new Fraction(6,9),
                new Fraction(3,8),
        };
         Arrays.sort(tab, Fraction::compareTo);

        for (var fraction : tab) {
            System.out.println(fraction);
        }

        // System.out.println(FouilleBinaire(tab, new Fraction(8,9)));
        // System.out.println(FouilleBinaire(tab,new Fraction(8,9),0,tab.length-1));
        System.out.println(Arrays.binarySearch(tab, new Fraction(8,9), Fraction::compareTo));

        // System.out.println(FouilleBinaire(tab, new Fraction(1,1)));
        // System.out.println(FouilleBinaire(tab,new Fraction(1,1),0,tab.length-1));
    }

    public static < E extends Comparable< E > > int FouilleBinaire( E [] tableau,
                                                                    E element ) {
        int debut = 0;
        int fin = tableau.length -1;
        while (debut < fin) {
            int milieu = (debut + fin ) / 2;
            if ( element.compareTo(tableau[milieu]) <= 0) {
                fin  = milieu;
            } else {
                debut = milieu + 1;
            }
        }
        if ( tableau[debut].compareTo(element) != 0){
            debut = -1;
        }
        return debut;
    }

    public static <E extends Comparable<E>> int FouilleBinaire( E[] tableau, E element, int debut, int fin) {
        int retour;
        if ( debut < fin) {
            int milieu = (debut + fin) / 2;
            int comparaison = element.compareTo(tableau[milieu]);
            if (comparaison < 0) {
                retour = FouilleBinaire(tableau, element, debut, milieu - 1);
            } else if (comparaison > 0){
                retour = FouilleBinaire(tableau, element, milieu + 1, fin);
            } else {
                retour = milieu;
            }
        } else {
            if ( tableau[debut].compareTo(element) != 0){
                retour = -1;
            } else {
                retour = debut;
            }
        }
        return retour;
    }
}
