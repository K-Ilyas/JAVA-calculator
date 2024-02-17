
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class Controller {

    double finall = 0;

    @FXML
    private Button clear;

    @FXML
    private TextArea formula;

    @FXML
    private TextField result;

    @FXML
    private Button divi;

    @FXML
    private Button eight;

    @FXML
    private Button equal;

    @FXML
    private Button five;

    @FXML
    private Button four;

    @FXML
    private Button minus;

    @FXML
    private Button multi;

    @FXML
    private Button nine;

    @FXML
    private Button one;

    @FXML
    private Button plus;

    @FXML
    private Button point;

    @FXML
    private Button seven;

    @FXML
    private Button six;

    @FXML
    private Button three;

    @FXML
    private Button two;

    @FXML
    private Button zero;

    private Stage mainWindow; // Define mainWindow as a variable of type Stage

    public Controller() {
        Functions._init_( this);
    }

    public TextField getResult() {
        return result;
    }

    public void setResult(TextField result) {
        this.result = result;
    }

    public TextArea getFormula() {
        return formula;
    }

    public void setFormula(TextArea formula) {
        this.formula = formula;
    }

    public void setMainWindow(Stage mainWindow) {
        this.mainWindow = mainWindow;
        Functions._init_(this);

    }

    public static void someMethod() {
        System.out.println("Custom method executed!");
    }


    public void setFinall(double finall) {
        this.finall = finall;
    }

    public double getFinall() {
        return finall;
    }

  

    @FXML
    void handleBtnAction(ActionEvent event) {
        if (event.getSource() == one) {
            System.out.println("HHHHHHHHHHH");

            Functions.handleClickNumbers(one);
        } else if (event.getSource() == two) {
            Functions.handleClickNumbers(two);

        } else if (event.getSource() == three) {
            Functions.handleClickNumbers(three);

        } else if (event.getSource() == four) {
            Functions.handleClickNumbers(four);

        } else if (event.getSource() == five) {
            Functions.handleClickNumbers(five);

        } else if (event.getSource() == six) {
            Functions.handleClickNumbers(six);

        } else if (event.getSource() == seven) {
            Functions.handleClickNumbers(seven);

        } else if (event.getSource() == eight) {
            Functions.handleClickNumbers(eight);

        } else if (event.getSource() == nine) {
            Functions.handleClickNumbers(nine);

        } else if (event.getSource() == zero) {
            Functions.handleClickNumbers(zero);

        } else if (event.getSource() == point) {
            Functions.handleClickNumbers(point);

        } else if (event.getSource() == clear) {
            Functions.handleClearFormula();

        } else if (event.getSource() == plus) {

            Functions.handleClickOperator(plus);
        } else if (event.getSource() == minus) {
            Functions.handleClickOperator(minus);

        } else if (event.getSource() == multi) {
            Functions.handleClickOperator(multi);

        } else if (event.getSource() == divi) {
            Functions.handleClickOperator(divi);
        } else if (event.getSource() == equal) {
            Functions.handleClickResult();
        }

    }

}