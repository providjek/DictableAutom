package enums;

public enum EndpointEnums {
    HOME("/"),
    RESET_PASS("/auth/resetPassword"),
    PROFILE("/profile");

    String endpoint;

    EndpointEnums(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getEndpoint() {
        return endpoint;
    }
}
