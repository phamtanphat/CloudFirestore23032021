package com.example.cloudfirestore23032021;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1 Gửi dạng map String
        // Khoa hoc
//            - android
//                    - ten : Lap trinh android
//            - ios
//                    - ten : Lap trinh ios
        Map<String,String> mapCourse = new HashMap<>();
        mapCourse.put("ten", "Lập trình android");

        db.collection("khoahoc")
                .document("android")
                .set(mapCourse)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        // 2 Gui dang mang
//        Map<String , List<String>> mapNames = new HashMap<>();
//        mapNames.put("arrays", new ArrayList<>(Arrays.asList("Tèo" , "Tí" , "Tủn" , "Hoa")));
//
//        db.collection("mangten")
//                .document("array")
//                .set(mapNames)
//                .addOnCompleteListener(new OnCompleteListener<Void>() {
//                    @Override
//                    public void onComplete(@NonNull Task<Void> task) {
//                        if (task.isSuccessful()){
//                            Toast.makeText(MainActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
//                        }else{
//                            Toast.makeText(MainActivity.this, "Thất bại", Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                });
    }
}