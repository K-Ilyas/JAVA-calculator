import javafx.scene.control.Button;
import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;


public class Functions {

    public static Controller controller = null;

    public static void _init_(Controller controller) {

        Functions.controller = controller;
        System.out.println(controller);
    }
    
    public static void handleClickOperator(Button click) {

        if (Functions.controller.getResult().getText().indexOf("MAX_DIGIT") == -1) {
            if (Functions.controller.getFinall() != 0 || Functions.controller.getFinall() == -1) {
                Functions.controller.getResult().setText(click.getText());
                Functions.controller.getFormula().setText((Functions.controller.getFinall() != -1 ? Functions.controller.getFinall() : 0)
                        + click.getText());
                Functions.controller.setFinall(0);
            } else {
                Functions.controller.getFormula().setText(Functions.controller.getFormula().getText() + Functions.controller.getResult().getText());
                String newresult = Functions.controller.getResult().getText().concat(click.getText())
                        .replaceAll("(.+|\\.)([\\+\\-x\\/]){1}", "$2")
                        .replaceAll("([\\+-x\\/]){1}([\\+-x\\/]){1}", "$2");

                Functions.controller.getResult().setText(newresult);

                String newformula = Functions.controller.getFormula().getText().concat(click.getText())
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
                Functions.controller.getFormula().setText(newformula);
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
            Functions.controller.getResult().setText(click.getText());
            Functions.controller.getFormula().setText("");
            Functions.controller.setFinall(0);
        } else {
            if (Functions.controller.getResult().getText().length() >= 22) {
                String data = Functions.controller.getResult().getText();
                Functions.controller.getResult().setText("MAX_DIGIT");
                setTimeout(() -> Functions.controller.getResult().setText(data), 2000);

            } else if (Functions.controller.getResult().getText() != "MAX_DIGIT") {

                String newresult = Functions.controller.getResult().getText().concat(click.getText())
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
                Functions.controller.getResult().setText(newresult);
                String newformula = Functions.controller.getFormula().getText();
                Functions.controller.getFormula().setText(newformula);

            }
        }
    }

    public static void handleClickResult() {
        if (Functions.controller.getResult().getText().indexOf("MAX_DIGIT") == -1) {
            String newResult = (Functions.controller.getFormula().getText() + Functions.controller.getResult().getText())
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
                        Functions.controller.getResult().setText(Functions.controller.getFinall() + "");
                        Functions.controller.getFormula().setText(newResult + "=" + Functions.controller.getResult().getText());

                        if (Functions.controller.getFinall() == 0) {
                            Functions.controller.setFinall(-1);
                        }
                    } catch (Exception ex) {
                        Functions.controller.getFormula().setText("NAN= NAN");
                        Functions.controller.getResult().setText("NAN");
                        Functions.controller.setFinall(-1);
                    }

                } else {
                    Functions.controller.getFormula().setText("NAN= NAN");
                    Functions.controller.getResult().setText("NAN");
                    Functions.controller.setFinall(-1);
                }
            }
        }
    }

    public static void handleClearFormula() {
        Functions.controller.getResult().setText("0");
        Functions.controller.setFinall(0);
        Functions.controller.getFormula().setText("");
    }

}
