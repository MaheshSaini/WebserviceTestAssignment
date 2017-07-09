package mahesh.webservice.com.webservicetestassignment.activity.network.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Mk6665069 on 12/7/2016.
 */

public class CountryRestResponse {

    @SerializedName("RestResponse")
    @Expose
    private RestResponse restResponse;

    /**
     * @return The restResponse
     */
    public RestResponse getRestResponse() {
        return restResponse;
    }

    /**
     * @param restResponse The RestResponse
     */
    public void setRestResponse(RestResponse restResponse) {
        this.restResponse = restResponse;
    }


    public class RestResponse {

        @SerializedName("messages")
        @Expose
        private List<String> messages = null;
        @SerializedName("result")
        @Expose
        private List<Result> result = null;

        /**
         * @return The messages
         */
        public List<String> getMessages() {
            return messages;
        }

        /**
         * @param messages The messages
         */
        public void setMessages(List<String> messages) {
            this.messages = messages;
        }

        /**
         * @return The result
         */
        public List<Result> getResult() {
            return result;
        }

        /**
         * @param result The result
         */
        public void setResult(List<Result> result) {
            this.result = result;
        }

    }

    public class Result {

        @SerializedName("country")
        @Expose
        private String country;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("abbr")
        @Expose
        private String abbr;
        @SerializedName("area")
        @Expose
        private String area;
        @SerializedName("largest_city")
        @Expose
        private String largestCity;
        @SerializedName("capital")
        @Expose
        private String capital;

        /**
         * @return The country
         */
        public String getCountry() {
            return country;
        }

        /**
         * @param country The country
         */
        public void setCountry(String country) {
            this.country = country;
        }

        /**
         * @return The name
         */
        public String getName() {
            return name;
        }

        /**
         * @param name The name
         */
        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The abbr
         */
        public String getAbbr() {
            return abbr;
        }

        /**
         * @param abbr The abbr
         */
        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }

        /**
         * @return The area
         */
        public String getArea() {
            return area;
        }

        /**
         * @param area The area
         */
        public void setArea(String area) {
            this.area = area;
        }

        /**
         * @return The largestCity
         */
        public String getLargestCity() {
            return largestCity;
        }

        /**
         * @param largestCity The largest_city
         */
        public void setLargestCity(String largestCity) {
            this.largestCity = largestCity;
        }

        /**
         * @return The capital
         */
        public String getCapital() {
            return capital;
        }

        /**
         * @param capital The capital
         */
        public void setCapital(String capital) {
            this.capital = capital;
        }

    }
}
