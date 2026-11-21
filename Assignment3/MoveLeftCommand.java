import shapes.Person;

public class MoveLeftCommand extends Command {
    public MoveLeftCommand(Person p, Scene s) { 
        super(p, s, 10);                        
    }

    public void execute() {
        player.moveHorizontal(-distance);
    }

    public void undo() {
        player.moveHorizontal(distance);
    }
}