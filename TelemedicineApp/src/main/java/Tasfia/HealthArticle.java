package Tasfia;

    public class HealthArticle {
        private String title;
        private String shortDescription;
        private String fullContent;

        public HealthArticle(String title, String shortDescription, String fullContent) {
            this.title = title;
            this.shortDescription = shortDescription;
            this.fullContent = fullContent;
        }

        public String getTitle() { return title; }
        public String getShortDescription() { return shortDescription; }
        public String getFullContent() { return fullContent; }
    }



