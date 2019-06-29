package commandPackage;

import java.awt.Color;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;

public class FunGIF extends Command {
	
	public FunGIF() {
		
		this.name = "gifs";
		this.aliases = new String[] {"gif", "giflist"};
		this.help = "List of available fun GIFs!";
	}
	
	protected void execute(CommandEvent event) {
		EmbedBuilder GIFList = new EmbedBuilder();
		GIFList.setColor(Color.WHITE);
		
//		don't forget to add new field after you add new GIF under this if scope.
		GIFList.setTitle("Here's the list of available GIF.");
		GIFList.addField("Hello there", "+hello", true);
		GIFList.addField("I'm Pickle Rick!", "+picklerick", true);
		GIFList.addField("That's a penis!", "+penis", true);		
				
		event.getChannel().sendMessage(GIFList.build()).queue();
	}

	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		
		String msg = event.getMessage().getContentRaw();
		EmbedBuilder GIF = new EmbedBuilder();
		GIF.setColor(Color.WHITE);
		
		/*				=== GIF URLs NOTES ===
		 * 
		 *  USE RAW URLs INSIDE ".SetImage()" PARAMS!
		 *  IF IT'S FROM GIPHY MAKE SURE THE URL IS FROM "media.giphy.com"!
		 *   > SEE "+hello" FOR EXAMPLE!
		 */
		
		if (msg.equalsIgnoreCase("+hello")) {
			
			//	https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif
			GIF.setTitle("Hello There!");
			GIF.setImage("https://media.giphy.com/media/Nx0rz3jtxtEre/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+picklerick")) {
			
			//	https://media1.giphy.com/media/9zXWAIcr6jycE/giphy.gif
			GIF.setTitle("I'm Pickle Rick!");
			GIF.setImage("https://media1.giphy.com/media/9zXWAIcr6jycE/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
			
		} else if (msg.equalsIgnoreCase("+penis")) {
			
			//	https://media.giphy.com/media/EzVPnZABeepdC/giphy.gif
			GIF.setTitle("That's a penis!");
			GIF.setImage("https://media.giphy.com/media/EzVPnZABeepdC/giphy.gif");
			event.getChannel().sendMessage(GIF.build()).queue();
		}
	}
}
	
