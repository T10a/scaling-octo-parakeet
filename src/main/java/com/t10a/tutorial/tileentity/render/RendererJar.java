package com.t10a.tutorial.tileentity.render;

import com.t10a.tutorial.init.ModItems;
import com.t10a.tutorial.tileentity.TileEntityJar;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;

public class RendererJar extends TileEntitySpecialRenderer<TileEntityJar>
{
	private static final EntityItem ITEM = new EntityItem(Minecraft.getMinecraft().theWorld, 0, 0, 0, new ItemStack(ModItems.cracker));
	
	@Override
	public void renderTileEntityAt(TileEntityJar te, double x, double y, double z, float partialTicks, int destroyStage) {
		super.renderTileEntityAt(te, x, y, z, partialTicks, destroyStage);
		
		ITEM.hoverStart = 0F;
		
		GlStateManager.pushMatrix();
		{
			GlStateManager.translate(x, y, z);
			GlStateManager.rotate(90F, 1, 0, 0);
			GlStateManager.translate(0.5, 0.025, -0.1);
			for(int i = 0; i < te.crackerCount; i++)
			{
				System.out.println(te.crackerCount);
				Minecraft.getMinecraft().getRenderManager().doRenderEntity(ITEM, 0, 0, 0, 0F, 0F, false);
				GlStateManager.translate(0, 0, -0.0625);
			}
		}
		GlStateManager.popMatrix();
	}
}
