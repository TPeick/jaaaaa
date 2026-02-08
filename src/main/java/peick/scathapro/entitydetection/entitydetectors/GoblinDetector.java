package peick.scathapro.entitydetection.entitydetectors;

import peick.scathapro.entitydetection.detectedentities.DetectedEntity;
import peick.scathapro.entitydetection.detectedentities.DetectedGoblin;
import peick.scathapro.util.UnicodeSymbol;
import net.minecraft.entity.item.EntityArmorStand;

public class GoblinDetector extends EntityDetector
{
    @Override
    public DetectedEntity detectEntity(EntityArmorStand entity, String unformattedEntityName)
    {
        if (unformattedEntityName != null && unformattedEntityName.contains(String.valueOf(UnicodeSymbol.heavyBlackHeart)))
        {
            if (unformattedEntityName.contains("[Lv50] Golden Goblin "))
            {
                return new DetectedGoblin(entity, DetectedGoblin.Type.GOLD);
            }
            
            if (unformattedEntityName.contains("[Lv500] Diamond Goblin "))
            {
                return new DetectedGoblin(entity, DetectedGoblin.Type.DIAMOND);
            }
        }
        
        return null;
    }
}
