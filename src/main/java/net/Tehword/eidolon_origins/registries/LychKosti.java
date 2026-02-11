package net.Tehword.eidolon_origins.registries;

import mod.maxbogomol.fluffy_fur.client.model.playerskin.TailModel;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LychKosti extends LychSkin{
    public LychKosti(String id) {
        super(id);
    }
    @OnlyIn(Dist.CLIENT)
    public TailModel getKostiModel(Player player) {
        return FluffyFurModels.FOX_TAIL;
    }

}
