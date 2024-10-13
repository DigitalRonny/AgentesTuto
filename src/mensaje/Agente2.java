package mensaje;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.*;

public class Agente2 extends Agent{

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    
    public class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {
            
            //RECIBIR MENSAJE DE AGENTE1
            ACLMessage aclMSJ = blockingReceive();//se espera el mensaje con blokingReceive
            try {
                Persona p = (Persona)aclMSJ.getContentObject();//INSTANCIO un objeto p de tipo Persona metido en el aclMSJ y extraigo su contenido

                System.out.println("[Ag2] "+"Mensaje recibido de [" + aclMSJ.getSender().getLocalName() + "] || Contenido del mensaje: " + p.toString() + "\n");
                
            } catch (Exception e) {
                // TODO: handle exception
            }

            //ENVIAR MENSAJE AL AGENTE3
            Mensaje.send_msj(ACLMessage.INFORM, "Ag3", getAgent(), "cod-2-3", null, new Persona("Alisson", "Yaguana", 21));

            //ENVIAR MENSAJE AL AGENTE4
            Mensaje.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-2-4", null, new Persona("Eddy", "Castro", 21));

            //doDelete();   
        }
    }
}
