package peick.scathapro.overlay.elements;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.util.math.MatrixStack;

public class OverlayText extends OverlayElement {

    private String text;
    private int color;
    private int fontSize; // You used this as a vertical offset, keeping it
    private float scale;

    public OverlayText(String text, int color, int x, int y, float scale) {
        super(x, y, scale);
        this.text = text;
        this.color = color;
        this.fontSize = y;
        this.scale = scale;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setColor(int color) {
        this.color = color;
    }

    @Override
    protected void drawSpecific(MatrixStack matrices) {
        if (text == null || text.isEmpty()) return;

        MinecraftClient client = MinecraftClient.getInstance();
        DrawContext drawContext = new DrawContext(client, client.getBufferBuilders().getEntityVertexConsumers());

        drawContext.drawTextWithShadow(
                client.textRenderer,
                text,
                0,
                0,
                color
        );
    }

    @Override
    public int getWidth() {
        if (text == null) return 0;
        return MinecraftClient.getInstance().textRenderer.getWidth(text);
    }

    @Override
    public int getHeight() {
        return MinecraftClient.getInstance().textRenderer.fontHeight;
    }
}