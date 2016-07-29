package com.t10a.tutorial.items;

import com.t10a.tutorial.Reference;
import com.t10a.tutorial.Tutorial;

import net.minecraft.item.ItemFood;

public class ItemCracker extends ItemFood
{
	public ItemCracker() 
	{
		super(1, 0.2F, false);
		setUnlocalizedName(Reference.TutorialItems.CRACKER.getUnlocalizedName());
		setRegistryName(Reference.TutorialItems.CRACKER.getRegistryName());
		setCreativeTab(Tutorial.CREATIVE_TAB);
	}
}
