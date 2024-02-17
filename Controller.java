
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

    // void handleClickOperator(Button click) {

    // if (result.getText().indexOf("MAX_DIGIT") == -1) {
    // if (finall != 0 || finall == -1) {
    // result.setText(click.getText());
    // formula.setText((finall != -1 ? finall : 0) + click.getText());
    // finall = 0;
    // } else {
    // formula.setText(formula.getText() + result.getText());
    // String newresult = result.getText().concat(click.getText())
    // .replaceAll("(.+|\\.)([\\+\\-x\\/]){1}", "$2")
    // .replaceAll("([\\+-x\\/]){1}([\\+-x\\/]){1}", "$2");

    // result.setText(newresult);

    // String newformula = formula.getText().concat(click.getText())
    // .replaceAll("([-]+)([\\+x\\/]+)", "$2")
    // .replaceAll("^([-]){2,}", "-")
    // .replaceAll("([-]){2,}$", "-")
    // .replaceAll("([\\+]){2,}", "+")
    // .replaceAll("([\\/]){2,}", "/")
    // .replaceAll("([x]){2,}", "x")
    // .replaceAll("([\\+x\\/]){1}([\\-]){1,}$", "$1-")
    // .replaceAll("([\\+x\\/]){1,}([\\+x\\/]){1}$", "$2")
    // .replaceAll("(\\.)(-)", "-")
    // .replaceAll("NAN=\\sNAN", "");
    // formula.setText(newformula);
    // }
    // }
    // }

    public void setFinall(double finall) {
        this.finall = finall;
    }

    public double getFinall() {
        return finall;
    }

    // public static void setTimeout(Runnable runnable, int delayMillis) {
    // new Thread(() -> {
    // try {
    // Thread.sleep(delayMillis);
    // runnable.run();
    // } catch (InterruptedException e) {
    // e.printStackTrace();
    // }
    // }).start();
    // }

    // void handleClickNumbers(Button click) {
    // if (finall != 0 || finall == -1) {
    // result.setText(click.getText());
    // formula.setText("");
    // finall = 0;
    // } else {
    // if (result.getText().length() >= 22) {
    // String data = result.getText();
    // result.setText("MAX_DIGIT");
    // setTimeout(() -> result.setText(data), 2000);

    // } else if (result.getText() != "MAX_DIGIT") {

    // String newresult = result.getText().concat(click.getText())
    // .replaceAll("^(\\.)", "0.")
    // .replaceFirst("^(0)(\\d)", "$2")
    // .replaceAll("([\\-+x\\/])", "")
    // .replaceAll("(\\-)(\\.)", "-0.")
    // .replaceAll("^(\\.)$", "0$1")
    // .replaceAll("^(0){2,}", "0")
    // .replaceAll("(\\d)(\\.){2,}", "$1.")
    // .replaceAll("(\\d+)(\\.)(\\d+)(\\.+)", "$1$2$3")
    // .replaceAll("NAN", "0");

    // System.out.print(newresult + " ");
    // result.setText(newresult);
    // String newformula = formula.getText();
    // formula.setText(newformula);

    // }
    // }
    // }

    // void handleClickResult() {
    // if (result.getText().indexOf("MAX_DIGIT") == -1) {
    // String newResult = (formula.getText() + result.getText())
    // .replaceAll("x", "*")
    // .replaceAll("--", " - -")
    // .replaceAll("^(\\.)$", "")
    // .replaceFirst("^([\\+\\*\\/]*)", "")
    // .replaceFirst("-$", "")
    // .replaceAll("(\\d+)(\\D*)$", "$1")
    // .replaceAll("=(\\s*)([0-9\\.]*)$", "")
    // .replaceAll("NAN= NAN", "");

    // if (finall == 0) {
    // System.out.println(newResult);
    // if (!newResult.equals("")) {
    // Expression e = new ExpressionBuilder(newResult).build();

    // try {
    // finall = e.evaluate();
    // result.setText(finall + "");
    // formula.setText(newResult + "=" + result.getText());

    // if (finall == 0) {
    // finall = -1;
    // }
    // } catch (Exception ex) {
    // formula.setText("NAN= NAN");
    // result.setText("NAN");
    // finall = 0;
    // }

    // } else {
    // formula.setText("NAN= NAN");
    // result.setText("NAN");
    // finall = -1;
    // }
    // }
    // }
    // }

    // void handleClearFormula() {
    // result.setText("0");
    // finall = 0;
    // formula.setText("");
    // }

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