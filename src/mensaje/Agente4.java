package mensaje;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente4 extends Agent{
    
    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }
    
    public class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {

            //RECIBIR MENSAJE DE AGENTE2 o AGENTE3
            ACLMessage aclMSJ = blockingReceive();

            try {
                Persona p = (Persona)aclMSJ.getContentObject();//INSTANCIO un objeto p de tipo Persona metido en el aclMSJ y extraigo su contenido
                
                System.out.println("[Ag4] "+"Mensaje recibido de [" + aclMSJ.getSender().getLocalName() + "] || Contenido del mensaje: " + p.toString() + "\n");

            } catch (Exception e) {
                // TODO: handle exception
            }

            //ENVIAR MENSAJE AL AGENTE5
            Mensaje.send_msj(ACLMessage.INFORM, "Ag5", getAgent(), "cod-4-5", null, new Persona("Jhonathan", "Luzu", 21));

            //doDelete();  // Termina después de enviar el mensaje
        }
    };
}
