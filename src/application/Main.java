package application;
	
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Scanner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.PixelFormat.Type;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Main extends Application {
	MediaRental m = new MediaRental();

	@Override

	public void start(Stage primaryStage) {
		try {
			File myObj = new File("Media.txt");
			if (myObj.length() != 0) {

				try {
					Scanner myReader = new Scanner(myObj);
					while (myReader.hasNext()) {
						String data = myReader.nextLine();
						String[] tokens = data.split(",");
						if (tokens[0].equals("Game")) {
							m.addGame(tokens[1], Integer.parseInt(tokens[2]), tokens[3], Double.parseDouble(tokens[4]));
						}

						else if (tokens[0].equals("Album")) {

							m.addAlbum(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4], tokens[5]);
						} else if (tokens[0].equals("Movie")) {
							m.addMovie(tokens[1], Integer.parseInt(tokens[2]), tokens[3], tokens[4]);
						}
						System.out.println(data);
					}
					myReader.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
			}

			File myObj2 = new File("Cus.txt");
			if (myObj2.length() != 0) {
				try {
					Scanner myReader2 = new Scanner(myObj2);
					while (myReader2.hasNext()) {
						String data = myReader2.nextLine();
						String[] tokens = data.split(",");
						m.addCustomer(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4]);
						for (int i = 5; i < tokens.length; i++) {
							m.AddRented(tokens[2],tokens[i]);

						}

					}
					myReader2.close();
				} catch (FileNotFoundException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}
		}

			BorderPane root = new BorderPane();
			VBox vertical = new VBox();
			ImageView cuc = new ImageView(
					"https://st3.depositphotos.com/4060975/17218/v/950/depositphotos_172182638-stock-illustration-customers-vector-icon.jpg");
			cuc.setFitHeight(150);
			cuc.setFitWidth(150);
			Button c = new Button(null, cuc);
			c.setLayoutX(30);
			ImageView a = new ImageView(
					"https://cdn.xxl.thumbs.canstockphoto.com/entertainmaent-folder-illustration-of-folder-full-of-entertainment-and-cinema-object-eps-vectors_csp8369023.jpg");
			a.setFitHeight(150);
			a.setFitWidth(150);
			Button b2 = new Button(null, a);
			ImageView x = new ImageView("https://cdn-icons-png.flaticon.com/512/609/609753.png");
			x.setFitHeight(150);
			x.setFitWidth(150);
			Button b3 = new Button(null, x);

			vertical.getChildren().addAll(c, b2, b3);
			vertical.setPadding(new Insets(25, 25, 25, 25));
			vertical.setAlignment(Pos.CENTER_LEFT);
			vertical.setSpacing(10);
			root.setLeft(vertical);

			ImageView icon = new ImageView("mh-4-5-video-game-movies-1617651239.jpg");
			Button imgbtn = new Button(null, icon);
			icon.setFitHeight(500);
			icon.setFitWidth(900);
			root.setCenter(imgbtn);
			DropShadow shadow = new DropShadow();
			Text word = new Text("Media Rental System");
			word.setFill(Color.CADETBLUE);
			word.setEffect(shadow);
			word.setFont(Font.font("Verdana", FontWeight.BOLD, FontPosture.ITALIC, 50));
			VBox v = new VBox();

			v.getChildren().addAll(imgbtn, word);
			v.setPadding(new Insets(10, 10, 10, 10));
			v.setAlignment(Pos.CENTER);
			v.setSpacing(20);
			root.setCenter(v);
			root.setStyle("-fx-background-color:LIGHTBLUE");

			Scene Firstscene = new Scene(root, 1000, 450);

			primaryStage.setScene(Firstscene);
			primaryStage.setTitle("Media Rental manger");
			primaryStage.show();
			primaryStage.setMaximized(true);

			c.setOnAction(new EventHandler<ActionEvent>() { //button customer

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

					BorderPane sp = new BorderPane();
					CheckBox p1 = new CheckBox("Add new customer");
					p1.setFont(Font.font(20));
					CheckBox p2 = new CheckBox("Delete customer");
					p2.setFont(Font.font(20));
					CheckBox p3 = new CheckBox("Update Information about Customer");
					p3.setFont(Font.font(20));
					CheckBox p4 = new CheckBox("Search a Customer by id");
					p4.setFont(Font.font(20));
					CheckBox p5 = new CheckBox("Return to main page");
					p5.setFont(Font.font(20));
					VBox v = new VBox();
					v.getChildren().addAll(p1, p2, p3, p4, p5);
					v.setAlignment(Pos.CENTER);
					v.setSpacing(10);
					v.setAlignment(Pos.BASELINE_LEFT);
					v.setPadding(new Insets(100, 50, 100, 150));
					sp.setCenter(v);

					VBox v2 = new VBox();
					ImageView cu = new ImageView(
							"https://st3.depositphotos.com/4060975/17218/v/950/depositphotos_172182638-stock-illustration-customers-vector-icon.jpg");
					cu.setFitHeight(200);
					cu.setFitWidth(200);
					Button cx = new Button(null, cu);

					v2.getChildren().add(cx);
					v2.setAlignment(Pos.CENTER_LEFT);
					v2.setPadding(new Insets(25, 25, 25, 25));
					sp.setLeft(v2);
					sp.setStyle("-fx-background-color:LIGHTBLUE");
					Scene secondScene = new Scene(sp, 1000, 450);
					primaryStage.setScene(secondScene);
					primaryStage.setTitle("Customer");
					primaryStage.setMaximized(false);
					primaryStage.show();
					p1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label l1 = new Label("Customer ID: ");
							l1.setFont(Font.font(25));
							gp.add(l1, 0, 0);

							TextField ID = new TextField();
							ID.setMinSize(70, 30);
							gp.add(ID, 1, 0);
							Label l2 = new Label("Customer Name: ");
							l2.setFont(Font.font(25));
							gp.add(l2, 0, 1);
							TextField name = new TextField();
							name.setMinSize(70, 30);
							name.setDisable(true);
							ID.setOnKeyTyped(e -> {
								name.setDisable(false);
							});
							gp.add(name, 1, 1);
							Label l3 = new Label("Customer Address:");
							l3.setFont(Font.font(25));
							gp.add(l3, 0, 2);
							TextField address = new TextField();
							address.setMinSize(70, 30);
							address.setDisable(true);

							name.setOnKeyTyped(e -> {
								address.setDisable(false);
							});
							gp.add(address, 1, 2);
							Label l4 = new Label("Customer Mobile: ");
							l4.setFont(Font.font(25));
							gp.add(l4, 0, 3);
							TextField number = new TextField();
							number.setMinSize(70, 30);
							number.setDisable(true);
							address.setOnKeyTyped(e -> {
								number.setDisable(false);
							});
							gp.add(number, 1, 3);
							Label l5 = new Label("Customer plan: ");
							l5.setFont(Font.font(25));
							gp.add(l5, 0, 4);
							VBox vcheck1 = new VBox();
							RadioButton ch1 = new RadioButton("Limited");
							ch1.setFont(Font.font(25));
							RadioButton ch2 = new RadioButton("Unlimited");
							ch2.setFont(Font.font(25));
							ToggleGroup t = new ToggleGroup(); // IMPORTANT مشان يتنقل بالخيارات

							ch1.setToggleGroup(t);
							ch2.setToggleGroup(t);
							vcheck1.getChildren().addAll(ch1, ch2);

							vcheck1.setSpacing(10);

							gp.add(vcheck1, 1, 4);
							gp.setAlignment(Pos.CENTER);
							gp.setHgap(5);
							gp.setVgap(15);
							gp.setPadding(new Insets(10, 10, 10, 10));
							root2.setCenter(gp);
							HBox H = new HBox();
							Image icon2 = new Image("Add.png");
							Button add = new Button(null, new ImageView(icon2));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							H.getChildren().addAll(add, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);
							add.setOnAction(e -> {

								if (ch1.isSelected()) {
									Label x = new Label("Limited");
                                            if(m.CustomerID(ID.getText())==0) {
                                            	m.addCustomer(name.getText(), address.getText(), ID.getText(), number.getText(),
            											x.getText());
                                            }
                                            else {
												Label l = new Label("This Customer ID is used!");
												l.setFont(Font.font(20));
												gp.add(l, 0, 5);
												root2.setCenter(gp);
											}
									

									ID.clear();
									name.clear();
									address.clear();
									number.clear();
								}
								if (ch2.isSelected()) {
									Label x = new Label("Unlimited");
									if(m.CustomerID(ID.getText())==0) {
									m.addCustomer(name.getText(), address.getText(), ID.getText(), number.getText(),
											x.getText()); }
									 else {
											Label l = new Label("This Customer ID is used!");
											l.setFont(Font.font(20));
											gp.add(l, 0, 5);
											root2.setCenter(gp);
										}

									ID.clear();
									name.clear();
									address.clear();
									number.clear();
								}

							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(secondScene);
									PrintWriter writer = null;
									String file = "Cus.txt";
									try {
										FileWriter CustomerInfo = new FileWriter(file, false);
										writer = new PrintWriter(CustomerInfo);

									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}

									writer.println(m.getAllCustomersInfo2());

									writer.close();

								}
							});

							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.show();

						}

					});

					p2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub

							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label lb = new Label("Customer ID: ");
							lb.setFont(Font.font(25));
							// gp.add(, 0, 0);
							TextField ID = new TextField();
							ID.setMinSize(70, 30);
							HBox h1 = new HBox();
							h1.getChildren().addAll(lb, ID);
							h1.setAlignment(Pos.CENTER);
							root2.setCenter(h1);
							HBox H = new HBox();
							Image icon1 = new Image("search.png");
							Button Find = new Button(null, new ImageView(icon1));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							H.getChildren().addAll(Find, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);

							Find.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									if (m.CustomerID(ID.getText()) == 1) {
										Label l1 = new Label("Customer ID: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField ID2 = new TextField(String.valueOf(m.CustomerID(ID.getText())));
										ID2.setMinSize(70, 30);
										gp.add(ID2, 1, 0);
										Label l2 = new Label("Customer Name: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField name = new TextField(m.CustomerName(ID.getText()));
										name.setMinSize(70, 30);
										gp.add(name, 1, 1);
										Label l3 = new Label("Customer Address:");
										gp.add(l3, 0, 2);
										l3.setFont(Font.font(25));
										TextField address = new TextField(m.CustomerAddress(ID.getText()));
										address.setMinSize(70, 30);
										gp.add(address, 1, 2);
										Label l4 = new Label("Customer Mobile: ");
										gp.add(l4, 0, 3);
										l4.setFont(Font.font(25));
										TextField MobileNum = new TextField(m.CustomerNumber(ID.getText()));
										MobileNum.setMinSize(70, 30);
										gp.add(MobileNum, 1, 3);
										Label l5 = new Label("Customer Plan: ");
										gp.add(l5, 0, 4);
										l5.setFont(Font.font(25));
										TextField plan = new TextField(m.CustomerPlan(ID.getText()));
										plan.setMinSize(70, 30);
										gp.add(plan, 1, 4);

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);

										Image icon2 = new Image("trash.png");
										Button delete = new Button(null, new ImageView(icon2));

										H.getChildren().addAll(delete);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);

										delete.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												m.removeCustomer(ID.getText());
												PrintWriter writer = null;
												String file = "Cus.txt";
												try {
													FileWriter CustomerInfo = new FileWriter(file, false);
													writer = new PrintWriter(CustomerInfo);

												} catch (FileNotFoundException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}

												writer.println(m.getAllCustomersInfo2());

												writer.close();

											}

										});
									} else {
										Label l1 = new Label("Customer ID: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField ID2 = new TextField(ID.getText());
										ID2.setMinSize(70, 30);
										gp.add(ID2, 1, 0);
										Label l2 = new Label("Customer Name: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField name2 = new TextField("not found");
										name2.setMinSize(70, 30);
										gp.add(name2, 1, 1);
										Label l3 = new Label("Customer Address:");
										gp.add(l3, 0, 2);
										l3.setFont(Font.font(25));

										TextField address2 = new TextField("not found");
										address2.setMinSize(70, 30);
										gp.add(address2, 1, 2);
										Label l4 = new Label("Customer Mobile: ");
										gp.add(l4, 0, 3);
										l4.setFont(Font.font(25));

										TextField MobileNum = new TextField("not found");
										MobileNum.setMinSize(70, 30);
										gp.add(MobileNum, 1, 3);

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
										HBox H = new HBox();

										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));
										// Label lb3 = new Label("Back");
										H.getChildren().add(back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);
										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												primaryStage.setScene(secondScene);
											}

										});
									}

								}

							});

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(secondScene);

								}
							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.setTitle("Remove Customer");
							primaryStage.show();

						}

					});

					p3.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label lb = new Label("Customer ID: ");
							lb.setFont(Font.font(25));
							// gp.add(, 0, 0);
							TextField ID = new TextField();
							ID.setMinSize(70, 30);
							HBox h1 = new HBox();
							h1.getChildren().addAll(lb, ID);
							h1.setAlignment(Pos.CENTER);
							root2.setCenter(h1);

							HBox H = new HBox();
							Image icon1 = new Image("search.png");
							Button search = new Button(null, new ImageView(icon1));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							H.getChildren().addAll(search, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(secondScene);

								}
							});
							search.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if (m.CustomerID(ID.getText()) == 1) {

										Label l1 = new Label("Customer ID: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField ID2 = new TextField(String.valueOf(m.CustomerID(ID.getText())));
										ID2.setMinSize(70, 30);
										gp.add(ID2, 1, 0);

										Label l2 = new Label("Customer Name: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField name = new TextField(m.CustomerName(ID.getText()));
										name.setMinSize(70, 30);
										gp.add(name, 1, 1);

										Label l3 = new Label("Customer Address:");
										gp.add(l3, 0, 2);
										l3.setFont(Font.font(25));
										TextField address = new TextField(m.CustomerAddress(ID.getText()));
										address.setMinSize(70, 30);
										gp.add(address, 1, 2);
										Label l4 = new Label("Customer Mobile: ");
										gp.add(l4, 0, 3);
										l4.setFont(Font.font(25));

										TextField MobileNum = new TextField(m.CustomerNumber(ID.getText()));
										MobileNum.setMinSize(70, 30);
										gp.add(MobileNum, 1, 3);
										Label l5 = new Label("Customer plan: ");
										l5.setFont(Font.font(25));
										gp.add(l5, 0, 4);

										VBox vcheck1 = new VBox();
										RadioButton ch1 = new RadioButton("Limited");
										ch1.setFont(Font.font(25));
										RadioButton ch2 = new RadioButton("Unlimited");
										ch2.setFont(Font.font(25));
										ToggleGroup t = new ToggleGroup(); // IMPORTANT مشان يتنقل بالخيارات
										vcheck1.setSpacing(10);
										ch1.setToggleGroup(t);
										ch2.setToggleGroup(t);
										gp.add(vcheck1, 1, 4);
										vcheck1.getChildren().addAll(ch1, ch2);
										if (m.CustomerPlan(ID.getText()).compareTo("Limited") == 0) {

											ch1.setSelected(true);
											ch2.setSelected(false);
										} else {
											ch1.setSelected(false);
											ch2.setSelected(true);

										}

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);

										HBox H = new HBox();
										Image icon2 = new Image("Files-Edit-file-icon.png");
										Button update = new Button(null, new ImageView(icon2));
										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));
										H.getChildren().addAll(update, back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);

										update.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												VBox vcheck1 = new VBox();
												RadioButton ch1 = new RadioButton("Limited");
												ch1.setFont(Font.font(15));
												RadioButton ch2 = new RadioButton("Unlimited");
												ch2.setFont(Font.font(15));
												ToggleGroup t = new ToggleGroup(); // IMPORTANT مشان يتنقل بالخيارات

												if (ID.getText() != null) {
													m.UpdateID(ID.getText(), ID2.getText());
												}
												if (name.getText() != null) {
													m.UpdateName(ID.getText(), name.getText());
												}
												if (address.getText() != null) {
													m.UpdateAddress(ID.getText(), address.getText());
												}
												if (MobileNum.getText() != null) {
													m.UpdateMobileNum(ID.getText(), MobileNum.getText());
												}
												if (address.getText() != null) {
													m.UpdateAddress(ID.getText(), address.getText());
												}
												if (ch1.isSelected()) {
													Label x = new Label("Limited");
													m.UpdatePlan(ID.getText(), x.getText());
												}
												if (ch2.isSelected()) {
													Label x = new Label("Unlimited");
													m.UpdatePlan(ID.getText(), x.getText());

												}
												PrintWriter writer = null;
												String file = "Cus.txt";
												try {
													FileWriter CustomerInfo = new FileWriter(file, false);
													writer = new PrintWriter(CustomerInfo);

												} catch (FileNotFoundException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												} catch (IOException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}

												writer.println(m.getAllCustomersInfo2());

												writer.close();

											}

										});
										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												primaryStage.setScene(secondScene);

											}

										});

									} else {
										Label l1 = new Label("Customer ID: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										// gp.add(new Label("Customer ID: "), 0, 0);
										TextField ID2 = new TextField(ID.getText());
										ID2.setMinSize(70, 30);
										gp.add(ID2, 1, 0);

										Label l2 = new Label("Customer Name: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField name2 = new TextField("not found");
										name2.setMinSize(70, 30);
										gp.add(name2, 1, 1);

										Label l3 = new Label("Customer Address:");
										gp.add(l3, 0, 2);
										l3.setFont(Font.font(25));
										TextField address2 = new TextField("not found");
										address2.setMinSize(70, 30);
										gp.add(address2, 1, 2);

										Label l5 = new Label("Customer Mobile: ");
										l5.setFont(Font.font(25));
										gp.add(l5, 0, 3);

										TextField MobileNum = new TextField("not found");
										MobileNum.setMinSize(70, 30);
										gp.add(MobileNum, 1, 3);

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
										HBox H = new HBox();

										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));
										// Label lb3 = new Label("Back");
										H.getChildren().add(back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);
										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												primaryStage.setScene(secondScene);

											}

										});
									}

								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450, Color.CORNFLOWERBLUE);
							// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.setTitle("Update");
							primaryStage.show();

						}
					});
					p4.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label lb = new Label("Customer ID: ");
							lb.setFont(Font.font(25));

							TextField ID = new TextField();
							ID.setMinSize(70, 30);
							HBox h1 = new HBox();
							h1.getChildren().addAll(lb, ID);
							h1.setAlignment(Pos.CENTER);
							root2.setCenter(h1);

							HBox H = new HBox();
							Image icon1 = new Image("search.png");
							Button Find = new Button(null, new ImageView(icon1));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							H.getChildren().addAll(Find, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);
							Find.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									if (m.CustomerID(ID.getText()) == 1) {

										Label l1 = new Label("Customer ID: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField ID2 = new TextField(String.valueOf(m.CustomerID(ID.getText())));
										ID2.setMinSize(70, 30);
										gp.add(ID2, 1, 0);

										Label l2 = new Label("Customer Name: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField name = new TextField(m.CustomerName(ID.getText()));
										name.setMinSize(70, 30);
										gp.add(name, 1, 1);

										Label l3 = new Label("Customer Address:");
										gp.add(l3, 0, 2);
										l3.setFont(Font.font(25));
										TextField address = new TextField(m.CustomerAddress(ID.getText()));
										address.setMinSize(70, 30);
										gp.add(address, 1, 2);
										Label l4 = new Label("Customer Mobile: ");
										gp.add(l4, 0, 3);
										l4.setFont(Font.font(25));

										TextField MobileNum = new TextField(m.CustomerNumber(ID.getText()));
										MobileNum.setMinSize(70, 30);
										gp.add(MobileNum, 1, 3);
										Label l5 = new Label("Customer plan: ");
										l5.setFont(Font.font(25));
										gp.add(l5, 0, 4);

										VBox vcheck1 = new VBox();
										RadioButton ch1 = new RadioButton("Limited");
										ch1.setFont(Font.font(25));
										RadioButton ch2 = new RadioButton("Unlimited");
										ch2.setFont(Font.font(25));
										ToggleGroup t = new ToggleGroup(); // IMPORTANT مشان يتنقل بالخيارات
										vcheck1.setSpacing(10);
										ch1.setToggleGroup(t);
										ch2.setToggleGroup(t);
										gp.add(vcheck1, 1, 4);
										vcheck1.getChildren().addAll(ch1, ch2);
										if (m.CustomerPlan(ID.getText()).compareTo("Limited") == 0) {
											ch1.setSelected(true);
											ch2.setSelected(false);
										} else {
											ch1.setSelected(false);
											ch2.setSelected(true);

										}

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
									}
								}
							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub

									primaryStage.setScene(secondScene);

								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450, Color.CORNFLOWERBLUE);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							primaryStage.setTitle("Search Customer");
							primaryStage.show();

						}

					});
					p5.setOnAction(new EventHandler<ActionEvent>() {

						@Override

						public void handle(ActionEvent arg0) {

							primaryStage.setScene(Firstscene);
							primaryStage.setMaximized(true);
						}

					});
				}

			});
			b2.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub

					BorderPane sp = new BorderPane();
					CheckBox p1 = new CheckBox("Add new Media");
					p1.setFont(Font.font(20));
					CheckBox p2 = new CheckBox("Delete Media");
					p2.setFont(Font.font(20));
					CheckBox p3 = new CheckBox("Update Information about Media");
					p3.setFont(Font.font(20));
					CheckBox p4 = new CheckBox("Search a Media by code");
					p4.setFont(Font.font(20));
					CheckBox p5 = new CheckBox("Print All Media information");
					p5.setFont(Font.font(20));
					CheckBox p6 = new CheckBox("Return to main page");
					p6.setFont(Font.font(20));
					VBox v = new VBox();
					v.getChildren().addAll(p1, p2, p3, p4, p5, p6);

					v.setAlignment(Pos.BASELINE_LEFT);
					v.setPadding(new Insets(100, 50, 100, 150));
					v.setSpacing(10);
					sp.setCenter(v);

					ImageView a2 = new ImageView(
							"https://cdn.xxl.thumbs.canstockphoto.com/entertainmaent-folder-illustration-of-folder-full-of-entertainment-and-cinema-object-eps-vectors_csp8369023.jpg");
					a2.setFitHeight(200);
					a2.setFitWidth(200);
					Button b2 = new Button(null, a2);

					VBox v2 = new VBox();
					v2.getChildren().add(b2);
					v2.setAlignment(Pos.CENTER_LEFT);
					v2.setPadding(new Insets(25, 25, 25, 25));
					sp.setLeft(v2);

					sp.setStyle("-fx-background-color:LIGHTBLUE");
					Scene MediaScene = new Scene(sp, 1000, 450);

					primaryStage.setScene(MediaScene);
					primaryStage.setTitle("Media");
					primaryStage.setMaximized(false);
					primaryStage.show();
					p1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							ComboBox<String> c;
							// TODO Auto-generated method stub
							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							c = new ComboBox();
							c.getItems().addAll("Movie", "Game", "Album");
							c.setValue("Select one media");
							// c.setMaxWidth(200);
							c.setMaxSize(250, 300);
							Button select = new Button("Select");
							select.setMinWidth(100);
							// root2.setBottom(select);
							VBox v = new VBox();
							v.getChildren().addAll(c, select);
							v.setAlignment(Pos.CENTER);
							v.setSpacing(10);
							root2.setCenter(v);

							VBox v100 = new VBox();

							Circle r1 = new Circle();
							r1.setRadius(65.0);
							Image image = new Image(
									"https://thumbs.dreamstime.com/b/flat-icon-music-album-color-style-release-discography-musician-artist-193432608.jpg");
							r1.setFill(new ImagePattern(image));
							Circle r2 = new Circle();
							r2.setRadius(65.0);
							Image image2 = new Image(
									"https://thumbs.dreamstime.com/b/big-open-clapper-board-movie-reel-cinema-icon-set-movie-film-elements-flat-design-cinema-movie-time-flat-icons-f-95500226.jpg");
							r2.setFill(new ImagePattern(image2));
							Image image3 = new Image(
									"http://thedailyaztec.com/wp-content/uploads/2021/11/freepikgaming.jpg");
							Circle r3 = new Circle();
							r3.setRadius(65.0);
							r3.setFill(new ImagePattern(image3));
							v100.getChildren().addAll(r1, r2, r3);

							v100.setAlignment(Pos.CENTER_LEFT);
							root2.setLeft(v100);
							VBox v1000 = new VBox();
							Circle r4 = new Circle();
							r4.setRadius(65.0);
							Image image4 = new Image(
									"https://thumbs.dreamstime.com/b/flat-icon-music-album-color-style-release-discography-musician-artist-193432608.jpg");
							r4.setFill(new ImagePattern(image4));
							Circle r5 = new Circle();
							r5.setRadius(65.0);
							Image image5 = new Image(
									"https://thumbs.dreamstime.com/b/big-open-clapper-board-movie-reel-cinema-icon-set-movie-film-elements-flat-design-cinema-movie-time-flat-icons-f-95500226.jpg");
							r5.setFill(new ImagePattern(image5));
							Image image6 = new Image(
									"http://thedailyaztec.com/wp-content/uploads/2021/11/freepikgaming.jpg");
							Circle r6 = new Circle();
							r6.setRadius(65.0);
							r6.setFill(new ImagePattern(image6));
							v1000.getChildren().addAll(r4, r5, r6);

							v1000.setAlignment(Pos.CENTER_RIGHT);
							root2.setRight(v1000);

							HBox h = new HBox();
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							h.getChildren().add(back);
							h.setAlignment(Pos.BOTTOM_CENTER);
							root2.setBottom(h);

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(MediaScene);
								}

							});
							select.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if (c.getValue().equals("Game")) {
										Label l1 = new Label("Media Code: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField code = new TextField();
										code.setMinSize(70, 30);
										gp.add(code, 1, 0);

										Label l2 = new Label("Media Title: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField title = new TextField();
										title.setMinSize(70, 30);
										title.setDisable(true);
										code.setOnKeyTyped(e -> {
											title.setDisable(false);
										});
										gp.add(title, 1, 1);

										Label l3 = new Label("Number of Copies:");
										l3.setFont(Font.font(25));
										gp.add(l3, 0, 2);
										TextField num = new TextField();
										num.setMinSize(70, 30);
										num.setDisable(true);
										title.setOnKeyTyped(e -> {
											num.setDisable(false);
										});
										gp.add(num, 1, 2);
										Label l4 = new Label("Weight: ");
										l4.setFont(Font.font(25));
										gp.add(l4, 0, 3);
										TextField weight = new TextField();
										weight.setMinSize(70, 30);
										weight.setDisable(true);
										num.setOnKeyTyped(e -> {
											weight.setDisable(false);
										});
										gp.add(weight, 1, 3);
										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
										HBox H = new HBox();
										Image icon2 = new Image("Add.png");
										Button add = new Button(null, new ImageView(icon2));
										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));

										ImageView a = new ImageView(
												"https://apptweak-blog.imgix.net/images/2019/02/06/Game%20Card-1.png?auto=format");
										a.setFitHeight(300);
										a.setFitWidth(400);
										Button b2 = new Button(null, a);

										VBox v2 = new VBox();
										v2.getChildren().add(b2);
										v2.setAlignment(Pos.CENTER_LEFT);
										v2.setPadding(new Insets(25, 25, 25, 25));
										root2.setLeft(v2);
										H.getChildren().addAll(add, back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);

										add.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub

												if (m.MediaCode(code.getText()) == 0) {
													m.addGame(title.getText(), Integer.parseInt(num.getText()),
															code.getText(), Double.parseDouble(weight.getText()));
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												} else {
													Label l = new Label("This media code is used!");
													l.setFont(Font.font(20));
													gp.add(l, 0, 4);
													root2.setCenter(gp);
												}
											}

										});
										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												code.clear();
												title.clear();
												num.clear();
												weight.clear();
												primaryStage.setScene(MediaScene);

											}
										});

									}
									if (c.getValue().equals("Album")) {
										Label l1 = new Label("Media Code: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField code = new TextField();
										code.setMinSize(70, 30);
										gp.add(code, 1, 0);
										Label l2 = new Label("Media Title: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField title = new TextField();
										title.setMinSize(70, 30);
										title.setDisable(true);
										code.setOnKeyTyped(e -> {
											title.setDisable(false);
										});
										gp.add(title, 1, 1);
										Label l3 = new Label("Number of Copies: ");
										l3.setFont(Font.font(25));
										gp.add(l3, 0, 2);
										TextField num = new TextField();
										num.setMinSize(70, 30);
										num.setDisable(true);
										title.setOnKeyTyped(e -> {
											num.setDisable(false);
										});
										gp.add(num, 1, 2);
										Label l4 = new Label("Artist: ");
										l4.setFont(Font.font(25));
										gp.add(l4, 0, 3);

										TextField artist = new TextField();
										artist.setMinSize(70, 30);
										artist.setDisable(true);
										num.setOnKeyTyped(e -> {
											artist.setDisable(false);
										});
										gp.add(artist, 1, 3);
										Label l5 = new Label("Songs: ");
										l5.setFont(Font.font(25));
										gp.add(l5, 0, 4);
										TextField songs = new TextField();
										songs.setMinSize(70, 30);
										songs.setDisable(true);
										artist.setOnKeyTyped(e -> {
											songs.setDisable(false);
										});
										gp.add(songs, 1, 4);

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
										ImageView a = new ImageView(
												"https://d1b3667xvzs6rz.cloudfront.net/2021/12/This_Is_Amr_Diab.jpg");
										a.setFitHeight(300);
										a.setFitWidth(400);
										Button b2 = new Button(null, a);

										VBox v2 = new VBox();
										v2.getChildren().add(b2);
										v2.setAlignment(Pos.CENTER_LEFT);
										v2.setPadding(new Insets(25, 25, 25, 25));
										root2.setLeft(v2);
										HBox H = new HBox();
										Image icon2 = new Image("Add.png");
										Button add = new Button(null, new ImageView(icon2));
										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));
										// Label lb1 = new Label("Add");
										// Label lb2 = new Label("Back");
										H.getChildren().addAll(add, back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);

										add.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub

												if (m.MediaCode(code.getText()) == 0) {
													m.addAlbum(title.getText(), Integer.parseInt(num.getText()),
															code.getText(), artist.getText(), songs.getText());
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();

												} else {
													Label l = new Label("This media code is used!");
													l.setFont(Font.font(20));
													gp.add(l, 0, 5);
													root2.setCenter(gp);
												}
											}
										});

										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												code.clear();
												title.clear();
												num.clear();
												artist.clear();
												songs.clear();
												primaryStage.setScene(MediaScene);

											}
										});

									}
									if (c.getValue().equals("Movie")) {
										Label l1 = new Label("Media Code: ");
										l1.setFont(Font.font(25));
										gp.add(l1, 0, 0);
										TextField code = new TextField();
										code.setMinSize(70, 30);
										gp.add(code, 1, 0);

										Label l2 = new Label("Media Title: ");
										l2.setFont(Font.font(25));
										gp.add(l2, 0, 1);
										TextField title = new TextField();
										title.setMinSize(70, 30);
										title.setDisable(true);
										code.setOnKeyTyped(e -> {
											title.setDisable(false);
										});
										gp.add(title, 1, 1);
										Label l3 = new Label("Number of Copies:");
										l3.setFont(Font.font(25));
										gp.add(l3, 0, 2);
										TextField num = new TextField();
										num.setMinSize(70, 30);
										num.setDisable(true);
										title.setOnKeyTyped(e -> {
											num.setDisable(false);
										});
										gp.add(num, 1, 2);
										Label l4 = new Label("Rating: ");
										l4.setFont(Font.font(25));
										gp.add(l4, 0, 3);
										TextField rating = new TextField();
										rating.setMinSize(70, 30);
										rating.setDisable(true);
										num.setOnKeyTyped(e -> {
											rating.setDisable(false);
										});
										gp.add(rating, 1, 3);

										gp.setAlignment(Pos.CENTER);
										gp.setHgap(5);
										gp.setVgap(15);
										gp.setPadding(new Insets(10, 10, 10, 10));
										root2.setCenter(gp);
										ImageView a = new ImageView(
												"https://images-wixmp-ed30a86b8c4ca887773594c2.wixmp.com/i/5709d59b-3714-48af-8db1-6c575d105094/d75o7mx-577c6c0d-2990-4cd8-98f5-8009351b3764.png");
										a.setFitHeight(350);
										a.setFitWidth(400);
										Button b2 = new Button(null, a);
										VBox v2 = new VBox();
										v2.getChildren().add(b2);
										v2.setAlignment(Pos.CENTER_LEFT);
										v2.setPadding(new Insets(25, 25, 25, 25));
										root2.setLeft(v2);
										HBox H = new HBox();
										Image icon2 = new Image("Add.png");
										Button add = new Button(null, new ImageView(icon2));
										Image icon3 = new Image("back.png");
										Button back = new Button(null, new ImageView(icon3));
										H.getChildren().addAll(add, back);
										H.setAlignment(Pos.BOTTOM_CENTER);
										H.setSpacing(30);
										root2.setBottom(H);

										add.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												if (m.MediaCode(code.getText()) == 0) {
													m.addMovie(title.getText(), Integer.parseInt(num.getText()),
															code.getText(), rating.getText());
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();

												} else {
													Label l = new Label("This media code is used!");
													l.setFont(Font.font(20));
													gp.add(l, 0, 4);
													root2.setCenter(gp);
												}
											}

										});
										back.setOnAction(new EventHandler<ActionEvent>() {

											@Override
											public void handle(ActionEvent arg0) {
												// TODO Auto-generated method stub
												code.clear();
												title.clear();
												num.clear();
												rating.clear();
												primaryStage.setScene(MediaScene);

											}
										});

									}

								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450, Color.BLUE);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							// primaryStage.setTitle(Add customer);
							primaryStage.show();

						}
					});
					p2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub

							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							HBox h2 = new HBox();
							Label l = new Label("Media Code: ");
							l.setFont(Font.font(25));
							TextField code = new TextField();
							code.setMinSize(70, 30);
							h2.getChildren().addAll(l, code);
							h2.setAlignment(Pos.CENTER);
							root2.setCenter(h2);

							Image icon1 = new Image("search.png");
							Button Find = new Button(null, new ImageView(icon1));

							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							HBox H = new HBox();
							H.getChildren().addAll(Find, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);
							Find.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									if (m.MediaCode(code.getText()) == 1) {
										if (m.MediaType(code.getText()).compareTo("Movie") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField();
											code2.setMinSize(70, 30);
											code2.setText(code.getText());
											gp.add(code, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField();
											title.setMinSize(70, 30);
											title.setText(m.MediaName(code.getText()));
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											gp.add(num, 1, 2);
											Label l4 = new Label("Rating: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField rating = new TextField(m.MediaRtaing(code.getText()));
											rating.setMinSize(70, 30);
											gp.add(rating, 1, 3);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
											HBox H = new HBox();

											Image icon3 = new Image("back.png");
											Button back = new Button(null, new ImageView(icon3));
											// Label lb1 = new Label("Add");
											Image icon2 = new Image("trash.png");
											Button delete = new Button(null, new ImageView(icon2));
											// Label lb3 = new Label("delete");

											H.getChildren().addAll(back, delete);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);

											delete.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) {
													// TODO Auto-generated method stub
													m.removeMedia(code.getText());
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

											back.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub
													primaryStage.setScene(MediaScene);
												}
											});

										} else if (m.MediaType(code.getText()).compareTo("Game") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField();
											code2.setMinSize(70, 30);
											code2.setText(code.getText());
											gp.add(code, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField();
											title.setMinSize(70, 30);
											title.setText(m.MediaName(code.getText()));
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("weight: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField weight = new TextField(
													String.valueOf(m.MediaWeight(code.getText())));
											weight.setMinSize(70, 30);
											gp.add(weight, 1, 3);

											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
											HBox H = new HBox();
											Image icon3 = new Image("back.png");
											Button back = new Button(null, new ImageView(icon3));
											// Label lb1 = new Label("Add");
											Image icon2 = new Image("trash.png");
											Button delete = new Button(null, new ImageView(icon2));
											// Label lb3 = new Label("delete");

											H.getChildren().addAll(back, delete);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);

											delete.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub

													m.removeMedia(code.getText());
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

											back.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub
													primaryStage.setScene(MediaScene);
												}
											});
										} else if (m.MediaType(code.getText()).compareTo("Album") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField();
											code2.setMinSize(70, 30);
											code2.setText(code.getText());
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField();
											title.setMinSize(70, 30);
											title.setText(m.MediaName(code.getText()));
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField();
											num.setMinSize(70, 30);
											num.setText(String.valueOf(m.MediaCopies(code.getText())));
											gp.add(num, 1, 2);
											Label l4 = new Label("Artist: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField a = new TextField(m.MediaArtist(code.getText()));
											a.setMinSize(70, 30);
											gp.add(a, 1, 3);
											Label l5 = new Label("Songs: ");
											l5.setFont(Font.font(25));
											gp.add(l5, 0, 4);
											TextField songs = new TextField(m.MediaSongs(code.getText()));
											songs.setMinSize(70, 30);
											gp.add(songs, 1, 4);

											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
											HBox H = new HBox();

											Image icon3 = new Image("back.png");
											Button back = new Button(null, new ImageView(icon3));

											Image icon2 = new Image("trash.png");
											Button delete = new Button(null, new ImageView(icon2));

											H.getChildren().addAll(delete, back);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);
											delete.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub

													m.removeMedia(code.getText());
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

											back.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) {
													// TODO Auto-generated method stub
													primaryStage.setScene(MediaScene);

												}
											});
										}

									}

								}
							});

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
									primaryStage.setScene(MediaScene);
								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene4 = new Scene(root2, 1000, 450, Color.BLUEVIOLET);
							primaryStage.setScene(scene4);
							primaryStage.show();

						}

					});
					p3.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) { // TODO Auto-generated method stub

							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label lb = new Label("Media Code: ");
							lb.setFont(Font.font(25));
							
							TextField code = new TextField();
							code.setMinSize(70, 30);
							
							HBox h = new HBox();
							h.getChildren().addAll(lb, code);
							h.setAlignment(Pos.CENTER);

							h.setPadding(new Insets(10, 10, 10, 10));
							root2.setCenter(h);
							HBox H = new HBox();

							Image icon1 = new Image("search.png");
							Button Find = new Button(null, new ImageView(icon1));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							
							H.getChildren().addAll(Find, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);

							Find.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
									if (m.MediaCode(code.getText()) == 1) {
										if (m.MediaType(code.getText()).compareTo("Movie") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Rating: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField rating = new TextField(m.MediaRtaing(code.getText()));
											rating.setMinSize(70, 30);
											gp.add(rating, 1, 3);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);

											Image icon2 = new Image("Files-Edit-file-icon.png");
											Button update = new Button(null, new ImageView(icon2));
											H.getChildren().add(update);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);
											update.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub
													if (code.getText() != null) {
														m.UpdateMediaCode(code.getText(), code2.getText());
													}
													if (title.getText() != null) {
														m.UpdateMediaName(code.getText(), title.getText());
													}
													if (num.getText() != null) {
														m.UpdateMediacopies(code.getText(),
																Integer.parseInt(num.getText()));
													}
													if (rating.getText() != null) {
														m.UpdateRating(code.getText(), rating.getText());
													}

													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

										}

										else if (m.MediaType(code.getText()).compareTo("Game") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											code2.setMinSize(70, 30);
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Weight: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField weight = new TextField(
													String.valueOf(m.MediaWeight(code.getText())));
											weight.setMinSize(70, 30);
											gp.add(weight, 1, 3);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);

											Image icon2 = new Image("Files-Edit-file-icon.png");
											Button update = new Button(null, new ImageView(icon2));
											
											H.getChildren().add(update);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);
											update.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) { // TODO Auto-generated method
																						// stub
													if (code.getText() != null) {
														m.UpdateMediaCode(code.getText(), code2.getText());
													}
													if (title.getText() != null) {
														m.UpdateMediaName(code.getText(), title.getText());
													}
													if (num.getText() != null) {
														m.UpdateMediacopies(code.getText(),
																Integer.parseInt(num.getText()));
													}
													if (weight.getText() != null) {
														m.UpdateWeight(code.getText(),
																Double.parseDouble(weight.getText()));
													}
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

										} else if (m.MediaType(code.getText()).compareTo("Album") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											code.setMinSize(70, 30);
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Album: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField artist = new TextField(m.MediaArtist(code.getText()));
											artist.setMinSize(70, 30);
											gp.add(artist, 1, 3);
											Label l5 = new Label("Songs: ");
											l5.setFont(Font.font(25));
											gp.add(l5, 0, 4);
											TextField songs = new TextField(m.MediaSongs(code.getText()));
											songs.setMinSize(70, 30);
											gp.add(songs, 1, 4);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);

											Image icon2 = new Image("Files-Edit-file-icon.png");
											Button update = new Button(null, new ImageView(icon2));
											H.getChildren().add(update);
											H.setAlignment(Pos.BOTTOM_CENTER);
											H.setSpacing(30);
											root2.setBottom(H);
											update.setOnAction(new EventHandler<ActionEvent>() {

												@Override
												public void handle(ActionEvent arg0) {
													// TODO Auto-generated method stub
													if (code.getText() != null) {
														m.UpdateMediaCode(code.getText(), code2.getText());
													}
													if (title.getText() != null) {
														m.UpdateMediaName(code.getText(), title.getText());
													}

													if (num.getText() != null) {
														m.UpdateMediacopies(code.getText(),
																Integer.parseInt(num.getText()));
													}
													if (artist.getText() != null) {
														m.UpdateArtist(code.getText(), artist.getText());
													}
													if (songs.getText() != null) {
														m.UpdateSongs(code.getText(), songs.getText());

													}
													PrintWriter writer = null;
													String file = "Media.txt";
													try {
														FileWriter Info = new FileWriter(file, false);
														writer = new PrintWriter(Info);

													} catch (FileNotFoundException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													} catch (IOException e1) {
														// TODO Auto-generated catch block
														e1.printStackTrace();
													}

													writer.println(m.getAllMediaInfo2());
													writer.close();
												}

											});

										}

									}
								}
							});

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
									primaryStage.setScene(MediaScene);
									System.out.println(m.getAllMediaInfo());
								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene4 = new Scene(root2, 1000, 450, Color.BLUEVIOLET);

							primaryStage.setScene(scene4);
							primaryStage.show();
						}

					});
					p4.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
							BorderPane root2 = new BorderPane();
							GridPane gp = new GridPane(); // matrix
							Label lb = new Label("Media Code: ");
							lb.setFont(Font.font(25));
							
							TextField code = new TextField();
							code.setMinSize(120, 30);
							
							HBox h = new HBox();
							h.getChildren().addAll(lb, code);
							h.setAlignment(Pos.CENTER);

							h.setPadding(new Insets(10, 10, 10, 10));
							root2.setCenter(h);

							HBox H = new HBox();

							Image icon1 = new Image("search.png");
							Button Find = new Button(null, new ImageView(icon1));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							
							H.getChildren().addAll(Find, back);
							H.setAlignment(Pos.BOTTOM_CENTER);
							H.setSpacing(30);
							root2.setBottom(H);

							Find.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									if (m.MediaCode(code.getText()) == 1) {
										if (m.MediaType(code.getText()).compareTo("Movie") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Rating: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField rating = new TextField(m.MediaRtaing(code.getText()));
											rating.setMinSize(70, 30);
											gp.add(rating, 1, 3);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
										} else if (m.MediaType(code.getText()).compareTo("Game") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											code2.setMinSize(70, 30);
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Weight: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField weight = new TextField(
													String.valueOf(m.MediaWeight(code.getText())));
											weight.setMinSize(70, 30);
											gp.add(weight, 1, 3);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
										} else if (m.MediaType(code.getText()).compareTo("Album") == 0) {
											Label l1 = new Label("Media Code: ");
											l1.setFont(Font.font(25));
											gp.add(l1, 0, 0);
											TextField code2 = new TextField(code.getText());
											code.setMinSize(70, 30);
											gp.add(code2, 1, 0);
											Label l2 = new Label("Media title: ");
											l2.setFont(Font.font(25));
											gp.add(l2, 0, 1);
											TextField title = new TextField(m.MediaName(code.getText()));
											title.setMinSize(70, 30);
											gp.add(title, 1, 1);
											Label l3 = new Label("Number of Copies:");
											l3.setFont(Font.font(25));
											gp.add(l3, 0, 2);
											TextField num = new TextField(
													String.valueOf(m.MediaCopies(code.getText())));
											num.setMinSize(70, 30);
											gp.add(num, 1, 2);
											Label l4 = new Label("Album: ");
											l4.setFont(Font.font(25));
											gp.add(l4, 0, 3);
											TextField artist = new TextField(m.MediaArtist(code.getText()));
											artist.setMinSize(70, 30);
											gp.add(artist, 1, 3);
											Label l5 = new Label("Songs: ");
											l5.setFont(Font.font(25));
											gp.add(l5, 0, 4);
											TextField songs = new TextField(m.MediaSongs(code.getText()));
											songs.setMinSize(70, 30);
											gp.add(songs, 1, 4);
											gp.setAlignment(Pos.CENTER);
											gp.setHgap(5);
											gp.setVgap(15);
											gp.setPadding(new Insets(10, 10, 10, 10));
											root2.setCenter(gp);
										}

									}

								}
							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
									primaryStage.setScene(MediaScene);

								}

							});
							root2.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(root2, 1000, 450, Color.BLUE);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);
							// primaryStage.setTitle(Addcustomer);
							primaryStage.show();

						}

					});
					p5.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
							BorderPane b = new BorderPane();
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							Label label = new Label("Media's informations: ");
							label.setFont(Font.font(25));

							TextArea area = new TextArea();
							area.setPrefHeight(20);
							area.setPrefWidth(500);

							area.setStyle("-fx-font-size: 14pt;");
							area.appendText(m.getAllMediaInfo() + "\n");

							HBox h1 = new HBox();
							h1.getChildren().add(area);
							h1.setPadding(new Insets(50, 20, 50, 20));
							h1.setAlignment(Pos.CENTER);
							b.setCenter(h1);

							VBox v = new VBox();
							v.getChildren().addAll(label);
							v.setPadding(new Insets(60, 40, 30, 30));
							v.setAlignment(Pos.TOP_LEFT);
							b.setLeft(v);

							HBox h = new HBox();
							h.getChildren().add(back);
							h.setAlignment(Pos.BOTTOM_CENTER);
							b.setBottom(h);

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method stub
									primaryStage.setScene(MediaScene);
								}

							});
							b.setStyle("-fx-background-color:LIGHTBLUE");
							Scene scene = new Scene(b, 1000, 450, Color.BLUE);
							scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(scene);

							primaryStage.show();

						}

					});
					p6.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) { // TODO Auto-generatedmethod stub
							primaryStage.setScene(Firstscene);
							primaryStage.setMaximized(true);
						}

					});

				}

			});
			b3.setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent arg0) {
					// TODO Auto-generated method stub
					BorderPane sp = new BorderPane();
					CheckBox p1 = new CheckBox("Rent form");
					p1.setFont(Font.font(20));
					CheckBox p2 = new CheckBox("Print interested media");
					p2.setFont(Font.font(20));
					CheckBox p3 = new CheckBox("Print the Rented media");
					p3.setFont(Font.font(20));
					CheckBox p4 = new CheckBox("Return rented media");
					p4.setFont(Font.font(20));
					CheckBox p5 = new CheckBox("Return to main page");
					p5.setFont(Font.font(20));
					VBox v = new VBox();
					v.getChildren().addAll(p1, p2, p3, p4, p5);
					v.setSpacing(10);
					v.setAlignment(Pos.BASELINE_LEFT);
					v.setPadding(new Insets(100, 50, 100, 150));
					v.setSpacing(10);
					sp.setCenter(v);

					ImageView a = new ImageView("https://cdn-icons-png.flaticon.com/512/609/609753.png");
					a.setFitHeight(200);
					a.setFitWidth(200);
					Button b2 = new Button(null, a);
					
					VBox v2 = new VBox();
					v2.getChildren().add(b2);
					v2.setAlignment(Pos.CENTER_LEFT);
					v2.setPadding(new Insets(25, 25, 25, 25));
					sp.setLeft(v2);

					sp.setStyle("-fx-background-color:LIGHTBLUE");

					Scene RentScene = new Scene(sp, 1000, 450);
					
					primaryStage.setScene(RentScene);
					primaryStage.setTitle("Rent");
					primaryStage.setMaximized(false);
					primaryStage.show();

					p1.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root = new BorderPane();
							Label cus = new Label("Customer ID: ");
							cus.setFont(Font.font(25));
							TextField cusId = new TextField();
							cusId.setMinSize(180, 30);
							Button cusInfo = new Button("Customer Information: ");
							Label media = new Label("Media Code: ");
							media.setFont(Font.font(25));
							TextField mediaCode = new TextField();

							mediaCode.setMinSize(180, 30);
							Button mediaInfo = new Button("Media Information: ");
							
							TextArea areaCus = new TextArea();
							areaCus.setPrefColumnCount(15);
							areaCus.setPrefHeight(120);
							areaCus.setPrefWidth(300);
							areaCus.setStyle("-fx-font-size: 10pt;");
							TextArea areaMedia = new TextArea();
							areaMedia.setStyle("-fx-font-size: 10pt;");
							areaMedia.setPrefColumnCount(15);
							areaMedia.setPrefHeight(120);
							areaMedia.setPrefWidth(300);

							Label r = new Label("Rented Date: ");
							r.setFont(Font.font(25));
							Date date = java.util.Calendar.getInstance().getTime();
							TextField r2 = new TextField(date.toString());
							r2.setMinSize(180, 30);
							HBox h0 = new HBox();
							h0.getChildren().addAll(r, r2);
							h0.setSpacing(5);
							HBox h1 = new HBox();
							h1.getChildren().addAll(cus, cusId);
							h1.setSpacing(5);
							HBox h2 = new HBox();
							h2.getChildren().addAll(media, mediaCode);
							h2.setSpacing(5);
							VBox v = new VBox();
							HBox h3 = new HBox();
							h3.getChildren().addAll(cusInfo, areaCus);
							h3.setSpacing(5);
							HBox h4 = new HBox();
							h4.getChildren().addAll(mediaInfo, areaMedia);
							h4.setSpacing(5);
							Image icon2 = new Image("Add.png");
							Button add = new Button(null, new ImageView(icon2));
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));

							Image icon4 = new Image("process.png");
							Button process = new Button(null, new ImageView(icon4));
							
							HBox h5 = new HBox();
							h5.getChildren().addAll(add, process, back);
							h5.setSpacing(30);
							h5.setAlignment(Pos.BOTTOM_CENTER);
							v.setAlignment(Pos.CENTER);
							v.setPadding(new Insets(10, 10, 10, 10));
							v.setSpacing(5);
							v.getChildren().addAll(h1, h3, h2, h4, h0);
							root.setLeft(v);
							root.setBottom(h5);

							HBox x = new HBox();
							ImageView a = new ImageView(
									"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT_6uoO0Je5sP6mmYkqqc-j3bLWRF5WRepI4A&usqp=CAU");
							a.setFitHeight(200);
							a.setFitWidth(250);
							Button b2 = new Button(null, a);
							x.getChildren().add(b2);
							x.setAlignment(Pos.CENTER_LEFT);
							x.setPadding(new Insets(30, 30, 30, 30));
							root.setRight(x);
							cusInfo.setOnAction(e -> {

								areaCus.setText(m.customerinfo(cusId.getText()));
							});
							mediaInfo.setOnAction(e -> {

								areaMedia.setText(m.mediainfo(mediaCode.getText()));

							});
							add.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) { // TODO Auto-generated method
																		// stub

									m.addToCart(cusId.getText(), mediaCode.getText());

								}

							});
							process.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									{
										m.processRequests();
										PrintWriter writer0 = null;
										String file0 = "Rent.txt";
										try {
											FileWriter Info = new FileWriter(file0, false);
											writer0 = new PrintWriter(Info);
									
										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
										writer0.println(m.getAllCustomersInfo());
										writer0.close();

										PrintWriter writer = null;
										String file = "Cus.txt";
										try {
											FileWriter CustomerInfo = new FileWriter(file, false);
											writer = new PrintWriter(CustomerInfo);
											writer.println(m.getAllCustomersInfo2());

											writer.close();

										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

										PrintWriter writer2 = null;
										String file2 = "Media.txt";
										try {
											FileWriter Info2 = new FileWriter(file2, false);
											writer2 = new PrintWriter(Info2);

										} catch (FileNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										} catch (IOException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}

										writer2.println(m.getAllMediaInfo2());
										writer2.close();

									}
								}

							});

							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(RentScene);
									System.out.println(m.getAllCustomersInfo());
								}
							});
							root.setStyle("-fx-background-color:LIGHTBLUE");
							Scene RentFormscene = new Scene(root, 1000, 450, Color.BLUE);
							RentFormscene.getStylesheets()
									.add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(RentFormscene);
							primaryStage.show();

						}

					});
					p2.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub

							BorderPane root = new BorderPane();
							HBox h2 = new HBox();
							Label l = new Label("Customer ID: ");
							l.setFont(Font.font(25));
							TextField code = new TextField();
							code.setMaxSize(180, 30);
							h2.getChildren().addAll(l, code);
							Button select = new Button("Select");
							select.setMaxSize(70, 30);
							VBox v = new VBox();
							v.getChildren().addAll(h2, select);
							v.setPadding(new Insets(10, 10, 10, 10));
							v.setAlignment(Pos.TOP_LEFT);
							TextArea area = new TextArea();
							area.setStyle("-fx-font-size: 14pt;");
							area.setPrefHeight(300);
							area.setPrefWidth(120);
							VBox h1 = new VBox();
							h1.getChildren().add(area);
							h1.setAlignment(Pos.CENTER);
							h1.setPadding(new Insets(50, 50, 50, 50));
							ImageView a = new ImageView(
									"https://media.istockphoto.com/vectors/shopping-cart-with-heart-vector-id918247736?k=20&m=918247736&s=612x612&w=0&h=u323Y5G4ioWXLHNoeNxXgdqkkQrV-16c4mTgtP2KLlc=");
							a.setFitHeight(200);
							a.setFitWidth(250);

							Button b2 = new Button(null, a);
							v.getChildren().add(b2);
							root.setCenter(h1);
							root.setLeft(v);

							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							HBox h3 = new HBox();
							h3.getChildren().add(back);
							h3.setSpacing(10);
							h3.setAlignment(Pos.BOTTOM_CENTER);
							root.setBottom(h3);

							root.setStyle("-fx-background-color:LIGHTBLUE");
							Scene Printscene = new Scene(root, 1000, 450, Color.BLUE);
							Printscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(Printscene);
							primaryStage.show();

							select.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub

									area.appendText(m.CustomerRequested(code.getText()) + "\n");

								}

							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(RentScene);

								}
							});

						}
					});
					p3.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root = new BorderPane();
							HBox h2 = new HBox();
							Label l = new Label("Customer ID: ");
							l.setFont(Font.font(25));
							TextField code = new TextField();
							code.setMaxSize(180, 30);
							h2.getChildren().addAll(l, code);
							Button select = new Button("select");
							select.setMaxSize(70, 30);
							VBox v = new VBox();
							v.getChildren().addAll(h2, select);
							v.setPadding(new Insets(10, 10, 10, 10));
							ImageView a = new ImageView(
									"https://cdn4.vectorstock.com/i/1000x1000/61/98/green-shopping-cart-and-check-mark-icon-vector-27116198.jpg");
							a.setFitHeight(200);
							a.setFitWidth(250);
							Button b2 = new Button(null, a);
							v.getChildren().add(b2);
							v.setAlignment(Pos.TOP_LEFT);
							
							TextArea area = new TextArea();
							;
							area.setStyle("-fx-font-size: 14pt;");
							area.setPrefHeight(300);
							area.setPrefWidth(120);
							VBox h1 = new VBox();
							h1.getChildren().add(area);
							h1.setAlignment(Pos.CENTER);
							h1.setPadding(new Insets(50, 50, 50, 50));
							root.setCenter(h1);
							root.setLeft(v);

							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							HBox h3 = new HBox();
							h3.getChildren().add(back);
							h3.setSpacing(10);
							h3.setAlignment(Pos.BOTTOM_CENTER);
							root.setBottom(h3);
							root.setStyle("-fx-background-color:LIGHTBLUE");
							Scene Printscene = new Scene(root, 1000, 450);
							Printscene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(Printscene);
							primaryStage.show();

							select.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub

									area.appendText(m.CustomerRented(code.getText()) + "\n");
								}

							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(RentScene);

								}
							});
						}

					});
					p4.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub
							BorderPane root = new BorderPane();
							// GridPane p=new GridPane();
							Label cusID = new Label("Customer ID: ");
							cusID.setFont(Font.font(25));
							TextField c = new TextField();
							c.setMaxSize(180, 30);
							HBox h2 = new HBox();
							h2.getChildren().addAll(cusID, c);

							h2.setAlignment(Pos.TOP_LEFT);
							h2.setSpacing(5);
							Button select = new Button("select");
							select.setMaxSize(70, 30);
							VBox v = new VBox();
							v.getChildren().addAll(h2, select);
							v.setPadding(new Insets(10, 10, 10, 10));
							v.setSpacing(5);
							v.setAlignment(Pos.TOP_LEFT);
							root.setLeft(v);
							ImageView a = new ImageView(
									"https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSCFedxmYCCiO0uhb2XwzKednqV8HpbFxR3nmAQzn3qXtI5A940fpGvNoS59euJJq6ygUA&usqp=CAU");
							a.setFitHeight(200);
							a.setFitWidth(250);
							Button b2 = new Button(null, a);
							v.getChildren().add(b2);
							v.setAlignment(Pos.TOP_LEFT);
							TextArea area = new TextArea();
							// area.setPrefColumnCount(15);
							area.setStyle("-fx-font-size: 14pt;");
							area.setPrefHeight(300);
							area.setPrefWidth(120);
							VBox h1 = new VBox();
							h1.getChildren().add(area);
							h1.setAlignment(Pos.CENTER);
							h1.setPadding(new Insets(50, 50, 50, 50));
							root.setCenter(h1);
							Image icon3 = new Image("back.png");
							Button back = new Button(null, new ImageView(icon3));
							HBox h3 = new HBox();
							h3.getChildren().add(back);
							h3.setSpacing(10);
							h3.setAlignment(Pos.BOTTOM_CENTER);
							root.setBottom(h3);
							root.setStyle("-fx-background-color:LIGHTBLUE");
							Scene Returnscene = new Scene(root, 1000, 450, Color.BLUE);
							Returnscene.getStylesheets()
									.add(getClass().getResource("application.css").toExternalForm());
							primaryStage.setScene(Returnscene);
							primaryStage.show();
							select.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub

									area.appendText(m.CustomerRented2(c.getText()) + "\n");
									Label code = new Label("Enter media's code: ");
									code.setFont(Font.font(25));
									TextField c2 = new TextField();
									c2.setMaxSize(70, 30);
									HBox h = new HBox();
									h.getChildren().addAll(code, c2);
									h.setAlignment(Pos.TOP_LEFT);
									h.setSpacing(5);
									Button select2 = new Button("Select");
									select2.setMaxSize(70, 30);
									VBox v2 = new VBox();
									v2.getChildren().addAll(h, select2);
									v2.setSpacing(5);
									v2.setPadding(new Insets(10, 10, 10, 10));

									root.setLeft(v2);
									select2.setOnAction(new EventHandler<ActionEvent>() {

										@Override
										public void handle(ActionEvent arg0) {
											// TODO Auto-generated method stub

											m.returnMedia(c.getText(), c2.getText());
											
											

										}
									});

								}

							});
							back.setOnAction(new EventHandler<ActionEvent>() {

								@Override
								public void handle(ActionEvent arg0) {
									// TODO Auto-generated method stub
									primaryStage.setScene(RentScene);

									
									PrintWriter writer = null;
									String file = "Cus.txt";
									try {
										FileWriter CustomerInfo = new FileWriter(file, false);
										writer = new PrintWriter(CustomerInfo);
										writer.println(m.getAllCustomersInfo2());

										writer.close();

									} catch (FileNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									} catch (IOException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
									
								}
							});

						}

					});
					p5.setOnAction(new EventHandler<ActionEvent>() {

						@Override
						public void handle(ActionEvent arg0) {
							// TODO Auto-generated method stub

							primaryStage.setScene(Firstscene);
							primaryStage.setMaximized(true);
						}
					});

				}
			});

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
