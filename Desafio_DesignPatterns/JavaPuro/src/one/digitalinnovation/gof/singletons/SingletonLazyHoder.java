package one.digitalinnovation.gof.singletons;

/**
 * Singleton "Lazy Hoder"
 */
public class SingletonLazyHoder {

    public static class Holder {
        private static SingletonLazyHoder instancia = new SingletonLazyHoder();
    }

    private SingletonLazyHoder() {
        super();
    }

    public static SingletonLazyHoder getInstance() {
        return Holder.instancia;
    }
}
