package peick.scathapro.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;
import peick.scathapro.ScathaPro;
import peick.scathapro.overlay.Overlay;

public class OverlayHandler {

    private static Overlay overlay;

    public static void init(ScathaPro mod) {
        overlay = new Overlay(mod);

        // Tick event
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (client.player != null && client.world != null) {
                overlay.updateRealtimeElements();
            }
        });

        // Render event
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            if (overlay != null) {
                overlay.drawOverlayIfAllowed(matrices);
            }
        });
    }

    public static Overlay getOverlay() {
        return overlay;
    }
}