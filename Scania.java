import java.awt.*;
import java.util.Objects;

public class Scania extends Truck implements MovablePlatform  {


    private PlatState platState;
    private final Platform platform = new Platform();

    public double getAngle(){

        return platform.getAngle();
    }
    public Scania(double x, double y) {
        super(3, 150, Color.white, "Scania",x,y);

        isMoving();
        this.platState = new DownState();

    }

    @Override
    public void Raise(double amount){
        if(isMoving()){
            System.out.println("cannot move platform if truck is moving");

            return;
        }

        platform.Raise(amount);
        System.out.println("angle is " + getAngle());

    }




    @Override
    public void lower( double amount){
        if(isMoving()){
            System.out.println("cannot move platform if truck is moving");

            return;
        }


        platform.lower(amount);
        System.out.println("Angle is " + getAngle());

    }

    @Override
    public double getMaxAngle() {
        return 70;
    }

    @Override
    public void Platformcheck() {



    }

    @Override
    public double getMinAngle() {
        return 0;
    }

    public void isPlatformraised(){
        if (platform.getAngle() > 0 && getCurrentSpeed() > 0){

            System.out.println("Cannot drive with the platform raised!!");
            return;
        }
    }

    @Override
    public double speedFactor() {
        return  getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void gas(double amount){

        if(platform.getState() instanceof DownState){

            super.gas(amount);
        }


    }
    ;


}