package mensaje;

import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.*;

public class Agente1 extends Agent{

    @Override
    protected void setup() {
        addBehaviour(new Comportamiento());
    }
    
    public class Comportamiento extends CyclicBehaviour{

        @Override
        public void action() {

            //enviar el mensaje a Agente2 por medio de la clase mensaje
            Mensaje.send_msj(ACLMessage.INFORM, "Ag2", getAgent(), "cod-1-2", null, new Persona("Ronny", "Cartagena", 21));
        

            //RECIBIR MENSAJE DE AGENTE5
            ACLMessage aclMSJ = blockingReceive();//se espera el mensaje con blokingReceive
            try {
                Persona p = (Persona)aclMSJ.getContentObject();//INSTANCIO un objeto p de tipo Persona metido en el aclMSJ y extraigo su contenido

                //System.out.println("-------Ag1-------");
                //System.out.println("Mensaje recibido de " + aclMSJ.getSender().getLocalName());// se trae el mensajero que envió aclMSJ y su nombre local
                //System.out.println("Contenido del mensaje: " + p.toString() + "\n");

                //TODO EL MENSAJE LO METO EN UNO SOLO .out PARA QUE NO SALGA DESPARRAMADO EN LA EJECUCION
                System.out.println("[Ag1] " + "Mensaje recibido de [" + aclMSJ.getSender().getLocalName()+ "] || Contenido del mensaje: " + p.toString() + "\n");
            } catch (Exception e) {
                // TODO: handle exception
            }

            
            //si todos los agentes tienen el doDelete solo se ejecutará un ciclo
            //doDelete();
        }

    }
    
}
