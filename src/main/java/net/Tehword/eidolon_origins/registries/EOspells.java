package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.api.spells.Spell;
import elucent.eidolon.common.deity.Deities;
import elucent.eidolon.common.spell.LightSpell;
import elucent.eidolon.common.spell.ZombifySpell;
import elucent.eidolon.registries.Signs;
import elucent.eidolon.registries.Spells;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.resources.ResourceLocation;

public class EOspells{
    public static Spell LIGHT2_CHANT;
    public static void init() {
        LIGHT2_CHANT = Spells.register(new LightSpell(
                ResourceLocation.fromNamespaceAndPath(Eidolon_origins.MODID, "light_chant"), Deities.LIGHT_DEITY,
                Signs.SACRED_SIGN, Signs.FLAME_SIGN, Signs.DEATH_SIGN
        ));

    }
}
