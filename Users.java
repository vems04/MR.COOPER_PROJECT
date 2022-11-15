import java.util.*;
import java.text.DecimalFormat;
import java.time.LocalDate;
public  class Users{
    static Map<Integer,Users> Viewer = new HashMap<>();
    static Map<Integer,Users> Critics = new HashMap<>();
    static Map<Integer,Users> Admin = new HashMap<>();
    static Map<Integer,Users> Movie = new HashMap<>();
    static Map<Integer,Users> Recentmovies = new HashMap<>();
    static Map<Integer,Users> Recentaaddedmoviesapprovedbyadmin = new HashMap<>();
    static Map<Integer,Users> Recentreviewedmoviebyviewer = new HashMap<>();
    static Map<Integer,Users> Recentreviewedmoviebycritics = new HashMap<>();
    static Map<Integer,Users> Recentreviewedmoviebyadmin = new HashMap<>();
    static Map<Integer,Users> Wholereviewsdatabase = new HashMap<>();
    ArrayList<Integer> review_id= new ArrayList<> ();
    static int Id = 1;
    String name;
    String phone;
    int reviewcount ;
    int premoviecount;
    int user_id;
    int movie_id ;
    int m_id =1;
    String email;
    String moviegenre;
    String movieyear;
    String movielanguage;
    String moviename;
    String movierating;
    String password;
    int count=0;
    int adminselectedmovie=0;
    int USER_IDs;
    String [] moviesname={"Alien","Angel","Bambi","Cobra","Dumbo","Earth","Greed","Hotel","Gypsy","Kitty"};
    String []  moviesyears = {"1941","1954","1954","1960","1968","1972","1981","2000","2003","2022"};
    String [] moviesgenre = {"Science","Thrill","Horror","Comedy","Romance","Drama","Crime","Thrill","Histroy","Artist"};
    String [] movieslanguage  = {"Spanish","English","Arabic","Russian","Chinese","English","Korean","Turkish","Tamil","Tamil"};
    String []  moviesrating = {"9.5","9.4","9.3","9.2","9.4","9.5","9.6","9.6","9.5","9.8"};
    String [] moviesnames={"Alien","Angel","Bambi","Cobra","Dumbo","Earth","Greed","Hotel","Gypsy","Kitty"};
    String []  moviesyearss = {"1968","1954","1954","2000","1972","1941","1981","1960","2022","2003"};
    String [] moviesgenres = {"Artist","Comedy","Crime","Drama","Horror","Histroy","Science","Romance","Thrill","Thrill"};
    String [] movieslanguages  = {"Spanish","English","Arabic","Russian","Chinese","English","Korean","Turkish","Tamil","Tamil"};
    String []  moviesratings = {"9.5","9.4","9.3","9.2","9.4","9.5","9.6","9.6","9.5","9.8"};

    public Users(){
                this.name = "";
                this.phone = "";
                this.user_id = Id;
                this.email= "";
                this.moviename="";
                this.movielanguage="";
                this.moviegenre="";
                this.movieyear="";
                this.movierating = "";
                this.movie_id = m_id;
                this.password = " ";
                this.reviewcount = 1;
    }

    public  Users(String name, String phone,String email,String passwords){
                this.name = name;
                this.phone = phone;
                this.user_id = Id++;
                this.email = email;
                this.reviewcount =1;
                this.password = passwords;
            }

    public Users(Integer user_id,Integer movie_id,String moviename,String moviegenre,String movieyear,String movielanguage,String movierating){
        this.moviename = moviename;
        this.moviegenre = moviegenre;
        this.movieyear = movieyear;
        this.movielanguage = movielanguage;
        this.movie_id = m_id++;
        this.user_id=Id;
        this.movierating=movierating;
    }

    public Users(Integer id,String moviename,String moviegenre,String movielanguage,String movieyear,String movierating){
        this.movie_id = id;
        this.moviename = moviename;
        this.moviegenre = moviegenre;
        this.movieyear = movieyear;
        this.movielanguage = movielanguage;
        this.movierating = movierating;
        this.user_id=Id;
    }

    public void nothing(int f){
        if(f == 3){
        System.out.println("                    THANKS FOR VISITING VEMS REVIEWS");
        System.out.println("                            HAVE A GOOD DAY");

         }
    }

