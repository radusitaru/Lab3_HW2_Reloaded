import java.util.Scanner;

public class Planets {

    //1.1 Enum
    public enum Planet {
        MERCURY(0.3),
        VENUS(0.9),
        MOON(0.1),
        MARS(0.3),
        JUPITER(2.5),
        SATURN(1),
        URANUS(0.8),
        NEPTUNE(1.1),
        PLUTO(0),
        IO(0.18),
        EUROPA(0.13),
        GANYMEDE(0.14),
        CALLISTO(0.12),
        SUN(27),
        WHITE_DWARF(1300000);

        //1.2 massRatio variable
        private final double massRatio;

        //1.3 Constructor
        Planet(double massRatio) {
            this.massRatio = massRatio;
        }

        //1.4 Getter for mass ratio
        public double getMassRatio() {
            return massRatio;
        }

        //1.5 Method for calculating weight on planets
        public double calculateMassOnPlanet(Planet planet, double weightOnEarth) {
            return planet.getMassRatio() * weightOnEarth;
        }

        //2. Main
        public static void main(String[] args) {

            //2.1 Inserting weight on earth
            Scanner sc = new Scanner(System.in);
            System.out.println("Insert your weight on earth (kg)");
            double weightOnEarth = sc.nextDouble();

            //2.2 Iterating weight through all planets from enum
            for (Planet p : Planet.values()) {
                System.out.println("Your weight (kg) on " + p.name() + " is " + p.calculateMassOnPlanet(p, weightOnEarth));
            }
        }
    }
}
