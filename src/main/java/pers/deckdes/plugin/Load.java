package pers.deckdes.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public final class Load extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("自动保存插件已启用！");

        BukkitTask Auto = new AutoSave(this).runTaskTimer(this,0,getConfig().getInt("time(second)")*20);


    }

    @Override
    public void onDisable() {
        getLogger().info("自动保存插件已禁用！");


    }
}