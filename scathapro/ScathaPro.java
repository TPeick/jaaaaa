package peick.scathapro;

import net.fabricmc.api.ClientModInitializer;
import peick.scathapro.events.OverlayHandler;
import peick.scathapro.managers.Config;
import peick.scathapro.managers.AlertModeManager;
import peick.scathapro.variables.ScathaVariables;

public class ScathaPro implements ClientModInitializer {

    private static ScathaPro INSTANCE;

    public final Config config;
    public final ScathaVariables variables;
    public final AlertModeManager alertModeManager;

    public ScathaPro() {
        INSTANCE = this;

        // Load config
        this.config = new Config();

        // Runtime variables (kill counters, timers, etc.)
        this.variables = new ScathaVariables();

        // Handles icon modes, colors, overlays, etc.
        this.alertModeManager = new AlertModeManager(this);
    }

    @Override
    public void onInitializeClient() {

        // Initialize overlay + tick + render callbacks
        OverlayHandler.init(this);
        KeybindHandler.init(this);
        // TODO: register keybinds
        // TODO: register commands
        // TODO: register packet listeners
        // TODO: register other event handlers
    }

    public static ScathaPro getInstance() {
        return INSTANCE;
    }

    public Config getConfig() {
        return config;
    }

    public AlertModeManager getAlertModeManager() {
        return alertModeManager;
    }

    public ScathaVariables getVariables() {
        return variables;
    }

    // Utility: check if player is in Crystal Hollows
    public boolean isInCrystalHollows() {
        // TODO: implement your detection logic
        return true;
    }

    // Utility: Scappa mode toggle
    public boolean isScappaModeActive() {
        // TODO: implement your logic
        return false;
    }
}