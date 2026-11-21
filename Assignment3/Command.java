import shapes.Person;

public abstract class Command implements Cloneable {
    protected Person player;
    protected Scene scene;                      
    protected int distance;

    public Command(Person p, Scene s, int d) {   
        player = p;
        scene = s;
        distance = d;
    }

    public abstract void execute();

    public abstract void undo();

    public void setDistance(int d) {
        distance = d;
    }

    @Override
    public Command clone() {
        try {
            return (Command) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }

    public final void executeWithLog() {
        logCommand();
        execute();
        checkIfHome();                           
    }

    public final void undoWithLog() {
        Logger.getInstance().log(getClass().getName() + " [undo]");
        undo();
        checkIfHome();                          
    }

    protected void logCommand() {
        Logger.getInstance().log(getClass().getName());
    }

    protected void checkIfHome() {
        if (scene != null) {
            scene.checkIfHome();
        }
    }
}