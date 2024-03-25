package tuimobileapptests.datastructure;

import lombok.Getter;

public enum PageTitles {
    LOGIN_PAGE("Login"),
    SAMPLES_LIST_PAGE("Samples List");

    @Getter
    private final String pageTitle;

    PageTitles(String pageTitle) {
        this.pageTitle = pageTitle;
    }
}
