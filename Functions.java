import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Functions {

    public static TextArea formula;
    public static TextField result;
    public static Controller controller = null;

    public static void _init_(TextArea formula, TextField result, Controller controller) {
        Functions.formula = formula;
        Functions.result = result;
        Functions.controller = controller;
    }

    public static void handleClickOperator(Button click) {

        if (result.getText().indexOf("MAX_DIGIT") == -1) {
            if (Functions.controller.getFinall() != 0 || Functions.controller.getFinall() == -1) {
                result.setText(click.getText());
                formula.setText((Functions.controller.getFinall() != -1 ? Functions.controller.getFinall() : 0)
                        + click.getText());
                Functions.controller.setFinall(0);
            } else {
                formula.setText(formula.getText() + result.getText());
                String newresult = result.getText().concat(click.getText())
                        .replaceAll("(.+|\\.)([\\+\\-x\\/]){1}", "$2")
                        .replaceAll("([\\+-x\\/]){1}([\\+-x\\/]){1}", "$2");

                result.setText(newresult);

                String newformula = formula.getText().concat(click.getText())
                        .replaceAll("([-]+)([\\+x\\/]+)", "$2")
                        .replaceAll("^([-]){2,}", "-")
                        .replaceAll("([-]){2,}$", "-")
                        .replaceAll("([\\+]){2,}", "+")
                        .replaceAll("([\\/]){2,}", "/")
                        .replaceAll("([x]){2,}", "x")
                        .replaceAll("([\\+x\\/]){1}([\\-]){1,}$", "$1-")
                        .replaceAll("([\\+x\\/]){1,}([\\+x\\/]){1}$", "$2")
                        .replaceAll("(\\.)(-)", "-")
                        .replaceAll("NAN=\\sNAN", "");
                formula.setText(newformula);
            }
        }
    }

    public static void setTimeout(Runnable runnable, int delayMillis) {
        new Thread(() -> {
            try {
                Thread.sleep(delayMillis);
                runnable.run();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    public static void  handleClickNumbers(Button click) {
        if (Functions.controller.getFinall() != 0 || Functions.controller.getFinall() == -1) {
            result.setText(click.getText());
            formula.setText("");
            Functions.controller.setFinall(0);
        } else {
            if (result.getText().length() >= 22) {
                String data = result.getText();
                result.setText("MAX_DIGIT");
                setTimeout(() -> result.setText(data), 2000);

            } else if (result.getText() != "MAX_DIGIT") {

                String newresult = result.getText().concat(click.getText())
                        .replaceAll("^(\\.)", "0.")
                        .replaceFirst("^(0)(\\d)", "$2")
                        .replaceAll("([\\-+x\\/])", "")
                        .replaceAll("(\\-)(\\.)", "-0.")
                        .replaceAll("^(\\.)$", "0$1")
                        .replaceAll("^(0){2,}", "0")
                        .replaceAll("(\\d)(\\.){2,}", "$1.")
                        .replaceAll("(\\d+)(\\.)(\\d+)(\\.+)", "$1$2$3")
                        .replaceAll("NAN", "0");

                System.out.print(newresult + "        ");
                result.setText(newresult);
                String newformula = formula.getText();
                formula.setText(newformula);

            }
        }
    }

    public static void handleClickResult() {
        if (result.getText().indexOf("MAX_DIGIT") == -1) {
            String newResult = (formula.getText() + result.getText())
                    .replaceAll("x", "*")
                    .replaceAll("--", " - -")
                    .replaceAll("^(\\.)$", "")
                    .replaceFirst("^([\\+\\*\\/]*)", "")
                    .replaceFirst("-$", "")
                    .replaceAll("(\\d+)(\\D*)$", "$1")
                    .replaceAll("=(\\s*)([0-9\\.]*)$", "")
                    .replaceAll("NAN= NAN", "");

            if (Functions.controller.getFinall() == 0) {
                System.out.println(newResult);
                if (!newResult.equals("")) {
                    Expression e = new ExpressionBuilder(newResult).build();

                    try {
                        Functions.controller.setFinall(e.evaluate());
                        result.setText(Functions.controller.getFinall() + "");
                        formula.setText(newResult + "=" + result.getText());

                        if (Functions.controller.getFinall() == 0) {
                            Functions.controller.setFinall(-1);
                        }
                    } catch (Exception ex) {
                        formula.setText("NAN= NAN");
                        result.setText("NAN");
                        Functions.controller.setFinall(-1);
                    }

                } else {
                    formula.setText("NAN= NAN");
                    result.setText("NAN");
                    Functions.controller.setFinall(-1);
                }
            }
        }
    }

    public static void handleClearFormula() {
        result.setText("0");
        Functions.controller.setFinall(0);
        formula.setText("");
    }

}
