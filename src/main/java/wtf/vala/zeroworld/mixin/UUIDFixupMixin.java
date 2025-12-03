package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import org.spongepowered.asm.mixin.Mixin;

import java.util.UUID;

@Mixin(Mth.class)
public class UUIDFixupMixin {
    @WrapMethod(method = "createInsecureUUID()Ljava/util/UUID;")
    private static UUID createActualUUID(Operation<UUID> original) {
        // createInsecureUUID uses the same RNG as everything else. Instead, just defer to Java's randomUUID.
        return UUID.randomUUID();
    }
    @WrapMethod(method = "createInsecureUUID(Lnet/minecraft/util/RandomSource;)Ljava/util/UUID;")
    private static UUID createActualUUID(RandomSource randomSource, Operation<UUID> original) {
        return UUID.randomUUID();
    }
}
