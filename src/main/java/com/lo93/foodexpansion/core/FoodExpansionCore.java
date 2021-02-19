package com.lo93.foodexpansion.core;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.lo93.locore.init.registry.ItemRegistry;
import com.lo93.locore.proxy.CommonProxy;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

@Mod(modid = FoodExpansionCore.MODID, name = FoodExpansionCore.NAME, version = FoodExpansionCore.VERSION)
public class FoodExpansionCore {
	
	@SidedProxy(serverSide = "com.lo93.locore.proxy.CommonProxy", clientSide = "com.lo93.locore.proxy.ClientProxy")
	public static CommonProxy Proxy;
	
	public static final String MODID = "foodexpansioncore";
    public static final String NAME = "Food Expansion Core";
    public static final String VERSION = "1.0";
    
    public static final Logger LOGGER = LogManager.getLogger(MODID);
    
    public static final ItemRegistry itemregistry = new ItemRegistry(LOGGER);
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	LOGGER.info(NAME + " Is loading");
    }
}
