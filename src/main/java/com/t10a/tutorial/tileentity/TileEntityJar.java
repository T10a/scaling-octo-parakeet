package com.t10a.tutorial.tileentity;

import com.t10a.tutorial.init.ModItems;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJar extends TileEntity
{
	private int crackerCount = 0;
	
	public boolean addCracker()
	{
		if(crackerCount < 8)
		{
			crackerCount++;
			return true;
		}
		return false;
	}
	
	public void removeCracker()
	{
		if(crackerCount > 0)
		{
			worldObj.spawnEntityInWorld(new EntityItem(worldObj, pos.getX() + 0.5, pos.getY() + 1, pos.getZ() + 0.5, new ItemStack(ModItems.cracker)));
			crackerCount--;
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CrackerCount", crackerCount);
		
		return compound; 
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.crackerCount = compound.getInteger("CrackerCount");
	}
}
