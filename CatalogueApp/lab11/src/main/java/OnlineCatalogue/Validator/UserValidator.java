package OnlineCatalogue.Validator;

import OnlineCatalogue.Entities.Subject;
import OnlineCatalogue.Entities.User;
import OnlineCatalogue.Manager.Manager;
import org.springframework.http.ResponseEntity;

public class UserValidator {

    public ResponseEntity<?> ValidateId(int id){
        if(!VerifyId(id)){
            return ResponseEntity.badRequest().body("There is no user with id " + id);
        }
        return ResponseEntity.ok("Id found.");
    }

    private boolean VerifyId(int id){
        return Manager.getInstance().getManager().find(User.class, id) != null;
    }
}
