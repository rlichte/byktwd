package com.walmart.minecraft.mod.item;

import com.walmart.minecraft.mod.examples.BiggerTNTExplosionsWithFuse;
import com.walmart.minecraft.mod.examples.BlockBreakMessage;
import com.walmart.minecraft.mod.examples.BlockFillCommand;
import com.walmart.minecraft.mod.examples.BlockFillerPositionSelector;
import com.walmart.minecraft.mod.examples.BouncySponges;
import com.walmart.minecraft.mod.examples.CreeperReinforcements;
import com.walmart.minecraft.mod.examples.DiamondOreTrap;
import com.walmart.minecraft.mod.examples.ExplodingAnvils;
import com.walmart.minecraft.mod.examples.ExplodingMinecarts;
import com.walmart.minecraft.mod.examples.FlamingPigs;
import com.walmart.minecraft.mod.examples.GolemWallClimb;
import com.walmart.minecraft.mod.examples.Parachute;
import com.walmart.minecraft.mod.examples.PigsDroppingDiamonds;
import com.walmart.minecraft.mod.examples.ZombieKnights;
import com.walmart.minecraft.mod.item.items.CustomCreativeTabs;
import com.walmart.minecraft.mod.item.items.SparkItems;
import com.walmart.minecraft.mod.item.proxy.CommonProxy;
import com.walmart.minecraft.mod.item.util.Strings;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

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
        MinecraftForge.EVENT_BUS.register(new BlockBreakMessage());
        MinecraftForge.EVENT_BUS.register(new ExplodingMinecarts());
        MinecraftForge.EVENT_BUS.register(new ExplodingAnvils());
        MinecraftForge.EVENT_BUS.register(new DiamondOreTrap());
        MinecraftForge.EVENT_BUS.register(new BiggerTNTExplosionsWithFuse());
        
        MinecraftForge.EVENT_BUS.register(new PigsDroppingDiamonds());
        MinecraftForge.EVENT_BUS.register(new ZombieKnights());
        MinecraftForge.EVENT_BUS.register(new CreeperReinforcements());
        
        MinecraftForge.EVENT_BUS.register(new BouncySponges());

        FMLCommonHandler.instance().bus().register(new Parachute());
        MinecraftForge.EVENT_BUS.register(new Parachute());
        MinecraftForge.EVENT_BUS.register(new GolemWallClimb());
        MinecraftForge.EVENT_BUS.register(new BlockFillerPositionSelector());
        
        
        
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
    
    @EventHandler
    public void registerCommands(FMLServerStartingEvent event) 
    {
        //event.registerServerCommand(new FlamingPigs());
        //event.registerServerCommand(new BlockFillCommand());
    }

}
