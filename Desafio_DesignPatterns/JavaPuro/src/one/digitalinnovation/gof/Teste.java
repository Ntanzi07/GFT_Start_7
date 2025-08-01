package one.digitalinnovation.gof;

import one.digitalinnovation.gof.facades.Facade;
import one.digitalinnovation.gof.singletons.SingletonEager;
import one.digitalinnovation.gof.singletons.SingletonLazy;
import one.digitalinnovation.gof.singletons.SingletonLazyHoder;
import one.digitalinnovation.gof.strategys.*;

public class Teste {

    public static void main(String[] args) {

        // Singleton
        SingletonLazy lazy = SingletonLazy.getInstance();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstance();
        System.out.println(lazy);


        System.out.println("=======================");
        SingletonEager eager = SingletonEager.getInstance();
        System.out.println(eager);
        eager = SingletonEager.getInstance();
        System.out.println(eager);

        System.out.println("=======================");
        SingletonLazyHoder lazyHoder = SingletonLazyHoder.getInstance();
        System.out.println(lazyHoder);
        lazyHoder = SingletonLazyHoder.getInstance();
        System.out.println(lazyHoder);

        //Strategy
        Comportamento normal = new ComportamentoNormal();
        Comportamento defenssivo = new ComportamentoDefencivo();
        Comportamento agressivo = new ComportamentoAgressivo();

        Robo robo = new Robo();

        robo.setComportamento(normal);
        robo.mover();
        robo.mover();

        robo.setComportamento(defenssivo);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();

        //Facade
        Facade facade = new Facade();
        facade.migrarCliente("nathan", "18055036");
    }


}
