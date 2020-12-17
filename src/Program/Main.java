package Program;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Main {

	public static void main(String[] args) throws ParseException {
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Reservation reservation = null;

		System.out.println("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.println("Check in date: ");
		Date checkin = sdf.parse(sc.next());
		System.out.println("Check out date: ");
		Date checkout = sdf.parse(sc.next());

		if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: invalid dadte");
		} else {
			reservation = new Reservation(roomNumber, checkin, checkout);
			System.out.println(reservation);
		}

		System.out.println("---------UPDATE RESERVATIONS-----------------");
		System.out.println("Entre com os dados para atualizar as reservas");
		System.out.println("Check in date: ");
		Date checkIn = sdf.parse(sc.next());
		System.out.println("Check out date: ");
		Date checkOut = sdf.parse(sc.next());

		System.out.println("------------DADOS ATUALIZADOS-------------");
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			System.out.println("Preciso de datas futuras");
		} else if (!checkout.after(checkin)) {
			System.out.println("Error in reservation: invalid dadte");
		} else {
			reservation.updateDates(checkIn, checkOut);
			System.out.println(reservation);
		}

		sc.close();

	}

}
