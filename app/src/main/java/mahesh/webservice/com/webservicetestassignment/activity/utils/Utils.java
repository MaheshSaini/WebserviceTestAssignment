package mahesh.webservice.com.webservicetestassignment.activity.utils;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.telephony.TelephonyManager;
import android.util.Base64;
import android.util.Log;
import android.util.Patterns;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import mahesh.webservice.com.webservicetestassignment.R;

public class Utils {

    public static final String JABSTATUS = "JabStstus";
    public static final String JABPOS = "Jabpos";
    public static final String USERIMAGE = "Userimage";
    public static final String ONETIMETIPS = "TIPS";
    public static final String ONEEMAIL = "Email";
    public static final String ONEPASSWORD = "pwd";
    public static final String LENGHTUNIT = "Lenghtunit";
    public static final String WEIGHTUNIT = "weightunit";
    public static final String SCORE = "score";
    public static final String TIMEZONE = "timezone";
    public static final String EMAIL = "Email";
    public static final String MAILSUBSCRIPTION = "MailSubsription";
    public static final String NOTIFICATION = "Notification";
    public static final String CHILDBIRTHDAY = "Childbirthday";
    public static final String SYNC = "synccalender";
    public static final String SYNC_CALENDAR_DATE = "sync_calender_date";
    public static final String SYNC1 = "synccalender1";
    public static final String PREG_LOOP1 = "Pregloop";
    public static final String JABLOC = "Jabloc";
    public static final String JABTYPE = "Jabtype";
    public static final String JABNOTE = "jabnote";
    public static final String JABDOCNAME = "Jandocname";
    public static final String JABFAC = "Jabfacility";
    public static final String DOCID = "docID";
    public static final String JABDATE = "JabDate";
    public static final String CHILDKEY = "Chilkey";
    public static final String TOKEN = "token";
    public static final String LOGINFAMILY = "loginfamily";
    public static final String HHCHILD_ID = "hh_childId";

    public static final String LOGIN_DATA = "logindata";
    public static final String BASIC_SETUP_CONROLLERS = "basicsetup_controllers";
    public static final String BASIC_SETUP_INDEX = "basicsetup_Index";
    public static final String HANDHOLD_CONROLLERS = "handhold_controllers";
    public static final String HANDHOLD_ACTION_INDEX = "handhldActionIndex";
    public static final String LOCATION = "location";
    public static final String MOTHERCOUNT = "MotherCount";
    public static final String ACTION = "action";
    public static final String MEMBER_ID = "member_id";
    public static final String TYPE = "type";
    public static String ONETIME = "first";
    public static final String FAMILYID = "familyId";
    public static final String COUNTRYCODE = "country_code";
    public static final String FIRSTNAME = "firstname";
    public static final String LASTNAME = "lastname";
    public static final String INVITATION_ID = "invitationId";
    public static final String IS_CREATOR = "is_creator";
    public static final String PREG_CHILDCOUNT = "preg_childcount";
    public static final String PREG_NAME = "preg_name";
    public static final String PREG_CHILDCOUNTHH = "HHpreg_childcount";
    public static final String HEIGHT = "Height";
    public static final String WEIGHT = "Weight";
    public static final String BMI = "BMI";
    public static final String PROVIDER = "BMI";
    public static final String HEAD = "Head";
    public static final String MEASURE_ID = "Mid";
    public static final String MEASURE_TIME = "Mtime";
    public static final String JABID = "jabId";
    public static final String JABNAME = "jabName";
    public static final String MILESTONEID = "Milestoneid";
    public static final String ID = "id";
    public static String CREDENTIALS = "Credit";
    private static String encodedCredentials;
    private static int screenWidth = 0;
    private static int screenHeight = 0;
    public static final boolean LOGTAG = true;
    public static int STORAGE_PERMISSION_CODE = 11;
    public static  String DISTANCE = "distance";

//	static String[] suffixes =
//			//    0     1     2     3     4     5     6     7     8     9
//			{ "th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
//					//    10    11    12    13    14    15    16    17    18    19
//					"th", "th", "th", "th", "th", "th", "th", "th", "th", "th",
//					//    20    21    22    23    24    25    26    27    28    29
//					"th", "st", "nd", "rd", "th", "th", "th", "th", "th", "th",
//					//    30    31
//					"th", "st" };

