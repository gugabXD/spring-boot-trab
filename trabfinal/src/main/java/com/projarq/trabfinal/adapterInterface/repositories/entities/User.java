import com.projarq.trabfinal.domain.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entitiy
public class User{
    @Id
    private String user;
    private String password;

    public UserModel(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassowrd(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "{" +
            ", user='" + getUser() + "'" +
            ", password='" + getPassword() + "'" +
            "}";
    }

    public static User fromUserModel(UserModel userModel){
        return new Produto(userModel.getUser(),userModel.getPassword());
    }

    public static UserModel toUserModel(User user){
        return new USerModel(user.getUser(),user.getPassword());
    }

}