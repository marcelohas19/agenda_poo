import controller.*;
import modell.*;
import view.*;
public class Main {
    public static void main(String[] args) throws Exception {

        @Override
        public void run() {
                // 1. Cria o Model
                AgendaModel model = new AgendaModel();
                
                // 2. Cria a View
                AgendaView view = new AgendaView();
                
                // 3. Cria o Controller, passando o Model e a View
                AgendaController controller = new AgendaController(model, view);
                
                // 4. Inicia a aplicação (torna a View visível)
                controller.iniciarAplicacao();
            }
    }
}
