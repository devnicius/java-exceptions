package application;

import application.model.entities.Reservation;
import application.model.exceptions.DomainException;

import java.security.PrivilegedActionException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  { // throws vai propagar a exceção no método main, "o método pode lançar essa exceção". Métodos que chamam o main também devem propagar a exceção
        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            System.out.println("Room number: ");
            int number = sc.nextInt();

            System.out.println("Check-in date (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());


            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println(reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation (dd/MM/yyyy): ");

            System.out.println("Check-in date (dd/MM/yyyy): ");
            checkIn = sdf.parse(sc.next());

            System.out.println("Check-out date (dd/MM/yyyy): ");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);


            System.out.println(reservation);

            sc.close();
        } catch (ParseException e) {
            System.out.println("Invalid date format.");
        } catch (DomainException e) {
            System.out.println("Error in reservation: " + e.getMessage());
        } catch(RuntimeException e) { // tipo genérico para fazer um upcasting à RuntimeException e retornar uma mensagem de erro inesperado
            System.out.println("Unexpected error");
        }
    }
}