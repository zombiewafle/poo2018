import java.util.Scanner;

public class Main {
    public static String getMenu(boolean isTurnedOn) {
        if (!isTurnedOn) {
            return "Menu:\n" +
                    "\t1. Encender\n" +
                    "\t2. Salir\n";
        }

        return "Menu:\n" +
                "\t1. Apagar\n" +
                "\t2. Subir volumen\n" +
                "\t3. Bajar volumen\n" +
                "\t4. Subir estacion\n" +
                "\t5. Bajar estacion\n" +
                "\t6. Cambiar frecuencia\n" +
                "\t7. Salir\n";
    }

    public static void main (String[] args) {
        boolean wantsToContinue = true;
        Radio myRadio = new Radio();

        do {
            // Mostrar el estado del radio
            System.out.println(myRadio);

            // Mostrar menu
            System.out.println(getMenu(myRadio.isTurnedOn()));

            // Leer del teclado
            System.out.print("Ingrese una opcion: ");
            Scanner input = new Scanner(System.in);
            int option = input.nextInt();

            if (myRadio.isTurnedOn()) {
                switch(option) {
                    case 1:
                        myRadio.turnOff();
                        break;
                    case 2:
                        myRadio.volumeUp();
                        break;
                    case 3:
                        myRadio.volumeDown();
                        break;
                    case 4:
                        myRadio.stationUp();
                        break;
                    case 5:
                        myRadio.stationDown();
                        break;
                    case 6:
                        if (myRadio.isInFM()) {
                            myRadio.changeToAM();
                        } else {
                            myRadio.changeToFM();
                        }
                        break;
                    case 7:
                        wantsToContinue = false;
                        break;
                    default:
                        System.out.println("Esta opcion no es valida!");
                        break;
                }
            } else {
                switch(option) {
                    case 1:
                        myRadio.turnOn();
                        break;
                    case 2:
                        wantsToContinue = false;
                        break;
                    default:
                        System.out.println("Esta opcion no es valida!");
                        break;
                }
            }

        } while (wantsToContinue);

        System.out.println("Gracias por participar, GG");
    }
}
