import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;

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
            agentContainer.createNewAgent("Peter", Agente1.class.getName(), null).start();;
        } catch (StaleProxyException e) {
            e.printStackTrace();
        }
    }
}

