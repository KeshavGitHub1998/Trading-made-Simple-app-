package com.example.shubh.dummy;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.io.IOException;
import java.util.Objects;

public class hacksell extends AppCompatActivity {

    static int iid=0;
    Button bonline;
    EditText etit,epric,edes;
    private FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference myRef;
    String stit,sdesc;
    ImageView prod;

    String ipric,irat;
    private ProgressDialog progressDialog;
    private StorageReference storageReference;
    private FirebaseStorage firebaseStorage;
    private static int PICK_IMAGE = 123;
    Uri imagePath;
    String naam,fimg="vhbh";//Long fimg;
   // Uri abc;



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getData() != null){
            imagePath = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imagePath);
               prod.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallsell);



            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        progressDialog = new ProgressDialog(this);

        bonline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                myRef = firebaseDatabase.getReference().child("sellwall");

              


            }
        });











    }

    private void uploadImage(){


        final StorageReference imageReference = storageReference.child("sellwall").child( "abc"+System.currentTimeMillis());
        imageReference.putFile(imagePath).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {

                imageReference.getDownloadUrl().addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        fimg=task.getResult().toString();
                        Toast.makeText(wallsell.this,fimg,Toast.LENGTH_SHORT).show();
                        Product psell=new Product(iid,stit,sdesc,firebaseAuth.getUid(),ipric,fimg);
                        myRef.push().setValue(psell);

                    }
                });

            }
        });


         //User id/Images/Profile Pic.jpg
        UploadTask uploadTask = imageReference.putFile(imagePath);
     uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Toast.makeText(wallsell.this, "Upload failed!", Toast.LENGTH_SHORT).show();
            }
        }).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                String url= Objects.requireNonNull(task.getResult().toString());

                Toast.makeText(wallsell.this, url, Toast.LENGTH_SHORT).show();
                imageReference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                    @Override
                    public void onSuccess(Uri uri) {
                       // abc=uri;
                        //fimg=Long.parseLong(uri.toString());
                        fimg= imageReference.getDownloadUrl().getResult().toString();
                        Toast.makeText(wallsell.this,fimg,Toast.LENGTH_SHORT).show();

                    }
                });

            }
        });
    }
}
