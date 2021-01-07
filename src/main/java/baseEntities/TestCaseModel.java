package baseEntities;

import lombok.Value;
import lombok.Builder;

@Value
@Builder
public class TestCaseModel {

    String title;
    String estimate;
    String filePath;
}
