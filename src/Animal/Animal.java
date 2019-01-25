package Animal;

public abstract class Animal {

    protected String name;
    protected int age;
    protected int maxAge;
    protected int starving;
    protected int sex;
    protected boolean mature;
    protected int xCoordinate;
    protected int yCoordinate;
    protected boolean alive;

    public String getName() {
        return name;
    }

    public void setCoordinate(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getStarving() {
        return starving;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void increaseStarving() {
        this.starving ++;
    }

    public int getSex() {
        return sex;
    }

    public boolean isMature() {
        return mature;
    }

    public void setAge() {
        this.age++;
        if (age > 365) {
            this.mature = true;
        }
    }
}
