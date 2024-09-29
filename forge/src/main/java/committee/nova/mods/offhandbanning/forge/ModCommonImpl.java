package committee.nova.mods.offhandbanning.forge;

import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

/**
 * @Project: offhandbanning
 * @Author: cnlimiter
 * @CreateTime: 2024/9/29 23:56
 * @Description:
 */
public class ModCommonImpl {
    public static Path getConfigPath() {
        return FMLPaths.CONFIGDIR.get();
    }
}