    public static final String INVITATION_DATA = "invitation_data";

    private static String TAG = Utils.class.getSimpleName();

    public static void Log(String className, String str, boolean show) {
        if (show) {

            Log.e(className, str);
        }
    }

    public static boolean isValidEmail(CharSequence target) {
        return target != null && Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public static boolean isValidEmail1(String email) {
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        return pattern.matcher(email).matches();

    }

//    public static SpannableString OneTypface(Context context, String input) {
//        SpannableString s = new SpannableString(input);
//        s.setSpan(new TypefaceSpans(context), 0, s.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
//        return s;
//    }

    public static Map<String, String> createBasicAuthHeader(String username, String password) {
        Map<String, String> headerMap = new HashMap<String, String>();
        String credentials = username + ":" + password;
        encodedCredentials = Base64.encodeToString(credentials.getBytes(), Base64.NO_WRAP);
        headerMap.put("Authorization", "Basic " + encodedCredentials);
        headerMap.put("Content-Type", "application/json; charset=utf-8");
        return headerMap;
    }

//    public static String Mac(Context context) {
//        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
//        WifiInfo wInfo = wifiManager.getConnectionInfo();
//        String macAddress = wInfo.getMacAddress();
//        return macAddress;
//    }

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }

    public static String getBytes(Bitmap bitmap) {
        String imageInBase64 = "";
        try {

            ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArray);
            byte[] byteArr = byteArray.toByteArray();
            imageInBase64 = Base64.encodeToString(byteArr, Base64.NO_WRAP);

        } catch (Exception e) {
            // TODO: handle exception

        }
        return imageInBase64;
    }

    // convert from byte array to bitmap
    public static Bitmap getPhoto(String imagename) {
        byte[] image = Base64.decode(imagename, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(image, 0, image.length);
    }

    public static void setExternalFontsRegular(EditText tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Regular.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsTextViewRegular(TextView tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Regular.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsButtonRegular(Button tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Regular.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsCheckboxRegular(CheckBox tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Regular.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsBold(EditText tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Bold.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsTextViewBold(TextView tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Bold.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsButtonBold(Button tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Bold.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsMedium(EditText tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Medium.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsTextViewMedium(TextView tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Medium.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsButtonMedium(Button tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Medium.otf");
        tv.setTypeface(tf);
    }

    public static void setExternalFontsRD(RadioButton tv, Context cntx) {
        Typeface tf = Typeface.createFromAsset(cntx.getAssets(), "SF-UI-Display-Regular.otf");
        tv.setTypeface(tf);
    }

    public static String DateFormat(String str) throws ParseException {
        if (!str.equals("")) {
            String tempstr = str.substring(0, 10);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.US);
            Date date = format1.parse(tempstr);
            String dayNumberSuffix = getDayNumberSuffix(Integer.parseInt(dayFormat.format(date)));
            SimpleDateFormat format2 = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM yyyy", Locale.US);
            return format2.format(date);
        } else {
            return "";
        }
    }

    public static String TempDateFormat(String str) throws ParseException {
        if (str.length() > 10) {
//			String tempstr = str.substring(0, 10);
            SimpleDateFormat format1 = new SimpleDateFormat(IConstants.DATE_FORMAT_DD_MMM_YYYY, Locale.US);
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.US);
            Date date = format1.parse(str);
            String dayNumberSuffix = getDayNumberSuffix(Integer.parseInt(dayFormat.format(date)));
            SimpleDateFormat format2 = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM yyyy", Locale.US);
            return format2.format(date);
        } else {
            return "";
        }
    }

    public static String DateFormatDDMMYYY(String str) throws ParseException {
        if (str.length() >= 10) {
//			String tempstr = str.substring(0, 10);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.US);
            Date date = format1.parse(str);
            String dayNumberSuffix = getDayNumberSuffix(Integer.parseInt(dayFormat.format(date)));
            SimpleDateFormat format2 = new SimpleDateFormat(" d'" + dayNumberSuffix + "' MMMM yyyy", Locale.US);
            return format2.format(date);
        } else {
            return "";
        }
    }

    public static String currentDate() {
        Calendar c = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat(IConstants.DATE_FORMAT_DD_MMM_YYYY);
        String formattedDate = df.format(c.getTime());
        return formattedDate;
    }

    public static String getDateAsDDMMMMYYYY(@NonNull String dateString) {
        final String formattedDate = getDateInFormat(dateString, IConstants.DATE_FORMAT_DD_MMM_YYYY);
        return formattedDate;
    }

    public static String getDateInFormat(@NonNull String dateString, String fromDateFormat, String toDateFormat) {

        String formattedDate = dateString;
        if (StringUtils.isNotEmpty(dateString)) {
            SimpleDateFormat format = new SimpleDateFormat(fromDateFormat, Locale.US);
            SimpleDateFormat requestedFormat = new SimpleDateFormat(StringUtils.isNotEmpty(toDateFormat) ? toDateFormat : IConstants.DATE_FORMAT_DD_MMM_YYYY, Locale.US);
            final Date date;
            try {
                date = format.parse(dateString);
                formattedDate = requestedFormat.format(date);
            } catch (ParseException e) {
                Log.e(TAG, "Exception while parsing date", e);
            }
        }
        return formattedDate;
    }

    public static String getDateInFormat(@NonNull String dateString, String toDateFormat) {
        String formattedDate = getDateInFormat(dateString, "yyyy-MM-dd", toDateFormat);
        return formattedDate;
    }

    public static void setCalendarDate(@NonNull String dateString, Calendar newCalendar) {

        SimpleDateFormat sdf = new SimpleDateFormat(IConstants.DATE_FORMAT_DD_MMM_YYYY, Locale.US);
        try {
            newCalendar.setTime(sdf.parse(dateString));
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }


    private static String getDayNumberSuffix(int day) {
        if (day >= 11 && day <= 13) {
            return "th";
        }
        switch (day % 10) {
            case 1:
                return "st";
            case 2:
                return "nd";
            case 3:
                return "rd";
            default:
                return "th";
        }
    }

    public static String DateFormatDDMMYYYHHMM(String str) throws ParseException {
        if (str.length() > 10) {
            String tempstr = str.substring(0, 10);
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.US);
            SimpleDateFormat format2 = new SimpleDateFormat(IConstants.DATE_FORMAT_DD_MMM_YYYY, Locale.US);
            Date date = format1.parse(tempstr);
            return format2.format(date);
        } else {
            return "";
        }
    }

    public static void makeAlert(Activity mContext, String string) {
        if (mContext != null && StringUtils.isNotEmpty(string)) {
            final Snackbar snackBar = Snackbar.make(mContext.findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG);
            final View snackBarView = snackBar.getView();
            FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)snackBarView.getLayoutParams();
            params.gravity = Gravity.TOP;
            snackBarView.setLayoutParams(params);
            snackBarView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.colorPrimaryDark));
            snackBar.show();
        }

    }

//    public static void makeAlertGreen(Activity mContext, String string) {
//        if (mContext != null && StringUtils.isNotEmpty(string)) {
//            final Snackbar snackBar = Snackbar.make(mContext.findViewById(android.R.id.content), string, Snackbar.LENGTH_LONG);
//            final View snackBarView = snackBar.getView();
//            snackBarView.setBackgroundColor(ContextCompat.getColor(mContext, R.color.success_alert_color));
//            snackBar.show();
//        }
//    }

    public static int getDiffYears(Date first, Date last) {
        Calendar a = getCalendar(first);
        Calendar b = getCalendar(last);
        int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
        if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH)
                || (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
            diff--;
        }
        return diff;
    }

    private static Calendar getCalendar(Date date) {
        Calendar cal = Calendar.getInstance(Locale.US);
        cal.setTime(date);
        return cal;
    }


    /*public static String getRelativeTime(String dateStr, String formatString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(formatString, Locale.US);
        Date date_updated_at = format.parse(dateStr);
        Calendar currentDate = Calendar.getInstance();

        if (Utils.LOGTAG) {
            Log.e("DAts", date_updated_at + "  1");
            Log.e("DAts2", currentDate.getTime() + "  1");
        }
        Calendar C_date_updated_at = Calendar.getInstance();
        C_date_updated_at.setTime(date_updated_at);
        long diff = currentDate.getTimeInMillis() - C_date_updated_at.getTimeInMillis();
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;

        String relativeDate = "";
        if (days == 0) {
            if (hours == 0) {
                relativeDate = "" + minutes + " minutes ago";
            } else {
                if (hours == 1) {
                    relativeDate = "1" + " hours ago";
                } else {
                    relativeDate = "" + hours + " hours ago";
                }
            }
        } else {
            if (hours == 1) {
                relativeDate = "1" + " day ago";
            } else {
                relativeDate = "" + days + " days ago";
            }
        }
        return relativeDate;

    }
*/

    public static String getRelativeTime(String dateStr, String formatString) throws ParseException {

        SimpleDateFormat format = new SimpleDateFormat(formatString, Locale.US);
        Date date_updated_at = format.parse(dateStr);
        Calendar currentDate = Calendar.getInstance();

        if (Utils.LOGTAG) {
            Log.e("DAts", date_updated_at + "  ");
            Log.e("DAts2", currentDate.getTime() + "  ");
        }
        Calendar c_cal = Calendar.getInstance();
        c_cal.setTime(date_updated_at);
        long diff = currentDate.getTimeInMillis() - c_cal.getTimeInMillis();
        Log.e("diff", diff + "  ");

        long totalyear = 0, totalmonths = 0, totaldays = 0;
        totalyear = diff / 1000 / 3600 / 24 / 365;
        Log.e("totalyear", totalyear + "  ");

        if (totalyear < 0) {
            totalyear = 0;
        }

        totalmonths = (diff - totalyear * 1000 * 3600 * 24 * 365) / 1000 / 3600 / 24 / 30;
        Log.e("totalmonths", totalmonths + "  ");

        if (totalmonths < 0) {
            totalmonths = 0;
        }
        totaldays = (diff - totalyear * 1000 * 3600 * 24 * 365 - totalmonths * 1000 * 3600 * 24 * 30) / 1000 / 3600 / 24;
        Log.e("totaldays", totaldays + "  ");

        if (totaldays < 0) {
            totaldays = 0;
        }

        String dayStr = "day";
        if (totaldays > 1) {
            dayStr = "days";
        }

        String monthStr = "month";
        if (totalmonths > 1) {
            monthStr = "months";
        }

        String yearStr = "year";
        if (totalyear > 1) {
            yearStr = "years";
        }


        String relativeDate = "";
        if (totalyear == 0) {

            if (totalmonths == 0) {
                if (totaldays <= 0) {
                    relativeDate = "Today";
                } else if (totaldays == 1) {
                    relativeDate = "Yesterday";
                } else {
                    relativeDate = "" + totaldays + " " + dayStr + "";
                }
            } else {
                relativeDate = "" + totalmonths + " " + monthStr + " " + totaldays + " " + dayStr;
            }
        } else {
            if (totalmonths == 0) {
                relativeDate = "" + totalyear + " " + yearStr + " " + totaldays + " " + dayStr;
            } else {
                relativeDate = "" + totalyear + " " + yearStr + " " + totalmonths + " " + monthStr + " " + totaldays + " " + dayStr;
            }
        }


        return relativeDate;

    }

    public static String getRelativeTime(String dateStr) throws ParseException {
        String relativeDate = getRelativeTime(dateStr, "yyyy-MM-dd'T'HH:mm:ss");
        return relativeDate;
    }


    public static String getTextRespectiveToNumber(int number) {

        if (number == 1) {
            return "first";
        }

        if (number == 2) {
            return "second";
        }
        if (number == 3) {
            return "third";
        }

        if (number == 4) {
            return "fourth";
        }

        if (number == 5) {
            return "fifth";
        }

        return "next";
    }

//    public static void loadImageWithGlide(@NonNull Context context, @NonNull final String originalUrl, final String alternateUrl, @NonNull final int placeHolder, @NonNull final ImageView imageView) {
//        final RequestManager requestManager = Glide.with(context);
//        requestManager.load(originalUrl)
//                .placeholder(placeHolder)
//                .crossFade()
//                .listener(new RequestListener<String, GlideDrawable>() {
//                    @Override
//                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
//                        Log.d(TAG, "Glide failed loading image " + originalUrl);
//                        requestManager.load(alternateUrl).placeholder(placeHolder).crossFade().into(imageView);
//                        return true;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
//                        imageView.setImageDrawable(resource);
//                        return false;
//                    }
//                })
//                .into(imageView);
//    }

    public static boolean isReadStorageAllowed(Activity activity) {
        //Getting the permission status
        int result = ContextCompat.checkSelfPermission(activity, Manifest.permission.READ_EXTERNAL_STORAGE);

        //If permission is granted returning true
        if (result == PackageManager.PERMISSION_GRANTED)
            return true;

        //If permission is not granted returning false
        return false;
    }

    //Requesting permission
    public static void requestStoragePermission(Activity activity) {

        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, Manifest.permission.READ_EXTERNAL_STORAGE)) {
            //If the user has denied the permission previously your code will come to this block
            //Here you can explain why you need this permission
            //Explain here why you need this permission
        }

        //And finally ask for the permission
        ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
    }

    public static boolean isStoragePermissionGranted(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity.checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE)
                    == PackageManager.PERMISSION_GRANTED) {
                Log.v(TAG, "Permission is granted");
                return true;
            } else {

                Log.v(TAG, "Permission is revoked");
                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            Log.v(TAG, "Permission is granted");
            return true;
        }

    }

    public static void hideKeyboard(Activity context) {
        final InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(context.getWindow().getDecorView()
                .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

    }

    public static String getCountryCode(Activity context) {
        TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
        String countryCode = manager.getSimCountryIso().toUpperCase();
        if (StringUtils.isEmpty(countryCode)) {
            countryCode = "GB";
        }
        return countryCode;
    }

    //mobile number validation
    public static boolean isMobileNumberValid(Activity context, String phone) {
        boolean isValid = false;
        String expressionMobile = "^[0-9]{10}$";
        Pattern patternMobile = Pattern.compile(expressionMobile, Pattern.CASE_INSENSITIVE);
        Matcher matcherMobile = patternMobile.matcher(phone);
        if (matcherMobile.matches()) {
            isValid = true;
        } else {
           // Utils.makeAlert(context, context.getString(R.string.error_mobile));
            return isValid;

        }

        return isValid;
    }

    //    email validation
    public static boolean isEmailValid(Activity context, String email) {
        boolean isValid = false;
        String expression = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        CharSequence inputStr = email;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        } else {
            //Utils.makeAlert(context, context.getString(R.string.error_email));
            return isValid;

        }

        return isValid;
    }

    //password validation
    public boolean isValid(String password) {
        if (password.length() < 8) {
            return false;
        }
        Character c = null;
        for (int i = 0; i < password.length() - 1; i++) {
            c = password.charAt(i);
        }
        if (Character.isLetterOrDigit(c)) {
            return false;
        } else if (Character.isDigit(c)) {
            return false;
        } else {
            return true;
        }
    }

    //signup screen validation
// Email Validation
    public static boolean isEmailMobileValid(Activity context, String email) {
        boolean isValid = false;
        String expressionMobile = "^[0-9]{10}$";
        String expression = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        CharSequence inputStr = email;
        Pattern patternMobile = Pattern.compile(expressionMobile, Pattern.CASE_INSENSITIVE);
        Matcher matcherMobile = patternMobile.matcher(inputStr);

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        } else if (matcherMobile.matches()) {
            isValid = true;
        } else {
           // Utils.makeAlert(context, context.getString(R.string.email_error_snack));
            return isValid;

        }

        return isValid;
    }


    // Password Validation
    public static boolean isPasswordValid(Activity context, String password) {
        boolean isValid = false;

        String expression = "^(?=.*\\d)(?=.*[a-zA-Z])(?=.*?[#?!@$%^&*-])[0-9a-zA-Z#?!@$%^&*-]{8,}$";
        CharSequence inputStr = password;
        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;

        } else {
            // System.out.println("Address is Invalid");
            //Utils.makeAlert(context, context.getString(R.string.password_error_vaildation));
            return isValid;

        }

        return isValid;
    }

    // alert dialog for web api class
    public static void alert(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();

    }

}
