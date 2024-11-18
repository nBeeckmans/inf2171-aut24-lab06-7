package Labo;

public class Fraction  {

    private int numerateur, denominateur;

    public Fraction(int numerateur, int denominateur) {
        this.numerateur = numerateur;
        this.denominateur = denominateur;
    }

    public int compareTo(Fraction autre) {
        Float thisValeur = ((float) this.numerateur) / this.denominateur;
        Float autreValeur = ((float) autre.numerateur) / autre.denominateur;

        return thisValeur.compareTo(autreValeur);
    }

    @Override
    public String toString() {
        return numerateur + "/" + denominateur;
    }
}
