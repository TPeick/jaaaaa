package peick.scathapro.overlay.elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

public class OverlayImage extends OverlayElement {

    private Identifier texture;
    private int textureWidth;
    private int textureHeight;

    public OverlayImage(int x, int y, float scale) {
        super(x, y, scale);
    }

    public OverlayImage(String path, int texW, int texH, int x, int y, float scale) {
        super(x, y, scale);
        setImage(path, texW, texH);
    }

    public void setImage(String path, int texW, int texH) {
        if (path == null) {
            this.texture = null;
            this.textureWidth = 0;
            this.textureHeight = 0;
            return;
        }

        this.texture = Identifier.of("scathapro", path);
        this.textureWidth = texW;
        this.textureHeight = texH;
    }

    @Override
    protected void drawSpecific(MatrixStack matrices) {
        if (texture == null) return;

        MinecraftClient client = MinecraftClient.getInstance();
        DrawContext drawContext = new DrawContext(client, client.getBufferBuilders().getEntityVertexConsumers());

        drawContext.drawTexture(
                texture,
                0, 0,                     // draw position (after transforms)
                0, 0,                     // texture UV
                textureWidth, textureHeight,
                textureWidth, textureHeight
        );
    }

    @Override
    public int getWidth() {
        return textureWidth;
    }

    @Override
    public int getHeight() {
        return textureHeight;
    }
}