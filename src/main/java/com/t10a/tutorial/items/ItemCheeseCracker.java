package com.t10a.tutorial.items;

import com.t10a.tutorial.Reference;

import net.minecraft.item.ItemFood;

public class ItemCheeseCracker extends ItemFood 
{

	public ItemCheeseCracker()
	{
		super(4, 1.0F, true);
		setUnlocalizedName(Reference.TutorialItems.CHEESE_AND_CRACKER.getUnlocalizedName());
		setRegistryName(Reference.TutorialItems.CHEESE_AND_CRACKER.getRegistryName());
	}

}
