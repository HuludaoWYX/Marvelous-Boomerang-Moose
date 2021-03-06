package marvelousboomerangmoose.shoppingwithfriends;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ArrayAdapter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NewFriendListActivity extends ActionBarActivity {
    private Intent intent;
    private String message;
    private static ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            intent = getIntent();
            setContentView(R.layout.activity_new_friend_list);
            arrayList = new ArrayList<>();
            ListView myListView = (ListView) this.findViewById(R.id.listView);
            ArrayAdapter listAdapter = new ArrayAdapter<>(this,R.layout.simplerow, arrayList);
            HashMap<String, User> friends = MainActivity.loggedInUser.getFriendList();
            for (String key : friends.keySet()) {
                User friend = friends.get(key);
                listAdapter.add(friend.getFirst() + " " + friend.getLast() + "\n" + friend.getEmail());
            }
            myListView.setAdapter(listAdapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_friend_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addFriendButtonOnClick(View v){
        //Button button=(Button) v;
        startActivity(new Intent(this, AddFriendActivity.class));
    }
    public void homeButtonOnClick(View v){
        startActivity(new Intent(this, HomeActivity.class));

    }

}
