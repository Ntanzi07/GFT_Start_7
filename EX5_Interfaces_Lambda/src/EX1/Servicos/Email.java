package EX1.Servicos;

public class Email implements MsgMarketing {

    @Override
    public void receberMsg() {
        System.out.println("Recebendo msg pelo Email");
    }

    @Override
    public void mandarMsg() {
        System.out.println("mandando msg pelo Email");
    }
}
