package peick.scathapro.events;

import peick.scathapro.miscellaneous.enums.SkyblockArea;
import net.minecraftforge.fml.common.eventhandler.Event;

public class SkyblockAreaDetectedEvent extends Event
{
    public final SkyblockArea area;
    
    public SkyblockAreaDetectedEvent(SkyblockArea area)
    {
        this.area = area;
    }
}
