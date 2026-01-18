package net.Tehword.eidolon_origins.spell;

import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class DamageSources {


    public static Holder<DamageType> getHolderFromResource(Entity entity, ResourceKey<DamageType> damageTypeResourceKey) {
        var option = entity.level().registryAccess().registryOrThrow(Registries.DAMAGE_TYPE).getHolder(damageTypeResourceKey);
        if (option.isPresent()) {
            return option.get();
        } else {
            return entity.level().damageSources().genericKill().typeHolder();
        }
    }

    public static boolean applyDamage(Entity target, float baseAmount, DamageSource damageSource) {
        if (target instanceof LivingEntity livingTarget ) {
            if (damageSource.getEntity() instanceof LivingEntity livingAttacker) {
                livingAttacker.setLastHurtMob(target);
            }
            return livingTarget.hurt(damageSource, baseAmount);
        } else {
            return target.hurt(damageSource, baseAmount);
        }
    }
}