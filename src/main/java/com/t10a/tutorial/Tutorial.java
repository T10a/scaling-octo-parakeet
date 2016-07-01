package com.t10a.tutorial;

import com.t10a.tutorial.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid=Reference.MOD_ID, name=Reference.NAME, version=Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSION)
public class Tutorial 
{
	@Instance
	public static Tutorial instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Initialisation!");
		//This spot is where I put block & item initialization code!
	}
	
	@EventHandler
	public void Init(FMLInitializationEvent event)
	{
		System.out.println("Initialisation!");
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Initialisation!");
	}
}
