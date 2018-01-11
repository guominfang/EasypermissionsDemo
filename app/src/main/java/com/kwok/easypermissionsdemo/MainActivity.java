package com.kwok.easypermissionsdemo;

import android.Manifest;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.List;

import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity implements EasyPermissions.PermissionCallbacks {

    public static final int RC_PERMISSIONS_CODE = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void onRequest(View view) {
        String[] perms = new String[]{
                Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE
        };
        if (EasyPermissions.hasPermissions(this, perms)) {
            Toast.makeText(this, "Contain Permission", Toast.LENGTH_SHORT).show();
        } else {
            EasyPermissions.requestPermissions(this, " request again", RC_PERMISSIONS_CODE, perms);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
    }

    @Override
    public void onPermissionsGranted(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "Granted Permission", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPermissionsDenied(int requestCode, @NonNull List<String> perms) {
        Toast.makeText(this, "Granted Permission", Toast.LENGTH_SHORT).show();
    }
}
