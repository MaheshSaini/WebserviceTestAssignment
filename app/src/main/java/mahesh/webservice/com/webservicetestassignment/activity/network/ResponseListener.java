package mahesh.webservice.com.webservicetestassignment.activity.network;

import com.android.volley.Response;

/**
 * Listener containing callbacks for rest requests.
 *
 * @param <T> type of response object expected.
 */
public interface ResponseListener<T> extends Response.ErrorListener {

    /**
     * Called when a successful response is available.
     *
     * @param responseData response object.
     */
    public void onRestResponse(T responseData);
}
