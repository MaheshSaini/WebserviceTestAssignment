package mahesh.webservice.com.webservicetestassignment.activity.network;

import com.android.volley.Request;

/**
 * Returned for each request submitted.
 */
public class RequestHandle {
    private final Request<?> mRequest;

    /**
     * Create a new instance.
     *
     * @param request Request.
     */
    public RequestHandle(Request<?> request) {
        mRequest = request;
    }

    /**
     * Cancel the request.
     */
    public void cancel() {
        mRequest.cancel();
    }
}
