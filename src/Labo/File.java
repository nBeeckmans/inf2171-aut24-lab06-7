package Labo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class File <T> {

    private Noeud premier, dernier;
    private int taille;

    private List<T> list = new ArrayList<>();

    public File() {}

    public File(Collection<T> element) {
        list.addAll(element);
    }
    public int taille() {
        return taille;
    }
    public boolean estVide() {
        return taille == 0;
    }
    public T tete() throws FileVide{
        if (this.estVide()) throw new FileVide();
        return premier.element;
    }
    public void enfiler( T a_element ){
        // TODO
        Noeud nouveau = new Noeud(a_element);
        if (this.estVide()) {
            dernier = nouveau;
            premier = dernier;
        } else {
            this.dernier.suivant = nouveau;
            this.dernier = nouveau;
        }
        taille++;
    }
    public T defiler() throws FileVide{
        T aRetourner = tete();
        this.premier = this.premier.suivant;
        taille--;
        assert taille >= 0;
        return aRetourner;
    }

    public static class FileVide extends Exception {
    }

    private class Noeud {
        T element;
        Noeud suivant;

        public Noeud(T element) {
            this. element = element;
        }
    }
}
