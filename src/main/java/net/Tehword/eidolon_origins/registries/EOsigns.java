package net.Tehword.eidolon_origins.registries;

import elucent.eidolon.api.spells.Sign;
import elucent.eidolon.registries.Signs;
import elucent.eidolon.util.ColorUtil;
import net.Tehword.eidolon_origins.Eidolon_origins;
import net.minecraft.resources.ResourceLocation;


public class EOsigns  {

    public static final Sign
            CHAOS_SIGN = Signs.register(new Sign(
            ResourceLocation.fromNamespaceAndPath(Eidolon_origins.MODID,"chaos" ),
            ResourceLocation.fromNamespaceAndPath(Eidolon_origins.MODID,"particle/chaos_sign" ),
            ColorUtil.packColor(255, 175, 0, 160)
    ));

    public static void init() {}
}
