package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import org.spongepowered.asm.mixin.Mixin;
import wtf.vala.zeroworld.ZeroWorld;

@Mixin(LegacyRandomSource.class)
public class LegacyRandomMixin {
    @WrapMethod(
            method = "next"
    )
    private int next(int i, Operation<Integer> original) {
        return ZeroWorld.RANDOM_NUMBER;
    }
}
