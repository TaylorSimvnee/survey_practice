import java.util.ArrayList;
import java.util.Scanner;

public class Survey {
    public static void main(String[] args) {

        /**
         COMPLETE THIS CLASS AFTER ALL OTHER CLASSES ARE COMPLETED
         */

        /*
        Write a program that will get information from 3 participants and
        -Print information for each participant
        -Print how many participants were male
        -Print how many participants were female
        -Print the age of the youngest person
        -Print the age of the eldest person
         */

        //Declare objects/variables , create your container -> run your program -> print out your results... a good logic flow

        //Global variables or objects needed //on the top - what you need - all variables or objects you need
        Scanner inputReader = new Scanner(System.in);
        ArrayList<Participant> participants = new ArrayList<>(); //can do without arrayList but this is a common practice... like using a container for your objects.
        int youngest = Integer.MAX_VALUE, eldest = 0;

        do {                                                //Run your program
            System.out.println(SurveyQuestions.askToJoin);
            String join = inputReader.next();

            if (join.toLowerCase().startsWith("y")){

                Participant.addParticipants();

                //Ask your questions to get name, age, and gender
                System.out.println(SurveyQuestions.askName);
                String name = inputReader.next();

                System.out.println(SurveyQuestions.askAge);
                int age = inputReader.nextInt();

                System.out.println(SurveyQuestions.askGender);
                String gender = inputReader.next();

                Participant participant = new Participant(name, age , gender);
                participants.add(participant);

                if (gender.toUpperCase().startsWith("M")) Participant.addMaleParticipants();
                else Participant.addFemaleParticipants();
            }
        }while (Participant.totalNumberOfParticipants < 3);

        for (Participant participant : participants) {
            System.out.println(participant);
            if(participant.age > eldest) eldest = participant.age;
            if(participant.age < youngest) youngest = participant.age;
        }

        System.out.println("The total number of male participants is = " + Participant.totalNumberOfMaleParticipants); //Print out at the bottom
        System.out.println("The total number of female participants is = " + Participant.totalNumberOfFemaleParticipants);
        System.out.println("The age of the youngest person is = " + youngest);
        System.out.println("The age of the eldest person is = " + eldest);
    }
}
