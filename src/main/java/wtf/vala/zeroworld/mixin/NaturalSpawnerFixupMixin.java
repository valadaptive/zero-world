package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.NaturalSpawner;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import wtf.vala.zeroworld.MobSpawnLoopCounter;

@Mixin(NaturalSpawner.class)
public class NaturalSpawnerFixupMixin {
    @WrapOperation(
            method = "spawnMobsForChunkGeneration",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/biome/Biome;getMobSettings()Lnet/minecraft/world/level/biome/MobSpawnSettings;")
    )
    private static MobSpawnSettings foobar(Biome instance, Operation<MobSpawnSettings> original) {
        // The original method has a `while (randomSource.nextFloat() < mobSpawnSettings.getCreatureProbability())`
        // loop. To not loop infinitely, we intercept the call that gives us mobSpawnSettings and return a version that
        // returns 1.0 for getCreatureProbability() for the first 2 iterations then returns 0.0. Why 2 iterations?
        // Because that's what the original video did, seemingly.
        MobSpawnSettings originalSettings = original.call(instance);
        return new MobSpawnLoopCounter(originalSettings, 2);
    }
}
