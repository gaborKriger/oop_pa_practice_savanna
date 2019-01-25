package Animal;

public abstract class Animal {

    protected String name;
    protected int age;
    protected int maxAge;
    protected boolean starving;
    protected int sex;
    protected boolean mature;
    protected int xCoordinate;
    protected int yCoordinate;

    public String getName() {
        return name;
    }

    public void setCoordinate(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }
}
