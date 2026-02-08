public class ScathaProClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScathaPro instance = new ScathaPro();

        Overlay overlay = new Overlay(instance);

        ScathaProHudRenderer renderer = new ScathaProHudRenderer(overlay);
        renderer.register();

        ScathaProTickHandler tickHandler = new ScathaProTickHandler(overlay);
        tickHandler.register();
    }
}