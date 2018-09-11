/**
 * Bibhas Abhishek
 * bibhas_01@hotmail.com
 * 11 Sep 2018
 * https://github.com/bibhas-abhishek/projects/tree/master/TruckTour
 */

public class TruckTour {

    static class PetrolPump {
        int petrol;
        int distance;

        public PetrolPump(int petrol, int distance) {
            this.petrol = petrol;
            this.distance = distance;
        }

    }

    static int printTour(PetrolPump arr[], int n) {
        int start = 0;
        int end = 1;
        int currentPetrol = arr[start].petrol - arr[start].distance;
        while (start != end || currentPetrol < 0) {
            while (start != end && currentPetrol < 0) {
                currentPetrol -= arr[start].petrol - arr[start].distance;
                start = (start + 1) % n;
                if (start == 0)
                    return -1;
            }
            currentPetrol += arr[end].petrol - arr[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] arr = {new PetrolPump(6, 4),
                new PetrolPump(3, 6),
                new PetrolPump(7, 3)};
        int start = printTour(arr, arr.length);
        System.out.println(start == -1 ? "No Solution" : "Start = " + start);
    }

}
