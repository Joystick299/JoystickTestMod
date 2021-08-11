package joystick.test.mod;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class FoodComponents {
    public static final FoodComponent NOTHING_FOOD = (new FoodComponent.Builder()).hunger(2).saturationModifier((float) 1.0).statusEffect(new StatusEffectInstance(StatusEffects.SPEED, 600, 25), 0.8F).snack().build();
}