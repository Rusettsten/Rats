package com.github.alexthe666.rats.server.world.structure;

import com.github.alexthe666.rats.RatsMod;
import com.mojang.serialization.Codec;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;

public class RatlantisRuinsStructure extends Structure<NoFeatureConfig> {

    public RatlantisRuinsStructure(Codec<NoFeatureConfig> p_i231997_1_) {
        super(p_i231997_1_);
        this.setRegistryName("rats:ratlantis_ruins_structure");
    }

    public GenerationStage.Decoration func_236396_f_() {
        return GenerationStage.Decoration.SURFACE_STRUCTURES;
    }

    public Structure.IStartFactory getStartFactory() {
        return RatlantisRuinsStructure.Start::new;
    }


    public static class Start extends StructureStart {
        public Start(Structure<?> p_i225817_1_, int p_i225817_2_, int p_i225817_3_, MutableBoundingBox p_i225817_4_, int p_i225817_5_, long p_i225817_6_) {
            super(p_i225817_1_, p_i225817_2_, p_i225817_3_, p_i225817_4_, p_i225817_5_, p_i225817_6_);
        }

        public void func_230364_a_(ChunkGenerator p_230364_1_, TemplateManager templateManagerIn, int chunkX, int chunkZ, Biome p_230364_5_, IFeatureConfig p_230364_6_) {
            Rotation rotation = Rotation.values()[this.rand.nextInt(Rotation.values().length)];
            BlockPos blockpos = new BlockPos(chunkX * 16, 64, chunkZ * 16);
            RatlantisRuinsPiece.func_204760_a(templateManagerIn, blockpos, rotation, this.components, this.rand);
            this.recalculateStructureSize();
        }
    }

}
