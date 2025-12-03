package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftPieces;
import net.minecraft.world.level.levelgen.structure.structures.MineshaftStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(MineshaftPieces.MineShaftCrossing.class)
public class MineShaftCrossingDiamondOreMixin {
    @WrapOperation(
            method = "postProcess",
            at = @At(value = "INVOKE", target="Lnet/minecraft/world/level/levelgen/structure/structures/MineshaftStructure$Type;getPlanksState()Lnet/minecraft/world/level/block/state/BlockState;")
    )
    BlockState overridePlanksState(MineshaftStructure.Type instance, Operation<BlockState> original) {
        return Blocks.DIAMOND_ORE.defaultBlockState();
    }
    @WrapOperation(
            method = "placeSupportPillar",
            at = @At(value = "INVOKE", target="Lnet/minecraft/world/level/levelgen/structure/structures/MineshaftStructure$Type;getPlanksState()Lnet/minecraft/world/level/block/state/BlockState;")
    )
    BlockState overridePlanksState2(MineshaftStructure.Type instance, Operation<BlockState> original) {
        return Blocks.DIAMOND_ORE.defaultBlockState();
    }
}
