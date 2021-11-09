package io.github.darkenedfusion;


import org.bukkit.plugin.java.JavaPlugin;

import io.github.darkenedfusion.Bosses.Young.CommonLootBox;
import io.github.darkenedfusion.Bosses.Young.InsaneLootBox;
import io.github.darkenedfusion.Bosses.Young.MythicLootBox;
import io.github.darkenedfusion.Bosses.Young.RareLootBox;
import io.github.darkenedfusion.Bosses.Young.YoungMoveSet;
import io.github.darkenedfusion.Commands.GrantCommand;
import io.github.darkenedfusion.Commands.ItemTab;
import io.github.darkenedfusion.Weapons.ItemListener;
import io.github.darkenedfusion.Weapons.CustomBowDamage.CustomBowDamage;

public class AbilityJam extends JavaPlugin  {
	
	private static AbilityJam instance;
	
	@Override
	public void onEnable() {
	instance = this;
	this.getCommand("grant").setExecutor(new GrantCommand());
	this.getCommand("grant").setTabCompleter(new ItemTab());
	
	this.getServer().getPluginManager().registerEvents(new CustomBowDamage(), this);
	this.getServer().getPluginManager().registerEvents(new YoungMoveSet(), this);
	this.getServer().getPluginManager().registerEvents(new CommonLootBox(), this);
//	this.getServer().getPluginManager().registerEvents(new RareLootBox(), this);
//	this.getServer().getPluginManager().registerEvents(new InsaneLootBox(), this);
//	this.getServer().getPluginManager().registerEvents(new MythicLootBox(), this);
//	this.getServer().getPluginManager().registerEvents(new ItemListener(), this);
	}
	
	@Override
	public void onDisable() {
		
	}

	public static AbilityJam getInstance() {
		return instance;
	}
	

}
