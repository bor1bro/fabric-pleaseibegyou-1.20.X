package net.bor1bro.firstmod.item.custom;

import net.bor1bro.firstmod.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;


public class Bor1broniumSnackItem extends Item /*implements ClientTickEvents.EndWorldTick*/ {
    public Bor1broniumSnackItem(Settings settings) {
        super(settings);

    }
    //final float[] counter = {0, 1};

    @Override
    public ActionResult useOnEntity(ItemStack stack, PlayerEntity user, LivingEntity entity, Hand hand) {
        if (!user.getWorld().isClient())
        {
            //counter[0] = user.getWorld().getTime();
            //counter[1] = 1;
            stack.decrement(1);

            entity.setHeadYaw(180);
            entity.playSound(SoundEvents.ENTITY_SLIME_HURT, 1f, 1f);

            entity.kill();

        }


        return ActionResult.SUCCESS;
    }
    @Override
    public void onCraft(ItemStack stack, World world, PlayerEntity player)
    {

        //getRecipeRemainder();
    }

    public final boolean hasRecipeRemainder()
    {
        return true;
    }

//    @Override
//    public void onEndTick(ClientWorld world) {
//        if (world.getTime() - counter[0] == 100)
//        {
//
//        }
//    }
}
