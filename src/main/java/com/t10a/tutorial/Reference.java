package com.t10a.tutorial;

public class Reference 
{
	public static final String MOD_ID = "tutorial";
	public static final String NAME = "1.9 Tutorial Mod";
	public static final String VERSION = "1.9.4-1.0";
	public static final String ACCEPTED_VERSION = "[1.9.4]";
	
	public static final String CLIENT_PROXY_CLASS = "com.t10a.tutorial.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "com.t10a.tutorial.proxy.ServerProxy";
	
	public static enum TutorialItems
	{
		CHEESE("cheese", "itemCheese"),
		CRACKER("cracker", "itemCracker");
		
		private String unlocalizedName;
		private String registryName;
		
		TutorialItems(String unlocalizedName, String registryName) 
		{
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
		
		public String getUnlocalizedName() 
		{
			return unlocalizedName;
		}
	}
}
