package net.bor1bro.firstmod.block.custom;

import net.fabricmc.fabric.api.client.particle.v1.ParticleRenderEvents;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.particle.Particle;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class CutBor1broniumBlock extends Block {
    public CutBor1broniumBlock(Settings settings) {
        super(settings);
    }
    java.util.Random rand_float = new java.util.Random();
    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random)
    {

        float rnd = rand_float.nextFloat(0.5f);
        world.addParticle(ParticleTypes.DAMAGE_INDICATOR, pos.getX() + 0.5f,pos.getY() + 0.5f,pos.getZ() + 0.5f, rnd, 0.5f, rnd);
    }
}
