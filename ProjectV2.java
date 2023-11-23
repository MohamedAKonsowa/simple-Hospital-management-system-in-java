import java.util.Arrays;
import java.util.Scanner;

public class ProjectV2 {
    public static void score_zero(int[] score,int[] score1,int[] score2,int[] score3){
        Arrays.fill(score, 0);
        Arrays.fill(score1, 0);
        Arrays.fill(score2, 0);
        Arrays.fill(score3, 0);
    }
    public static void signup_name(int id, String name, String[] name_arr){
        name_arr[id] = name;
        System.out.println("Your ID is "+id);
    }
    public static void pass_signup(int[] password, int id, int new_password, String name){
        password[id] = new_password;
        System.out.println(name + " has been registered successfully");
    }
    public static void doctor_name_rank(String[] name){
        for (int i = 1; i < 100; i++) {
            boolean check;
            check = name[i] != null;
            if (check) {
                System.out.println(i+"- " + name[i]);
            }
            if (!check){break;}
        }
    }
    public static void doctor_data(String[][]doctor_data , int ID){
        for (int i = 1; i < 100; i++) {
            boolean check;
            check = doctor_data[i][ID] != null;
            if (check) {
                System.out.println(doctor_data[i][ID]);
            }
            else {break;}
        }
    }
    public static void recommendation(int[] score , int max_score , String[] doctor_name){
        for (int i = 1; i < 100; i++){
            if (score[i] == max_score){
                System.out.println("Dr. "+doctor_name[i]+" is recommended");
                break;
            }
        }
    }
    public static void loop(int[][]x,int y,String[]time){
        for (int i = 1 ; i <= 12; i++){
            if (x[i][y] > 0){
                System.out.println(i+"-  "+time[i]);
            }
        }
    }
    public static void top_patient(int[]patient_score, int patient_score_max, String[]patient_name){
        for (int i = 1; i < 100; i++){
            if (patient_score[i] == patient_score_max){
                System.out.println(patient_name[i]+" : "+patient_score[i]);
                break;
            }
        }
    }

