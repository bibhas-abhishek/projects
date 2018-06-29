/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 29 Jun 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/AbstractFactory
 **/

public class SamsungMobileFactory extends MobileFactory {

    Samsung createSamsungDevice() {
        return new Samsung();
    }

}
