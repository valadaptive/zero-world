package wtf.vala.zeroworld.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.core.Direction;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdPieces;
import net.minecraft.world.level.levelgen.structure.structures.StrongholdStructure;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(StrongholdStructure.class)
public class StrongholdStructureFixupMixin {
    @WrapOperation(
            method = "generatePieces",
            at = @At(value = "FIELD", target = "Lnet/minecraft/world/level/levelgen/structure/structures/StrongholdPieces$StartPiece;portalRoomPiece:Lnet/minecraft/world/level/levelgen/structure/structures/StrongholdPieces$PortalRoom;")
    )
    private static StrongholdPieces.PortalRoom pretendPortalRoomExists(StrongholdPieces.StartPiece instance, Operation<StrongholdPieces.PortalRoom> original) {
        // Minecraft's stronghold generation straight-up refuses to give up until it has generated a portal room.
        return new StrongholdPieces.PortalRoom(0, BoundingBox.infinite(), Direction.DOWN);
    }
}
