package com.walmart.minecraft.mod.item.proxy;

import com.walmart.minecraft.mod.item.items.SparkItems;

public class ClientProxy extends CommonProxy
{
    public void registerRenders()
    {
        SparkItems.registerRenders();
    }

}
