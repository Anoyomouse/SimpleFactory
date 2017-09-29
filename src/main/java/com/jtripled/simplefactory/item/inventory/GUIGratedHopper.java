package com.jtripled.simplefactory.item.inventory;

import com.jtripled.simplefactory.SimpleFactory;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

/**
 *
 * @author jtripled
 */
public class GUIGratedHopper extends GuiContainer
{
    protected final ContainerGratedHopper container;
    protected final String name;
    protected final ResourceLocation texture;

    public GUIGratedHopper(ContainerGratedHopper container)
    {
        super(container);
        this.container = container;
        this.name = SimpleFactory.PROXY.localize(container.tile.getBlockType().getUnlocalizedName() + ".name");
        this.texture = new ResourceLocation(SimpleFactory.ID, "textures/gui/grated_hopper.png");
        this.ySize = 159;
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        fontRenderer.drawString("Inventory", 8, ySize - 93, 0x404040);
        fontRenderer.drawString(name, 8, 6, 0x404040);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float ticks, int mouseX, int mouseY)
    {
        drawDefaultBackground();
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        mc.getTextureManager().bindTexture(texture);
        int x = (width - xSize) / 2;
        int y = (height - ySize) / 2;
        drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
    }
    
    public ContainerGratedHopper getContainer()
    {
        return container;
    }
}