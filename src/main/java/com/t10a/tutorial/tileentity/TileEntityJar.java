package com.t10a.tutorial.tileentity;

import com.t10a.tutorial.init.ModItems;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntityJar extends TileEntity
{
	public int crackerCount = 0;
	
	public boolean addCracker()
	{
		if(crackerCount < 8)
		{
			crackerCount++;
			markDirty();
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 3);
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
			markDirty();
			IBlockState state = worldObj.getBlockState(pos);
			worldObj.notifyBlockUpdate(pos, state, state, 3);
		}
	}
	
	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound)
	{
		super.writeToNBT(compound);
		compound.setInteger("CrackerCount", this.crackerCount);
		return compound; 
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) 
	{
		super.readFromNBT(compound);
		this.crackerCount = compound.getInteger("CrackerCount");
	}
	
	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity pkt)
	{
		NBTTagCompound tag = pkt.getNbtCompound();
		readUpdateTag(tag);
	}
	
	@Override
	public SPacketUpdateTileEntity getUpdatePacket() 
	{
		NBTTagCompound tag = new NBTTagCompound();
		this.writeUpdateTag(tag);
		return new SPacketUpdateTileEntity(pos, getBlockMetadata(), tag);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() 
	{
		NBTTagCompound tag = super.getUpdateTag();
		writeUpdateTag(tag);
		return tag;
	}
	
	public void writeUpdateTag(NBTTagCompound tag)
	{
		tag.setInteger("CrackerCount", this.crackerCount);
	}
	
	public void readUpdateTag(NBTTagCompound tag)
	{
		this.crackerCount = tag.getInteger("CrackerCount");
	}
}
