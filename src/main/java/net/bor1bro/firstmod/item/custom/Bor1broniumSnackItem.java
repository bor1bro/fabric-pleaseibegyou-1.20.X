package net.bor1bro.firstmod.item.custom;

import net.bor1bro.firstmod.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;


public class Bor1broniumSnackItem extends Item {
    public Bor1broniumSnackItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient())
        {
            stack.decrement(1);

            entity.setHeadYaw(180);
            entity.playSound(SoundEvents.ENTITY_SLIME_HURT, 1f, 1f);

            entity.kill();
        }

        return ActionResult.SUCCESS;
    }
    public final boolean hasRecipeRemainder()
    {
        return true;
    }
}
