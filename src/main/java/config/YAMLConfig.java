package config;

import lombok.Data;

@Data
public class YAMLConfig {

    private Ztrain ztrain;
    private TimeConst timeConst;

    @Data
    public static class Ztrain {
        private String url;
    }
    @Data
    public static class TimeConst {
        private int timeout;
        private int shortWait;
        private  int longWait;
    }
}
