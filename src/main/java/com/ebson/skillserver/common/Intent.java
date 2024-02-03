package com.ebson.skillserver.common;

import lombok.Data;
import java.util.List;
import java.util.Map;

@Data
public class Intent {
    private String id;
    private String name;
    private Extra extra;

    @Data
    public class Extra {
        private Reason reason;
        private Knowledge knowledge;

        @Data
        public class Reason {
            private int code;
            private String message;
        }

        @Data
        public class Knowledge {
            private String responseType;
            private List<MatchedKnowledge> matchedKnowledges;

            @Data
            public class MatchedKnowledge {
                private List<String> categories;
                private String question;
                private String answer;
                private String imageUrl;
                private String landingUrl;
            }
        }
    }
}








