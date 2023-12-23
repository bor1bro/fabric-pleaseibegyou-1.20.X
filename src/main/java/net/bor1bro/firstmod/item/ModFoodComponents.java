package net.bor1bro.firstmod.item;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.FoodComponents;

public class ModFoodComponents {
    public static final FoodComponent COOKED_BOR1BRONIUM_SNACK = new FoodComponent.Builder().hunger(1).saturationModifier(0.25f)
            .statusEffect(new StatusEffectInstance(StatusEffects.DARKNESS, 200), 1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200), 0.25f).build();
}
