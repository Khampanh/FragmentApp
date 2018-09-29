package la.edu.homsombathnuol.k.fragmentapp;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         BottomNavigationView bottomNav = findViewById(R.id.nav_bottom);
         bottomNav.setOnNavigationItemSelectedListener(navigationItemSelected);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.fragment_container, new HomeFragment()).commit();

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navigationItemSelected =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                    Fragment fragmentSelected = null;
                    switch (item.getItemId()){
                        case R.id.nav_home:
                            fragmentSelected = new HomeFragment();
                            break;
                        case R.id.nav_favorite:
                            fragmentSelected = new FavoriteFragment();
                            break;
                        case R.id.nav_search:
                            fragmentSelected = new SearchFragment();
                            break;
                    }

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.fragment_container, fragmentSelected)
                            .commit();
                    return true;
                }
            };
}
