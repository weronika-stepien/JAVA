package application.gymmanagementsystem;

import java.sql.Date;

public class MemberData {


      private final Integer id;
      private final String memberId;
      private final String name;
      private final String surname;
      private final String email;
      private final Integer age;
      private final String address;
      private final String gender;
      private final Integer phone;
      private final String status;
      private final Date startDate;
      private final Date endDate;
      private final String schedule;
      private final Double price;

      public MemberData(Integer id, String memberId, String name, String surname, String email, Integer age, String address, String gender, Integer phone, String status, Date startDate, Date endDate, String schedule, Double price) {
            this.id = id;
            this.memberId = memberId;
            this.name = name;
            this.surname = surname;
            this.email = email;
            this.age = age;
            this.address = address;
            this.gender = gender;
            this.phone = phone;
            this.status = status;
            this.startDate = startDate;
            this.endDate = endDate;
            this.schedule = schedule;
            this.price = price;
      }

      public Integer getId() {
            return id;
      }

      public String getMemberId() {
            return memberId;
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

      public Integer getAge() {
            return age;
      }

      public String getAddress() {
            return address;
      }

      public String getGender() {
            return gender;
      }

      public Integer getPhone() {
            return phone;
      }

      public String getStatus() {
            return status;
      }

      public Date getStartDate() {
            return startDate;
      }

      public Date getEndDate() {
            return endDate;
      }

      public String getSchedule() {
            return schedule;
      }

      public Double getPrice() {
            return price;
      }
}
