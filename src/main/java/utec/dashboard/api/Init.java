package utec.dashboard.api;

import utec.dashboard.dta.UsuarioDAO;
import utec.dashboard.utils.JsonTransformer;

import static spark.Spark.*;

public class Init {
    public static void main(String[] args) {
        UsuarioDAO user = new UsuarioDAO();
        port(getHerokuAssignedPort());

        post("/validarUsuario", (req, res) -> {
            return user.logearUsuarios(req.queryParams("user"), req.queryParams("pwd"));
        }, new JsonTransformer());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }

    
}
