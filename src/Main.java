import javax.swing.*;

public class Main {
    /**
     * beautiful theme by UIManager.
     */
    public static void main(String[] args) {


        CalculatorGui myCal = new CalculatorGui();
        myCal.add();


     /*   try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // If Nimbus is not available, you can set the GUI to another look and feel.
        }*/
    }
}
