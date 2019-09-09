package commandPackage;

import com.jagrosh.jdautilities.command.Command;
import com.jagrosh.jdautilities.command.CommandEvent;

public class Echo extends Command{
	
	public Echo() {
		
		this.name = "echo";
		this.help = "Use bot to chat. This command isn't available for public use.";
		this.ownerCommand = true;
	}
	
	@Override
	protected void execute(CommandEvent event) {
		// TODO Auto-generated method stub
		String msg = event.getMessage().getContentRaw();
		String delcommand = "+echo";
		
		String newmsg = msg.replace(delcommand, "");
		
		event.getMessage().delete().queue();
		event.getChannel().sendMessage(newmsg).queue();
	}
}
