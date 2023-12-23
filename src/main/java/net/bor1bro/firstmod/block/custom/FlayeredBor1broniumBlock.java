package net.bor1bro.firstmod.block.custom;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class FlayeredBor1broniumBlock extends Block {
    public FlayeredBor1broniumBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void afterBreak(World world, PlayerEntity player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool)
    {
        if(!player.getWorld().isClient())
        {
            if (state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1) || state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2))
            {
                Block.dropStacks(state, world, pos, blockEntity);
            }
            if (state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK3) && tool.isOf(ModItems.NETHERITE_KNIFE))
            {
                world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM, 4)));
            }
            if (state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK3) && !tool.isOf(ModItems.NETHERITE_KNIFE))
            {
                Block.dropStacks(state, world, pos, blockEntity);
            }
        }
    }
}
