package committee.nova.mods.offhandbanning.config;

import com.google.common.collect.Sets;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.Set;

/**
 * ModConfig
 *
 * @author cnlimiter
 * @version 1.0
 * @description
 * @date 2024/5/3 下午8:16
 */
public class ModConfig {
    @SerializedName("offhand_banning_items")
    private Set<String> items = Sets.newHashSet("minecraft:stone", "minecraft:stick");

    public Set<String> getItems() {
        return items;
    }

    public void addBanItems(String item){
        this.items.add(item);
    }

    public void removeBanItems(String item){
        this.items.remove(item);
    }

    public String getConfigName() {
        return "offhandbanning";
    }
}
