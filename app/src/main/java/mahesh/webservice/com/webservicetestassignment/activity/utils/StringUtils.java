package mahesh.webservice.com.webservicetestassignment.activity.utils;

import android.text.Html;
import android.text.Spannable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;

/**
 * Created by Abhishesh.
 */
public class StringUtils {

    private static final String NULL_STRING = "null";
    private static final String TAG = StringUtils.class.getSimpleName();

    /**
     * Checks if is not empty.
     *
     * @param value the value
     * @return true, if is not empty
     */
    public static boolean isNotEmpty(String value) {
        return !isEmpty(value);
    }

    /**
     * Checks if is empty.
     *
     * @param value the value
     * @return true, if is empty
     */
    public static boolean isEmpty(String value) {
        return TextUtils.isEmpty(value) || NULL_STRING.equalsIgnoreCase(value);
    }

    public static boolean isEmailValid(String email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public static boolean isPasswordValid(String password) {
        return isNotEmpty(password) && password.length() >= IConstants.MAX_PASSWORD_LENGTH;
    }

    public static Spannable getNoUnderlineSpannableString(final String value) {
        Spannable spannable = (Spannable) Html.fromHtml(value);
        for (URLSpan u: spannable.getSpans(0, spannable.length(), URLSpan.class)) {
            spannable.setSpan(new UnderlineSpan() {
                public void updateDrawState(TextPaint tp) {
                    tp.setUnderlineText(false);
                }
            }, spannable.getSpanStart(u), spannable.getSpanEnd(u), 0);
        }
        return spannable;
    }
}
