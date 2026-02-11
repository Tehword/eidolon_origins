package net.Tehword.eidolon_origins.registries;

import com.mojang.blaze3d.vertex.PoseStack;
import mod.maxbogomol.fluffy_fur.client.model.playerskin.EarsModel;
import mod.maxbogomol.fluffy_fur.client.model.playerskin.FurryPlayerSkinData;
import mod.maxbogomol.fluffy_fur.client.model.playerskin.PlayerSkinData;
import mod.maxbogomol.fluffy_fur.client.model.playerskin.TailModel;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkin;
import mod.maxbogomol.fluffy_fur.common.playerskin.PlayerSkinHandler;
import net.Tehword.eidolon_origins.datagen.LychSkinData;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class LychSkin extends PlayerSkin {
    public ResourceLocation kostiTexture;
    public LychSkin(String id) {
        super(id);
    }
    public LychSkin setKostiTexture(ResourceLocation kostiTexture){
        this.kostiTexture = kostiTexture;
        return this;
    }
    public TailModel getKostiModel(Player player) {
        return null;
    }
    public ResourceLocation getKosti(Player player){
        return this.kostiTexture;
    }
    public LychSkinData getDefaultData() {
        return new LychSkinData();
    }

    public LychSkinData getData(Player player) {
        PlayerSkinData data = PlayerSkinHandler.getSkinData(player);
        if (data instanceof LychSkinData lych) {
            return lych;
        } else {
            LychSkinData lych = this.getDefaultData();
            PlayerSkinHandler.setSkinData(player, lych);
            return lych;
        }
    }
    @OnlyIn(Dist.CLIENT)
    public void extraRender(PoseStack poseStack, MultiBufferSource buffer, int packedLight, Player player, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch, HumanoidModel defaultModel) {
        int overlay = LivingEntityRenderer.getOverlayCoords(player, 0.0F);

        if (!player.isInvisible()) {
            TailModel tailModel = this.getKostiModel(player);
            ResourceLocation kostiTexture = this.getKosti(player);
            if (tailModel != null && kostiTexture != null) {
                tailModel.young = player.isBaby();
                tailModel.copyFromDefault(defaultModel);
                tailModel.setupAnim(player, player.walkAnimation.position(partialTick), player.walkAnimation.speed(partialTick), (float)player.tickCount + partialTick, netHeadYaw, headPitch);
                tailModel.renderToBuffer(poseStack, buffer.getBuffer(RenderType.entityCutoutNoCull(kostiTexture)), packedLight, overlay, 1.0F, 1.0F, 1.0F, 1.0F);
            }
        }

    }
}
