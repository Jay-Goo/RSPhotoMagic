package jaygoo.com.rspm.library;

import android.graphics.Bitmap;
import android.support.v8.renderscript.Allocation;
import android.support.v8.renderscript.RenderScript;
import android.util.Log;

import jaygoo.com.sobelbyrsdemo.ScriptC_grayscale;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：1.1.0
 * 创建日期：2017/3/23
 * 描    述: 图片灰度化处理
 * ================================================
 */
public class GrayProcessor extends SuperProcessor {

	public GrayProcessor(RenderScript renderscript) {
		super(renderscript);
	}

	@Override
	public Bitmap process(Bitmap input) {
		if (input == null)return null;

		long time = System.currentTimeMillis();

		Bitmap output = Bitmap.createBitmap(input.getWidth(), input.getHeight(), input.getConfig());
		Allocation inputAllocation = Allocation.createFromBitmap(mRenderScript, input);
		Allocation outputAllocation = Allocation.createFromBitmap(mRenderScript, output);
		ScriptC_grayscale mGrayScaleScript = new ScriptC_grayscale(mRenderScript);
		mGrayScaleScript.forEach_root(inputAllocation, outputAllocation);
		outputAllocation.copyTo(output);

		Log.d("HandleTime", "Gray(ms): "+ (System.currentTimeMillis() - time));

		return output;
	}


}