    public void Start(){
        Scanner sc = new Scanner(System.in);
            System.out.println("*************  WELCOME TO VEMS REVIEWS  *************");
            System.out.println("1.SIGN UP"+"    "+ "2.SIGN IN"+"    "+ "3.CLOSE THE SITE");
            System.out.println("PLEASE ENTER THE NUMBER WITH RESPECT TO THE CHOICES GIVEN");
            int temp =sc.nextInt();
            switch (temp){
                case 1:
                    System.out.println("SELECT FROM THE ROLES GIVEN BELOW");
                    System.out.println("1.VIEWER"+"  "+"2.CRITICS"+"  "+"3.ADMIN");
                    int option = sc.nextInt();
                        if(option==1){
                            Users a = new Users();
                            a.Signup_details(option);
                            break;
                        }
                        else if(option==2){
                            System.out.println("FOR DIRECT CRITICS SIGN UP YOU HAVE TO ENTER SECURITY CODE");
                            String securitycodecirtics = sc.next();
                            String securitycode="CRITIC";
                            if(securitycodecirtics.equals(securitycode)){
                                System.out.println("ACCESS GRANTED");
                                Users a = new Users();
                                a.Signup_details(option);
                                break;
                            }
                            else{
                                System.out.println("SECURITY CODE MISMATCH");
                                Start();
                                break;
                            }
                        }
                        else if(option==3){
                            System.out.println("FOR DIRECT ADMIN SIGN UP YOU HAVE TO ENTER SECURITY CODE");
                            String securitycodecirtics = sc.next();
                            String securitycode="ADMIN";
                            if(securitycodecirtics.equals(securitycode)){
                                System.out.println("ACCESS GRANTED");
                                Users a = new Users();
                                a.Signup_details(option);
                                break;
                            }
                            else{
                                System.out.println("Security code mismatch");
                                Start();
                                break;
                            }
                        }
                        else{
                            System.out.println("ENTER CORRECT NUMERICAL VALUES ONLY");
                            Start();
                            break;
                        }
                case 2:
                    int check=0;
                    try{
                    System.out.println("1.VIEWER"+"  "+"2.CRITICS"+"  "+"3.ADMIN");
                     option = sc.nextInt();
                     if(option==1){
                         check =0;
                            System.out.println("ENTER YOUR USER_ID");
                            USER_IDs = sc.nextInt();
                            System.out.println("ENTER THE PASSWORD");
                            String password =sc.next();
                            if(Viewer.isEmpty()){
                                System.out.println("NO VIEWERS IN DATABASE");
                                Start();
                                break;
                            }
                            for(Users m: Viewer.values()){
                                if(USER_IDs==m.user_id) {
                                    check =1;
                                    if (password.equals(m.password)) {
                                        System.out.println("SUCCESSFULLY LOGGED IN ");
                                        Reviewsystem(m, option);
                                        break;
                                         }
                                    else {
                                        System.out.println("PASSWORD MISMATCH PLEASE ENTER CORRECT PASSWORD");
                                        Start();
                                        break;
                                          }
                                        }
                                    }
                                if(check!=1){
                                    System.out.println("USER ID NOT FOUND");
                                    Start();
                                    break;
                                }
                           }

                        if(option==2){
                            check =0;
                               System.out.println("ENTER YOUR USER_ID");
                               USER_IDs = sc.nextInt();
                               System.out.println("ENTER THE PASSWORD");
                               password =sc.next();
                               if(Critics.isEmpty()){
                                 System.out.println("NO CRITICS IN DATABASE");
                                 Start();
                                 break;
                               }
                               for(Users m: Critics.values()){
                                if(USER_IDs==(m.user_id)){
                                    check=1;
                                    if(password.equals(m.password)){
                                        System.out.println("SUCCESSFULLY LOGGED IN ");
                                        Reviewsystem(m,option);
                                        break;
                                    }
                                    else{
                                        System.out.println("PASSWORD MISMATCH");
                                        Start();
                                        break;
                                         }
                                      }
                                   }
                            if(check!=1){
                                System.out.println("USER ID NOT FOUND");
                                Start();
                                break;
                            }
                        }
                        if(option==3){
                            check =0;
                            System.out.println("ENTER YOUR USER_ID");
                            USER_IDs = sc.nextInt();
                            System.out.println("ENTER THE PASSWORD");
                            String password =sc.next();
                            if(Admin.isEmpty()){
                                System.out.println("NO ADMINS IN DATABASE");
                                Start();
                                break;
                            }
                            for(Users m: Admin.values()){
                                if(USER_IDs==m.user_id) {
                                    check =1;
                                    if (password.equals(m.password)) {
                                        System.out.println("SUCCESSFULLY LOGGED IN ");
                                        Admin_privilege(m, option);
                                        break;
                                    }
                                    else {
                                        System.out.println("PASSWORD MISMATCH PLEASE ENTER CORRECT PASSWORD");
                                        Start();
                                        break;
                                    }
                                }
                            }
                            if(check!=1){
                                System.out.println("USER ID NOT FOUND");
                                Start();
                                break;
                            }
                        }
                    }
                    catch(Exception e){
                        System.out.println("ENTER NUMERIC VALUES ONLY");
                        Start();
                        break;
                    }
                case 3:
                    nothing(temp);
                    break;
                }
    }

