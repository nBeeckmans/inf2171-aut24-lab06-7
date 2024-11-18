package Labo;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class Main {
    public static void main(String[]args) {

        Deque<Integer> pile = new ArrayDeque<>();
        pile.addFirst(1);
        pile.addFirst(2);
        pile.addFirst(3);
        pile.addFirst(4);

        System.out.println(pile);

        Deque<Integer> pileInversee = inverser(pile);
        System.out.println(pileInversee);
        System.out.println(pile);

        inverser2(pileInversee);
        System.out.println(pileInversee);

        System.out.println(estValide("()"));
        System.out.println(estValide("("));
        System.out.println(estValide("[()]"));

    }

    public static <E> Deque<E> inverser(Deque<E> pile) {
        Deque<E> pr = new ArrayDeque<>();
        while(!pile.isEmpty()) {
            E tmp = pile.removeFirst();
            pr.addFirst(tmp);
        }
        return pr;
    }

    public static <E> void inverser2(Deque<E> pile) {
        Deque<E> tmp = inverser(inverser(pile));
        while(!tmp.isEmpty()) {
            pile.addFirst(tmp.removeFirst());
        }
    }

    public static boolean estValide(String text) {
        Deque<Character> characters = new ArrayDeque<>();
        boolean resultat = true;
        int i = 0;
        while (resultat && i < text.length()) {
           char character  = text.charAt(i);
           switch(character) {
               case '(','[','{' -> characters.addFirst(character);
               case '}' -> resultat = !characters.isEmpty() && characters.removeFirst() == '{';
               case ']' -> resultat = !characters.isEmpty() && characters.removeFirst() == '[';
               case ')' -> resultat = !characters.isEmpty() && characters.removeFirst() == '(';
           }
           i++;
        }

        return resultat && characters.isEmpty();
    }
}
