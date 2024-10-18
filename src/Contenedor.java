import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import mensaje.Agente1;
import mensaje.Agente2;
import mensaje.Agente3;
import mensaje.Agente4;
import mensaje.Agente5;

public final class Contenedor {
    private static AgentContainer agentContainer;
    public static void configurarContentedor(){
        jade.core.Runtime runtime = jade.core.Runtime.instance();
        Profile profile = new ProfileImpl(null, 1099, null);
        agentContainer = runtime.createMainContainer(profile);
        agregarAgentes(); 
    }

    public static void agregarAgentes(){
        try {
            agentContainer.createNewAgent("Ag1", Agente1.class.getName(), null).start();
            agentContainer.createNewAgent("Ag2", Agente2.class.getName(), null).start();
            agentContainer.createNewAgent("Ag3", Agente3.class.getName(), null).start();
            agentContainer.createNewAgent("Ag4", Agente4.class.getName(), null).start();
            agentContainer.createNewAgent("Ag5", Agente5.class.getName(), null).start();
        } catch (StaleProxyException e) {
            e.printStackTrace();
        
        }
    }
}

