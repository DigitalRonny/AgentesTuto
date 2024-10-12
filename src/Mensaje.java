import java.io.IOException;
import java.io.Serializable;
import java.util.logging.Level;
import jade.core.AID;
import jade.core.Agent;
import jade.domain.FIPANames;
import jade.lang.acl.ACLMessage;
import jade.util.Logger;

public class Mensaje {
    public static void send_msj(int tipoMsj, String receptor, Agent emisor, String conversationId, String contenido, Serializable contenidoObj) {
        
        //Instanciar aclm de tipo ACLMessage
        ACLMessage aclm = new ACLMessage(tipoMsj);
        aclm.setLanguage(FIPANames.ContentLanguage.FIPA_SL);
				
		//instanciar un Identificador (AID)
        AID aid = new AID();
        aid.setLocalName(receptor); // A este aid (de tipo AID) le voy a pasar el nombre del agente receptor(pasado como parametro)
        aclm.addReceiver(aid); // Anadir el receptor a la instancia aclm de ACLMessage

		//Del parametro emisor de tipo agente se trae su AID
        aclm.setSender(emisor.getAID()); // El emisor del mensaje (setSender establece el emisor) traigo el AID del emisor
        aclm.setConversationId(conversationId); // Establecer un ID de la conversación

        if (contenido != null) {
            aclm.setContent(contenido); // Si se pasa un contenido en forma de texto (contenido), lo agrega al mensaje.
        } else { //Si no, se serializa un objeto (contenidoObj) y lo agrega al mensaje.
            try {
                aclm.setContentObject(contenidoObj); // Establecer un objeto serializado si es necesario
            } catch (IOException e) {
                Logger.getLogger(Mensaje.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        emisor.send(aclm); // Envía el mensaje desde el agente emisor al agente receptor.
    }
}