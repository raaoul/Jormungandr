package commandPackage;

import java.awt.Color;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

import net.dv8tion.jda.core.EmbedBuilder;

public class ServerInfo extends Command {
	
	public ServerInfo(){
      this.name = "serverinfo";
      this.aliases = new String[] {"svinfo", "sv"};
      this.help = "Gives information about the server.";
    }

	@Override
	protected void execute(CommandEvent event) {

      EmbedBuilder infoBox = new EmbedBuilder();
      infoBox.setColor(Color.WHITE);
      infoBox.setTitle(event.getGuild().getName());
      infoBox.setThumbnail(event.getGuild().getIconUrl());
      infoBox.addField("Server Region:", event.getGuild().getRegionRaw(), false);
      infoBox.addField("Member Count:", Integer.toString(event.getGuild().getMembers().toArray().length), true);
      infoBox.addField("Server Owner:", event.getGuild().getOwner().getEffectiveName(), true);
      infoBox.setDescription("\n **Invite link:** \n" + "https://discord.gg/5MTSWaW");
        
      event.getChannel().sendMessage(event.getAuthor().getAsMention()).queue();        
      event.getChannel().sendMessage(infoBox.build()).queue();
        
	}
}