    public void Signup_details(int options){
        Scanner sc = new Scanner(System.in);
        System.out.println("ENTER THE DETAILS");
        System.out.println("ENTER YOUR NAME");
        String name = sc.nextLine();
        if(name.isEmpty()){
            System.out.println("ENTER A VALID NAME");
            Signup_details(options);
        }
        System.out.println("ENTER YOUR EMAIL ID");
        String email = sc.next();
        System.out.println("ENTER YOUR PHONE NUMBER");
        String phone = sc.next();
        while(phone.length() != 10){
             System.out.println("ENTER A VALID NUMBER");
             System.out.println("ENTER YOUR PHONE NUMBER");
             phone = sc.next();
        }
        System.out.println("ENTER THE PASSWORD");
        System.out.println("PASSWORD CAN CONTAIN NUMERICS,ALPHABETS,ETC."+'\n'+"IT'S LENGTH MUST BE GREATER THAN 8 CHARACTERS");
        String password =sc.next();
         if(password.length()<8){
             System.out.println("PASSWORD IS TOO SHORT");
             System.out.println("ENTER THE PASSWORD");
             password =sc.next();
        }
         System.out.println("RE-ENTER PASSWORD FOR COMFORMATION");
         String confirmpassword =sc.next();
           while(!password.equals(confirmpassword)){
             System.out.println("PASSWORD MISMATCH TRY AGAIN");
               System.out.println("ENTER THE PASSWORD");
               password =sc.next();
               System.out.println("RE-ENTER PASSWORD FOR COMFORMATION");
               confirmpassword =sc.next();
           }
        Users a = new Users(name,phone,email,password);
        if(options==1){
        a.Addviewer(a);
        a.Reviewsystem(a,options);
        }
        else if(options==2){
            a.Addcritics(a);
            a.Reviewsystem(a,options);
        }
        else{
            a.Addadmin(a);
            a.Admin_privilege(a,options);

        }
    }

    public void Admin_privilege(Users a,int options){
        Scanner sc = new Scanner(System.in);
        System.out.println("1.REVIEW MOVIE"+" "+"2.CHECK MOVIE SUGGESTIONS GIVEN BY VIEWERS"+" "+"3.VIEW USERSLIST"+" "+"4.REVIEWS LIST"+" "+"5.REMOVE USERS"+" "+"6.EXIT");
        int option = sc.nextInt();
        switch(option){
            case 1:
                a.Reviewsystem(a,options);
                break;
            case 2:
                System.out.println("CHECK THE LIST FOR NEW MOVIE ADDITION TO THE WEBSITE");
                if(Recentmovies.isEmpty()){
                    System.out.println("NO MOVIE WERE SUGGESTED BY VIEWERS");
                    Admin_privilege(a,options);
                    break;
                }
                Printrecentaddedmoviesbyviewer();
                System.out.println("SELECT THE ID FOR ADDITION OF MOVIE TO SITE");
                int select = sc.nextInt();
                Checking_movies_by_Admin_which_is_added_by_viewer(select);
                Admin_privilege(a,options);
                break;
            case 3:
                System.out.println("SELECT USER TYPE");
                System.out.println("1.VIEWER"+" "+"2.CRITICS"+" "+"3.ADMINS");
                int user_type=sc.nextInt();
                switch (user_type){
                                case 1:
                                    Printviewer(a,options);
                                    break;
                                case 2:
                                    Printcritics(a,options);
                                    break;
                                case 3:
                                    Printadmin(a,options);
                                    break;
                            }
                   Admin_privilege(a,options);
                   break;
            case 4:
                  printwholedatabase(a,options);
                  Admin_privilege(a,options);
                  break;
            case 5:
                  System.out.println("SELECT USER TYPE");
                  System.out.println("1.VIEWER"+" "+"2.CRITICS"+" "+"3.ADMINS");
                  user_type=sc.nextInt();
                  int Removeuser;
                  if(user_type==1){
                        Printviewer(a,options);
                        System.out.println("ENTER THE USER_ID TO BE REMOVED");
                        Removeuser = sc.nextInt();
                        remove_viewer(Removeuser);
                        System.out.println("USER SUCCESSFULLY REMOVED");
                        Admin_privilege(a,options);
                        break;
                }
                    if(user_type==2){
                        Printcritics(a,options);
                        System.out.println("ENTER THE USER_ID TO BE REMOVED");
                        Removeuser = sc.nextInt();
                        remove_critics(Removeuser);
                        System.out.println("USER SUCCESSFULLY REMOVED");
                        Admin_privilege(a,options);
                        break;
                    }
                    if(user_type==3){
                        Printadmin(a,options);
                        System.out.println("ENTER THE USER_ID TO BE REMOVED");
                        Removeuser = sc.nextInt();
                        remove_admin(Removeuser);
                        System.out.println("USER SUCCESSFULLY REMOVED");
                        Admin_privilege(a,options);
                        break;
                }
            case 6:
            {
               Start();
               break;
            }
        }
    }

