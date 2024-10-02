package application.gymmanagementsystem;

public class CoachData {


      //    Variable declaration
      private final Integer id;
      private final Integer age;
      private final Integer phone;
      private final String coachId;
      private final String name;
      private final String surname;
      private final String email;

      private final String gender;
      private final String status;

      //    Constructor
      public CoachData(Integer Id, Integer age, Integer phone, String coachId, String name, String surname, String email, String gender, String status) {
            this.id = Id;
            this.age = age;
            this.phone = phone;
            this.coachId = coachId;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.gender = gender;
            this.status = status;

      }

      public Integer getAge() {
            return age;
      }

      public Integer getId() {
            return id;
      }

      public Integer getPhone() {
            return phone;
      }

      public String getCoachId() {
            return coachId;
      }

      public String getName() {
            return name;
      }

      public String getSurname() {
            return surname;
      }

      public String getEmail() {
            return email;
      }

      public String getGender() {
            return gender;
      }

      public String getStatus() {
            return status;
      }


}
