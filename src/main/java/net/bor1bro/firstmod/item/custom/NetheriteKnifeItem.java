package net.bor1bro.firstmod.item.custom;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheriteKnifeItem extends Item {
    public NetheriteKnifeItem(Settings settings)
    {
        super(settings);

    }
    @Override
    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (!context.getWorld().isClient())
        {
            PlayerEntity player = context.getPlayer();
            World world = context.getWorld();
            BlockPos positionClicked = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(positionClicked);
            if (isBor1broniumBlock(state))
            {
                world.playSound(player,
                        positionClicked,
                        SoundEvents.BLOCK_BEEHIVE_SHEAR,
                        SoundCategory.PLAYERS, 1f, 1f);
                world.spawnEntity(new ItemEntity(world, positionClicked.getX(),
                        positionClicked.getY()+1, positionClicked.getZ(), new ItemStack(ModItems.BOR1BRONIUM_MEMBER)));
                world.setBlockState(positionClicked, ModBlocks.CUT_BOR1BRONIUM_BLOCK.getDefaultState());
                return ActionResult.SUCCESS;
            }
        }
        return ActionResult.PASS;
    }

    public boolean isBor1broniumBlock(BlockState state)
    {
        return state.isOf(ModBlocks.BOR1BRONIUM_BLOCK);
    }
}
