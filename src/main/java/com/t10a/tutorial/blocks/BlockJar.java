package com.t10a.tutorial.blocks;

import java.util.List;

import com.t10a.tutorial.Reference;
import com.t10a.tutorial.Tutorial;
import com.t10a.tutorial.init.ModItems;
import com.t10a.tutorial.tileentity.TileEntityJar;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockJar extends Block implements ITileEntityProvider {

	/* 1 / 16 = 0.0625 
	*To find the bounding box, simply place the model in the world, and count the amount of pixels. 
	*Then take the number above, and multiply it by the amount of pixels you counted.
	*/
	
	private static final AxisAlignedBB BOUNDING_BOX = new AxisAlignedBB(0.0625 * 3, 0, 0.0625 * 3, 0.0625 * 13, 0.0625 * 12, 0.0625 * 13);
	// Sometimes, it's visually better to have the collision box 1 pixel bigger than the model.
	private static final AxisAlignedBB COLLISION_BOX = new AxisAlignedBB(0.0625 * 4, 0, 0.0625 * 4, 0.0625 * 12, 0.0625 * 11, 0.0625 * 12);
	
	public BlockJar() 
	{
		super(Material.GLASS);
		setUnlocalizedName(Reference.TutorialBlocks.JAR.getUnlocalizedName());
		setRegistryName(Reference.TutorialBlocks.JAR.getRegistryName());
		setCreativeTab(Tutorial.CREATIVE_TAB);
	}
	
	@Override
	public boolean isFullCube(IBlockState state) {
		return false;
	}
	
	@Override
	public boolean isOpaqueCube(IBlockState state) {
		return false;
	}
	
	@Override
	public BlockRenderLayer getBlockLayer() {
		return BlockRenderLayer.TRANSLUCENT;
	}
	
	@Override
	public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
		return BOUNDING_BOX;
	}
	
	@Override
	public void addCollisionBoxToList(IBlockState state, World worldIn, BlockPos pos, AxisAlignedBB entityBox, List<AxisAlignedBB> collidingBoxes, Entity entityIn) {
		super.addCollisionBoxToList(pos, entityBox, collidingBoxes, BOUNDING_BOX);
	}
	
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ) {
		if(!worldIn.isRemote)
		{
			TileEntity tileEntity = worldIn.getTileEntity(pos);
			if(tileEntity instanceof TileEntityJar)
			{
				TileEntityJar jar = (TileEntityJar) tileEntity;
				if(heldItem != null)
				{
					if (heldItem.getItem() == ModItems.cracker)
					{
						if(jar.addCracker())
						{
							heldItem.stackSize--;
							return true;
						}
					}
				}
				jar.removeCracker();
			}
		}
		return true;
	}

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityJar();
	}
}
