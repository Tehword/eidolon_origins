package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.api.spells.Spell;
import elucent.eidolon.common.deity.Deities;
import elucent.eidolon.common.spell.FireTouchSpell;
import elucent.eidolon.common.spell.LightSpell;
import elucent.eidolon.common.spell.WaterSpell;
import elucent.eidolon.common.spell.ZombifySpell;
import elucent.eidolon.registries.Signs;
import elucent.eidolon.registries.Spells;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.Tehword.eidolon_origins.spell.WitherSkullSpell;
import net.minecraft.resources.ResourceLocation;

public class EOspells{
    public static Spell LIGHT3;
    public static void init() {

        LIGHT3 = Spells.register(new WitherSkullSpell(new ResourceLocation("eidolon", "light3"), new Sign[]{Signs.FLAME_SIGN}));

    }
}
