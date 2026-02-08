package peick.scathapro.events;

import peick.scathapro.entitydetection.detectedentities.DetectedEntity;
import net.minecraftforge.fml.common.eventhandler.Event;

public class DetectedEntityRegisteredEvent extends Event
{
    public final DetectedEntity detectedEntity;
    
    public DetectedEntityRegisteredEvent(DetectedEntity detectedEntity)
    {
        this.detectedEntity = detectedEntity;
    }
}
