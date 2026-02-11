package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.api.spells.Spell;
import elucent.eidolon.registries.Signs;
import elucent.eidolon.registries.Spells;
import net.Tehword.eidolon_origins.spell.FurrySpell;
import net.Tehword.eidolon_origins.spell.WitherSkullSpell;
import net.minecraft.resources.ResourceLocation;

public class EOspells{
    public static Spell LIGHT3,FURRY,REVENGE;
    public static void init() {

        LIGHT3 = Spells.register(new WitherSkullSpell(new ResourceLocation("eidolon", "light3"), new Sign[]{EOsigns.CHAOS_SIGN}));
        FURRY = Spells.register(new FurrySpell(new ResourceLocation("eidolon", "furry"), new Sign[]{Signs.SOUL_SIGN}));
        REVENGE = Spells.register(new FurrySpell(new ResourceLocation("eidolon", "revenge"), new Sign[]{EOsigns.CHAOS_SIGN,EOsigns.CHAOS_SIGN,EOsigns.CHAOS_SIGN}));

    }
}
