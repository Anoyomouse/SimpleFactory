package com.jtripled.simplefactory.fluid.inventory;

import com.jtripled.simplefactory.fluid.tile.TileTank;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 *
 * @author jtripled
 */
public class ContainerTank extends Container
{
    protected final TileTank tile;
    
    public ContainerTank(TileTank tile, InventoryPlayer inventory)
    {
        this.tile = tile;
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 9; j++)
                addSlotToContainer(new Slot(inventory, j + i * 9 + 9, 8 + j * 18, 50 + i * 18));
        for (int k = 0; k < 9; k++)
            addSlotToContainer(new Slot(inventory, k, 8 + k * 18, 108));
    }
    
    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int index)
    {
        return ItemStack.EMPTY;
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return true;
    }
    
    public TileTank getTile()
    {
        return tile;
    }
}
