package AirlineReservationSystem;

public class Airline {
    private Person[] seats;
    public Airline(Person[] seats){
        this.seats = new Person[seats.length];
    }
    public Person getPerson(int index){
        return new Person(this.seats[index]);
    }
    public void setPerson(Person person){
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }
    
    public void createReservation(Person person){
        while(seats[person.getSeatNumber() - 1] != null){
            System.out.println("\n" + person.getName() + ", seat: " + person.getSeatNumber()  + " is already taken. Please choose another one.\n");
            person.chooseSeat();
        }
        seats[person.getSeatNumber() - 1] = new Person(person);
        System.out.println("Thank you " + person.getName() + " for flying with Java airlines. Your seat number is " + person.getSeatNumber()+ ".\n");
    }
    public String toString(){
        String temp = "";
        System.out.println("****************** RESERVATIONS COMPLETE! ******************\n");
        for (int i = 0; i < this.seats.length; i++) {
            if(this.seats[i] == null){
                temp += (i + 1) + " is empty.\n\n";
                continue;
            }
            temp += this.seats[i] + "\n";
        }
        return temp;
    }
}
