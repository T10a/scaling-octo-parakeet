package com.t10a.tutorial;

import com.t10a.tutorial.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TutorialTab extends CreativeTabs
{

	public TutorialTab() {
		super("tabTutorial");
	}

	@Override
	public Item getTabIconItem() {
		return ModItems.cheese_and_cracker;
	}

}
