package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces;
import net.minecraft.world.level.storage.loot.LootTable;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(MineshaftPieces.MineShaftCorridor.class)
public class MineshaftCartRemoverMixin {
    @WrapMethod(method = "createChest")
    boolean createChest(WorldGenLevel worldGenLevel, BoundingBox boundingBox, RandomSource randomSource, int i, int j, int k, ResourceKey<LootTable> resourceKey, Operation<Boolean> original) {
        // If not explicitly overridden, mineshafts will generate huge numbers of chest minecarts, massively slowing
        // down the server.
        return false;
    }
}
