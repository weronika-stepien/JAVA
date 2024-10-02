package application.gymmanagementsystem;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;


import static java.lang.String.valueOf;

public class DashboardController implements Initializable, Maintenance {

      @FXML
      private Button close_button;

      @FXML
      private Button coaches_addButton;

      @FXML
      private TextField coaches_age;
      @FXML
      private TableColumn<CoachData, IntegerProperty> coaches_col_age;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_email;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_gender;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_id;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_name;

      @FXML
      private TableColumn<CoachData, IntegerProperty> coaches_col_phone;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_status;

      @FXML
      private TableColumn<CoachData, StringProperty> coaches_col_surname;

      @FXML
      private Button coaches_deleteButton;

      @FXML
      private TextField coaches_email;

      @FXML
      private AnchorPane coaches_form;

      @FXML
      private ComboBox<?> coaches_gender;

      @FXML
      private TextField coaches_id;

      @FXML
      private TextField coaches_name;

      @FXML
      private TextField coaches_phone;

      @FXML
      private Button coaches_resetButton;

      @FXML
      private ComboBox<?> coaches_status;

      @FXML
      private TextField coaches_surname;

      @FXML
      private TableView<CoachData> coaches_tableView;

      @FXML
      private Button coaches_updateButton;

      @FXML
      private Label dashboard_NC;

      @FXML
      private Label dashboard_NM;

      @FXML
      private Label dashboard_TI;

      @FXML
      private AnchorPane dashboard_form;

      @FXML
      private AreaChart<?, ?> dashboard_incomeChart;

      @FXML
      public Label side_user_name;

      @FXML
      private Button side_dashboardButton;

      @FXML
      private Button side_coachButton;

      @FXML
      private Button side_membersButton;

      @FXML
      private Button side_expensesButton;

      @FXML
      private Button logout_button;

      @FXML
      private AnchorPane main_form;

//    MEMBERS WIDGETS

      @FXML
      private Button members_addButton;

      @FXML
      private TextField members_address;

      @FXML
      private TextField members_age;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_address;

      @FXML
      private TableColumn<MemberData, IntegerProperty> members_col_age;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_email;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_endD;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_gender;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_id;

      @FXML
      private TableColumn<MemberData, IntegerProperty> members_col_phone;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_schedule;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_startD;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_status;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_name;

      @FXML
      private TableColumn<MemberData, StringProperty> members_col_surname;

      @FXML
      private Button members_deleteButton;

      @FXML
      private TextField members_email;

      @FXML
      private DatePicker members_startD;

      @FXML
      private DatePicker members_endD;

      @FXML
      private AnchorPane members_form;

      @FXML
      private ComboBox<?> members_gender;

      @FXML
      private TextField members_membersId;

      @FXML
      private TextField members_name;

      @FXML
      private TextField members_phone;

      @FXML
      private Button members_resetButton;

      @FXML
      private ComboBox<?> members_schedule;

      @FXML
      private ComboBox<?> members_status;

      @FXML
      private TextField members_surname;

      @FXML
      private TableView<MemberData> members_tableView;

      @FXML
      private Button members_updateButton;

      @FXML
      private Button minimize_button;

      @FXML
      private TextField payment_amount;

      @FXML
      private TableColumn<MemberData, StringProperty> payment_col_memberEndD;

      @FXML
      private TableColumn<MemberData, StringProperty> payment_col_memberId;

      @FXML
      private TableColumn<MemberData, StringProperty> payment_col_memberName;

      @FXML
      private TableColumn<MemberData, StringProperty> payment_col_memberStartD;

      @FXML
      private TableColumn<MemberData, StringProperty> payment_col_status;

      @FXML
      private AnchorPane payment_form;

      @FXML
      private ComboBox<?> payment_memberId;

      @FXML
      private ComboBox<?> payment_memberName;

      @FXML
      private Button payment_payButton;

      @FXML
      private TableView<MemberData> payment_tableView;

      @FXML
      private Label payment_total;

      //    Maintenance
      Stage stage;
      Alert alert;
      private int totalDay;
      private double totalPay;
      private double price;
      private int id;

