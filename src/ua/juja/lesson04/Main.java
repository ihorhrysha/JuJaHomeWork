package ua.juja.lesson04;

//import java.util.PriorityQueue;
//import java.util.Queue;

/**
 * Created by Ігор on 14.10.2014.
 */
public class Main {
    public static void main(String[] args) {

        String testLinerName = "TestLinerName";
        float testLinerLength = 1000;
        float testLinerWidth = 1000;
        float testLinerDisplacement = 1000;
        int testLinerPassengers = 100;
        String testCargoName = "TestCargoName";
        float testCargoLength = 1000;
        float testCargoWidth = 1000;
        float testCargoDisplacement = 1000;
        float testCargoTonnage = 100;
        String testTankerName = "TestTankerName";
        float testTankerLength = 1000;
        float testTankerWidth = 1000;
        float testTankerDisplacement = 1000;
        float testTankerVolume = 100;

        int expectedStatusAddShipIntoQueueFull = -1;

        AbstractShip testLiner = new Liner(testLinerName, testLinerLength, testLinerWidth, testLinerDisplacement, testLinerPassengers);
        //AbstractShip testCargo = new Cargo(testCargoName, testCargoLength, testCargoWidth, testCargoDisplacement, testCargoTonnage);
        AbstractShip testTanker = new Tanker(testTankerName, testTankerLength, testTankerWidth, testTankerDisplacement, testTankerVolume);

        OdessaSeaPort odessaSeaPort = new OdessaSeaPort();


        System.out.println(odessaSeaPort.addShipToEndQueue(testLiner));
        //System.out.println(odessaSeaPort.addShipToEndQueue(testCargo));
        System.out.println(odessaSeaPort.addShipToEndQueue(testTanker));

        System.out.println(odessaSeaPort.addShipToEndQueue(testTanker));

    }
}
class Liner extends AbstractShip {

    private int passengers;
    public static final float DEFAULT_RENTAL = 1000;

    public Liner(String name, float length, float width, float displacement, int passengers) {
        super(name, length, width, displacement);
        this.passengers = passengers;
    }

    @Override
    public float calculatePayment() {
        return passengers * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return passengers * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Tanker extends AbstractShip {
    private float volume;
    public static final float DEFAULT_RENTAL = 250;

    public Tanker(String name, float length, float width, float displacement, float volume) {
        super(name, length, width, displacement);
        this.volume = volume;
    }

    @Override
    public float calculatePayment() {
        return volume * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return volume * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

class Cargo extends AbstractShip {
    private float tonnage;
    public static final float DEFAULT_RENTAL=550;

    public Cargo(String name, float length, float width, float displacement, float tonnage) {
        super(name, length, width, displacement);
        this.tonnage = tonnage;
    }

    @Override
    public float calculatePayment() {
        return tonnage * DEFAULT_RENTAL;
    }

    public float calculatePayment(float rentTax) {
        if (rentTax > 0) {
            return tonnage * rentTax;
        } else {
            return calculatePayment();
        }
    }
}

abstract class AbstractShip {
    private String name;
    private float length;
    private float width;
    private float displacement;

    public AbstractShip(String name, float length, float width, float displacement) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.displacement = displacement;
    }

    public abstract float calculatePayment();

    public String toPrint() {
        return "Name=" + name +
                "Length=" + length +
                "Width=" + width +
                "Displacement=" + displacement;
    }

    public String getName() {
        return name;
    }
}
interface SeaPortQueue {
    public final static int LENGTH_QUEUE_SHIP = 3;
    public int addShipToEndQueue(AbstractShip ship);
    public int removeShipFromBeginQueue();
    public String printQueueShip();
}

class OdessaSeaPort implements SeaPortQueue {
    private static final int NO_SHIP_IN_ARRAY = -1;
    //private int indexShipInPort = NO_SHIP_IN_ARRAY;
    //private AbstractShip[] arrayShip = new AbstractShip[LENGTH_QUEUE_SHIP];

    private java.util.Queue<AbstractShip> portQueue = new java.util.LinkedList<AbstractShip>();

    @Override
    public int addShipToEndQueue(AbstractShip ship) {
        if (portQueue.size()>=LENGTH_QUEUE_SHIP) return -1;

        portQueue.add(ship);
        return portQueue.size() - 1;
    }

    @Override
    public int removeShipFromBeginQueue() {
        if (portQueue.size()==0)
            return NO_SHIP_IN_ARRAY;

        portQueue.remove();
        return 1;
    }

    @Override
    public String printQueueShip() {
        if (portQueue.size()==0)
            return "QueueEmpty";

        String returnString="";

        for (AbstractShip Ship : portQueue){
            returnString+="{"+Ship.toPrint()+"};";
        }
        return returnString;

    }

    public static String sortSumPaymentAsc(AbstractShip[] arrayShips) {

        if (arrayShips == null) return "";

        boolean swapped = true;
        while (swapped){
            swapped = false;
            for (int i = 0; i < arrayShips.length - 1; i++) {
                if (arrayShips[i].calculatePayment() > arrayShips[i + 1].calculatePayment()) {
                    AbstractShip a = arrayShips[i];
                    arrayShips[i] = arrayShips[i + 1];
                    arrayShips[i + 1] = a;
                    swapped = true;
                }
            }
        }

        String returnString="";

        for (AbstractShip ship : arrayShips){
            returnString+=ship.getName()+"="+ship.calculatePayment();
        }

        return returnString;
    }
}