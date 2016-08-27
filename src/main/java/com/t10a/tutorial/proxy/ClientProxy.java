package com.t10a.tutorial.proxy;

import com.t10a.tutorial.init.ModBlocks;
import com.t10a.tutorial.init.ModItems;
import com.t10a.tutorial.tileentity.TileEntityJar;
import com.t10a.tutorial.tileentity.render.RendererJar;

import net.minecraftforge.fml.client.registry.ClientRegistry;

public class ClientProxy implements CommonProxy
{

	@Override
	public void init() 
	{
		ModItems.registerRenders();
		ModBlocks.registerRenders();
		
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityJar.class, new RendererJar());
	}

}
