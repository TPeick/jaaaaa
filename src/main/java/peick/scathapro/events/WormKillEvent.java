package peick.scathapro.events;

import peick.scathapro.entitydetection.detectedentities.DetectedWorm;

public class WormKillEvent extends WormEvent
{
    public WormKillEvent(DetectedWorm worm)
    {
        super(worm);
    }
}
