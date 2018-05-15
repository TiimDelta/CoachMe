package Delta.CoachMeSpring.auth;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthRequest {
    private String code;
    private String clientId;
    private String redirectUri;
    private String state;
}
