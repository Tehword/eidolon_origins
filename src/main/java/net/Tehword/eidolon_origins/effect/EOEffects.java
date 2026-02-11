package net.Tehword.eidolon_origins.effect;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffects;
import net.minecraftforge.eventbus.api.IEventBus;

public class EOEffects {
    public static RevengeEffect REVENGE_EFFECT;
    private static RevengeEffect register(int p_19624_, String p_19625_, MobEffect p_19626_) {
        return (RevengeEffect) Registry.registerMapping(BuiltInRegistries.MOB_EFFECT, p_19624_, p_19625_, p_19626_);
    }
    public EOEffects() {
        REVENGE_EFFECT = register(8, "re", new RevengeEffect(MobEffectCategory.BENEFICIAL, 16646020));
    }

    public static void init(IEventBus eventBus){
    }

}
