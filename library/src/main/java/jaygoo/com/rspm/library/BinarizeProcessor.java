package jaygoo.com.rspm.library;



import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;

import jaygoo.com.sobelbyrsdemo.ScriptC_binarize;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/3/23
 * 描    述: 图片二值化处理
 * ================================================
 */
public class BinarizeProcessor extends SuperProcessor {

    public BinarizeProcessor(RenderScript renderscript) {
    	super(renderscript);
    }

    @Override
    public Bitmap process(Bitmap input) throws RSRuntimeException {
    	Bitmap output = Bitmap.createBitmap(input.getWidth(), input.getHeight(), input.getConfig());
    	Allocation inputAllocation = Allocation.createFromBitmap(mRenderScript, input);
    	Allocation outputAllocation = Allocation.createFromBitmap(mRenderScript, output);
    	ScriptC_binarize mBinarizeScript = new ScriptC_binarize(mRenderScript);
    		
    	mBinarizeScript.forEach_root(inputAllocation, outputAllocation);
    	outputAllocation.copyTo(output);
		mBinarizeScript.destroy();
    	return output;
    }


}
