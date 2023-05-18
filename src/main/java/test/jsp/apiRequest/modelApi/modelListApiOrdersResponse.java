
package test.jsp.apiRequest.modelApi;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author danyr59
 */
@Data
@AllArgsConstructor
@NoArgsConstructor

public class modelListApiOrdersResponse {
    List<modelApiOrderResponse> order;
}
