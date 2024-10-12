import jade.core.Agent;
import jade.core.behaviours.Behaviour;

public class Agente2 extends Agent{

    @Override
    public void setup(){
        addBehaviour(new Comportamiento());
    }
    
    public class Comportamiento extends Behaviour{

        @Override
        public void action() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'action'");
        }

        @Override
        public boolean done() {
            // TODO Auto-generated method stub
            throw new UnsupportedOperationException("Unimplemented method 'done'");
        }
           
        
    }

}
