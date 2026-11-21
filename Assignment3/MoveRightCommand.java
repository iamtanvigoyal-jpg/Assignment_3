import shapes.Person;

public class MoveRightCommand extends Command {
    public MoveRightCommand(Person p, Scene s) { 
        super(p, s, 10);                      
    }

    public void execute() {
        player.moveHorizontal(distance);
    }

    public void undo() {
        player.moveHorizontal(-distance);
    }
}