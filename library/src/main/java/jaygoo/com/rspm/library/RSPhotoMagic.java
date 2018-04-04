package jaygoo.com.rspm.library;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2018/4/4
 * 描    述:
 * ================================================
 */
public class RSPhotoMagic {

    private ProcessorInterface processor;
    private Context context;

    private RSPhotoMagic(){}

    private RSPhotoMagic(Context context){
        this.context = context;
        processor = ProcessorInterface.getProcessor(context);
    }

    public static RSPhotoMagic get(Context context){
        return new RSPhotoMagic(context);
    }

    public Bitmap execute(int type, Bitmap bitmap){
        return processor.process(type, bitmap);
    }

    public Bitmap execute(int type, int resId) {
        return processor.process(type, BitmapFactory.decodeResource(context.getResources(), resId));
    }
}
