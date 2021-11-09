package io.github.darkenedfusion.Commands;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class ItemTab implements TabCompleter {
	
	//Creates a list for all arguments (item command names)
		List<String> arguments = new ArrayList<String>();
		
		//Constructor
		@Override
		public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args){
				if(label.equals("grant")) {
			
			//If the list is empty add in these arguments globally
			if(arguments.isEmpty()) {
				arguments.add("COMMON_LOOT_BOX"); 
				arguments.add("RARE_LOOT_BOX"); 
				arguments.add("INSANE_LOOT_BOX");
				arguments.add("MYTHIC_LOOT_BOX");
				arguments.add("BLUE_CORE");
				arguments.add("UNDEAD_SOCKET");
				arguments.add("WATER_RUNE");
				arguments.add("BABY_TEAR");
				arguments.add("TOY_GUN");
				arguments.add("YOUNG_BOSS");
				arguments.add("TOY_TRAIN");
				
			} else {
				return arguments;
			}
			
			//Allows the tab complete to detect the letters you type and filters what you see depending on what you type.
			List<String> result = new ArrayList<String>();
			if(args.length == 0) {
				for(String a : arguments) {
					if(a.toUpperCase().startsWith(args[0].toUpperCase())) {
						result.add(a);
					}
					return result;
				}
			}
			}	
			return arguments;
			
		}
	

}
