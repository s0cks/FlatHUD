package flathud.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import flathud.client.Drawable;
import flathud.client.drawables.RenderHUD;
import net.minecraftforge.client.event.RenderGameOverlayEvent;

public final class FlatHUDRenderer {
    private final Drawable renderHUD = new RenderHUD();

    @SubscribeEvent
    public void onRenderGameOverlay(RenderGameOverlayEvent e){
        switch(e.type){
            case HOTBAR:
            case EXPERIENCE:
            case HEALTH:
            case CHAT:
            case FOOD: {
                e.setCanceled(true);
            }
        }

        if(e.type != RenderGameOverlayEvent.ElementType.DEBUG){
            this.renderHUD.draw(e.partialTicks);
        }
    }
}