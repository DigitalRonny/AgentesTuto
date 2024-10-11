public class App {
    public static void main(String[] args) throws Exception {
        Contenedor.configurarContentedor();
        System.out.println("Contentedor inicializado.");
        Thread.sleep(Long.MAX_VALUE);
    }
}
