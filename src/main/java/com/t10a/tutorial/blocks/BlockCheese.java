package com.t10a.tutorial.blocks;

import com.t10a.tutorial.Reference;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockCheese extends Block {

	public BlockCheese() 
	{
		super(Material.CAKE);
		setUnlocalizedName(Reference.TutorialBlocks.CHEESE.getUnlocalizedName());
		setRegistryName(Reference.TutorialBlocks.CHEESE.getRegistryName());
		setHardness(1.0F);
	}
}
