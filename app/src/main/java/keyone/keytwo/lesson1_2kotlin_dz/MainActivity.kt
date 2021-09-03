package keyone.keytwo.lesson1_2kotlin_dz

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    protected override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


//        ZametkiFragment zametkiFragment = ZametkiFragment.newInstance();

        // получаем фрагмент-менедер(жанглер)
        getSupportFragmentManager()
            .beginTransaction()
            .replace(R.id.zametki_container, ZametkiFragment.newInstance())
            .commit()

        // описание применяем в ландшафтной ориентации
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            getSupportFragmentManager()
                .beginTransaction()
                .replace(
                    R.id.opisanie_zametki_container,
                    OpisanieFragment.newInstance(Menu(0, "test"))
                )
                .commit()
        }
    }
}