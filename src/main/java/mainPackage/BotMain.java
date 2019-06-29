package mainPackage;

import com.jagrosh.jdautilities.command.CommandClient;
import com.jagrosh.jdautilities.command.CommandClientBuilder;

import commandPackage.Dice;
import commandPackage.FunGIF;
import commandPackage.ServerInfo;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;

public class BotMain {

	public static void main(String[] args) throws Exception {
		
		  JDA bot = new JDABuilder("NTg3ODI0MTA4ODU1NjIzNzEw.XQ9YFw.veOIZ0hPAJV0fZR-P-5u9pB7AkE").build();
		  CommandClientBuilder builder = new CommandClientBuilder();
		  
		  builder.setOwnerId("587824108855623710");
		  builder.setPrefix("+");
		  
		  builder.addCommand(new FunGIF());
		  builder.addCommand(new Dice());
		  builder.addCommand(new ServerInfo());
		  
		  CommandClient client = builder.build();
		  
		  bot.addEventListener(client);
//		  bot.addEventListener(new HelpListener());		// UNUSED FOR NOW
	}

}
