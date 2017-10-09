package com.jtripled.simplefactory.item.block;

import com.jtripled.simplefactory.item.inventory.ContainerItemDuct;
import com.jtripled.simplefactory.item.inventory.GUIItemDuct;
import com.jtripled.simplefactory.item.tile.TileItemDuct;
import com.jtripled.voxen.block.BlockDuct;
import com.jtripled.voxen.gui.GUIBase;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;

/**
 *
 * @author jtripled
 */
public class BlockItemDuct extends BlockDuct implements GUIBase
{
    public BlockItemDuct()
    {
        super(Material.IRON, "item_duct");
        this.setCreativeTab(CreativeTabs.REDSTONE);
        this.setItem();
    }
    
    @Override
    public Class<ContainerItemDuct> getContainerClass()
    {
        return ContainerItemDuct.class;
    }
    
    @Override
    public Class<GUIItemDuct> getGUIClass()
    {
        return GUIItemDuct.class;
    }
    
    @Override
    public Class<? extends TileEntity> getTileClass()
    {
        return TileItemDuct.class;
    }

    @Override
    public boolean canConnect(IBlockState state, IBlockAccess world, BlockPos otherPos, EnumFacing otherFacing)
    {
        TileEntity tile = world.getTileEntity(otherPos);
        return tile != null && tile.hasCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, otherFacing);
    }

    @SideOnly(Side.CLIENT)
    @Override
    public boolean shouldSideBeRendered(IBlockState blockState, IBlockAccess blockAccess, BlockPos pos, EnumFacing side)
    {
        return true;
    }
}
