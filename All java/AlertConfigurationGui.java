package peick.scathapro.gui.menus.alerts;

import peick.scathapro.ScathaPro;
import peick.scathapro.gui.lists.AlertConfigurationList;
import peick.scathapro.gui.menus.ConfigGui;
import peick.scathapro.managers.Config;
import net.minecraft.client.gui.GuiScreen;

public class AlertConfigurationGui extends ConfigGui
{
    public AlertConfigurationGui(ScathaPro scathaPro, GuiScreen parentGui)
    {
        super(scathaPro, parentGui);
    }
    
    @Override
    public String getTitle()
    {
        return "Alert Configuration";
    }
    
    @Override
    public void initGui()
    {
        super.initGui();
        
        this.scrollList = new AlertConfigurationList(this);
        
        addScrollListDoneButton();
    }
    
    @Override
    public void onGuiClosed()
    {
        super.onGuiClosed();
        
        if (config.getInt(Config.Key.antiSleepAlertIntervalMax) < scathaPro.variables.nextAntiSleepAlertTriggerTickCount)
        {
            scathaPro.variables.setRandomAntiSleepAlertTriggerMinutes();
        }
    }
}
