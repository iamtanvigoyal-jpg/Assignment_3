public class MacroCommand extends Command {
    private Command[] commands;

    public MacroCommand(Scene s, Command... commands) {
        super(null, s, 0);
        this.commands = commands;
    }

    public void execute() {
        for (int i = 0; i < commands.length; i++) {
            commands[i].execute();
        }
    }

    public void undo() {
        for (int i = commands.length - 1; i >= 0; i--) {
            commands[i].undo();
        }
    }

    @Override
    public void setDistance(int d) {
    }

    @Override
    public Command clone() {
        MacroCommand copy = (MacroCommand) super.clone();
        copy.commands = new Command[commands.length];
        for (int i = 0; i < commands.length; i++) {
            copy.commands[i] = commands[i].clone();
        }
        return copy;
    }
}