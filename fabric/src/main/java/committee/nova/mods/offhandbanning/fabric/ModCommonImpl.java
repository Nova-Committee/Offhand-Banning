package committee.nova.mods.offhandbanning.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

/**
 * @Project: offhandbanning
 * @Author: cnlimiter
 * @CreateTime: 2024/9/29 23:56
 * @Description:
 */
public class ModCommonImpl {
    public static Path getConfigPath() {
        return FabricLoader.getInstance().getConfigDir();
    }
}
