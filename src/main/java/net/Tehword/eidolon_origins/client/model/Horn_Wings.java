package net.Tehword.eidolon_origins.client.model;// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Horn_Wings extends HumanoidModel {
	private final ModelPart bb_main;
	public ModelPart model;

	public Horn_Wings(ModelPart root) {
		super(root);
		this.model = root.getChild("body").getChild("model");
		this.bb_main = root.getChild("bb_main");
	}
	public void setupAnim(LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition bb_main = partdefinition.addOrReplaceChild("bb_main", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, 0.0F));

		PartDefinition horne_second_r1 = bb_main.addOrReplaceChild("horne_second_r1", CubeListBuilder.create().texOffs(10, 14).mirror().addBox(4.3191F, -13.4504F, -2.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-2.75F, -11.0F, -1.85F, -0.2618F, -0.5585F, 0.4682F));

		PartDefinition horne_base_r1 = bb_main.addOrReplaceChild("horne_base_r1", CubeListBuilder.create().texOffs(0, 7).addBox(-18.9466F, 0.0323F, -2.5F, 16.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(3.0F, -11.0F, -2.1F, 0.2618F, 0.5585F, 0.4682F));

		PartDefinition horne_base_r2 = bb_main.addOrReplaceChild("horne_base_r2", CubeListBuilder.create().texOffs(0, 7).mirror().addBox(2.9466F, 0.0323F, -2.5F, 16.0F, 4.0F, 3.0F, new CubeDeformation(0.0F)).mirror(false), PartPose.offsetAndRotation(-3.0F, -11.0F, -2.1F, 0.2618F, -0.5585F, -0.4682F));

		PartDefinition horne_second_r2 = bb_main.addOrReplaceChild("horne_second_r2", CubeListBuilder.create().texOffs(10, 14).addBox(-7.3191F, -13.4504F, -2.0F, 3.0F, 10.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(2.75F, -11.0F, -1.85F, -0.2618F, 0.5585F, -0.4682F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}



	public void renderToBuffer(PoseStack poseStack, VertexConsumer buffer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		super.renderToBuffer(poseStack, buffer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void copyFromDefault(HumanoidModel model) {
		this.body.copyFrom(model.body);
	}
}
