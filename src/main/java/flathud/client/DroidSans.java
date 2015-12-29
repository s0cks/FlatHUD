package flathud.client;

import net.minecraft.util.ResourceLocation;
import truetyper.FontHelper;
import truetyper.FontLoader;
import truetyper.TrueTypeFont;

public final class DroidSans{
    private static final ResourceLocation font = new ResourceLocation("flathud", "font/DroidSans.ttf");
    private static final TrueTypeFont droidSans = FontLoader.createFont(font, 12, true);

    public static float height(){
        return droidSans.getHeight();
    }

    public static float getWidth(String str){
        return droidSans.getWidth(str);
    }

    public static void drawString(String str, int x, int y){
        FontHelper.drawString(str, x, y, droidSans, 1.0F, 1.0F);
    }

    public static void drawString(String str, int x, int y, float scale){
        FontHelper.drawString(str, x, y, droidSans, scale, scale);
    }

    public static void drawString(String str, int x, int y, int color, float scale){
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);
        FontHelper.drawString(str, x, y, droidSans, scale, scale, new float[]{r / 255, g / 255, b / 255});
    }

    public static void drawString(String str, int x, int y, int color){
        int r = (color >> 16 & 0xFF);
        int g = (color >> 8 & 0xFF);
        int b = (color & 0xFF);
        FontHelper.drawString(str, x, y, droidSans, 1.0F, 1.0F, new float[]{r / 255, g / 255, b / 255, 1.0F});
    }
}