      ObservableList observableList;
      ObservableList<MemberData> memberListData;
      ObservableList<MemberData> paymentListData;

      private final String[] gender = {"Female", "Male", "Other"};
      private final String[] coachStatus = {"Active", "Inactive"};
      private final String[] schedule = {"9 AM - 11 AM", "11:30 AM - 1 PM", "1:30 PM - 3 PM", "3:30 PM - 5 PM", "5:30 PM - 7 PM"};
      private final String[] memberStatus = {"Paid", "Unpaid"};


      //    Database tools;
      private Connection connection;
      private PreparedStatement preparedStatement;
      private ResultSet resultSet;
      private Statement statement;

      String sql;


      /* ----------> MAINTENANCE SETTINGS <--------------- */


      public void setUserName() {
            Maintenance.setUserName(side_user_name);
      }

      public void close() {
            Maintenance.close();
      }

      public void minimize() {
            Maintenance.minimize(stage, main_form);
      }


      public boolean checkMemberFields() {
            boolean answer = members_membersId.getText().isEmpty()
                    || members_name.getText().isEmpty()
                    || members_surname.getText().isEmpty()
                    || members_age.getText().isEmpty()
                    || members_gender.getSelectionModel().isEmpty()
                    || members_status.getSelectionModel().isEmpty()
                    || members_schedule.getSelectionModel().isEmpty()
                    || members_endD.getValue() == null
                    || members_startD.getValue() == null
                    || members_address.getText().isEmpty()
                    || members_email.getText().isEmpty()
                    || members_phone.getText().isEmpty();

            return answer;
      }

      public boolean checkCoachFields() {
            boolean answer = coaches_id.getText().isEmpty()
                    || coaches_name.getText().isEmpty()
                    || coaches_surname.getText().isEmpty()
                    || coaches_age.getText().isEmpty()
                    || coaches_email.getText().isEmpty()
                    || coaches_phone.getText().isEmpty()
                    || coaches_status.getSelectionModel().isEmpty()
                    || coaches_gender.getSelectionModel().isEmpty();

            return answer;
      }

      public void clearFields() {
            coaches_id.setText("");
            coaches_name.setText("");
            coaches_surname.setText("");
            coaches_age.setText("");
            coaches_email.setText("");
            coaches_phone.setText("");
            coaches_status.getSelectionModel().clearSelection();
            coaches_gender.getSelectionModel().clearSelection();

            members_membersId.clear();
            members_name.clear();
            members_surname.clear();
            members_age.clear();
            members_gender.getSelectionModel().clearSelection();
            members_status.getSelectionModel().clearSelection();
            members_schedule.getSelectionModel().clearSelection();
            members_endD.setValue(null);
            members_startD.setValue(null);
            members_address.clear();
            members_email.clear();
            members_phone.clear();
      }


