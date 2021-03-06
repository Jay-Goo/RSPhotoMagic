#pragma version(1)
#pragma rs java_package_name(jaygoo.com.sobelbyrsdemo)

#define MSG_TAG "SobelDetectingFromRenderScript"


rs_allocation gIn;
rs_allocation gOut;
rs_script gScript;

int *gOutPixels;
int count = 0;
int mImageWidth;
int mImageHeight;
int color = 0xFF0496FD;

void root(const int *v_in, int *v_out) {
	if (count != 0) return;
 	count++;


	for (int i = 0; i < mImageHeight; i++) {
		for (int j = 0; j < mImageWidth; j++) {
			int pix = v_in[i * mImageWidth + j];

			if (pix != 0) {
                gOutPixels[i * mImageWidth + j] = color;
            }
		}
	}


}


void init() {
	rsDebug("Called init", rsUptimeMillis());
}

void compute() {
	rsForEach(gScript, gIn, gOut);
}