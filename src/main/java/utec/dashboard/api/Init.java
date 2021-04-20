package utec.dashboard.api;

import utec.dashboard.dta.Usuario;

import java.util.ResourceBundle;

import static spark.Spark.get;
import static spark.Spark.port;

public class Init {
    public static void main(String[] args) {
        Usuario user = new Usuario();
//        get("/helloworld", (req, res) -> user.logearUsuarios("edwin.alberto", "p4ssw0rd1234") + req.queryParams("name"));
        port(getHerokuAssignedPort());

        get("/validarUsuario", (req, res) -> {
            String s = user.logearUsuarios(req.queryParams("user"), req.queryParams("pwd"));
            return s;
        });
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