      public void logout() {
            try {
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Are you sure?");
                  alert.setHeaderText(null);
                  alert.setContentText("You're about to logout.");
                  Optional<ButtonType> option = alert.showAndWait();

                  if (option.get().equals(ButtonType.OK)) {
                        Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));

                        stage = new Stage();
                        Scene scene = new Scene(root);

                        Maintenance.customBar(root, stage, scene);

                        stage.setScene(scene);
                        stage.show();

                        //    To hide a dashboard form
                        logout_button.getScene().getWindow().hide();
                  }

            } catch (Exception exception) {
                  exception.printStackTrace();
            }
      }

      public void switchForm(ActionEvent actionEvent) {

            switch (((Button) actionEvent.getSource()).getId()) {
                  case "side_dashboardButton":
                        dashboard_form.setVisible(true);
                        coaches_form.setVisible(false);
                        members_form.setVisible(false);
                        payment_form.setVisible(false);

                        numberOfMembers();
                        numberOfCoaches();
                        todaysIncome();
                        setDashboard_incomeChart();

                        break;

                  case "side_coachButton":
                        dashboard_form.setVisible(false);
                        coaches_form.setVisible(true);
                        members_form.setVisible(false);
                        payment_form.setVisible(false);

                        setCoachGender();
                        setCoachStatus();
                        showCoaches();

                        break;

                  case "side_membersButton":
                        dashboard_form.setVisible(false);
                        coaches_form.setVisible(false);
                        members_form.setVisible(true);
                        payment_form.setVisible(false);

                        showMembers();
                        setMemberGender();
                        setMemberStatus();
                        setMemberSchedule();

                        break;


                  case "side_expensesButton":
                        dashboard_form.setVisible(false);
                        coaches_form.setVisible(false);
                        members_form.setVisible(false);
                        payment_form.setVisible(true);

                        paymentMemberId();
                        paymentName();
                        showPaymentData();

                        break;
            }
      }


      /* -----------> COACHES SETTINGS  <---------- */

      public void addCoaches() {
            sql = "INSERT INTO coach (coachId, name, surname, email, age, gender, phone, status)"
                    + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

            connection = Database.connectDb();


            try {
                  if (coaches_gender.getSelectionModel().getSelectedItem() == null || coaches_status.getSelectionModel().getSelectedItem() == null || checkCoachFields()) {
                        Maintenance.emptyAlert();
                  }
                  else {
                        String checkData = "SELECT coachId FROM coach WHERE coachId = ' " + coaches_id.getText() + " ' ";

                        statement = connection.createStatement();
                        resultSet = statement.executeQuery(checkData);

                        if (resultSet.next()) {
                              Maintenance.errorAlert("Coach Id:" + coaches_id.getText() + " is already existing!");
                        }
                        else {
                              preparedStatement = connection.prepareStatement(sql);
                              preparedStatement.setString(1, coaches_id.getText());
                              preparedStatement.setString(2, coaches_name.getText());
                              preparedStatement.setString(3, coaches_surname.getText());
                              preparedStatement.setString(4, coaches_email.getText());
                              preparedStatement.setString(5, coaches_age.getText());
                              preparedStatement.setString(6, (String) coaches_gender.getSelectionModel().getSelectedItem());
                              preparedStatement.setString(7, coaches_phone.getText());
                              preparedStatement.setString(8, (String) coaches_status.getSelectionModel().getSelectedItem());

                              Maintenance.infoAlert("Successfully Added.");

                              //    To insert all data
                              preparedStatement.executeUpdate();
                              //    To update table view
                              showCoaches();
                              //    To clearFields all fields
                              clearFields();

                        }
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'addCoaches()' method.");
            }

      }

      public void setCoachGender() {
            List<String> genderList = new ArrayList<>();

            Collections.addAll(genderList, gender);

            observableList = FXCollections.observableArrayList(genderList);
            coaches_gender.setItems(observableList);
      }

      public void setCoachStatus() {
            List<String> statusList = new ArrayList<>();

            Collections.addAll(statusList, coachStatus);

            observableList = FXCollections.observableArrayList(statusList);
            coaches_status.setItems(observableList);
      }

      public ObservableList<CoachData> coachesDataList() {
            ObservableList<CoachData> listData = FXCollections.observableArrayList();

            sql = "SELECT * FROM coach";

            connection = Database.connectDb();
            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  CoachData coachData;

                  while (resultSet.next()) {
                        coachData = new CoachData(
                                resultSet.getInt("id"),
                                resultSet.getInt("age"),
                                resultSet.getInt("phone"),
                                resultSet.getString("coachId"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("email"),
                                resultSet.getString("gender"),
                                resultSet.getString("status"));

                        listData.add(coachData);
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'coachesDataList()' method.");
            }

            return listData;
      }

      public void selectCoaches() {
            try {
                  CoachData coachData = coaches_tableView.getSelectionModel().getSelectedItem();
                  int num = coaches_tableView.getSelectionModel().getSelectedIndex();

                  if ((num - 1) < -1) {
                        return;
                  }

                  coaches_id.setText(coachData.getCoachId());
                  coaches_name.setText(coachData.getName());
                  coaches_surname.setText(coachData.getSurname());
                  coaches_email.setText(coachData.getEmail());
                  coaches_age.setText(valueOf(coachData.getAge()));
                  coaches_phone.setText(valueOf(coachData.getPhone()));
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'selectCoaches()' method.");
            }
      }

      public void deleteCoaches() {

            sql = "DELETE FROM coach WHERE coachId = '" + coaches_id.getText() + "'";
            connection = Database.connectDb();

            try {
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Are you sure?");
                  alert.setHeaderText(null);
                  alert.setContentText("Deleting Coach: " + coaches_id.getText());
                  Optional<ButtonType> option = alert.showAndWait();

                  if (option.get().equals(ButtonType.OK)) {
                        preparedStatement.executeUpdate(sql);


                        Maintenance.infoAlert("Successfully Deleted");

                        //    To update table view
                        showCoaches();
                        //    To clearFields all fields
                        clearFields();
                  }
                  else {
                        Maintenance.errorAlert("Deleting Cancelled!");
                  }


            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'deleteCoaches()' method.");
            }
      }

      public void showCoaches() {
            try {
                  ObservableList<CoachData> coachListData = coachesDataList();

                  coaches_col_id.setCellValueFactory(new PropertyValueFactory<>("coachId"));
                  coaches_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                  coaches_col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                  coaches_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
                  coaches_col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
                  coaches_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
                  coaches_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
                  coaches_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));

                  coaches_tableView.setItems(coachListData);
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'showCoaches()' method.");
            }
      }


      public void updateCoaches() {
            sql = "UPDATE coach SET name ='" + coaches_name.getText() + "',surname='" + coaches_surname.getText() + "',email='" + coaches_email.getText() + "',age='" + coaches_age.getText() + "',gender='" + coaches_gender.getSelectionModel().getSelectedItem() + "',phone='" + coaches_phone.getText() + "',status='" + coaches_status.getSelectionModel().getSelectedItem() + "'WHERE coachId='" + coaches_id.getText() + "'";


            connection = Database.connectDb();

            try {
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Are you sure?");
                  alert.setHeaderText(null);
                  alert.setContentText("Updating Coach: " + coaches_id.getText());
                  Optional<ButtonType> option = alert.showAndWait();

                  if (option.get().equals(ButtonType.OK)) {
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.executeUpdate();

                        //    To update table view
                        showCoaches();
                        //    To clearFields all fields
                        clearFields();

                        Maintenance.infoAlert("Successfully Updated");

                  }
                  else {
                        Maintenance.errorAlert("Update Cancelled!");
                  }


            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'updateCoaches()' method.");
            }
      }

      /* --------->       MEMBERS SETTINGS <-------------------   */


      public void addMembers() {
            sql = "INSERT INTO member(memberId, name, surname, email, age, address, gender, phone, status, startDate, endDate, schedule, price) " + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

            connection = Database.connectDb();

            try {
                  if (members_gender.getSelectionModel().getSelectedItem() == null
                          || members_status.getSelectionModel().getSelectedItem() == null
                          || checkMemberFields()
                          || members_schedule.getSelectionModel().getSelectedItem() == null
                          || members_startD.getValue() == null
                          || members_endD.getValue() == null) {
                        Maintenance.emptyAlert();
                  }
                  else {
                        preparedStatement = connection.prepareStatement(sql);

                        String checkData = "SELECT memberId FROM member WHERE memberId = '" + members_membersId.getText() + "'";

                        statement = connection.createStatement();
                        resultSet = statement.executeQuery(checkData);

                        if (resultSet.next()) {
                              Maintenance.errorAlert("Member: " + members_membersId + "already exists!");
                        }
                        else {
                              preparedStatement.setString(1, members_membersId.getText());
                              preparedStatement.setString(2, members_name.getText());
                              preparedStatement.setString(3, members_surname.getText());
                              preparedStatement.setString(4, members_email.getText());
                              preparedStatement.setString(5, members_age.getText());
                              preparedStatement.setString(6, members_address.getText());
                              preparedStatement.setString(7, (String) members_gender.getSelectionModel().getSelectedItem());
                              preparedStatement.setString(8, members_phone.getText());
                              preparedStatement.setString(9, (String) members_status.getSelectionModel().getSelectedItem());
                              preparedStatement.setString(10, String.valueOf(members_startD.getValue()));
                              preparedStatement.setString(11, String.valueOf(members_startD.getValue()));
                              preparedStatement.setString(12, (String) members_schedule.getSelectionModel().getSelectedItem());
                              preparedStatement.setString(13, String.valueOf(price));

                              //    To get the number of days between starting date and ending dade
                              totalDay = (int) ChronoUnit.DAYS.between(members_startD.getValue(), members_endD.getValue());
                              //    How much money does the member need to pay?
                              price = (totalDay * 50);

                              preparedStatement.executeUpdate();

                              Maintenance.infoAlert("Successfully Added.");

                              showMembers();
                              clearFields();

                        }
                  }

            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'addMembers()' method.");
            }
      }

      public void setMemberGender() {
            List<String> genderList = new ArrayList<>();

            Collections.addAll(genderList, gender);

            observableList = FXCollections.observableArrayList(genderList);
            members_gender.setItems(observableList);
      }

      public void setMemberSchedule() {
            List<String> scheduleList = new ArrayList<>();

            Collections.addAll(scheduleList, schedule);

            observableList = FXCollections.observableArrayList(scheduleList);
            members_schedule.setItems(observableList);
      }

      public void setMemberStatus() {
            List<String> statusList = new ArrayList<>();

            Collections.addAll(statusList, memberStatus);

            observableList = FXCollections.observableArrayList(statusList);
            members_status.setItems(observableList);
      }

      public ObservableList<MemberData> memberDataList() {
            ObservableList<MemberData> listData = FXCollections.observableArrayList();

            sql = "SELECT * FROM member";

            connection = Database.connectDb();

            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  MemberData memberData;

                  while (resultSet.next()) {
                        memberData = new MemberData(
                                resultSet.getInt("id"),
                                resultSet.getString("memberId"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("email"),
                                resultSet.getInt("age"),
                                resultSet.getString("address"),
                                resultSet.getString("gender"),
                                resultSet.getInt("phone"),
                                resultSet.getString("status"),
                                resultSet.getDate("startDate"),
                                resultSet.getDate("endDate"),
                                resultSet.getString("schedule"),
                                resultSet.getDouble("price")
                        );

                        listData.add(memberData);
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'memberDataList()' method.");
            }

            return listData;
      }

      public void showMembers() {
            try {
                  memberListData = memberDataList();

                  members_col_id.setCellValueFactory(new PropertyValueFactory<>("memberId"));
                  members_col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
                  members_col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
                  members_col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
                  members_col_age.setCellValueFactory(new PropertyValueFactory<>("age"));
                  members_col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
                  members_col_gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
                  members_col_phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
                  members_col_status.setCellValueFactory(new PropertyValueFactory<>("status"));
                  members_col_startD.setCellValueFactory(new PropertyValueFactory<>("startDate"));
                  members_col_endD.setCellValueFactory(new PropertyValueFactory<>("endDate"));
                  members_col_schedule.setCellValueFactory(new PropertyValueFactory<>("schedule"));

                  members_tableView.setItems(memberListData);

            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'showMembers()' method.");
            }
      }

      public void selectMembers() {
            try {
                  MemberData memberData = members_tableView.getSelectionModel().getSelectedItem();
                  int num = members_tableView.getSelectionModel().getSelectedIndex();

                  if ((num - 1) < -1) {
                        return;
                  }

                  members_membersId.setText(memberData.getMemberId());
                  members_name.setText(memberData.getName());
                  members_surname.setText(memberData.getSurname());
                  members_email.setText(memberData.getEmail());
                  members_age.setText(String.valueOf(memberData.getAge()));
                  members_address.setText(memberData.getAddress());
                  members_phone.setText(String.valueOf(memberData.getPhone()));
                  members_startD.setValue(LocalDate.parse(String.valueOf(memberData.getStartDate())));
                  members_endD.setValue(LocalDate.parse(String.valueOf(memberData.getEndDate())));
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'selectCoaches()' method.");
            }
      }

      public void updateMembers() {
            sql = "UPDATE member SET name ='" + members_name.getText() + "',surname='" + members_surname.getText() + "',email='" + members_email.getText() + "',age='" + members_age.getText() + "',address='" + members_address.getText() + "',gender='" + members_gender.getSelectionModel().getSelectedItem() + "',phone='" + members_phone.getText() + "',status='" + members_status.getSelectionModel().getSelectedItem() + "',startDate='" + members_startD.getValue() + "',endDate='" + members_endD.getValue() + "',schedule='" + members_schedule.getSelectionModel().getSelectedItem() + "',price='" + price + "'WHERE memberId='" + members_membersId.getText() + "'";


            connection = Database.connectDb();

            try {
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Are you sure?");
                  alert.setHeaderText(null);
                  alert.setContentText("Updating Member: " + members_membersId.getText());
                  Optional<ButtonType> option = alert.showAndWait();

                  if (option.get().equals(ButtonType.OK)) {
                        preparedStatement = connection.prepareStatement(sql);
                        preparedStatement.executeUpdate();

                        //    To update table view
                        showMembers();
                        //    To clearFields all fields
                        clearFields();

                        Maintenance.infoAlert("Successfully Updated");

                  }
                  else {
                        Maintenance.errorAlert("Update Cancelled!");
                  }

            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'updateMembers()' method.");
            }
      }

      public void deleteMembers() {
            sql = "DELETE FROM member WHERE memberId = '" + members_membersId.getText() + "'";
            connection = Database.connectDb();

            try {
                  alert = new Alert(Alert.AlertType.CONFIRMATION);
                  alert.setTitle("Are you sure?");
                  alert.setHeaderText(null);
                  alert.setContentText("Deleting Member: " + members_membersId.getText());
                  Optional<ButtonType> option = alert.showAndWait();

                  if (option.get().equals(ButtonType.OK)) {
                        preparedStatement.executeUpdate(sql);


                        Maintenance.infoAlert("Successfully Deleted");

                        //    To update table view
                        showMembers();
                        //    To clearFields all fields
                        clearFields();
                  }
                  else {
                        Maintenance.errorAlert("Deleting Cancelled!");
                  }


            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error occurring at 'deleteMembers()' method.");
            }
      }

      /* ------------------> PAYMENT ZONE <---------------*/

      public ObservableList<MemberData> paymentDataList() {
            ObservableList<MemberData> listData = FXCollections.observableArrayList();

            sql = "SELECT * FROM member";
            connection = Database.connectDb();

            try {
                  MemberData memberData;
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  while (resultSet.next()) {
                        memberData = new MemberData(
                                resultSet.getInt("id"),
                                resultSet.getString("memberId"),
                                resultSet.getString("name"),
                                resultSet.getString("surname"),
                                resultSet.getString("email"),
                                resultSet.getInt("age"),
                                resultSet.getString("address"),
                                resultSet.getString("gender"),
                                resultSet.getInt("phone"),
                                resultSet.getString("status"),
                                resultSet.getDate("startDate"),
                                resultSet.getDate("endDate"),
                                resultSet.getString("schedule"),
                                resultSet.getDouble("price")
                        );
                        listData.add(memberData);
                  }
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'paymentDataList()'.");
            }

            return listData;
      }

      public void showPaymentData() {

            try {
                  ObservableList<MemberData> paymentListData = paymentDataList();

                  payment_col_memberId.setCellValueFactory(new PropertyValueFactory<MemberData, StringProperty>("memberId"));
                  payment_col_memberName.setCellValueFactory(new PropertyValueFactory<MemberData, StringProperty>("name"));
                  payment_col_memberStartD.setCellValueFactory(new PropertyValueFactory<MemberData, StringProperty>("startDate"));
                  payment_col_memberEndD.setCellValueFactory(new PropertyValueFactory<MemberData, StringProperty>("endDate"));
                  payment_col_status.setCellValueFactory(new PropertyValueFactory<MemberData, StringProperty>("status"));

                  payment_tableView.setItems(paymentListData);
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'showPaymentData()'.");
            }
      }

      public void paymentMemberId() {
            sql = "SELECT memberId FROM member";

            connection = Database.connectDb();

            try {
                  ObservableList listData = FXCollections.observableArrayList();

                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  while (resultSet.next()) {
                        listData.add(resultSet.getString("memberId"));
                  }

                  payment_memberId.setItems(listData);
                  paymentName();
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'paymentMemberId()'.");
            }
      }

      public void paymentName() {
            sql = "SELECT name FROM member WHERE memberId = '" + payment_memberId.getSelectionModel().getSelectedItem() + "'";

            connection = Database.connectDb();
            try {
                  ObservableList listData = FXCollections.observableArrayList();

                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) {
                        listData.add(resultSet.getString("name"));
                  }
                  payment_memberName.setItems(listData);
                  displayTotal();

            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'paymentName()'.");
            }
      }

      public void displayTotal() {
            sql = "SELECT price FROM member WHERE name='" + payment_memberName.getSelectionModel().getSelectedItem() + "'AND memberId='" + payment_memberId.getSelectionModel().getSelectedItem() + "'";

            connection = Database.connectDb();
            try {

                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) {
                        totalPay = resultSet.getDouble("price");
                  }

                  payment_total.setText("$" + totalPay);
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'displayTotal()'.");
            }
      }

      /* --------------> DASHBOARD SECTION <---------------*/
      public void numberOfCoaches() {
            sql = "SELECT COUNT(id) FROM coach";

            connection = Database.connectDb();

            int coachesNumber = 0;
            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) {
                        coachesNumber = resultSet.getInt("COUNT(id)");
                  }
                  dashboard_NC.setText(String.valueOf(coachesNumber));
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'numberOfCoachesr()'.");
            }

      }

      public void numberOfMembers() {
            sql = "SELECT COUNT(id) FROM member";

            connection = Database.connectDb();

            int membersNumber = 0;
            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) {
                        membersNumber = resultSet.getInt("COUNT(id)");
                  }
                  dashboard_NM.setText(String.valueOf(membersNumber));
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'numberOfMembers()'.");
            }

      }

      public void todaysIncome() {
            sql = "SELECT SUM(price) FROM member";

            connection = Database.connectDb();

            double todayIncome = 0;
            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  if (resultSet.next()) {
                        todayIncome = resultSet.getInt("SUM(price)");
                  }
                  dashboard_TI.setText(String.valueOf(todayIncome));
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'todaysIncome()'.");
            }


      }

      public void setDashboard_incomeChart() {
            dashboard_incomeChart.getData().clear();

            sql = "SELECT startDate, SUM(price) FROM member GROUP BY startDate ORDER BY TIMESTAMP(startDate) ASC LIMIT 10";
            connection = Database.connectDb();

            XYChart.Series chart = new XYChart.Series<>();

            try {
                  preparedStatement = connection.prepareStatement(sql);
                  resultSet = preparedStatement.executeQuery();

                  while (resultSet.next()) {
                        chart.getData().add(new XYChart.Data(resultSet.getString(1), resultSet.getDouble(2)));
                  }
                  dashboard_incomeChart.getData().add(chart);
            } catch (Exception exception) {
                  exception.printStackTrace();
                  System.out.println("Error at 'setDashboard_incomeChart()'.");
            }


      }


      @Override
      public void initialize(URL url, ResourceBundle resourceBundle) {
            //    DASHBOARD SECTION
            numberOfMembers();
            numberOfCoaches();
            todaysIncome();
            setDashboard_incomeChart();

            //    COACHES SECTION
            showCoaches();
            setCoachGender();
            setCoachStatus();

            //    MEMBERS SECTION
            showMembers();
            setMemberGender();
            setMemberStatus();
            setMemberSchedule();

            //    PAYMENT SECTION
            displayTotal();
            showPaymentData();
            paymentMemberId();
            paymentName();


      }

}



