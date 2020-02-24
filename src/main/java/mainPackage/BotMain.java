package mainPackage;

import java.util.List;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import commandPackage.Dice;
import commandPackage.Echo;
import commandPackage.GIFHelp;
import commandPackage.GIFMain;
import commandPackage.ServerInfo;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Guild;

public class BotMain {

	public static void main(String[] args) throws Exception {
		
		JDA bot = new JDABuilder("bot-login-token").build();
		CommandClientBuilder builder = new CommandClientBuilder();
		  	  
		builder.setOwnerId("280286374337314816");
		builder.setPrefix("+");
		  
		builder.addCommand(new GIFHelp());
		builder.addCommand(new Dice());
		builder.addCommand(new ServerInfo());
		builder.addCommand(new Echo());
		  
		CommandClient client = builder.build();
		  
		bot.addEventListener(client);
		bot.addEventListener(new GIFMain());		// EventListener for GIFMain
//		bot.addEventListener(new HelpListener());		// UNUSED FOR NOW
		  
		List<Guild> guild = bot.getGuilds();
		
		System.out.println("Server I'm in");
		for(int i = 0; i < guild.size(); i++)
			System.out.println("GuildName: " + guild.get(i).getName() + " GuildId: " + guild.get(i).getId());
	}
}
