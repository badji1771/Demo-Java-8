package work.interfacefonctionnel;

public interface MonInterface {
    default void afficher() {
        System.out.println("Méthode par défaut");
    }

}
