package pers.deckdes.plugin;

import org.bukkit.scheduler.BukkitRunnable;
import static org.bukkit.Bukkit.getServer;

@SuppressWarnings("all")

public class AutoSave extends BukkitRunnable {
    Load plugins;
    public AutoSave(Load plugins) {
        this.plugins = plugins;
    }
    private static int order(int i) {
        i = i + 1;
        return i;
        //序号+1
        //order+1
    }
    private int i = 0;
    @Override
    public void run () {
        if (plugins.getConfig().getBoolean("command-switch")) {
            if (i < plugins.getConfig().getStringList("command-list").size()) {
                //如果i小于列表中的行数就执行下面的命令
                //if i<the lines of list,run the code.
                plugins.getServer().broadcastMessage(plugins.getConfig().getStringList("String-List1").get(i));
                plugins.getServer().dispatchCommand(getServer().getConsoleSender(),plugins.getConfig().getStringList("command-list").get(i));
                plugins.getServer().broadcastMessage(plugins.getConfig().getStringList("String-List2").get(i));
                i = order(i);
            }else {
                i = 0;
                plugins.getServer().broadcastMessage(plugins.getConfig().getStringList("String-List1").get(i));
                plugins.getServer().dispatchCommand(getServer().getConsoleSender(),plugins.getConfig().getStringList("command-list").get(i));
                plugins.getServer().broadcastMessage(plugins.getConfig().getStringList("String-List2").get(i));
                i = order(i);

            }
        }

    }
}
