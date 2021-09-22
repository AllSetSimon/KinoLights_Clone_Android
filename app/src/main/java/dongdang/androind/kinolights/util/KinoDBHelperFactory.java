package dongdang.androind.kinolights.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import dongdang.androind.kinolights.util.KinoDBHelper;

public class KinoDBHelperFactory {
    private static KinoDBHelper kinoDBHelper;
    public KinoDBHelperFactory(Context context) {
        kinoDBHelper = new KinoDBHelper(context);
    }

    public static KinoDBHelper getKinoDBHelper() {
        return kinoDBHelper;
    }
}
