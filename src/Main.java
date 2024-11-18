import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Deque<Integer> pile = new ArrayDeque<>();
        pile.add(1);
        pile.add(2);
        pile.add(3);
        pile.add(4);
        System.out.println(pile);
        pile.removeLast();
        System.out.println(pile);

        Deque<Integer> inversee = inverser(pile);

        System.out.println(inversee);
        System.out.println(pile);
        inverser2(inversee);
        System.out.println(inversee);

        System.out.println("----------------------------");

        File<Integer> file = new File<>();
        System.out.println(file.estVide());
        try {file.defiler();} catch(Exception e){
            System.out.println("exception");
        };
        file.enfiler(1);
        file.enfiler(2);
        file.enfiler(3);
        try {
            while (true) {
                System.out.println(file.defiler());
            }
        } catch (Exception e) {
            System.out.println("vide");
        }



        boolean isValid = estParensValide("{{]]}}[[][][");
        System.out.println(isValid);
        isValid = estParensValide("{}}");
        System.out.println(isValid);

        isValid = estParensValide("{}");
        System.out.println(isValid);
    }

    public static <E> Deque<E> inverser(Deque<E> pile) {
        Deque<E> toReturn = new ArrayDeque<>();
        while(!pile.isEmpty()) {
            toReturn.add(pile.removeLast());
        }
        return toReturn;
    }

    public static <E> void inverser2(Deque<E> pile) {
        Deque<E> pile_inversee = inverser(inverser(pile));
        pile.clear();
        while (!pile_inversee.isEmpty()) {
            pile.add(pile_inversee.removeLast());
        }
    }

    public static boolean estParensValide(String text) {
        Deque<Character> pile = new ArrayDeque<>();
        boolean isValid = true;
        int indice = 0;
        while (isValid && indice < text.length()) {
            char a = text.charAt(indice);
            switch (a) {
                case '(', '{', '[' -> pile.push(a);
                case ')', '}', ']' -> {
                    if (!pile.isEmpty()) {
                        switch (pile.pop()) {
                            case '(' -> isValid = a == ')';
                            case '[' -> isValid = a == ']';
                            case '{' -> isValid = a == '}';
                            default -> {
                            }
                        }
                    } else {
                        isValid = false;
                    }
                }
                default -> {}
            }
            indice++;
        }
        return isValid && pile.isEmpty();
    }
}