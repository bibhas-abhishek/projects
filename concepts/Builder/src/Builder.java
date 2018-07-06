public class Builder {

    public static void main(String[] args) {
        System.out.println(new Cake.CakeBuilder().addButter(10).addSugar(20).addMilk(25).addCherries(5).build());
    }

}
