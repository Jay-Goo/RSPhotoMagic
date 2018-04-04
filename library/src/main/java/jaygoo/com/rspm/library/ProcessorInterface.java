package jaygoo.com.rspm.library;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v8.renderscript.RSRuntimeException;
import android.support.v8.renderscript.RenderScript;


public class ProcessorInterface {

	private static ProcessorInterface processor = null;
	private RenderScript mRS;

	//  use singleton pattern to ensure there is only one processor
	private ProcessorInterface(Context context) {
		mRS = RenderScript.create(context);
	}

	public static ProcessorInterface getProcessor(Context context) {
		if (processor == null) processor = new ProcessorInterface(context);
		return processor;
	}

	public Bitmap process(int processorType, Bitmap input) throws ProcessorException {
		if (mRS == null) throw new ProcessorException(ProcessorException.NOT_INITIALIZED);
		Bitmap output = null;
		SuperProcessor processor;
		switch (processorType) {
			case RSPhotoMagicType.BINARIZE:
				processor = new BinarizeProcessor(mRS);
				break;
			case RSPhotoMagicType.SOBEL:
				processor = new SobelProcessor(mRS);
				break;
			case RSPhotoMagicType.GRAY:
				processor = new GrayProcessor(mRS);
				break;
			case RSPhotoMagicType.GRAY_SOBEL:
				processor = new GraySobelProcessor(mRS);
				break;
			case RSPhotoMagicType.BLUR:
				processor = new BlurProcessor(mRS);
				break;
			default:
				throw new ProcessorException(ProcessorException.UNKNOWN_PROCESSOR_TYPE);
		}

		try {
			output = processor.process(input);
		} catch (NullPointerException | RSRuntimeException e) {
			e.printStackTrace();
			throw new ProcessorException(ProcessorException.RUNTIME_EXCEPTION);
		}

		return output;
	}

	public void release() {
		if (mRS != null) {
			mRS.destroy();
		}
	}

}
