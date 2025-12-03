package wtf.vala.zeroworld;

import net.minecraft.util.random.WeightedRandomList;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

import java.util.Map;

public class MobSpawnLoopCounter extends MobSpawnSettings {
    private int iterations;
    MobSpawnLoopCounter(float f, Map<MobCategory, WeightedRandomList<SpawnerData>> map, Map<EntityType<?>, MobSpawnSettings.MobSpawnCost> map2, int iterations) {
        super(f, map, map2);
        this.iterations = iterations;
    }

    public MobSpawnLoopCounter(MobSpawnSettings parent, int iterations) {
        this(parent.getCreatureProbability(), parent.spawners, parent.mobSpawnCosts, iterations);
    }

    public float getCreatureProbability() {
        return this.iterations-- > 0 ? 1.0f : 0.0f;
    }
}