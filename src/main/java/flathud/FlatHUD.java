package flathud;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.IGuiHandler;
import flathud.common.CommonProxy;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

@Mod(modid = "flathud", name = "FlatHUD", version = "1.0.0.0", useMetadata = true)
public final class FlatHUD
implements IGuiHandler{
    @Mod.Instance("flathud")
    public static FlatHUD instance;

    @SidedProxy(clientSide = "flathud.client.ClientProxy", serverSide = "flathud.common.CommonProxy")
    public static CommonProxy proxy;

    public static int GUI_MAIN_MENU = 0x00;
    public static int GUI_PAUSE_MENU = 0x01;

    @Mod.EventHandler
    public void onPreInit(FMLPreInitializationEvent e){
        proxy.registerRenders();
        proxy.registerHandlers();
    }

    @Mod.EventHandler
    public void onInit(FMLInitializationEvent e){

    }

    @Mod.EventHandler
    public void onPostInit(FMLPostInitializationEvent e){

    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent e){

    }

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return null;
    }
}