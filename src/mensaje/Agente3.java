package mensaje;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;

public class Agente3 extends Agent{

    @Override
    protected void setup(){
        addBehaviour(new Comportamiento());
    }

    public class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {

            //RECIBIR MENSAJE DE AGENTE2
            ACLMessage aclMSJ = blockingReceive();//se espera el mensaje con blokingReceive
            
            try {
                Persona p = (Persona)aclMSJ.getContentObject();//INSTANCIO un objeto p de tipo Persona metido en el aclMSJ y extraigo su contenido
                
                System.out.println("[Ag3] "+"Mensaje recibido de [" + aclMSJ.getSender().getLocalName() + "] || Contenido del mensaje: " + p.toString() + "\n");
                
            } catch (Exception e) {
                // TODO: handle exception
            }

            //ENVIAR MENSAJE AL AGENTE4
            Mensaje.send_msj(ACLMessage.INFORM, "Ag4", getAgent(), "cod-3-4", null, new Persona("Pennedy", "Castro", 21));
            
            //block(10000); // Espera 10 segundos antes de enviar un nuevo mensaje

            //doDelete();
        }       
    }
    
}
