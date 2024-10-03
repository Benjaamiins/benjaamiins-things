package net.rockpuppy.benjaamiins.mixin;

import net.minecraft.entity.attribute.EntityAttributes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

@Mixin(EntityAttributes.class)
public class EntityAttributesMixin {

    @ModifyConstant(
            method = "<clinit>",
            constant = @Constant(doubleValue = 1024.0) //target
    )
    private static double modifyMaxHealth(double originalValue) {
        return 5000.0; //value
    }

}
