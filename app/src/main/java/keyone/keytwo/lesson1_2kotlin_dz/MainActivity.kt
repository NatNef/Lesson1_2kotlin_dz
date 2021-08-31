package keyone.keytwo.lesson1_2kotlin_dz;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import keyone.keytwo.zametki.R;
import keyone.keytwo.zametki.ZametkiFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        ZametkiFragment zametkiFragment = ZametkiFragment.newInstance();

        // получаем фрагмент-менедер(жанглер)
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.zametki_container, ZametkiFragment.newInstance())
                .commit();

        // описание применяем в ландшафтной ориентации
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.opisanie_zametki_container, OpisanieFragment.newInstance(new Menu(0, "test")))
                    .commit();
        }
    }

}