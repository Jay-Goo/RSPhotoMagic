package jaygoo.com.rspm.library;


import android.support.v8.renderscript.RSRuntimeException;

/**
 * ================================================
 * 作    者：JayGoo
 * 版    本：
 * 创建日期：2017/3/23
 * 描    述: 图片处理异常捕获器
 * ================================================
 */
public class ProcessorException extends RSRuntimeException {

    private static final String DEFAULT_MESSAGE = "Unknown exception happens to processor";
    public static final String NOT_INITIALIZED = "The processor is not properly initialized";
    public static final String UNKNOWN_PROCESSOR_TYPE = "Cannot resolve processot type";
    public static final String RUNTIME_EXCEPTION = "Processor exception in runtime";
    
    public ProcessorException() {
	super(DEFAULT_MESSAGE);
    }
    
    public ProcessorException(String message) {
	super(message);
    }
}
