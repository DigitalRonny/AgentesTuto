package comportamiento;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.Behaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.*;

public class Agente1 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());    
    }

    public class Comportamiento extends OneShotBehaviour{//comportamiento simple

        @Override
        public void action() {
            
        }

    }
}
