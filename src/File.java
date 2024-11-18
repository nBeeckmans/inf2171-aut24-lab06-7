public class File<T> {
    public static void main(String []args) throws FileVide {
        File<Integer> file = new File<>();
        System.out.println(file.estVide());
        file.enfiler(3);
        System.out.println(file.estVide());
        System.out.println(file);
        file.enfiler(6);
        file.enfiler(9);
        System.out.println(file.taille);

        System.out.println(file.tete());
        System.out.println( file.defiler());

    }

    int taille = 0;

    private Noeud tete, queue;

    private class Noeud {
        T element;
        Noeud suivant;
    }

    public File() {}

    public int taille () { return taille;}

    public boolean estVide() {return taille == 0;}

    public T tete () throws FileVide {
        if (estVide()) throw new FileVide();
        return tete.element;
    }

    public void enfiler (T element) {
        Noeud nouveau = new Noeud();
        nouveau.element = element;
        if (!estVide()) {
            queue.suivant = nouveau;
            queue = nouveau;
        } else {
            tete = queue = nouveau;
        }
        taille++;
    }

    public T defiler () throws FileVide {
        if (estVide()) throw new FileVide();
        T element = tete.element;
        tete = tete.suivant;
        taille--;
        return element;
    }

    @Override
    public String toString() {
        Noeud n = this.tete;
        String toString = "[ ";
        while (n != null) {
            toString += n.element + " ";
            n = n.suivant;
        }
        toString += "]";
        return  toString;
    }

    public static class FileVide extends Exception {


    }
}
