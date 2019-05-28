package com.riel.kajurapps;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            TextView displayName = findViewById(R.id.profileName);
            TextView displayEmail = findViewById(R.id.profileEmail);
            ImageView profileImage = findViewById(R.id.imageView);
            if (user != null) {
                displayName.setText(user.getDisplayName());
                displayEmail.setText(user.getEmail());
                // Loading profile image
                Uri profilePicUrl = user.getPhotoUrl();
                if (profilePicUrl != null) {
                    Glide.with(this).load(profilePicUrl)
                            .into(profileImage);
                }
            }
        } else {
            // No user is signed in
        }

    }

}
