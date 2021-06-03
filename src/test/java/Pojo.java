import com.fasterxml.jackson.databind.util.JSONPObject;
import org.assertj.core.api.SoftAssertions;

public class Pojo {

    private String User;
    private String password;

    public String getUser() {
        return User;
    }

    public void setUser(String user) {
        User = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    protected SoftAssertions softAssert;

    public String postbody ="{ \"method\": \"POST\" }";


   //public JSONPObject postbody = new JSONPObject();



}
