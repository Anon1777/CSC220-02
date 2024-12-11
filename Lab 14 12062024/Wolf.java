import java.util.Random;
import java.awt.Color;
public class Wolf {
    private int x,y,size;
    private Color color;
    private World world;
    public Random random = new Random();
    public Wolf(int x, int y, int size, Color color, World world){
        this.x=random.nextInt(x);
        this.y=random.nextInt(y);
        size = 1;
        color = new Color(
            random.nextInt(256), 
            random.nextInt(256), 
            random.nextInt(256)
        );
        this.world = world;
    }
    public void setX(int x){
        this.x=x;
    }
    public int getX(){
        return x;
    }
    public void setY(int y){
        this.y=y;
    }
    public int getY(){
        return y;
    }
    public void walk(){
        int dx = random.nextInt(-1, 1);
        int dy = random.nextInt(-1, 1);
        this.setX(this.getX() + dx);
        this.setY(this.getY() + dy);
        if(this.getX())>world.getNcols()){
            this.setX(0);
        }else if(this.getX()<0){
            this.setX(world.getNcols());
        }
        if(this.getY()>world.getNrows()){
            this.setY(0);
        }else if(this.getY()<0){
            this.setX(world.getNrows());
        }
    }
    public void draw(){
        StdDraw.setPenColor(color);
        StdDraw.filledSquare((double)(this.getX()), (double)(this.getY()), (double)(size));
    }
}
