import java.util.ArrayList;
import java.util.List;

public class ListaTarefa {
    private final List<Tarefa> tarefaList;

    public ListaTarefa() {
        this.tarefaList = new ArrayList<>();
    }

    public void adicionarTarefa(String descricao) {
        tarefaList.add(new Tarefa(descricao));
    }

    public void removerTarefa(String descricao) {
        var tarefasParaRemover = tarefaList
                .stream()
                .filter(tarefa -> tarefa.getDescricao().equals(descricao))
                .toList();

        tarefaList.removeAll(tarefasParaRemover);
    }

    public int obterNumeroTotalTarefas() {
        return tarefaList.size();
    }

    public void obterDescricaoTarefas() {
        System.out.println(tarefaList);
    }

    public static void main(String[] args) {
        ListaTarefa minhaLista = new ListaTarefa();

        minhaLista.adicionarTarefa("tarefa 1");
        minhaLista.adicionarTarefa("tarefa 2");
        minhaLista.adicionarTarefa("tarefa 3");
        minhaLista.adicionarTarefa("tarefa 4");
        minhaLista.adicionarTarefa("tarefa 2");
        minhaLista.adicionarTarefa("tarefa 2");

        System.out.println("numero de tarefas: " + minhaLista.obterNumeroTotalTarefas());
        minhaLista.obterDescricaoTarefas();
        System.out.println("==============================");
        minhaLista.removerTarefa("tarefa 2");
        minhaLista.obterDescricaoTarefas();
        System.out.println("numero de tarefas: " + minhaLista.obterNumeroTotalTarefas());
    }
}
