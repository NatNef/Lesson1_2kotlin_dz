package keyone.keytwo.lesson1_2kotlin_dz

import android.content.res.Configuration
import android.os.Bundle
import android.view.View
import android.widget.Button
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

    // поле для статичесского метода
    companion object Reserv {
        val name = "name1"
        val surname = "surname1"

    }

    class Test(var name1: String, var name2: String = "") {
        fun copy() {
        }
    }

    // Создать Object. KotlinSingleton
    //В Object вызвать copy и вывести значения скопированного класса на экран.
    val objTest = Test("name", "name2")
    val objTest2 = objTest.copy();


    //    // кнопка
    val button = findViewById<Button>(R.id.button_p)
    button.setOnClickListener(
    private object : View.OnClickListener {
        override fun onClick(v: View?) {
            TODO("Not yet implemented")
        }
    })

    //цилы
    val daysOfWeek = listOf("Sunday", "Monday", "Tuesday") {
        for (day in daysOfWeek) {
            Log.d("mylogs", "$day")
        }

        //перечисляет
        repeat(daysOfWeek.size) {
            Log.d("mylogs", "${daysOfWeek[it]}")
            if (i > 2) break
        }
        //ничего
        fun test(): Nothing Int{
        while (true) {
        }

    }



