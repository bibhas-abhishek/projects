/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 30 Jun 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/Decorator
 **/

public class LuxuryCar extends CarDecorator {

    public LuxuryCar(Car car) {
        super(car);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.print("Adding features of Luxury Car\n");
    }

}
