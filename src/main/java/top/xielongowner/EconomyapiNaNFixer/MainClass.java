package top.xielongowner.EconomyapiNaNFixer;

import cn.nukkit.Player;
import cn.nukkit.event.EventHandler;
import cn.nukkit.event.Listener;
import cn.nukkit.event.player.PlayerCommandPreprocessEvent;
import cn.nukkit.plugin.PluginBase;

public class MainClass extends PluginBase implements Listener {
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onPlayerCommandPreprocess(PlayerCommandPreprocessEvent event) {
        Player player = event.getPlayer();
        String command = event.getMessage();
        if (command.startsWith("/pay") || command.startsWith("/setmoney") || command.startsWith("/givemoney") || command.startsWith("/takemoney")) {
            if (command.contains("NaN")) {
                command = command.replace("NaN", "0");
                event.setMessage(command);
                player.sendMessage("You entered an illegal value when running this command.");
            }
        }
    }
}
