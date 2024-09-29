package committee.nova.mods.offhandbanning;

import dev.architectury.injectables.annotations.ExpectPlatform;

import java.nio.file.Path;

/**
 * @Project: MoreLeads
 * @Author: cnlimiter
 * @CreateTime: 2024/9/29 02:37
 * @Description:
 */
public class ModCommon {
    @ExpectPlatform
    public static Path getConfigPath() {
        throw new IllegalStateException();
    }
}
