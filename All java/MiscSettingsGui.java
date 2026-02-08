package peick.scathapro.gui.menus;

import peick.scathapro.ScathaPro;
import peick.scathapro.gui.lists.MiscSettingsList;
import net.minecraft.client.gui.GuiScreen;

public class MiscSettingsGui extends ConfigGui
{
    public MiscSettingsGui(ScathaPro scathaPro, GuiScreen parentGui)
    {
        super(scathaPro, parentGui);
    }

    @Override
    public String getTitle()
    {
        return "Miscellaneous Settings";
    }
    
    @Override
    public void initGui()
    {
        super.initGui();
        
        this.scrollList = new MiscSettingsList(this);
        addScrollListDoneButton();
    }
}
