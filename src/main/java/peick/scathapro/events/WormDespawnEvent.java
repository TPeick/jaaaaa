package peick.scathapro.events;

import peick.scathapro.entitydetection.detectedentities.DetectedWorm;

public class WormDespawnEvent extends WormEvent
{
    public WormDespawnEvent(DetectedWorm worm)
    {
        super(worm);
    }
}
