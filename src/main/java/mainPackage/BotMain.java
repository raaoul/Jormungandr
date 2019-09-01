package mainPackage;

import java.util.List;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import commandPackage.Dice;
import commandPackage.GIFHelp;
import commandPackage.GIFMain;
import commandPackage.ServerInfo;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;

public class BotMain {

	public static void main(String[] args) throws Exception {
		
		  JDA bot = new JDABuilder("NTg3ODI0MTA4ODU1NjIzNzEw.XQ9YFw.veOIZ0hPAJV0fZR-P-5u9pB7AkE").build();
		  CommandClientBuilder builder = new CommandClientBuilder();
		  
		  
		  
		  builder.setOwnerId("587824108855623710");
		  builder.setPrefix("+");
		  
		  builder.addCommand(new GIFHelp());
		  builder.addCommand(new Dice());
		  builder.addCommand(new ServerInfo());
		  
		  CommandClient client = builder.build();
		  
		  bot.addEventListener(client);
		  bot.addEventListener(new GIFMain());		// EventListener for GIFMain
		  
		  List<Guild> guild = bot.getGuilds();
		  System.out.println("Server I'm in");
		  for(int i = 0; i < guild.size(); i++) {
			  System.out.println("GuildName: " + guild.get(i).getName() + " GuildId: " + guild.get(i).getId());
		  }
		  
//		  bot.addEventListener(new HelpListener());		// UNUSED FOR NOW
	}

}
