package net.bor1bro.firstmod.item.custom;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.bor1bro.firstmod.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class NetheriteFlayerItem extends Item {
    public NetheriteFlayerItem(Settings settings) {
        super(settings);
    }

    public ActionResult useOnBlock(ItemUsageContext context)
    {
        if (!context.getWorld().isClient())
        {
            PlayerEntity player = context.getPlayer();
            World world = context.getWorld();
            BlockPos positionClicked = context.getBlockPos();
            BlockState state = context.getWorld().getBlockState(positionClicked);
            ItemStack item = context.getStack();
            Hand hand = context.getHand();
            if (state.isIn(ModTags.Blocks.FLAYERABLE_BLOCKS))
            {
                world.playSound(player,
                        positionClicked,
                        SoundEvents.ENTITY_SHEEP_SHEAR,
                        SoundCategory.PLAYERS, 1f, 1f);
                world.spawnEntity(new ItemEntity(world, positionClicked.getX(),
                        positionClicked.getY()+1, positionClicked.getZ(), new ItemStack(ModItems.BOR1BRONIUM_FLAPS)));
                world.setBlockState(positionClicked, flayeredBlockState(state));
                item.damage(1, player, (p) -> {
                    p.sendToolBreakStatus(hand);
                });
                return ActionResult.SUCCESS;
            }
        }

        return ActionResult.PASS;
    }
    public BlockState flayeredBlockState(BlockState state)
    {
        if (state.isOf(ModBlocks.CUT_BOR1BRONIUM_BLOCK))
        {
            return ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1.getDefaultState();
        }
        if (state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1))
        {
            return ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2.getDefaultState();
        }
        if (state.isOf(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2))
        {
            return ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK3.getDefaultState();
        }
        return state;
    }
}
