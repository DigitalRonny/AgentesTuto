import jade.core.Agent;

public class Agente1 extends Agent{
    
    @Override
    protected void setup(){
        System.out.println("Hola");
        System.out.println("Mi nombre es: " + getLocalName());
        System.out.println("Mi AID es: " + getAID());
    }
}
