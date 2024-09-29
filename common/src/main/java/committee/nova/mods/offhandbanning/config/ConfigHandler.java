package committee.nova.mods.offhandbanning.config;

import committee.nova.mods.offhandbanning.OffhandBanning;
import org.apache.commons.io.FileUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static committee.nova.mods.offhandbanning.OffhandBanning.GSON;

/**
 * ConfigHandler
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午8:17
 */
public class ConfigHandler {
    public final Path configFolder;
    public ModConfig config;

    public ConfigHandler(Path configFolder){
        this.configFolder = configFolder;
        this.config = load();
    }

    public ModConfig load(){
        ModConfig config = new ModConfig();
        Path configPath = configFolder.resolve(config.getConfigName() + ".json");
        try {
            if (!Files.exists(configFolder)) {
                Files.createDirectories(configFolder);
            }
            if (Files.exists(configPath)) {
                config = GSON.fromJson(FileUtils.readFileToString(configPath.toFile(), StandardCharsets.UTF_8),
                        ModConfig.class);
            } else FileUtils.write(configPath.toFile(), GSON.toJson(config), StandardCharsets.UTF_8);

        } catch (IOException e) {
            OffhandBanning.LOGGER.error("Couldn't load: {}", configPath, e);
        }
        return config;
    }

    public void save() {
        Path configPath = configFolder.resolve(config.getConfigName() + ".json");
        try {
            if (!Files.exists(configPath)){
                Files.createDirectories(configFolder);
            }
            FileUtils.write(configPath.toFile(), GSON.toJson(config), StandardCharsets.UTF_8);
        } catch (IOException e) {
            OffhandBanning.LOGGER.error("Couldn't save: {}", configFolder, e);
        }

    }

}
