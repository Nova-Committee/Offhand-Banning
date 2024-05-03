package cn.evole.mods.offhandbanning;

import cn.evole.mods.offhandbanning.cmds.AddBanCmd;
import cn.evole.mods.offhandbanning.cmds.DelBanCmd;
import cn.evole.mods.offhandbanning.config.ConfigHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

@Mod(
        name = Const.MOD_NAME,
        modid = Const.MOD_ID,
        useMetadata = true
)
public class OffhandBanning {

    @Mod.EventHandler
    public static void preInit(FMLPreInitializationEvent event) {
        Const.configHandler = new ConfigHandler(event.getModConfigurationDirectory().toPath());
    }

    @Mod.EventHandler
    public static void onServerStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new AddBanCmd());
        event.registerServerCommand(new DelBanCmd());
    }
}
