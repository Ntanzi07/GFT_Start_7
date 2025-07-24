package EX1.Servicos;

public class SMS implements MsgMarketing {

    @Override
    public void receberMsg() {
        System.out.println("Recebendo msg pelo SMS");
    }

    @Override
    public void mandarMsg() {
        System.out.println("mandando msg pelo SMS");
    }
}
