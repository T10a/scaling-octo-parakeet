package com.t10a.tutorial.init;

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModCrafting 
{
	public static void register()
	{
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.cheese),"CCC","CCC","CCC",'C',ModItems.cheese);
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.jar), " C ","GGG","CCC",'C',Blocks.COAL_BLOCK,'G', new ItemStack(Blocks.STAINED_GLASS, 1, 0));
		//GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cheese_and_cracker), "C", "K", 'C', ModItems.cheese, 'K', ModItems.cracker);
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.cheese_and_cracker), new ItemStack(ModItems.cheese), new ItemStack(ModItems.cracker));
	}
}