    public  void Reviewsystem(Users a,int i){
        try{
            Scanner sc = new Scanner(System.in);
            System.out.println("1.REVIEW A MOVIE"+" "+"2.ADD A MOVIE"+" "+"3.VIEW PREVIOUS REVIEWS" +" "+"4.BACK");
            int options = sc.nextInt();
            if(options>4){
                System.out.println("ENTER VALUES BETWEEN THE RANGE");
                Reviewsystem(a,i);
            }
            switch (options) {
                case 1:
                    System.out.println("LIST MOVIES BY");
                    System.out.println("1.GENRE"+"  "+"2.YEAR OF RELEASE"+"  "+"3.RECENTLY ADDED MOVIE");
                    int option = sc.nextInt();
                    if(option>3){
                        System.out.println("ENTER WITH RESPECT TO NUMBER GIVEN");
                        Reviewsystem(a,i);
                        break;
                    }
                    Reviewmovies(option, a, i);
                    break;
                case 2:
                    System.out.println("HOW ANY MOVIES DO YOU WANT TO ADD");
                    int moviecount = sc.nextInt();
                    premoviecount = moviecount + Recentmovies.size();
                    for(int y = premoviecount-moviecount;y<premoviecount;y++){
                        System.out.println("ENTER DETAILS OF THE MOVIE");
                        System.out.println("ENTER THE TITLE");
                        String moviename = sc.next();
                        System.out.println("GENRE");
                        String moviegenre = sc.next();
                        System.out.println("YEAR OF RELEASE");
                        String movieyear = sc.next();
                        System.out.println("LANGUAGE");
                        String movielanguage =sc.next();
                        Users m = new Users(y+1,moviename,moviegenre,movielanguage,movieyear," ");
                        if(i==1){
                            Addmovie(m);
                        }
                        else{
                            Addmovies_by_critics_and_admin(m);
                        }
                    }
                    Reviewsystem(a,i);
                    break;
                case 3:
                    Print_recently_reviewed_movies(a.user_id,i);
                    if(i==3){
                        Admin_privilege(a,options);
                        break;
                    }
                    Reviewsystem(a,i);
                    break;
                case 4:
                    if(i==3){
                        Admin_privilege(a,i);
                        break;
                    }
                    Users m = new Users();
                    m.Start();
                    break;
            }
        }
        catch(Exception e){
            System.out.println("ENTER NUMERICAL VALUES ONLY");
            Reviewsystem(a,i);
        }
    }
    
