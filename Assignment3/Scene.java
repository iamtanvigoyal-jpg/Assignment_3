import shapes.*;

/**
 * ACS-3913 Assignment 3
 *
 * Creates the game scene with access to the house, player and enemy
 */
public class Scene {
    private Square house;
    private Circle sun;
    private Triangle roof;
    private Person player;
    private Enemy enemy;

    public Scene() {
        // house
        house = new Square();
        house.changeColor("blue");
        house.moveHorizontal(-130);
        house.moveVertical(80);
        house.makeVisible();

        // roof 
        roof = new Triangle();
        roof.makeVisible();

        // sun 
        sun = new Circle();
        sun.changeColor("yellow");
        sun.moveVertical(-80);
        sun.makeVisible();

        // player
        player = new TrackedPlayer();
        player.changeSize(40, 20);
        player.moveVertical(-100);
        player.moveHorizontal(100);
        player.makeVisible();

        // enemy
        Person badGuy = new Person();
        badGuy.changeColor("red");
        badGuy.moveHorizontal(60);
        badGuy.moveVertical(-80);
        badGuy.makeVisible();
        enemy = new Enemy(badGuy);
        enemy.start();
    }

    // A small, provided win condition. No changes to the original shapes package.
    // The player's feet must enter the house square (x=180..240, y=200..260).
    private boolean homeReached;

    public boolean hasReachedHouse() {
        TrackedPlayer p = (TrackedPlayer) player;
        int feetX = p.x + 10; // half of the player's configured width (20)
        int feetY = p.y + 40; // player's configured height (40)
        return feetX >= 180 && feetX <= 240 && feetY >= 200 && feetY <= 260;
    }

    public void checkIfHome() {
        if (!homeReached && hasReachedHouse()) {
            homeReached = true;
            System.out.println("You made it home!");
        }
    }

    public boolean isHomeReached() {
        return homeReached;
    }

    // Track player position without changing the original Shapes classes.
    private static class TrackedPlayer extends Person {
        private int x = 280; // original Person defaults
        private int y = 190;

        @Override
        public void moveHorizontal(int distance) {
            super.moveHorizontal(distance);
            x += distance;
        }

        @Override
        public void moveVertical(int distance) {
            super.moveVertical(distance);
            y += distance;
        }
    }

    /**
     * getters
     */ 
    public Person getPlayer() {
        return player;
    }

    public Square getHouse() {
        return house;
    }

    public Enemy getEnemy() {
        return enemy;
    }
}
