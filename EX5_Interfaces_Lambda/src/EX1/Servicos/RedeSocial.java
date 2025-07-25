package EX1.Servicos;

public class RedeSocial implements MsgMarketing {

    @Override
    public void receberMsg() {
        System.out.println("Recebendo msg pela Rede Social");
    }

    @Override
    public void mandarMsg() {
        System.out.println("mandando msg pela Rede Social");
    }
}
