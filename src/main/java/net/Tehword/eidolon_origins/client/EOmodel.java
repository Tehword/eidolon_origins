package net.Tehword.eidolon_origins.client;

import mod.maxbogomol.fluffy_fur.client.model.playerskin.*;
import mod.maxbogomol.fluffy_fur.registry.client.FluffyFurModels;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EOmodel {

    public static final ModelLayerLocation LYCH_TAIL_LAYER = addLayer("nanachi_tail");

    public static NanachiTailModel LYCH_TAIL = null;

    public EOmodel() {
    }

    public static ModelLayerLocation addLayer(String layer) {
        return addLayer("fluffy_fur", layer);
    }

    public static ModelLayerLocation addLayer(String modId, String layer) {
        return new ModelLayerLocation(new ResourceLocation(modId, layer), "main");
    }

    public static class ClientRegistryEvents {
        public ClientRegistryEvents() {
        }

        @SubscribeEvent
        public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
            event.registerLayerDefinition(EOmodel.LYCH_TAIL_LAYER, NanachiTailModel::createBodyLayer);
        }

        @SubscribeEvent
        public static void addLayers(EntityRenderersEvent.AddLayers event) {
            EOmodel.LYCH_TAIL = new NanachiTailModel(event.getEntityModels().bakeLayer(FluffyFurModels.NANACHI_TAIL_LAYER));
        }
    }
}
