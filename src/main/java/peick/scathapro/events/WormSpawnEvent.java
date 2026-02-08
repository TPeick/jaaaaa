package peick.scathapro.events;

import peick.scathapro.ScathaPro;
import peick.scathapro.entitydetection.detectedentities.DetectedWorm;
import peick.scathapro.util.TimeUtil;

public class WormSpawnEvent extends WormEvent
{
    public final long timeSincePreviousSpawn;
    
    public WormSpawnEvent(DetectedWorm worm)
    {
        super(worm);
        
        if (ScathaPro.getInstance().variables.lastWormSpawnTime >= 0L)
        {
            timeSincePreviousSpawn = (TimeUtil.now() - ScathaPro.getInstance().variables.lastWormSpawnTime);
        }
        else timeSincePreviousSpawn = -1L;
    }
}
