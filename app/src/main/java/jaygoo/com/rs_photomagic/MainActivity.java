package jaygoo.com.rs_photomagic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import jaygoo.com.rspm.library.RSPhotoMagic;
import jaygoo.com.rspm.library.RSPhotoMagicType;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView iv1 = findViewById(R.id.iv);
        ImageView iv2 = findViewById(R.id.iv2);
        iv1.setImageResource(R.mipmap.ic_launcher);
        iv2.setImageBitmap(RSPhotoMagic.get(this).execute(RSPhotoMagicType.BLUR,R.mipmap.ic_launcher));
    }
}