    public void Reviewmovies(int option,Users a,int i){
        try{
            Scanner sc = new Scanner(System.in);
            Viewer_to_critic_change_checker(a);
            switch(option) {
                case (1):
                    System.out.println("SELECT THE MOVIE FROM GIVEN LIST");
                    System.out.println("LIST OF ALL TIME FAVOURITE MOVIES BASED ON GENRE");
                    System.out.println("ID"+"\t\t"+"TITLE"+"\t\t"+"GENRE"+"\t\t\t"+"LANGUAGE"+"\t\t"+"YEAR"+"\t\t\t"+"RATING");
                    Preinputmovies(option);
                    Printtopmovies();
                    System.out.println("SELECT THE MOVIE FOR THE RATING");
                    movie_id = sc.nextInt();
                    if(movie_id<0||movie_id>10){
                        System.out.println("INVALID MOVIE_ID PLEASE SELECT CORRECTLY");
                        break;
                    }
                    count++;
                    if (count > 1) {
                        if (review_id.contains(movie_id)) {
                            System.out.println("YOU HAVE REVIEW THE MOVIE ALREADY PLEASE SELECT OTHER MOVIES");
                            Reviewsystem(a,i);
                            break;
                        }
                    }
                    review_id.add(movie_id);
                    Addreview(a, movie_id, i,option);
                    break;
                case (2):
                    System.out.println("SELECT THE MOVIE FROM GIVEN LIST");
                    System.out.println("LIST OF ALL TIME FAVOURITE MOVIES BASED ON YEAR OF RELEASE");
                    System.out.println("ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t" + "YEAR" + "\t\t\t" + "RATING");
                    Preinputmovies(option);
                    Printtopmovies();
                    System.out.println("SELECT THE MOVIE FOR THE RATING");
                    movie_id = sc.nextInt();
                    if(movie_id<0||movie_id>10){
                        System.out.println("INVALID MOVIE_ID PLEASE SELECT CORRECTLY");
                        break;
                    }
                    count++;
                    if (count > 1) {
                        if (review_id.contains(movie_id)) {
                            System.out.println("YOU HAVE REVIEW THE MOVIE ALREADY PLEASE SELECT OTHER MOVIES");
                            Reviewsystem(a,i);
                            break;
                        }
                    }
                    review_id.add(movie_id);
                    Addreview(a, movie_id, i,option);
                    break;
                case (3):
                    if (Recentaaddedmoviesapprovedbyadmin.isEmpty()) {
                        System.out.println("NO MOVIES RECENTLY ADDED");
                        Reviewsystem(a, i);
                        break;
                    }
                    System.out.println("LIST OF RECENTLY ADDED MOVIES");
                    Printrecentaddedmoviesbyadmin(user_id);
                    System.out.println("SELECT THE MOVIE FOR THE RATING");
                    movie_id = sc.nextInt();
                    Check_date_before_review(movie_id, a, i);
                    Recentmovies_addreview(a, movie_id, i);
                    break;
            }
        }
       catch(Exception e){System.out.println("ENTER NUMERICAL VALUES OpNLY" );
           Reviewsystem(a,i);
       }
    }

    public void Addreview(Users a,int movie_id,int i,int option){
        Scanner sc = new Scanner(System.in);
        System.out.println("FROM 1 TO 10 BEING 10 AS THE HIGHEST RATING FOR THE MOVIE");
        String rating =sc.next();
        a.reviewcount++;
        System.out.println(reviewcount);
        Calculating_rating(movie_id,rating,i,option);
        for(Users m:Movie.values()){
            if (m.movie_id == movie_id){
                Users r = new Users(a.user_id,m.movie_id, m.moviename, m.moviegenre, m.movieyear, m.movielanguage,rating);
                if(i==1){
                    Recentreviewedmoviebyviewer.put(movie_id, r);
                    Wholereviewsdatabase.put(movie_id,r);
                    System.out.println("----REVIEW ADDED SUCCESSFULLY----");
                    Reviewsystem(a,i);
                    break;
                }
                else if (i==2){
                    Recentreviewedmoviebycritics.put(movie_id, r);
                    Wholereviewsdatabase.put(movie_id,r);
                    System.out.println("----REVIEW ADDED SUCCESSFULLY----");
                    Reviewsystem(a,i);
                    break;
                }
                else if (i==3){
                    Recentreviewedmoviebyadmin.put(movie_id, r);
                    Wholereviewsdatabase.put(movie_id,r);
                    System.out.println("----REVIEW ADDED SUCCESSFULLY----");
                    Reviewsystem(a,i);
                    break;
                }
            }
        }
    }

    public void Recentmovies_addreview(Users a,int movie_id,int i){
        Scanner sc = new Scanner(System.in);
        System.out.println("FROM 1 TO 10 BEING 10 AS THE HIGHEST RATING FOR THE MOVIE");
        String rating =sc.next();
        for(Users m:Recentaaddedmoviesapprovedbyadmin.values()){
            if (m.movie_id == movie_id) {
                Users r = new Users(a.user_id, m.moviename, m.moviegenre, m.movieyear, m.movielanguage, rating);
                if(i==1){
                    Recentreviewedmoviebyviewer.put(user_id, r);
                    System.out.println("----REVIEW ADDED SUCCESSFULLY----");
                }
                else if(i==2){
                    Recentreviewedmoviebycritics.put(a.user_id, r);
                    System.out.println("----REVIEW ADDED SUCCESSFULLY----");
                }
                else if (i==3) {
                    Recentreviewedmoviebyadmin.put(a.user_id,r);
                    System.out.println("----REVIEW ADDED SUCCESSFUlLLY----");
                }
            }
        }
    }
    
