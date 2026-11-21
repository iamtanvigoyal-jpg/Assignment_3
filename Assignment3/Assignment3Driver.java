import shapes.*;                                
import java.util.Scanner;

public class Assignment3Driver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Scene game = new Scene();
        Person player = game.getPlayer();
        player.changeColor(Configuration.getInstance().getPlayerColor());

        PlayerController controller = new PlayerController();

        Command up = new MoveUpCommand(player, game);
        Command down = new MoveDownCommand(player, game);
        Command left = new MoveLeftCommand(player, game);
        Command right = new MoveRightCommand(player, game);

        controller.setCommand('w', up);
        controller.setCommand('s', down);
        controller.setCommand('a', left);
        controller.setCommand('d', right);
        controller.setCommand('W', up);
        controller.setCommand('S', down);
        controller.setCommand('A', left);
        controller.setCommand('D', right);

        Command macroLeft1 = new MoveLeftCommand(player, game);
        macroLeft1.setDistance(20);
        Command macroUp = new MoveUpCommand(player, game);
        Command macroLeft2 = new MoveLeftCommand(player, game);
        macroLeft2.setDistance(20);
        controller.setCommand('h', new MacroCommand(game, macroLeft1, macroUp, macroLeft2));

       
        while (!game.isHomeReached()) {
            System.out.print("Enter key: ");
            char key = scanner.next().charAt(0);
            if (key == 'q') break;
            controller.keyWasPressed(key);
        }

        game.getEnemy().stop();
        System.exit(0);
    }
}