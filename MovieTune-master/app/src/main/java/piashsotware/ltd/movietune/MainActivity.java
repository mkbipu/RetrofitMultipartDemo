package piashsotware.ltd.movietune;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import piashsotware.ltd.movietune.fragment.MainFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            FragmentManager fm = getFragmentManager();
    FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.activity_main, new MainFragment());
                ft.commit();
                }

@Override
public void onBackPressed() {
        super.onBackPressed();
        }
        }
