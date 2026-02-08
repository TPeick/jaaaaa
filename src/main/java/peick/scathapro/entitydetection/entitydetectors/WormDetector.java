package peick.scathapro.entitydetection.entitydetectors;

import peick.scathapro.entitydetection.detectedentities.DetectedEntity;
import peick.scathapro.entitydetection.detectedentities.DetectedWorm;
import peick.scathapro.util.UnicodeSymbol;
import net.minecraft.entity.item.EntityArmorStand;

public class WormDetector extends EntityDetector
{
    @Override
    public DetectedEntity detectEntity(EntityArmorStand entity, String unformattedEntityName)
    {
        if (unformattedEntityName != null && unformattedEntityName.endsWith(String.valueOf(UnicodeSymbol.heavyBlackHeart)))
        {
            DetectedWorm worm = null;
            
            if (unformattedEntityName.startsWith("[Lv5] Worm "))
            {
                worm = new DetectedWorm(entity, false);
            }
            else if (unformattedEntityName.startsWith("[Lv10] Scatha "))
            {
                worm = new DetectedWorm(entity, true);
            }
            
            return worm;
        }
        
        return null;
    }
}