    public static void main(String[]args){
        Scanner s1 = new Scanner(System.in);
        String[] patient_name = new String[100];
        String[] doctor_type1_name = new String[100];
        String[] doctor_type2_name = new String[100];
        String[] doctor_type3_name = new String[100];
        String[][] patient_data = new String[100][100];
        String[][] doctor_type1_data = new String[100][100];
        String[][] doctor_type2_data = new String[100][100];
        String[][] doctor_type3_data = new String[100][100];
        String[] time = {null,"9:00","9:30","10:00","10:30","11:00","11:30","12:00","12:30","1:00","1:30","2:00","2:30"};
        int[][] doctor_type1_time = new int[100][100];
        int[][] doctor_type2_time = new int[100][100];
        int[][] doctor_type3_time = new int[100][100];
        int[] patient_password = new int[100];
        int[] doctor_type1_password = new int[100];
        int[] doctor_type2_password = new int[100];
        int[] doctor_type3_password = new int[100];
        int[] doctor_type1_score = new int[100];
        int[] doctor_type2_score = new int[100];
        int[] doctor_type3_score = new int[100];
        int[] patient_score = new int[100];
        int patient_id = 0;
        int doctor_type1_id = 0;
        int doctor_type2_id = 0;
        int doctor_type3_id = 0;
        int doctor_type1_total = 0;
        int doctor_type2_total = 0;
        int doctor_type3_total = 0;
        int patient_total = 0;
        for (int day = 1; day <= 30; day++){
            System.out.println("day "+day);
            for (;;){
                score_zero(patient_score,doctor_type1_score,doctor_type2_score,doctor_type3_score);
                for (int i = 1; i < 100; i++){
                    for (int j = 1; j < 100; j++){
                        if (doctor_type1_data[j][i] != null){
                            doctor_type1_score[i]++;
                            doctor_type1_total = doctor_type1_total + 1;
                        }
                        if (doctor_type2_data[j][i] != null){
                            doctor_type2_score[i]++;
                            doctor_type2_total = doctor_type2_total + 1;
                        }
                        if (doctor_type3_data[j][i] != null){
                            doctor_type3_score[i]++;
                            doctor_type3_total = doctor_type3_total + 1;
                        }
                        if (patient_data[j][i] != null){
                            patient_score[i]++;
                            patient_total = patient_total + 1;
                        }
                    }
                }
                int patient_score_max = 0;
                int doctor_type1_score_max = 0;
                int doctor_type2_score_max = 0;
                int doctor_type3_score_max =0;
                for (int i = 1; i < 100; i++){
                    if (patient_score[i] > patient_score_max) {patient_score_max = patient_score[i];}
                    if (doctor_type1_score[i] > doctor_type1_score_max) {doctor_type1_score_max = doctor_type1_score[i];}
                    if (doctor_type2_score[i] > doctor_type2_score_max) {doctor_type2_score_max = doctor_type2_score[i];}
                    if (doctor_type3_score[i] > doctor_type3_score_max) {doctor_type3_score_max = doctor_type3_score[i];}
                }
                System.out.println("Please chose your current role");
                System.out.println("1- Staff\n2- Patient\n3- Administration");
                int role = s1.nextInt();
                if (role == 1){
                    System.out.println("Please chose your current role");
                    System.out.println("1- New Staff\n2- Old Staff");
                    int staff_role = s1.nextInt();
                    if (staff_role == 1){
                        System.out.println("Enter you name");
                        String new_staff_name = s1.next();
                        new_staff_name = new_staff_name.substring(0, 1).toUpperCase() + new_staff_name.substring(1);
                        System.out.println("Select your specialization");
                        System.out.println("1- Dentistry\n2- surgery\n3- Internal medicine");
                        int new_specialization = s1.nextInt();
                        if (new_specialization == 1){
                            doctor_type1_id++;
                            signup_name(doctor_type1_id, new_staff_name, doctor_type1_name);
                            System.out.println("Enter your password ( Can only be int number )");
                            int new_password = s1.nextInt();
                            pass_signup(doctor_type1_password, doctor_type1_id, new_password, new_staff_name);
                        }
                        else if (new_specialization == 2){
                            doctor_type2_id++;
                            signup_name(doctor_type2_id, new_staff_name, doctor_type2_name);
                            System.out.println("Enter your password ( Can only be int number )");
                            int new_password = s1.nextInt();
                            pass_signup(doctor_type2_password, doctor_type2_id, new_password, new_staff_name);
                        }
                        else if (new_specialization == 3){
                            doctor_type3_id++;
                            signup_name(doctor_type3_id, new_staff_name, doctor_type3_name);
                            System.out.println("Enter your password ( Can only be int number )");
                            int new_password = s1.nextInt();
                            pass_signup(doctor_type3_password, doctor_type3_id, new_password, new_staff_name);
                        }
                        else{System.out.println("Invalid Choice");}
                    }
                    else if (staff_role == 2){
                        System.out.println("Select your specialization");
                        System.out.println("1- Dentistry\n2- surgery\n3- Internal medicine");
                        int choose_specialization = s1.nextInt();
                        if (choose_specialization == 1){
                            System.out.println("Enter your ID");
                            int ID = s1.nextInt();
                            System.out.println("Enter your password");
                            int password_input = s1.nextInt();
                            if (password_input == doctor_type1_password[ID]) {
                                System.out.println("You have logged in as dr. " + doctor_type1_name[ID]);
                                System.out.println("1- Check data\n2- Add available time");
                                int answer1 = s1.nextInt();
                                if (answer1 == 1){
                                    doctor_data(doctor_type1_data,ID);
                                }
                                else if (answer1 == 2){
                                    System.out.println("1- 9:00\n2- 9:30\n3- 10:00\n4- 10:30\n5- 11:00\n6- 11:30\n7- 12:00\n8- 12:30\n9- 1:00\n10- 1:30\n11- 2:00\n12- 2:30");
                                    for (;;){
                                        System.out.println("Will you add a new time\n1- Yes\n2- No");
                                        int answer2 = s1.nextInt();
                                        if (answer2 == 1){
                                            System.out.println("Select time from above");
                                            int answer3 = s1.nextInt();
                                            doctor_type1_time[answer3][ID]++;}
                                        else if (answer2 == 2){break;}
                                        else{System.out.println("Invalid answer");}
                                    }
                                }
                                else{System.out.println("Invalid Choice");}
                            }
                            else {
                                System.out.println("Invalid password\n1- Try again\n2- Leave");
                                System.out.println("Returning to main screen");
                            }
                        }
                        else if (choose_specialization == 2){
                            System.out.println("Enter your ID");
                            int ID = s1.nextInt();
                            for (;;) {
                                System.out.println("Enter your password");
                                int password_input = s1.nextInt();
                                if (password_input == doctor_type2_password[ID]) {
                                    System.out.println("You have logged in as dr. " + doctor_type2_name[ID]);
                                    System.out.println("1- Check data\n2- Add available time");
                                    int answer1 = s1.nextInt();
                                    if (answer1 == 1){
                                        doctor_data(doctor_type2_data,ID);
                                    }
                                    else if (answer1 == 2){
                                        System.out.println("1- 9:00\n2- 9:30\n3- 10:00\n4- 10:30\n5- 11:00\n6- 11:30\n7- 12:00\n8- 12:30\n9- 1:00\n10- 1:30\n11- 2:00\n12- 2:30");
                                        for (;;){
                                            System.out.println("Will you add a new time\n1- Yes\n2- No");
                                            int answer2 = s1.nextInt();
                                            if (answer2 == 1){
                                                System.out.println("Select time from above");
                                                int answer3 = s1.nextInt();
                                                doctor_type2_time[answer3][ID]++;}
                                            else if (answer2 == 2){break;}
                                            else{System.out.println("Invalid answer");}
                                        }
                                    }
                                    else{System.out.println("Invalid Choice");}
                                }
                                else {
                                    System.out.println("Invalid password\n1- Try again\n2- Leave");
                                    int answer1 = s1.nextInt();
                                    if (answer1 == 2){
                                        System.out.println("Returning to main screen");
                                        break;
                                    }
                                }
                            }
                        }
                        else if (choose_specialization == 3){
                            System.out.println("Enter your ID");
                            int ID = s1.nextInt();
                            for (;;) {
                                System.out.println("Enter your password");
                                int password_input = s1.nextInt();
                                if (password_input == doctor_type3_password[ID]) {
                                    System.out.println("You have logged in as dr. " + doctor_type3_name[ID]);
                                    System.out.println("1- Check data\n2- Add available time");
                                    int answer1 = s1.nextInt();
                                    if (answer1 == 1){
                                        doctor_data(doctor_type3_data,ID);
                                    }
                                    else if (answer1 == 2){
                                        System.out.println("1- 9:00\n2- 9:30\n3- 10:00\n4- 10:30\n5- 11:00\n6- 11:30\n7- 12:00\n8- 12:30\n9- 1:00\n10- 1:30\n11- 2:00\n12- 2:30");
                                        for (;;){
                                            System.out.println("Will you add a new time\n1- Yes\n2- No");
                                            int answer2 = s1.nextInt();
                                            if (answer2 == 1){
                                                System.out.println("Select time from above");
                                                int answer3 = s1.nextInt();
                                                doctor_type3_time[answer3][ID]++;}
                                            else if (answer2 == 2){break;}
                                            else{System.out.println("Invalid answer");}
                                        }
                                    }
                                    else{System.out.println("Invalid Choice");}
                                }
                                else {
                                    System.out.println("Invalid password\n1- Try again\n2- Leave");
                                    int answer1 = s1.nextInt();
                                    if (answer1 == 2){
                                        System.out.println("Returning to main screen");
                                        break;
                                    }
                                }
                            }
                        }
                        else{System.out.println("Invalid Choice");}
                    }
                    else{System.out.println("Invalid Choice");}
                }
                else if (role == 2){
                    System.out.println("Please chose your current role");
                    System.out.println("1- New Patient\n2- Old Patient");
                    int patient_role = s1.nextInt();
                    if (patient_role == 1){
                        System.out.println("Enter Your name");
                        String new_patient_name = s1.next();
                        patient_id++;
                        new_patient_name = new_patient_name.substring(0, 1).toUpperCase() + new_patient_name.substring(1);
                        signup_name(patient_id, new_patient_name, patient_name);
                        System.out.println("Enter your password ( Can only be int number )");
                        int new_password = s1.nextInt();
                        pass_signup(patient_password, patient_id, new_password, new_patient_name);
                    }
                    else if (patient_role == 2){
                        System.out.println("Enter your ID");
                        int ID = s1.nextInt();
                        System.out.println("Enter your password");
                        int password_input = s1.nextInt();
                        if (password_input == patient_password[ID]) {
                            System.out.println("You have logged in as " + patient_name[ID]);
                            System.out.println("Wold you like to make a reservation\n1- Yes\n2- No\n3- Wold you like to check your reservation data");
                            int answer1 = s1.nextInt();
                            if (answer1 == 1){
                                System.out.println("Select doctor specialization");
                                System.out.println("1- Dentistry\n2- surgery\n3- Internal medicine");
                                int answer2 = s1.nextInt();
                                if (answer2 == 1){
                                    if (doctor_type1_total > 0){
                                        recommendation(doctor_type1_score, doctor_type1_score_max, doctor_type1_name);
                                    }
                                    doctor_name_rank(doctor_type1_name);
                                    System.out.println("Chose a doctor based and how they are ordered");
                                    int answer3 = s1.nextInt();
                                    for (;;){
                                        System.out.println("Select a time");
                                        loop(doctor_type1_time,answer3,time);
                                        int answer4 = s1.nextInt();
                                        if (doctor_type1_time[answer4][answer3] > 0){
                                            doctor_type1_time[answer4][answer3]--;
                                            System.out.println("You "+patient_name[ID]+" Have made an appointment with Dr "+doctor_type1_name[answer3]+" at "+time[answer4]);
                                            for (int i = 1; i < 100; i++){
                                                boolean check;
                                                check = doctor_type1_data[i][answer3] == null;
                                                if (check){
                                                    doctor_type1_data[i][answer3] = "";
                                                    doctor_type1_data[i][answer3]+= "Day " + day + " " + patient_name[ID] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            for (int i = 1; i < 100; i++) {
                                                boolean check1;
                                                check1 = patient_data[i][ID] == null;
                                                if (check1) {
                                                    patient_data[i][ID] = "";
                                                    patient_data[i][ID] += "Day " + day + " " + doctor_type1_name[answer3] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (answer4 > 12){
                                            System.out.println("Invalid Choice");
                                        }
                                        else{
                                            System.out.println("You cannot reserve at the chosen time");
                                            break;
                                        }
                                    }
                                }
                                else if (answer2 == 2){
                                    if (doctor_type2_total > 0){
                                        recommendation(doctor_type2_score, doctor_type2_score_max, doctor_type2_name);
                                    }
                                    doctor_name_rank(doctor_type2_name);
                                    System.out.println("Chose a doctor based and how they are ordered");
                                    int answer3 = s1.nextInt();
                                    for (;;){
                                        System.out.println("Select a time");
                                        loop(doctor_type2_time,answer3,time);
                                        int answer4 = s1.nextInt();
                                        if (doctor_type2_time[answer4][answer3] > 0){
                                            doctor_type2_time[answer4][answer3]--;
                                            System.out.println("You "+patient_name[ID]+" Have made an appointment with Dr "+doctor_type2_name[answer3]+" at "+time[answer4]);
                                            for (int i = 1; i < 100; i++){
                                                boolean check;
                                                check = doctor_type2_data[i][answer3] == null;
                                                if (check){
                                                    doctor_type2_data[i][answer3] = "";
                                                    doctor_type2_data[i][answer3]+= "Day " + day + " " + patient_name[ID] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            for (int i = 1; i < 100; i++) {
                                                boolean check1;
                                                check1 = patient_data[i][ID] == null;
                                                if (check1) {
                                                    patient_data[i][ID] = "";
                                                    patient_data[i][ID] += "Day " + day + " dr. " + doctor_type2_name[answer3] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (answer4 > 12){
                                            System.out.println("Invalid Choice");
                                        }
                                        else{
                                            System.out.println("You cannot reserve at the chosen time");
                                            break;
                                        }
                                    }
                                }
                                else if (answer2 == 3){
                                    if (doctor_type3_total > 0){
                                        recommendation(doctor_type3_score, doctor_type3_score_max, doctor_type3_name);
                                    }
                                    doctor_name_rank(doctor_type3_name);
                                    System.out.println("Chose a doctor based and how they are ordered");
                                    int answer3 = s1.nextInt();
                                    for (;;){
                                        System.out.println("Select a time");
                                        loop(doctor_type3_time,answer3,time);
                                        int answer4 = s1.nextInt();
                                        if (doctor_type3_time[answer4][answer3] > 0){
                                            doctor_type3_time[answer4][answer3]--;
                                            System.out.println("You "+patient_name[ID]+" Have made an appointment with Dr "+doctor_type3_name[answer3]+" at "+time[answer4]);
                                            for (int i = 1; i < 100; i++){
                                                boolean check;
                                                check = doctor_type3_data[i][answer3] == null;
                                                if (check){
                                                    doctor_type3_data[i][answer3] = "";
                                                    doctor_type3_data[i][answer3]+= "Day " + day + " dr. " + patient_name[ID] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            for (int i = 1; i < 100; i++) {
                                                boolean check1;
                                                check1 = patient_data[i][ID] == null;
                                                if (check1) {
                                                    patient_data[i][ID] = "";
                                                    patient_data[i][ID] += "Day " + day + " dr. " + doctor_type3_name[answer3] + " " + time[answer4];
                                                    break;
                                                }
                                            }
                                            break;
                                        }
                                        else if (answer4 > 12){
                                            System.out.println("Invalid Choice");
                                        }
                                        else{
                                            System.out.println("You cannot reserve at the chosen time");
                                            break;
                                        }
                                    }
                                }
                                else {System.out.println("Invalid Choice");}
                            }
                            else if (answer1 == 2){System.out.println("Returning to main screen");}
                            else if (answer1 == 3){
                                for (int i = 1; i < 100; i++){
                                    boolean check;
                                    check = patient_data[i][ID] != null;
                                    if (check){
                                        System.out.println(patient_data[i][ID]);
                                    }else {break;}}
                            }
                            else{System.out.println("Invalid Choice");}
                        }
                        else {
                            System.out.println("Invalid password\n1- Try again\n2- Leave");
                            int answer1 = s1.nextInt();
                            if (answer1 == 2){
                                System.out.println("Returning to main screen");
                                break;
                            }
                        }
                    }
                    else{System.out.println("Invalid Choice");}
                }
                else if (role == 3){
                    System.out.println("Has the day ended\n1- Yes\n2- No\n3- See top patient");
                    int answer = s1.nextInt();
                    if (answer == 1){break;}
                    if (answer == 2){System.out.println("Returning to main screen");}
                    if (answer == 3){
                        top_patient(patient_score, patient_score_max, patient_name);
                    }
                    else{System.out.println("Invalid Choice");}
                }
                else{System.out.println("Invalid answer");}
            }
        }
    }
}
