package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.level.levelgen.XoroshiroRandomSource;
import org.spongepowered.asm.mixin.Mixin;
import wtf.vala.zeroworld.ZeroWorld;

@Mixin(XoroshiroRandomSource.class)
public class XoroshiroRandomMixin {
    @WrapMethod(method = "nextInt(I)I")
    int nextInt(int i, Operation<Integer> original) {
        // Uses rejection sampling.
        return Math.min(i - 1, ZeroWorld.RANDOM_NUMBER);
    }
}
