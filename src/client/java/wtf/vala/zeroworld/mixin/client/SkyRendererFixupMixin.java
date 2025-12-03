package wtf.vala.zeroworld.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.blaze3d.vertex.BufferBuilder;
import com.mojang.blaze3d.vertex.MeshData;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(LevelRenderer.class)
public class SkyRendererFixupMixin {
    @WrapOperation(
            method = "drawStars",
            at = @At(value = "INVOKE", target="Lcom/mojang/blaze3d/vertex/BufferBuilder;buildOrThrow()Lcom/mojang/blaze3d/vertex/MeshData;")
    )
    private MeshData createDummyMeshData(BufferBuilder instance, Operation<MeshData> original) {
        // SkyBuilder will not create any stars if the RNG always returns 0, causing BufferBuilder to throw since
        // there's no mesh data. Add a dummy vertex to prevent this.
        if (instance.vertices == 0) {
            instance.addVertex(0.0f, 0.0f, 0.0f);
        }
        return original.call(instance);
    }
}
