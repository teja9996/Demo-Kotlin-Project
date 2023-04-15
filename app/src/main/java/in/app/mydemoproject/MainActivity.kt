package `in`.app.mydemoproject

import `in`.app.mydemoproject.RoomDataBase.MainScreen.MainFragment
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentManager
import com.google.android.material.floatingactionbutton.FloatingActionButton

/*class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}*/


class MainActivity : AppCompatActivity() {

    private val fragmentManager: FragmentManager = supportFragmentManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Find the FloatingActionButton by its ID
        val fabAdd = findViewById<FloatingActionButton>(R.id.fabAdd)
        val fragment = MainFragment()
        fragmentManager.beginTransaction()

            .replace(R.id.container, fragment)
            .addToBackStack(null)
            .commit()

        // on below line we are initializing our adapter class.

        // Set click listener for FloatingActionButton
        fabAdd.setOnClickListener {
            // Create and show the PersonalInfoFragment

            val fragment = PersonalInfoFragment()
            fragmentManager.beginTransaction()

                .replace(R.id.container, fragment)
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onBackPressed() {
        // Check if there are any fragments in the back stack
        /* if (fragmentManager.backStackEntryCount > 0) {
             // Pop the top fragment from the back stack
             fragmentManager.popBackStack()
         } else {
             // If no fragments in back stack, perform default back button behavior
             super.onBackPressed()
         }*/
        finish()
    }


}

