package peaksoft.dto.response;

import lombok.Builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Builder
public record ChequeFinalResponse(
        String  fullName,
        Set<MenuItemResponse> items,
        int price,
        int service,
        int  globalTotal

) {


}
