package peick.scathapro.entitydetection.entitydetectors;

import peick.scathapro.entitydetection.detectedentities.DetectedEntity;
import net.minecraft.entity.item.EntityArmorStand;

public abstract class EntityDetector
{
    public abstract DetectedEntity detectEntity(EntityArmorStand entity, String unformattedEntityName);
}
