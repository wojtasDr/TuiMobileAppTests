package tuimobileapptests.datastructure;

import lombok.Getter;

public enum SampleViews {
    CAROUSEL_VIEW("carousel", "Carousel"),
    DOUBLE_TAP_VIEW("double tap", "Double Tap"),
    DRAG_AND_DROP_VIEW("drag and drop", "Drag & Drop"),
    LONG_PRESS_VIEW("long press", "Long Press"),
    NATIVE_VIEW("native", "Native View"),
    PHOTO_VIEW("photo", "Photo View"),
    SLIDER_VIEW("slider", "Slider"),
    VERTICAL_SWIPING_VIEW("vertical swipe", "Vertical swiping"),
    WEB_VIEW("web", "Web View"),
    WHEEL_PICKER_VIEW("wheel picker", "Wheel Picker");

    @Getter
    private final String viewName;

    @Getter
    private final String viewText;

    SampleViews(String viewName, String viewText) {
        this.viewName = viewName;
        this.viewText = viewText;
    }

//    private static class Constants {
//        public static final String CAROUSEL_VIEW_NAME = "carousel";
//    }
}
