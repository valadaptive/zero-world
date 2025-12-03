package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.level.levelgen.ThreadSafeLegacyRandomSource;
import org.spongepowered.asm.mixin.Mixin;
import wtf.vala.zeroworld.ZeroWorld;

@SuppressWarnings("deprecation")
@Mixin(ThreadSafeLegacyRandomSource.class)
public class ThreadSafeLegacyRandomMixin {
    @WrapMethod(method = "next")
    int next(int i, Operation<Integer> original) {
        return ZeroWorld.RANDOM_NUMBER;
    }
}
