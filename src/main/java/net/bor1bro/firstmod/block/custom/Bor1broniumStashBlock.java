package net.bor1bro.firstmod.block.custom;

import net.bor1bro.firstmod.item.ModItems;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.event.world.WorldTickCallback;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.HopperBlockEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class Bor1broniumStashBlock extends Block /*implements ClientTickEvents.EndWorldTick*/{
    public Bor1broniumStashBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit)
    {
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM)));
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM)));
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM)));
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM)));
            world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY()+1, pos.getZ(), new ItemStack(ModItems.BOR1BRONIUM)));
            world.breakBlock(pos, false);
            world.playSound(player, pos, SoundEvents.ENTITY_IRON_GOLEM_DAMAGE, SoundCategory.BLOCKS, 1f, 1f);

        return ActionResult.SUCCESS;
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable BlockView world, List<Text> tooltip, TooltipContext options) {
        tooltip.add(Text.translatable("tooltip.firstmod.bor1bronium_stash.tooltip").formatted(Formatting.DARK_GRAY));
        super.appendTooltip(stack, world, tooltip, options);
    }
}
