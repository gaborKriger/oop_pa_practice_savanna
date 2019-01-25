import Savanna.Savanna;

class App {

    public static void main(String[] args) {

        Savanna savanna = new Savanna();
        savanna.addField(10,10);


        int years = 2;

        for (int i = 0; i < years * 365; i++) {
            savanna.life();
            System.out.println(savanna.getDay());
        }

    }
}