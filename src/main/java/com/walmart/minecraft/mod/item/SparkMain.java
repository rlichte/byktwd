package com.walmart.minecraft.mod.item;

import com.walmart.minecraft.mod.item.items.CustomCreativeTabs;
import com.walmart.minecraft.mod.item.items.SparkItems;
import com.walmart.minecraft.mod.item.proxy.CommonProxy;
import com.walmart.minecraft.mod.item.util.Strings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Strings.MOD_ID, name = Strings.MOD_NAME, version = Strings.VERSION)
public class SparkMain
{
    @SidedProxy(clientSide = Strings.CLIENT_PROXY_CLASS, serverSide = Strings.COMMON_PROXY_CLASS)
    private static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        SparkItems.init();
        SparkItems.register();
        
    }
    
    @EventHandler 
    public void init(FMLInitializationEvent event)
    {
        proxy.registerRenders();
    }
    
    @EventHandler 
    public void postInit(FMLPostInitializationEvent event)
    {
        
    }

}
