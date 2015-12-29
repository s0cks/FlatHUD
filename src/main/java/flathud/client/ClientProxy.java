package flathud.client;

import flathud.client.handler.FlatHUDRenderer;
import flathud.common.CommonProxy;
import net.minecraftforge.common.MinecraftForge;

public final class ClientProxy
extends CommonProxy {
    @Override
    public void registerHandlers() {
        MinecraftForge.EVENT_BUS.register(new FlatHUDRenderer());
    }
}