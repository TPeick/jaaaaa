package peick.scathapro;

import net.fabricmc.fabric.api.client.rendering.v1.HudRenderCallback;
import net.minecraft.client.util.math.MatrixStack;

public class ScathaProHudRenderer {

    private final Overlay overlay;

    public ScathaProHudRenderer(Overlay overlay) {
        this.overlay = overlay;
    }

    public void register() {
        HudRenderCallback.EVENT.register((matrices, tickDelta) -> {
            overlay.render(matrices, tickDelta);
        });
    }
}