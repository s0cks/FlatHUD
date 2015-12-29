package flathud.client.drawables;

import cpw.mods.fml.client.FMLClientHandler;
import flathud.client.Drawable;
import flathud.client.DroidSans;
import flathud.client.RenderUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public final class RenderHUD
implements Drawable {
    private final RenderItem render = new RenderItem();

    @Override
    public void draw(float partial) {
        Minecraft mc = FMLClientHandler.instance().getClient();
        EntityPlayer player = FMLClientHandler.instance().getClient().thePlayer;

        int height = 16;
        int y = (int) (DroidSans.height() - height) / 2;
        int fill = (int) ((player.getHealth() * 100) / player.getMaxHealth());
        int width = (int) (DroidSans.getWidth(player.getDisplayName()) + player.getMaxHealth() * 5 + 16);
        int x = (int) (4 + (width / DroidSans.getWidth(player.getDisplayName())));
        RenderUtils.drawColoredQuad(0x000000, 200, 0, 0, width, height);
        DroidSans.drawString(player.getDisplayName(), x, y + 4, 0xFFFFFF);
        RenderUtils.drawColoredQuad(0xFF0000, 200, x + DroidSans.getWidth(player.getDisplayName()) + 4, y + 2, fill, 12);

        width = 24;
        height = (9 * 18) + 2;
        x = 0;
        y = 100;
        RenderUtils.drawColoredQuad(0x000000, 200, x, y + 4, width, height + 36);

        RenderHelper.enableStandardItemLighting();
        for(int i = 0; i < 9; i++){
            if(i == player.inventory.currentItem){
                RenderHelper.disableStandardItemLighting();
                RenderUtils.drawColoredQuad(0xFFFFFF, x, y + 4, width, 24);
                RenderUtils.drawColoredQuad(0x000000, x + 2, y + 6, width - 4, 20);
                RenderHelper.enableStandardItemLighting();
            }

            ItemStack stack = player.inventory.getStackInSlot(i);
            if(stack != null){
                renderInventorySlot(stack, x + 4, y + 8, partial);
            }

            y += 22;
        }
        RenderHelper.disableStandardItemLighting();
    }

    private void renderInventorySlot(ItemStack stack, int x, int y, float partial){
        if(stack != null){
            float f1 = (stack.animationsToGo - partial);
            if(f1 > 0.0F){
                GL11.glPushMatrix();
                float f2 = 1.0F + f1 / 5.0F;
                GL11.glTranslatef(x + 8, y + 8, 1.0F);
                GL11.glScalef(1.0F / f2, (f2 + 1.0F) / 2.0F, 1.0F);
                GL11.glTranslatef((float) (-(x + 8)), (float) (-(y + 8)), 1.0F);
            }

            render.renderItemAndEffectIntoGUI(FMLClientHandler.instance().getClient().fontRenderer, FMLClientHandler.instance().getClient().renderEngine, stack, x, y);

            if(f1 > 0.0F){
                GL11.glPopMatrix();
            }

            render.renderItemOverlayIntoGUI(FMLClientHandler.instance().getClient().fontRenderer, FMLClientHandler.instance().getClient().renderEngine, stack, x, y);
        }
    }
}