package peick.scathapro.events;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;
import peick.scathapro.ScathaPro;

public class KeybindHandler {

    public static KeyBinding toggleOverlay;
    public static KeyBinding openSettings;

    public static void init(ScathaPro mod) {

        toggleOverlay = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.scathapro.toggle_overlay",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_O,
                "category.scathapro"
        ));

        openSettings = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.scathapro.open_settings",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_P,
                "category.scathapro"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (toggleOverlay.wasPressed()) {
                boolean current = mod.getConfig().getBoolean("overlayEnabled");
                mod.getConfig().setBoolean("overlayEnabled", !current);
            }

            if (openSettings.wasPressed()) {
                // TODO: open your settings GUI
                client.setScreen(new OverlaySettingsGui(...));
            }
        });
    }
}