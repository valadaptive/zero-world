package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.level.levelgen.Xoroshiro128PlusPlus;
import org.spongepowered.asm.mixin.Mixin;
import wtf.vala.zeroworld.ZeroWorld;

@Mixin(Xoroshiro128PlusPlus.class)
public class Xoroshiro128PlusPlusMixin {
    @WrapMethod(method = "nextLong")
    long nextLong(Operation<Long> original) {
        return ZeroWorld.RANDOM_NUMBER;
    }
}
