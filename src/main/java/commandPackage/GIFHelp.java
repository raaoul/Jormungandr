package commandPackage;

import java.awt.Color;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.EmbedBuilder;

public class GIFHelp extends Command {
	
	public GIFHelp() {
		
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
		GIFList.addField("UNLIMITED POWER!", "+power", true);
		GIFList.addField(":(", "+sad", true);		
				
		event.getChannel().sendMessage(GIFList.build()).queue();
	}
}
	
