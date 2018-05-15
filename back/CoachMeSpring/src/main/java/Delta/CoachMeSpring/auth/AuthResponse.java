package Delta.CoachMeSpring.auth;

import lombok.Getter;

class AuthResponse {
    @Getter
    String token;

    public AuthResponse(String token) {
        this.token = token;
    }
}