    public void Checking_movies_by_Admin_which_is_added_by_viewer(int select){
        if(Recentmovies.isEmpty()){
            System.out.println("NO MOVIES RECENTLY SUGGESTED BY VIEWERS");
        }
        for(Users m:Recentmovies.values()){
            if (m.movie_id == select) {
                Users r = new Users(m.movie_id,m.moviename, m.moviegenre, m.movielanguage,m.movieyear,m.movierating);
                adminselectedmovie++;
                Recentaaddedmoviesapprovedbyadmin.put(adminselectedmovie, r);
                Recentmovies.remove(select);
                System.out.println("----ADDED SUCCESSFULLY----");
                break;
            }
        }
    }
    
    public  void Preaddmovie(Users m){
        Movie.put(m.movie_id,m);
    }

    public void Printtopmovies() {
        for(Users m:Movie.values()){
            System.out.println(m.movie_id+"\t\t"+m.moviename+"\t\t"+m.moviegenre+"\t\t\t"+m.movielanguage+"\t\t\t"+m.movieyear+"\t\t\t"+m.movierating);
        }
        System.out.println("--------------------------------------------------------------------------------");
        movie_id=0;
    }

    public void Preinputmovies(int i){
        if(i==1){
        for ( i = 0; i < 10; i++) {
            Users m = new Users(i + 1, moviesnames[i],moviesgenres[i],moviesyearss[i], movieslanguages[i], moviesratings[i]);
            Preaddmovie(m);
            }
        }
        else{
            for (i = 0; i < 10; i++) {
                Users m = new Users(i + 1, moviesname[i],moviesgenre[i],moviesyears[i], movieslanguage[i], moviesrating[i]);
                Preaddmovie(m);
            }
        }
    }

    public void Calculating_rating(int id,String rating,int i,int option){
        if(option ==1){
            if (i == 2) {
                String prerating = moviesratings[id-1];
                DecimalFormat rating_pattern = new DecimalFormat("#.#");
                float ratin =  ((Float.parseFloat(prerating)+2*(Float.parseFloat((rating))))/2);
                if(ratin > 10){
                    moviesratings[id-1]=String.valueOf(10.0);
                    }
                else{
                moviesratings[id-1]=String.valueOf(rating_pattern.format(ratin));
                }
            }
            else{
                String prerating = moviesratings[id-1];
                DecimalFormat rating_pattern = new DecimalFormat("#.#");
                float ratin = ((Float.parseFloat(prerating)+Float.parseFloat((rating)))/2);
                moviesratings[id-1]=String.valueOf(rating_pattern.format(ratin));
            }
        }
        if(option == 2){
        if (i == 2) {
            String prerating = moviesrating[id-1];
            DecimalFormat rating_pattern = new DecimalFormat("#.#");
            float ratin =  ((Float.parseFloat(prerating)+2*(Float.parseFloat((rating))))/2);
            if(ratin>10){
                moviesrating[id-1]=String.valueOf(10.0);
            }
            else {
                moviesrating[id-1]=String.valueOf( rating_pattern.format(ratin));
            }
        }
        else{
            String prerating = moviesrating[id-1];
            DecimalFormat rating_pattern = new DecimalFormat("#.#");
            float ratin = ((Float.parseFloat(prerating)+Float.parseFloat((rating)))/2);
            moviesrating[id-1]=String.valueOf(rating_pattern.format(ratin));
           }
        }
    }
    
    public void printwholedatabase(Users a,int options){
        Scanner sc = new Scanner(System.in);
        if(Wholereviewsdatabase.isEmpty()){
         System.out.println("NO REVIEWS BY USERS");
            Admin_privilege(a,options);
        }
        System.out.println("USER_ID"+"\t\t"+"TITLE"+"\t\t"+"GENRE"+"\t\t"+"YEAR"+"\t\t"+"LANGUAGE"+"\t\t"+"RATING");
        for(Users m : Wholereviewsdatabase.values()){
            System.out.println(m.user_id-1+"\t\t"+m.moviename+"\t\t"+ m.moviegenre+"\t\t"+ m.movieyear+"\t\t"+ m.movielanguage+"\t\t"+m.movierating);
        }
        System.out.println("FILTER REVIEWS BASED ON USER_ID");
        System.out.println("ENTER USER_ID TO FILTER");
        int id = sc.nextInt();
        Users b = new Users();
        b.Filter_review_based_on_user_id(id);
    }
    
    public void Addviewer(Users a) {
        Viewer.put(a.user_id,a);
        System.out.println("*****  SUCCESSFULLY SIGNED UP  *****");
    }
    
