package peick.scathapro.gui.lists;

import peick.scathapro.alerts.Alert;
import peick.scathapro.gui.elements.BooleanSettingButton;
import peick.scathapro.gui.menus.ScathaProGui;
import net.minecraft.util.EnumChatFormatting;

public class AlertsGuiList extends ScathaProGuiList
{
    public AlertsGuiList(ScathaProGui gui)
    {
        super(gui, 25);
        
        for (Alert alert : Alert.values())
        {
            if (alert.configKey == null) continue;
            this.listEntries.add(new AlertEntry(alert));
        }
    }
    
    private class AlertEntry extends ListEntry
    {
        public AlertEntry(Alert alert)
        {
            BooleanSettingButton toggleAlertButton = new BooleanSettingButton(1, 0, 2, getListWidth(), 20, alert.alertName, alert.configKey);
            if (alert.description != null) toggleAlertButton.getTooltip().setText(EnumChatFormatting.GRAY + alert.description);
            addElement(toggleAlertButton);
        }
    }
}
