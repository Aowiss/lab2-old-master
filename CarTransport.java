import java.awt.*;
import java.util.ArrayDeque;
import java.util.Objects;

public class CarTransport extends Truck implements MovablePlatform {


    private PlatState platState;





    private final int maxCars = 5;



    public int GetCargosize(){
        return cargo.size();
    }
    private ArrayDeque<Vehicle> cargo = new ArrayDeque<>();
    private final Platform platform;
    public CarTransport(double x, double y){

        super(2, 300, Color.black, "CarTransport",0,0);
        canTransportmove();
        platform = new Platform();


    }

    @Override
    public double speedFactor() {
        return  getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void move() {
        super.move();
        stayWithTransport();
    }



    public void stayWithTransport(){


        for (Vehicle cars : cargo) {
            cars.SetX(this.GetX());
            cars.SetY(this.GetY());

            }




    }

    public void canTransportmove(){


        if (Objects.equals(platform.getState(), new DownState()) && isMoving()); {
            System.out.println("Can't move with ramp down");

            return;

        }
    }

    boolean canLoad(Vehicle car){

        boolean loadable = false;
        if( (Objects.equals(platform.getState(), new DownState())) && cargo.size() < maxCars && withinRadius(car)) {
            loadable = true;
        }

        return loadable;
    }
    public void loadCar(Vehicle car){
        if(canLoad(car)){

            cargo.add(car);

        }
        stayWithTransport();



    }
    public Vehicle deLoadCar(Vehicle car) {

        if (!cargo.isEmpty() && canLoad(car)) {

            Vehicle unloadedcar = cargo.remove();

            System.out.println(unloadedcar + " has been unloaded");

            return unloadedcar;

        } else return null;

    }


    @Override
    public void Raise(double amount) {

        if (isMoving()) {

            System.out.println("Cannot move platform if truck is moving!!");

            return;

        }
        platform.Raise(70);
    }




    @Override
    public void lower(double amount) {

    }

    @Override
    public double getMaxAngle() {
        return 0;
    }

    @Override
    public void Platformcheck() {

    }

    @Override
    public double getMinAngle() {
        return 0;
    }


    public void raise(Platform platform) {
        platform.setAngle(getMaxAngle());
        platState = new UpState();
    }


    public void lower(Platform platform) {
        platform.setAngle(getMinAngle());
        platState = new DownState();


    }
}

