package marvelousboomerangmoose.shoppingwithfriends;


import 	android.widget.EditText;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;

import marvelousboomerangmoose.shoppingwithfriends.Model.UserActivity;

/**
 * The add friend screen where a user can input information relevant to adding a new friend and
 * then add that person.
 */
public class AddFriendActivity extends ActionBarActivity {
<<<<<<< HEAD
    //public final static String MESSAGE = "marvelousboomerangmoose.shoppingwithfriends.MESSAGE";
    private final Context context = this;

=======
>>>>>>> origin/master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_friend);
    }

    /**
     * Cancels add friend function; sends user back to home activity
     * @param v - button that is clicked
     */
    public void addFriendCancelOnClick(View v) {
        //Does nothing but to eliminate a analyzing error
        v.getId();
        startActivity(new Intent(this, HomeActivity.class));
    }

<<<<<<< HEAD


=======
>>>>>>> origin/master
    /**
     * Adds a friend when the button is clicked if  all checks pass.
     * @param v the button being clicked
     */
    public void addFriendButtonOnClick(View v){
<<<<<<< HEAD
        //Does nothing but to eliminate a analyzing error
        v.getId();
=======
        final Context context = this;
>>>>>>> origin/master
        final String first = ((EditText)findViewById(R.id.friendFirst)).getText().toString();
        final String last = ((EditText)findViewById(R.id.friendLast)).getText().toString();
        final String email = ((EditText)findViewById(R.id.friendEmail)).getText().toString();

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        if(first.matches("")||last.matches("")||email.matches("")){
            String errorMessage = "";
            if (first.matches("")){
                errorMessage += "Your friend must have a first name\n";
            }
            if (last.matches("")){
                errorMessage += "Your friend must have a last name\n";
            }
            if (email.matches("")){
                errorMessage += "Your friend must have an email";
            }

            // set title
            alertDialogBuilder.setTitle("Invalid Input");

            // set dialog message
            alertDialogBuilder
                    .setMessage(errorMessage)
                    .setCancelable(false)
                    .setNegativeButton("OK",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            // if this button is clicked, just close
                            // the dialog box and do nothing
                            dialog.cancel();
                        }
                    });

            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();

            // show it
            alertDialog.show();
        } else {
            alertDialogBuilder.setTitle("");

            //TODO: add error creating method
            if (UserActivity.loggedInUser.getEmail().equals(email)) {
                //added self
                // set dialog message
                alertDialogBuilder
                    .setMessage("Sorry if you don't have any, but you can't add yourself as a friend")
                    .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            } else if (UserActivity.loggedInUser.getFriendList().containsKey(email)) {
                //re-adding friend
                // set dialog message
                alertDialogBuilder
                    .setMessage("You've already added this friend")
                    .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                        }
                });
                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();
            } else {
                Boolean status = UserActivity.addFriend(first, last, email);

                if (status) {
                    // set dialog message
                    alertDialogBuilder
                            .setMessage("Successfully added a friend")
                            .setCancelable(false)
                            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    // if this button is clicked, close
                                    // current activity

                                    Intent intent = new Intent(context, CurrentFriendListActivity.class);
<<<<<<< HEAD
                                    //intent.putExtra(MESSAGE, first + " " + last + "\n" + email);
=======
>>>>>>> origin/master
                                    startActivity(intent);

                                }
                            });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                } else {
                    // set dialog message
                    alertDialogBuilder
                        .setMessage("Failed to add a friend")
                        .setCancelable(false).setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                            }
                    });
                    AlertDialog alertDialog = alertDialogBuilder.create();
                    alertDialog.show();
                }

            }
        }
    }
}
