package mainPackage;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        procesoMaquina();
    }

    public static void procesoMaquina(){
        Scanner sc = new Scanner(System.in);
        String option = "";
        int transactions = 0;
        int operacionesCambio = 0;
        int cambio;
        //La opción D se consider para salir del programa
        while (!option.equals("D")){
            System.out.println("Elija el producto: ");
            option = sc.nextLine();
            if (option != null && (option.equals("A") || option.equals("B") || option.equals("C"))) {
                transactions ++;
                cambio = calcularCambio(option);
                operacionesCambio += operacionesCambio(cambio);
            }else if (!option.equals("D")){
                System.out.println("Selecciona una opción válida");
            }
        }
        System.out.println("Transacciones: " + transactions);
        System.out.println("Operaciones para devolver el cambio: " + operacionesCambio);
    }

    public static int calcularCambio(String option){
        int operations = 0;
        int optionSelectedCost = costoOpcionSeleccionada(option);
        int total = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar cantidad de pago: ");
        while (total < optionSelectedCost){
            total += sc.nextInt();
        }
        System.out.println("Su cambio es: " + (total - optionSelectedCost));
        return total - optionSelectedCost;
    }

    public static int operacionesCambio(int cambio){
        int operacionesDeCambio = 0;
        if (cambio != 0){
            while (cambio >= 10){
                if (cambio >= 100){
                    System.out.println("100");
                    cambio -= 100;
                } else if (cambio >= 50) {
                    System.out.println("50");
                    cambio -= 50;
                } else {
                    System.out.println("10");
                    cambio -= 10;
                }
                operacionesDeCambio ++;
            }
        }
        return operacionesDeCambio;
    }



    public static int costoOpcionSeleccionada(String option){
        int total = 0;
        switch (option){
            case "A":   total = 270;
                        break;
            case "B":   total = 340;
                        break;
            case "C":   total = 390;
                        break;
        }
        return total;
    }
}
