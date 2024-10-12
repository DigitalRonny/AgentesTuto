import jade.core.Agent;
import jade.core.behaviours.Behaviour;;

public class Agente1 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());    
    }

    public class Comportamiento extends Behaviour{

        @Override
        public void action() {
            for (int i = 0; i < 10; i++) {
                System.out.println("Contador en: "+ i);
            }
        }

        @Override
        public boolean done() {
            System.out.println("FIN");
            return true;        } 
    }
}
