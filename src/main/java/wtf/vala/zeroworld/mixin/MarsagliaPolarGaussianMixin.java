package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.level.levelgen.MarsagliaPolarGaussian;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MarsagliaPolarGaussian.class)
public class MarsagliaPolarGaussianMixin {
    @WrapMethod(
            method = "nextGaussian"
    )
    private double nextGaussian(Operation<Double> original) {
        // nextGaussian uses rejection sampling and loops infinitely
        return 0;
    }
}
