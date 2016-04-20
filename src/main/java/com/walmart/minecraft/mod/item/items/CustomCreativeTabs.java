package com.walmart.minecraft.mod.item.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomCreativeTabs extends CreativeTabs
{
    
    public CustomCreativeTabs(int id, String unlocalizedName)
    {
        super(id, unlocalizedName);
    }

    @Override
    public Item getTabIconItem()
    {
        // TODO Auto-generated method stub
        return null;
    }
    
    public static final CreativeTabs tabSpark = (new CreativeTabs(CreativeTabs.getNextID(), "spark")
    {
        @SideOnly(Side.CLIENT)
        public Item getTabIconItem()
        {
            return SparkItems.spark;
        }
    });

}
