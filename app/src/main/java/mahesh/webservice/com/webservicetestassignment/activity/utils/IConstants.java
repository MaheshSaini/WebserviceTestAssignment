package mahesh.webservice.com.webservicetestassignment.activity.utils;

import android.Manifest;

/**
 * Created by Abhishesh on 16-08-2016.
 */
public interface IConstants {
    public int DB_VERSION = 1;
    public String LOGIN_TABLE = "tbl_user_master";
    public String LOGIN_USERID = "userid";
    public String LOGIN_ID = "username";
    public String LOGIN_PASSWORD = "password";
    public String INTRO_SLIDER_BOOL = "intro_slider_bool";
    public String TOKEN = "token";
    public String USERID = "userid";
    public String PATIENT_ID = "patient_id";
    public String NO_OF_NOTIFICATION = "no_of_notification";
    public String APP_CURRENT_VERSION = "app_current_version";
    public String USER_EMAIL = "email";
    public String PATIENT_NAME = "patientName";
    public String MOBILE_NO = "primaryMbNo";
    public String CITY_NAME = "cityName";
    public String CITY_ID = "cityId";
    public String LOCALITY_CITY_ID = "localityId";
    public String LOCALITY_CITY_NAME = "localityName";
    public String HOME_SEARCH_ID = "searchId";
    public String HOME_SEARCH_NAME = "searchName";
    public String LOCATION_LATITUDE = "location_lat";
    public String LOCATION_LONGITUDE = "location_long";
    public String HOME_SEARCH_TYPE = "searchType";
    public String GET_LAT_LONG_URL = "get_lat_long";
    public String GET_LAT_LONG_URL_ADDRESS = "get_lat_long_address";
    public final static String DISTANCE = "distance";
    public String DOCTOR_ID = "doctorId";
    public String CLINIC_ID = "clinicId";
    public String APPOINTMET_DATE = "appointment_date";

    // doctor list master adapter view types
    public int TYPE_DOCTOR_DETAIL = 111;
    public int TYPE_DOCTOR_CLINIC_LIST = 112;
    public int TYPE_ABOUT = 113;
    public int TYPE_REVIEWS = 114;

    // clinic detail master adapter view types
    public int TYPE_CLINIC_DETAIL = 211;
    public int TYPE_CLINIC_SPECIAL_OFFER = 212;
    public int TYPE_DOCTOR_LIST = 213;
    public int TYPE_CLINIC_GALLERY = 214;
    public int TYPE_CLINIC_ABOUT = 215;
    public int TYPE_CLINIC_RECOMMENDATION = 216;
    public int TYPE_CLINIC_FACILITY = 217;
    public int TYPE_CLINIC_REVIEWS = 218;




    int MAX_PASSWORD_LENGTH = 8;
    String AUTH_HEADER_PASSWORD = "w!nt3r(00l";
    String AUTH_HEADER_USERNAME = "admin";
    String email = "email";
    String facebook = "facebook";
    String DATE_FORMAT_DD_MMM_YYYY = "dd MMM yyyy";
    String DATE_FORMAT_HH_MM = "hh:mm";
    String DATE_FORMAT_DD_MMMM_YYYY = "dd MMMM yyyy";
    String PREF_SHOULD_REFRESH = "PREF_SHOULD_REFRESH";
    String EXTRA_LAYOUT_ID = "EXTRA_LAYOUT_ID";
    String MEMBER_TYPE_CHILD = "child";
    String MEMBER_TYPE_PARENT = "parent";
    int DEFAULT_CONNECT_TIMEOUT_MILLIS = 60000;
    int DEFAULT_READ_TIMEOUT_MILLIS = 60000;
    int DEFAULT_WRITE_TIMEOUT_MILLIS = 60000;
    String[] PERMISSIONS_READ_STORAGE = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};
    String[] PERMISSIONS_ACCESS_CAMERA = new String[]{Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};
    String[] PERMISSIONS_WRITE_CALENDAR_EVENT = new String[]{Manifest.permission.READ_CALENDAR, Manifest.permission.WRITE_CALENDAR};
    // String DEFAULT_DATE_FORMAT = "yyyy-mm-dd'T'hh:MM:ss";
    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd'T'HH:mm:ss";
    String PREF_CALENDAR_SYNCED_ON = "PREF_CALENDAR_SYNCED_ON";
    String PREF_SHOULD_SHOW_CALENDAR_SYNC_DIALOG = "PREF_SHOULD_SHOW_CALENDAR_SYNC_DIALOG";
    int PERMISSION_REQUEST_CODE = 1000;

    int MIN_HC_IN_INCHES =  70; // (7)
    int MIN_HC_IN_CMS = 200; // (20)
    int MIN_HEIGHT_IN_INCHES = 110; //(11)
    int MIN_HEIGHT_IN_CMS = 300; //(30)
    int MIN_WEIGHT_IN_LBS = 11; //(1.1)
    int MIN_WEIGHT_IN_KG = 5; //(0.5)
}