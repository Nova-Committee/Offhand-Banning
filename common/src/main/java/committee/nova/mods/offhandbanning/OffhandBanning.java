package committee.nova.mods.offhandbanning;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import committee.nova.mods.offhandbanning.config.ConfigHandler;
import net.minecraft.resources.ResourceLocation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class OffhandBanning {
    public static final String MOD_ID = "offhandbanning";
    public static final Logger LOGGER = LogManager.getLogger();
    public static Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();
    public static ConfigHandler configHandler;
    public static ResourceLocation rl(String name){
        return new ResourceLocation(MOD_ID, name);
    }
    public static void init() {
        configHandler = new ConfigHandler(ModCommon.getConfigPath());
    }
}
