package session7.i18n;

import java.util.Locale;

public class LocaleTest {
    public static void main(String[] args) {
        Locale[] availableLocales = Locale.getAvailableLocales();
        StringBuilder sb = new StringBuilder();
        for (Locale locale : availableLocales) {
            sb.append(locale.getDisplayCountry()).append("=").append(locale.getCountry()).append(" ");
            sb.append(locale.getDisplayLanguage()).append("=").append(locale.getLanguage());
            System.out.println(sb);
            sb.setLength(0);
        }
    }
}
