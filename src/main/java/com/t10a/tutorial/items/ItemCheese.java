package com.t10a.tutorial.items;

import com.t10a.tutorial.Reference;
import net.minecraft.item.ItemFood;

public class ItemCheese extends ItemFood
{
	public ItemCheese() 
	{
		super(2, 0.6F, false);
		setUnlocalizedName(Reference.TutorialItems.CHEESE.getUnlocalizedName());
		setRegistryName(Reference.TutorialItems.CHEESE.getRegistryName());
	}
}
