import controller.ControllerMahasiswa;
import view.View;

public class Main {
    public static void main(String[] args) {
        View.setController(new ControllerMahasiswa());
        View.login();
    }
}
