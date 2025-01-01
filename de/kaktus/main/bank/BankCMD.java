package de.kaktus.main.bank;

import de.kaktus.main.Main;
import de.kaktus.main.util.Construct;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BankCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender s, Command cmd, String label, String[] args) {
        if (!(s instanceof Player)){
            return true;
        }
        Player p = (Player)s;
        Construct construct = new Construct();
        construct.openCustomInventory(p);
        return false;
    }
}