    public void Addcritics(Users a) {
        Critics.put(a.user_id,a);
        System.out.println("*****  SUCCESSFULLY SIGNED UP  *****");
    }

    public void Addadmin(Users a){
        Admin.put(a.user_id,a);
        System.out.println("*****  SUCCESSFULLY SIGNED UP  *****");
    }

    public void Printviewer(Users a,int options) {
        if(Viewer.isEmpty()){
            System.out.println("NO USERS CURRENTLY IN DATABASE");
            Admin_privilege(a,options);
        }
        System.out.println("User_id"+"\t"+"NAME"+"\t"+"PHONENUMBER"+"\t"+"EMAIL");
        for(Users p:Viewer.values()){
            System.out.println(p.user_id+"\t"+p.name+"\t"+p.phone+"\t"+p.email);
        }
        System.out.println("----------------------------");
    }

    public void Printcritics(Users a,int options) {
        if(Critics.isEmpty()){
            System.out.println("NO USERS CURRENTLY IN DATABASE");
            Admin_privilege(a,options);
        }
        System.out.println("User_id"+"\t"+"NAME"+"\t"+"PHONENUMBER"+"\t"+"EMAIL");
        for(Users p:Critics.values()){
            System.out.println(p.user_id+"\t"+p.name+"\t"+p.phone+"\t"+p.email);
        }
        System.out.println("----------------------------");
    }

    public void Printadmin(Users a,int options) {
        if(Admin.isEmpty()){
            System.out.println("NO USERS CURRENTLY IN DATABASE");
            Admin_privilege(a,options);
        }
        System.out.println("User_id"+"\t"+"NAME"+"\t"+"PHONENUMBER"+"\t"+"EMAIL");
        for(Users p:Admin.values()){
            System.out.println(p.user_id+"\t"+p.name+"\t"+p.phone+"\t"+p.email);
        }
        System.out.println("----------------------------");
    }

    public void remove_viewer(int User_id){
        int c=0;
        if(Viewer.isEmpty()){
            System.out.println("NO USERS IN THE SERVER");
        }
        for(Users m : Viewer.values()){
            if(User_id== m.user_id){
                c=1;
                Viewer.remove(m.user_id);
            }
        }
        if(c!=1){
            System.out.println(" NO USER IS IN DATABASE WITH THIS USER_ID");
        }
    }
    
    public void remove_critics(int User_id){
        int c=0;
        if(Critics.isEmpty()){
            System.out.println("NO USERS IN THE SERVER");
        }
        for(Users m : Critics.values()){
            if(User_id== m.user_id){
                c=1;
                Critics.remove(m.user_id);
            }
        }
        if(c!=1){
            System.out.println(" NO USER PRESENT IN DATABASE WITH THIS USER_ID");
        }
    }
    
    public void remove_admin(int User_id){
        int c=0;
        if(Admin.isEmpty()){
            System.out.println("NO USERS IN THE SERVER");
        }
        for(Users m : Admin.values()){
            if(User_id== m.user_id){
                c=1;
                Admin.remove(m.user_id);
            }
        }
        if(c!=1){
            System.out.println(" NO USER PRESENT IN DATABASE WITH THIS USER_ID");
        }
    }

    public void Addmovie(Users m){
        Recentmovies.put(m.movie_id,m);
        System.out.println("----------- ADDED SUCCESSFULLY -----------");
    }

    public void Addmovies_by_critics_and_admin(Users m){
        Recentaaddedmoviesapprovedbyadmin.put(m.movie_id,m);
        System.out.println("----------- ADDED SUCCESSFULLY -----------");
    }

