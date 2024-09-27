package elementPojo;

import io.cucumber.core.internal.com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class HomeScreenElements {
    private Boolean homePageHeader;
    private Boolean loginPageHeader;
}
