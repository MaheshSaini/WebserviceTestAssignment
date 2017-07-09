package mahesh.webservice.com.webservicetestassignment.activity.network;

import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.Map;
import java.util.SortedMap;

import mahesh.webservice.com.webservicetestassignment.App;
import mahesh.webservice.com.webservicetestassignment.activity.utils.IConstants;
import mahesh.webservice.com.webservicetestassignment.activity.utils.StringUtils;
import mahesh.webservice.com.webservicetestassignment.activity.utils.Utils;

/**
 * Created by Mahseh Saini
 */
public class RestProcessor {
    public static final RestProcessor INSTANCE = new RestProcessor();
    private static final String TAG = RestProcessor.class.getSimpleName();
    public static final DefaultRetryPolicy DEFAULT_RETRY_POLICY =
            new DefaultRetryPolicy(
                    IConstants.DEFAULT_CONNECT_TIMEOUT_MILLIS,
                    DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                    DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    private Gson mGson;

    public static final Map<String, String> BASIC_AUTH_HEADER = Utils.createBasicAuthHeader(
            IConstants.AUTH_HEADER_USERNAME, IConstants.AUTH_HEADER_PASSWORD);

    private RestProcessor() {
        mGson = new Gson();
    }

    public void clearCache() {
        App.getInstance().getRequestQueue().getCache().clear();
    }

    protected void stop() throws Throwable {
        App.getInstance().getRequestQueue().stop();
    }


    public <T> RequestHandle doGet(
            String endPointUrl,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {
        return doGet(
                BASIC_AUTH_HEADER,
                endPointUrl,
                listener,
                errorListener);
    }

    public <T> RequestHandle doPost(
            String endPointUrl,
            JSONObject requestObject,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {
        return doPost(
                BASIC_AUTH_HEADER,
                endPointUrl,
                requestObject,
                listener,
                errorListener);
    }

    public <T> RequestHandle doDelete(
            String endPointUrl,
            JSONObject requestObject,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {
        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.DELETE, finalUrl, requestObject, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return BASIC_AUTH_HEADER;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doPut(
            String endPointUrl,
            JSONObject requestObject,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {
        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.PUT, finalUrl, requestObject, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return BASIC_AUTH_HEADER;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doGet(
            final Map<String, String> headers,
            String endPointUrl,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {
        //        BuildConfig.API_BASE_URL +
        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(finalUrl, null, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }


    public <T> RequestHandle doDelete(
            final Map<String, String> headers,
            final String endPointUrl,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {

        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.DELETE, finalUrl, null, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }


    public <T> RequestHandle doPost(
            final Map<String, String> headers,
            final String endPointUrl,
            final JSONObject request,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {

        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.POST, finalUrl, request, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doPut(
            final Map<String, String> headers,
            final String endPointUrl,
            final JSONObject request,
            Response.Listener<JSONObject> listener,
            Response.ErrorListener errorListener) {

        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(Request.Method.PUT, finalUrl, request, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doParamsPost(
            final Map<String, String> headers,
            String endPointUrl,
            final SortedMap<String, String> requestParams,
            Response.Listener<String> listener,
            Response.ErrorListener errorListener) {

        final String url = endPointUrl;
        final StringRequest stringRequest =
                new StringRequest(Request.Method.POST, url, listener, errorListener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        return requestParams;
                    }
                };
        stringRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(stringRequest));
    }

    public <T> RequestHandle doGet(
            final Map<String, String> headers,
            String endPointUrl,
            final ResponseListener<T> listener,
            final Class<T> tClass) {

        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(
                        finalUrl,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                final String responseString = String.valueOf(jsonObject);
                                Log.d(TAG, "Response received :: " + responseString);
                                if (StringUtils.isEmpty(responseString)) {
                                    listener.onRestResponse(null);
                                } else {
                                    try {
                                        final T response = mGson.fromJson(responseString, tClass);
                                        if (response != null) {
                                            listener.onRestResponse(response);
                                        } else {
                                            listener.onErrorResponse(new VolleyError("Gson Parsing Error..."));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace(); // TODO: remove before release
                                        listener.onErrorResponse(new VolleyError(e));
                                    }
                                }
                            }
                        },
                        listener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doPost(
            final Map<String, String> headers,
            final String endPointUrl,
            final JSONObject request,
            final ResponseListener<T> listener,
            final Class<T> tClass) {

        final String finalUrl = endPointUrl;
        final JsonObjectRequest jsonObjectRequest =
                new JsonObjectRequest(
                        Request.Method.POST,
                        finalUrl,
                        request,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject jsonObject) {
                                final String responseString = String.valueOf(jsonObject);
                                Log.d(TAG, "Response received :: " + responseString);
                                if (StringUtils.isEmpty(responseString)) {
                                    listener.onRestResponse(null);
                                } else {
                                    try {
                                        final T response = mGson.fromJson(responseString, tClass);
                                        if (response != null) {
                                            listener.onRestResponse(response);
                                        } else {
                                            listener.onErrorResponse(new VolleyError("Gson Parsing Error..."));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace(); // TODO: remove before release
                                        listener.onErrorResponse(new VolleyError(e));
                                    }
                                }
                            }
                        },
                        listener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }
                };
        jsonObjectRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(jsonObjectRequest));
    }

    public <T> RequestHandle doParamsPost(
            final Map<String, String> headers,
            String endPointUrl,
            final SortedMap<String, String> requestParams,
            final ResponseListener<T> listener,
            final Class<T> tClass) {

        final String url = endPointUrl;
        final StringRequest stringRequest =
                new StringRequest(
                        Request.Method.POST,
                        url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String jsonObject) {
                                final String responseString = String.valueOf(jsonObject);
                                Log.d(TAG, "Response received :: " + responseString);
                                if (StringUtils.isEmpty(responseString)) {
                                    listener.onRestResponse(null);
                                } else {
                                    try {
                                        final T response = mGson.fromJson(responseString, tClass);
                                        if (response != null) {
                                            listener.onRestResponse(response);
                                        } else {
                                            listener.onErrorResponse(new VolleyError("Gson Parsing Error..."));
                                        }
                                    } catch (Exception e) {
                                        e.printStackTrace(); // TODO: remove before release
                                        listener.onErrorResponse(new VolleyError(e));
                                    }
                                }
                            }
                        },
                        listener) {
                    @Override
                    public Priority getPriority() {
                        return Priority.HIGH;
                    }

                    @Override
                    public Map<String, String> getHeaders() throws AuthFailureError {
                        return headers;
                    }

                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        return requestParams;
                    }
                };
        stringRequest.setRetryPolicy(DEFAULT_RETRY_POLICY);
        return new RequestHandle(App.getInstance().addToRequestQueue(stringRequest));
    }

}