    public void Printrecentaddedmoviesbyadmin(int user_id){
        System.out.println("MOVIE_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" +"\t\t\t" +"LANGUAGE" + "\t\t\t" + "YEAR"+"\t\t\t" + "RATING");
        for( Users m : Recentaaddedmoviesapprovedbyadmin.values()) {
            System.out.println(m.movie_id + "\t\t\t\t" + m.moviename + "\t\t" + m.moviegenre + "\t\t\t" + m.movielanguage + "\t\t\t" + m.movieyear + "\t\t\t" + m.movierating);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void Printrecentaddedmoviesbyviewer(){
        System.out.println("MOVIE_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t\t" + "YEAR" + "\t\t\t" + "RATING");
        for( Users m : Recentmovies.values()) {
            System.out.println(m.movie_id + "\t\t" + m.moviename + "\t\t" + m.moviegenre + "\t\t\t" + m.movielanguage + "\t\t\t" + m.movieyear + "\t\t\t" + m.movierating);
        }
        System.out.println("--------------------------------------------------------------------------------");
    }

    public void Print_recently_reviewed_movies(int user_id,int i) {
        int co = 0, cq = 0, cc = 0;
        System.out.println(i);
        switch (i) {
            case 1:
            {
                if (Recentreviewedmoviebyviewer.isEmpty()) {
                    System.out.println("NO MOVIE IS RECENTLY REVIEWED");
                    break;
                }
                System.out.println("USER_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t" + "YEAR" + "\t\t\t" + "RATING");
                for (Users m : Recentreviewedmoviebyviewer.values()) {
                    if (user_id == m.user_id - 1) {
                        co = 1;
                        System.out.println(m.user_id - 1 + "\t\t\t" + m.moviename + "\t\t" + m.moviegenre + "\t\t\t" + m.movielanguage + "\t\t\t" + m.movieyear + "\t\t\t" + m.movierating);
                    }
                }
                if (co != 1) {
                    System.out.println("NO MOVIES REVIEWED BY USER");
                }
                System.out.println("--------------------------------------------------------------------------------");
                break;
            }
            case 2: {
                if (Recentreviewedmoviebycritics.isEmpty()) {
                    System.out.println("NO MORE RECENTLY REVIEWED");
                    break;
                }
                System.out.println("USER_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t" + "YEAR" + "\t\t\t" + "RATING");
                for (Users m : Recentreviewedmoviebycritics.values()) {
                    if (user_id == m.user_id-1) {
                        cc = 1;
                        System.out.println(m.user_id - 1 + "\t\t\t" + m.moviename + "\t\t" + m.moviegenre + "\t\t\t" + m.movielanguage + "\t\t\t" + m.movieyear + "\t\t\t" + m.movierating);
                    }
                }
                if (cc != 1) {
                    System.out.println("NO MOVIES REVIEWED BY USER");
                }
                System.out.println("--------------------------------------------------------------------------------");
                break;
            }
            case 3: {
                if (Recentreviewedmoviebyadmin.isEmpty()) {
                    System.out.println("NO MOVIE IS RECENTLY REVIEWED");
                    break;
                }
                System.out.println("USER_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t" + "YEAR" + "\t\t\t" + "RATING");
                for (Users m : Recentreviewedmoviebyadmin.values()) {
                    if (user_id == m.user_id-1) {
                        cq = 1;
                        System.out.println(m.user_id - 1 + "\t\t\t" + m.moviename + "\t\t" + m.moviegenre + "\t\t\t" + m.movielanguage + "\t\t\t" + m.movieyear + "\t\t\t" + m.movierating);
                    }
                }
                if (cq != 1) {
                    System.out.println("NO MOVIES REVIEWED BY USER");
                }
                System.out.println("--------------------------------------------------------------------------------");
                break;
            }
        }
    }

    public void Viewer_to_critic_change_checker(Users a){
        if(a.reviewcount>3){
            Critics.put(a.user_id, a);
           remove_viewer(a.user_id);
        }
    }
    
   public void Check_date_before_review(int movie_id,Users a,int i){
        for (Users m:Recentaaddedmoviesapprovedbyadmin.values()) {
            int yearr;
            if (movie_id == m.movie_id) {
                yearr = Integer.parseInt(m.movieyear);
                LocalDate currentdate = LocalDate.now();
                int currentYear = currentdate.getYear();
            if (yearr > currentYear) {
                System.out.println("MOVIE IS NOT RELEASED YET PLEASE TRY AGAIN AFTER SOMETIME");
                Reviewsystem(a,i);
                break;
            }
            else{
                Recentmovies_addreview(a, movie_id,i);
                a.reviewcount++;
                Reviewsystem(a,i);
                break;
            }
          }
        }
      }
      
      public void Filter_review_based_on_user_id(int id){
        int c=0;
        System.out.println("USER_ID" + "\t\t" + "TITLE" + "\t\t" + "GENRE" + "\t\t\t" + "LANGUAGE" + "\t\t" + "YEAR" + "\t\t\t" + "RATING");
        for(Users m : Wholereviewsdatabase.values()){
            if(m.user_id-1==id){
                System.out.println(m.user_id-1+"\t\t"+m.moviename+"\t\t\t"+ m.moviegenre+"\t\t\t"+ m.movieyear+"\t\t\t"+ m.movielanguage+"\t\t\t"+m.movierating);
                c=1;
            }
        }
        if (c!=1){
            System.out.println("NO USER_ID FOUND");
        }
    }
  
    public static void main (String [] args) {
            Users s = new Users();
            s.Start();
        }
}