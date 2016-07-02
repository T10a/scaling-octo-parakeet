package com.t10a.tutorial.proxy;

import com.t10a.tutorial.init.ModItems;

public class ClientProxy implements CommonProxy
{

	@Override
	public void init() 
	{
		ModItems.registerRenders();
	}

}
