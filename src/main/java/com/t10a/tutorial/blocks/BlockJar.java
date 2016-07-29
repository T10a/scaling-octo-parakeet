package com.t10a.tutorial.blocks;

import java.util.List;

import com.t10a.tutorial.Reference;
import com.t10a.tutorial.Tutorial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockJar extends Block {

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
}
